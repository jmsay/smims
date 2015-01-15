package model;

import java.sql.*;

public class AddStockModel extends SuperModel {
	
	private String[] itemIDs;
	
	public AddStockModel()
	{
		super();
		try {
			Class.forName(driver).newInstance();
		} catch( Exception e ) {
			e.printStackTrace();
		}
	}
	
	public String[] getItems()
	{
		String[] list = new String[0];
		setItemIDs(new String[0]);
		try {
			conn = DriverManager.getConnection(url+dbName,userName,password);
			
			stmt = conn.createStatement();
			
			String sql;
			sql = "SELECT COUNT(*) AS num FROM material";
			rs = stmt.executeQuery(sql);
			
			while( rs.next() )
			{
				int size = rs.getInt("num");
				list = new String[size];
				setItemIDs(new String[size]);
				break;
			}
			
			sql = "SELECT * FROM material ORDER BY name ASC";
			rs = stmt.executeQuery(sql);
			
			int count = 0;
			while(rs.next())
			{
				list[count] = rs.getString("name") + ", " + rs.getString("description") + " (" + rs.getString("item_no") + ")";
				itemIDs[count] = rs.getString("item_no");
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
	
	public void addToDatabase( int empID, String item_no, int amount )
	{
		try {
			conn = DriverManager.getConnection(url+dbName,userName,password);
			
			stmt = conn.createStatement();
			
			String sql;
			sql = "INSERT INTO stock(item_no, amount, date_added) VALUES (\"" + item_no + "\"," + amount + ",NOW()" + ")";
			stmt.executeUpdate(sql);
			sql = "INSERT INTO transaction_log(office_emp_id, action, date_time_stamp) VALUES (" + empID + ", \"added " + amount + " to Item " + item_no + "\'s stock\", NOW())";
			stmt.executeUpdate(sql);
			rs.close();
			stmt.close();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public String[] getItemIDs() {
		return itemIDs;
	}

	public void setItemIDs(String[] itemIDs) {
		this.itemIDs = itemIDs;
	}
}
