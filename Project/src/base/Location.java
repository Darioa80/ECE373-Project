package base;

public class Location {

	private int Num;
	private int Letter;  //Made this private member a character because this will be presented by a Letter on the gameboard
	
	public Location(){
		
		this.Num = -1;
		this.Letter = -1;
		return;
		
	}
	public Location(int newLetter, int newNum) {	//Added this constructor because when we make locations, we will already know the Letter and number location on the gameboard
		this.Letter = newLetter;
		this.Num = newNum;
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
