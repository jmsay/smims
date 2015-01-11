package view;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JPanel;

import controller.AddPersonnelController;

public class AddPersonnelView extends JPanel {
	
	ImageIcon bg, okU, okR;
	private JLabel apbg;
	private JButton ok;
	private JTextField last, first, posi;
	private JComboBox officeList;
	String[] offices;
	
	public AddPersonnelView() {
		super();
		setLayout(null);
		loadImages();
		initComponents();
		addComponents();
		setSize(795, 477);
	}
	
	public void setOffices( String office, String[] offices )
	{
		if( !office.equalsIgnoreCase("Supply") ) {
			this.offices = new String[1];
			this.offices[0] = office;
		}
		else
			this.offices = offices;
	}
	
	private void loadImages() {
		bg = new ImageIcon("images/addPersonnelBg.jpg");
		okU = new ImageIcon("images/buttons/okBtn.png");
		okR = new ImageIcon("images/buttons/okR.png");
	}

	private void addComponents() {
		add(getOK());
		add(getLastField());
		add(getFirstField());
		add(getPosiField());
	}
	
	public void addOfficeComboBox() {
        setOfficeList(new JComboBox(offices));
        getOfficeList().setBounds(264, 219, 416, 31);
        //getOfficeList().setOpaque(false);
        getOfficeList().setBorder(null);
        add(getOfficeList());
		add(getBG());
        repaint();
        revalidate();
	}
	
	private void initComponents() {
		setBG(new JLabel(bg));
		getBG().setBounds(0, 0, 795, 477);
		
		setOK(new JButton(okU));
		getOK().setBounds(350, 350, 96, 61);
		getOK().setOpaque(false);
		getOK().setFocusable(false);
        getOK().setContentAreaFilled(false);
        getOK().setBorderPainted(false);
        getOK().setRolloverIcon(okR);
        
        setLastField(new JTextField(20));
        setFirstField(new JTextField(20));
        setPosiField(new JTextField(20));
        
        setTextField(getLastField(), 264, 111, 416, 31);
        setTextField(getFirstField(), 264, 165, 416, 31);
        setTextField(getPosiField(), 264, 273, 416, 31);
	}
	
	private void setTextField(JTextField field, int x, int y, int width, int height) {
		field.setBounds(x, y, width, height);
		field.setOpaque(false);
		field.setBorder(null);
	}
	
	public void addControllers( AddPersonnelController controller ) {
		getOK().addActionListener( controller );
	}
	
	public JTextField getPosiField() {
		return posi;
	}

	public JTextField getFirstField() {
		return first;
	}

	private void setPosiField(JTextField posi) {
		this.posi = posi;
	}

	private void setFirstField(JTextField first) {
		this.first = first;
	}

	public JTextField getLastField() {
		return last;
	}

	private void setLastField(JTextField last) {
		this.last = last;
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

	public JComboBox getOfficeList() {
		return officeList;
	}

	public void setOfficeList(JComboBox officeList) {
		this.officeList = officeList;
	}
}
