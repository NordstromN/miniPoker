package poker.version_graphics.view;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.geometry.Pos;
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
	private BorderPane root;
	private CardBackDeck cbd;
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
			
			//create the card deck to deal out of
			cbd = new CardBackDeck();
			cbd.setAlignment(Pos.BOTTOM_CENTER);
			
			// Create root and set size
			this.root = new BorderPane();
		
			// Put menu, players and controls into a BorderPane
			root.setTop(menuBar);
			root.setCenter(players);
			root.setRight(cbd);
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
			boolean choice = ConfirmBoxClose.display("Quit?", "Are you sure, that you want to quit?");
			if (choice)
			stage.close();
		}
	
	
		public PlayerPane getPlayerPane(int i) {
			return (PlayerPane) players.getChildren().get(i);
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
		
		public MenuItem getPlayerSettings() {
			return menuBar.changePl;
		}
		
		public MenuItem getSettingsBox() {
			return menuBar.changeColourItem;
		}
				
		public PlayerBox getPlayer() {
			
			PlayerBox b1 = new PlayerBox();
			return b1;
			
		}
		
		
		
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

		
		
		