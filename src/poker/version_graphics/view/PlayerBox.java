package poker.version_graphics.view;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import poker.version_graphics.PokerGame;

public class PlayerBox {

	public static int playerNr;
	
	public static int newPlayer() {
		
		Stage secondStage = new Stage();
		
		secondStage.initModality(Modality.APPLICATION_MODAL);
		secondStage.setTitle("Choose Player");
		secondStage.setMinWidth(250);
		Label messageLabel = new Label();
		messageLabel.setText("Choose how many player to participate");
		
		Button player2 = new Button ("2");
		Button player3 = new Button ("3");
		Button player4 = new Button ("4");
		
		HBox hBox = new HBox(10);
		hBox.getChildren().addAll(player2, player3, player3);
		
		VBox vBox = new VBox(10);
		vBox.getChildren().addAll(messageLabel, hBox);
		vBox.setAlignment(Pos.CENTER);
		Scene scene = new Scene (vBox);
		secondStage.setScene(scene);
		secondStage.showAndWait();
		
		player2.setOnAction(e -> playerNr = 2);
		player3.setOnAction(e -> playerNr = 3);
		player4.setOnAction(e -> playerNr = 4);
		
		PokerGame.num_players = playerNr;
		return playerNr;
		
	}

}
