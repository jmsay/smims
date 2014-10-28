package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import view.LoginView;
import view.HomeView;
import model.LoginModel;
import controller.MainController;

public class LoginController implements ActionListener {
	
	private LoginView view;
	private LoginModel model;
	private MainController controller;
	
	public LoginController( MainController controller, LoginView view, LoginModel model ) {
		this.view = view;
		this.model = model;
		this.controller = controller;
		connectViewController();
	}
	
	public void connectViewController() {
		view.addControllers( this );
	}
	
	public void actionPerformed(ActionEvent e)
	{
		if( e.getSource() == view.getUserField() || e.getSource() == view.getPassField() || e.getSource() == view.getLoginButton() )
		{
			System.out.println( "--VIEW-- user: " + view.getUserField().getText() + " pass: " + new String(view.getPassField().getPassword()) );
		}
		boolean loginResult = model.checkCredentials(view.getUserField().getText(), new String(view.getPassField().getPassword()));
		JOptionPane.showMessageDialog( null, loginResult ? "Login successful!" : "Incorrect username/password combination!" );
		if( loginResult )
		{
			HomeView homeView = new HomeView();
			controller.changeView( homeView );
		}
	}
}
