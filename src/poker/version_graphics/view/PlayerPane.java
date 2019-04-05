package poker.version_graphics.view;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.util.Duration;
import poker.version_graphics.model.Card;
import poker.version_graphics.model.HandType;
import poker.version_graphics.model.Player;

public class PlayerPane extends FlowPane {
    private Label lblName = new Label();
    private Label wonLabel = new Label("won: ");
    GridPane gridPanePlayer = new GridPane();
    private Label currentStatus = new Label("");
    
    private HBox hboxCards = new HBox();
    private VBox vboxPlayerInfo = new VBox();
    
    private Label lblEvaluation = new Label("--");
    private HBox morePlayer = new HBox();
    
    // Link to player object
    private Player player;
    
    
    
    public void setTextWonLabel() {
    	
    	wonLabel.setText("won: "+player.getWon());
    	
    }
    
    // animation for Status (winner, loser, even) changer
    public void animationStatus() {
    	
    	Timeline time = new Timeline();
    	time.setCycleCount(2);
    	time.setAutoReverse(true);
    	//animation gets biger and from Transparent to Red
    	KeyValue width = new KeyValue(currentStatus.scaleXProperty(), 2);
    	KeyValue height = new KeyValue(currentStatus.scaleYProperty(), 2);
    	KeyValue fill = new KeyValue(currentStatus.textFillProperty(), Color.RED);
    	KeyFrame keyFrame = new KeyFrame(Duration.seconds(0.5),
    	 width, height, fill);
    	time.getKeyFrames().add(keyFrame);
    	
    	// should turn transparent and small again
    	width = new KeyValue(currentStatus.scaleXProperty(), 1);
    	height = new KeyValue(currentStatus.scaleYProperty(), 1);
    	fill = new KeyValue(currentStatus.textFillProperty(), Color.TRANSPARENT);
    	KeyFrame keyFrame1 = new KeyFrame(Duration.seconds(0.5), 
    	 width, height, fill);
    	time.getKeyFrames().add(keyFrame1);
    	
    	time.play();
    	
    }
    
    // PlayerPane, with Player Name, Current Status, Cards and HandType
    public PlayerPane() {
        super(); // Always call super-constructor first !!
        this.getStyleClass().add("player"); // CSS style class
        this.vboxPlayerInfo.getChildren().addAll(lblName, wonLabel);
        this.vboxPlayerInfo.setAlignment(Pos.CENTER_LEFT);
                
        for (int i = 0; i < 5; i++) {
            Label lblCard = new CardLabel();
            hboxCards.getChildren().add(lblCard);
        }  
        
        // set CurrentStatus on Transparent, that it will disappear after the animation
        currentStatus.setStyle("-fx-text-fill: transparent");
       
        StackPane stackPane = new StackPane();
        stackPane.getChildren().addAll(hboxCards, currentStatus);
        
        this.getChildren().addAll(this.vboxPlayerInfo, stackPane, lblEvaluation);
        //this.add(lblName, 640, 200);
        //this.add(hboxCards, 640, 300);
        //this.add(lblEvaluation, 640, 400);
        
        
        

    }
   
    // Returns Label of Status of current Hand, it must be available from other
    // classes to change it
    public Label getCurrentStatus() {
    	return this.currentStatus;
    }
   
    
    public void setPlayer(Player player) {
    	this.player = player;
    	updatePlayerDisplay(); // Immediately display the player information
    }
    
    //Updates Player Display
    public void updatePlayerDisplay() {
    	lblName.setText(player.getPlayerName());
    	wonLabel.setText("won: "+player.getWon());
    	for (int i = 0; i < Player.HAND_SIZE; i++) {
    		Card card = null;
    		if (player.getCards().size() > i) card = player.getCards().get(i);
    		CardLabel cl = (CardLabel) hboxCards.getChildren().get(i);
    		cl.setCard(card);
    		HandType evaluation = player.evaluateHand();
    		if (evaluation != null)
    			lblEvaluation.setText(evaluation.toString());
    		else
    			lblEvaluation.setText("--");
    	}
    }
}
