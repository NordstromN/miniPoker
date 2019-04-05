package poker.version_graphics.view;

import javafx.animation.Animation;
import javafx.animation.Interpolator;
import javafx.animation.PathTransition;
import javafx.animation.RotateTransition;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.shape.LineTo;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;
import javafx.scene.shape.PathElement;
import javafx.scene.transform.Rotate;
import javafx.util.Duration;
import poker.version_graphics.model.Card;

public class CardLabel extends Label {
	public CardLabel() {
		super();

		this.getStyleClass().add("card");
	}
	//set the card or the back 
	public void setCard(Card card) {
		if (card != null) {
			String fileName = cardToFileName(card);
			Image image = new Image(this.getClass().getClassLoader().getResourceAsStream("poker/images/" + fileName));
			ImageView imv = new ImageView(image);
			imv.fitWidthProperty().bind(this.widthProperty());
			imv.fitHeightProperty().bind(this.heightProperty());
			imv.setPreserveRatio(true);
			this.setGraphic(imv);
			cardAnimation(imv);
		} else {
			Image image = new Image(this.getClass().getClassLoader().getResourceAsStream("poker/images/panda.png"));
			ImageView imv = new ImageView(image);
			imv.fitWidthProperty().bind(this.widthProperty());
			imv.fitHeightProperty().bind(this.heightProperty());
			imv.setPreserveRatio(true);
			this.setGraphic(imv);
		}
	}
	
	
	private void cardAnimation(ImageView imv) {
		
		//Rotation method 
		RotateTransition rotator = new RotateTransition(Duration.millis(500), imv);
	    rotator.setAxis(Rotate.Y_AXIS);
	    rotator.setFromAngle(0);
	    rotator.setToAngle(360);
	    rotator.setInterpolator(Interpolator.EASE_OUT);
	    rotator.setCycleCount(1);
	    rotator.play();
		
	 
		
	}

	private String cardToFileName(Card card) {
		String rank = card.getRank().toString();
		String suit = card.getSuit().toString();
		return rank + "_of_" + suit + ".png";
	}

}