# A quick introduction

Blackjack is a card game in which the player competes against the dealer, and in this case the computer is the dealer. 

Upon executing the program, the user picks between **"easy"** and **"hard"** difficulty. 
	1) Easy mode has a computer with no form of checks, so just picks randomly if they  are to stay or hit.
	2) Hard mode has a computer with checks to make sure it is picking the best option, despite the randomness of the card.

Each round type: 
	***"hit"***) to get a new random card from the pile.
 	***"stay"***) to stay and not recieve a card this round.

Who ever has the deck with highest value **wins**, but the value **cannot** exceed *21* —in which case it is a **bust**. 

## Overview of the project.

### Main.java

This file contains static method that essentially starts the game.

This file introduces the game, takes the input for gamemode and selecting the proper computer bot, constructing the round class, and lastly, adds replayability.  

### Round.java

This file contains the class that manages each game. 
The class is constructed with a given number of rounds.

This class takes in an computer bot, and constructs the player object.
This class manages the round system —as it's name suggests— and end game (calculating winners, displaying the computer cards' values).

Each round, it checks if a player busted (went over 21).

### Card.java

This file contains the class that represents a card in the game.
A card class contains value, name, and methods that print properly.

The print methods utilizes a ColumnPrinter object, in order to display the cards in 1 line.

The class is able to print back, which is displayed when a card is hidden, and is able to print front, which displays the card with the value shown.

### ColumnPrinter.java

If I normally print out the ASCII art, it will print one card, but must print next card in a different row. Hence, it would be super akward and hard to play, when there are multiple cards.

Column printer is a glorified ArrayList that concatnates the strings in an ArrayList (index 0 represents line 1, index 1 represents line 2...).

When rendering, it prints index by index. 

For example:
```java
ColumnPrinter printer = new ColumnPrinter();
printer.add(new String[]{
	" _____ ",
	"|     |",
	"|K    |",
	"|    K|",
	"|_____|",
});
printer.add(new String[]{
	" _____ ",
	"|OOOOO|",
	"|ooooo|",
	"|.....|",
	"|_____|",
});
printer.render();
```
Here is the output: 

```
 _____   _____ 
|     | |OOOOO|
|K    | |ooooo|
|    K| |.....|
|_____| |_____|

...
```

### PlayerBase.java

The base class representing all players (dealer, real life players, and etc).

The class contains an ArrayList of all Cards, and a column printer. 
This class also contains basic methods such as rendering the column printer, and selecting a card randomly.

### Player.java (extends PlayerBase.java)

Overrides a PlayerBase's method, which decides if they player should hit or stay.

The class uses the scanner object to decide if the player should stay or hit. 

### Dealer.java (extends PlayerBase.java)

Overrides a PlayerBase's method, which decides if they computer should hit or stay.

If it is the first choice, the computer hits.

Otherwise, the computer generates a random number between 0 and 1. The computer hits if the random number is 1; otherwise, stays.

The dealer also doesn't show it's cards, but instead shows the back design. 

### HardDealer.java (extends Dealer.java)

Simply overrides Dealer, but instead goes through serious of checks to pick the best optons in Blackjack.

# THE END.