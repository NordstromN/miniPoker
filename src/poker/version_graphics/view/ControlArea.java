package poker.version_graphics.view;

import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import poker.version_graphics.model.DeckOfCards;

public class ControlArea extends VBox{
    private DeckLabel lblDeck = new DeckLabel();
    private Region spacer = new Region(); // Empty spacer
    Button btnShufDea = new Button("Shuffle & Deal");
    Button btnShuffle = new Button("Shuffle");
    Button btnDeal = new Button("Deal");

    public ControlArea() {
    	super(); // Always call super-constructor first !!
    	
    	this.getChildren().addAll(lblDeck, spacer, btnShufDea, btnShuffle, btnDeal);

        HBox.setHgrow(spacer, Priority.ALWAYS); // Use region to absorb resizing
        this.setId("controlArea"); // Unique ID in the CSS
    }
    
    public void linkDeck(DeckOfCards deck) {
    	lblDeck.setDeck(deck);
    }
}
