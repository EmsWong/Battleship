import java.awt.*;
import javax.swing.*;
import java.awt.image.*;
import java.io.*;
import javax.imageio.*;

public class hpanel extends JPanel{

	//Properties
	
	//Theme panel images
	BufferedImage imgtile = null;
	BufferedImage imghit = null;
	BufferedImage imgmiss = null;
	
	BufferedImage img2boata = null;
	BufferedImage img2boatb = null;
	BufferedImage img3boat = null;
	BufferedImage img4boat = null;
	BufferedImage img5boat = null;
	
	BufferedImage imghelp3 = null;
	BufferedImage imghelp2 = null;
	BufferedImage imghelp1 = null;
	
	//Variables	
	int intPanel;
	int intMousex;
	int intMousey;
	
	int int2px1 = 32;
	int int2py1 = 135;
	int int2px2 = 122;
	int int2py2 = 180;
	
	boolean blnMove2 = false;
	boolean blnRot2 = false;
	
	//Methods
	public void paintComponent(Graphics g){
		//Properties
		//Array
		String strMap[][] = new String[10][10];
		String strLines = "";
		String strSplits[];
		int intMapCol = 0;
		int intMapRow = 0;
		int intCount1;
		int intCount2;
		int intCount3;
		int intCount;
		
		int intX = 32;
		int intY = 135;
		int intX1 = 502;
		int intY1 = 135;
		
		g.setColor(Color.WHITE);
		
		g.fillRect(1005,66,238,524);
		g.fillRect(1005,607,238,48);
		g.fillRect(554,85,156,24);
		g.fillRect(743,85,156,24);
		
		for(intCount = 0; intCount < 10; intCount++){
			for(intCount1 = 0; intCount1 <10; intCount1++){
				strMap[intCount][intCount1] = "w";
			}
		}
		for(intCount2 = 0; intCount2 < 10; intCount2++){
			for(intCount3 = 0; intCount3 <10; intCount3++){
				if(strMap[intCount2][intCount3].equals("w")){
					g.drawImage(imgtile, intX + intCount3 *45, intY + intCount2 * 45, null);
				}
			}
		}
		for(intCount2 = 0; intCount2 < 10; intCount2++){
			for(intCount3 = 0; intCount3 <10; intCount3++){
				if(strMap[intCount2][intCount3].equals("w")){
					g.drawImage(imgtile, intX1 + intCount3 *45, intY1 + intCount2 * 45, null);
				}
			}
		}
		if(intPanel == 1){
			if(blnRot2 == false){
				g.drawImage(img2boata, int2px1, int2py1, null);
			}else{
				g.drawImage(img2boatb, int2px1, int2py1, null);
			}
			System.out.println(intMousex+" "+intMousey);
			g.drawImage(imghelp1,0,0,null);
		}else if(intPanel ==2){
			g.drawImage(imghelp2,0,0,null);
			
			g.drawImage(img2boatb, 167, 270, null);
			g.drawImage(img3boat, 347, 180, null);
			g.drawImage(img3boat, 77, 450, null);
			g.drawImage(img4boat, 437, 270, null);
			g.drawImage(img5boat, 122, 405, null);
		}else if(intPanel == 3){
			g.drawImage(img2boatb, 167, 270, null);
			g.drawImage(img3boat, 347, 180, null);
			g.drawImage(img3boat, 77, 450, null);
			g.drawImage(img4boat, 437, 270, null);
			g.drawImage(img5boat, 122, 405, null);
			
			g.drawImage(imghit, 167, 270, null);
			g.drawImage(imghit, 167, 315, null);
			g.drawImage(imgmiss, 77, 360, null);
			g.drawImage(imgmiss, 392, 225, null);
			g.drawImage(imgmiss, 302, 450, null);
			
			g.drawImage(imghit, 592, 495, null);
			g.drawImage(imgmiss, 682, 225, null);
			g.drawImage(imgmiss, 502, 180, null);
			g.drawImage(imgmiss, 907, 315, null);
			g.drawImage(imgmiss, 772, 405, null);
			
			g.fillRect(646,607,163,47);
			g.drawImage(imghelp3,0,0,null);
		}
	}
	
