
public class TesterMaster {

	public static void main (String args[] ) {
		
		System.out.println("WELCOME TO MASTERMIND"); 
	
		System.out.println("\nYou must guess a four-color code. \nYou will have 12 tries to guess the code correctly."); 
		
		System.out.println("There will not be repeat colors in the code."); 
		System.out.println("Once you guess, your guess will be checked");
	
		System.out.println("A Black pin, 'b', denotes that you have guessed the correct color in the correct location.");  
		System.out.println("A white pin, 'w', denotes that you have guess a correct color but in the incorrect location."); 
		System.out.println("The placement of the pin does not have any bearing on which color was guessed correctly.\n"); 
		
		System.out.println("Here are your colors."); 
		System.out.println("R = Red\nY = Yellow\nG = Green\nB = Blue\nP = Purple\nW = White\nO = Orange\n"); 
	
		System.out.println("BEGIN!\n"); 
		
		Mastermind m1 = new Mastermind(); 
		m1.setCode(); 
		
		int turn = 1; //turns
		boolean win = false; 
		
		m1.buildBoard(); 
		m1.guess();
		m1.check(win);

		m1.printBoard();  

		while (turn <= 12) {
			m1.buildBoard(); 
			m1.guess();
				if (m1.check(win) == true) {
					turn = 14;  //return true = win = get out of loop 
				}
				else {  //make sure youre not calling the method twice
					turn = turn + 1;
				}
		
			 m1.printBoard();
		}
		
		if (turn == 13) {
			
			System.out.println("SORRY OUT OF TURNS"); 
			m1.printCode(); 
		}
		else {
			
			System.out.println("YOU WIN!"); 
			m1.printCode();
		}
		
	}
}
