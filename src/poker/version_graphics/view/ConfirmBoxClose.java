package poker.version_graphics.view;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class ConfirmBoxClose {
	
	public static boolean answer;
	
	public static void display(String title, String message) {
		
		Stage secondStage = new Stage();
		
		secondStage.initModality(Modality.APPLICATION_MODAL);
		secondStage.setTitle(title);
		secondStage.setMinWidth(250);
		Label messageLabel = new Label();
		messageLabel.setText(message);
		
		Button yesButton = new Button ("Yes");
		Button noButton = new Button ("No");
		
		
		
		VBox vBox = new VBox(10);
		vBox.getChildren().addAll(messageLabel);
		vBox.setAlignment(Pos.CENTER);
		Scene scene = new Scene (vBox);
		secondStage.setScene(scene);
		secondStage.showAndWait();
		
		
		
	}

}
