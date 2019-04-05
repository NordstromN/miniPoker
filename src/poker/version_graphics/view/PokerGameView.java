package poker.version_graphics.view;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
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
	private BorderPane root;
	private Scene scene;
	
	public PokerGameView(Stage stage, PokerGameModel model) {
			this.model = model;
			
			// Create the view of players, set them central in the middle
			players = new VBox();
			players.setAlignment(Pos.CENTER);
			for (int i = 0; i < PokerGame.num_players; i++) {
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
			this.root = new BorderPane();
		
			// Put menu, players and controls into a BorderPane
			root.setTop(menuBar);
			root.setCenter(players);
			root.setBottom(controls);
			root.setMinSize(1280, 800);
			root.setMaxSize(1280, 1200);	
			
			// Disallow resizing - which is difficult to get right with images
			stage.setResizable(false);

	        // Create the scene using our layout; then display it
	        this.scene = new Scene(root);
	        scene.getStylesheets().add(
	                getClass().getResource("poker.css").toExternalForm());
	        stage.setTitle("Poker Miniproject");
	        stage.setScene(scene); 
	        stage.show();	
	        
	        // if request on Stage close, than method closeProgram which will open an ConfirmBox
	        stage.setOnCloseRequest(e -> {
	        	e.consume();
	        	closeProgram(stage);	
	        });
	        
		}
		
		// Link to ConfirmBoxClose, which opens the window
		private void closeProgram(Stage stage) {
			boolean choice = ConfirmBoxClose.display("Quit?", "You lost already a lot of money!!! \nDo you really want to quit?");
			if (choice)
			stage.close();
		}
		
		
		//Makes animation for player
		public void playerAnimation(int i) {
			getPlayerPane(i).animationStatus();
		}
		
	
		
		public PlayerPane getPlayerPane(int i) {
			return (PlayerPane) players.getChildren().get(i);
		}
	
		// Returns the Label of the CurrentStatus, as the Controller needs to setText on this
		public Label getCurrentStatus(int i) {
			return getPlayerPane(i).getCurrentStatus();
		}
	
	
		//Getter methods for the buttons	
		public Button getShuffleButton() {
			return controls.btnShuffle;
		}

		
		public Button getDealButton() {
			return controls.btnDeal;
		}
		
		public Button getShufDeaButton() {
			return controls.btnShufDea;
		}
		//Below the getter methods for the menu items
		public MenuItem getnewGame() {
			return menuBar.newGame;
		}
		
		// Returns the MenuItem of Change Player, controller requires connection
		public MenuItem getPlayerSettings() {
			return menuBar.changePl;
		}

		// Returns the MenuItem of ColorItem, controller requires connection
		public MenuItem getSettingsBox() {
			return menuBar.changeColourItem;
		}
		

		// Returns the MenuItem of Statistics, controller requires connection
		public MenuItem getStatistics() {
			return menuBar.statGameItem;
		}
				
		
		public PlayerBox getPlayer() {
			PlayerBox b1 = new PlayerBox();
			return b1;
		}
		
		
		// set CSS File on what Settings have been chosen in the Static window SettingsBox.changeSettings()
		public void setCSSFile() {
			
			int i = SettingsBox.changeSettings();
			
			switch(i) {
				
			case 0:
				scene.getStylesheets().clear();
				  scene.getStylesheets().add(
			                getClass().getResource("poker.css").toExternalForm());
				
				break;
			case 1:
				scene.getStylesheets().clear();
				  scene.getStylesheets().add(
			                getClass().getResource("poker1.css").toExternalForm());

				break;
				
			case 2:
				scene.getStylesheets().clear();
				  scene.getStylesheets().add(
			                getClass().getResource("poker2.css").toExternalForm());
				  
				break;
			}	
		}
}

		
		
		