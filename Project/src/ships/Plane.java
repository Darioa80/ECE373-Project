package ships;
import java.util.ArrayList;

import base.*;


public class Plane extends Equipment {
	private boolean destroyed;
	private Location loc;
	
	
	public Plane(){
		super();
		
		this.destroyed = false;
		this.loc = new Location();	
	}

	
	//setters and getters
	public void setLoc(Location L){this.loc = L; return;}
	public void setDestroyed(boolean D){ this.destroyed = D; return;}
	
	public Location getLoc(){return this.loc;}
	public boolean isDestroyed(){return this.destroyed;}
	
	public ArrayList<Location> Scan(Location center, boolean pattern, GameBoard Board){
		ArrayList<Location> Hits = new ArrayList<Location>();
		Location Curr = new Location();
		Coordinate Grid [][] = new Coordinate[10][10];
		Grid = Board.getSpaces();
		
		
		//pattern true is for X pattern false is for +
		if(pattern){
			Curr.setLetter(center.getLetter() - 1);
			Curr.setNum(center.getNum() - 1);
			
			if(Grid[Curr.getLetter()][Curr.getNum()].getisOccupied()){
				Hits.add(Curr);
			}
			
			Curr.setLetter(center.getLetter() - 1);
			Curr.setLetter(center.getNum() + 1);
			
			if(Grid[Curr.getLetter()][Curr.getNum()].getisOccupied()){
				Hits.add(Curr);
			}
			
			Curr.setLetter(center.getLetter());
			Curr.setLetter(center.getNum());
			
			if(Grid[Curr.getLetter()][Curr.getNum()].getisOccupied()){
				Hits.add(Curr);
			}
			
			
			Curr.setLetter(center.getLetter() +1);
			Curr.setLetter(center.getNum() - 1);
			
			if(Grid[Curr.getLetter()][Curr.getNum()].getisOccupied()){
				Hits.add(Curr);
			}
			
			Curr.setLetter(center.getLetter() +1);
			Curr.setLetter(center.getNum() + 1);
			
			if(Grid[Curr.getLetter()][Curr.getNum()].getisOccupied()){
				Hits.add(Curr);
			}
			
			
			
			
		
		}
		else{
			
			Curr.setLetter(center.getLetter() -1);
			Curr.setLetter(center.getNum());
			
			if(Grid[Curr.getLetter()][Curr.getNum()].getisOccupied()){
				Hits.add(Curr);
			}
			
			Curr.setLetter(center.getLetter());
			Curr.setLetter(center.getNum() - 1);
			
			if(Grid[Curr.getLetter()][Curr.getNum()].getisOccupied()){
				Hits.add(Curr);
			}
			Curr.setLetter(center.getLetter());
			Curr.setLetter(center.getNum());
			
			if(Grid[Curr.getLetter()][Curr.getNum()].getisOccupied()){
				Hits.add(Curr);
			}
			Curr.setLetter(center.getLetter());
			Curr.setLetter(center.getNum() + 1);
			
			if(Grid[Curr.getLetter()][Curr.getNum()].getisOccupied()){
				Hits.add(Curr);
			}
			Curr.setLetter(center.getLetter() +1);
			Curr.setLetter(center.getNum());
			
			if(Grid[Curr.getLetter()][Curr.getNum()].getisOccupied()){
				Hits.add(Curr);
			}
			
		}
			
		if(Hits.isEmpty())
			//Display a GUI Message Telling Player that there were no hits found
			return Hits;
		else
			//display a GUI Message Telling player which spaces have a ship occupying them.
			return Hits;
	}
	
	
	
}
