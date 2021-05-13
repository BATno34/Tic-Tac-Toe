package may17;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import musicGUI.MusicDatabase;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JTextPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JProgressBar;
import java.awt.EventQueue;

public class DifficultyFrame extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DifficultyFrame frame = new DifficultyFrame();
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
	public DifficultyFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1000, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		//Lables
		
		JLabel lblTitle = new JLabel("Choose AI Difficulty");
		lblTitle.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblTitle.setBounds(370, 10, 221, 51);
		contentPane.add(lblTitle);
		
		JLabel lblEasy1 = new JLabel("A beginner's best friend. AI will ");
		lblEasy1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblEasy1.setBounds(470, 150, 289, 20);
		contentPane.add(lblEasy1);
		
		JLabel lblEasy2 = new JLabel("always make a random move.");
		lblEasy2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblEasy2.setBounds(470, 171, 289, 20);
		contentPane.add(lblEasy2);
		
		JLabel lblMedium1 = new JLabel("Just playing for fun! AI will sometimes ");
		lblMedium1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblMedium1.setBounds(470, 250, 289, 20);
		contentPane.add(lblMedium1);
		
		JLabel lblMedium2 = new JLabel("make a smart move.");
		lblMedium2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblMedium2.setBounds(470, 270, 289, 20);
		contentPane.add(lblMedium2);
		
		JLabel lblHard1 = new JLabel("A real challenge! AI will always make");
		lblHard1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblHard1.setBounds(470, 350, 289, 20);
		contentPane.add(lblHard1);
		
		JLabel lblHard2 = new JLabel("the best decision to win. Good Luck!");
		lblHard2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblHard2.setBounds(470, 370, 289, 20);
		contentPane.add(lblHard2);
		
		//Buttons
		
		JButton btnEasy = new JButton("Easy");
		btnEasy.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//set AI Difficulty to Easy
				
				JOptionPane.showMessageDialog(btnEasy, "AI Difficulty set to Easy");
			}
		});
		btnEasy.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnEasy.setBounds(220, 150, 200, 60);
		contentPane.add(btnEasy);
		
		JButton btnMedium = new JButton("Medium");
		btnMedium.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//set AI Difficulty to Medium
				
				JOptionPane.showMessageDialog(btnMedium, "AI Difficulty set to Medium");


			}
		});
		btnMedium.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnMedium.setBounds(220, 250, 200, 60);
		contentPane.add(btnMedium);
		
		JButton btnHard = new JButton("Hard");
		btnHard.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//set AI Difficulty to Hard
				
				JOptionPane.showMessageDialog(btnHard, "AI Difficulty set to Hard");


			}
		});
		btnHard.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnHard.setBounds(220, 350, 200, 60);
		contentPane.add(btnHard);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				//MainMenu window = new MainMenu();
				//window.setVisible(true);
				
			}
		});
		btnBack.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnBack.setBounds(10, 493, 200, 60);
		contentPane.add(btnBack);
	}
}