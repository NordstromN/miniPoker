package poker.version_graphics.model;

import java.util.ArrayList;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Player implements Comparable<Player> {
    public static final int HAND_SIZE = 5;
    
    private ArrayList<Hand> history = null;
    //
    
    private ObservableList<Hand> obsList= FXCollections.observableArrayList();
    
    //
    private int won = 0;
    private final String playerName; // This is the ID
    private final ArrayList<Card> cards = new ArrayList<>();
    private HandType handType;
    
    public Player(String playerName) {
        this.playerName = playerName;       
    }
    
    public void addCardsToHistory() {
    	//TODO round Won, loss, even
    	Hand hand = new Hand(this.cards, Status.won);
    	this.history.add(hand);
    	obsList.clear();
    	obsList.addAll(this.history);
    }
    
    public ObservableList<Hand> getObservableList(){
    	return this.obsList;
    }

    public String getPlayerName() {
        return playerName;
    }

    public ArrayList<Card> getCards() {
        return cards;
    }
    
    public void addCard(Card card) {
        if (cards.size() < HAND_SIZE) cards.add(card);
    }
    
    public void discardHand() {
        cards.clear();
        handType = null;
    }
    
    public int getNumCards() {
        return cards.size();
    }

    /**
     * If the hand has not been evaluated, but does have all cards, 
     * then evaluate it.
     */
    public HandType evaluateHand() {
        if (handType == null && cards.size() == HAND_SIZE) {
            handType = HandType.evaluateHand(cards);
        }
        return handType;
    }

    /**
     * Hands are compared, based on the evaluation they have.
     */
    @Override
    public int compareTo(Player o) {
        return handType.compareTo(o.handType);
    }
    
    // TEST Methoden delete
    
    public void addCard(Card c1, Card c2, Card c3, Card c4, Card c5) {
    	cards.add(c1);   
    	cards.add(c2);   
    	cards.add(c3);   
    	cards.add(c4);   
    	cards.add(c5);   
    }
    
    public void printCard() {
    	for (Card currentCard : cards) {
    		System.out.println(currentCard);
    	}
    }
    
}
