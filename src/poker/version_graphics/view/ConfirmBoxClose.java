package poker.version_graphics.view;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.util.Duration;

public class ConfirmBoxClose {
	
	//Boolean to determine to stay or leave the game
	public static boolean answer;
	
	//Opens a window returns a boolean (users Choice) and takes title and message
	public static boolean display(String title, String message) {
		
		Stage secondStage = new Stage();
		
		secondStage.initModality(Modality.APPLICATION_MODAL);
		secondStage.setTitle(title);
		secondStage.setMinWidth(320);
		secondStage.setMinHeight(220);
		Label messageLabel = new Label();
		messageLabel.setText(message);
		
		messageLabel.setStyle("-fx-font-size: 12px ; -fx-font-weight: bold;"
				+ " -fx-text-fill: red");
		
		
		Button noButton = new Button ("No");
		Button yesButton = new Button ("Yes");
		
	
		
		yesButton.setStyle("-fx-font-size: 12px ; -fx-font-weight: bold;"
				+ " -fx-text-fill: black");
		noButton.setStyle("-fx-font-size: 12px ; -fx-font-weight: bold;"
				+ " -fx-text-fill: black");	
		
		//Method to secure which choice the user pushed/pressed
		yesButton.setOnKeyPressed((event)->{
			if (event.getCode()==KeyCode.ENTER) {
				answer = true;
				
				
				// a little useless animation, button clicked gets twice of the size
				Timeline time = new Timeline();
				time.setAutoReverse(false);
				KeyValue width = new KeyValue(yesButton.scaleXProperty(),2);
				KeyValue hight = new KeyValue(yesButton.scaleYProperty(),2);
				
				KeyFrame keyFrame = new KeyFrame(Duration.seconds(0.5), width, hight);
				time.getKeyFrames().add(keyFrame);
				time.play();
				
				// whe timeline is finished, than close secondStage 
				time.setOnFinished(e->secondStage.close());
				
			}
		});
		
		yesButton.setOnAction(e-> {
			answer = true;
			
			//creating Timeline, which doubles size of Button when pressed
			Timeline time = new Timeline();
			time.setAutoReverse(false);
			KeyValue width = new KeyValue(yesButton.scaleXProperty(),2);
			KeyValue hight = new KeyValue(yesButton.scaleYProperty(),2);
			KeyFrame keyFrame = new KeyFrame(Duration.seconds(0.5), width, hight);
			time.getKeyFrames().add(keyFrame);
			time.play();
			
			// whe timeline is finished, than close secondStage 
			time.setOnFinished(ed->secondStage.close());
		});
		
		noButton.setOnAction(e-> {
			answer = false;
			
			//creating Timeline, which doubles size of Button when pressed
			Timeline time = new Timeline();
			time.setAutoReverse(false);
			KeyValue width = new KeyValue(noButton.scaleXProperty(),2);
			KeyValue hight = new KeyValue(noButton.scaleYProperty(),2);
			KeyFrame keyFrame = new KeyFrame(Duration.seconds(0.5), width, hight);
			time.getKeyFrames().add(keyFrame);
			time.play();
			
			// whe timeline is finished, than close secondStage 
			time.setOnFinished(ed->secondStage.close());		
		});
		
		//Added this method due to annoyed coder during development (to many mouse clicks)
		noButton.setOnKeyPressed((event)->{
			if (event.getCode()==KeyCode.ENTER) {
				answer = false;
				
				//creating Timeline, which doubles size of Button when pressed
				Timeline time = new Timeline();
				time.setAutoReverse(false);
				KeyValue width = new KeyValue(noButton.scaleXProperty(),2);
				KeyValue hight = new KeyValue(noButton.scaleYProperty(),2);
				KeyFrame keyFrame = new KeyFrame(Duration.seconds(0.5), width, hight);
				time.getKeyFrames().add(keyFrame);
				time.play();
				
				// the timeline is finished, than close secondStage 
				time.setOnFinished(e->secondStage.close());
				
			}
		});
		
		VBox vBox = new VBox(10);
		vBox.getChildren().addAll(messageLabel, yesButton, noButton);
		vBox.setAlignment(Pos.CENTER);
		vBox.setSpacing(20.0);
		
		Scene scene = new Scene (vBox);
	

		secondStage.setScene(scene);
		secondStage.showAndWait();
		
		return answer;
		
	}

}
