//https://www.w3schools.com/java/java_user_input.asp
import java.util.Scanner;
//https://www.w3schools.com/java/java_arraylist.asp
import java.util.ArrayList;
import java.lang.Math;

class Main {
	// Introduction of the game to the player
	public static void infoSection() {
		System.out.println("❓ Blackjack is a game of luck, primarily played in Casinos.\n");

		System.out.println("❗ Which ever player has the highest deck, wins.\n");

		System.out.println("❕ That is if you don't exceed 21, in that case you lose instantly. \n\n");
	}
	
	public static void main(String[] args) {
		// main input object
		Scanner input = new Scanner(System.in);

		// while loop allows for replayability 
		while (true) {
			Round.clearScreen(true);
			Main.infoSection();

			Dealer computer = null;

			// Asks the user for the game mode as long as they don't pick correctly
			while (computer == null) {
				System.out.print("You want 'easy' or 'hard' mode?");
				System.out.print(" ==> ");
				
				String gameMode = input.nextLine();
				gameMode = gameMode.toLowerCase();
				
				if (gameMode.equals("easy")) {
					// picked the easy game mode
					computer = new Dealer();
				}else if (gameMode.equals("hard")) {
					// picked the hard game mode
					computer = new HardDealer();
				}else {
					// picked neither game modes
					Round.clearScreen(true);
					System.out.println("Not valid mode.");
				}
			}

			/* The Round object
			Can input the number of rounds */
			Round newRound = new Round(3); 

			newRound.setDealer(computer); // the computer (easy or hard)
			newRound.setScanner(input); // for inputting from terminal
			newRound.start();

			System.out.println("\nWould you like to retry ('yes' or 'no')?");
			String retry = input.nextLine();
			retry = retry.toLowerCase();

			if (!retry.equals("yes")) {
				// breaks the replayability while loop
				Round.clearScreen(true);
				System.out.println("See you next time...");
				break;
			}
		}
	}
}