import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.event.*;
import java.io.*;

public class test implements ActionListener{
	//Properties
	//Font
	Font text = null;
	//Frame and Panels
	JFrame theframe = new JFrame("Battleship");
	apanel mainpanel = new apanel(); 
	JPanel homepanel = new JPanel();
	
	//Text area
	JTextArea textarea = new JTextArea();
	JScrollPane thescroll = new JScrollPane(textarea);
	JTextField sendfield = new JTextField();
	
	//Row, Col and Fire
	String[] strRow = {"1","2","3","4","5","6","7","8","9","10"}; 
	String[] strCol = {"A","B","C","D","E","F","G","H","I","J"}; 
	JComboBox rowlist = new JComboBox(strRow);
	JComboBox collist = new JComboBox(strCol);
	JButton firebutton = new JButton("FIRE");
	
	//Home screen
	JButton playbutton = new JButton("Play");
	JButton helpbutton = new JButton("Help");
	JButton quitbutton = new JButton("Quit");
	JLabel battleship = new JLabel("BATTLESHIP");

	public void actionPerformed(ActionEvent evt){
		if(evt.getSource() == playbutton){
			theframe.setContentPane(mainpanel);
			theframe.pack();
			theframe.repaint();
			
		}
		if(evt.getSource() == firebutton){
			String strRow = (String)rowlist.getSelectedItem();
			String strCol = (String)collist.getSelectedItem();
			System.out.println(strRow+strCol);
		}
	}
	
	public test(){
		text = new Font("arial", Font.BOLD, 20);
		mainpanel.setLayout(null);
		mainpanel.setPreferredSize(new Dimension(1280,780));
		
		thescroll.setSize(238,524);
		thescroll.setLocation(1010,66);
		textarea.setEnabled(false);
		mainpanel.add(thescroll);
		
		sendfield.setSize(238,48);
		sendfield.setLocation(1010,607);
		sendfield.addActionListener(this);
		mainpanel.add(sendfield);
		
		firebutton.setSize(163,47);
		firebutton.setLocation(678,607);
		firebutton.setFont(text);
		firebutton.addActionListener(this);
		mainpanel.add(firebutton);
		
		rowlist.setSize(163,30);
		rowlist.setLocation(570,83);
		rowlist.addActionListener(this);
		mainpanel.add(rowlist);
		
		collist.setSize(163,30);
		collist.setLocation(759,83);
		collist.addActionListener(this);
		mainpanel.add(collist);

		homepanel.setLayout(null);
		homepanel.setPreferredSize(new Dimension(1280,780));

		playbutton.setSize(497,80);
		playbutton.setLocation(390, 287);
		playbutton.setFont(text);
		playbutton.addActionListener(this);
		homepanel.add(playbutton);

		helpbutton.setSize(497,80);
		helpbutton.setLocation(390, 427);
		helpbutton.setFont(text);
		helpbutton.addActionListener(this);
		homepanel.add(helpbutton);

		quitbutton.setSize(497,80);
		quitbutton.setLocation(390, 567);
		quitbutton.setFont(text);
		quitbutton.addActionListener(this);
		homepanel.add(quitbutton);

		text = new Font("arial", Font.BOLD, 60);
		battleship.setSize(435, 95);
		battleship.setLocation(447,154);
		battleship.setFont(text);
		homepanel.add(battleship);

		theframe.setContentPane(homepanel);
		theframe.pack();
		theframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		theframe.setResizable(false);
		theframe.setVisible(true);
	}
	
	public static void main(String[] args){
		new test();
	}
}
