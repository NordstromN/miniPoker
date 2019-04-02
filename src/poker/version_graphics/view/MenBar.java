package poker.version_graphics.view;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import poker.version_graphics.controller.PokerGameController;

public class MenBar extends MenuBar{

	private Menu game, settings;	
	private MenuItem changPl, statGameItem, closeGameItem, changeColourItem;


	//Create the contructor for MenuBar with two Menues and 4 Items
	public MenBar() {
	
	game = new Menu("Game");

	// Start the Game new including deleting the played hands out the history
	//MenuItem newGameItem = new MenuItem("New Game");
	//newGameItem.setOnAction((Actionevent e) -> );
	
	//Get the Menu Items
	changPl = new MenuItem("Change Player");
	changPl.setOnAction(e -> selectChangePl());
	
	statGameItem = new MenuItem("Statistics");
		//Setting exit
	closeGameItem = new MenuItem("Close Game");
	closeGameItem.setOnAction((ActionEvent e) -> closeBox());
	
	
	game.getItems().addAll(changPl, statGameItem, closeGameItem);
	
	settings = new Menu("Settings");
	changeColourItem = new MenuItem("Change Colour");
	//changeColourItem.setOnAction((ActionEvent e) -> lülülülülü);
	//	changeColourItem.setOnAction((ActionEvent f) -> changecolor(f));
	
	settings.getItems().add(changeColourItem);
	this.getMenus().addAll(game,settings);
	

	}
	
	public void closeBox() {
		if (ConfirmBoxClose.display("Quit", "Are you sure you want to quit?"))
			Platform.exit();
	}
	
	public void selectChangePl() {
		PlayerBox.newPlayer();
		
	}
}
	