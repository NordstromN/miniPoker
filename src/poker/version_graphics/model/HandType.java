package poker.version_graphics.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public enum HandType {
    HighCard, OnePair, TwoPair, ThreeOfAKind, Straight, Flush, FullHouse, FourOfAKind, StraightFlush, RoyalFlush;
    
    /**
     * Determine the value of this hand. Note that this does not
     * account for any tie-breaking
     */
    public static HandType evaluateHand(ArrayList<Card> cards) {
        HandType currentEval = HighCard;
        
        if (isOnePair(cards)) currentEval = OnePair;
        if (isTwoPair(cards)) currentEval = TwoPair;
        if (isThreeOfAKind(cards)) currentEval = ThreeOfAKind;
        if (isStraight(cards)) currentEval = Straight;
        if (isFlush(cards)) currentEval = Flush;
        if (isFullHouse(cards)) currentEval = FullHouse;
        if (isFourOfAKind(cards)) currentEval = FourOfAKind;
        if (isStraightFlush(cards)) currentEval = StraightFlush;
        if (isRoyalFlush(cards)) currentEval = RoyalFlush;
        
        return currentEval;
    }
    
    public static boolean isOnePair(ArrayList<Card> cards) {
        boolean found = false;
        for (int i = 0; i < cards.size() - 1 && !found; i++) {
            for (int j = i+1; j < cards.size() && !found; j++) {
                if (cards.get(i).getRank() == cards.get(j).getRank()) found = true;
            }
        }
        return found;
    }
    
    public static boolean isTwoPair(ArrayList<Card> cards) {
        // Clone the cards, because we will be altering the list
        ArrayList<Card> clonedCards = (ArrayList<Card>) cards.clone();

        // Find the first pair; if found, remove the cards from the list
        boolean firstPairFound = false;
        for (int i = 0; i < clonedCards.size() - 1 && !firstPairFound; i++) {
            for (int j = i+1; j < clonedCards.size() && !firstPairFound; j++) {
                if (clonedCards.get(i).getRank() == clonedCards.get(j).getRank()) {
                    firstPairFound = true;
                    clonedCards.remove(j);  // Remove the later card
                    clonedCards.remove(i);  // Before the earlier one
                }
            }
        }
        // If a first pair was found, see if there is a second pair
        return firstPairFound && isOnePair(clonedCards);
    }
    
    public static boolean isThreeOfAKind(ArrayList<Card> cards) {
        
    	boolean threeOfAKindFound = false;
    	
    	for (int i = 0; i<cards.size()-2; i++) {
    		for (int j = i+1; j<cards.size()-1; j++) {
    			for (int k = j+1; k<cards.size(); k++) {
    		
    				if (cards.get(i).getRank() == cards.get(j).getRank() &&
    						cards.get(j).getRank() == cards.get(k).getRank()) {
    					threeOfAKindFound = true;
    				}
    			}
    		}
    	}      
        return threeOfAKindFound;
    	
    }
    
    public static boolean isStraight(ArrayList<Card> cards) {
        ArrayList<Card> sortedArray = sortCards(cards);
    	
        // subtracts value of lowest card rank with highest card rank, if
        // value equals 4, than it is a straight, in other case not
        
        int highCard = sortedArray.get(4).getRank().getRankValue();
        int lowCard = sortedArray.get(0).getRank().getRankValue();
        
        return ((highCard - lowCard)==4); 
    }
    
    public static boolean isFlush(ArrayList<Card> cards) {
    	// equals method from Class Card
    	return(
    			cards.get(0).equals(cards.get(1))
    			&& cards.get(1).equals(cards.get(2))
    			&& cards.get(2).equals(cards.get(3))
    			&& cards.get(3).equals(cards.get(4))
    			); 	
    }
    
    public static boolean isFullHouse(ArrayList<Card> cards) {
        // TODO        
        return false;
    }
    
    public static boolean isFourOfAKind(ArrayList<Card> cards) {
    	boolean fourOfAKindFound = false;    	
    	
    	for (int i = 0; i<cards.size()-3; i++) {
    		for (int j = i+1; j<cards.size()-2; j++) {
    			for (int k = j+1; k<cards.size()-1; k++) {
    				for (int l = k+1; l<cards.size(); l++) {
    					if (cards.get(i).getRank() == cards.get(j).getRank() &&
        						cards.get(j).getRank() == cards.get(k).getRank() &&
        						cards.get(k).getRank() == cards.get(l).getRank()) {
        					fourOfAKindFound = true;			
    					}
    				}
    			}
    		}
    	}      
        return fourOfAKindFound;
    }
    
    public static boolean isStraightFlush(ArrayList<Card> cards) {        
    	return isFlush(cards) && isStraight(cards);
    }
    
    public static boolean isRoyalFlush(ArrayList<Card> cards) {
    	return (
    			//Highest Card of StraightFlush must be Ace -> Value 14
    			isStraightFlush(cards)
    			&& sortCards(cards).get(4).getRank().getRankValue() == 14);
    }
    
    //Sorts the cards
    public static ArrayList<Card> sortCards(ArrayList<Card> cards){
    	ArrayList<Card> sortedCards = cards;
    	
    	Collections.sort(sortedCards, new Comparator<Card>()
    			{
    			public int compare(Card c1, Card c2)
    			{
    				return Integer.valueOf(c1.getRank().getRankValue())
    						.compareTo(c2.getRank().getRankValue());
    			}
    			});
    	return sortedCards;
    }
}
