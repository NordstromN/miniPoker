package poker.version_graphics.model;

import java.util.ArrayList;

public class Round {
	
	private ArrayList<Card> cards	= new ArrayList<Card>();
	
    
	private Status status;
    
	public Round (ArrayList<Card> cards, Status status) {
		this.cards = cards;
		this.status = status;
	}

	public ArrayList<Card> getCards(){
		return this.cards;
	}
	
	public Status getStatus() {
		return this.status;
	}
	
	public String toString() {
		String cardString = "";
		for (Card currentCard : cards) {
			cardString += currentCard +" ";
		}
		cardString +="\n\n"+HandType.evaluateHand(cards);
		cardString +="\n\n"+this.status;
		
		return cardString;
	}

}
