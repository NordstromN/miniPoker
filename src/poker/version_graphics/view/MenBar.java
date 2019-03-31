package poker.version_graphics.view;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;

public class MenBar extends MenuBar{

	//Create the contructor for MenuBar with two Menues and 4 Items
	
	public MenBar() {
	
	Menu game = new Menu("Game");
	
	MenuItem newGameItem = new MenuItem("New Game");
	
	MenuItem statGameItem = new MenuItem("Statistics");
	
	//Setting exit
	MenuItem closeGameItem = new MenuItem("Close Game");
	closeGameItem.setOnAction((ActionEvent e) -> Platform.exit());
	
	
	game.getItems().addAll(newGameItem, statGameItem, closeGameItem);
	
	Menu settings = new Menu("Settings");
	MenuItem changeColourItem = new MenuItem("Change Colour");
	
	changeColourItem.setOnAction((ActionEvent f) -> changecolor(f));
	
	settings.getItems().add(changeColourItem);

	this.getMenus().addAll(game,settings);
	
		
	

	}

	private void changecolor(ActionEvent f) {
		
		
		;
	}
}

	