package aleksandar.conex;

import java.beans.Statement;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Conexion {
	private ConfigDir config;
	public Conexion() throws IOException, ClassNotFoundException, SQLException{
		config = new ConfigDir();
//		System.out.println(config.getProperty("MYSQLJDBC.driver"));
		
		try {
			
			
			Class.forName(config.getProperty("MYSQLJDBC.driver"));  
			
			Connection con = DriverManager.getConnection(  
				config.getProperty("MYSQLJDBC.url"),
				config.getProperty("MYSQLJDBC.username"),
				config.getProperty("MYSQLJDBC.password")
			);  
			
			Statement stmt = (Statement) con.createStatement(); 
			ResultSet rs = ((java.sql.Statement) stmt).executeQuery("select * from user"); 
			
			while(rs.next())  
			System.out.println(rs.getInt(1)+"  "+rs.getString(2)+"  "+rs.getString(3));  
			
			
			con.close();  
			
			
		} catch (Exception e) {
			System.out.println(e);
		}

		
//		ConfigDir.getInstance();
//		config.getProperty("MYSQLJDBC.driver");
	}
}
