public class HardDealer extends Dealer {
	public boolean hitOrStay() {
		int score = this.calculateValue(); // gets total value of the deckk
		
		if (score >= 18) {
			// to high, could lose 
			this.displayMessage(false);
			return false;
			
		} else if (score <= 5) {
			// the bot knows it is too low to win
			this.displayMessage(true);
			return true;
			
		} else {
			/* 
				There is still a possbility the computer could lose
				This is intentional

				If the player has higher deck, he could win.
				If the computer hits a card bigger than 3, they lose.
			*/
			return super.hitOrStay();
		}
	}
}