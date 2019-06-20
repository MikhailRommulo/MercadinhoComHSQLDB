package Teste;

import java.sql.Connection;
import java.sql.SQLException;

import model.connection.ConnectionFactory;

public class conexao {

	public static void main(String[] args) {
		try {
			Connection cnx = ConnectionFactory.conectar();
			System.out.println("Conectou!");
			ConnectionFactory.fechar();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
