package poker.version_graphics.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public enum HandType {
    HighCard (1), OnePair(2), TwoPair(3), ThreeOfAKind(4), 
    Straight(5), Flush(6), FullHouse(7), FourOfAKind(8), StraightFlush(9), RoyalFlush(10);
    
	private int valueHandType;
	
	private HandType(int valueHandType) {
		this.valueHandType = valueHandType;
	}
	
	public int getHandTypeRankValue() {
		return this.valueHandType;
	}
	
	
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
    
    
    // returns the Pair ranking. Return can be used to compare with other cards Pair
    public static int isOnePairRank(ArrayList<Card> cards) {
        boolean found = false;
        int value = 0;
        for (int i = 0; i < cards.size() - 1 && !found; i++) {
            for (int j = i+1; j < cards.size() && !found; j++) {
                if (cards.get(i).getRank() == cards.get(j).getRank()) 
                	found = true;
                	value = cards.get(i).getRank().getRankValue();
            }
        }
        return value;
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
    

    // returns the Pair ranking. Return can be used to compare with other cards Pair
    
    public static int isTwoPairRank(ArrayList<Card> cards, int pairWish) {
        // Clone the cards, because we will be altering the list
        ArrayList<Card> clonedCards = sortCards((ArrayList<Card>) cards.clone());
        int firstPairRank = 0;
        int secondPairRank = 0;
        // Find the first pair; if found, remove the cards from the list
        boolean firstPairFound = false;
        for (int i = 0; i < clonedCards.size() - 1 && !firstPairFound; i++) {
            for (int j = i+1; j < clonedCards.size() && !firstPairFound; j++) {
                if (clonedCards.get(i).getRank() == clonedCards.get(j).getRank()) {
                	if (firstPairFound = false) {
                		firstPairRank = clonedCards.get(i).getRank().getRankValue();
                	}
                	if (firstPairFound = true) {
                		secondPairRank = clonedCards.get(i).getRank().getRankValue();
                	}
                	firstPairFound = true;
                    
                    clonedCards.remove(j);  // Remove the later card
                    clonedCards.remove(i);  // Before the earlier one
                }
            }
        }
        // If a first pair was found, see if there is a second pair
        if (pairWish == 2) {
        	return secondPairRank;
        } else{
        	return firstPairRank;
        }
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
    
    public static int isThreeOfAKindRank(ArrayList<Card> cards) {
        int value = 0;
    	for (int i = 0; i<cards.size()-2; i++) {
    		for (int j = i+1; j<cards.size()-1; j++) {
    			for (int k = j+1; k<cards.size(); k++) {
    				if (cards.get(i).getRank() == cards.get(j).getRank() &&
    					cards.get(j).getRank() == cards.get(k).getRank()) {
    					value = cards.get(i).getRank().getRankValue();
    				}
    			}
    		}
    	}      
        return value;
    }
    
    
    
    
    
    public static boolean isStraight(ArrayList<Card> cards) {
    	// Sort Array
    	ArrayList<Card> sortedArray = sortCards(cards);
        int count = 0;
        // check if next card is Rank +1, if 4 Times true, than it is a straight
        for (int i = 0; i < 4; i++) {
        	if((sortedArray.get(i).getRank().getRankValue()+1)
        			== sortedArray.get(i+1).getRank().getRankValue()) {
        		count ++;
        	}
        }
    	return (count==4);
    }
    
    //returns the Highest Card of a Straight
    public static int isStraightRank(ArrayList<Card> cards) {
    	// Sort Array
    	ArrayList<Card> sortedArray = sortCards(cards);
        
        int value = sortedArray.get(4).getRank().getRankValue();
        
    	return value;
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
        // Clone the cards, because we will be altering the list
        ArrayList<Card> clonedCards = (ArrayList<Card>) cards.clone();

        // Find three of a kind; if found, remove the cards from the list
        boolean threeOfAKindFound = false;
        boolean twoOfAKindFound = false;
        for (int i = 0; i < clonedCards.size() - 1 && !threeOfAKindFound; i++) {
            for (int j = i+1; j < clonedCards.size() && !threeOfAKindFound; j++) {
               for (int k = j+1; k < clonedCards.size() && !threeOfAKindFound; k++) {
            	   if (clonedCards.get(i).getRank() == clonedCards.get(j).getRank()
            			   && clonedCards.get(j).getRank() == clonedCards.get(k).getRank()) {
                   	   threeOfAKindFound = true;
                   	   clonedCards.remove(k);  // Remove the latest card
                       clonedCards.remove(j);  // Remove the later card
                       clonedCards.remove(i);  // Before the earlier one   
            	   }
                }
            }
        }
        // If a three of a kind found, see if there is a second pair
        return threeOfAKindFound && isOnePair(clonedCards);
    }
    
    public static int isFourOfAKindRank(ArrayList<Card> cards) {
    	int value = 0;    	
    	
    	for (int i = 0; i<cards.size()-3; i++) {
    		for (int j = i+1; j<cards.size()-2; j++) {
    			for (int k = j+1; k<cards.size()-1; k++) {
    				for (int l = k+1; l<cards.size(); l++) {
    					if (cards.get(i).getRank() == cards.get(j).getRank() &&
        						cards.get(j).getRank() == cards.get(k).getRank() &&
        						cards.get(k).getRank() == cards.get(l).getRank()) {
        					value = cards.get(j).getRank().getRankValue();			
    					}
    				}
    			}
    		}
    	}      
        return value;
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
