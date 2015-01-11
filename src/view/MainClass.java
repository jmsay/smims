package view;

import javax.swing.JFrame;

import controller.*;
import model.*;

public class MainClass extends JFrame {
	
	private MainController mainController;

	private LoginController loginController;
	private LoginView loginView;
	private LoginModel loginModel;
	
	public MainClass( MainController mainController )
	{
		super( "Supplies and Materials Inventory Management System" );
		setMainController( mainController );
		
		setLayout(null);
		setLoginMVC();
		
		setSize(1024, 600);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setVisible(true);
	}
	
	public void setLoginMVC()
	{
		setLoginView(new LoginView());
		setLoginModel(new LoginModel());
		setLoginController(new LoginController( getMainController(), getLoginView(), getLoginModel() ));
		
		add(getLoginView());
		getLoginView().setVisible(true);
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
