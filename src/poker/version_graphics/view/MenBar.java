package poker.version_graphics.view;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import poker.version_graphics.controller.PokerGameController;

public class MenBar extends MenuBar{

	protected Menu game, settings;	
	protected MenuItem changePl, statGameItem, closeGameItem, changeColourItem;


	//Create the contructor for MenuBar with two Menus and 4 Items
	public MenBar() {
	
	game = new Menu("Game");
	
	//Get the Menu Items
	changePl = new MenuItem("Change Player");
	statGameItem = new MenuItem("Statistics");
	closeGameItem = new MenuItem("Close Game");
	
	closeGameItem.setOnAction((ActionEvent e) -> closeBox());
	
	
	game.getItems().addAll(changePl, statGameItem, closeGameItem);
	

	settings = new Menu("Settings");
	
	changeColourItem = new MenuItem("Change Colour");
	
		
	settings.getItems().add(changeColourItem);
	this.getMenus().addAll(game,settings);
	

	}
	
	public void closeBox() {
		if (ConfirmBoxClose.display("Quit", "Are you sure you want to quit?"))
			Platform.exit();
	}
	
}
	