package ships;
import base.*;


public abstract class Ship extends Equipment {
	private boolean direction;
	private boolean sunk;
	private int specialsLeft;
	private int size; //NAOMI ADDED THIS, it's the size of the ship (AirCraftCarrier = 5, Battleship = 4 , Destroyer & Submarine = 3, PTBoat = 2)
	public static final int GRID_HEIGHT = 10;
	public static final int GRID_WIDTH = 10;
	
	
	//default constructor
	public Ship(){
		super();
		direction = true;
		sunk = false;
		specialsLeft = 0;
		size = 0;	//NAOMI ADDED THIS
	}
	
	//setters and getters
	public void setDir(boolean D){this.direction = D; return;}
	public void setSunk(boolean S){this.sunk = S; return; }
	public void setSpecialsLeft(int left){this.specialsLeft = left; return; }
	public void setSize(int shipLength) {this.size = shipLength;}	//NAOMI ADDED THIS
	
	public boolean getDir(){return this.direction; }
	public boolean getSunk(){return this.sunk; }
	public int getSpecialsLeft () {return this.specialsLeft;}
	public int getSize() {return size;}	//NAOMI ADDED THIS
	
	
	
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
		
		
	public void setShip(Coordinate frontCoordinate, boolean direction){	//This function will be used to place the ships in the grid.
		int size = this.getSize();  //gets the size of the ship
		int i;
		int j;
		if(direction == false){ //if direction is horizontal 
			if ((frontCoordinate.getCoord().getNum() + size) > (GRID_WIDTH - 1)){	//minus 1 because the grid goes from 0-9 not 1-10
			System.out.println("Coordinate is out of bounds, pick a different Coordinate or direction.");
			return;
				}
			else {
				for (i = 0; i < size; i++){	//iterates through the columns due to horizontal displacement.
					GameBoard.Spaces[frontCoordinate.getCoord().getLetter()][frontCoordinate.getCoord().getNum()+i].setIsOccupiedBy(this);
					GameBoard.Spaces[frontCoordinate.getCoord().getLetter()][frontCoordinate.getCoord().getNum()+i].setIsOccupied(true);
				}
			}

			}
		else{	//direction is vertical
			if((frontCoordinate.getCoord().getLetter()+size) > (GRID_HEIGHT -1)){
				System.out.println("Coordinate is out of bounds, pick a different Coordinate or direction.");
				return;	
			}
			else {
				for (j = 0; j < size; j++){		//iterates through rows
					GameBoard.Spaces[frontCoordinate.getCoord().getLetter()+j][frontCoordinate.getCoord().getNum()].setIsOccupiedBy(this);
					GameBoard.Spaces[frontCoordinate.getCoord().getLetter()+j][frontCoordinate.getCoord().getNum()].setIsOccupied(true);
				}
			}
		}
		
		
	}
		
		
		
}
	
	
	
	


