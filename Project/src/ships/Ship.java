package ships;
import base.*;


public abstract class Ship extends Equipment {
	private boolean direction;
	private boolean sunk;
	private int specialsLeft;
	
	//default contructor
	public Ship(){
		super();
		direction = true;
		sunk = false;
		specialsLeft = 0;
	}
	
	//setters and getters
	public void setDir(boolean D){this.direction = D; return;}
	public void setSunk(boolean S){this.sunk = S; return; }
	public void setSpecialsLeft(int left){this.specialsLeft = left; return; }
	
	public boolean getDir(){return this.direction; }
	public boolean getSunk(){return this.sunk; }
	public int getSpecialsLeft () {return this.specialsLeft;}
	
	
	
	
	public void place(GameBoard Board){
		Location loc;
		//this part is just a placeholder for user input.
		//I will change it when the project is further along.
		
		
		//for now True coresponds to vertical and false coresponsed to horizontal
		loc = new Location();
		loc.setLetter('1');
		loc.setNum('1');
		
		
		
		// I will need a completed board class to finish this but the psuedo code will look like this:
		//while(true){
		//I will probably place the user input code here. and make it loop until the user places the
		//the ship in a valid location
		
		//basically all of this will check to see if the place you are trying to place the ship is valid
		//before assigning the ship to that location. it will also assigned the ship to the subsequent 
		//spaces it will occupy on the board.
		//if (Board.Coord[loc.getLetter * 10 + loc.getNum - 1].isOccupied() == true)
		//else if (this.direction = true && this.getsize() - loc.getNum() < 0 &&  )
		//else if (this.direction = false && this.getSize
		//}
		
		return;
		
		
		}
		
		
		
		
		
		
}
	
	
	
	


