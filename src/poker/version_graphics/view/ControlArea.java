package poker.version_graphics.view;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import poker.version_graphics.model.DeckOfCards;

public class ControlArea extends VBox{
    private DeckLabel lblDeck = new DeckLabel();
    Button btnShufDea = new Button("Shuffle & Deal");
    Button btnShuffle = new Button("Shuffle");
    Button btnDeal = new Button("Deal");

    public ControlArea() {
    	super(); // Always call super-constructor first !!

    	
    	this.getChildren().addAll(lblDeck, btnDeal, btnShuffle, btnShufDea);
        this.setId("button"); // Unique ID in the CSS for the buttons
    }
    
    public void linkDeck(DeckOfCards deck) {
    	lblDeck.setDeck(deck);
    }
}
