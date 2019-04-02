package poker.version_graphics.view;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import poker.version_graphics.PokerGame;
import poker.version_graphics.model.PokerGameModel;

public class PokerGameView {
	private VBox players;
	private ControlArea controls;
	private PokerGameModel model;
	private MenuBar menuBar;
	private Menu game, settings;
	private MenuItem changPl, statGameItem, closeGameItem, changeColourItem;
	
	public PokerGameView(Stage stage, PokerGameModel model) {
		this.model = model;
		
		//Create and add MenuBar and first Menu Point
		menuBar = new MenuBar();
		game = new Menu("Game");
		//Change nr of player in the game
		changPl = new MenuItem("Change Player");
		//Show Statistics of the game		
		statGameItem = new MenuItem("Statistics");
		//Leave the game
		closeGameItem = new MenuItem("Close Game");
		closeGameItem.setOnAction((ActionEvent e) -> Platform.exit());
		menuBar.getMenus().add(game);
		game.getItems().addAll(changPl, statGameItem, closeGameItem);
		
		//Add another Menu for Settings
		settings = new Menu("Settings");
		changeColourItem = new MenuItem("Change Colour");
		//hangeColourItem.setOnAction((ActionEvent e) -> lülülülülü);
		menuBar.getMenus().add(settings);
		settings.getItems().add(changeColourItem);

		//this.getMenus().addAll(game,settings);
		
		// Create all of the player panes we need, and put them into an HBox
		players = new VBox();
		for (int i = 0; i < PokerGame.NUM_PLAYERS; i++) {
			PlayerPane pp = new PlayerPane();
			pp.setPlayer(model.getPlayer(i)); // link to player object in the logic
			players.getChildren().add(pp);
		}
			
		// Create the control area
		controls = new ControlArea();
		controls.linkDeck(model.getDeck()); // link DeckLabel to DeckOfCards in the logic
		
		// Create root and set size
		BorderPane root = new BorderPane();
	
			// Put menu, players and controls into a BorderPane
		root.setTop(menuBar);
		root.setCenter(players);
		root.setBottom(controls);
		root.setMinSize(1280, 800);
		root.setMaxSize(1280, 800);	
		
		
		// Disallow resizing - which is difficult to get right with images
		stage.setResizable(false);

        // Create the scene using our layout; then display it
        Scene scene = new Scene(root);
        scene.getStylesheets().add(
                getClass().getResource("poker.css").toExternalForm());
        stage.setTitle("Poker Miniproject");
        stage.setScene(scene); 
        stage.show();		
	}
	
	public PlayerPane getPlayerPane(int i) {
		return (PlayerPane) players.getChildren().get(i);
	}
	
	public MenuItem getChangPl() {
		return this.changPl;
	}
	
	
	public Button getShuffleButton() {
		return controls.btnShuffle;
	}

	public Button getDealButton() {
		return controls.btnDeal;
	}
	
	public Button getShufDeaButton() {
		return controls.btnShufDea;
	}
	
	public void newGame() {
		
		
		
		
	}
	}
	
