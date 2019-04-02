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
	private MenBar menuBar;
	private PokerGameModel model;
	
	public PokerGameView(Stage stage, PokerGameModel model) {
			this.model = model;
			
			
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
		
			
			//create the MenuBar
			menuBar = new MenBar();

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
	        
	        stage.setOnCloseRequest(e -> {
	        	e.consume();
	        	closeProgram(stage);	
	        });
	        
		}
		
		private void closeProgram(Stage stage) {
			boolean choice = ConfirmBoxClose.display("Quit?", "Are you sure, that you want to quit?");
			if (choice)
			stage.close();
		}
	
	
	
		public PlayerPane getPlayerPane(int i) {
			return (PlayerPane) players.getChildren().get(i);
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
		
		}