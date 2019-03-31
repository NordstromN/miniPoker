package poker.version_graphics.view;

import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import poker.version_graphics.model.DeckOfCards;

public class BottomPane extends AnchorPane{
	private ControlArea controls;
	private CardShuffle shuffle;
	
	public BottomPane() {
		
		controls = new ControlArea();
		shuffle = new CardShuffle();
		
		
		this.getChildren().add(shuffle);
		this.getChildren().add(controls);
		
		AnchorPane.setBottomAnchor(shuffle, 10.0);
		AnchorPane.setBottomAnchor(controls, 10.0);
		AnchorPane.setLeftAnchor(shuffle, 5.0);
		AnchorPane.setRightAnchor(controls, 5.0);
		
		
	}

	
	

}
