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
	
	/**
	 * Constructor to create a HumanPlayer object
	 * @param name, the player's name
	 * @param symbol, the symbol that will represent the player
	 */
	public HumanPlayer(String name, String symbol) {
		this.name = name;
		this.symbol = symbol;
	}
	
	/**
	 * Gets the name of the player
	 * @return the name
	 */
	public String getName() {
		return this.name;
	}
	
	/**
	 * Gets the symbol of the player
	 * @return the symbol
	 */
	public String getSymbol() {
		return this.symbol;
	}
	
	/**
	 * Changes the name of the player to the specified argument
	 * @param name, the name for the player's name to be changed to
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * Changes the player's symbol
	 * @param symbol, the new symbol for the player's symbol to be changed to
	 */
	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}
	
	/**
	 * Makes a move for the human player based on the move chosen by the user
	 * @param spacesAvailable, an ArrayList containing the spaces on the board that are still available
	 * @param humanMoves, an ArrayList containing all the moves made by the human player
	 * @param chosenMove, the square on the grid that the player has chosen
	 */
	public void makeMove(ArrayList<Integer> spacesAvailable, ArrayList<Integer> humanMoves, int chosenMove) {
		int moveIndex = spacesAvailable.indexOf(chosenMove);
		spacesAvailable.remove(moveIndex);
		humanMoves.add(chosenMove);
	}
}
