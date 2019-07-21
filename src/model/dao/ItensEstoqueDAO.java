package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.ItemEstoque;
import model.Produto;
import model.connection.ConnectionFactory;

public class ItensEstoqueDAO {
	
	PreparedStatement stmt;
	
	public void create(ItemEstoque ie) throws SQLException {
		
		Connection connection = ConnectionFactory.conectar();
		
		String sql = "INSERT INTO itemfornecedor (fornecedor,produto,quantidade,validade) VALUES('43.298.811/0003-11',?,0,'2019-07-20')";
		
		try {
			stmt = connection.prepareStatement(sql);
			stmt.setString(1, ie.getProduto().getCodigo());
			
			stmt.executeUpdate();
		}catch(SQLException e) {
			System.out.println(e);
		}finally{
			ConnectionFactory.fechar();
		}
	}
	
	public ArrayList<ItemEstoque> read(String pesquisa, String opcao) throws SQLException{
		Connection connection = ConnectionFactory.conectar();
		String sql = "";
		switch(opcao) {
			case "Descrição":
				sql = "SELECT * FROM produtos AS p JOIN itemfornecedor AS ie ON p.codigo = ie.produto WHERE p.descricao LIKE ?";
				break;
			case "Código":
				sql = "SELECT * FROM produtos AS p JOIN itemfornecedor AS ie ON p.codigo = ie.produto WHERE p.codigo LIKE ?";
				break;
			case "Marca":
				sql = "SELECT * FROM produtos AS p JOIN itemfornecedor AS ie ON p.codigo = ie.produto WHERE p.marca LIKE ?";
			case "Setor":
				sql = "SELECT * FROM produtos AS p JOIN itemfornecedor AS ie ON p.codigo = ie.produto WHERE p.setor LIKE ?";
		}
		
		
		ArrayList<ItemEstoque> listaDeItensEstoque = new ArrayList<>();
		try {
			stmt = connection.prepareStatement(sql);
			stmt.setString(1, '%'+pesquisa+'%');
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next()) {
				Produto p = new Produto();
				
				p.setCodigo(rs.getString("PRODUTOS.CODIGO"));
				p.setDescricao(rs.getString("PRODUTOS.DESCRICAO"));
				p.setMarca(rs.getString("PRODUTOS.MARCA"));
				p.setSetor(rs.getString("PRODUTOS.SETOR"));
				p.setPreco(rs.getDouble("PRODUTOS.PRECO"));
				
				ItemEstoque ie = new ItemEstoque();
				
				ie.setProduto(p);
				ie.setQuantidade(rs.getInt("ITEMFORNECEDOR.QUANTIDADE"));
				
				listaDeItensEstoque.add(ie);
			}
		}catch(SQLException e) {
			System.out.println(e);
		}finally {
			ConnectionFactory.fechar();
		}
		return listaDeItensEstoque;
	}
	
	public void update(ItemEstoque ie) throws SQLException {
		
		Connection connection = ConnectionFactory.conectar();
		
		String sql = "UPDATE itemfornecedor SET fornecedor = '43.298.811/0003-11', produto = ?, quantidade = ?, validade = '2019-07-20' WHERE produto = ?";
		
		try {
			stmt = connection.prepareStatement(sql);
			
			stmt.setString(1, ie.getProduto().getCodigo());
			stmt.setInt(2, ie.getQuantidade());
			stmt.setString(3, ie.getProduto().getCodigo());
			
			stmt.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			ConnectionFactory.fechar();
		}
	}
	
	public void delete(ItemEstoque ie) throws SQLException {
		
		Connection connection = ConnectionFactory.conectar();
		
		String sql = "DELETE FROM itemfornecedor WHERE produto = ?";
		
		try {
			stmt = connection.prepareStatement(sql);
			stmt.setString(1, ie.getProduto().getCodigo());
			
			stmt.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			ConnectionFactory.fechar();
			ProdutoDAO pd = new ProdutoDAO();
			try {
				pd.delete(ie.getProduto());				
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}
		
	}
}
