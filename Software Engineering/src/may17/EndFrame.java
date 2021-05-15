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
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class EndFrame extends JFrame {

	private JPanel contentPane;
	public static int gameOutcome;
	
	private JButton btnNo;

	/**
	 * Launch the application.
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
		setBounds(100, 100, 600, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblGameOver = new JLabel("GAME OVER");
		lblGameOver.setHorizontalAlignment(SwingConstants.CENTER);
		lblGameOver.setFont(new Font("Times New Roman", Font.BOLD, 32));
		lblGameOver.setBounds(185, 11, 230, 53);
		contentPane.add(lblGameOver);
		
		JLabel lblOutcome = new JLabel("");
		lblOutcome.setHorizontalAlignment(SwingConstants.CENTER);
		lblOutcome.setFont(new Font("Times New Roman", Font.PLAIN, 24));
		lblOutcome.setBounds(95, 85, 409, 53);
		contentPane.add(lblOutcome);
		
		if(gameOutcome == 1) {
			lblOutcome.setText("You won!");
		} else if(gameOutcome == 2) {
			lblOutcome.setText("You lost!");
		} else {
			lblOutcome.setText("You tied with the computer!");
		}
		
		JLabel lblPlayAgain = new JLabel("Play again?");
		lblPlayAgain.setHorizontalAlignment(SwingConstants.CENTER);
		lblPlayAgain.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblPlayAgain.setBounds(95, 183, 409, 53);
		contentPane.add(lblPlayAgain);
		
		JButton btnYes = new JButton("Yes");
		btnYes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				MainMenu main = new MainMenu();
				main.frame.setVisible(true);
			}
		});
		btnYes.setFont(new Font("Times New Roman", Font.BOLD, 14));
		btnYes.setBounds(95, 278, 156, 35);
		contentPane.add(btnYes);
		
		btnNo = new JButton("No");
		btnNo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(btnNo, "Thank you for playing!");
				dispose();
			}
		});
		btnNo.setFont(new Font("Times New Roman", Font.BOLD, 14));
		btnNo.setBounds(348, 278, 156, 35);
		contentPane.add(btnNo);
	}
}
