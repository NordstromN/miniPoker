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
	
	
}
