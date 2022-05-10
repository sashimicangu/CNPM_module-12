package dao;

import java.sql.Connection;
import java.sql.DriverManager;

public class DAO {
	public static Connection con;
	
	public DAO() {
		final String dbUrl = "jdbc:mysql://localhost:3306/cnpm_module12?autoReconnect=true&useSSL=false";
		final String dbClass = "com.mysql.cj.jdbc.Driver";
		
		try {
			Class.forName(dbClass);
			con = DriverManager.getConnection(dbUrl, "root", "");
		} catch (Exception e) {
			e.printStackTrace();
		}
	};
}
