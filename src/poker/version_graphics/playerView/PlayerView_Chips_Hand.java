package poker.version_graphics.playerView;

import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;

public class PlayerView_Chips_Hand extends GridPane	{
	
	private Label chips, chipsValue;
	
	public PlayerView_Chips_Hand() {
		
		chips = new Label("Chips: ");
		chipsValue = new Label("0 CHF");
		
		this.add(chips, 1, 0);
		this.add(chipsValue, 2, 0);
	
		this.setAlignment(Pos.CENTER);
		
	}
	
	

}
