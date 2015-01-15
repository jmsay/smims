package view;

import java.awt.Dimension;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

public class InventorySupplyView extends JPanel {
	private JLabel inventoryBg;
	ImageIcon bgIcon, searchIcon, searchROIcon, editIcon, editROIcon;
	private JButton searchBtn, editBtn;
	private JTextField searchField, tf[];
	private JComboBox category;
	private JTable inventoryTable;
	private JScrollPane scrollPane;
	String[] categoryList;
	String [] columnNames = {"Stock Number",
            "Name",
            "Description",
            "Category",
            "Unit",
            "Price",
            "Amount in Stock"};

	public InventorySupplyView() {
		super();
		setLayout(null);
		loadImages();
		initComponents();
		addComponents();
		setSize(795, 477);
	}
	
	private void loadImages() {
		bgIcon = new ImageIcon("images/bg/inventorySupplyBG.png");
		searchIcon = new ImageIcon("images/buttons/searchBtn.png");
		searchROIcon = new ImageIcon("images/buttons/searchRO.png");
		editIcon = new ImageIcon("images/buttons/searchBtn.png");
		editROIcon = new ImageIcon("images/buttons/searchRO.png");
	}
	
	private void addComponents() {
		add( getSearchBtn() );
		add( getEditBtn() );
		add( getSearchField() );
		for( int i=0; i < 5; i++ )
			add( getTf()[i] );
		add( getCategory() );
		add( getScrollPane() );
		//getCategory().setVisible(false);
		add( getInventoryBg() );
	}
	
	private void initComponents() {
		setInventoryBg( new JLabel(bgIcon) );
		getInventoryBg().setBounds(0, 0, 801, 476);
		
		setInventoryTable( new JTable(new DefaultTableModel(new Object[0][7], columnNames)));
		getInventoryTable().setPreferredScrollableViewportSize(new Dimension(755, 303));
		getInventoryTable().setFillsViewportHeight(true);
		
		setScrollPane( new JScrollPane( getInventoryTable()) );
		getScrollPane().setBounds(23, 73, 755, 303);
		
		TableColumn column = null;
		for (int i = 0; i < 7; i++)
		{
		    column = getInventoryTable().getColumnModel().getColumn(i);
		    if (i == 2)
		    {
		        column.setPreferredWidth(100);
		    } 
		    else 
		    {
		        column.setPreferredWidth(50);
		    }
		}
		
        setCategory(new JComboBox());
        getCategory().setBounds( 101, 419, 151, 20 );
        getCategory().setOpaque(false);
        getCategory().setBorder(null);
        getCategory().setEditable(true);
        
		setSearchBtn(new JButton(searchIcon));
		setButton(getSearchBtn(), searchROIcon, 700, 39, 71, 27);
		
		setEditBtn(new JButton(editIcon));
		setButton(getEditBtn(), editROIcon, 705, 443, 71, 27);
		
		setSearchField( new JTextField(20) );
		setTextField( getSearchField(), 25, 40, 670, 24);
		
		setTf( new JTextField[5] );
		for( int i=0, j=0; i < 6; i++ )
		{
			int xpos, ypos;
			if( i / 2 == 0 )
				xpos = 101;
			else if( i / 2 == 1 )
				xpos = 369;
			else
				xpos = 600;
			if( i % 2 == 0 )
				ypos = 393;
			else
				ypos = 419;

			if( i != 1 ) {
				getTf()[j] = new JTextField( 20 );
				setTextField( getTf()[j], xpos, ypos, 151, 20);
				j++;
			}
		}
	}
	
	public void addCategoryComboBox() {
		setCategory(new JComboBox(categoryList));
        getCategory().setVisible(true);
        repaint();
        revalidate();
	}
	
	private void setButton(JButton button, ImageIcon rollover, int x, int y, int width, int height) {
		button.setBounds(x, y, width, height);
		button.setOpaque(false);
		button.setFocusable(false);
		button.setContentAreaFilled(false);
		button.setBorderPainted(false);
		button.setRolloverIcon(rollover);
	}
	
	private void setTextField(JTextField field, int x, int y, int width, int height) {
		field.setBounds(x, y, width, height);
		field.setFont( new Font("Serif", Font.PLAIN, 16));
		field.setOpaque(false);
		field.setBorder(null);
	}
	
//	public void addControllers( HomeController controller )
//	{
//		for( int i = 0; i < 5; i++ )
//			getMenuButtons()[i].addActionListener( controller );
//		getLogoutBtn().addActionListener( controller );
//	}
	
	public JButton getSearchBtn() {
		return searchBtn;
	}

	public void setSearchBtn(JButton searchBtn) {
		this.searchBtn = searchBtn;
	}

	public JButton getEditBtn() {
		return editBtn;
	}

	public void setEditBtn(JButton editBtn) {
		this.editBtn = editBtn;
	}

	public JTextField getSearchField() {
		return searchField;
	}

	public void setSearchField(JTextField searchField) {
		this.searchField = searchField;
	}

	public JScrollPane getScrollPane() {
		return scrollPane;
	}

	public void setScrollPane(JScrollPane scrollPane) {
		this.scrollPane = scrollPane;
	}

	public JTextField[] getTf() {
		return tf;
	}

	public void setTf(JTextField[] tf) {
		this.tf = tf;
	}

	public JLabel getInventoryBg() {
		return inventoryBg;
	}

	public void setInventoryBg(JLabel inventoryBg) {
		this.inventoryBg = inventoryBg;
	}

	public JTable getInventoryTable() {
		return inventoryTable;
	}

	public void setInventoryTable(JTable inventoryTable) {
		this.inventoryTable = inventoryTable;
	}

	public JComboBox getCategory() {
		return category;
	}

	public void setCategory(JComboBox category) {
		this.category = category;
	}

	public void setTableEntries( Object[][] tableData )
	{
		DefaultTableModel model = (DefaultTableModel) getInventoryTable().getModel();
		for( int i = 0; i < tableData.length; i++ )
		{
			Object[] tuple = {
				tableData[i][0],
				tableData[i][2],
				tableData[i][3],
				tableData[i][1],
				tableData[i][4],
				tableData[i][5],
				tableData[i][6]
			};
			model.addRow( tuple );
		}
	}
}
