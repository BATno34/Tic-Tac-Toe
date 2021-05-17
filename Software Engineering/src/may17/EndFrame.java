package may17;

/**
 * Frame to display the outcome of the game (win, lose, or tie), as well as the final gameboard
 * @author Ardavan, Justin, Shirley, Shreyas
 * @version May 16 2021
 */

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JSeparator;
import java.awt.Color;

public class EndFrame extends JFrame {

	private JPanel contentPane;
	public static int gameOutcome;
	public static String userSymbol;
	public static String aiSymbol;
	
	//labels for grid squares
	private JLabel lbl1;
	private JLabel lbl2;
	private JLabel lbl3;
	private JLabel lbl4;
	private JLabel lbl5;
	private JLabel lbl6;
	private JLabel lbl7;
	private JLabel lbl8;
	private JLabel lbl9;
		
	public static ArrayList<JLabel> gridLabels;
	
	private JButton btnReturnToMainMenu;
	
	/**
	 * Method to update the gameBoard according to the human and computer moves
	 */
	public static void updateBoard() {
		for(int i = 0; i < GameFrame.humanMoves.size(); i++) { //check all human moves
			int square = GameFrame.humanMoves.get(i);
			gridLabels.get(square-1).setText(userSymbol);
		}
		for(int i = 0; i < GameFrame.computerMoves.size(); i++) { //check all computer moves
			int square = GameFrame.computerMoves.get(i);
			gridLabels.get(square-1).setText(aiSymbol);
		}
	}

