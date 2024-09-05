/* 
	The class represents a card itself.
 	A card has a face value (name) and value.
*/

public class Card {
	private String name;
	private int value;

	/* 
		All the cards inside of the game
		The value of each cards is index + 1
		
		So a King's card index 12, so the value of card is 13.
	*/
	private static String[] nameFromVal = {
		"1", "2", "3", "4", "5", 
		"6", "7", "8", "9", "10", 
		"J", "Q", "K"
	};

	public Card(int value) {
		this.value = value;
		this.name = nameFromVal[value - 1];
	}

	// returns value in order to calculate deck later.
	public int getValue() {
		return this.value;
	}

	// Show this if the card is hidden.
	public void printBack(ColumnPrinter printer) {
		printer.add(new String[]{
			" _____ ",
			"|OOOOO|",
			"|ooooo|",
			"|.....|",
			"|_____|",
		});
	}

	// Show this if the card is visible
	// The value is printed on the card
	public void printFront(ColumnPrinter printer) {
		String topNumber = this.name;
		String bottomNumber = this.name;

		/* 
			Weird edge case: if the value is 10, the design is ruined
	 		This fixes the design, by adding an addition space if it is a single face value. 
		*/
		if (this.name.length() <= 1) {
			topNumber += " ";
			bottomNumber = " " + bottomNumber;
		}

		// to be printed later
		printer.add(new String[]{
			" _____ ",
			"|     |",
			
			"|" + topNumber + "   |",
			"|   "+ bottomNumber + "|",
			
			"|_____|",
		});
	}
}