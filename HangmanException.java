package edu.cuny.csi.csc330.LabEC;


public class HangmanException extends Exception {
	
	
	HangmanException() {
	
	} //constructor
	

	@Override
	public String toString() {
		return "\n \n GAME OVER! \n"
				+ "__________ \n"
				+ "|	 | \n"
				+ "|	 | \n"
				+ "|	 | \n"
				+ "|	 O \n"
				+ "|	/|\\ \n"
				+ "|	/ \\ \n"
				+ "|_____________ \n";
		}



	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// test w/o code 
    	HangmanException re = new HangmanException();
	}

}
