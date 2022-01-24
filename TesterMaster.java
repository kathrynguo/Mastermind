public class TesterMaster {

	public static void main (String args[] ) {
	
		Mastermind m1 = new Mastermind(); 
		m1.setCode(); 
		m1.buildBoard(); 
		m1.userGuess(); 
		m1.printBoard(); 
	}
}
