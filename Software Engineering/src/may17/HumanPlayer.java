package may17;

import java.util.ArrayList;

/**
 * A class to create a human player object, that would be used to represent the user and perform certain moves.
 * @author Ardavan, Justin, Shirley, Shreyas
 * @version 1.2, May 15, 2021
 */
public class HumanPlayer {
	private String symbol; // the symbol that will be used to represent the player on the game board, typically X or O
	private String name;
	
	
	public HumanPlayer(String name, String symbol) {
		this.name = name;
		this.symbol = symbol;
	}
	
	public String getName() {
		return this.name;
	}
	
	public String getSymbol() {
		return this.symbol;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}
	
	public void makeMove(ArrayList<Integer> spacesAvailable, ArrayList<Integer> humanMoves, int chosenMove) {
		int moveIndex = spacesAvailable.indexOf(chosenMove);
		spacesAvailable.remove(moveIndex);
		humanMoves.add(chosenMove);
	}
}
