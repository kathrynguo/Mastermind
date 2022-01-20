import java.util.ArrayList; 

public class Mastermind {
	
	//ArrayList of ArrayLists
	ArrayList<ArrayList<String>> board = new ArrayList<ArrayList<String>>();
	//how will the human 'guess' a 4 digit color band


//building guess
	public void setGuess() {
		
	//psuedo guess with ints
	int[] guess = new int[4]; 
	
	for (int x = 0; x < 4; x++) {
		guess[x] = (int)(Math.random()*7 + 1); 
	}
		
	
	//R = 1
	//Y = 2
	//G = 3 
	//B = 4
	//P = 5
	//W = 6
	//B = 7
	
	}
	
	
//build a row for each turn; currently empty 
	//move print statements into a print method; print once populated 
	
	//board counter 
	int x = 0; 

	public void buildBoard() {
		
	int a = 0; 
	int b = 1; 
	
	//for (int x = 0; x < 12; x++) {
		
		//add new array 
		board.add(new ArrayList<String>() ); 
		
		//f4 blank spots for guesses
		for (int i = 0; i < 4; i++) {
			board.get(a).add("[ ]");
		}
		
		//printing out guess board
		for (int c = 0; c < 4; c ++){ 
		System.out.print(board.get(a).get(c) + " ");
		}
		System.out.println("\n");  
		a = a + 2;  
		
		//add new array 
		board.add(new ArrayList<String>() );
		
		//4 spots for blanks for checks
		for (int y = 0; y < 4; y++) {
			board.get(b).add("( )");  
		}
		
		System.out.print(board.get(b).get(0) + " "); 
		System.out.print(board.get(b).get(1) + " "); 
		System.out.println(""); 
		System.out.print(board.get(b).get(2) + " "); 
		System.out.print(board.get(b).get(3) + " "); 
		b = b + 2; 
		
		System.out.println("\n"); 
		
		
	//}
	//System.out.print(board); 
	
	}
	
	 
}
