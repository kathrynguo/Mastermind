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
		
		boolean rp = true;
		for (int x = 0; x < 4; x++) { 
		do {
				intCode[x] = (int)(Math.random()*7 + 1); 
				//System.out.print(guess[x] + "");
					if (x == 0 || intCode[x] != intCode [x-1]){
						//if its equal to the one before it
						//has not repeated, so break out of loop
						rp = false; 
					}
					else {
						rp = true;  
					}
			}while(rp == true); 
		//System.out.print("/n"); 
		}
		
			
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
		//System.out.println(code); 
		
		//in setCode 
		//l1; l2; l3; l4; 
		//check that string does not contain l2, l3, l4 already within the substring you've already checked
		//for loop to find numbers of repeats of letters

			
	}
	
	public void printCode() {
		System.out.print("CODE: "); 
		System.out.print(code);
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
		//System.out.println("new guess array"); 
		a = a + 2; 
		
		//add new array for check; odd numbered
		board.add(new ArrayList<String>() );
		
		//4 spots for blanks for checks
		//odd numbered array 
		for (int y = 0; y < 4; y++) {
			board.get(b).add("( )");  
		}
		//System.out.println(b); 
		b = b + 2; 
	//}
	
	}
	
	private int a1 = 0; //for even number array guesses
	private int b1 = 1; //for odd number array checks
	//last in tester class
	public void printBoard() {
		
		//printing out guess board
		for (int c = 0; c < 4; c ++){ 
		System.out.print(board.get(a1).get(c) + " ");
		}
		System.out.println("\n"); 
		//adds 2 after printing 
		a1 = a1 + 2; 
		
		//printing out check array
		System.out.print(board.get(b1).get(0) + " "); 
		System.out.print(board.get(b1).get(1) + " "); 
		System.out.println(""); 
		System.out.print(board.get(b1).get(2) + " "); 
		System.out.print(board.get(b1).get(3) + " "); 
		//adds 2 after printing 1
		b1 = b1 + 2; 
		
		System.out.println("\n");
		
	}
	
	//board index counter; even numbers for guess arrays
	private int gs = 0; //for populating guess
	private int ck = 1; //for populating check
	//boolean to make sure there are no replacements when checking the setting key 
	private boolean occ=true; //true = occupied 
	public String uGuess; 
	
	public void guess() { //check is not working

		//getting guess from user
		Scanner s1 = new Scanner(System.in);
		System.out.print("Guess: ");
		uGuess = s1.nextLine(); 
		
		//populate board with guess
		for (int x = 0; x < 4; x++) {
			//array index gs (even), index x, set
			board.get(gs).set(x, "[" + uGuess.charAt(x) + "]"); 
		}
		//board counter goes up by 2
		gs = gs + 2; 
		
		//space; rest of the board is printed out in printBoard
		System.out.print("\n"); 
		
		//checking
		//int c = 0; //for else if 
		//System.out.println(ck); 
	}
	
	
	public boolean check(boolean win){
		
		win = false; 
		
		//circulate through all four
		for (int i = 0; i < 4; i++) {
			//if matches color and location
			if (uGuess.substring(i, i+1).equals(code.get(i))) {
				//System.out.println("RED pin");
				//b = black = right color right spot
				do {
					int d = (int)(Math.random()*4);
					
					String x = board.get(ck).get(d); 
					if (x.equals("( )") ) {  
						board.get(ck).set(d,"(B)");  
						//System.out.println("b pin set");
						occ = false;
					}
					else {
						occ = true; 
						//System.out.println(d + "loop");
					//	win = true; 
					} 
				} while(occ == true); //DOUBLE EQUAL SIGN 
			}//close if 
			//only matches color
			else if (code.contains(uGuess.substring(i, i + 1))){ 
				//System.out.println("WHITE PIN");
				
			
				//checking how many times it contains that letter in the code
				int apC = 0;
				for (int h = 0; h < 4; h++) {
					if ((code.get(h)).equals(uGuess.substring(i, i + 1))) {
						apC = apC + 1;  //appears once
					}
				}
				//System.out.println(apC + " appearances in code");
				//if number of times in guess is greater than number of reps in code
				
				//checking for repeats in guess
				int apG = 0; 
				for (int w = 0; w < 4; w++) {
					//if letter 1 equals letter 2, 3, 4, and so on
					//need to change so that it doesnt double count the last letter
					if ((uGuess.substring(w, w+1)).equals(uGuess.substring(i, i + 1))) {
						apG = apG + 1;  //appearances in guess
					}
				}
				//System.out.println(apG + " appearances in guess");
			

			
				do {
					int d = (int)(Math.random()*4);
					String x = board.get(ck).get(d); 
					//if it appears more in the guess than it does in the code, you have double counted
					if (x.equals("( )") && (apC >= apG)){ 
						board.get(ck).set(d,"(W)");  
						//System.out.println("w pin set");
						occ = false; 
						
					}
					else if (apG > apC) { //if appears more in the guess than it does in the code
						//no population
						occ = false; 
					}
					else { //occupied, get out of loop 
						occ = true; 
						//System.out.println(d + "loop"); 
					}
				} while(occ == true); //DOUBLE EQUAL SIGN 
				
			}//close else if
			} //close for loop 
			
			//checking to see if you win 
			if (board.get(ck).contains("( )") || board.get(ck).contains ("(W)")) { //means its not all black
				win = false;
				ck = ck + 2;
				//System.out.print("lose"); 
			}
			else {
				win = true; 
				ck = ck + 2;
				//System.out.print("win");
			}
			return win; 
			 
			
		} 
	
		//System.out.print(win + "\n"); 
	}

