package model;

import java.sql.*;

import javax.swing.JOptionPane;

public class AddMaterialModel extends SuperModel {
	
	private String itemNo;
	
	public AddMaterialModel()
	{
		super();
		try {
			Class.forName(driver).newInstance();
		} catch( Exception e ) {
			e.printStackTrace();
		}
	}
	
	public String[] getCategories()
	{
		String[] list = new String[0];
		try {
			conn = DriverManager.getConnection(url+dbName,userName,password);
			
			stmt = conn.createStatement();
			
			String sql;
			sql = "SELECT COUNT(DISTINCT category) AS num FROM material";
			rs = stmt.executeQuery(sql);
			
			while( rs.next() )
			{
				list = new String[rs.getInt("num")];
				break;
			}
			
			sql = "SELECT DISTINCT category FROM material";
			rs = stmt.executeQuery(sql);
			
			int count = 0;
			while(rs.next())
			{
				list[count] = rs.getString("category");
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
	
	public void addToDatabase( String item_no, String name, String description, String category, String unit, float price )
	{
		int result;
		String item="";
		try {
			conn = DriverManager.getConnection(url+dbName,userName,password);
			
			stmt = conn.createStatement();
			
			String sql;
			sql = "SELECT * FROM material WHERE name=\"" + name + "\" AND description=\"" + description + "\"";
			rs = stmt.executeQuery(sql);
			
			int count = 0;
			while(rs.next())
			{
				count++;
				item = rs.getString("item_no");
			}
			if( count > 0 )
			{
				result = JOptionPane.showConfirmDialog(null, "There are duplicate entries. Do you want to update instead?", "Duplicate Entries", JOptionPane.YES_NO_OPTION );
				if( result == 0 ) {
					sql = "UPDATE material SET category=\"" + category + "\", unit=\"" + unit + "\", price=" + price + " WHERE item_no=\"" + item + "\"";
					stmt.executeUpdate(sql);
					setItemNo( item );
				}
			}
			else {
				sql = "INSERT INTO material(item_no, name, description, category, unit, price) VALUES (\"" + item_no + "\",\"" + name + "\",\"" + description + "\",\"" + category + "\",\"" + unit + "\"," + price + ")";
				stmt.executeUpdate(sql);
			}
			rs.close();
			stmt.close();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public String getItemNo() {
		return itemNo;
	}

	public void setItemNo(String itemNo) {
		this.itemNo = itemNo;
	}
}
