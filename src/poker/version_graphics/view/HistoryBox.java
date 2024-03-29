package poker.version_graphics.view;

import java.util.ArrayList;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import poker.version_graphics.model.Player;

public class HistoryBox {
	
	public static void historyBox(ArrayList<Player> players) {
		
		Stage historyStage = new Stage();
		
		historyStage.initModality(Modality.APPLICATION_MODAL);
		historyStage.setTitle("History");
		historyStage.setMinWidth(400);
		historyStage.setMinHeight(700);
		
		Label historyLabel = new Label("History, Choose Player wanted: ");
		historyLabel.setStyle("-fx-font-size: 20px ; -fx-font-weight: bold");
		
		Label historyText = new Label("");
		
		//Creating a Choice Box
		ChoiceBox<String> choiceBoxPlayer = new ChoiceBox<String>();
		// adding All players to the Choice Box
		for (int i = 0; i<players.size(); i++) {
			choiceBoxPlayer.getItems().add(players.get(i).getPlayerName());
			}
		
		// if User select a Player, this event will happen: setText with the History of the selected Player
		choiceBoxPlayer.setOnAction((event) ->{
			for (int i = 0; i<players.size(); i++) {
				if (choiceBoxPlayer.getValue()== players.get(i).getPlayerName()) {
					historyText.setText(players.get(i).getHistory());
				}
			}
		});
		
		
		VBox vBox = new VBox();
		vBox.getChildren().addAll(historyLabel, choiceBoxPlayer, historyText);
		vBox.setAlignment(Pos.TOP_CENTER);
		vBox.setSpacing(15);
		vBox.setSpacing(20);
	
		Scene scene = new Scene (vBox);
		
		

		historyStage.setScene(scene);
		historyStage.showAndWait();
		
		
	}
	


	

}
