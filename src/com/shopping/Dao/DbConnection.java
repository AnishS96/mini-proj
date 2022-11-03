package com.shopping.Dao;
import com.shopping.*;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Properties;

public class DbConnection {
	public void dbConnection(GroceryListData d){
		String str=d.getCart().toString();
		try {
			Properties prop=new Properties();
			FileInputStream file=new FileInputStream("D:\\Eclipse\\eclipse\\com.oct\\src\\com\\shopping\\Dao\\DbValue.properties");
			prop.load(file);
			 
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			Connection con= DriverManager.getConnection(prop.getProperty("Dburl"),prop.getProperty("Dbusername"),prop.getProperty("Dbpassword"));
			PreparedStatement stmt= con.prepareStatement("insert into ANISH_ONLINESHOPPING values(?,?,?,?)");
			stmt.setString(1,  d.getUserName());
			stmt.setLong(2,  d.getPassword());
			stmt.setString(3,  str);
			stmt.setInt(4, d.getAmount());
			System.out.println();
			int st=stmt.executeUpdate();
			System.out.println(st);	
			}
		catch(Exception e) {
			e.printStackTrace();
		}
	}

}
