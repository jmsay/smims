package view;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import controller.LoginController;

public class LoginView extends JPanel {
	
	ImageIcon bg, lgu, lgr;
	private JLabel lbg;
	private JButton loginButton;
	private JTextField userField;
	private JPasswordField passField;
	
	public LoginView() {
		super();
		setLayout(null);
		loadImages();
		initComponents();
		addComponents();
		setBounds(0, 0, 1000, 700);
	}

	private void addComponents() {
		add(getUserField());
		add(getPassField());
		add(getLoginButton());
		add(getBG());
	}

	private void loadImages() {
		bg = new ImageIcon("images/login/loginbg.jpg");
		lgu = new ImageIcon("images/login/loginu.png");
		lgr = new ImageIcon("images/login/loginr.png");
	}

	private void initComponents() {
		setBG(new JLabel(bg));
		getBG().setBounds(0, 0, 1000, 700);
		
		setLoginButton(new JButton(lgu));
		getLoginButton().setBounds(455, 435, 96, 91);
		getLoginButton().setOpaque(false);
		getLoginButton().setFocusable(false);
        getLoginButton().setContentAreaFilled(false);
        getLoginButton().setBorderPainted(false);
        getLoginButton().setRolloverIcon(lgr);
        
        setUserField(new JTextField(20));
        getUserField().setBounds(369, 322, 267, 37);
        getUserField().setOpaque(false);
        getUserField().setBorder(null);
        
        setPassField(new JPasswordField(20));
        getPassField().setBounds(369, 405, 267, 37);
        getPassField().setOpaque(false);
        getPassField().setBorder(null);
	}
	
	public JPasswordField getPassField() {
		return passField;
	}

	public JTextField getUserField() {
		return userField;
	}

	private void setPassField(JPasswordField passField) {
		this.passField = passField;
	}

	private void setUserField(JTextField userField) {
		this.userField = userField;
	}

	public JButton getLoginButton() {
		return loginButton;
	}

	public JLabel getBG() {
		return lbg;
	}

	private void setLoginButton(JButton login) {
		this.loginButton = login;
	}

	private void setBG(JLabel lgbg) {
		this.lbg = lgbg;
	}
	
	public void addControllers( LoginController controller )
	{
		getUserField().addActionListener( controller );
		getPassField().addActionListener( controller );
		getLoginButton().addActionListener( controller );
	}
}
