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
		p1.printCard();
		
		System.out.println(HandType.evaluateHand(p1.getCards()));
		
	}

}
