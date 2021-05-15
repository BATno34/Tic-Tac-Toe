package may17;

//COMMENT :)
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class ComputerPlayer{
	private String symbol;
	
	public String getSymbol() {
		return this.symbol;
	}
	
	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}
	
	public static int simpleMove(ArrayList<Integer> spacesAvailable, ArrayList<Integer> computerMoves) {
		int moveIndex = (int)(Math.random() * (spacesAvailable.size()));
		int move = spacesAvailable.get(moveIndex);
		spacesAvailable.remove(moveIndex);
		computerMoves.add(move);
		return move;
	}
	
	public static int medianMove(ArrayList<Integer> spacesAvailable, ArrayList<Integer> computerMoves,
			 					 ArrayList<Integer> humanMoves) {
		int levelChoice = (int)(Math.random() * 2);
		if (levelChoice == 0) {
			return simpleMove(spacesAvailable, computerMoves);
		} else {
			return hardMove(spacesAvailable, computerMoves, humanMoves);
		}
	}
	
	public static int hardMove(ArrayList<Integer> spacesAvailable, ArrayList<Integer> computerMoves,
							   ArrayList<Integer> humanMoves) {
		int bestScore = -999;
		int bestMove = spacesAvailable.get(0);
		for (int i = 0; i < spacesAvailable.size(); i++){
			int move = spacesAvailable.get(i);
			spacesAvailable.remove(Integer.valueOf(move));
			computerMoves.add(move);
			int score = minimax(spacesAvailable, computerMoves, humanMoves, 0, false);
			spacesAvailable.add(i, move);
			computerMoves.remove(Integer.valueOf(move));
			if (score > bestScore){
				bestScore = score;
				bestMove = move;
			}
		}
		spacesAvailable.remove(Integer.valueOf(bestMove));
		computerMoves.add(bestMove);
		return bestMove;
	}
	
	public static int minimax(ArrayList<Integer> spacesAvailable, ArrayList<Integer> computerMoves,
							  ArrayList<Integer> humanMoves, int depth, boolean isMax){
		
		int result = checkWinner(computerMoves, humanMoves);
		if (result != 4) {
			int overallScore = -999;
			if (result == 2) {
				overallScore = 10;
			} else if (result == 1) {
				overallScore = -10;
			} else if(result == 3) {
				overallScore = 0;
			}
			return overallScore;
		}
		
		if (isMax) {
			int bestScore = -999;
			for (int i = 0; i < spacesAvailable.size(); i++){
				int move = spacesAvailable.get(i);
				spacesAvailable.remove(i);
				computerMoves.add(move);
				int score = minimax(spacesAvailable, computerMoves, humanMoves, depth+1, false);
				spacesAvailable.add(i, move);
				computerMoves.remove(Integer.valueOf(move));
				bestScore = Math.max(score, bestScore);
			}
			return bestScore;
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
	
	public static int checkWinner(ArrayList<Integer> computerMoves, ArrayList<Integer> humanMoves) {
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
