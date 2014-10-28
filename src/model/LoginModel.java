package model;

import java.sql.*;

public class LoginModel {
	
	String url = "jdbc:mysql://localhost:3306/";
	String dbName = "supply_db";
	String driver = "com.mysql.jdbc.Driver";
	String userName = "root"; 
	String password = "";//Setup the Connection and Statement object variables
	Connection conn = null; 
	Statement stmt  = null; 
	ResultSet rs = null;
	
	public LoginModel()
	{
		try {
			Class.forName(driver).newInstance();
		} catch( Exception e ) {
			e.printStackTrace();
		}
	}
	
	public boolean checkCredentials( String user, String pass )
	{
		boolean result=false;
		try {
			conn = DriverManager.getConnection(url+dbName,userName,password);
			
			stmt = conn.createStatement();
			
			String sql;
			sql = "SELECT * FROM users WHERE username=\"" + user + "\" AND password=\"" + pass + "\"";
			rs = stmt.executeQuery(sql);
			
			int count = 0;
			while(rs.next())
			{
				String name = rs.getString("username");
				String pass1 = rs.getString("password");
				int emp_id = rs.getInt("emp_id");
				
				System.out.println("--MODEL-- Name: " + name + " Password: " + pass1 + " Employee ID:" + emp_id);
				count++;
			}
			if( count > 0 )
				result = true;
			else
				result = false;
			rs.close();
			stmt.close();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	public static void main( String [] args )
	{
		new LoginModel();
	}
}
