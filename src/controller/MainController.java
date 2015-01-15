package controller;

import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

import view.*;

public class MainController implements WindowListener {
	
	private MainClass mainClass;
	private int officeEmpID;
	
	public MainController() {
		mainClass = new MainClass( this );
		getMainClass().addWindowListener(this);
	}
	
	public void changeView( JPanel prevView, JPanel view ) {
		getMainClass().setVisible(false);
		prevView.setVisible(false);
		getMainClass().remove( prevView );
		getMainClass().add( view );
		getMainClass().setVisible(true);
		getMainClass().repaint();
		getMainClass().revalidate();
	}

	public MainClass getMainClass() {
		return mainClass;
	}

	public void setMainClass(MainClass mainClass) {
		this.mainClass = mainClass;
	}

	public int getOfficeEmpID() {
		return officeEmpID;
	}

	public void setOfficeEmpID(int officeEmpID) {
		this.officeEmpID = officeEmpID;
	}

	@Override
	public void windowOpened(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowClosing(WindowEvent e) {
		// TODO Auto-generated method stub
		if (JOptionPane.showConfirmDialog(null, "Are you sure you want to exit the program?", null, 0, 1) == 0) {
			if( getOfficeEmpID() != 0 )
			{
				getMainClass().getLoginModel().logoutUser();
			}
			System.exit(0);
		}
	}

	@Override
	public void windowClosed(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowIconified(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowDeiconified(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowActivated(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowDeactivated(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}
}
