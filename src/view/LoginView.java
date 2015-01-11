package view;

import java.awt.Font;
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
		setBounds(0, 0, 1024, 600);
		setOpaque(false);
		loadImages();
		initComponents();
		addComponents();
	}

	private void addComponents() {
		add(getUserField());
		add(getPassField());
		add(getLoginButton());
		add(getBG());
	}

	private void loadImages() {
		bg = new ImageIcon("images/loginbg.jpg");
		lgu = new ImageIcon("images/buttons/loginU.png");
		lgr = new ImageIcon("images/buttons/loginR.png");
	}

	private void initComponents() {
		setBG(new JLabel(bg));
		getBG().setBounds(0, 0, 1024, 600);
		
		setLoginButton(new JButton(lgu));
		getLoginButton().setBounds(656, 405, 96, 61);
		getLoginButton().setOpaque(false);
		getLoginButton().setFocusable(false);
        getLoginButton().setContentAreaFilled(false);
        getLoginButton().setBorderPainted(false);
        getLoginButton().setRolloverIcon(lgr);
        
        setUserField(new JTextField(20));
        getUserField().setFont( new Font("Serif", Font.PLAIN, 20)); 
		getUserField().setBounds(593, 300, 230, 33);
        getUserField().setOpaque(false);
        getUserField().setBorder(null);
        
        setPassField(new JPasswordField(20));
        getPassField().setFont( new Font("Serif", Font.PLAIN, 20));
        getPassField().setBounds(593, 370, 230, 33);
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
