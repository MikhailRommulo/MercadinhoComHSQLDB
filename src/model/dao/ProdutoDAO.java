package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import model.Produto;
import model.connection.ConnectionFactory;

public class ProdutoDAO {
	private static Connection connection;
	PreparedStatement stmt;
	
	public ProdutoDAO(){
		try {
			connection = ConnectionFactory.conectar();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public Produto buscarProduto(String codigo) {
		String sql = "select * from produtos where codigo =" + "'" +codigo+"'" ;
		Produto p = new Produto();
		try {
			stmt = ProdutoDAO.connection.prepareStatement(sql);
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
