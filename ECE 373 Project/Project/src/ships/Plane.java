package ships;
import java.util.ArrayList;

import javax.swing.JOptionPane;

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
	public void setLoc(Location L){this.loc.setLetter(L.getLetter()); this.loc.setNum(L.getNum()); return;}
	public void setDestroyed(boolean D){ this.destroyed = D; return;}
	
	public Location getLoc(){return this.loc;}
	public boolean isDestroyed(){return this.destroyed;}
	
	public boolean Scan(Location center, boolean pattern, GameBoard Board){
		boolean hit = false;
		Location Curr = new Location();
		Coordinate Grid [][] = new Coordinate[10][10];
		
		
		//pattern true is for X pattern false is for +
		if(pattern){
				
			
			if(center.getLetter() != 0 && center.getNum() != 0){
				Curr.setLetter(center.getLetter() - 1);
				Curr.setNum(center.getNum() - 1);
			
				if(Board.Spaces[Curr.getNum()][Curr.getLetter()].getisOccupied()){
					Board.Spaces[Curr.getNum()][Curr.getLetter()].setFound(true);
					hit = true;
				}
				else{
					Board.Spaces[Curr.getNum()][Curr.getLetter()].setChecked(true);
				}
			}
			
			if(center.getLetter() != 0 && center.getNum() != 9){
				Curr.setLetter(center.getLetter() - 1);
				Curr.setNum(center.getNum() + 1);
			
				if(Board.Spaces[Curr.getNum()][Curr.getLetter()].getisOccupied()){
					Board.Spaces[Curr.getNum()][Curr.getLetter()].setFound(true);
					hit = true;
				}
				else{
					Board.Spaces[Curr.getNum()][Curr.getLetter()].setChecked(true);
				}
				
			}
			
			
			if(Board.Spaces[center.getNum()][center.getLetter()].getisOccupied()){
				Board.Spaces[center.getNum()][center.getLetter()].setFound(true);
				hit = true;
			}
			else{
				Board.Spaces[center.getNum()][center.getLetter()].setChecked(true);
			}
			
			if(center.getLetter() != 9 && center.getNum() != 0) {
				Curr.setLetter(center.getLetter() +1);
				Curr.setNum(center.getNum() - 1);
			
				if(Board.Spaces[Curr.getNum()][Curr.getLetter()].getisOccupied()){
					Board.Spaces[Curr.getNum()][Curr.getLetter()].setFound(true);
					hit = true;
				}
				else{
					Board.Spaces[Curr.getNum()][Curr.getLetter()].setChecked(true);
				}
			}
			
			
			if(center.getLetter() != 9 && center.getNum() != 9){
				Curr.setLetter(center.getLetter() +1);
				Curr.setNum(center.getNum() + 1);
			
				if(Board.Spaces[Curr.getNum()][Curr.getLetter()].getisOccupied()){
					Board.Spaces[Curr.getNum()][Curr.getLetter()].setFound(true);
					hit = true;
				}
				else{
					Board.Spaces[Curr.getNum()][Curr.getLetter()].setChecked(true);
				}
			}
			
			
			
			
		
		}
		else{
			
			
			if(center.getLetter() != 0){
				Curr.setLetter(center.getLetter() -1);
				Curr.setNum(center.getNum());
			
				if(Board.Spaces[Curr.getNum()][Curr.getLetter()].getisOccupied()){
					Board.Spaces[Curr.getNum()][Curr.getLetter()].setFound(true);
					hit = true;
				}
				else{
					Board.Spaces[Curr.getNum()][Curr.getLetter()].setChecked(true);
				}
			}
			
			if(center.getNum() != 0){
				Curr.setLetter(center.getLetter());
				Curr.setNum(center.getNum() - 1);
				
				if(Board.Spaces[Curr.getNum()][Curr.getLetter()].getisOccupied()){
					Board.Spaces[Curr.getNum()][Curr.getLetter()].setFound(true);
					hit = true;
				}
				else{
					Board.Spaces[Curr.getNum()][Curr.getLetter()].setChecked(true);
				}
			}
			
			
			if(Board.Spaces[center.getNum()][center.getLetter()].getisOccupied()){
				Board.Spaces[center.getNum()][center.getLetter()].setFound(true);
				hit = true;
			}
			else{
				Board.Spaces[center.getNum()][center.getLetter()].setChecked(true);
			}
			
			if(center.getNum() != 9){
				Curr.setLetter(center.getLetter());
				Curr.setNum(center.getNum() + 1);
			
				if(Board.Spaces[Curr.getNum()][Curr.getLetter()].getisOccupied()){
					Board.Spaces[Curr.getNum()][Curr.getLetter()].setFound(true);
					hit = true;
				}
				else{
					Board.Spaces[Curr.getNum()][Curr.getLetter()].setChecked(true);
				}
			}
			
			if(center.getLetter() != 9){
				
				Curr.setLetter(center.getLetter() +1);
				Curr.setNum(center.getNum());
			
				if(Board.Spaces[Curr.getNum()][Curr.getLetter()].getisOccupied()){
					Board.Spaces[Curr.getNum()][Curr.getLetter()].setFound(true);
					hit = true;
				}
				else{
					Board.Spaces[Curr.getNum()][Curr.getLetter()].setChecked(true);
				}
			}
			
		}
			
		return hit;
			//display a GUI Message Telling player which spaces have a ship occupying them.
			
	}
	
	
	
}
