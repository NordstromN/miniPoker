package poker.version_graphics.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import poker.version_graphics.PokerGame;

public class PokerGameModel {
	private final ArrayList<Player> players = new ArrayList<>();
	private DeckOfCards deck;
	
	public PokerGameModel() {
		for (int i = 0; i < PokerGame.num_players; i++) {
			players.add(new Player("Player " + i));
		}
		deck = new DeckOfCards();
	}
	
	//returns the player searched int i
	public Player getPlayer(int i) {
		return players.get(i);
	}
	
	// returns the Arraylist of the Current players
	public ArrayList <Player> getPlayers(){
		return players;
	}
	
	public DeckOfCards getDeck() {
		return deck;
	}
	
	// iterate threw players and opens their method actualizeRound
	public void actualizePlayers() {
		for (int i = 0; i<players.size();i++) {
			players.get(i).actualizeRound(players);
		}
	}
	
}
