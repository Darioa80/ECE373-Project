package Testing;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;

import javax.swing.SwingConstants;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.CardLayout;
import javax.swing.JLabel;
import javax.swing.JPasswordField;

public class SecondWindow extends JFrame {

	private JPanel contentPane;
	private JTextField txtBattleship;

	/**
	 * Launch the application.
	 */
/*	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SecondWindow frame = new SecondWindow();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}*/

	/**
	 * Create the frame.
	 */
	public SecondWindow(int mode) {
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 0, 139));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		//contentPane.setLayout(new CardLayout(0, 0));
		
		JPanel panel_Classic = new JPanel();
		panel_Classic.setBackground(new Color(0, 0, 139));
		
		JButton btnNewButton = new JButton("How to Play");
		btnNewButton.setFont(new Font("Verdana", Font.PLAIN, 18));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				RulesWindow rw = new RulesWindow(mode);
				rw.setVisible(true);
				//close();
			}
		});
		
		JButton btnNewButton_1 = new JButton("Play");
		btnNewButton_1.setFont(new Font("Verdana", Font.PLAIN, 18));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				BattleshipMainGUI bs = new BattleshipMainGUI(mode);
				bs.setVisible(true);
				close();
			}
		});
		
		JButton btnNewButton_2 = new JButton("Go Back");
		btnNewButton_2.setFont(new Font("Verdana", Font.PLAIN, 18));
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				OpeningWindow op = new OpeningWindow();
				op.setVisible(true);
				close();
			}
		});
		txtBattleship = new JTextField();
		txtBattleship.setForeground(new Color(255, 250, 250));
		txtBattleship.setBackground(new Color(0, 0, 139));
		txtBattleship.setHorizontalAlignment(SwingConstants.CENTER);
		txtBattleship.setText("BATTLESHIP");
		txtBattleship.setFont(new Font("Verdana", Font.PLAIN, 22));
		txtBattleship.setColumns(10);
		GroupLayout gl_panel_Classic = new GroupLayout(panel_Classic);
		gl_panel_Classic.setHorizontalGroup(
			gl_panel_Classic.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel_Classic.createSequentialGroup()
					.addContainerGap(105, Short.MAX_VALUE)
					.addGroup(gl_panel_Classic.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_Classic.createParallelGroup(Alignment.TRAILING)
							.addGroup(gl_panel_Classic.createSequentialGroup()
								.addComponent(txtBattleship, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addGap(103))
							.addGroup(gl_panel_Classic.createSequentialGroup()
								.addComponent(btnNewButton_2)
								.addGap(153))
							.addGroup(gl_panel_Classic.createSequentialGroup()
								.addComponent(btnNewButton_1)
								.addGap(172)))
						.addGroup(Alignment.TRAILING, gl_panel_Classic.createSequentialGroup()
							.addComponent(btnNewButton)
							.addGap(140))))
		);
		gl_panel_Classic.setVerticalGroup(
			gl_panel_Classic.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_Classic.createSequentialGroup()
					.addContainerGap()
					.addComponent(txtBattleship, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(btnNewButton)
					.addGap(29)
					.addComponent(btnNewButton_1)
					.addGap(31)
					.addComponent(btnNewButton_2)
					.addGap(35))
		);
		panel_Classic.setLayout(gl_panel_Classic);
		contentPane.add(panel_Classic, "name_894558251165237");
	}
	
	public void close(){
		WindowEvent winClosingEvent = new WindowEvent(this,WindowEvent.WINDOW_CLOSING);
		Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(winClosingEvent);
	}
	
	public void Handle(){
		
	}
}
