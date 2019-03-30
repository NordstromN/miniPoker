package poker.version_graphics.playerView;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;

public class PlayerView_Cards extends HBox{
	
	Button sButton;
	//Rectangle card1, card2, card3, card4, card5;
	
	public PlayerView_Cards() {

		sButton = new Button("Show\nCards");
		sButton.setShape(new Circle(10));
		sButton.setId("showCards");
		HBox cardField = new HBox();
		cardField.setSpacing(5);
		
		cardField.setAlignment(Pos.CENTER);
		
		Label l1 = new Label();
		cardField.getChildren().add(l1);
		
		for(int i=0; i<=4; i++) {
			
			Rectangle rectangle = new Rectangle(30, 50);
			rectangle.setFill(Color.SANDYBROWN);
			rectangle.setStroke(Color.GREY);
			rectangle.setStyle("-fx-border-radius: 200;");
			cardField.getChildren().add(rectangle);
		}
		
		Label l2 = new Label();
		cardField.getChildren().add(l2);
		
		
		VBox vBox = new VBox();
		HBox hBoxChips = new HBox();
		Label cardLabel = new Label("Hand: ");
		Label cardType = new Label("- keine Karten -");
		hBoxChips.getChildren().addAll(cardLabel, cardType);
		hBoxChips.setAlignment(Pos.CENTER);
		
		Label l3 = new Label();
		vBox.getChildren().addAll(l3, cardField, hBoxChips);
		vBox.setStyle("-fx-border-style:solid inside;" + "-fx-border-radius: 5");
		vBox.setAlignment(Pos.CENTER);
		
		this.getChildren().addAll(sButton,vBox);
		this.setSpacing(10);
		this.setAlignment(Pos.CENTER);
		
	}
	

	

}
