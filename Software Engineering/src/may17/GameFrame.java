package may17;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JRadioButton;

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
	
	private ButtonGroup gridButtons;
	
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
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
		
		JLabel lbl2 = new JLabel("");
		lbl2.setHorizontalAlignment(SwingConstants.CENTER);
		lbl2.setFont(new Font("Arial", Font.BOLD, 36));
		lbl2.setBounds(254, 50, 84, 81);
		contentPane.add(lbl2);
		
		JLabel lbl1 = new JLabel("");
		lbl1.setHorizontalAlignment(SwingConstants.CENTER);
		lbl1.setFont(new Font("Arial", Font.BOLD, 36));
		lbl1.setBounds(155, 50, 84, 81);
		contentPane.add(lbl1);
		
		JLabel lbl3 = new JLabel("");
		lbl3.setHorizontalAlignment(SwingConstants.CENTER);
		lbl3.setFont(new Font("Arial", Font.BOLD, 36));
		lbl3.setBounds(348, 50, 84, 81);
		contentPane.add(lbl3);
		
		JLabel lbl6 = new JLabel("");
		lbl6.setHorizontalAlignment(SwingConstants.CENTER);
		lbl6.setFont(new Font("Arial", Font.BOLD, 36));
		lbl6.setBounds(349, 153, 84, 81);
		contentPane.add(lbl6);
		
		JLabel lbl4 = new JLabel("");
		lbl4.setHorizontalAlignment(SwingConstants.CENTER);
		lbl4.setFont(new Font("Arial", Font.BOLD, 36));
		lbl4.setBounds(156, 153, 84, 81);
		contentPane.add(lbl4);
		
		JLabel lbl5 = new JLabel("");
		lbl5.setHorizontalAlignment(SwingConstants.CENTER);
		lbl5.setFont(new Font("Arial", Font.BOLD, 36));
		lbl5.setBounds(255, 153, 84, 81);
		contentPane.add(lbl5);
		
		JLabel lbl9 = new JLabel("");
		lbl9.setHorizontalAlignment(SwingConstants.CENTER);
		lbl9.setFont(new Font("Arial", Font.BOLD, 36));
		lbl9.setBounds(349, 255, 84, 81);
		contentPane.add(lbl9);
		
		JLabel lbl7 = new JLabel("");
		lbl7.setHorizontalAlignment(SwingConstants.CENTER);
		lbl7.setFont(new Font("Arial", Font.BOLD, 36));
		lbl7.setBounds(156, 255, 84, 81);
		contentPane.add(lbl7);
		
		JLabel lbl8 = new JLabel("");
		lbl8.setHorizontalAlignment(SwingConstants.CENTER);
		lbl8.setFont(new Font("Arial", Font.BOLD, 36));
		lbl8.setBounds(255, 255, 84, 81);
		contentPane.add(lbl8);
		
		JLabel lblTitle = new JLabel("Tic Tac Toe");
		lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitle.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblTitle.setBounds(196, 0, 208, 32);
		contentPane.add(lblTitle);
		
		JLabel lblTurn = new JLabel("It is your turn!");
		lblTurn.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblTurn.setBounds(63, 359, 208, 26);
		contentPane.add(lblTurn);
		
		JButton btnNewButton = new JButton("Confirm Move");
		btnNewButton.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		btnNewButton.setBounds(223, 377, 154, 23);
		contentPane.add(btnNewButton);
	}
}
