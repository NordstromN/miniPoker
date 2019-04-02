package poker.version_graphics.model;

import poker.version_graphics.model.Card.Rank;
import poker.version_graphics.model.Card.Suit;


public class HistoryTest {

	public static void main(String[] args) {
		
		Card c1 = new Card(Suit.Clubs, Rank.Ace);
		Card c2 = new Card(Suit.Clubs, Rank.Queen);
		Card c3 = new Card(Suit.Clubs, Rank.Ten);
		Card c4 = new Card(Suit.Clubs, Rank.Jack);
		Card c5 = new Card(Suit.Clubs, Rank.King);
		
		Player p1 = new Player("El Huron");
		p1.addCard(c1, c2, c3, c4, c5);
	
		Round round = new Round(p1.getCards(), Status.loss);
		//Test print Round
		// System.out.println(round);
		
		Card c6 = new Card(Suit.Hearts, Rank.Eight);
		Card c7 = new Card(Suit.Diamonds, Rank.Queen);
		Card c8 = new Card(Suit.Hearts, Rank.Ten);
		Card c9 = new Card(Suit.Spades, Rank.Jack);
		Card c10 = new Card(Suit.Hearts, Rank.Nine);
		
		Player p2 = new Player("El Huron");
		p2.addCard(c6, c7, c8, c9, c10);
	
		Round round2 = new Round(p2.getCards(), Status.won);
		
		
		
		
		
		
		History history = new History();
		history.addRound(round);
		history.addRound(round2);
		System.out.println(history);
		
		
		//Test HandType
		//System.out.println(HandType.evaluateHand(p1.getCards()));
		
	}

}
