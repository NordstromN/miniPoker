package poker.version_graphics.model;

import java.util.ArrayList;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Player implements Comparable<Player> {
    public static final int HAND_SIZE = 5;
    private ArrayList<Hand> history = null;
    private int roundResult = 0;
    //
    
    private final String playerName; // This is the ID
    private final ArrayList<Card> cards = new ArrayList<>();
    private HandType handType;
    
    public Player(String playerName) {
        this.playerName = playerName;  
        this.history = new ArrayList<Hand>();
    }
    
    public void addCardsToHistory() {
    	//TODO round Won, loss, even
    	Hand hand = new Hand(this.cards, this.roundResult);
    	this.history.add(hand);
    }

    public String getPlayerName() {
        return playerName;
    }
    
    
    public int getWon() {
    	int wonHistory = 0;
    	if(history == null || history.size()<1) {
    		
    	} else {
    		for (int i = 0; i<history.size(); i++) {
        		if(history.get(i).getRoundResult()==1) {
        			wonHistory ++;
        		}
        	}		
    	}
    	
    	return wonHistory;
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
    	int value = handType.compareTo(o.handType);
    	if (handType.compareTo(o.handType) == 0) {
    		if (this.handType.equals(handType.OnePair)) {
    			if (handType.isOnePairRank(this.cards)>handType.isOnePairRank(o.cards)) {
    				value = 1;
    			}
    		}
    	}
    	
    	
    	return value;
        
    }
    
    
    public void actualizeRound(ArrayList <Player> players) {
    	// find Player  card in Array List
    	// remove Player
    	int resultCounter;
    	ArrayList <Player> clonedPlayers = (ArrayList<Player>) players.clone();
    	
    	boolean cardFound = false;
    	for (int i = 0; i<clonedPlayers.size() && !cardFound; i++) {
    		if(this.getPlayerName() == clonedPlayers.get(i).getPlayerName()) {
    			clonedPlayers.remove(i);
    			cardFound = true;
    		}
    	}
    	
    	int counterWon = 0;
    	int counterLoss = 0;
    	int counterEven = 0;
    	
    	for (int i = 0; i<clonedPlayers.size(); i++) {
    		if(this.compareTo(clonedPlayers.get(i))<0){
    			counterLoss--;
    		} 
    		if(this.compareTo(clonedPlayers.get(i))>0){
    			counterWon++;
    		} 
    		if(this.compareTo(clonedPlayers.get(i))==0){
    			counterEven++;
    		} 
    	}
    	
    	
    	if (counterWon == clonedPlayers.size()) {
    		resultCounter = 1;
    	} else if  (counterLoss >= 1) {
    		resultCounter = -1;
         	} else {
         		resultCounter = 0;
         	}
    	this.roundResult = resultCounter;
    	
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
    
    public void roundResult(int i) {
    	this.roundResult = i;
    }
    
    
    
    public HandType getHandType() {
    	return this.handType;
    }
   
    
}
