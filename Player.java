//https://www.w3schools.com/java/java_user_input.asp
import java.util.Scanner;

public class Player extends PlayerBase {

	private Scanner input;

	// the input used by the player
	public Player(Scanner input) {
		this.input = input;
	}

	/* 
		if the player types "hit" then return true
		if the player types "stay" then return false
		other wise ask for the input again
	*/
	public boolean hitOrStay() {
		String choice = "";
		
		// edge case: makes sure the input is valid 
		while (!choice.equals("hit") && !choice.equals("stay")) {
			System.out.println("Type 'hit' or 'stay'.");

			// edge cases: removes uppercase/lowercase errors
			choice = this.input.nextLine();
			choice = choice.toLowerCase();	
		}
		
		return choice.equals("hit"); 
	}

}