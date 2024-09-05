import java.lang.Math;
//https://www.w3schools.com/java/java_arraylist.asp
import java.util.ArrayList;

public class PlayerBase {
	private ArrayList<Card> cards;
	private ColumnPrinter cardDisplay;

	public PlayerBase() {
		cards = new ArrayList<Card>();
		cardDisplay = new ColumnPrinter();
	}

	// adds up all the card values for final calculations.
	public int calculateValue() {
		int totalValue = 0;
		
		for (Card card : this.cards) {
			// gets the value of each card  then adds to totalValue
			totalValue += card.getValue();
		}
		
		return totalValue;
	}

	// if the player hits (true) then generates a random card
	// adds the card to the pile of cards, and the design to the column renderer
	public void addCard() {
		if (this.hitOrStay()) {
			// gets a random card 
			int value = (int) (Math.random() * 13) + 1;
			Card newCard = new Card(value);
			
			cards.add(newCard);
			newCard.printFront(cardDisplay);
		}
	}

	public boolean hitOrStay() {
		// only in base case
		// must override in sub-class
		return true;
	}

	// returns the card objects in the deck
	public ArrayList<Card> getCards() {
		return this.cards;
	}

	// calls the column renderer .render()
	// this prints out all of the player's cards in a row
	public void render() {
		cardDisplay.render();
	}

	// calls render after adding to the column renderer
	public void render(String[] display) {
		cardDisplay.add(display);
		this.render();
	}
}