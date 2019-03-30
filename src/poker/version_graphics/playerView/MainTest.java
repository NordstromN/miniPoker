package poker.version_graphics.playerView;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;


public class MainTest extends Application{
	
	public static void main (String[] args) {
		launch (args);
	}
	
	public void start(Stage primaryStage) {
		
		PlayerView_Main pvc = new PlayerView_Main();
		pvc.setLayoutX(20);
		
		PlayerView_Main pvc2 = new PlayerView_Main();
		pvc2.setLayoutX(20);
		
		HBox hBox = new HBox();
		hBox.getChildren().addAll(pvc, pvc2);
		
		Scene scene = new Scene(hBox, 400, 200);
		
		primaryStage.setTitle("PlayerCards");
		primaryStage.setScene(scene);
		primaryStage.show();
		
		scene.getStylesheets().add(getClass().getResource("Style.css").toExternalForm());
		
	}
	
}
