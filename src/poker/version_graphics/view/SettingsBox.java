package poker.version_graphics.view;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class SettingsBox {
	
	public static void changeSettings() {
		
		Stage settingsStage = new Stage();
		
		settingsStage.initModality(Modality.APPLICATION_MODAL);
		settingsStage.setTitle("Settings");
		settingsStage.setMinWidth(250);
		
		Label bgLabel = new Label("Background:");
		bgLabel.setStyle("-fx-font-size: 20px ; -fx-font-weight: bold;"
				+ " -fx-text-fill: white");
		
		Button bTable = new Button();
		bTable.setStyle("-fx-background-image: url(/poker.images/background.png)");
		bTable.setStyle("-fx-min-width: 200; -fx-min-height: 100;");
		
		Button cTable = new Button();
		cTable.setStyle("-fx-background-color: blue");
		cTable.setStyle("-fx-min-width: 200; -fx-min-height: 100;");
		
		HBox hBox = new HBox();
		hBox.getChildren().addAll(bTable, cTable);		
		
		VBox vBox = new VBox();
		vBox.getChildren().addAll(bgLabel, hBox);
		
		Scene scene = new Scene (vBox);
		vBox.setStyle("-fx-background-color: black");
		
		settingsStage.setScene(scene);
		settingsStage.showAndWait();
				
		
		
	}

}
