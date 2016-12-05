package ships;
import base.*;
import java.util.ArrayList;

public class AirCraftCarrier extends Ship {
	private ArrayList<Plane> Planes;
	
	public AirCraftCarrier(){
		//The variables in Equipment
			this.setSize(5);	
			this.setName("Aircraft Carrier");					//Set the name
			//When is the location array set?		
			for(int i = 0; i < this.getSize(); ++i) {
				this.getHits().add(false);
			}
			//ownedBy is be set in the driver.

		//The variables in Ship
			//Direction is set in the driver.
			//Sunk is set in Ship class.			
			this.setSpecialsLeft(2);
			
		//The variables in AirCraftCarrier
			Planes = new ArrayList<Plane>();
	}	
	
	public void Exocet(boolean firingPattern, Coordinate centerCoor, GameBoard board){
		//FIXME
		
		// I changed it so that the window can ask the user which firingPattern
		// And if they say in the shape of a cross, "firingPattern" will be true
		// If they say in the shape of an X, "firingPattern" will be false
		
		/*
		 * The Aircraft Carrier is able to fire 2 Exocet Missiles per game, 
		 * which can attack multiple spots in the opponent's grid at once each 
		 * Exocet will target 5 squares in the opponent’s grid. The player has 
		 * the choice of attacking with the firing pattern that resembles an “X” 
		 * or a cross. If the player’s Carrier is destroyed before both Exocet 
		 * missiles are used, the missiles will be lost along with the Carrier.
		 */
		
		/*
		 *  IN THE GUI:
		 *  
		 */
		
		int i = 0, j = 0, k =0;
		int sizeOfHitArrayList = 0;
		if(this.getSpecialsLeft() > 0) {			//There are exocet missiles that you can fire :)
			
			this.setSpecialsLeft(this.getSpecialsLeft()-1); //Update the amount of specials left
			
			if (this.getSpecialsLeft() <= 0) {				//Deactivate button if no specials are left???
				//Deactivate button??
				//Simply print out an error msgs when you try to press the button again??
				//Find out in the next episode of DBZ!!!
			}
			
			if (firingPattern == true) {		//attack using a firing pattern that resembles a cross	

				//FIRING IN A CROSS: This fires in the horizontal direction of that cross
				j = centerCoor.getCoord().getLetter();	//Row stays the same
				for(i = centerCoor.getCoord().getNum() - 1; i <= centerCoor.getCoord().getNum() + 1; i++) {	//iterates through the column above and below the column that was selected
					if((i >= 0) && (i < 10)) {	//if the location is within the bounds
						if(board.getSpaces()[i][j].getBeenHit() == false) {			//If this location hasn't been hit
							board.getSpaces()[i][j].setBeenHit(true);			//hit the spot that is occupied
							if(board.getSpaces()[i][j].getisOccupied() == true){ 	//checks if this location is occupied by something
								
								sizeOfHitArrayList = board.getSpaces()[i][j].getIsOccupiedBy().getHits().size(); 
								for (k = 0; k < sizeOfHitArrayList; k++){		//We need to update the hits array of enemy's ship we hit
									if(board.getSpaces()[i][j].getIsOccupiedBy().getHits().get(k) == false) {	//Finds the first item listed as "false" and updates it to true
										board.getSpaces()[i][j].getIsOccupiedBy().getHits().set(k, true); 	//sets one of the arrayList's items to true (meaning it's true that it has been hit)
										if(k == sizeOfHitArrayList - 1){	//if k = the last spot in that arrayList, that means the entire array is filled with "trues" which means the entire ship has been sunk!!!! 
											board.getSpaces()[i][j].getIsOccupiedBy().setSunk(true);		//So change the sunk variable from false to true
										}
										break;
									}
								}
							}
						}
					}	
				}
				
				//FIRING IN A CROSS: This fires in the vertical direction of that cross
				i = centerCoor.getCoord().getNum();	//Column stays the same
				for(j = centerCoor.getCoord().getLetter() - 1; j <= centerCoor.getCoord().getLetter() + 1; j++){ //iterates through the row above and below the row that was selected
					if((j >= 0) && (j < 10)) {	//if the location is within the bounds
						if(board.getSpaces()[i][j].getBeenHit() == false) {			//If this location hasn't been hit
							board.getSpaces()[i][j].setBeenHit(true);			//hit the spot that is occupied
							if(board.getSpaces()[i][j].getisOccupied() == true){ 	//checks if this location is occupied by something
								
								sizeOfHitArrayList = board.getSpaces()[i][j].getIsOccupiedBy().getHits().size(); 
								for (k = 0; k < sizeOfHitArrayList; k++){		//We need to update the hits array of enemy's ship we hit
									if(board.getSpaces()[i][j].getIsOccupiedBy().getHits().get(k) == false) {	//Finds the first item listed as "false" and updates it to true
										board.getSpaces()[i][j].getIsOccupiedBy().getHits().set(k, true); 	//sets one of the arrayList's items to true (meaning it's true that it has been hit)
										if(k == sizeOfHitArrayList - 1){	//if k = the last spot in that arrayList, that means the entire array is filled with "trues" which means the entire ship has been sunk!!!! 
											board.getSpaces()[i][j].getIsOccupiedBy().setSunk(true);		//So change the sunk variable from false to true
										}
										break; //break out of this arrayList for loop
									}
								}
							}
						}
					}
			
				}				
			}
			
			else if (firingPattern == false) {	//attack using a firing pattern that resembles an X	
				int n = centerCoor.getCoord().getLetter();	//m equals the Letter / row that the user selected to hit
				int m = centerCoor.getCoord().getNum();		//n equals the Number / column that the user selected to hit
				
				for(j = centerCoor.getCoord().getLetter() - 1; j <= centerCoor.getCoord().getLetter() + 1; j++){ //iterates through the row above and below the row that was selected  
					for(i = centerCoor.getCoord().getNum() - 1; i <= centerCoor.getCoord().getNum() + 1; i++) {	//iterates through the column above and below the column that was selected
						if((i >= 0) && (i < 10) && (j >= 0) && (j < 10)) {	//if the location is within the bounds
							//FIRE!!! make it so that it fires in an X
							
							/* Okay so incredible inefficient but idk how to do it in any other way .-.
							 * The way that I'm doing it is if the space it is iterating through is
							 * one of the spaces that forms the X, check / fire at it.
							 * 
							 * I broke it into three if, else if statements.
							 * The first if statement checks the top left & top right corners of the X
							 * The second if statement checks the center of the X
							 * The third if statement checks the bottom left & bottom right corners of the X
							 */

							//If the space is the top left corner of the X or top right corner of the X, check / fire.
							if(((i == m-1) && (j == n-1)) || ((i== m-1) && (j == n+1))){		
								if(board.getSpaces()[i][j].getBeenHit() == false) {			//If this location hasn't been hit
									board.getSpaces()[i][j].setBeenHit(true);			//hit the spot that is occupied
									if(board.getSpaces()[i][j].getisOccupied() == true){ 	//checks if this location is occupied by something

										
										sizeOfHitArrayList = board.getSpaces()[i][j].getIsOccupiedBy().getHits().size(); 
										for (k = 0; k < sizeOfHitArrayList; k++){		//We need to update the hits array of enemy's ship we hit
											if(board.getSpaces()[i][j].getIsOccupiedBy().getHits().get(k) == false) {	//Finds the first item listed as "false" and updates it to true
												board.getSpaces()[i][j].getIsOccupiedBy().getHits().set(k, true); 	//sets one of the arrayList's items to true (meaning it's true that it has been hit)
												if(k == sizeOfHitArrayList - 1){	//if k = the last spot in that arrayList, that means the entire array is filled with "trues" which means the entire ship has been sunk!!!! 
													board.getSpaces()[i][j].getIsOccupiedBy().setSunk(true);		//So change the sunk variable from false to true
												}
												break;
											}
										}
									}
								}
							}
							
							//If the space is the center X (aka the spot the user hit), check / fire.
							else if((i == m) && (j == n)){										
								if(board.getSpaces()[i][j].getBeenHit() == false) {			//If this location hasn't been hit
									board.getSpaces()[i][j].setBeenHit(true);			//hit the spot that is occupied
									if(board.getSpaces()[i][j].getisOccupied() == true){ 	//checks if this location is occupied by something
										
										sizeOfHitArrayList = board.getSpaces()[i][j].getIsOccupiedBy().getHits().size(); 
										for (k = 0; k < sizeOfHitArrayList; k++){		//We need to update the hits array of enemy's ship we hit
											if(board.getSpaces()[i][j].getIsOccupiedBy().getHits().get(k) == false) {	//Finds the first item listed as "false" and updates it to true
												board.getSpaces()[i][j].getIsOccupiedBy().getHits().set(k, true); 	//sets one of the arrayList's items to true (meaning it's true that it has been hit)
												if(k == sizeOfHitArrayList - 1){	//if k = the last spot in that arrayList, that means the entire array is filled with "trues" which means the entire ship has been sunk!!!! 
													board.getSpaces()[i][j].getIsOccupiedBy().setSunk(true);		//So change the sunk variable from false to true
												}
												break;
											}
										}
									}
								}
							}				
							
							//If the space is the bottom left corner of the X or bottom right corner of the X, check / fire.
							else if(((i == m+1) && (j == n-1)) || ((i== m+1) && (j == n+1))){	
								if(board.getSpaces()[i][j].getBeenHit() == false) {			//If this location hasn't been hit
									board.getSpaces()[i][j].setBeenHit(true);			//hit the spot that is occupied
									if(board.getSpaces()[i][j].getisOccupied() == true){ 	//checks if this location is occupied by something
										
										sizeOfHitArrayList = board.getSpaces()[i][j].getIsOccupiedBy().getHits().size(); 
										for (k = 0; k < sizeOfHitArrayList; k++){		//We need to update the hits array of enemy's ship we hit
											if(board.getSpaces()[i][j].getIsOccupiedBy().getHits().get(k) == false) {	//Finds the first item listed as "false" and updates it to true
												board.getSpaces()[i][j].getIsOccupiedBy().getHits().set(k, true); 	//sets one of the arrayList's items to true (meaning it's true that it has been hit)
												if(k == sizeOfHitArrayList - 1){	//if k = the last spot in that arrayList, that means the entire array is filled with "trues" which means the entire ship has been sunk!!!! 
													board.getSpaces()[i][j].getIsOccupiedBy().setSunk(true);		//So change the sunk variable from false to true
												}
												break;
											}
										}
									}
								}
							}
							
							
							
						}
					}
				}
			}
		}
		
		else {	//No exocet missiles are left
			//So either an error message will pop up 
			//OR this will never occur since we would have deactivated this ability button
		}
		
		return;
	}
}
