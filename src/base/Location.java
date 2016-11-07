package base;

public class Location {

	private int Num;
	private int Letter;  //Made this private member a character because this will be presented by a Letter on the gameboard
	
	public Location(){
		
		this.Num = -1;
		this.Letter = -1;
		return;
		
	}
	
	public int getNum(){
		return this.Num;
	}
	
	public void setNum(int newNum){
		this.Num = newNum;
		return;
	}
	
	public int getLetter(){
		return this.Letter;
	}
	
	public void setLetter(int newLetter){
		this.Letter = newLetter;
		return;
	}
	
	
}
