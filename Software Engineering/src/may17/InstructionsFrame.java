package may17;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;

/**
 * A frame to display instructions for the game, allow the user to choose their symbol, and to enter their name.
 * @author Ardavan, Justin, Shirley, Shreyas
 * @version May 16 2021
 */

public class InstructionsFrame extends JFrame {

	private JPanel contentPane;
	private JRadioButton rdbtnO;
	private JRadioButton rdbtnX;
	private JButton btnContinue;
	private JTextField nameField;
	JLabel lblEnterYourName;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InstructionsFrame frame = new InstructionsFrame();
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
	public InstructionsFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblTitle = new JLabel("Tic Tac Toe Instructions");
		lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitle.setFont(new Font("Times New Roman", Font.BOLD, 24));
		lblTitle.setBounds(126, 10, 347, 57);
		contentPane.add(lblTitle);
		
		JLabel lblInstructions = new JLabel("Welcome to Tic Tac Toe! In this game, you will take turns with a computer marking");
		lblInstructions.setVerticalAlignment(SwingConstants.TOP);
		lblInstructions.setHorizontalAlignment(SwingConstants.LEFT);
		lblInstructions.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblInstructions.setBounds(34, 78, 522, 29);
		contentPane.add(lblInstructions);
		
		JLabel lblSquaresInA = new JLabel("squares in a grid with your symbol. The goal of the game is to mark 3 squares in a row");
		lblSquaresInA.setVerticalAlignment(SwingConstants.TOP);
		lblSquaresInA.setHorizontalAlignment(SwingConstants.LEFT);
		lblSquaresInA.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblSquaresInA.setBounds(34, 106, 522, 29);
		contentPane.add(lblSquaresInA);
		
		JLabel lblWithYourSymbol = new JLabel("with your symbol before the computer does!");
		lblWithYourSymbol.setVerticalAlignment(SwingConstants.TOP);
		lblWithYourSymbol.setHorizontalAlignment(SwingConstants.LEFT);
		lblWithYourSymbol.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblWithYourSymbol.setBounds(34, 134, 522, 29);
		contentPane.add(lblWithYourSymbol);
		
		JLabel lblChooseYourSymbol = new JLabel("Choose your symbol (X or O):");
		lblChooseYourSymbol.setVerticalAlignment(SwingConstants.TOP);
		lblChooseYourSymbol.setHorizontalAlignment(SwingConstants.LEFT);
		lblChooseYourSymbol.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblChooseYourSymbol.setBounds(34, 203, 225, 29);
		contentPane.add(lblChooseYourSymbol);
		
		rdbtnX = new JRadioButton("X");
		rdbtnX.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		rdbtnX.setBounds(34, 265, 109, 23);
		contentPane.add(rdbtnX);
		
		rdbtnO = new JRadioButton("O");
		rdbtnO.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		rdbtnO.setBounds(178, 266, 50, 23);
		contentPane.add(rdbtnO);
		
		ButtonGroup group = new ButtonGroup();
		group.add(rdbtnO);
		group.add(rdbtnX);
		
		btnContinue = new JButton("Continue to Game");
		btnContinue.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					if(rdbtnO.isSelected()) {
						GameFrame.user.setSymbol("O");
						EndFrame.userSymbol = "O";
						GameFrame.ai.setSymbol("X");
						EndFrame.aiSymbol = "X";
					} else if(rdbtnX.isSelected()) {
						GameFrame.user.setSymbol("X");
						EndFrame.userSymbol = "X";
						GameFrame.ai.setSymbol("O");
						EndFrame.aiSymbol = "O";
					} else {
						throw new Exception();
					}
					
					if(lblEnterYourName.getText().equals("")) {
						throw new Exception();
					} else {
						GameFrame.user.setName(nameField.getText());
					}
					
					dispose();
					GameFrame gameFrame = new GameFrame();
					gameFrame.setVisible(true);
				} catch(Exception exc) {
					JOptionPane.showMessageDialog(btnContinue, "Invalid Input!");
				}
			}
		});
		btnContinue.setFont(new Font("Times New Roman", Font.BOLD, 14));
		btnContinue.setBounds(222, 315, 156, 35);
		contentPane.add(btnContinue);
		
		lblEnterYourName = new JLabel("Enter your name:");
		lblEnterYourName.setVerticalAlignment(SwingConstants.TOP);
		lblEnterYourName.setHorizontalAlignment(SwingConstants.LEFT);
		lblEnterYourName.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblEnterYourName.setBounds(273, 203, 273, 29);
		contentPane.add(lblEnterYourName);
		
		nameField = new JTextField();
		nameField.setBounds(273, 266, 218, 23);
		contentPane.add(nameField);
		nameField.setColumns(10);
	}
}
