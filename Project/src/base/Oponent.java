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
		boolean hitCheck = false;
		Random rn = new Random();
		
		
		
		
		i = rn.nextInt(4);
		
		switch (i){
			case 1:{
				Aim.setLetter(rn.nextInt(10));
				Aim.setNum(rn.nextInt(10));
				
				
				
				
			}
			default:
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
			
		
			
			
		
		
		
		
		
		
		
		
		return;
	}
	
	
	
	
}
