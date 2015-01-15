package model;

import java.sql.*;

import javax.swing.JOptionPane;

public class AddPersonnelModel extends SuperModel {
	
	public AddPersonnelModel()
	{
		super();
		try {
			Class.forName(driver).newInstance();
		} catch( Exception e ) {
			e.printStackTrace();
		}
	}
	
	public String[] getOffices()
	{
		String[] list = new String[0];
		try {
			conn = DriverManager.getConnection(url+dbName,userName,password);
			
			stmt = conn.createStatement();
			
			String sql;
			sql = "SELECT COUNT(*) AS num FROM office";
			rs = stmt.executeQuery(sql);
			
			while( rs.next() )
			{
				list = new String[rs.getInt("num")];
				break;
			}
			
			sql = "SELECT * FROM office";
			rs = stmt.executeQuery(sql);
			
			int count = 0;
			while(rs.next())
			{
				list[count] = rs.getString("name");
				count++;
			}
			rs.close();
			stmt.close();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	
	public void addToDatabase( int empID, String first_name, String last_name, String office, String position )
	{
		int result, emp_id=0, office_id=0;
		try {
			conn = DriverManager.getConnection(url+dbName,userName,password);
			
			stmt = conn.createStatement();
			
			String sql;
			sql = "SELECT id FROM office WHERE name=\"" + office + "\"";
			rs = stmt.executeQuery(sql);
			
			while(rs.next())
			{
				office_id = rs.getInt("id");
				break;
			}
			sql = "SELECT * FROM personnel WHERE first_name=\"" + first_name + "\" AND last_name=\"" + last_name + "\"";
			rs = stmt.executeQuery(sql);
			
			int count = 0;
			while(rs.next())
			{
				count++;
				emp_id = rs.getInt("id");
			}
			if( count > 0 )
			{
				result = JOptionPane.showConfirmDialog(null, "There are duplicate entries. Do you want to update instead?", "Duplicate Entries", JOptionPane.YES_NO_OPTION );
				if( result == 0 ) {
					sql = "UPDATE office_personnel SET office_id=" + office_id + ", position=\"" + position + "\" WHERE emp_id=" + emp_id;
					stmt.executeUpdate(sql);
				}
			}
			else {
				sql = "INSERT INTO personnel(last_name, first_name) VALUES (\"" + last_name + "\",\"" + first_name + "\")";
				stmt.executeUpdate(sql);
				sql = "SELECT id FROM personnel WHERE last_name=\"" + last_name + "\" AND first_name=\"" + first_name + "\"";
				rs = stmt.executeQuery(sql);
				while(rs.next())
				{
					emp_id = rs.getInt("id");
				}
				sql = "INSERT INTO office_personnel(office_id, emp_id, position) VALUES (" + office_id + "," + emp_id + ",\"" + position + "\")";
				stmt.executeUpdate(sql);
				sql = "INSERT INTO transaction_log(office_emp_id, action, date_time_stamp) VALUES (" + empID + ", \"added new personnel " + first_name + " " + last_name + "\", NOW())";
				stmt.executeUpdate(sql);
			}
			rs.close();
			stmt.close();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
