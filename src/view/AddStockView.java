package view;

import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JPanel;

import controller.AddStockController;

public class AddStockView extends JPanel {
	
	ImageIcon bg, okU, okR;
	private JLabel apbg;
	private JButton ok;
	private JTextField item_no, amount;
	private JComboBox itemList;
	String[] items;
	
	public AddStockView() {
		super();
		setLayout(null);
		loadImages();
		initComponents();
		addComponents();
		setSize(795, 477);
	}
	
	public void setItems( String[] items )
	{
		this.items = items;
	}
	
	private void loadImages() {
		bg = new ImageIcon("images/bg/addStockBg.png");
		okU = new ImageIcon("images/buttons/okBtn.png");
		okR = new ImageIcon("images/buttons/okRO.png");
	}

	private void addComponents() {
		add(getOK());
		add(getAmount());
	}
	
	public void addItemsComboBox() {
        setItemList(new JComboBox(items));
        getItemList().setBounds(259, 151, 416, 31);
        //getItemList().setOpaque(false);
        getItemList().setBorder(null);
        add(getItemList());
		add(getBG());
        repaint();
        revalidate();
	}
	
	private void initComponents() {
		setBG(new JLabel(bg));
		getBG().setBounds(0, 0, 801, 476);
		
		setOK(new JButton(okU));
		getOK().setBounds(350, 300, 96, 61);
		getOK().setOpaque(false);
		getOK().setFocusable(false);
        getOK().setContentAreaFilled(false);
        getOK().setBorderPainted(false);
        getOK().setRolloverIcon(okR);
        
        setAmount( new JTextField(20) );
        
        setTextField(getAmount(), 259, 201, 416, 31);
	}
	
	private void setTextField(JTextField field, int x, int y, int width, int height) {
		field.setBounds(x, y, width, height);
		field.setFont( new Font("Serif", Font.PLAIN, 21));
		field.setOpaque(false);
		field.setBorder(null);
	}
	
	public void addControllers( AddStockController controller ) {
		getOK().addActionListener( controller );
		getAmount().addActionListener( controller );
	}
	
	public JButton getOK() {
		return ok;
	}

	public JLabel getBG() {
		return apbg;
	}

	private void setOK(JButton ok) {
		this.ok = ok;
	}

	private void setBG(JLabel apbg) {
		this.apbg = apbg;
	}

	public JComboBox getItemList() {
		return itemList;
	}

	public void setItemList(JComboBox itemList) {
		this.itemList = itemList;
	}
	
	public JTextField getAmount() {
		return amount;
	}

	public void setAmount(JTextField amount) {
		this.amount = amount;
	}
}
