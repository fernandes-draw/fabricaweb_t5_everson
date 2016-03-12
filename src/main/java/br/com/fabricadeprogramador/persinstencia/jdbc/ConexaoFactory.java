package br.com.fabricadeprogramador.persinstencia.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoFactory {

	public static Connection getConection() {
		
		try {
			return DriverManager.getConnection("jdbc:mysql://localhost:3306/fabricaweb", "root", "162916" );
		} catch (SQLException e) {
			//Relanšando a exception.
			throw new RuntimeException(e);
		}
	}

}
