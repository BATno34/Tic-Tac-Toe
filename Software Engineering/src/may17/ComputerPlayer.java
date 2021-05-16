package may17;

/**
 * A class to create a computer player object.
 * The class mainly calculates moves and stores the symbol that represents the computer
 * @author Shirley
 * @editor Ardavan and Shreyas
 * @version May 16 2021
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class ComputerPlayer{
	private String symbol;
	
	/** Get the computer player's symbol
	 * @return			the string that represents computer moves
	 */
	public String getSymbol() {
		return this.symbol;
	}
	
	/** Set the computer player's symbol to a string
	 * @return			the string that represents computer moves
	 */
	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}
	
	/** Make a simple move based on a randomly generated number
	 * @param spacesAvailable			The ArrayList that contains which moves are available
	 * @param computerMoves				The ArrayList that contains all computer's moves so far
	 * @return							The numerical value of the move (i.e. 1 means the top right corner)
	 */
	public static int simpleMove(ArrayList<Integer> spacesAvailable, ArrayList<Integer> computerMoves) {
		int moveIndex = (int)(Math.random() * (spacesAvailable.size()));
		int move = spacesAvailable.get(moveIndex);
		spacesAvailable.remove(moveIndex);
		computerMoves.add(move);
		return move;
	}
	
	/** Make a median move by mixing the chances of making simple and hard move (simple:hard=1:2)
	 * @param spacesAvailable			The ArrayList that contains which moves are available
	 * @param computerMoves				The ArrayList that contains all computer's moves so far
	 * @param humanMoves				The ArrayList that contains all human's moves so far
	 * @return							The numerical value of the move (i.e. 1 means the top right corner)
	 */
	public static int medianMove(ArrayList<Integer> spacesAvailable, ArrayList<Integer> computerMoves,
			 					 ArrayList<Integer> humanMoves) {
		int levelChoice = (int)(Math.random() * 3);
		if (levelChoice == 0) {
			return simpleMove(spacesAvailable, computerMoves);
		} else {
			return hardMove(spacesAvailable, computerMoves, humanMoves);
		}
	}
	
	/** Make a hard move by based on the calculation using minimax algorithm 
	 * @param spacesAvailable			The ArrayList that contains which moves are available
	 * @param computerMoves				The ArrayList that contains all computer's moves so far
	 * @param humanMoves				The ArrayList that contains all human's moves so far
	 * @return							The numerical value of the move (i.e. 1 means the top right corner)
	 */
	public static int hardMove(ArrayList<Integer> spacesAvailable, ArrayList<Integer> computerMoves,
							   ArrayList<Integer> humanMoves) {
		int bestScore = -999;
		int bestMove = spacesAvailable.get(0);
		//Go through all possible moves
		//Simulate the move and call minimax to calculate the score
		for (int i = 0; i < spacesAvailable.size(); i++){
			int move = spacesAvailable.get(i);
			spacesAvailable.remove(Integer.valueOf(move));
			computerMoves.add(move);
			//Since we wants to maximize ai move, then we need to minimize the next move
			int score = minimax(spacesAvailable, computerMoves, humanMoves, 0, false);
			//Reset the move
			spacesAvailable.add(i, move);
			computerMoves.remove(Integer.valueOf(move));
			if (score > bestScore){
				bestScore = score;
				bestMove = move;
			}
		}
		//Make the move that has the best score
		spacesAvailable.remove(Integer.valueOf(bestMove));
		computerMoves.add(bestMove);
		return bestMove;
	}
	
	/** Minimax algorithm that recursively calculates score of each move based on the assumption that
	 * the human player will make his/her optiaml move (AI is the maximizing player in this case)
	 * @param spacesAvailable			The ArrayList that contains which moves are available
	 * @param computerMoves				The ArrayList that contains all computer's moves so far
	 * @param humanMoves				The ArrayList that contains all human's moves so far
	 * @param depth						The number of rounds since the assumed move is made 
	 * @param isMax						If we wants to minimze or maximize the next move
	 * @return
	 */
	public static int minimax(ArrayList<Integer> spacesAvailable, ArrayList<Integer> computerMoves,
							  ArrayList<Integer> humanMoves, int depth, boolean isMax){
		
		//When the game appraches to an end, return the overall score of this move
		int result = checkWinner(computerMoves, humanMoves);
		if (result != 4) {
			int overallScore = -999;
			if (result == 2) {
				overallScore = 10; //Computer wins
			} else if (result == 1) {
				overallScore = -10; //Human wins
			} else if(result == 3) {
				overallScore = 0; //Tie
			}
			return overallScore;
		}
		
		if (isMax) {
			int bestScore = -999;
			for (int i = 0; i < spacesAvailable.size(); i++){
				//Simulates a move
				int move = spacesAvailable.get(i);
				spacesAvailable.remove(i);
				computerMoves.add(move);
				//Get the score of if we make this move
				int score = minimax(spacesAvailable, computerMoves, humanMoves, depth+1, false);
				//Reset the move
				spacesAvailable.add(i, move);
				computerMoves.remove(Integer.valueOf(move));
				bestScore = Math.max(score, bestScore);
			}
			//Find the best score for all possible moves
			return bestScore;
		//Minimize the score of human player: assume human makes their optimal move
		} else {
			int bestScore = 999;
			for (int i = 0; i < spacesAvailable.size(); i++){
				int move = spacesAvailable.get(i);
				spacesAvailable.remove(i);
				humanMoves.add(move);
				int score = minimax(spacesAvailable, computerMoves, humanMoves, depth+1, true);
				spacesAvailable.add(i, move);
				humanMoves.remove(Integer.valueOf(move));
				bestScore = Math.min(score, bestScore);
			}
			return bestScore;
		}
	}
	
	/** Check if the resut of the game
	 * @param computerMoves				The ArrayList that contains all computer's moves so far
	 * @param humanMoves				The ArrayList that contains all human's moves so far
	 * @return							Use integer value of represent the result
	 */
	public static int checkWinner(ArrayList<Integer> computerMoves, ArrayList<Integer> humanMoves) {
		//Make an ArrayList that contains ArrayLists to store all possible winning conditions
		ArrayList<Integer> row1 = new ArrayList<Integer>(Arrays.asList(1,2,3));
		ArrayList<Integer> row2 = new ArrayList<Integer>(Arrays.asList(4,5,6));
		ArrayList<Integer> row3 = new ArrayList<Integer>(Arrays.asList(7,8,9));
		ArrayList<Integer> col1 = new ArrayList<Integer>(Arrays.asList(1,4,7));
		ArrayList<Integer> col2 = new ArrayList<Integer>(Arrays.asList(2,5,8));
		ArrayList<Integer> col3 = new ArrayList<Integer>(Arrays.asList(3,6,9));
		ArrayList<Integer> cross1 = new ArrayList<Integer>(Arrays.asList(1,5,9));
		ArrayList<Integer> cross2 = new ArrayList<Integer>(Arrays.asList(3,5,7));
		ArrayList<ArrayList> winConditions = new ArrayList<ArrayList>();
		winConditions.add(row1);
		winConditions.add(row2);
		winConditions.add(row3);
		winConditions.add(col1);
		winConditions.add(col2);
		winConditions.add(col3);
		winConditions.add(cross1);
		winConditions.add(cross2);
		
		for(ArrayList list: winConditions) {
			if (humanMoves.containsAll(list)) {
				return 1;     //player wins
			} else if (computerMoves.containsAll(list)) {
				return 2;     //computer wins
			}
		}
		
		if (humanMoves.size() + computerMoves.size() == 9) {
			return 3;     //draw
		}
		
		return 4;     //no conclusion to make so far
	}
}
