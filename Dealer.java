import java.lang.Math;

public class Dealer extends PlayerBase {

	private int numPicks = 0;

	// displays the computer's choice
	public void displayMessage(boolean hit) {
		if (hit) {
			System.out.println("The computer said 'hit'.");
		}else {
			System.out.println("The computer stayed.");
		}
	}
	
	public boolean hitOrStay() {
		this.numPicks++;

		// The computer is mandated to return hit the first round
		if (this.numPicks == 1) {
			this.displayMessage(true);
			return true; // first pick 
		}

		// decides randomy if they want to hit or stay.
		int randomChoice = (int) (Math.random() * 2);
		this.displayMessage(randomChoice == 1);
		return randomChoice == 1;
	}

	/*
		We do this because we don't want the player to see the computers cards
		The back of the card is printed using printBack() method of each card
	*/
	public void renderEmpty() {
		ColumnPrinter empty = new ColumnPrinter();
		for (Card card: this.getCards()) {
			card.printBack(empty);
		}
		empty.render();
	}
	
}