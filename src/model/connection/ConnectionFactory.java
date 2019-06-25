package model.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
	private static final String DRIVER_CLASS = "org.hsqldb.jdbcDriver";
	private static Connection cnx = null;
	private static String usuario = "adm";
	private static String senha = "adm";
	private static String PathBase = "db//Mercadinho";
	private static final String URL = "jdbc:hsqldb:file:" + PathBase + ";ifexists=true;hsqldb.write_delay=false;shutdown=true;";
	
	public static Connection conectar() throws SQLException {
		if(cnx == null) {
			try {
				Class.forName(DRIVER_CLASS);
				//estabelecendo conexão
				cnx = DriverManager.getConnection(URL, usuario, senha);
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return cnx;
	}
	
	public static void fechar() {
		try {
			cnx.close();
			cnx = null;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
