package may17;

/**
 * The main gameFrame, frame in which the game itself takes place
 * Determines user input to perform the actions required in the game.
 * @author Ardavan, Justin, Shirley, Shreyas
 * @version May 16 2021
 */

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JRadioButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class GameFrame extends JFrame {
	private JRadioButton rdbtn1;
	private JRadioButton rdbtn2;
	private JRadioButton rdbtn3;
	private JRadioButton rdbtn4;
	private JRadioButton rdbtn5;
	private JRadioButton rdbtn6;
	private JRadioButton rdbtn7;
	private JRadioButton rdbtn8;
	private JRadioButton rdbtn9;
	
	private JLabel lblTurn;
	
	private JLabel lbl1;
	private JLabel lbl2;
	private JLabel lbl3;
	private JLabel lbl4;
	private JLabel lbl5;
	private JLabel lbl6;
	private JLabel lbl7;
	private JLabel lbl8;
	private JLabel lbl9;
	
	private JButton btnConfirm;
	
	public static ArrayList<JLabel> gridLabels;
	
	private ButtonGroup gridButtons;
	
	private JPanel contentPane;
	
	public static HumanPlayer user = new HumanPlayer("","");
	public static ComputerPlayer ai = new ComputerPlayer();
	
	public static ArrayList<Integer> spacesAvailable = new ArrayList<Integer>();
	public static ArrayList<Integer> humanMoves = new ArrayList<Integer>();
	public static ArrayList<Integer> computerMoves = new ArrayList<Integer>();
	
	public static int difficulty = 2;
	public static char whoStarts = 'p';
	private JLabel lblDiffLevel;

	public static int aiMove() {
		int move = 0;
		if(difficulty == 1) {
			move = ComputerPlayer.simpleMove(spacesAvailable, computerMoves);
		} else if(difficulty == 2) {
			move = ComputerPlayer.medianMove(spacesAvailable, computerMoves, humanMoves);
		} else {
			move = ComputerPlayer.hardMove(spacesAvailable, computerMoves, humanMoves);
		}
		return move;
	}
	
	/**
	 * Launch the application.
	 */
	
	public static void setDifficulty(int diff) {
		difficulty = diff;
	}
	
	public static void setWhoStarts (char start) {
		whoStarts = start;
	}
	
	public static void updateBoard() {
		for(int i = 0; i < humanMoves.size(); i++) {
			int square = humanMoves.get(i);
			gridLabels.get(square-1).setText(user.getSymbol());
		}
		for(int i = 0; i < computerMoves.size(); i++) {
			int square = computerMoves.get(i);
			gridLabels.get(square-1).setText(ai.getSymbol());
		}
	}
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GameFrame frame = new GameFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public GameFrame() {
		spacesAvailable.clear();
		for(int i = 1; i <=9; i++) {
			spacesAvailable.add(i);
		}
		humanMoves.clear();
		computerMoves.clear();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 450);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		rdbtn9 = new JRadioButton("");
		rdbtn9.setBounds(383, 280, 21, 23);
		contentPane.add(rdbtn9);
		
		rdbtn7 = new JRadioButton("");
		rdbtn7.setBounds(183, 280, 21, 23);
		contentPane.add(rdbtn7);
		
		rdbtn8 = new JRadioButton("");
		rdbtn8.setBounds(286, 280, 21, 23);
		contentPane.add(rdbtn8);
		
		rdbtn6 = new JRadioButton("");
		rdbtn6.setBounds(383, 182, 21, 23);
		contentPane.add(rdbtn6);
		
		rdbtn5 = new JRadioButton("");
		rdbtn5.setBounds(286, 182, 21, 23);
		contentPane.add(rdbtn5);
		
		rdbtn4 = new JRadioButton("");
		rdbtn4.setBounds(183, 182, 21, 23);
		contentPane.add(rdbtn4);
		
		rdbtn3 = new JRadioButton("");
		rdbtn3.setBounds(383, 76, 21, 23);
		contentPane.add(rdbtn3);
		
		rdbtn2 = new JRadioButton("");
		rdbtn2.setBounds(286, 76, 21, 23);
		contentPane.add(rdbtn2);
		
		rdbtn1 = new JRadioButton("");
		rdbtn1.setBounds(183, 76, 21, 23);
		contentPane.add(rdbtn1);
		
		gridButtons = new ButtonGroup();
		
		gridButtons.add(rdbtn1);
		gridButtons.add(rdbtn2);
		gridButtons.add(rdbtn3);
		gridButtons.add(rdbtn4);
		gridButtons.add(rdbtn5);
		gridButtons.add(rdbtn6);
		gridButtons.add(rdbtn7);
		gridButtons.add(rdbtn8);
		gridButtons.add(rdbtn9);
		
		JSeparator separator1 = new JSeparator();
		separator1.setForeground(Color.BLACK);
		separator1.setOrientation(SwingConstants.VERTICAL);
		separator1.setBounds(248, 37, 15, 311);
		contentPane.add(separator1);
		
		JSeparator separator2 = new JSeparator();
		separator2.setOrientation(SwingConstants.VERTICAL);
		separator2.setForeground(Color.BLACK);
		separator2.setBounds(341, 37, 15, 311);
		contentPane.add(separator2);
		
		JSeparator separator1_1 = new JSeparator();
		separator1_1.setForeground(Color.BLACK);
		separator1_1.setBounds(145, 140, 310, 15);
		contentPane.add(separator1_1);
		
		JSeparator separator1_1_1 = new JSeparator();
		separator1_1_1.setForeground(Color.BLACK);
		separator1_1_1.setBounds(145, 243, 310, 15);
		contentPane.add(separator1_1_1);
		
		lbl2 = new JLabel("");
		lbl2.setHorizontalAlignment(SwingConstants.CENTER);
		lbl2.setFont(new Font("Arial", Font.BOLD, 36));
		lbl2.setBounds(254, 50, 84, 81);
		contentPane.add(lbl2);
		
		lbl1 = new JLabel("");
		lbl1.setHorizontalAlignment(SwingConstants.CENTER);
		lbl1.setFont(new Font("Arial", Font.BOLD, 36));
		lbl1.setBounds(155, 50, 84, 81);
		contentPane.add(lbl1);
		
		lbl3 = new JLabel("");
		lbl3.setHorizontalAlignment(SwingConstants.CENTER);
		lbl3.setFont(new Font("Arial", Font.BOLD, 36));
		lbl3.setBounds(348, 50, 84, 81);
		contentPane.add(lbl3);
		
		lbl6 = new JLabel("");
		lbl6.setHorizontalAlignment(SwingConstants.CENTER);
		lbl6.setFont(new Font("Arial", Font.BOLD, 36));
		lbl6.setBounds(349, 153, 84, 81);
		contentPane.add(lbl6);
		
		lbl4 = new JLabel("");
		lbl4.setHorizontalAlignment(SwingConstants.CENTER);
		lbl4.setFont(new Font("Arial", Font.BOLD, 36));
		lbl4.setBounds(156, 153, 84, 81);
		contentPane.add(lbl4);
		
		lbl5 = new JLabel("");
		lbl5.setHorizontalAlignment(SwingConstants.CENTER);
		lbl5.setFont(new Font("Arial", Font.BOLD, 36));
		lbl5.setBounds(255, 153, 84, 81);
		contentPane.add(lbl5);
		
		lbl9 = new JLabel("");
		lbl9.setHorizontalAlignment(SwingConstants.CENTER);
		lbl9.setFont(new Font("Arial", Font.BOLD, 36));
		lbl9.setBounds(349, 255, 84, 81);
		contentPane.add(lbl9);
		
		lbl7 = new JLabel("");
		lbl7.setHorizontalAlignment(SwingConstants.CENTER);
		lbl7.setFont(new Font("Arial", Font.BOLD, 36));
		lbl7.setBounds(156, 255, 84, 81);
		contentPane.add(lbl7);
		
		lbl8 = new JLabel("");
		lbl8.setHorizontalAlignment(SwingConstants.CENTER);
		lbl8.setFont(new Font("Arial", Font.BOLD, 36));
		lbl8.setBounds(255, 255, 84, 81);
		contentPane.add(lbl8);
		
		gridLabels = new ArrayList<JLabel>();
		
		gridLabels.add(lbl1);
		gridLabels.add(lbl2);
		gridLabels.add(lbl3);
		gridLabels.add(lbl4);
		gridLabels.add(lbl5);
		gridLabels.add(lbl6);
		gridLabels.add(lbl7);
		gridLabels.add(lbl8);
		gridLabels.add(lbl9);
				
		JLabel lblTitle = new JLabel("Tic Tac Toe");
		lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitle.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblTitle.setBounds(196, 0, 208, 32);
		contentPane.add(lblTitle);
		
		lblTurn = new JLabel(user.getName() + ", it is your turn!");
		lblTurn.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblTurn.setBounds(63, 359, 208, 26);
		contentPane.add(lblTurn);
		
		if (whoStarts == 'c') {
			int aiMove = aiMove();
			if(aiMove == 1) {
				rdbtn1.setVisible(false);
			} else if(aiMove == 2) {
				rdbtn2.setVisible(false);
			} else if(aiMove == 3) {
				rdbtn3.setVisible(false);
			} else if(aiMove == 4) {
				rdbtn4.setVisible(false);
			} else if(aiMove == 5) {
				rdbtn5.setVisible(false);
			} else if(aiMove == 6) {
				rdbtn6.setVisible(false);
			} else if(aiMove == 7) {
				rdbtn7.setVisible(false);
			} else if(aiMove == 8) {
				rdbtn8.setVisible(false);
			} else if(aiMove == 9) {
				rdbtn9.setVisible(false);
			} 
			
			updateBoard();
			int gameStatus = ComputerPlayer.checkWinner(computerMoves, humanMoves);
			if(gameStatus!=4) {
				EndFrame.gameOutcome = gameStatus;
				
				dispose();
				EndFrame endFrame = new EndFrame();
				endFrame.setVisible(true);
			}
		}
		
		btnConfirm = new JButton("Confirm Move");
		btnConfirm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					
					int move = -1;
					if(rdbtn1.isSelected()) {
						move = 1;
						rdbtn1.setSelected(false);
						rdbtn1.setVisible(false);
					} else if(rdbtn2.isSelected()) {
						move = 2;
						rdbtn2.setSelected(false);
						rdbtn2.setVisible(false);
					} else if(rdbtn3.isSelected()) {
						move = 3;
						rdbtn3.setSelected(false);
						rdbtn3.setVisible(false);
					} else if(rdbtn4.isSelected()) {
						move = 4;
						rdbtn4.setSelected(false);
						rdbtn4.setVisible(false);
					} else if(rdbtn5.isSelected()) {
						move = 5;
						rdbtn5.setSelected(false);
						rdbtn5.setVisible(false);
					} else if(rdbtn6.isSelected()) {
						move = 6;
						rdbtn6.setSelected(false);
						rdbtn6.setVisible(false);
					} else if(rdbtn7.isSelected()) {
						move = 7;
						rdbtn7.setSelected(false);
						rdbtn7.setVisible(false);
					} else if(rdbtn8.isSelected()) {
						move = 8;
						rdbtn8.setSelected(false);
						rdbtn8.setVisible(false);
					} else if(rdbtn9.isSelected()) {
						move = 9;
						rdbtn9.setSelected(false);
						rdbtn9.setVisible(false);
					} else {
						throw new Exception();
					}
					
					if(spacesAvailable.indexOf(move) == -1) {
						throw new Exception();
					} else {
						user.makeMove(spacesAvailable, humanMoves, move);
					}
					
					updateBoard();
					
					int gameStatus = ComputerPlayer.checkWinner(computerMoves, humanMoves);
					if(gameStatus!=4) {
						EndFrame.gameOutcome = gameStatus;
												
						dispose();
						EndFrame endFrame = new EndFrame();
						endFrame.setVisible(true);
					} else {
						int aiMove = aiMove();
						if(aiMove == 1) {
							rdbtn1.setVisible(false);
						} else if(aiMove == 2) {
							rdbtn2.setVisible(false);
						} else if(aiMove == 3) {
							rdbtn3.setVisible(false);
						} else if(aiMove == 4) {
							rdbtn4.setVisible(false);
						} else if(aiMove == 5) {
							rdbtn5.setVisible(false);
						} else if(aiMove == 6) {
							rdbtn6.setVisible(false);
						} else if(aiMove == 7) {
							rdbtn7.setVisible(false);
						} else if(aiMove == 8) {
							rdbtn8.setVisible(false);
						} else if(aiMove == 9) {
							rdbtn9.setVisible(false);
						} 
						
						updateBoard();
						gameStatus = ComputerPlayer.checkWinner(computerMoves, humanMoves);
						if(gameStatus!=4) {
							EndFrame.gameOutcome = gameStatus;
							
							dispose();
							EndFrame endFrame = new EndFrame();
							endFrame.setVisible(true);
						}
					}
					
						
				} catch (Exception exc) {
					JOptionPane.showMessageDialog(btnConfirm, "Invalid input!");
				}
			}
		});
		btnConfirm.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		btnConfirm.setBounds(223, 377, 154, 23);
		contentPane.add(btnConfirm);
		
		//Display the diiculty level
		lblDiffLevel = new JLabel("Difficulty Level: ");
		lblDiffLevel.setHorizontalAlignment(SwingConstants.TRAILING);
		lblDiffLevel.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblDiffLevel.setBounds(359, 359, 208, 26);
		if(difficulty == 1) {
			lblDiffLevel.setText("Difficulty Level: Easy");
		} else if(difficulty == 2) {
			lblDiffLevel.setText("Difficulty Level: Medium");
		} else {
			lblDiffLevel.setText("Difficulty Level: Hard");
		}
		contentPane.add(lblDiffLevel);
	}
}
