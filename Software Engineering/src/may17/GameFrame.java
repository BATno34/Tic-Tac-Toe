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

public class GameFrame extends JFrame {

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
		
		JSeparator separator1 = new JSeparator();
		separator1.setForeground(Color.BLACK);
		separator1.setOrientation(SwingConstants.VERTICAL);
		separator1.setBounds(248, 11, 15, 311);
		contentPane.add(separator1);
		
		JSeparator separator2 = new JSeparator();
		separator2.setOrientation(SwingConstants.VERTICAL);
		separator2.setForeground(Color.BLACK);
		separator2.setBounds(341, 11, 15, 311);
		contentPane.add(separator2);
		
		JSeparator separator1_1 = new JSeparator();
		separator1_1.setForeground(Color.BLACK);
		separator1_1.setBounds(145, 114, 310, 15);
		contentPane.add(separator1_1);
		
		JSeparator separator1_1_1 = new JSeparator();
		separator1_1_1.setForeground(Color.BLACK);
		separator1_1_1.setBounds(145, 217, 310, 15);
		contentPane.add(separator1_1_1);
		
		JLabel lbl1 = new JLabel("");
		lbl1.setHorizontalAlignment(SwingConstants.CENTER);
		lbl1.setFont(new Font("Arial", Font.BOLD, 36));
		lbl1.setBounds(154, 22, 84, 81);
		contentPane.add(lbl1);
		
		JLabel lbl2 = new JLabel("");
		lbl2.setHorizontalAlignment(SwingConstants.CENTER);
		lbl2.setFont(new Font("Arial", Font.BOLD, 36));
		lbl2.setBounds(253, 22, 84, 81);
		contentPane.add(lbl2);
		
		JLabel lbl3 = new JLabel("");
		lbl3.setHorizontalAlignment(SwingConstants.CENTER);
		lbl3.setFont(new Font("Arial", Font.BOLD, 36));
		lbl3.setBounds(347, 22, 84, 81);
		contentPane.add(lbl3);
		
		JLabel lbl6 = new JLabel("");
		lbl6.setHorizontalAlignment(SwingConstants.CENTER);
		lbl6.setFont(new Font("Arial", Font.BOLD, 36));
		lbl6.setBounds(348, 125, 84, 81);
		contentPane.add(lbl6);
		
		JLabel lbl4 = new JLabel("");
		lbl4.setHorizontalAlignment(SwingConstants.CENTER);
		lbl4.setFont(new Font("Arial", Font.BOLD, 36));
		lbl4.setBounds(155, 125, 84, 81);
		contentPane.add(lbl4);
		
		JLabel lbl5 = new JLabel("");
		lbl5.setHorizontalAlignment(SwingConstants.CENTER);
		lbl5.setFont(new Font("Arial", Font.BOLD, 36));
		lbl5.setBounds(254, 125, 84, 81);
		contentPane.add(lbl5);
		
		JLabel lbl9 = new JLabel("");
		lbl9.setHorizontalAlignment(SwingConstants.CENTER);
		lbl9.setFont(new Font("Arial", Font.BOLD, 36));
		lbl9.setBounds(348, 227, 84, 81);
		contentPane.add(lbl9);
		
		JLabel lbl7 = new JLabel("");
		lbl7.setHorizontalAlignment(SwingConstants.CENTER);
		lbl7.setFont(new Font("Arial", Font.BOLD, 36));
		lbl7.setBounds(155, 227, 84, 81);
		contentPane.add(lbl7);
		
		JLabel lbl8 = new JLabel("");
		lbl8.setHorizontalAlignment(SwingConstants.CENTER);
		lbl8.setFont(new Font("Arial", Font.BOLD, 36));
		lbl8.setBounds(254, 227, 84, 81);
		contentPane.add(lbl8);
	}
}
