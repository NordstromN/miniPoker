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
	
	public Player getPlayer(int i) {
		return players.get(i);
	}
	
	public ArrayList <Player> getPlayers(){
		return players;
	}
	
	public DeckOfCards getDeck() {
		return deck;
	}
	
	public void actualizePlayers() {
		for (int i = 0; i<players.size();i++) {
			players.get(i).actualizeRound(players);
		}
	}
	
	
	
	
	/*
	public void checkWinner() {		
		
		int playerWonPosition = 0;
		int secondPlayerPosition = 0;
		ArrayList<Player> clonePlayers = new ArrayList<Player>();
		clonePlayers = this.players;
		
		Collections.sort(clonePlayers, new Comparator<Player>()
		{
			public int compare(Player c1, Player c2)
			{
			return Integer.valueOf(c1.compareTo(c2));
			}
		});
		
		for (int i = 0; i<clonePlayers.size(); i++) {
			if (clonePlayers.get(clonePlayers.size()-1).equals(this.players.get(i))) {
				playerWonPosition = i;
			}
		}
		
		for (int i = 0; i<clonePlayers.size(); i++) {
			if (clonePlayers.get(clonePlayers.size()-2).equals(this.players.get(i))) {
				secondPlayerPosition = i;
			}
		}	
		
		
		if (players.get(playerWonPosition).compareTo(players.get(secondPlayerPosition))==0) {
			players.get(playerWonPosition).roundResult(0);
		} else {
			players.get(playerWonPosition).roundResult(1);
		}
		
	}	
	*/
	
}
