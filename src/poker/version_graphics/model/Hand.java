package poker.version_graphics.model;

import java.util.ArrayList;

public class Hand {
	
	private ArrayList<Card> cards = new ArrayList<Card>();
	private Status status =null;

	public Hand(ArrayList<Card> cards, Status status) {
		this.cards = cards;
		this.status = status;
	}
	
	public ArrayList<Card> getHand(){
		return this.cards;
	}
	
	public Status getStatus() {
		return this.getStatus();
	}
}
