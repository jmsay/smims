package view;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class HomeView extends JPanel {
	
	ImageIcon bg, perU, perR, stoU, stoR, supU, supR, genU, genR, updU, updR, viewU, viewR, priU, priR, fileB, editB, vieB, setB, helpB, loB;
	private JLabel mainbg;
	private JButton person, stock, supply, report, update, view, print, file, edit, vie, set, help, lo;
	
	public HomeView() {
		super();
		setLayout(null);
		loadImages();
		initComponents();
		addComponents();
		setBounds(0, 0, 1000, 700);
	}

	private void addComponents() {
		add(getSup());
		add(getSto());
		add(getPer());
		add(getUpd());
		add(getGen());
		add(getView());
		add(getPri());
		add(getBG());
	}
	
	private void loadImages() {
		bg = new ImageIcon("images/menu/menuBg.jpg");
		perU = new ImageIcon("images/menu/addPerson.png");
		perR = new ImageIcon("images/menu/addPersonR.png");
		stoU = new ImageIcon("images/menu/addStock.png");
		stoR = new ImageIcon("images/menu/addStockR.png");
		supU = new ImageIcon("images/menu/addSupplyBtn.png");
		supR = new ImageIcon("images/menu/addSupplyR.png");
		genU = new ImageIcon("images/menu/generate.png");
		genR = new ImageIcon("images/menu/generateR.png");
		updU = new ImageIcon("images/menu/update.png");
		updR = new ImageIcon("images/menu/updateR.png");
		viewU = new ImageIcon("images/menu/viewInvent.png");
		viewR = new ImageIcon("images/menu/viewInventR.png");
		priU = new ImageIcon("images/menu/print.png");
		priR = new ImageIcon("images/menu/printR.png");
		fileB = new ImageIcon("images/menu/fileBtn.png");
	}

	private void initComponents() {
		setBG(new JLabel(bg));
		getBG().setBounds(0, 0, 1000, 700);
		
		setPer(new JButton(perU));
		setSto(new JButton(stoU));
		setSup(new JButton(supU));
		setGen(new JButton(genU));
		setUpd(new JButton(updU));
		setView(new JButton(viewU));
		setPri(new JButton(priU));
		
		getSup().setBounds(5, 146, 269, 45);
		getSup().setOpaque(false);
		getSup().setFocusable(false);
        getSup().setContentAreaFilled(false);
        getSup().setBorderPainted(false);
        getSup().setRolloverIcon(supR);
        
        getSto().setBounds(5, 193, 269, 45);
		getSto().setOpaque(false);
		getSto().setFocusable(false);
        getSto().setContentAreaFilled(false);
        getSto().setBorderPainted(false);
        getSto().setRolloverIcon(stoR);
        
        getPer().setBounds(5, 240, 269, 45);
		getPer().setOpaque(false);
		getPer().setFocusable(false);
        getPer().setContentAreaFilled(false);
        getPer().setBorderPainted(false);
        getPer().setRolloverIcon(perR);
        
        getUpd().setBounds(5, 287, 269, 45);
		getUpd().setOpaque(false);
		getUpd().setFocusable(false);
        getUpd().setContentAreaFilled(false);
        getUpd().setBorderPainted(false);
        getUpd().setRolloverIcon(updR);
        
        getGen().setBounds(5, 334, 269, 45);
		getGen().setOpaque(false);
		getGen().setFocusable(false);
        getGen().setContentAreaFilled(false);
        getGen().setBorderPainted(false);
        getGen().setRolloverIcon(genR);
        
        getView().setBounds(5, 381, 269, 45);
		getView().setOpaque(false);
		getView().setFocusable(false);
        getView().setContentAreaFilled(false);
        getView().setBorderPainted(false);
        getView().setRolloverIcon(viewR);
        
        getPri().setBounds(5, 428, 269, 45);
		getPri().setOpaque(false);
		getPri().setFocusable(false);
        getPri().setContentAreaFilled(false);
        getPri().setBorderPainted(false);
        getPri().setRolloverIcon(priR);
	}
	
	private void setButton(JButton button, ImageIcon rollover, int x, int y, int width, int height) {
		button.setBounds(x, y, width, height);
		button.setOpaque(false);
		button.setFocusable(false);
		button.setContentAreaFilled(false);
		button.setBorderPainted(false);
		button.setRolloverIcon(rollover);
	}

	public JButton getPer() {
		return person;
	}
	
	public JButton getSto() {
		return stock;
	}
	
	public JButton getSup() {
		return supply;
	}
	
	public JButton getGen() {
		return report;
	}
	
	public JButton getView() {
		return view;
	}
	
	public JButton getUpd() {
		return update;
	}
	
	public JButton getPri() {
		return print;
	}

	private void setPri(JButton print) {
		this.print = print;
	}

	private void setView(JButton view) {
		this.view = view;
	}

	private void setUpd(JButton update) {
		this.update = update;
	}

	private void setGen(JButton report) {
		this.report = report;
	}

	private void setSup(JButton supply) {
		this.supply = supply;
	}

	private void setSto(JButton stock) {
		this.stock = stock;
	}

	private void setPer(JButton person) {
		this.person = person;
	}

	public JLabel getBG() {
		return mainbg;
	}

	private void setBG(JLabel mainbg) {
		this.mainbg = mainbg;
	}
}
