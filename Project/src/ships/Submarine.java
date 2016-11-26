package ships;
import base.*;

public class Submarine extends Ship{
	public int torpedoesLeft;
	
	public Submarine() {
		this.setSize(3);
		torpedoesLeft = 2;
	}
	
	public boolean Torpedo(Coordinate spotChosen){
		//FIXME
		//In the GUI:
		//"Pick a spot along the edges of the grid."
		/*
		 * if (spot != along the edge) {
		 * 		Window("Error, the location you selected is not on the edge. 
		 * 				Please select a location on the edge of the grid."
		 * }
		 * if ((spot == A1) || (spot == A10) || (spot == J1) || (spot == J10)) {
		 * 
		 * 
		 */
		
		
		/*
		 * For the Torpedo, a spot at the edge of the grid will be chosen. 
		 * The direction of the Torpedo depends on the spot that is selected 
		 * along the edges. If a spot is selected along the vertical edges 
		 * of the grid, the Torpedo will fire at the corresponding row. If a 
		 * spot is selected along the horizontal edges, the Torpedo will fire 
		 * at the corresponding column. Once a column/row has been decided 
		 * the Torpedo will then hit every spot from one end of the grid 
		 * until either it hits an enemy ship in that row/column or it reaches 
		 * the other edge of the grid. If an enemy ship is hit, fire from the 
		 * Torpedo will stop. The player can only fire two Torpedoes per game 
		 * and are lost if used or if the Submarine is sunk.
		 * 
		 */
		
		if(torpedoesLeft > 0) {
			/* SHOOT THE FUCK OUT OF THOSE SPACES
			 * If the spot chosen = a corner (A1, A10, J1, J10 / 1,1 ; 1,10 ; 10,1 ; 10,10)
			 * Ask the user whether to shoot vertically or horizontally
			 * if() 
			 * 
			 */
			//			
			
			
		}
		else { //no torpedoes left :'(
			//Return an error message??
		}
		
		
		torpedoesLeft = torpedoesLeft - 1;
		if (torpedoesLeft <= 0) {
			//Deactivate button??
			//Simply print out an error msgs when you try to press the button again??
			//Find out in the next episode of DBZ!!!
		}
		
		return true;
	}
	public boolean Sonar(){
		//FIXME
		return true;
	}
}
