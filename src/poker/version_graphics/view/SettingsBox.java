package poker.version_graphics.view;

import javafx.event.Event;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.effect.ImageInput;
import javafx.scene.image.Image;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Rectangle;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class SettingsBox {
	
	public static int answerChoice = 0;
	
	public static int changeSettings() {
		
		Stage settingsStage = new Stage();
		
		settingsStage.initModality(Modality.APPLICATION_MODAL);
		settingsStage.setTitle("Settings");
		settingsStage.setMinWidth(250);
		
		Label bgLabel = new Label("Background:");
		bgLabel.setStyle("-fx-font-size: 20px ; -fx-font-weight: bold;"
				+ " -fx-text-fill: white");
		
		
		Button bImage = new Button("Reset to Table");
		bImage.setMinSize(200.0, 100.0);
		bImage.setStyle("-fx-font-size: 20px ; -fx-font-weight: bold;"
				+ " -fx-text-fill: black; -fx-background-color: orange");
		
		
		Button blueTable = new Button();
		blueTable.setStyle("-fx-background-color: blue");
		blueTable.setMinSize(200.0, 100.0);
	
		Button lilaTable = new Button();
		lilaTable.setStyle("-fx-background-color: violet");
		lilaTable.setMinSize(200.0, 100.0);
		
		HBox hBox = new HBox();
		hBox.getChildren().addAll(bImage, blueTable, lilaTable);		
		
		VBox vBox = new VBox();
		vBox.getChildren().addAll(bgLabel, hBox);
		
		Scene scene = new Scene (vBox);
		vBox.setStyle("-fx-background-color: black");
		
		bImage.setOnAction(e-> {
			answerChoice = 0;
			
			settingsStage.close();
		});
	
		blueTable.setOnAction(e-> {
			answerChoice = 1;
			
			settingsStage.close();
		});
		
		lilaTable.setOnAction(e-> {
			answerChoice = 2;
		
			settingsStage.close();
		});
		
		settingsStage.setScene(scene);
		settingsStage.showAndWait();
		
		return answerChoice;
	}

	

}
