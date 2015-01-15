package model;

import java.sql.DriverManager;

import javax.swing.JOptionPane;

public class InventorySupplyModel extends SuperModel {

	private String [] itemNoList, categoryList, nameList, descList, unitList;
	private Object[][] inventoryArray;
	private float[] priceList;
	private int[] stockList;
	public InventorySupplyModel()
	{
		super();
		try {
			Class.forName(driver).newInstance();
		} catch( Exception e ) {
			e.printStackTrace();
		}
	}
	
	public void getInventory( String searchEntry )
	{
		String search;
		try {
			conn = DriverManager.getConnection(url+dbName,userName,password);
			
			stmt = conn.createStatement();
			String sql;
			
			search = searchEntry.trim();
			
			if( !search.equals("") )
			{
				sql = "SELECT COUNT(*) AS total FROM material"
						+ "WHERE item_no=\"" + search + "\" OR category=\"" + search + "\" OR name=\""
								+ search + "\" OR description=\"" + search + "\"";
			}
			else {
				sql = "SELECT COUNT(*) AS total FROM material";
			}
			rs = stmt.executeQuery(sql);
			
			while( rs.next() )
			{
				setItemNoList( new String[rs.getInt("total")] );
				setCategoryList( new String[rs.getInt("total")] );
				setNameList( new String[rs.getInt("total")] );
				setDescList( new String[rs.getInt("total")] );
				setUnitList( new String[rs.getInt("total")] );
				setPriceList( new float[rs.getInt("total")] );
				setStockList( new int[rs.getInt("total")] );
				setInventoryArray( new Object[rs.getInt("total")][7] );
				break;
			}
			if( !search.equals("") )
			{
				sql = "SELECT mat.*, SUM(sto.amount) AS total_amount FROM material AS mat "
						+ "LEFT JOIN stock AS sto ON mat.item_no=sto.item_no GROUP BY mat.item_no"
						+ "HAVING item_no=\"" + search + "\" OR category=\"" + search + "\" OR name=\""
								+ search + "\" OR description=\"" + search + "\" ORDER BY item_no ASC";
			}
			else {
				sql = "SELECT mat.*, SUM(sto.amount) AS total_amount FROM material AS mat LEFT JOIN stock AS sto ON mat.item_no=sto.item_no GROUP BY mat.item_no ORDER BY item_no ASC";
			}
			rs = stmt.executeQuery(sql);
			
			
			int count = 0;
			while(rs.next())
			{
				getItemNoList()[count] = rs.getString("item_no");
				getCategoryList()[count] = rs.getString("category");
				getNameList()[count] = rs.getString("name");
				getDescList()[count] = rs.getString("description");
				getUnitList()[count] = rs.getString("unit");
				getPriceList()[count] = rs.getFloat("price");
				getStockList()[count] = rs.getInt("total_amount");
				getInventoryArray()[count][0] = rs.getString("item_no");
				getInventoryArray()[count][1] = rs.getString("category");
				getInventoryArray()[count][2] = rs.getString("name");
				getInventoryArray()[count][3] = rs.getString("description");
				getInventoryArray()[count][4] = rs.getString("unit");
				getInventoryArray()[count][5] = rs.getFloat("price");
				getInventoryArray()[count][6] = rs.getInt("total_amount");
				count++;
			}
			rs.close();
			stmt.close();
			conn.close();
		} catch (Exception e) {
			JOptionPane.showMessageDialog( null, "Database error. Contact database administrator." );
			e.printStackTrace();
		}
	}

	public Object[][] getInventoryArray() {
		return inventoryArray;
	}

	public void setInventoryArray(Object[][] objects) {
		this.inventoryArray = objects;
	}

	public String[] getItemNoList() {
		return itemNoList;
	}

	public void setItemNoList(String[] itemNoList) {
		this.itemNoList = itemNoList;
	}

	public String[] getCategoryList() {
		return categoryList;
	}

	public void setCategoryList(String[] categoryList) {
		this.categoryList = categoryList;
	}

	public String[] getNameList() {
		return nameList;
	}

	public void setNameList(String[] nameList) {
		this.nameList = nameList;
	}

	public String[] getDescList() {
		return descList;
	}

	public void setDescList(String[] descList) {
		this.descList = descList;
	}

	public String[] getUnitList() {
		return unitList;
	}

	public void setUnitList(String[] unitList) {
		this.unitList = unitList;
	}

	public float[] getPriceList() {
		return priceList;
	}

	public void setPriceList(float[] priceList) {
		this.priceList = priceList;
	}

	public int[] getStockList() {
		return stockList;
	}

	public void setStockList(int[] stockList) {
		this.stockList = stockList;
	}
}
