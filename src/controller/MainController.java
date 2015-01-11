package controller;

import javax.swing.JPanel;

import view.*;

public class MainController {
	
	private MainClass mainClass;
	
	public MainController() {
		mainClass = new MainClass( this );
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
}
