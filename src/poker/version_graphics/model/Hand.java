package poker.version_graphics.model;

import java.util.ArrayList;

public class Hand {
	
	private ArrayList<Card> cards = new ArrayList<Card>();
	private int roundResult = 0;

	public Hand(ArrayList<Card> cards, int roundResult) {
		this.cards = cards;
		this.roundResult = roundResult;
	}
	
	public ArrayList<Card> getHand(){
		return this.cards;
	}
	
	public int getRoundResult() {
		return this.roundResult;
	}
	
	public String toString() {
		String cardsString ="";
		cardsString+= "Result: ";
		if (roundResult < 0) cardsString += "loss\n";		
		if (roundResult > 0) cardsString += "win\n";	
		if (roundResult == 0) cardsString += "even\n";	
		for (int i = 0; i<cards.size(); i++) {
			cardsString += cards.get(i) +" | ";
		}
		cardsString+= "\n*******************************\n";
		return cardsString;
		
	}
	
	
}
