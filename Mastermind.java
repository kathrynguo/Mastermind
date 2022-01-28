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
		private ArrayList<String> code = new ArrayList<String>(); //had to change to arraylist for list.contains
	
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
				code.add("R"); 
			}
			else if (intCode[i] == 2) {
				code.add("Y"); 
			}
			else if (intCode[i] == 3) {
				code.add("G"); 
			}
			else if (intCode[i] == 4) {
				code.add("B"); 
			}
			else if (intCode[i] == 5) {
				code.add("P"); 
			}
			else if (intCode[i] == 6) {
				code.add("W"); 
			}
			else if (intCode[i] == 7) {
				code.add("O"); 
			}
		}
		 
		//print code
		System.out.println(code); 
		
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
	//last in tester class
	public void printBoard() {
		
		//printing out guess board
		for (int c = 0; c < 4; c ++){ 
		System.out.print(board.get(a).get(c) + " ");
		}
		System.out.println("\n"); 
		//adds 2 after printing 
		a = a + 2; 
		
		//printing out check array
		System.out.print(board.get(b).get(0) + " "); 
		System.out.print(board.get(b).get(1) + " "); 
		System.out.println(""); 
		System.out.print(board.get(b).get(2) + " "); 
		System.out.print(board.get(b).get(3) + " "); 
		//adds 2 after printing 
		b = b + 2; 
		
		System.out.println("\n");
		
	}
	
	//board index counter; even numbers for guess arrays
	private int gs = 0; 
	//boolean to know if you won 
	boolean win; 
	
	public void guessAndCheck() {
		
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
		
		//space; rest of the board is printed out in printBoard
		System.out.print("\n"); 
		
		//checking
		int c = 0; //for else if 
		
		//circulate through all four
		for (int i = 0; i < 4; i++) {
			//if matches color and location
			if (uGuess.substring(i, i+1).equals(code.get(i))) {
				//b = black = right color right spot
				int d = (int)(Math.random()*3 + 1); //replaces make not random 
				board.get(b).set(d,"(B)"); 
				win = true; 
			}
			//only matches color
			else if (code.contains(uGuess.substring(c, c + 1))) {
				int d = (int)(Math.random()*3 + 1); 
				board.get(b).set(d, "(W)"); 
				win = false;
			}
		}

	}
}

