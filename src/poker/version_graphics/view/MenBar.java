package poker.version_graphics.view;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import poker.version_graphics.controller.PokerGameController;

public class MenBar extends MenuBar{

	protected Menu game, settings;	
	protected MenuItem newGame, changePl, statGameItem, closeGameItem, changeColourItem;


	//Create the contructor for MenuBar with two Menus and 4 Items
	public MenBar() {
	
	game = new Menu("Game");
	
	//Add the menu Items
	newGame = new MenuItem("New Game");
	changePl = new MenuItem("Change Player");
	statGameItem = new MenuItem("Statistics");
	
	//Close game menuitem with the closeBox method
	closeGameItem = new MenuItem("Close Game");
	closeGameItem.setOnAction((ActionEvent e) -> closeBox());
	
	//Add the items
	game.getItems().addAll(newGame, changePl, statGameItem, closeGameItem);

	//Add another Menut and MenuItem to the GUI
	settings = new Menu("Settings");
	changeColourItem = new MenuItem("Change Colour");
	settings.getItems().add(changeColourItem);
	this.getMenus().addAll(game,settings);
	

	}
	// Open a notification window before closing from a separate class
	public void closeBox() {
		if (ConfirmBoxClose.display("Quit", "Are you sure you want to quit?"))
			Platform.exit();
	}
	
}
	