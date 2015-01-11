package view;

import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JPanel;

import controller.AddMaterialController;

public class AddMaterialView extends JPanel {
	
	ImageIcon bg, okU, okR;
	private JLabel ambg;
	private JButton ok;
	private JTextField item_no, materialName, desc, unit, price;
	private JComboBox category;
	String[] categoryList;
	
	public AddMaterialView() {
		super();
		setLayout(null);
		loadImages();
		initComponents();
		addComponents();
		setSize(795, 477);
	}

	private void loadImages() {
		bg = new ImageIcon("images/addMaterialBG.jpg");
		okU = new ImageIcon("images/buttons/okBtn.png");
		okR = new ImageIcon("images/buttons/okR.png");
	}

	private void addComponents() {
		add(getOK());
		add(getItem_no());
		add(getMaterialName());
		add(getDesc());
		add(getUnit());
		add(getPrice());
	}
	
	private void initComponents() {
		setBG(new JLabel(bg));
		getBG().setBounds(0, 0, 795, 477);
		
		setOK(new JButton(okU));
		getOK().setBounds(350, 393, 96, 61);
		getOK().setOpaque(false);
		getOK().setFocusable(false);
        getOK().setContentAreaFilled(false);
        getOK().setBorderPainted(false);
        getOK().setRolloverIcon(okR);
        
        setItem_no(new JTextField(10));
        setMaterialName(new JTextField(20));
        setDesc(new JTextField(20));
        setUnit(new JTextField(10));
        setPrice(new JTextField(10));
        
        setTextField(getItem_no(), 258, 67, 418, 31);
        setTextField(getMaterialName(), 258, 148, 418, 31);
        setTextField(getDesc(), 258, 188, 418, 31);
        setTextField(getUnit(), 258, 325, 418, 31);
        setTextField(getPrice(), 258, 364, 418, 31);
	}
	
	public void addCategoryComboBox() {
        setCategory(new JComboBox(categoryList));
        getCategory().setBounds( 258, 108, 418, 31 );
        //getCategory().setOpaque(false);
        getCategory().setBorder(null);
        getCategory().setEditable(true);
        add(getCategory());
		add(getBG());
        repaint();
        revalidate();
	}
	
	private void setTextField(JTextField field, int x, int y, int width, int height) {
		field.setBounds(x, y, width, height);
		field.setOpaque(false);
		field.setFont( new Font("Serif", Font.PLAIN, 21));
		field.setBorder(null);
	}
	
	public void addControllers( AddMaterialController controller ) {
		getOK().addActionListener( controller );
	}

	public ImageIcon getOkU() {
		return okU;
	}

	public void setOkU(ImageIcon okU) {
		this.okU = okU;
	}

	public ImageIcon getOkR() {
		return okR;
	}

	public void setOkR(ImageIcon okR) {
		this.okR = okR;
	}

	public JButton getOK() {
		return ok;
	}

	public JLabel getBG() {
		return ambg;
	}

	private void setOK(JButton ok) {
		this.ok = ok;
	}

	private void setBG(JLabel ambg) {
		this.ambg = ambg;
	}

	public JTextField getMaterialName() {
		return materialName;
	}

	public void setMaterialName(JTextField name) {
		this.materialName = name;
	}

	public JTextField getDesc() {
		return desc;
	}

	public void setDesc(JTextField desc) {
		this.desc = desc;
	}

	public JTextField getUnit() {
		return unit;
	}

	public void setUnit(JTextField unit) {
		this.unit = unit;
	}

	public JTextField getPrice() {
		return price;
	}

	public void setPrice(JTextField price) {
		this.price = price;
	}

	public JComboBox getCategory() {
		return category;
	}

	public void setCategory(JComboBox category) {
		this.category = category;
	}

	public JTextField getItem_no() {
		return item_no;
	}

	public void setItem_no(JTextField item_no) {
		this.item_no = item_no;
	}
	
	public void setCategoryList( String[] categoryList )
	{
		this.categoryList = categoryList;
	}
}
