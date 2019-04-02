package poker.version_graphics.statistics;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import poker.version_graphics.model.Card;
import poker.version_graphics.model.Hand;
import poker.version_graphics.model.PokerGameModel;

public class TableViewHand extends Application{
	
	private PokerGameModel model;
	Stage window;
	
	TableView<Hand> table;
	
	public static void main (String[] args) {
		launch(args);
	}
	
	public void start (Stage primaryStage) {
		window = primaryStage;
		window.setTitle("Statistik");
		
		TableColumn<Hand, Card> firstCard = new TableColumn<>("FirstCard");
		firstCard.setMinWidth(200);
		firstCard.setCellValueFactory(value);
		
		
		VBox vbox = new VBox();
		vbox.getChildren().addAll();
		
		Scene scene = new Scene (vbox);
		window.setScene(scene);
		window.show();
	}

}
