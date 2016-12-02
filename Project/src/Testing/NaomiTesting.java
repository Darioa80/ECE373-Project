package Testing;

import javax.swing.JButton;

import base.*;
import ships.*;

public class NaomiTesting {
	public static void main(String[] args) {
		
		
		BattleshipMainGUI newGUI = new BattleshipMainGUI();
		
		GameBoard userBoard = new GameBoard();	//Set the user's board
		GameBoard compBoard = new GameBoard();	//Set the computer's board
		
		
		for(int i = 0; i < 10; i++) {
			for(int j=0; j < 10; j++) {
				String buttonName = new String(Character.toString((char) (i + 65)));
				buttonName = buttonName.concat(Integer.toString(j+1));
								
				System.out.println(buttonName);
			}
		}
		//User's Aircraft Carrier
			AirCraftCarrier userAirCraft = new AirCraftCarrier();
			userAirCraft.setOwner(true);
			Coordinate userAirCraftCoordinate = new Coordinate();
			Location userAirCraftLocation = new Location();
			
			//"Where would you like to place your AirCraftCarrier?": 			A1
			userAirCraftLocation = new Location(0,0);
			userAirCraftCoordinate.setCoord(userAirCraftLocation);
			
			//"Would you like to place the ship vertically or horizontally?": 	Horizontally, aka false
			userAirCraft.setDir(false);
			userAirCraft.setShip(userAirCraftCoordinate, userBoard);	//Set's ALL of the ships locations
			
		//Computer's Submarine
			Submarine compSubmarine = new Submarine();
			compSubmarine.setOwner(false);
			Coordinate compSubmarineCoordinate = new Coordinate();
			Location compSubmarineLocation = new Location();
			
			//"Where would you like to place your AirCraftCarrier?": 			A10
			compSubmarineLocation = new Location(0, 9);
			compSubmarineCoordinate.setCoord(compSubmarineLocation);
			
			//"Would you like to place the ship vertically or horizontally?": 	Vertically, aka true
			compSubmarine.setDir(true);
			compSubmarine.setShip(compSubmarineCoordinate, compBoard);
			
			
		//User shoots the computer's screen with the aircraft carrier
			Coordinate shootCoor = new Coordinate();
			Location shootLocation = new Location(1,8);
			shootCoor.setCoord(shootLocation);
			
			userAirCraft.Exocet(false, shootCoor, compBoard);
			
			boolean result;
		//Computer shoots the user's screen with Submarine 
			Coordinate compShootCoor = new Coordinate();
			Location compShootLocation = new Location(1,1);
			compShootCoor.setCoord(compShootLocation);
			
			//compSubmarine.Torpedo(compShootCoor, true, userBoard);
			
			result = compSubmarine.Sonar(compShootCoor, userBoard);
			if(result == false) {
				System.out.println("No ships were found");
			}
			else {
				System.out.println("One or more ships were located in this area.");
			}

			
		//User shoots the computer's screen with the aircraft carrier
			userAirCraft.Exocet(true, shootCoor, compBoard);

			
		//Computer shoots the user's screen with Submarine
			compShootLocation.setLetter(1);
			compSubmarine.Torpedo(compShootCoor, false, userBoard);
	
	}
}
