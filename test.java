import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.event.*;
import java.io.*;

public class test implements ActionListener, KeyListener{
	//Properties
	//Font
	Font text = null;
	
	//Frame and Panels
	JFrame theframe = new JFrame("Battleship");
	JPanel mainpanel = new JPanel(); 
	apanel gamepanel = new apanel();
	JPanel homepanel = new JPanel();
	JPanel joinpanel = new JPanel();
	JPanel waitingpanel = new JPanel();
	JPanel themepanel = new JPanel();
	JPanel chatpanel = new JPanel();
	
	
	//Chat Area
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

	//Join screen
	JTextField username = new JTextField();
	JTextField ip = new JTextField();
	JTextField port = new JTextField();
	JButton host = new JButton("Host");
	JButton join = new JButton("Join");
	JLabel userlabel = new JLabel("Username");
	JLabel iplabel = new JLabel("IP");
	JLabel portlabel = new JLabel("Port");
	JLabel title = new JLabel("BATTLESHIP");
	SuperSocketMaster ssm = null;

	//Themes
	JButton standardbutton = new JButton("Standard");
	JButton carsbutton = new JButton("Cars");
	JButton spacebutton = new JButton("Space");
	
	//Waiting 
	JLabel waitinglabel = new JLabel("Waiting for Host...");

	public void actionPerformed(ActionEvent evt){
		//clicking play button on home screen
		if(evt.getSource() == playbutton){
			theframe.setContentPane(joinpanel);
			theframe.pack();
			theframe.repaint();
		}

		//clicking quit button on home screen
		if(evt.getSource() == quitbutton){
			System.exit(0);
		}

		//clicking the fire button on gameplay screen
		if(evt.getSource() == firebutton){
			String strRow = (String)rowlist.getSelectedItem();
			String strCol = (String)collist.getSelectedItem();
			System.out.println(strRow+strCol);
		}

		//clicking the host button on join screen
		if(evt.getSource() == host){
			ssm = new SuperSocketMaster(Integer.parseInt(port.getText()), this);
			ssm.connect();
			System.out.println(ssm.getMyAddress());
			theframe.setTitle(ssm.getMyAddress());

			try{
				Thread.sleep(3500);
			}
			catch (InterruptedException e){
				
			}

			theframe.setContentPane(themepanel);
			theframe.pack();
			theframe.repaint();
		}
		

		//clicking the join button on the join screen
		if(evt.getSource() == join){
			ssm = new SuperSocketMaster(ip.getText(), Integer.parseInt(port.getText()), this);
			ssm.connect();
			theframe.setContentPane(waitingpanel);
			theframe.pack();
			theframe.repaint();
		}

		//clicking the standard theme button
		if(evt.getSource() == standardbutton){
			theframe.setContentPane(gamepanel);
			theframe.pack();
			theframe.repaint();
			ssm.sendText("playstandard");
		}

		//clicking the cars theme button
		if(evt.getSource() == carsbutton){

		}

		//clicking the space theme button
		if(evt.getSource() == spacebutton){

		}

		//ssm message for clinet to switch to gameplay screen
		if(evt.getSource() == ssm){
			if(ssm.readText().equals("playstandard")){
				theframe.setContentPane(gamepanel);
				theframe.pack();
				theframe.repaint();
			}
		}
	}

	public void keyPressed(KeyEvent evt){

	}

	public void keyTyped(KeyEvent evt){
		if(username.getText().length() > 10 && !(evt.getKeyChar() == KeyEvent.VK_DELETE || evt.getKeyChar() == KeyEvent.VK_BACK_SPACE)){
			String strusername = username.getText().substring(0, 9);
			username.setText(strusername);
			userlabel.setText("Too Long");
		}else{
			userlabel.setText("Username");
		}
		
	}

	public void keyReleased(KeyEvent evt){
		if(username.getText().length() > 10 && !(evt.getKeyChar() == KeyEvent.VK_DELETE || evt.getKeyChar() == KeyEvent.VK_BACK_SPACE)){
			String strusername = username.getText().substring(0, 10);
			username.setText(strusername);
			userlabel.setText("Too Long");
		}else{
			userlabel.setText("Username");
		}
	}
	
