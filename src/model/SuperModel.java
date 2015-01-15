package model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class SuperModel {

	static String url = "jdbc:mysql://localhost:3306/";
	static String dbName = "supply_db";
	static String driver = "com.mysql.jdbc.Driver";
	static String userName = "root"; 
	static String password = "";//Setup the Connection and Statement object variables
	static Connection conn = null; 
	static Statement stmt  = null; 
	static ResultSet rs = null;
	private int empID;
	
	public SuperModel()
	{
		
	}

	public int getEmpID() {
		return empID;
	}

	public void setEmpID(int empID) {
		this.empID = empID;
	}
}
