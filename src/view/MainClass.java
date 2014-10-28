package view;

import javax.swing.JFrame;
import javax.swing.JPanel;

import controller.*;
import model.*;

public class MainClass extends JFrame{
	
	private MainController mainController;

	private LoginController loginController;
	private LoginView loginView;
	private LoginModel loginModel;
	
	public MainClass()
	{
		super( "Supplies and Materials Inventory Management System" );
		setLoginView(new LoginView());
		setLoginModel(new LoginModel());
		setMainController( new MainController( this ) );
		setLoginController(new LoginController( getMainController(), getLoginView(), getLoginModel() ));
		setLayout(null);
		
		add(getLoginView());
		getLoginView().setVisible(true);
		
		setSize(1000, 700);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setVisible(true);
	}
	
	public static void main( String [] args )
	{
		new MainClass();
	}
	
	public void setView( JPanel panel ) {
		
	}

	public MainController getMainController() {
		return mainController;
	}

	public void setMainController(MainController mainController) {
		this.mainController = mainController;
	}

	public LoginController getLoginController() {
		return loginController;
	}

	public void setLoginController(LoginController loginController) {
		this.loginController = loginController;
	}

	public LoginView getLoginView() {
		return loginView;
	}

	public void setLoginView(LoginView loginView) {
		this.loginView = loginView;
	}

	public LoginModel getLoginModel() {
		return loginModel;
	}

	public void setLoginModel(LoginModel loginModel) {
		this.loginModel = loginModel;
	}
}
