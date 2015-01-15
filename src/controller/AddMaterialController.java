package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import view.AddMaterialView;
import model.AddMaterialModel;

public class AddMaterialController implements ActionListener {
	
	private AddMaterialView view;
	private AddMaterialModel model;
	private HomeController controller;
	
	public AddMaterialController( HomeController controller, AddMaterialModel model, AddMaterialView view ) {
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
			try {
				String item_no = view.getItem_no().getText().trim();
				String materialName = view.getMaterialName().getText().trim();
				String desc = view.getDesc().getText().trim();
				String category = (String) view.getCategory().getSelectedItem();
				category = category.trim();
				String unit = view.getUnit().getText().trim();
				String priceString = view.getPrice().getText().trim();
				if( item_no.isEmpty() || materialName.isEmpty() || category.isEmpty() || unit.isEmpty() || priceString.isEmpty() )
					JOptionPane.showMessageDialog( null, "All fields are required." );
				else {
					float price = Float.parseFloat(priceString);
					model.addToDatabase( getController().getController().getOfficeEmpID(), item_no, materialName, desc, category, unit, price );
					view.getItem_no().setText(model.getItemNo());
					int result = JOptionPane.showConfirmDialog(null, "Database successfully updated! Do you want to add a new entry?", "Success", JOptionPane.YES_NO_OPTION );
					if( result == 0 ) {
						AddMaterialModel addMaterialModel = new AddMaterialModel();
						AddMaterialView addMaterialView = new AddMaterialView();
						addMaterialView.setCategoryList(addMaterialModel.getCategories());
						addMaterialView.addCategoryComboBox();
						new AddMaterialController( getController(), addMaterialModel, addMaterialView );
						getController().getView().changePanel(view, addMaterialView);
					}
					else {
						getController().getView().getNewPanel().remove( getController().getView().getNewPanel().getComponentAt(0,0) );
					}
				}
			}
			catch( NumberFormatException nfE ) {
				JOptionPane.showMessageDialog( null, "Please input a valid price." );
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
