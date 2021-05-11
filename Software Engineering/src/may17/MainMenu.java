package may17;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class mainMenu {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					mainMenu window = new mainMenu();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public mainMenu() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 1000, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblTitle = new JLabel("Tic Tac Toe");
		lblTitle.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblTitle.setBounds(414, 46, 134, 42);
		frame.getContentPane().add(lblTitle);
		
		JButton btnStartButton = new JButton("Start Game");
		btnStartButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();     //closes the frame
				//MAKE GAME FRAME OBJECT
				//MAKE GAME FRAME VISIBLE
			}
		});
		btnStartButton.setBounds(380, 173, 201, 65);
		frame.getContentPane().add(btnStartButton);
		
		JButton btnChange = new JButton("Change Difficulty");
		btnChange.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();     //closes the frame
				//MAKE DIFICULTY PANEL OBJECT
				//MAKE PANEL VISIBLE

			}
		});
		btnChange.setBounds(380, 285, 201, 65);
		frame.getContentPane().add(btnChange);
		
		JButton btnQuitGame = new JButton("Quit Game");
		btnQuitGame.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();     //closes the frame
			}
		});
		btnQuitGame.setBounds(380, 417, 201, 65);
		frame.getContentPane().add(btnQuitGame);
	}
}