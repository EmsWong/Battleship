import java.awt.*;
import javax.swing.*;
import java.awt.image.*;
import java.io.*;
import javax.imageio.*;

public class apanel extends JPanel{
	//properties
	int intX = 100;
	int intY = 100;



	//methods
	//override how the JComponent is painted
	public void paintComponent(Graphics g){
		g.setColor(Color.BLACK);
		g.fillRect(32,135,450,450);

		g.fillRect(522,135,450,450);
		
		g.setColor(Color.BLUE);
		//g.fillRect(0,0,50,50);


	}
	//constructor
	public apanel(){

	}
}
