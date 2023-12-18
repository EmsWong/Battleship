import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.event.*;
import java.io.*;

public class test implements ActionListener{
	//Properties
	
	//Frame and Panels
	JFrame theframe = new JFrame("Battleships");
	apanel mainpanel = new apanel(); 
	
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
	
	
	public void actionPerformed(ActionEvent evt){
		
	}
	
	public test(){
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
		
		theframe.setContentPane(mainpanel);
		theframe.pack();
		theframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		theframe.setResizable(false);
		theframe.setVisible(true);
	}
	
	public static void main(String[] args){
		new test();
	}
}