	public test(){
		text = new Font("arial", Font.BOLD, 20);
		
		
		//Chat Panel
		chatpanel.setLayout(null);
		chatpanel.setPreferredSize(new Dimension(314,780));

		//Game Panel
		gamepanel.setLayout(null);
		gamepanel.setPreferredSize(new Dimension(1280,780));

		//Chat Area
		thescroll.setSize(238,524);
		thescroll.setLocation(39,66);
		textarea.setEnabled(false);
		chatpanel.add(thescroll);
		
		sendfield.setSize(238,48);
		sendfield.setLocation(39,607);
		sendfield.addActionListener(this);
		chatpanel.add(sendfield);
		
		
		//Fire button
		firebutton.setSize(163,47);
		firebutton.setLocation(678,607);
		firebutton.setFont(text);
		firebutton.addActionListener(this);
		gamepanel.add(firebutton);
		
		//Row and Column Drop down lists
		rowlist.setSize(163,30);
		rowlist.setLocation(570,83);
		rowlist.addActionListener(this);
		gamepanel.add(rowlist);
		
		collist.setSize(163,30);
		collist.setLocation(759,83);
		collist.addActionListener(this);
		gamepanel.add(collist);

		//Home Panel
		homepanel.setLayout(null);
		homepanel.setPreferredSize(new Dimension(1280,780));

		//Play, Help, and Quit Button
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

		//Battleship Title
		text = new Font("arial", Font.BOLD, 60);
		battleship.setSize(435, 95);
		battleship.setLocation(447,154);
		battleship.setFont(text);
		homepanel.add(battleship);

		//Join Panel
		joinpanel.setLayout(null);
		joinpanel.setPreferredSize(new Dimension(1280,780));

		//Battleship Title
		title.setSize(435, 95);
		title.setLocation(470,124);
		title.setFont(text);
		joinpanel.add(title);

		//User, IP, Port Labels
		text = new Font("arial", Font.BOLD, 32);
		userlabel.setSize(310, 51);
		userlabel.setLocation(581, 236);
		userlabel.setFont(text);
		joinpanel.add(userlabel);

		iplabel.setSize(289, 40);
		iplabel.setLocation(500, 410);
		iplabel.setFont(text);
		joinpanel.add(iplabel);

		portlabel.setSize(289, 40);
		portlabel.setLocation(768, 410);
		portlabel.setFont(text);
		joinpanel.add(portlabel);

		//Host and Join Buttons
		host.setSize(251, 80);
		host.setLocation(387, 558);
		host.setFont(text);
		host.addActionListener(this);
		joinpanel.add(host);

		join.setSize(251, 80);
		join.setLocation(677, 558);
		join.setFont(text);
		join.addActionListener(this);
		joinpanel.add(join);

		//Username, IP, and Port Text Fields
		username.setSize(542, 80);
		username.setLocation(386, 280);
		username.setFont(text);
		username.addKeyListener(this);
		joinpanel.add(username);

		ip.setSize(251, 80);
		ip.setLocation(389, 450);
		ip.setFont(text);
		joinpanel.add(ip);

		port.setSize(251, 80);
		port.setLocation(677, 450);
		port.setFont(text);
		joinpanel.add(port);

		//Theme Panel and Buttons
		themepanel.setLayout(null);
		themepanel.setPreferredSize(new Dimension(1280,780));
		
		standardbutton.setSize(331,106);
		standardbutton.setLocation(582,174);
		standardbutton.addActionListener(this);
		themepanel.add(standardbutton);
		
		carsbutton.setSize(331,106);
		carsbutton.setLocation(582,364);
		carsbutton.addActionListener(this);
		themepanel.add(carsbutton);
		
		spacebutton.setSize(331,106);
		spacebutton.setLocation(582,553);
		spacebutton.addActionListener(this);
		themepanel.add(spacebutton);
		
		//Waiting Panel
		waitingpanel.setLayout(null);
		waitingpanel.setPreferredSize(new Dimension(1280,780));
		
		text = new Font("arial", Font.BOLD, 60);
		waitinglabel.setSize(650,100);
		waitinglabel.setLocation(330,320);
		waitinglabel.setFont(text);
		waitingpanel.add(waitinglabel);
		
		
		
		//The Frame
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