	/**
	 * Main method to launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EndFrame frame = new EndFrame();
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
	public EndFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		//labels
		JLabel lblGameOver = new JLabel("GAME OVER");
		lblGameOver.setHorizontalAlignment(SwingConstants.CENTER);
		lblGameOver.setFont(new Font("Times New Roman", Font.BOLD, 32));
		lblGameOver.setBounds(285, 11, 230, 53);
		contentPane.add(lblGameOver);
		
		JLabel lblOutcome = new JLabel("");
		lblOutcome.setHorizontalAlignment(SwingConstants.CENTER);
		lblOutcome.setFont(new Font("Times New Roman", Font.PLAIN, 24));
		lblOutcome.setBounds(209, 404, 409, 53);
		contentPane.add(lblOutcome);
		
		//set the text of lblOutcome based on the outcome of the game
		if(gameOutcome == 1) {
			lblOutcome.setText("You won!");
		} else if(gameOutcome == 2) {
			lblOutcome.setText("You lost!");
		} else {
			lblOutcome.setText("You tied with the computer!");
		}
		
		JButton btnPlayAgain = new JButton("Play Again");
		btnPlayAgain.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose(); 
				//start a new game and alternate the player who starts
				if (GameFrame.whoStarts == 'p')
					GameFrame.setWhoStarts('c');
				else
					GameFrame.setWhoStarts('p');
				
				GameFrame game = new GameFrame();
				game.setVisible(true);
			}
		});
		btnPlayAgain.setFont(new Font("Times New Roman", Font.BOLD, 14));
		btnPlayAgain.setBounds(166, 468, 189, 35);
		contentPane.add(btnPlayAgain);
		
		btnReturnToMainMenu = new JButton("Return to Main Menu");
		btnReturnToMainMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) { //return to the mainMenu frame
				dispose();
				MainMenu main = new MainMenu();
				main.frame.setVisible(true);
			}
		});
		btnReturnToMainMenu.setFont(new Font("Times New Roman", Font.BOLD, 14));
		btnReturnToMainMenu.setBounds(445, 468, 189, 35);
		contentPane.add(btnReturnToMainMenu);
		
		//grid lines
		JSeparator separator1 = new JSeparator();
		separator1.setOrientation(SwingConstants.VERTICAL);
		separator1.setForeground(Color.BLACK);
		separator1.setBounds(352, 65, 15, 311);
		contentPane.add(separator1);
		
		JSeparator separator2 = new JSeparator();
		separator2.setOrientation(SwingConstants.VERTICAL);
		separator2.setForeground(Color.BLACK);
		separator2.setBounds(445, 65, 15, 311);
		contentPane.add(separator2);
		
		JSeparator separator1_1 = new JSeparator();
		separator1_1.setForeground(Color.BLACK);
		separator1_1.setBounds(249, 168, 310, 15);
		contentPane.add(separator1_1);
		
		JSeparator separator1_1_1 = new JSeparator();
		separator1_1_1.setForeground(Color.BLACK);
		separator1_1_1.setBounds(249, 271, 310, 15);
		contentPane.add(separator1_1_1);
		
		//grid labels
		lbl2 = new JLabel("");
		lbl2.setHorizontalAlignment(SwingConstants.CENTER);
		lbl2.setFont(new Font("Arial", Font.BOLD, 36));
		lbl2.setBounds(358, 78, 84, 81);
		
		lbl1 = new JLabel("");
		lbl1.setHorizontalAlignment(SwingConstants.CENTER);
		lbl1.setFont(new Font("Arial", Font.BOLD, 36));
		lbl1.setBounds(259, 78, 84, 81);
		
		lbl3 = new JLabel("");
		lbl3.setHorizontalAlignment(SwingConstants.CENTER);
		lbl3.setFont(new Font("Arial", Font.BOLD, 36));
		lbl3.setBounds(452, 78, 84, 81);
		
		lbl6 = new JLabel("");
		lbl6.setHorizontalAlignment(SwingConstants.CENTER);
		lbl6.setFont(new Font("Arial", Font.BOLD, 36));
		lbl6.setBounds(453, 181, 84, 81);
		
		lbl4 = new JLabel("");
		lbl4.setHorizontalAlignment(SwingConstants.CENTER);
		lbl4.setFont(new Font("Arial", Font.BOLD, 36));
		lbl4.setBounds(260, 181, 84, 81);
		
		lbl5 = new JLabel("");
		lbl5.setHorizontalAlignment(SwingConstants.CENTER);
		lbl5.setFont(new Font("Arial", Font.BOLD, 36));
		lbl5.setBounds(359, 181, 84, 81);
		
		lbl9 = new JLabel("");
		lbl9.setHorizontalAlignment(SwingConstants.CENTER);
		lbl9.setFont(new Font("Arial", Font.BOLD, 36));
		lbl9.setBounds(453, 283, 84, 81);
		
		lbl7 = new JLabel("");
		lbl7.setHorizontalAlignment(SwingConstants.CENTER);
		lbl7.setFont(new Font("Arial", Font.BOLD, 36));
		lbl7.setBounds(260, 283, 84, 81);
		
		lbl8 = new JLabel("");
		lbl8.setHorizontalAlignment(SwingConstants.CENTER);
		lbl8.setFont(new Font("Arial", Font.BOLD, 36));
		lbl8.setBounds(359, 283, 84, 81);
		
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
		
		updateBoard();
		
		contentPane.add(lbl1);
		contentPane.add(lbl2);
		contentPane.add(lbl3);
		contentPane.add(lbl4);
		contentPane.add(lbl5);
		contentPane.add(lbl6);
		contentPane.add(lbl7);
		contentPane.add(lbl8);
		contentPane.add(lbl9);
		
		//Display the user's and ai's symbol
		JLabel userSymbolDisplay = new JLabel("User:");
		userSymbolDisplay.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		userSymbolDisplay.setBounds(88, 284, 111, 16);
		userSymbolDisplay.setText("You: " + userSymbol);
		contentPane.add(userSymbolDisplay);
		
		JLabel aiSymbolDisplay = new JLabel("AI:");
		aiSymbolDisplay.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		aiSymbolDisplay.setBounds(88, 343, 111, 16);
		aiSymbolDisplay.setText("AI: " + aiSymbol);
		contentPane.add(aiSymbolDisplay);
	}
}
