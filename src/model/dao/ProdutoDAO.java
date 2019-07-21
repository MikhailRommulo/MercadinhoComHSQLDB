package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;

import model.ItemEstoque;
import model.Produto;
import model.connection.ConnectionFactory;

public class ProdutoDAO {
	
	PreparedStatement stmt;
	
	public void create(Produto p) throws SQLException {
		
		Connection connection = ConnectionFactory.conectar();
		String sql = "INSERT INTO produtos (codigo,descricao,marca,setor,preco) VALUES(?,?,?,?,?)" ;
		
		try {
			stmt = connection.prepareStatement(sql);
			stmt.setString(1, p.getCodigo());
			stmt.setString(2, p.getDescricao());
			stmt.setString(3, p.getMarca());
			stmt.setString(4, p.getSetor());
			stmt.setDouble(5, p.getPreco());
		
			stmt.executeUpdate();
		}catch(SQLException ex) {
			System.out.println(ex);
		}finally{
			ConnectionFactory.fechar();
			ItemEstoque ie = new ItemEstoque();
			ie.setProduto(p);
			ItensEstoqueDAO ied = new ItensEstoqueDAO();
			try {
				ied.create(ie);
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}
		
	}
	
	public ArrayList<Produto> read(String pesquisa, String opcao) throws SQLException{
		String sql = "";
		switch(opcao) {
			case "Descrição":
				sql="SELECT * FROM produtos WHERE descricao LIKE ?";
				break;
			case "Código":
				sql="SELECT * FROM produtos WHERE codigo LIKE ?";
				break;
			case "Marca":
				sql="SELECT * FROM produtos WHERE marca LIKE ?";
				break;
			case "Setor":
				sql="SELECT * FROM produtos WHERE setor LIKE ?";
				break;
		}
		Connection connection = ConnectionFactory.conectar();
		
		
		ArrayList<Produto> produtos = new ArrayList<>();
		
		try {
			stmt = connection.prepareStatement(sql);
			stmt.setString(1, "%"+pesquisa+"%");
			ResultSet rs = stmt.executeQuery();			
			
			while(rs.next()) {
				Produto p = new Produto();
				
				p.setCodigo(rs.getString("CODIGO"));
				p.setDescricao(rs.getString("DESCRICAO"));
				p.setMarca(rs.getString("MARCA"));
				p.setSetor(rs.getString("SETOR"));
				p.setPreco(rs.getDouble("PRECO"));
				
				produtos.add(p);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			ConnectionFactory.fechar();
		}
		return produtos;
	}
	
	public void update(Produto p) throws SQLException {
		
			Connection connection = ConnectionFactory.conectar();
			String sql = "UPDATE produtos SET descricao = ?, marca = ?, setor = ?, preco = ? WHERE codigo = ?";
			
		try {
			stmt = connection.prepareStatement(sql);
			
			stmt.setString(1, p.getDescricao());
			stmt.setString(2, p.getMarca());
			stmt.setString(3, p.getSetor());
			stmt.setDouble(4, p.getPreco());
			
			stmt.setString(5, p.getCodigo());
			
			stmt.executeUpdate();
			
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			ConnectionFactory.fechar();
		}
	}
	
	public void delete(Produto p) throws SQLException {
		
		Connection connection = ConnectionFactory.conectar();
		String sql = "DELETE FROM produtos WHERE codigo = ?";
		
		try {
			stmt = connection.prepareStatement(sql);
			stmt.setString(1, p.getCodigo());
			
			stmt.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			ConnectionFactory.fechar();
		}
		
	}
	
	
	public Produto buscarProduto(String codigo) throws SQLException {
		
		Connection connection = ConnectionFactory.conectar();
		String sql = "select * from produtos where codigo = ?" ;
		Produto p = new Produto();
		try {
			stmt = connection.prepareStatement(sql);
			stmt.setString(1, codigo);
			ResultSet rs = stmt.executeQuery();
			rs.next();
			p.setCodigo(rs.getString("CODIGO"));
			p.setDescricao(rs.getString("DESCRICAO"));
			p.setMarca(rs.getString("MARCA"));
			p.setSetor(rs.getString("SETOR"));
			p.setPreco(rs.getDouble("PRECO"));			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			ConnectionFactory.fechar();
		}
		return p;
	}
	
}
