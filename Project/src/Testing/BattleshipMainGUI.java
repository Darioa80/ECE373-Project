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
    public GameBoard userBoard;
    public GameBoard compBoard;
    public Player player;
    public Oponent enemy;
    public int turn;
	
    private boolean dirHasBeenChosen = false;
    private Coordinate coor;
    
    public boolean gameOn = false;		//If true, it means the player has set all the ships and is ready to play. 
    
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
		enemy = new Oponent();
		//enemy.setShips(coor, userBoard);
		
		//SET THE ENEMIES SHIP
		
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
	    String buttonName;
		for(i = 0; i < 10; i++) {			//iterates through rows aka nums
			for(j = 0; j < 10; j++) {		//iterates through columns aka letter
				if(j ==0) {
					k = k + 1;
					userPanel.add(new JLabel("                " + Integer.toString(k)));
				}
				buttonName = Character.toString((char) (j + 65));
				buttonName = buttonName.concat(Integer.toString(i+1));
				
				userButtonGrid[i][j] = new JButton(buttonName); 
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
				buttonName = Character.toString((char) (j + 65));
				buttonName = buttonName.concat(Integer.toString(i+1));
				
				enemyButtonGrid[i][j] = new JButton(buttonName); 
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
	    
	    handlePlacingShips();		//Calling the JFrame that tells the user to click where they want to place their ships
	}
	
	public void handlePlacingShips() {
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
			for(i = 0; i < 10; i++) {		//rows
				for(j = 0; j < 10; j++){	//columns
					if (source == userButtonGrid[i][j]) {
						coor = new Coordinate();
						Location loc = new Location(i,j);
						coor.setCoord(loc);	
						if(gameOn == false) {
							if(userBoard.getSpaces()[i][j].getisOccupied() == true) {		//Space clicked on is occupied :(
								JOptionPane.showMessageDialog(null, "<HTML><center>The desired coordinate is occupied,"
										+ "<BR> choose a new coordinate or direction for " 
										+ player.getOwnedShips().get(ship).getName() + "</center></HTML>");
								handlePlacingShips();
							}
							else if(userBoard.getSpaces()[i][j].getisOccupied() == false) {	//Space clicked on is clear!!
								SelectDirectionFrame();
								//FIXME CJ, idk anything about the planes placement and shit							
							}
						}
						else if (mode == 3) {
							//FIXME CJ, idk anything about the planes shooting and stuff
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
						if(gameOn == true) {		//If the game has started, it's time to fire some shots pew pew
							if(turn % 2 == 0) {		//User's turn
								coor = new Coordinate();
								Location loc = new Location(i,j);
								coor.setCoord(loc);
								if(Shoot() == -1) {
									JOptionPane.showMessageDialog(null, "<HTML><center>You've already hit this spot!"
															+ "<BR> Why not try a new location?</center></HTML>");
								}
								else if(Shoot() == 0){
									//missed!
									turn++;
								}
								else {
									//SHOT! They get to go again
								}
							}
							else {	//Computers turn
								//enemy.shoot(userBoard);
							}
						}
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
			else if (source == helpButton) {								//Calls the appropriate RulesWindow based on the mode that was selected
				RulesWindow rulesMenu = new RulesWindow(mode);			
				rulesMenu.setVisible(true);
			}
			else if (source == restartButton) {								//Starts a brand spanking new game
				dispose();			//Close the current window
				setVisible(false);
				BattleshipMainGUI newGame = new BattleshipMainGUI(mode);
			}
			else if (source == abilityButton) {								//Calls the abilities window
				if(gameOn == true) {
					if (turn % 2 == 0) {	//User's turn!
						AbilitiesWindow abilitiesMenu = new AbilitiesWindow(player, compBoard, enemyButtonGrid);
						abilitiesMenu.setVisible(true);
					}
					else {	//Computers turn
						JOptionPane.showMessageDialog(null, "<HTML><center>You have to wait your turn before using an ability.</center></HTML>");
					}
				}
				else {		//Ships aren't initialized yet
					JOptionPane.showMessageDialog(null, "<HTML><center>You have to set your ships first "
												+ "<BR>before attacking the enemy!</center></HTML>");
				}
			}
		}
	}
	
	public void checkEnemyBoardChanges() {
		//Checks the whole board after the ability button has been pressed.
		//If a new board location has been hit, change its color 
		int i, j;
		for(i = 0; i < 10; i++) {
			for(j = 0; j < 10; j++) {
				if (compBoard.getSpaces()[i][j].getBeenHit() == true) {
					if (compBoard.getSpaces()[i][j].getisOccupied() == true) {
						enemyButtonGrid[i][j].setBackground(Color.RED);
					}
					else {
						enemyButtonGrid[i][j].setBackground(Color.WHITE);
					}
				}
			}
		}
	}

	public void SelectDirectionFrame() {
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
			dirHasBeenChosen = true;		//the user has selected the direction 
			frameAskForDirection.dispose();
			frameAskForDirection.setVisible(false);
			
			checkPlacingSuccess();			//Checks if placing the ship was a success and if it wasn't an error message pops up
		}
	}
	
	public void checkPlacingSuccess() {
		//Checks if placing the ship was a success and if it wasn't an error message pops up
		
		int settingWasSuccessful;
		
		if(dirHasBeenChosen == true) {
			settingWasSuccessful = player.getOwnedShips().get(ship).setShip(coor, userBoard);	//Checks to see if all the locations the ship will get set in are clear to get set
			if(settingWasSuccessful == 0) {	//Setting was a success!
				initButtonColor();			//Change the colors of the buttons
				if(ship == 4) {				//All ships have been set!
					JOptionPane.showMessageDialog(null, "<HTML><center>Excellent! All your ships have been set. "
										+ "Time to demolish the enemy.</center></HTML>");
					gameOn = true;			//Time to shoot some villains!!
				}
				ship = ship + 1;			//Go to the next ship in the player's ships arrayList
				dirHasBeenChosen = false;
				if(ship <5) {				//If we're still placing ships on the board, call this function to let the user know what ship is going to get set next
					handlePlacingShips();
				}
				
			}
			else if (settingWasSuccessful == 1) {		//One of the locations is occupied
				JOptionPane.showMessageDialog(null, "<HTML><center>One of the desired coordinates is occupied,"
										+ "<BR> choose a new coordinate or direction for " 
										+ player.getOwnedShips().get(ship).getName() + "</center></HTML>");
				dirHasBeenChosen = false;
				handlePlacingShips();
			}
			else if (settingWasSuccessful == 2) {		//One of the locations would be off the board
				JOptionPane.showMessageDialog(null, "<HTML><center>Coordinate is out of bounds," 
										+ "<BR>pick a different Coordinate or direction.</center></HTML>");
				dirHasBeenChosen = false;
				handlePlacingShips();
			}
		}
	}
	
	public void initButtonColor() {
		//After the person clicks where to set their ship,
		//this function changes the color of those locations 
		//from blue to grey
		int i;
		int m, n;
		int size;
		boolean dir;
		
		m = player.getOwnedShips().get(ship).getLocation().get(0).getLetter();
		n = player.getOwnedShips().get(ship).getLocation().get(0).getNum();
		size = player.getOwnedShips().get(ship).getSize();
		dir = player.getOwnedShips().get(ship).getDir();
		if(dir == true) { 		//Vertical
			//vertical so n stays the same. aka the letter
			for(i = 0; i <size; i++) {
				userButtonGrid[m+i][n].setBackground(Color.GRAY);
			}
		}
		else if(dir == false) {	//Horizontal
			//horizontal so m stays the same. aka the number
			for(i = 0; i <size; i++) {
				userButtonGrid[m][n+i].setBackground(Color.GRAY);
			}
		}
		
		return;
	}
	
	public int Shoot(){
		int i = coor.getCoord().getLetter();
		int j = coor.getCoord().getNum();
		if (compBoard.getSpaces()[i][j].getBeenHit() == true){		//Spot has been hit in the past! Return a message saying so
			return -1;
		}
		else {		//Spot hasn't been hit before!
			if (compBoard.getSpaces()[i][j].getisOccupied() == true){
				if (compBoard.getSpaces()[i][j].getIsOccupiedBy().getSunk() == false){
					for (int k = 0; k < compBoard.getSpaces()[i][j].getIsOccupiedBy().getHits().size(); k++){
						if (compBoard.getSpaces()[i][j].getIsOccupiedBy().getHits().get(k) == false){
							compBoard.getSpaces()[i][j].getIsOccupiedBy().setAHit(k, true);
							compBoard.getSpaces()[i][j].setBeenHit(true);
							enemyButtonGrid[i][j].setBackground(Color.RED);
							if (k == compBoard.getSpaces()[i][j].getIsOccupiedBy().getHits().size()){
								compBoard.getSpaces()[i][j].getIsOccupiedBy().setSunk(true);
							}		
							break;
						}
					}
				}
				else { //the ship has sunk. Theoretically should never get here.
					return -1;
				}
			}
			else {	//Not occupied
				enemyButtonGrid[i][j].setBackground(Color.WHITE);
				return 0;
			}
		}
		
		return 1;
	}
}

