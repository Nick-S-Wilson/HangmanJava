package edu.cuny.csi.csc330.LabEC;

import java.util.Scanner;

//import edu.cuny.csi.csc330.newradio.RadioException;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Hangman {

	
	private static List<String> results = new ArrayList<String>(); //creates list for Words.txt
	private static int lengthTest; //gets length of list
	private static String word; //gets random word from list
	private static String hidden; //makes the word not visible
	private static int count = 0; // for <6 loop
	
    public static String[] guesses = new String[6];
    public static String wrongGuess; 

	
	
	public static void main(String[] args) throws HangmanException {
		
		
		// file to open.
        String fileName = "H:\\CSC 330 (Sprint 2018)\\Labs\\Lab Extra Credit\\Words.txt"; //words file location (changes)
        // This will reference one line at a time
        String line = null;
        try {
            // FileReader reads text files in the default encoding.
            FileReader fileReader = 
                new FileReader(fileName);

            // Always wrap FileReader in BufferedReader.
            BufferedReader bufferedReader = 
                new BufferedReader(fileReader);

            while((line = bufferedReader.readLine()) != null) {
                //create list
            	results.add(line);
            }   

            // Always close files.
            bufferedReader.close();         
        }
        catch(FileNotFoundException ex) {
            System.out.println(
                "Unable to open file '" + 
                fileName + "'");                
        }
        catch(IOException ex) {
            System.out.println(
                "Error reading file '" 
                + fileName + "'");                  
        }
        
        
        
        
       lengthTest = results.size(); //gets the length of the list
       word = results.get((int) (Math.random() * lengthTest)); //picks random word from list
       hidden = new String(new char[word.length()]).replace("\0", "_"); //blanks out word

       
       
        
		Scanner sc = new Scanner(System.in);

		while (count < 6 && hidden.contains("_")) {
			try {
				
				System.out.println("Guess any letter in the word");
				char[] letter = hidden.toCharArray(); 
			    for(int i = 0; i < letter.length; i++)
			    {
			    	System.out.format("%2c", letter[i]);
			    }
			    System.out.printf(System.lineSeparator());
				String guess = sc.next(); //reads user input
				wrongGuess = guess;
				hang(guess);				
			}
			catch (HangmanException tester) { //catches exception from count == 6
				
				System.err.println(tester); //prints the exception
			}

		}
		sc.close();
	}

	public static void hang(String guess) throws HangmanException {
		String newasterisk = "";
		for (int i = 0; i < word.length(); i++) 
		{
			if (word.charAt(i) == guess.charAt(0)) 
			{
				newasterisk += guess.charAt(0);
			} 
			else if (hidden.charAt(i) != '_') 
			{
				newasterisk += word.charAt(i);
			} 
			else 
			{
				newasterisk += "_";
			}
		}

		if (hidden.equals(newasterisk)) {
			guesses[count] = wrongGuess;
			count++;
			hangmanImage();
		} else {
			hidden = newasterisk;
		}
		if (hidden.equals(word)) {
			System.out.println("Correct! You win! The word was " + word);
		}
	}

	public static void hangmanImage() throws HangmanException {
		if (count == 1) {
			System.out.println("Wrong guess, try again");
			System.out.println("__________");
			System.out.println("|	 |");
			System.out.println("|	 |");
			System.out.println("|	 O");
			System.out.println("|	");
			System.out.println("|	");
			System.out.println("|_____________");
		}
		if (count == 2) {
			System.out.println("Wrong guess, try again");
			System.out.println("__________");
			System.out.println("|	 |");
			System.out.println("|	 |");
			System.out.println("|	 O");
			System.out.println("|	/");
			System.out.println("|	");
			System.out.println("|_____________");
		}
		if (count == 3) {
			System.out.println("Wrong guess, try again");
			System.out.println("__________");
			System.out.println("|	 |");
			System.out.println("|	 |");
			System.out.println("|	 O");
			System.out.println("|	/|");
			System.out.println("|");
			System.out.println("|_____________");
		}
		if (count == 4) {
			System.out.println("Wrong guess, try again");
			System.out.println("__________");
			System.out.println("|	 |");
			System.out.println("|	 |");
			System.out.println("|	 O");
			System.out.println("|	/|\\ ");
			System.out.println("|");
			System.out.println("|_____________");
		}
		if (count == 5) {
			System.out.println("Wrong guess, try again");
			System.out.println("__________");
			System.out.println("|	 |");
			System.out.println("|	 |");
			System.out.println("|	 O");
			System.out.println("|	/|\\ ");
			System.out.println("|	/");
			System.out.println("|_____________");
		}
		if (count == 6) {
			
			System.out.println("Wrong Guesses: ");
			
			for (int i = 0; i < 6; i++)
			{
				System.out.printf("%2s", guesses[i]);
			}
			
			System.out.println("\n The word was " + word);
			
			throw new HangmanException(); //throws exception to main
			

		}
	}
	

	
	
}