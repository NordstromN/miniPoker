package poker.version_graphics.view;

import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;

public class MenBar extends MenuBar{

	//Create the contructor for MenuBar with two Menues and 4 Items
	
	public MenBar() {
	
	Menu game = new Menu("Game");
	MenuItem newGameItem = new MenuItem("New Game");
	MenuItem statGameItem = new MenuItem("Statistics");
	MenuItem closeGameItem = new MenuItem("Close Game");
	
	game.getItems().addAll(newGameItem, statGameItem, closeGameItem);
	
	Menu settings = new Menu("Settings");
	MenuItem changeColourItem = new MenuItem("Change Colour");
	settings.getItems().add(changeColourItem);

	this.getMenus().addAll(game,settings);
	
	
	

	}
}

	