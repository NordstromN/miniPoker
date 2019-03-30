package poker.version_graphics.playerView;

import javafx.animation.PathTransition;
import javafx.animation.Timeline;
import javafx.scene.Group;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.CubicCurveTo;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;

public class PlayerView_Card extends Rectangle{
	
	protected Rectangle card;
	protected int xPosDeck, yPosDeck, xToGo, yToGo;
	
	

	public void moveCard(int xComeFrom, int yComeFrom, int xGoTo, int yGoTo) {
		
		this.setArcHeight(10);
		this.setArcWidth(10);
		this.setFill(Color.ORANGE);
		
		Path path = new Path();
		path.getElements().add(new MoveTo(200,200));
		path.getElements().add(new CubicCurveTo(380, 0, 380, 120, 200, 120));
		path.getElements().add(new CubicCurveTo(0, 120, 0, 240, 380, 240));
		PathTransition pathTransition = new PathTransition();
		pathTransition.setDuration(Duration.millis(4000));
		pathTransition.setPath(path);
		pathTransition.setNode(this);
		pathTransition.setOrientation(PathTransition.OrientationType.ORTHOGONAL_TO_TANGENT);
		pathTransition.setCycleCount(Timeline.INDEFINITE);
		pathTransition.setAutoReverse(true);
		pathTransition.play();
		
		
	}

	
	public void move() {
		
		
		
		
	}

}
