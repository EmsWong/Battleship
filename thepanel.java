import java.awt.*;
import javax.swing.*;
import java.awt.image.*;
import java.io.*;
import javax.imageio.*;

public class thepanel extends JPanel{

	//Properties
	
	//Theme panel images
	BufferedImage imgboat = null;
	BufferedImage imgcar = null;
	BufferedImage imgrocket = null;
	
	//Methods
	public void paintComponent(Graphics g){
		g.drawImage(imgboat, 281, 154, null);
		g.drawImage(imgcar, 271, 344, null);
		g.drawImage(imgrocket, 271, 533, null);
	
	}
	
	//constructor
	public thepanel(){
		InputStream imageclass = null;
		
		imageclass = this.getClass().getResourceAsStream("Resources/menuboat.png");
		if(imageclass != null){
			try{
				imgboat = ImageIO.read(imageclass);
			}catch(IOException e){
				System.out.println("Unable to load image from jar");
			}
		}
		if(imgboat == null){
			try{
				imgboat = ImageIO.read(new File("Resources/menuboat.png"));
			}catch(IOException e){
				System.out.println("Unable to load images");
			}
		}
		
		imageclass = this.getClass().getResourceAsStream("Resources/menucar.png");
		if(imageclass != null){
			try{
				imgcar = ImageIO.read(imageclass);
			}catch(IOException e){
				System.out.println("Unable to load image from jar");
			}
		}
		if(imgcar == null){
			try{
				imgcar = ImageIO.read(new File("Resources/menucar.png"));
			}catch(IOException e){
				System.out.println("Unable to load images");
			}
		}
		
		imageclass = this.getClass().getResourceAsStream("Resources/menurocket.png");
		if(imageclass != null){
			try{
				imgrocket = ImageIO.read(imageclass);
			}catch(IOException e){
				System.out.println("Unable to load image from jar");
			}
		}
		if(imgrocket == null){
			try{
				imgrocket = ImageIO.read(new File("Resources/menurocket.png"));
			}catch(IOException e){
				System.out.println("Unable to load images");
			}
		}
	}
}
