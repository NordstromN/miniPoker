package poker.version_graphics.playerView;

import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

public class PlayerView_Main extends VBox {
	
	
	public PlayerView_Main() {
		
		PlayerView_Cards pvc = new PlayerView_Cards();
		PlayerView_Chips_Hand pvch = new PlayerView_Chips_Hand();
		PlayerView_Choice pvchoice = new PlayerView_Choice();
		Label l1, l2;
		l1 = new Label("");
		l2 = new Label("");
		this.setSpacing(5);
		
		this.getChildren().addAll(l1, pvc, pvch, pvchoice, l2);
				
	}
	
}
