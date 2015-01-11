package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import view.AddPersonnelView;
import model.AddPersonnelModel;
import controller.HomeController;

public class AddPersonnelController implements ActionListener {
	
	private AddPersonnelView view;
	private AddPersonnelModel model;
	private HomeController controller;
	
	public AddPersonnelController( HomeController controller, AddPersonnelModel model, AddPersonnelView view ) {
		this.view = view;
		this.model = model;
		this.setController(controller);
		connectViewController();
	}
	
	public void connectViewController() {
		view.addControllers( this );
	}
	
	public void actionPerformed(ActionEvent e)
	{
		if( e.getSource() == view.getOK() ) {
			String first = view.getFirstField().getText().trim();
			String last = view.getLastField().getText().trim();
			String office = (String) view.getOfficeList().getSelectedItem();
			office = office.trim();
			String position = view.getPosiField().getText().trim();
			if( first.isEmpty() || last.isEmpty() || office.isEmpty() || position.isEmpty() )
				JOptionPane.showMessageDialog( null, "All fields are required." );
			else {
				model.addToDatabase( first, last, office, position );
				int result = JOptionPane.showConfirmDialog(null, "Database successfully updated! Do you want to add a new entry?", "Success", JOptionPane.YES_NO_OPTION );
				if( result == 0 ) {
					AddPersonnelModel addPersonnelModel = new AddPersonnelModel();
					AddPersonnelView addPersonnelView = new AddPersonnelView();
					addPersonnelView.setOffices(getController().getModel().getOffice(), addPersonnelModel.getOffices());
					addPersonnelView.addOfficeComboBox();
					new AddPersonnelController( getController(), addPersonnelModel, addPersonnelView );
					getController().getView().changePanel(view, addPersonnelView);
				}
				else {
					getController().getView().getNewPanel().remove( getController().getView().getNewPanel().getComponentAt(0,0) );
				}
			}
		}
	}

	public HomeController getController() {
		return controller;
	}

	public void setController(HomeController controller) {
		this.controller = controller;
	}
	
}
