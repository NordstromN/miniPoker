package poker.version_graphics.playerView;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class PlayerView_Choice extends HBox{
	
	private Button call, check, fold, bet;
	private VBox vBox1, vBox2, vBox3;
	private HBox hBox1;
	
	public PlayerView_Choice() {
		
		call = new Button("Call\t\t");
		check = new Button("Check\t");
		fold = new Button ("Fold\t\t");
		bet = new Button("Bet/Raise\t");
		
		call.getStyleClass().add("option-Button");
		check.getStyleClass().add("option-Button");
		fold.getStyleClass().add("option-Button");
		bet.getStyleClass().add("option-Button");
		
		vBox1 = new VBox();
		vBox1.getChildren().addAll(fold, check);
		vBox2 = new VBox();
		vBox2.getChildren().addAll(call, bet);
			
		
		
		Label betrag = new Label(" Betrag: ");
		TextField betSize = new TextField("0");
		hBox1 = new HBox();
		hBox1.getChildren().addAll(betrag, betSize);	
		
		Slider slider = new Slider(0, 20, 0.5);
		slider.setShowTickMarks(true);
		slider.setShowTickLabels(true);
		slider.setBlockIncrement(0.1);
				
		
		
		vBox3 = new VBox();
		vBox3.getChildren().addAll(hBox1, slider);
		
		this.setAlignment(Pos.CENTER);
		this.getChildren().addAll(vBox1, vBox2, vBox3);
		
	}
	


}