	//constructor
	public hpanel(){
		
		InputStream imageclass = null;
		
		//Water
		imageclass = this.getClass().getResourceAsStream("Resources/watertile.png");
		if(imageclass != null){
			try{
				imgtile = ImageIO.read(imageclass);
			}catch(IOException e){
				System.out.println("Unable to load image from jar");
			}
		}
		if(imgtile == null){
			try{
				imgtile = ImageIO.read(new File("Resources/watertile.png"));
			}catch(IOException e){
				System.out.println("Unable to load images");
			}
		}

		//Hit
		imageclass = this.getClass().getResourceAsStream("Resources/hit.png");
		if(imageclass != null){
			try{
				imghit = ImageIO.read(imageclass);
			}catch(IOException e){
				System.out.println("Unable to load image from jar");
			}
		}
		if(imghit == null){
			try{
				imghit = ImageIO.read(new File("Resources/hit.png"));
			}catch(IOException e){
				System.out.println("Unable to load images");
			}
		}
		//Miss
		imageclass = this.getClass().getResourceAsStream("Resources/missed.png");
		if(imageclass != null){
			try{
				imgmiss = ImageIO.read(imageclass);
			}catch(IOException e){
				System.out.println("Unable to load image from jar");
			}
		}
		if(imgmiss == null){
			try{
				imgmiss = ImageIO.read(new File("Resources/missed.png"));
			}catch(IOException e){
				System.out.println("Unable to load images");
			}
		}
		//Boat 2a
		imageclass = this.getClass().getResourceAsStream("Resources/2boath.png");
		if(imageclass != null){
			try{
				img2boata = ImageIO.read(imageclass);
			}catch(IOException e){
				System.out.println("Unable to load image from jar");
			}
		}
		if(img2boata == null){
			try{
				img2boata = ImageIO.read(new File("Resources/2boath.png"));
			}catch(IOException e){
				System.out.println("Unable to load images");
			}
		}
		//Boat 2b
		imageclass = this.getClass().getResourceAsStream("Resources/2boatv.png");
		if(imageclass != null){
			try{
				img2boatb = ImageIO.read(imageclass);
			}catch(IOException e){
				System.out.println("Unable to load image from jar");
			}
		}
		if(img2boatb == null){
			try{
				img2boata = ImageIO.read(new File("Resources/2boatv.png"));
			}catch(IOException e){
				System.out.println("Unable to load images");
			}
		}
		//Boat 3
		imageclass = this.getClass().getResourceAsStream("Resources/3boatv.png");
		if(imageclass != null){
			try{
				img3boat = ImageIO.read(imageclass);
			}catch(IOException e){
				System.out.println("Unable to load image from jar");
			}
		}
		if(img3boat == null){
			try{
				img3boat = ImageIO.read(new File("Resources/3boatv.png"));
			}catch(IOException e){
				System.out.println("Unable to load images");
			}
		}
		//Boat 4
		imageclass = this.getClass().getResourceAsStream("Resources/4boatv.png");
		if(imageclass != null){
			try{
				img4boat = ImageIO.read(imageclass);
			}catch(IOException e){
				System.out.println("Unable to load image from jar");
			}
		}
		if(img4boat == null){
			try{
				img4boat = ImageIO.read(new File("Resources/4boatv.png"));
			}catch(IOException e){
				System.out.println("Unable to load images");
			}
		}
		//Boat 5
		imageclass = this.getClass().getResourceAsStream("Resources/5boath.png");
		if(imageclass != null){
			try{
				img5boat = ImageIO.read(imageclass);
			}catch(IOException e){
				System.out.println("Unable to load image from jar");
			}
		}
		if(img5boat == null){
			try{
				img5boat = ImageIO.read(new File("Resources/5boath.png"));
			}catch(IOException e){
				System.out.println("Unable to load images");
			}
		}
		
		//Help Image 1
		imageclass = this.getClass().getResourceAsStream("Resources/help1.png");
		if(imageclass != null){
			try{
				imghelp1 = ImageIO.read(imageclass);
			}catch(IOException e){
				System.out.println("Unable to load image from jar");
			}
		}
		if(imghelp1 == null){
			try{
				imghelp1 = ImageIO.read(new File("Resources/help1.png"));
			}catch(IOException e){
				System.out.println("Unable to load images");
			}
		}
		
		//Help Image 2
		imageclass = this.getClass().getResourceAsStream("Resources/help2.png");
		if(imageclass != null){
			try{
				imghelp2 = ImageIO.read(imageclass);
			}catch(IOException e){
				System.out.println("Unable to load image from jar");
			}
		}
		if(imghelp2 == null){
			try{
				imghelp2 = ImageIO.read(new File("Resources/help2.png"));
			}catch(IOException e){
				System.out.println("Unable to load images");
			}
		}
		//Help Image 3
		imageclass = this.getClass().getResourceAsStream("Resources/help3.png");
		if(imageclass != null){
			try{
				imghelp3 = ImageIO.read(imageclass);
			}catch(IOException e){
				System.out.println("Unable to load image from jar");
			}
		}
		if(imghelp3 == null){
			try{
				imghelp3 = ImageIO.read(new File("Resources/help3.png"));
			}catch(IOException e){
				System.out.println("Unable to load images");
			}
		}
	}
}
