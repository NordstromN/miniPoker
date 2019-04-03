package poker.version_graphics.view;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;

public class CardBackDeck extends HBox{

	private ImageView imv;


	public CardBackDeck() {
		super();
		addPanda();
		this.getStyleClass().add("card");
	}
		
	
	public void addPanda() {	
		Image image = new Image(this.getClass().getClassLoader().getResourceAsStream("poker/images/panda.png"));
		imv = new ImageView(image);
		this.getChildren().add(imv);
		
		
	}
	
	
	
	
	
	
	
	
}
