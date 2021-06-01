package may17;

/**
 * The starting application window for the game, used as a Main Menu
 * Starting point (main file) for the rest of the game
 * @author Ardavan, Justin, Shirley, Shreyas
 * @version May 16 2021
 */

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;

public class MainMenu {

	JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainMenu window = new MainMenu();
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
	public MainMenu() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 1000, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JLabel lblTitle = new JLabel("Tic Tac Toe");
		lblTitle.setFont(new Font("Tahoma", Font.PLAIN, 24));
		
		JButton btnStartButton = new JButton("Start Game");
		btnStartButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();     //closes the frame
				InstructionsFrame instFrame = new InstructionsFrame(); //creates new frame
				instFrame.setVisible(true);
			}
		});
		
		JButton btnChange = new JButton("Change Difficulty");
		btnChange.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();     //closes the frame
				DifficultyFrame diffFrame = new DifficultyFrame();//creates new frame
				diffFrame.setVisible(true);

			}
		});
		
		JButton btnQuitGame = new JButton("Quit Game");
		btnQuitGame.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "Thank you for playing!");
				frame.dispose();     //closes the frame
			}
		});
		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(414)
					.addComponent(lblTitle, GroupLayout.DEFAULT_SIZE, 134, Short.MAX_VALUE)
					.addGap(440))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(380)
					.addComponent(btnStartButton, GroupLayout.DEFAULT_SIZE, 201, Short.MAX_VALUE)
					.addGap(407))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(380)
					.addComponent(btnChange, GroupLayout.DEFAULT_SIZE, 201, Short.MAX_VALUE)
					.addGap(407))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(380)
					.addComponent(btnQuitGame, GroupLayout.DEFAULT_SIZE, 201, Short.MAX_VALUE)
					.addGap(407))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(46)
					.addComponent(lblTitle, GroupLayout.DEFAULT_SIZE, 42, Short.MAX_VALUE)
					.addGap(85)
					.addComponent(btnStartButton, GroupLayout.DEFAULT_SIZE, 65, Short.MAX_VALUE)
					.addGap(47)
					.addComponent(btnChange, GroupLayout.DEFAULT_SIZE, 65, Short.MAX_VALUE)
					.addGap(67)
					.addComponent(btnQuitGame, GroupLayout.DEFAULT_SIZE, 65, Short.MAX_VALUE)
					.addGap(83))
		);
		frame.getContentPane().setLayout(groupLayout);
	}
}
