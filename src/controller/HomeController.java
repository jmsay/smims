package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import view.*;
import model.*;
import controller.MainController;

public class HomeController implements ActionListener {
	
	private HomeView view;
	private MainController controller;
	private LoginModel model;
	
	public HomeController( MainController controller, HomeView view, LoginModel model ) {
		this.view = view;
		this.controller = controller;
		this.model = model;
		connectViewController();
		if( !getModel().getOffice().equalsIgnoreCase("Supply") )
		{
			getView().viewNonSupply();
		}
	}
	
	public void connectViewController() {
		getView().addControllers( this );
	}
	
	public void actionPerformed(ActionEvent e)
	{
//		if( e.getSource() == getView().getPri() ) {
//			getView().getNewPanel().remove( getView().getNewPanel().getComponentAt(0,0) );
//		}
		if( e.getSource() == getView().getMenuButtons()[0] ) {
			AddMaterialModel addMaterialModel = new AddMaterialModel();
			AddMaterialView addMaterialView = new AddMaterialView();
			addMaterialView.setCategoryList(addMaterialModel.getCategories());
			addMaterialView.addCategoryComboBox();
			new AddMaterialController( this, addMaterialModel, addMaterialView );
			getView().changePanel( getView().getNewPanel().getComponentAt(0,0), addMaterialView );
		}
		else if( e.getSource() == getView().getMenuButtons()[1] ) {
			AddStockModel addStockModel = new AddStockModel();
			AddStockView addStockView = new AddStockView();
			addStockView.setItems(addStockModel.getItems());
			addStockView.addItemsComboBox();
			new AddStockController( this, addStockModel, addStockView );
			getView().changePanel( getView().getNewPanel().getComponentAt(0,0), addStockView);
		}
		else if( e.getSource() == getView().getMenuButtons()[2] ) {
			InventorySupplyModel inventorySupplyModel = new InventorySupplyModel();
			inventorySupplyModel.getInventory("");
			InventorySupplyView inventorySupplyView = new InventorySupplyView();
			inventorySupplyView.setTableEntries(inventorySupplyModel.getInventoryArray());
//			inventorySupplyView.setTableEntries(inventorySupplyModel.getItemNoList(), inventorySupplyModel.getNameList(), inventorySupplyModel.getDescList(), inventorySupplyModel.getCategoryList(), inventorySupplyModel.getUnitList(), inventorySupplyModel.getPriceList(), inventorySupplyModel.getStockList());
			new InventorySupplyController( this, inventorySupplyModel, inventorySupplyView);
			getView().changePanel( getView().getNewPanel().getComponentAt(0, 0), inventorySupplyView);
		}
		else if( e.getSource() == getView().getMenuButtons()[3] ) {
			AddPersonnelModel addPersonnelModel = new AddPersonnelModel();
			AddPersonnelView addPersonnelView = new AddPersonnelView();
			addPersonnelView.setOffices(model.getOffice(), addPersonnelModel.getOffices());
			addPersonnelView.addOfficeComboBox();
			new AddPersonnelController( this, addPersonnelModel, addPersonnelView );
			getView().changePanel( getView().getNewPanel().getComponentAt(0,0), addPersonnelView );
		}
		else if( e.getSource() == getView().getLogoutBtn() ) {
			int result = JOptionPane.showConfirmDialog(null, "Are you sure you want to logout?", "Logout", JOptionPane.YES_NO_OPTION );
			if( result == 0 ) {
				getModel().logoutUser();
				LoginView loginView = new LoginView();
				new LoginController( getController(), loginView, getModel() );
				getController().changeView(getView(), loginView);
			}
		}
	}

	public HomeView getView() {
		return view;
	}

	public void setView(HomeView view) {
		this.view = view;
	}

	public MainController getController() {
		return controller;
	}

	public void setController(MainController controller) {
		this.controller = controller;
	}

	public LoginModel getModel() {
		return model;
	}

	public void setModel(LoginModel model) {
		this.model = model;
	}
}
