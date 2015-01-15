package view;

import java.awt.Component;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.awt.Font;

import controller.HomeController;

public class HomeView extends JPanel {
	
	ImageIcon bg, menuButtonIcon[] = new ImageIcon[5], menuROButtonIcon[] = new ImageIcon[5], logoutIcon, logoutROIcon;
	private JLabel mainbg;
	private JLabel dateTime;
	private JLabel userLabel;
	private JButton menuButtons[] = new JButton[5];
	private JButton logoutBtn;
	private JPanel newPanel;
	private String userName;
	private String officeName;

	public HomeView() {
		super();
		setLayout(null);
		setBounds(0, 0, 1024, 600);
		setOpaque(false);
		loadImages();
		initComponents();
		addComponents();
	}

	private void addComponents() {
		add(getNewPanel());
		add(getLogoutBtn());
		add(getUserLabel());
		add(getDateTime());
		for( int i = 0; i < 5; i++ )
			add( getMenuButtons()[i] );
		add( getBG() );
	}
	
	private void loadImages() {
		bg = new ImageIcon("images/bg/menuBg.png");
		menuButtonIcon[0] = new ImageIcon("images/buttons/addSupMat.png");
		menuROButtonIcon[0] = new ImageIcon("images/buttons/addSupMatRO.png");
		menuButtonIcon[1] = new ImageIcon("images/buttons/addStock.png");
		menuROButtonIcon[1] = new ImageIcon("images/buttons/addStockRO.png");
		menuButtonIcon[2] = new ImageIcon("images/buttons/viewInv.png");
		menuROButtonIcon[2] = new ImageIcon("images/buttons/viewInvRO.png");
		menuButtonIcon[3] = new ImageIcon("images/buttons/addPer.png");
		menuROButtonIcon[3] = new ImageIcon("images/buttons/addPerRO.png");
		menuButtonIcon[4] = new ImageIcon("images/buttons/genRep.png");
		menuROButtonIcon[4] = new ImageIcon("images/buttons/genRepRO.png");
		logoutIcon = new ImageIcon("images/buttons/logoutBtn.png");
		logoutROIcon = new ImageIcon("images/buttons/logoutRO.png");
	}

	private void initComponents() {
		setBG(new JLabel(bg));
		getBG().setBounds(0, 0, 1024, 575);

		setLogoutBtn( new JButton(logoutIcon) );
		setButton( getLogoutBtn(), logoutROIcon, 935, 65, 75, 29 );
		
		for(int i=0, y=135; i<5; i++, y+=33 ){
			menuButtons[i] = new JButton(menuButtonIcon[i]);
			if( i == 3 )
				y = 273;
			else if( i == 4 )
				y = 351;
			setButton( getMenuButtons()[i], menuROButtonIcon[i], 4, y, 214, 32 );
		}
		setNewPanel(new JPanel());
		getNewPanel().setBounds(221, 99, 801, 476);
		getNewPanel().setOpaque(false);
		getNewPanel().setFocusable(false);
		getNewPanel().setLayout(null);
		
		setUserLabel(new JLabel("Logged in as: " + getUserName() + "     " + getOfficeName()));
		getUserLabel().setBounds(6, 59, 600, 38);
		getUserLabel().setOpaque(false);
		getUserLabel().setFont( new Font("Serif", Font.PLAIN, 18));
		getUserLabel().setBorder(null);
		
		setDateTime(new JLabel());
		dateTime.setBounds(600, 59, 315, 38);
		dateTime.setOpaque(false);
		dateTime.setFont( new Font("Serif", Font.PLAIN, 18));
		dateTime.setBorder(null);
		dateTime.setHorizontalAlignment(SwingConstants.RIGHT);
		new Thread( new CurrentTime() ).start();
	}
	
	public class CurrentTime implements Runnable
	{
		public void run()
		{
			while( true ) {
				try {
					Date dNow = new Date( );
					SimpleDateFormat ft = new SimpleDateFormat ("EE, dd MMM yyyy hh:mm:ss a");
					getDateTime().setText( ft.format(dNow) );
					Thread.sleep( 1000 );
				} catch (InterruptedException e) {
					JOptionPane.showMessageDialog( null, "Error in current time display." );
				}
			}
		}
	}
	private void setButton(JButton button, ImageIcon rollover, int x, int y, int width, int height) {
		button.setBounds(x, y, width, height);
		button.setOpaque(false);
		button.setFocusable(false);
		button.setContentAreaFilled(false);
		button.setBorderPainted(false);
		button.setRolloverIcon(rollover);
	}
	
	public void addControllers( HomeController controller )
	{
		for( int i = 0; i < 5; i++ )
			getMenuButtons()[i].addActionListener( controller );
		getLogoutBtn().addActionListener( controller );
	}
	
	public void viewNonSupply()
	{
		getMenuButtons()[0].setVisible( false );
		getMenuButtons()[1].setVisible( false );
		getMenuButtons()[3].setVisible( false );
	}
	
	public void changePanel( Component oldPanel, JPanel panel ) {
		newPanel.setVisible(false);
		newPanel.remove(oldPanel);
		newPanel.add( panel );
		newPanel.setVisible( true );
		panel.setVisible( true );
		repaint();
		revalidate();
	}
	
	public JLabel getBG() {
		return mainbg;
	}

	private void setBG(JLabel mainbg) {
		this.mainbg = mainbg;
	}
	
	public JPanel getNewPanel() {
		return newPanel;
	}

	public void setNewPanel(JPanel newPanel) {
		this.newPanel = newPanel;
	}

	public JButton[] getMenuButtons() {
		return menuButtons;
	}

	public void setMenuButtons(JButton menuButtons[]) {
		this.menuButtons = menuButtons;
	}

	public JButton getLogoutBtn() {
		return logoutBtn;
	}

	public void setLogoutBtn(JButton logoutBtn) {
		this.logoutBtn = logoutBtn;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getOfficeName() {
		return officeName;
	}

	public void setOfficeName(String officeName) {
		this.officeName = officeName;
	}

	public JLabel getDateTime() {
		return dateTime;
	}

	public void setDateTime(JLabel dateTime) {
		this.dateTime = dateTime;
	}
	
	public JLabel getUserLabel() {
		return userLabel;
	}

	public void setUserLabel(JLabel userLabel) {
		this.userLabel = userLabel;
	}

	public void updateUserLabel() {
		getUserLabel().setText("Logged in as: " + getUserName() + "     " + getOfficeName());
	}
}
