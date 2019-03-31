package poker.version_graphics.model;

import java.util.ArrayList;

public class History {
	
	private ArrayList<Round> rounds = null;
	private String playerName;
	private int wonSum = 0;
	private int lossSum = 0;
	private int evenSum = 0;
	
	public History(String playerName) {
		
		this.playerName = playerName;
			
	}
	
	public void addRound(Round round) {
		
	}
	

}
