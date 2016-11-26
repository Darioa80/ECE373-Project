package Testing;

import base.*;
import ships.*;

public class NaomiTesting {
	public static void main(String[] args) {
		Coordinate idkCoordinate = new Coordinate();
		Location location = new Location();
		GameBoard userGameBoard = new GameBoard();
		
		/*
		 * this.Coord = new Location();
		 * this.isOccupied = false;
		 * this.isOccupiedBy = null;
		 */
		
		//idkCoordinate.setCoord(newLoc);
		AirCraftCarrier newAirCraft = new AirCraftCarrier();
		
		//"Where would you like to place your AirCraftCarrier?"
		//User enters A1
		location = new Location(1,1);
		idkCoordinate.setCoord(location);
		
		//"Would you like to place the ship vertically or horizontally?
		//User enters vertically, aka ship direction is "True" 		//for now True corresponds to vertical and false corresponds to horizontal
		newAirCraft.setDir(true);
		
		//newAirCraft.setLocation();
		
		//Okay so call a method (setAllLocations) that tries to set all the locations
		//Within that method call another method (CheckIfSpaceIsClear) that makes sure that the other spaces are free
		//And that all the spaces are within the board (in case they select space A10 and want the ship to be placed horizontally)
		//if one of the spaces is occupied or off the board, that method returns false 
		//A window then pops up and displays either "Could not place ship in desired location. One or more spaces are occupied."
		//or "Could not place ship in desired location. One or more spaces are off the board."
		//or idk SOMETHING occurs letting 
		
		userGameBoard.setSpace(idkCoordinate);
	}
}
