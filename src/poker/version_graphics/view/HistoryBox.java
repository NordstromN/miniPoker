package poker.version_graphics.view;

import java.util.ArrayList;

import javafx.event.Event;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.effect.ImageInput;
import javafx.scene.image.Image;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Rectangle;
import javafx.stage.Modality;
import javafx.stage.Stage;
import poker.version_graphics.model.Player;

public class HistoryBox {
	
	public static void historyBox(ArrayList<Player> players) {
		
		Stage historyStage = new Stage();
		
		historyStage.initModality(Modality.APPLICATION_MODAL);
		historyStage.setTitle("History");
		historyStage.setMinWidth(400);
		historyStage.setMinHeight(400);
		
		Label historyLabel = new Label("History, Choose Player wanted: ");
		historyLabel.setStyle("-fx-font-size: 20px ; -fx-font-weight: bold");
		
		Label historyText = new Label("");
		
		ChoiceBox<String> choiceBoxPlayer = new ChoiceBox<String>();
		for (int i = 0; i<players.size(); i++) {
			choiceBoxPlayer.getItems().add(players.get(i).getPlayerName());
			}
		
		
		choiceBoxPlayer.setOnAction((event) ->{
			historyText.setText(players.get(0).getHistory());
		});
		
		VBox vBox = new VBox();
		vBox.getChildren().addAll(historyLabel, choiceBoxPlayer, historyText);
		vBox.setSpacing(20);
		Scene scene = new Scene (vBox);
		
		

		historyStage.setScene(scene);
		historyStage.showAndWait();
		
		
	}
	


	

}
