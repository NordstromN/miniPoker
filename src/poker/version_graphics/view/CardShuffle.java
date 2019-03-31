package poker.version_graphics.view;

import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;

 //Add design from the CSS and get cards 
public class CardShuffle extends HBox{

	private StackPane hboxshuffle = new StackPane();
		
	public CardShuffle() {
		super();
		this.getStyleClass().add("deck");
	
		this.getChildren().add(hboxshuffle);
		
		for (int i = 0; i<4;i++) {
		Label lblCard = new CardLabel();
        hboxshuffle.getChildren().add(lblCard);
        StackPane.setAlignment(lblCard, Pos.TOP_RIGHT);
		}
	
	
	
	}
	
	
	
	
	
	
	

}
