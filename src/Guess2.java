//
// Lab 6
// Task 3
//
// Welcome to the Guess Game!\n\n RULES:")
//  1.  We will play five rounds.");
//	2. Each round you will guess the number rolled on a six-sided die.");
//  3. If you guess the correct value in three or fewer tries\n" +//
//     then you score a point, otherwise I score a point.");
//  4. Whoever has the most points after five rounds wins.");
//

import java.util.Scanner;
import java.util.Random;

public class Guess2 {

	public static void main(String[] args) {
		
		Random ranGen = new Random(8);	// seeded to make debugging easier
		final int sides = 6;			// number of sides for a die
		Scanner userInput = new Scanner(System.in);
		int userguess = -1;				// user's guess,  1 - 6 inclusive
		int rolled = -1;				// number rolled, 1 - 6 inclusive
		int computerPoints = 0;			// computer's score, 0 - 5 max
		int humanPoints = 0;			// human user's score, 0 - 5 max
		boolean rightGuess = false;		// flag for correct guess
		int numGuesses = 0;				// counts the number of guesses per round

		//MAKE SURE THE PROGRAM PLAYS BY THESE RULES!!!
		System.out.println("Welcome to the Guess Game!\n\n RULES:");
		System.out.println("1. We will play five rounds.");
		System.out.println("2. Each round you will guess the number rolled on a six-sided die.");
		System.out.println("3. If you guess the correct value in three or fewer tries\n" +
			"   then you score a point, otherwise I score a point.");
		System.out.println("4. Whoever has the most points after five rounds wins.");
		
		// play five rounds
		for (int r = 1; r <= 5; r++) {  /* there is a change in this line */

			// roll the die to start the round
			System.out.println("\n\nROUND " + r);
			System.out.println("-------");
			rolled = ranGen.nextInt(sides)+1;  /* there is a change in this line */
			System.out.println("The computer has rolled the die.");
			System.out.println("You have three guesses.");

			// loop gives user up to three guesses
			rightGuess = false;
			numGuesses = 0;  /* there is a change in this line */
			while (numGuesses < 3 && !rightGuess) { /* there is a change in this line */

				// input & validation: must be in range 1 to 6 inclusive
				do {
					System.out.print("\nWhat is your guess [1-6]? ");

					userguess = userInput.nextInt();

					if ((userguess < 1) || (userguess > 6)) {  /* there is a change in this line */
						System.out.println("   Please enter a valid guess [1-6]!");
					}
				} while (userguess < 1 || userguess > 6); 

				// did the user guess right?
				if (rolled == userguess) {
					rightGuess = true;  /* there is a change in this line */
					System.out.println("   Correct!");
				} else {
					System.out.println("   Incorrect guess.");
				}
				numGuesses++;
			}

			// if the user guessed right, they get a point
			// otherwise the computer gets a point
			if (rightGuess) {
				humanPoints++;   /* there is a change in this line */
			} else {
				computerPoints++;  /* there is a change in this line */
			}

			// display the answer and scores
			System.out.println("\n*** The correct answer was: " + rolled + " ***\n");
			System.out.println("Scores:");
			System.out.println("  You: \t\t" + humanPoints);
			System.out.println("  Computer: \t" + computerPoints);
			System.out.println("");
		}

		// tell the user if they won or lost
		if (computerPoints > humanPoints) {
			System.out.println("*** You Lose! ***");
		} else {
			System.out.println("*** You Win! ***");
		}

		System.out.println("Thanks for playing the Guess Game!");
	} // end main

}  // end class Guess