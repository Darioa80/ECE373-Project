package base;

import java.util.*;
import ships.*;

public class Oponent {
	private ArrayList<Ship> Ships;
	private ArrayList<Plane> Planes;
	private AAGun aa = new AAGun();
	public GameBoard Board;
	private int lastHit;
	private Location lastLocation;
	private ArrayList<Location> lastFour;
	int gamemode;
	
	
	
	
	
	
	public void takeTurn(GameBoard Board, Player P){
		int i;
		ArrayList<Location> Confirmed = new ArrayList<Location>();
		int turnCount = 0;
		Location Aim = new Location();
		boolean scan = false;
		Location scanLoc = new Location();
		boolean ori;
		ArrayList<Boolean> hitCheck = new ArrayList<Boolean>();
		ArrayList<Location> lastLoc = new ArrayList<Location>();
		Random rn = new Random();
		int j;
		int turnsleft = 0;
		
		switch(this.gamemode){
		case 1: {
			Aim.setLetter(rn.nextInt(10));
			Aim.setNum(rn.nextInt(10));
			
			
ifcheck1:if(Board.Spaces[Aim.getLetter()][Aim.getNum()].getisOccupied() == true){
				//checks to see if space is occupied
				for(j = 0; j < Board.Spaces[Aim.getLetter()][Aim.getNum()].getIsOccupiedBy().getSize(); j++){
					//checks the spaces of the ship occupying the space
					if(Board.Spaces[Aim.getLetter()][Aim.getNum()].getIsOccupiedBy().getLocation().get(j).getLetter() == Aim.getLetter() 
							&& Board.Spaces[Aim.getLetter()][Aim.getNum()].getIsOccupiedBy().getLocation().get(j).getNum() == Aim.getNum()){
						//checks to see if the spot has been hit yet
						if(Board.Spaces[Aim.getLetter()][Aim.getNum()].getIsOccupiedBy().getHits().get(j) == false){
							Board.Spaces[Aim.getLetter()][Aim.getNum()].getIsOccupiedBy().setAHit(j, true);
							hitCheck.add(true);
							break ifcheck1;
						}
					}
					
					
					
				}
			}
			hitCheck.add(false);
			
			lastLoc.add(Aim);
			break;
			
			
		}
		//Salvo Mission
		case 2: {
			for(i = 0; i < this.Ships.size(); i++)
				if(this.Ships.get(i).getSunk() == false)
					turnsleft++;
			while(turnsleft > 0){
			
			
			Aim.setLetter(rn.nextInt(10));
			Aim.setNum(rn.nextInt(10));
			
			
ifcheck2:	if(Board.Spaces[Aim.getLetter()][Aim.getNum()].getisOccupied() == true){
			
				//checks to see if space is occupied
					for(j = 0; j < Board.Spaces[Aim.getLetter()][Aim.getNum()].getIsOccupiedBy().getSize(); j++){
						//checks the spaces of the ship occupying the space
						if(Board.Spaces[Aim.getLetter()][Aim.getNum()].getIsOccupiedBy().getLocation().get(j).getLetter() == Aim.getLetter() 
								&& Board.Spaces[Aim.getLetter()][Aim.getNum()].getIsOccupiedBy().getLocation().get(j).getNum() == Aim.getNum()){
							//checks to see if the spot has been hit yet
							if(Board.Spaces[Aim.getLetter()][Aim.getNum()].getIsOccupiedBy().getHits().get(j) == false){
								Board.Spaces[Aim.getLetter()][Aim.getNum()].getIsOccupiedBy().setAHit(j, true);
								hitCheck.add(true);
								break ifcheck2;
							}
						}
					}
			}
			hitCheck.add(false);
			
			lastLoc.add(Aim);
			
			
			
			}
			break;
		}
		
		case 3:{
		
loop:			while(true){
				i = rn.nextInt(4);
		
				switch (i){
				
					//this case is for the regular fire function
					case 0:{
						Aim.setLetter(rn.nextInt(10));
						Aim.setNum(rn.nextInt(10));
					
					
ifcheck3:				if(Board.Spaces[Aim.getLetter()][Aim.getNum()].getisOccupied() == true){
							//checks to see if space is occupied
							for(j = 0; j < Board.Spaces[Aim.getLetter()][Aim.getNum()].getIsOccupiedBy().getSize(); j++){
								//checks the spaces of the ship occupying the space
								if(Board.Spaces[Aim.getLetter()][Aim.getNum()].getIsOccupiedBy().getLocation().get(j).getLetter() == Aim.getLetter() 
										&& Board.Spaces[Aim.getLetter()][Aim.getNum()].getIsOccupiedBy().getLocation().get(j).getNum() == Aim.getNum()){
									//checks to see if the spot has been hit yet
									if(Board.Spaces[Aim.getLetter()][Aim.getNum()].getIsOccupiedBy().getHits().get(j) == false){
										Board.Spaces[Aim.getLetter()][Aim.getNum()].getIsOccupiedBy().setAHit(j, true);
										hitCheck.add(true);
										break ifcheck3;
									}
								}
							}
						}
						hitCheck.add(false);
					
						lastLoc.add(Aim);
						break loop;
					
					}
					//this is for the scan function
					case 1:{
						Aim.setLetter(rn.nextInt(10));
						Aim.setNum(rn.nextInt(10));
						if(rn.nextBoolean() ==true){
							if(this.Ships.get(3).getSunk() == false){
								Submarine s = new Submarine();
								if(s.Sonar(Board.Spaces[Aim.getLetter()][Aim.getNum()], Board) == true){
									scan = true;
									scanLoc = Aim;
									turnCount = 0;
								}
								else{
									scan = false;
								}
								break loop;
							}
						}
						else{
							i = rn.nextInt(2);
							if(this.Planes.get(i).isDestroyed() == false){
								Confirmed = this.Planes.get(i).Scan(Board.Spaces[Aim.getLetter()][Aim.getNum()].getCoord(), rn.nextBoolean() , Board);
								break loop;
							}
						
						}
					
					
					
						
						break;
					}
					
				
				
					
					//this is for the aa gun
					case 2:{
						Aim.setLetter(rn.nextInt(10));
						Aim.setNum(rn.nextInt(10));
						ori = rn.nextBoolean();
						if(this.aa.getEnabled() == true){
							aa.Fire(this.Board.Spaces[Aim.getLetter()][Aim.getNum()].getCoord(), Board, P.OwnedPlanes);
							break loop;
						}
						break;
					}
				
					//this is for the specials 
					case 3: {
						Aim.setLetter(rn.nextInt(10));
						Aim.setNum(rn.nextInt(10));
						ori = rn.nextBoolean();
						i = rn.nextInt(4);
						if(this.Ships.get(i).getSunk() == false){
							switch (i){
								case(0): {
									if(this.Ships.get(0).getSpecialsLeft() > 0){
										AirCraftCarrier acc = new AirCraftCarrier();
										acc.Exocet(ori, Board.Spaces[Aim.getLetter()][Aim.getNum()], Board);
										break loop;
									}
									break;
								}
								case(1):{
									if(this.Ships.get(1).getSpecialsLeft() > 0){
										Battleship bs = new Battleship();
										bs.TomaHawk(Board.Spaces[Aim.getLetter()][Aim.getNum()], Board);
										break loop;
									}
									break;
								
								}
								case(2): {
									if(this.Ships.get(2).getSpecialsLeft() > 0){
										Destroyer d = new Destroyer();
										d.Apache(Board.Spaces[Aim.getLetter()][Aim.getNum()], rn.nextBoolean(), Board);
										break loop;
									}
									break;
								}
								default:{
									if(this.Ships.get(3).getSpecialsLeft() > 0){
										Submarine s = new Submarine();
										s.Torpedo(Board.Spaces[Aim.getLetter()][Aim.getNum()], rn.nextBoolean(), Board);
										break loop;	
									}
									break;
								}
							
							}
						}	
					
					
						break;
					}
				
					default:
						break;
				
				}
			
			
			
				break;
			}
			
		
		
			}
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
		int i;
		Plane Curr = new Plane();
		
		
		//sets the aircraft carrier
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
		
		
		//sets the Battleship
		while(true){
			if(acc.getDir()){	
				loc.setLetter(rn.nextInt(7));
				loc.setNum(rn.nextInt(10));
			}
			else{
				loc.setLetter(rn.nextInt(10));
				loc.setNum(rn.nextInt(7));	
			}
			if(acc.setShip(this.Board.Spaces[loc.getLetter()][loc.getNum()] , this.Board) == 0){
				this.Ships.add(bs);
				break;
				
			}
			
		}
		
		
		//sets the destroyer
		while(true){
			if(d.getDir()){	
				loc.setLetter(rn.nextInt(8));
				loc.setNum(rn.nextInt(10));
			}
			else{
				loc.setLetter(rn.nextInt(10));
				loc.setNum(rn.nextInt(8));	
			}
			if(d.setShip(this.Board.Spaces[loc.getLetter()][loc.getNum()] , this.Board) ==  0){
				this.Ships.add(d);
				break;
				
			}
			
		}
		
		
		//sets the submarine
		while(true){
			if(s.getDir()){	
				loc.setLetter(rn.nextInt(8));
				loc.setNum(rn.nextInt(10));
			}
			else{
				loc.setLetter(rn.nextInt(10));
				loc.setNum(rn.nextInt(8));	
			}
			if(s.setShip(this.Board.Spaces[loc.getLetter()][loc.getNum()] , this.Board) == 0){
				this.Ships.add(s);
				break;
				
			}
			
		}
		
		
		//sets the pt boat
		while(true){
			if(pt.getDir()){	
				loc.setLetter(rn.nextInt(9));
				loc.setNum(rn.nextInt(10));
			}
			else{
				loc.setLetter(rn.nextInt(10));
				loc.setNum(rn.nextInt(9));	
			}
			if(pt.setShip(this.Board.Spaces[loc.getLetter()][loc.getNum()] , this.Board) == 0){
				this.Ships.add(pt);
				break;
				
			}
			
		}
		
		i = rn.nextInt(5);
		Curr.setLoc(this.Ships.get(0).getLocation().get(i));
		this.Planes.add(Curr);
		
		
		while(true){
			i = rn.nextInt(5);
			if(Planes.get(0).getLoc() != this.Ships.get(0).getLocation().get(i)){
				Curr.setLoc(this.Ships.get(0).getLocation().get(i));
				break;
			}
		
			
			
		}
		
		return;
	}
	
	
	
	
}
