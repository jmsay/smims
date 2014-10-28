package controller;

import javax.swing.JPanel;

import view.*;
import model.*;

public class MainController {
	
	private MainClass mainClass;
	
	public MainController( MainClass mainClass ) {
		this.mainClass = mainClass;
	}
	
	public void changeView( JPanel view ) {
		getMainClass().setVisible(false);
		getMainClass().getLoginView().setVisible(false);
		getMainClass().add( view );
		getMainClass().repaint();
		getMainClass().revalidate();
		getMainClass().setVisible(true);
		getMainClass().remove(mainClass.getLoginView());
	}

	public MainClass getMainClass() {
		return mainClass;
	}

	public void setMainClass(MainClass mainClass) {
		this.mainClass = mainClass;
	}
}
