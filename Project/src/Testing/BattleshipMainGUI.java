package Testing;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import base.*;
import ships.*;


public class BattleshipMainGUI extends JFrame {
	
	private JButton[][] userButtonGrid = new JButton[10][10];
	private JButton[][] enemyButtonGrid = new JButton[10][10];
	private int mode;
	
    JButton mainMenuButton;
    JButton helpButton;
    JButton restartButton;
    JButton abilityButton;
    
    public int ship;	//This iterates thru the OwnedShips ArrayList that the player has
    public JFrame frameAskForDirection;		//When a ship is lost at sea, it can ask the nearest ship for directions back home. JK it asks the player whether to set the ship vertically or horizontally
    
    //INITIALIZING THE GAME
    GameBoard userBoard;
    GameBoard compBoard;
    Player player;
	
	public BattleshipMainGUI(int modeSelected) {
		super("BATTLESHIP");
		final int width = 1500;
		final int height = 600;
		mode = modeSelected;
		setSize(width, height);
	    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    buildGUI();
	    setVisible(true);	    
	}

	private void buildGUI() {
		int i, j;
		getContentPane().setLayout(new BorderLayout());
		
		//INITIALIZING THE GAME
		userBoard = new GameBoard();	//Set the user's board
		compBoard = new GameBoard();	//Set the computer's board
		player = new Player();
		ship = 0;
		
		//TITLE:		
		JPanel titlePanel = new JPanel();
		JLabel title = new JLabel("BATTLESHIP");
		title.setFont(new Font("Impact", Font.PLAIN, 45));
		titlePanel.add(title);
		//USER PANEL:
	    JPanel userPanel = new JPanel();
	    userPanel.setLayout(new GridLayout(12,11));
	    
	    userPanel.add(new JLabel("\n"));		//All of these \n are me just trying to center it. When I tried making it all on the same line it didn't work .-.
	    userPanel.add(new JLabel("\n"));
	    userPanel.add(new JLabel("\n"));
	    userPanel.add(new JLabel("\n"));
	    userPanel.add(new JLabel("\n"));
	    userPanel.add(new JLabel("<HTML><p>Your Ships:<BR> </HTML>"));
	    userPanel.add(new JLabel("\n"));
	    userPanel.add(new JLabel("\n"));
	    userPanel.add(new JLabel("\n"));
	    userPanel.add(new JLabel("\n"));
	    userPanel.add(new JLabel("\n"));

	    
	    UserButtonListener userGridButtonListener = new UserButtonListener();
	    userPanel.add(new JLabel("\n"));
	    for(i = 0; i < 10; i++) {
	    	String Letters = new String("         " + Character.toString((char) (i + 65)));
	    	userPanel.add(new JLabel(Letters));
	    	
	    }
	    int k = 0;
		for(i = 0; i < 10; i++) {
			for(j = 0; j < 10; j++) {
				if(j ==0) {
					k = k + 1;
					userPanel.add(new JLabel("                " + Integer.toString(k)));
				}
				userButtonGrid[i][j] = new JButton(); 
				userButtonGrid[i][j].setBackground(new Color(175, 238, 238));
				userPanel.add(userButtonGrid[i][j]);
				userButtonGrid[i][j].addActionListener(userGridButtonListener);
			}
		}
	    
	    //ENEMY PANEL
	    JPanel enemyPanel = new JPanel();
	    JPanel enemyGridPanel = new JPanel();
	    enemyPanel.setLayout(new GridLayout(12,11));
	    
	    enemyPanel.add(new JLabel("\n"));
	    enemyPanel.add(new JLabel("\n"));
	    enemyPanel.add(new JLabel("\n"));
	    enemyPanel.add(new JLabel("\n"));
	    enemyPanel.add(new JLabel("\n"));
	    enemyPanel.add(new JLabel("Enemy:"));
	    enemyPanel.add(new JLabel("\n"));
	    enemyPanel.add(new JLabel("\n"));
	    enemyPanel.add(new JLabel("\n"));
	    enemyPanel.add(new JLabel("\n"));
	    EnemyButtonListener enemyGridButtonListener = new EnemyButtonListener();

	    enemyPanel.add(new JLabel("\n"));
	    enemyPanel.add(new JLabel("\n"));
	    for(i = 0; i < 10; i++) {
	    	String Letters = new String("         " + Character.toString((char) (i + 65)));
	    	enemyPanel.add(new JLabel(Letters));
	    }
	    k = 0;
		for(i = 0; i < 10; i++) {
			for(j = 0; j < 10; j++) {
				if(j ==0) {
					k = k + 1;
					enemyPanel.add(new JLabel("            " + Integer.toString(k)));
				}
				enemyButtonGrid[i][j] = new JButton(); 
				enemyButtonGrid[i][j].setBackground(Color.BLUE);
				enemyPanel.add(enemyButtonGrid[i][j]);
				enemyButtonGrid[i][j].addActionListener(enemyGridButtonListener);
			}
		}
	    
	    //GAME BUTTONS PANEL
	    JPanel gameButtonsPanel = new JPanel();	    
	    gameButtonsPanel.setLayout(new GridLayout(10,1));
	    
	    mainMenuButton = new JButton("Main Menu");
	    helpButton = new JButton("Help");
	    restartButton = new JButton("Restart");

	    mainMenuButton.addActionListener(new SideButtonsListener());
	    helpButton.addActionListener(new SideButtonsListener());
	    restartButton.addActionListener(new SideButtonsListener());
	    
	    gameButtonsPanel.add(mainMenuButton);
	    gameButtonsPanel.add(helpButton);
	    gameButtonsPanel.add(restartButton);
	    if(mode == 3) {
		    abilityButton = new JButton("Ability");
		    abilityButton.setBackground(Color.GREEN);
		    abilityButton.addActionListener(new SideButtonsListener());
	    	gameButtonsPanel.add(abilityButton);
	    }
	    
	    //SOUTH PANEL (Blank)
	    JPanel blankPanel = new JPanel();	//Just to make some space at the bottom of the window
	    
	    
	    getContentPane().add(titlePanel, BorderLayout.NORTH);
	    getContentPane().add(userPanel, BorderLayout.WEST);
	    getContentPane().add(enemyPanel, BorderLayout.CENTER);
	    getContentPane().add(gameButtonsPanel,BorderLayout.EAST);
	    getContentPane().add(blankPanel, BorderLayout.SOUTH);
	    
	    this.setVisible(true);
	    try{						//DELAY FOR 1 SECOND
	    	Thread.sleep(1000);
	    } catch (InterruptedException ex) {
	    	Thread.currentThread().interrupt();
	    }
	    handlePlacingShips();
	}
	public void handlePlacingShips() {
		//User's Aircraft Carrier
			AirCraftCarrier userAirCraft = new AirCraftCarrier();
			userAirCraft.setOwner(true);
			Coordinate userAirCraftCoordinate = new Coordinate();
			Location userAirCraftLocation = new Location();
			
			
			JOptionPane.showMessageDialog(null, "<HTML><center>Where would you like to place your " 
										+ player.getOwnedShips().get(ship).getName() + 
										"? It has a length of " + player.getOwnedShips().get(ship).getSize() + "." +
										"<BR> Please Select a location on your grid, the left grid, "
										+ "<BR>otherwise nothing will happen.</center></HTML>");
	}
	
