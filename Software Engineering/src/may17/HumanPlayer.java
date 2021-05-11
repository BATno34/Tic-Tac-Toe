package may17;
/**
 * A class to create a human player object, that would be used to represent the user and perform certain moves.
 * @author Shreyas
 * @version 1.0, May 10, 2021
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
	
	public void makeMove(int square) {
		//change this later to allow the specified square in the game grid to be changed to the player's symbol
	}
}
