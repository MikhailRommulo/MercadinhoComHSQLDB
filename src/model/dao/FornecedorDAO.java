package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.Fornecedor;
import model.connection.ConnectionFactory;

public class FornecedorDAO {
	
	PreparedStatement stmt;
	
	public Fornecedor readUnique(String codigo, Connection connActive) throws SQLException {
		
		Connection connection = null;
		if(connActive.isClosed()) {
			connection = ConnectionFactory.conectar();
		}else {
			connection = connActive;
		}
		
		String sql = "SELECT * FROM fornecedores WHERE cnpj = ?";
		Fornecedor f = new Fornecedor();
		try {
			stmt = connection.prepareStatement(sql);
			stmt.setString(1, codigo);
			ResultSet rs = stmt.executeQuery();
			rs.next();
			f.setCNPJ(rs.getString("CNPJ"));
			f.setNomeFantasia(rs.getString("NOMEFANTASIA"));
			f.setRazaoSocial(rs.getString("RAZAOSOCIAL"));
			f.setIE(rs.getString("IE"));
			f.setEndereco(rs.getString("ENDERECO"));
			f.setBairro(rs.getString("BAIRRO"));
			f.setCidade(rs.getString("CIDADE"));
			f.setEstado(rs.getString("ESTADO"));
			f.setPais(rs.getString("PAIS"));
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		return f;
	}

}