	private class UserButtonListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			int i, j;
			Object source = e.getSource();
			
			for(i = 0; i < 10; i++) {
				for(j = 0; j < 10; j++){
					if (source == userButtonGrid[i][j]) {
						//FIXME
						//place(i,j);
						//setShip(Coordinate frontCoordinate, GameBoard Board)
						//But we first have to know what ship it is. 
						if(ship < 5) {	//Meaning we're still initializing the ships
							AskForDirectionFrame();
						}
						return;
					}
				}
			}
		}
	}
	
	private class EnemyButtonListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			int i, j;
			Object source = e.getSource();
			
			for(i = 0; i < 10; i++) {
				for(j = 0; j < 10; j++){
					if (source == enemyButtonGrid[i][j]) {
						
					}
				}
			}
		}
	}
	
	private class SideButtonsListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			Object source = e.getSource();
		    
			if (source == mainMenuButton) {
				int value;
				value = JOptionPane.showConfirmDialog(null, "Are you sure? Progress will be lost.", "plz don't leave", JOptionPane.YES_NO_OPTION); 					//Pop up window. "Are you sure? Game will be lost."
				if (value == JOptionPane.YES_OPTION) {				//If the person wants to to exit the game, they will be sent to the main menu
					dispose();
					setVisible(false);
					OpeningWindow mainMenu = new OpeningWindow();
					mainMenu.setVisible(true);
				}				
			}
			else if (source == helpButton) {
				if(mode == 1){
					RulesWindow rulesMenu = new RulesWindow(1);
				}
				else if(mode == 2){
					RulesWindow rulesMenu = new RulesWindow(2);
				}				
				else if(mode == 3){
					RulesWindow rulesMenu = new RulesWindow(3);
				}
			}
			else if (source == restartButton) {
				dispose();			//Close the current window
				setVisible(false);
				//FIXME
				BattleshipMainGUI newGame = new BattleshipMainGUI(mode);	//This should work, right??
			}
			else if (source == abilityButton) {
				AbilitiesWindow abilitiesMenu = new AbilitiesWindow();
				abilitiesMenu.setVisible(true);
			}
		}
	}
	public void AskForDirectionFrame() {
		frameAskForDirection = new JFrame("Select the direction to place your ship");
		JButton vertically = new JButton("Vertically");
		vertically.addActionListener(new directionButtonListener());
		
		JButton horizontally = new JButton("Horizontally");
		horizontally.addActionListener(new directionButtonListener());
		
		JLabel words = new JLabel("<HTML><center>Would you like to place the ship vertically or horizontally?</center></HMTL>");
		
		JPanel panel = new JPanel();
		frameAskForDirection.setSize(375,100);
		panel.add(words);
		panel.add(vertically, new FlowLayout(FlowLayout.CENTER));
		panel.add(horizontally,new FlowLayout(FlowLayout.CENTER));
		
		frameAskForDirection.add(panel);
		pack();
		frameAskForDirection.setVisible(true);
		super.setSize(1500,600);
		
	}
	private class directionButtonListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			String actionCommand = e.getActionCommand();
			if(actionCommand.equals("Vertically")) {
				player.getOwnedShips().get(ship).setDir(true);
			}
			else if(actionCommand.equals("Horizontally")) {
				player.getOwnedShips().get(ship).setDir(false);
			}
			frameAskForDirection.dispose();
			frameAskForDirection.setVisible(false);
			
			//FIXME SET SHIP
			
			ship = ship + 1;
			if(ship <5) {
				handlePlacingShips();
			}
		}
	}
}

