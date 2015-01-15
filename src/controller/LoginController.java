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
			boolean loginResult = model.checkCredentials(view.getUserField().getText(), new String(view.getPassField().getPassword()));
			if( loginResult )
			{
				HomeView homeView = new HomeView();
				homeView.setUserName( model.getLast_name().toUpperCase() + ", " + model.getFirst_name() );
				homeView.setOfficeName( model.getPosition() + ", " + model.getOffice().toUpperCase() );
				homeView.updateUserLabel();
				controller.changeView( view, homeView );
				controller.setOfficeEmpID( model.getEmpID() );
				new HomeController( controller, homeView, model );
			}
			else
			{
				JOptionPane.showMessageDialog(null, "Incorrect username/password combination.");
				view.getPassField().setText(null);
			}
		}
	}
}
