package poker.version_graphics.controller;

import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import poker.version_graphics.PokerGame;
import poker.version_graphics.model.Card;
import poker.version_graphics.model.DeckOfCards;
import poker.version_graphics.model.Player;
import poker.version_graphics.model.PokerGameModel;
import poker.version_graphics.view.HistoryBox;
import poker.version_graphics.view.PlayerBox;
import poker.version_graphics.view.PlayerPane;
import poker.version_graphics.view.PokerGameView;

public class PokerGameController {
	private PokerGameModel model;
	private PokerGameView view;
	private PokerGame start = new PokerGame();
		
	public PokerGameController(PokerGameModel model, PokerGameView view) {
		this.model = model;
		this.view = view;

		//Buttons in the view
		view.getShuffleButton().setOnAction(e -> shuffle());
		view.getDealButton().setOnAction(e -> deal());
		view.getShufDeaButton().addEventHandler(ActionEvent.ACTION, (e)-> {
			shuffle();
			deal();	
		});
		//MenuItems with event triggered
		view.getnewGame().setOnAction(e -> newGame());
		view.getPlayerSettings().setOnAction(e-> actualizePlayerCount());
		view.getSettingsBox().setOnAction(e-> setSettings());
		view.getStatistics().setOnAction(e-> showHistory());
		
	}
	
	// set CSS Settings
	private void setSettings() {
		view.setCSSFile();
	}
	
	private void showHistory() {
		HistoryBox.historyBox(model.getPlayers());
	}
	

	
	//Starting a new game 
	private void newGame() {
		try {
			start.start(PokerGame.primarySt);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("I find your lack of faith disturbing" +e);
		}
	}
	
	//Restart the game after changing number of players
	private void actualizePlayerCount() {
		int i = PlayerBox.newPlayer();
		PokerGame.num_players = i;
		try {
			start.start(PokerGame.primarySt);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("May the force be with you" + e);
		}
	}
	
	/**
     * Remove all cards from players hands, and shuffle the deck
     */
	
	private void shuffle() {
    	for (int i = 0; i < PokerGame.num_players; i++) {
    		Player p = model.getPlayer(i);
    		p.discardHand();
    		PlayerPane pp = view.getPlayerPane(i);
    		pp.updatePlayerDisplay();
    	}

    	model.getDeck().shuffle();
    }
    
    /**
     * Deal each player five cards, then evaluate the two hands
     */
    private void deal() {
    	int cardsRequired = PokerGame.num_players * Player.HAND_SIZE;
    	DeckOfCards deck = model.getDeck();
    	if (cardsRequired <= deck.getCardsRemaining()) {
        	for (int i = 0; i < PokerGame.num_players; i++) {
        		Player p = model.getPlayer(i);
        		p.discardHand();
        		for (int j = 0; j < Player.HAND_SIZE; j++) {
        			Card card = deck.dealCard();
        			p.addCard(card);
        		}
        		p.evaluateHand();
        		
        		///////////////////////////////////////////////////////////////////////////////
        		
        		
        		///////////////////////////////////////////////////////////////////////////////
        		
        		PlayerPane pp = view.getPlayerPane(i);
        		pp.updatePlayerDisplay();
        	}
        	

        	for (int i=0; i<PokerGame.num_players; i++) {
        		
        		view.getCurrentStatus(i).setText(model.getPlayer(i).getCurrentStatus());
        		view.playerAnimation(i);   		        		
        	}

        	for (int i=0; i<PokerGame.num_players; i++) {
        		view.getPlayerPane(i).setTextWonLabel();	
        	}
        	model.actualizePlayers();
        	
    	} else {
            Alert alert = new Alert(AlertType.ERROR, "Not enough cards - shuffle first");
            alert.showAndWait();
    	}
    	
    	
    }
}
