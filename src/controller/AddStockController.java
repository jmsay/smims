package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import view.AddStockView;
import model.AddStockModel;
import controller.HomeController;

public class AddStockController implements ActionListener {
	
	private AddStockView view;
	private AddStockModel model;
	private HomeController controller;
	
	public AddStockController( HomeController controller, AddStockModel model, AddStockView view ) {
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
		if( e.getSource() == view.getOK() || e.getSource() == view.getAmount() ) {
			try {
				String item = (String) model.getItemIDs()[view.getItemList().getSelectedIndex()];
				item = item.trim();
				String amountString = view.getAmount().getText().trim();
				if( item.isEmpty() || amountString.isEmpty() )
					JOptionPane.showMessageDialog( null, "All fields are required." );
				else {
					int amount = Integer.parseInt(amountString);
					model.addToDatabase( getController().getController().getOfficeEmpID(), item, amount );
					int result = JOptionPane.showConfirmDialog(null, "Database successfully updated! Do you want to add a new entry?", "Success", JOptionPane.YES_NO_OPTION );
					if( result == 0 ) {
						AddStockModel addStockModel = new AddStockModel();
						AddStockView addStockView = new AddStockView();
						addStockView.setItems(addStockModel.getItems());
						addStockView.addItemsComboBox();
						new AddStockController( getController(), addStockModel, addStockView );
						getController().getView().changePanel(view, addStockView);
					}
					else {
						getController().getView().getNewPanel().remove( getController().getView().getNewPanel().getComponentAt(0,0) );
					}
				}
			} catch( NumberFormatException nfE ) {
				JOptionPane.showMessageDialog( null, "Please input a valid amount." );
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
