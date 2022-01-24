import java.util.ArrayList; 
import java.util.Scanner; 

public class Mastermind {
	
	//BOARD
	private ArrayList<ArrayList<String>> board = new ArrayList<ArrayList<String>>();
	//how will the human 'guess' a 4 digit color band


	//setting code (4 digit array)
		//psuedo guess with ints
		private int[] intCode = new int[4];
		//real guess with letters 
		private String[] code = new String[4]; 
	
	//building code; WITH REPEATS
	public void setCode() {
	
		//random number to each index in code 
		for (int x = 0; x < 4; x++) {
			intCode[x] = (int)(Math.random()*7 + 1); 
			//System.out.print(guess[x] + "");
		}
		//System.out.print("/n"); 
			
		//setting letters in code based on numbers in intCode
		//R = 1
		//Y = 2
		//G = 3 
		//B = 4
		//P = 5
		//W = 6
		//O = 7
		
		for (int i = 0; i < 4; i++) {
			if (intCode[i] == 1) {
				code[i] = "R"; 
			}
			else if (intCode[i] == 2) {
				code[i] = "Y"; 
			}
			else if (intCode[i] == 3) {
				code[i] = "G"; 
			}
			else if (intCode[i] == 4) {
				code[i] = "B"; 
			}
			else if (intCode[i] == 5) {
				code[i] = "P"; 
			}
			else if (intCode[i] == 6) {
				code[i] = "W"; 
			}
			else if (intCode[i] == 7) {
				code[i] = "O"; 
			}
		}
		 
		//print code
		for (int a = 0; a < 4; a++) {
			System.out.print(code[a]); 
		}
		System.out.println("\n"); 
		
	}
	
	
	//build a row for each turn; currently empty 
	//move print statements into a print method; print once populated 
		
		//board counter 
		private int x = 0; 
		//used in buildBoard and printBoard
		private int a = 0; //for even number array guesses
		private int b = 1; //for odd number array checks

	public void buildBoard() { //creates 1 set of guesses & checks; loop in driver class to do 1 at a time
	
	//for (int x = 0; x < 12; x++) {
		
		//add new array for guess; even numbered
		board.add(new ArrayList<String>() ); 
		
		//4 blank spots for guesses; even numbered
		for (int i = 0; i < 4; i++) {
			board.get(a).add("[ ]");
		}
		
		//add new array for check; odd numbered
		board.add(new ArrayList<String>() );
		
		//4 spots for blanks for checks
		//odd numbered array 
		for (int y = 0; y < 4; y++) {
			board.get(b).add("( )");  
		}
		
	//}
	
	}
	
	public void printBoard() {
		
		//printing out guess board
		for (int c = 0; c < 4; c ++){ 
		System.out.print(board.get(a).get(c) + " ");
		}
		System.out.println("\n");  
		a = a + 2; 
		
		
		//printing out check array
		System.out.print(board.get(b).get(0) + " "); 
		System.out.print(board.get(b).get(1) + " "); 
		System.out.println(""); 
		System.out.print(board.get(b).get(2) + " "); 
		System.out.print(board.get(b).get(3) + " "); 
		b = b + 2; 
		
		System.out.println("\n");
		
	}
	
	//board index counter; even numbers for guess arrays
	private int gs = 0; 
		
	public void userGuess() {
		
		//string for user guess
		String uGuess; 
		
		//getting guess from user
		Scanner s1 = new Scanner(System.in);
		System.out.print("Guess: ");
		uGuess = s1.nextLine(); 
		
		//populate board with guess
		for (int x = 0; x < 4; x++) {
			//array index gs, index x, set
			board.get(gs).set(x, "[" + uGuess.charAt(x) + "]"); 
		}
		//board counter goes up by 2
		gs = gs + 2; 
		
		//space
		System.out.print("\n"); 

	}
	 
}
