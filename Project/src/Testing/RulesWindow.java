package Testing;

import java.awt.BorderLayout;
import java.util.Scanner;
import java.awt.EventQueue;
import java.io.*;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.JTextArea;

public class RulesWindow extends JFrame {
	public RulesWindow(int mode) {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(250, 250, 700, 300);
		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 0, 139));
		JLabel label = new JLabel("RULES");
		label.setForeground(new Color(255, 255, 255));
		label.setBackground(new Color(0, 0, 139));
		label.setFont(new Font("Verdana", Font.PLAIN, 22));
				
		JTextArea textArea = new JTextArea(50, 30);
		textArea.setText(Read(mode).toString());
		JScrollPane scroll = new JScrollPane(textArea,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		scroll.setPreferredSize(new Dimension(650, 250));
		panel.add(label, BorderLayout.NORTH);
		panel.add(scroll, BorderLayout.CENTER);
		this.add(panel);
		this.setVisible(true);
	}

	
	
	public StringBuilder Read(int mode){
		String currOut =  new String();
		StringBuilder Out = new StringBuilder();
		try{
			if (mode == 1){
			File myFile = new File("C:/Users/Angel/Desktop/Java/ClassicInstructions.txt");
			Scanner scan = new Scanner(myFile);
			while(scan.hasNext()){
				currOut = scan.nextLine();
				Out.append(currOut);
				Out.append("\n");
			}
			}
			else if (mode == 2){
			File myFile = new File("C:/Users/Angel/Desktop/Java/SalvoInstructions.txt");
			Scanner scan = new Scanner(myFile);
			while(scan.hasNext()){
				currOut = scan.nextLine();
				Out.append(currOut);
				Out.append("\n");
			}
			}
			else if (mode == 3){
			File myFile = new File("C:/Users/Angel/Desktop/Java/AdvancedInstructions.txt");	
			Scanner scan = new Scanner(myFile);
			while(scan.hasNext()){
				currOut = scan.nextLine();
				Out.append(currOut);
				Out.append("\n");
			}
			}

			
			} catch (FileNotFoundException e){
				e.printStackTrace();
			}
		return Out;
	}
}
