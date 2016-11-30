package base;

import java.util.*;
import ships.*;

public class Oponent {
	private ArrayList<Ship> Ships;
	private GameBoard Board;
	private int lastHit;
	private Location lastLocation;
	private ArrayList<Location> lastFour;
	
	
	
	
	
	
	public void takeTurn(GameBoard Board){
		int i;
		Location Aim = new Location();
		boolean ori;
		boolean hitCheck = false;
		Random rn = new Random();
		
		
		
		while(true){
			i = rn.nextInt(4);
		
			switch (i){
				case 0:{
					Aim.setLetter(rn.nextInt(10));
					Aim.setNum(rn.nextInt(10));
				}
				case 1:{
					Aim.setLetter(rn.nextInt(10));
					Aim.setNum(rn.nextInt(10));
					ori = rn.nextBoolean();
				}
				case 2:{
					Aim.setLetter(rn.nextInt(10));
					Aim.setNum(rn.nextInt(10));
					ori = rn.nextBoolean();
					
				}
				case 3: {
					Aim.setLetter(rn.nextInt(10));
					Aim.setNum(rn.nextInt(10));
				}
				
				default:
					break;
				
			}
			
			
			
			break;
		}
			
		
		
		
		
		return;
	}
	
	
	
	public void setShips(){
		
		AirCraftCarrier acc = new AirCraftCarrier();
		Battleship bs = new Battleship();
		Destroyer d = new Destroyer();
		Submarine s = new Submarine();
		PTBoat pt = new PTBoat();
		Random rn = new Random();
		Location loc = new Location();
		
		
		
		acc.setDir(rn.nextBoolean());
		
		if(acc.getDir()){	
			loc.setLetter(rn.nextInt(6));
			loc.setNum(rn.nextInt(10));
		}
		else{
			loc.setLetter(rn.nextInt(10));
			loc.setNum(rn.nextInt(6));
		}
			
		acc.setShip(this.Board.Spaces[loc.getLetter()][loc.getNum()] , this.Board);
		this.Ships.add(acc);
		
		
		while(true){
			if(acc.getDir()){	
				loc.setLetter(rn.nextInt(7));
				loc.setNum(rn.nextInt(10));
			}
			else{
				loc.setLetter(rn.nextInt(10));
				loc.setNum(rn.nextInt(7));	
			}
			if(acc.setShip(this.Board.Spaces[loc.getLetter()][loc.getNum()] , this.Board) == true){
				this.Ships.add(bs);
				break;
				
			}
			
		}
		
		while(true){
			if(d.getDir()){	
				loc.setLetter(rn.nextInt(8));
				loc.setNum(rn.nextInt(10));
			}
			else{
				loc.setLetter(rn.nextInt(10));
				loc.setNum(rn.nextInt(8));	
			}
			if(d.setShip(this.Board.Spaces[loc.getLetter()][loc.getNum()] , this.Board) == true){
				this.Ships.add(d);
				break;
				
			}
			
		}
		
		while(true){
			if(s.getDir()){	
				loc.setLetter(rn.nextInt(8));
				loc.setNum(rn.nextInt(10));
			}
			else{
				loc.setLetter(rn.nextInt(10));
				loc.setNum(rn.nextInt(8));	
			}
			if(s.setShip(this.Board.Spaces[loc.getLetter()][loc.getNum()] , this.Board) == true){
				this.Ships.add(s);
				break;
				
			}
			
		}
		
		while(true){
			if(pt.getDir()){	
				loc.setLetter(rn.nextInt(9));
				loc.setNum(rn.nextInt(10));
			}
			else{
				loc.setLetter(rn.nextInt(10));
				loc.setNum(rn.nextInt(9));	
			}
			if(pt.setShip(this.Board.Spaces[loc.getLetter()][loc.getNum()] , this.Board) == true){
				this.Ships.add(pt);
				break;
				
			}
			
		}
		
		return;
	}
	
	
	
	
}
