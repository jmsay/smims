package model;

import java.sql.*;

public class LoginModel extends SuperModel {

	String first_name;
	String last_name;
	String office;
	String position;
	int empID;
	
	public LoginModel()
	{
		super();
		try {
			Class.forName(driver).newInstance();
		} catch( Exception e ) {
			e.printStackTrace();
		}
	}
	
	public boolean checkCredentials( String user, String pass )
	{
		boolean result=false;
		int emp_id = 0;
		try {
			conn = DriverManager.getConnection(url+dbName,userName,password);
			
			stmt = conn.createStatement();
			
			String sql;
			sql = "SELECT * FROM users WHERE username=\"" + user + "\" AND password=\"" + pass + "\"";
			rs = stmt.executeQuery(sql);
			
			int count = 0;
			while(rs.next())
			{
				emp_id = rs.getInt("emp_id");
				count++;
			}
			if( count > 0 ) {
				result = true;
				sql = "SELECT first_name, last_name FROM personnel WHERE id=" + emp_id;
				rs = stmt.executeQuery(sql);
				
				while(rs.next())
				{
					setFirst_name(rs.getString("first_name"));
					setLast_name(rs.getString("last_name"));
					break;
				}
				sql = "SELECT office_emp_id, name, position FROM office_personnel JOIN office ON office_id=id WHERE emp_id=" + emp_id;
				
				rs = stmt.executeQuery(sql);
				
				while(rs.next())
				{
					setOffice( rs.getString("name") );
					setPosition( rs.getString("position") );
					setEmpID( rs.getInt("office_emp_id") );
					sql = "INSERT INTO transaction_log(office_emp_id, action, date_time_stamp) VALUES (" + getEmpID() + ", \"logged in\", NOW())";
					stmt.executeUpdate(sql);
					break;
				}
			}
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
	
	public boolean logoutUser()
	{
		boolean result=false;
		try {
			conn = DriverManager.getConnection(url+dbName,userName,password);
			
			stmt = conn.createStatement();
			
			String sql;
			sql = "SELECT * FROM office_personnel WHERE office_emp_id=" + getEmpID() + "";
			rs = stmt.executeQuery(sql);
			
			int count = 0;
			while(rs.next())
			{
				count++;
			}
			if( count > 0 ) {
				result = true;
				sql = "INSERT INTO transaction_log(office_emp_id, action, date_time_stamp) VALUES (" + getEmpID() + ", \"logged out\", NOW())";
				stmt.executeUpdate(sql);
				setEmpID( 0 );
			}
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
	
	public String getFirst_name() {
		return first_name;
	}
	
	public void setFirst_name( String first_name ) {
		this.first_name = first_name;
	}
	
	public String getLast_name() {
		return last_name;
	}
	
	public void setLast_name( String last_name ) {
		this.last_name = last_name;
	}
	
	public String getOffice() {
		return office;
	}
	
	public void setOffice( String office ) {
		this.office = office;
	}
	
	public String getPosition() {
		return position;
	}
	
	public void setPosition( String position ) {
		this.position = position;
	}

	public int getEmpID() {
		return empID;
	}

	public void setEmpID(int empID) {
		this.empID = empID;
	}
}
