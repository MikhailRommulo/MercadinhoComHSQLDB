package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import model.Produto;
import model.connection.ConnectionFactory;

public class ProdutoDAO {
	
	PreparedStatement stmt;
	
	public void create(Produto p) throws SQLException {
		
		Connection connection = ConnectionFactory.conectar();
		String sql = "INSERT INTO produtos (codigo,descricao,marca,setor,fornecedor,preco,validade) VALUES(?,?,?,?,?,?,?)" ;
		
		try {
			stmt = connection.prepareStatement(sql);
			stmt.setString(1, p.getCodigo());
			stmt.setString(2, p.getDescricao());
			stmt.setString(3, p.getMarca());
			stmt.setString(4, p.getSetor());
			stmt.setString(5, p.getFornecedor());
			stmt.setDouble(6, p.getPreco());
		
			LocalDateTime validade = p.getValidade();
			Timestamp data = Timestamp.valueOf(validade);
			stmt.setTimestamp(7, data);
		
			stmt.executeUpdate();
		}catch(SQLException ex) {
			System.out.println(ex);
		}finally{
			ConnectionFactory.fechar();
		}
		
	}
	
	public Produto buscarProduto(String codigo) throws SQLException {
		
		Connection connection = ConnectionFactory.conectar();
		String sql = "select * from produtos where codigo =" + "'" +codigo+"'" ;
		Produto p = new Produto();
		try {
			stmt = connection.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			rs.next();
			p.setCodigo(rs.getString("CODIGO"));
			p.setDescricao(rs.getString("DESCRICAO"));
			p.setMarca(rs.getString("MARCA"));
			p.setSetor(rs.getString("SETOR"));
			p.setFornecedor(rs.getString("FORNECEDOR"));
			p.setPreco(rs.getDouble("PRECO"));
			//Convertendo timestamp para LocalDateTime
			Timestamp validade = rs.getTimestamp("VALIDADE");			
			p.setValidade(validade.toLocalDateTime());			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			ConnectionFactory.fechar();
		}
		return p;
	}
	
}
