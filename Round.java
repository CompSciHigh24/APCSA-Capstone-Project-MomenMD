//https://www.w3schools.com/java/java_user_input.asp
import java.util.Scanner;

public class Round {
	private int numRounds;
	private int currentRound = 1;

	private Scanner input; // for user input

	private Dealer dealer;
	private Player player;

	// constructor takes in the number of rounds
	public Round(int numRounds) {
		this.numRounds = numRounds;
	}

	// takes in the scanner from Main.java for the player
	public void setScanner(Scanner scanner) {
		this.input = scanner;
	}

	// clears the terminal (apart of the rendering system)
	public static void clearScreen(boolean spaced) {
		// ANSI escape code to clear the whole screen 
		// https://www.javatpoint.com/how-to-clear-screen-in-java
		System.out.print("\033[H\033[2J");  
    System.out.flush(); 

		if (spaced) {
			System.out.print("\n");
		}
	}

	// returns if the player has busted
	public boolean checkBusted(PlayerBase player) {
		return player.calculateValue() > 21;
	}

	// sets the dealer
	// used in Main.java to set the computer based on difficulty
	public void setDealer(Dealer dealer) {
		this.dealer = dealer;
	}

	// called to start the game.
	public void start() {
		this.player = new Player(this.input);

		// runs until number of rounds.
		while (this.currentRound <= this.numRounds) {
			Round.clearScreen(true);

			// the computer picks whether they are going to hit or stay.
			this.dealer.addCard();
			this.dealer.renderEmpty();

			// the computer has more than 21 cards.
			if (this.checkBusted(this.dealer)) break;

			// displays the current number of cards
			this.player.render();
			System.out.println();

			// the player enters if they are going to hit or stay.
			this.player.addCard();

			// the player has more than 21 cards.
			if (this.checkBusted(this.player)) break;
			
			this.currentRound++;
		}	

		this.conclude();
	}

	// the end game/ decides who won
	public void conclude() {
		Round.clearScreen(false);

		int playerValue = this.player.calculateValue();
		int dealerValue = this.dealer.calculateValue();

		// add a display of total score to the column printer
		this.dealer.render(new String[]{
			"",
			"    |",
			"    | DEALER (" + dealerValue + ")",
			"    |",
			""
		});
		// add a display of total score to the column printer
		this.player.render(new String[]{
			"",
			"    |",
			"    | PLAYER (" + playerValue + ")",
			"    |",
			""
		});

		// checks if the player or computer has lost due to high deck value.
		if (playerValue > 21) {
			System.out.println("\nYou Busted...COMPUTER ONE!");
			return;
		}else if (dealerValue > 21) {
			System.out.println("\nThe Computer Busted... YOU WON!");
			return;
		}

		System.out.println("");

		// checks who won the game by comparing the deck value.
		if (playerValue > dealerValue) {
			System.out.println("CONGRATS YOU WON!");
		}else if (dealerValue > playerValue) {
			System.out.println("THE COMPUTER WON...");
		}else {
			System.out.println("TIE...");
		}
	}
}