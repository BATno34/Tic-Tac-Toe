package may17;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class ComputerPlayer{
	
	//private static ArrayList<Integer> spacesAvailable;
	//private static ArrayList<Integer> humanMoves;
	//private static ArrayList<Integer> computerMoves;
	
	//public ComputerPlayer (ArrayList<Integer> spacesAvailable, 
	//					   ArrayList<Integer> humanMoves, 
	//					   ArrayList<Integer> computerMoves) {
		//super(spacesAvailable, humanMoves);
	//	this.computerMoves = computerMoves;
		
	//}
	
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
							   ArrayList<Integer> humanMoves ) {
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
		
		String result = checkWinner(computerMoves, humanMoves);
		return 0;
	}
	
	//public static ArrayList<Integer> getComputerMoves(){
	//	return computerMoves;
	//}
	
	public static String checkWinner(ArrayList<Integer> computerMoves, ArrayList<Integer> humanMoves) {
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
				return "Wow, congrats! You win!";
			} else if (computerMoves.containsAll(list)) {
				return "Ops! The computer wins!";
			} else if (humanMoves.size() + computerMoves.size() == 9) {
				return "Draw!";
			}
		}
		
		return "";
	}
	
	//testing purpose
	public static char[][]changeBoard(char[][]board, int position, char symbol){
		if (position == 1) {
			board[0][0]=symbol;
		} else if (position == 2) {
			board[0][1]=symbol;
		} else if (position == 3) {
			board[0][2]=symbol;
		} else if (position == 4) {
			board[1][0]=symbol;
		} else if (position == 5) {
			board[1][1]=symbol;
		} else if (position == 6) {
			board[1][2]=symbol;
		} else if (position == 7) {
			board[2][0]=symbol;
		} else if (position == 8) {
			board[2][1]=symbol;
		} else if (position == 9) {
			board[2][2]=symbol;
		} 
		return board;
	}
	
	//testing purpose
	public static void printBoard(char[][]board) {
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[i].length; j++) {
				System.out.printf("%5s", board[i][j] +",");
			}
			System.out.println();
		}
	}
	public static void main(String[] args) {
		
		Scanner input = new Scanner (System.in);
		char[][]board = {{' ',' ',' '}, {' ',' ',' '}, {' ',' ',' '}};
		printBoard(board);
		
		ArrayList<Integer> spacesAvailable = new ArrayList<Integer>(Arrays.asList(1,2,3,4,5,6,7,8,9));
		ArrayList<Integer> humanMoves = new ArrayList<Integer>();
		ArrayList<Integer> computerMoves = new ArrayList<Integer>();
		
		String win = "";
		
		while (win == "") {
			System.out.print("Make a move: ");
			int humanMovePos = input.nextInt();
			spacesAvailable.remove(Integer.valueOf(humanMovePos));
			humanMoves.add(humanMovePos);
			board = changeBoard(board, humanMovePos, 'H');
			win = checkWinner(computerMoves, humanMoves);
			if (win != "") {
				System.out.println(win);
				break;
			}
			int compMovePos = simpleMove(spacesAvailable, computerMoves);
			board = changeBoard(board, compMovePos, 'C');
			printBoard(board);
			win = checkWinner(computerMoves, humanMoves);
			System.out.println(win);
		}
		
	}
		

}
