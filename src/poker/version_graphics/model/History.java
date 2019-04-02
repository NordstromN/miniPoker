package poker.version_graphics.model;

import java.util.ArrayList;

public class History {
	
	private ArrayList<Round> rounds;
	private int wonSum = 0;
	private int lossSum = 0;
	private int evenSum = 0;
	private int roundsCount = 0;
	
	public History() {
		rounds = new ArrayList<Round>();			
	}
	
	public void addRound(Round round) {
		this.rounds.add(round);
		this.roundsCount++;
	}
	
	public String toString() {
		String roundsString = "";
		roundsString += "Rounds: "+rounds.size()+"\n";
		for (Round currentRound : rounds) {
			roundsString += "\n*************************************\n";
			roundsString += currentRound + "\n\n";
			roundsString += "\n*************************************\n";
		}
		return roundsString;	
	}
	

}
