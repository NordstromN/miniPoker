package poker.version_graphics.view;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import poker.version_graphics.controller.PokerGameController;

public class MenBar extends MenuBar{

	
	
	//Create the contructor for MenuBar with two Menues and 4 Items
	public MenBar() {
	
	Menu game = new Menu("Game");

	// Start the Game new including deleting the played hands out the history
	MenuItem newGameItem = new MenuItem("New Game");
	//newGameItem.setOnAction((Actionevent e) -> );
	
	MenuItem changPl = new MenuItem("Change Player");
	
	MenuItem statGameItem = new MenuItem("Statistics");
	
	//Setting exit
	MenuItem closeGameItem = new MenuItem("Close Game");
	closeGameItem.setOnAction((ActionEvent e) -> Platform.exit());
	
	
	game.getItems().addAll(newGameItem, changPl, statGameItem, closeGameItem);
	
	Menu settings = new Menu("Settings");
	MenuItem changeColourItem = new MenuItem("Change Colour");
	
	//changeColourItem.setOnAction((ActionEvent e) -> lülülülülü);
	
//	changeColourItem.setOnAction((ActionEvent f) -> changecolor(f));
	
	settings.getItems().add(changeColourItem);

	this.getMenus().addAll(game,settings);
	
		
	

	}

	
}

	