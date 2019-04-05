package poker.version_graphics.model;

import java.util.ArrayList;

public class Hand {
	
	private HandType handType;
	private int roundResult = 0;

	public Hand(HandType handType, int roundResult) {
		this.handType = handType;
		this.roundResult = roundResult;
	}
	

	
	public int getRoundResult() {
		return this.roundResult;
	}
	
	public String toString() {
		String cardsString ="";
		cardsString+= "Handtype: \t"+this.handType.name()+"\n";
		cardsString+= "Result: \t\t";
		if (roundResult < 0) cardsString += "loss\n";		
		if (roundResult > 0) cardsString += "win\n";	
		if (roundResult == 0) cardsString += "even\n";	
		
		cardsString+= "\n*******************************\n";
		return cardsString;
		
	}
	
	
}
