import java.awt.*;
import javax.swing.*;
import java.awt.image.*;
import java.io.*;
import javax.imageio.*;

public class apanel extends JPanel{
	// Properties
	
	//Boats
	BufferedImage img2boath = null;
	BufferedImage img2boatv = null;
	BufferedImage img3boath = null;
	BufferedImage img3boatv = null;
	BufferedImage img4boath = null;
	BufferedImage img4boatv = null;
	BufferedImage img5boath = null;
	BufferedImage img5boatv = null;
	
	//Cars
	BufferedImage img2carh = null;
	BufferedImage img2carv = null;
	BufferedImage img3carh = null;
	BufferedImage img3carv = null;
	BufferedImage img4carh = null;
	BufferedImage img4carv = null;
	BufferedImage img5carh = null;
	BufferedImage img5carv = null;
	
	//Rockets
	BufferedImage img2rocketh = null;
	BufferedImage img2rocketv = null;
	BufferedImage img3rocketh = null;
	BufferedImage img3rocketv = null;
	BufferedImage img4rocketh = null;
	BufferedImage img4rocketv = null;
	BufferedImage img5rocketh = null;
	BufferedImage img5rocketv = null;

	//Maps
	BufferedImage imgwatertile = null;
	BufferedImage imgspacetile = null;
	BufferedImage imgstreettile = null;
	BufferedImage imgstars = null;
	int intX = 32;
	int intY = 135;
	int intX1 = 502;
	int intY1 = 135;
	String strImage = "";
	int intMapChoice =1;



	//methods
	//override how the JComponent is painted
	public void paintComponent(Graphics g){
		g.setColor(Color.BLACK);
		//g.fillRect(32,135,450,450);

		//g.fillRect(522,135,450,450);
		
		//g.setColor(Color.BLUE);
		g.drawImage(img2boath, 0, 0, null);
		//g.fillRect(0,0,50,50);
		
		
		//LOADS MAP INTO 2D ARRAY
		String strMap[][];
		strMap = new String[10][10];
		String strMapChoice = "";
		String strLine = "";
		String strSplit[];
			
		int intMapCol = 0;
		int intMapRow = 0;
		int intCount1;
		int intCount2;
		int intCount3;
		int intCount4;
			
		// CHOOSES THE CORRECT CSV FILE TO LOAD INTO ARRAY
			
		try{
			BufferedReader mapFile = new BufferedReader(new FileReader("map.csv"));
			
			while(intMapRow <= 9 && strLine != null){
				try{
					strLine = mapFile.readLine();
				}catch(IOException e){
					
				}
				strSplit = strLine.split(",");
				strMap[intMapRow][0] = strSplit[0];
				strMap[intMapRow][1] = strSplit[1];
				strMap[intMapRow][2] = strSplit[2];
				strMap[intMapRow][3] = strSplit[3];
				strMap[intMapRow][4] = strSplit[4];
				strMap[intMapRow][5] = strSplit[5];
				strMap[intMapRow][6] = strSplit[6];
				strMap[intMapRow][7] = strSplit[7];
				strMap[intMapRow][8] = strSplit[8];
				strMap[intMapRow][9] = strSplit[9];
				intMapRow += 1;
			}
			
			mapFile.close();
		}catch(FileNotFoundException e){
			System.out.println("Can't load file");
		}catch(IOException e){
			System.out.println("Can't load file");

		}
			
		
		System.out.println(intMapChoice);
		if(intMapChoice == 1){	
			for(intCount1 = 0; intCount1 < 10; intCount1++){
				for(intCount2 = 0; intCount2 <10; intCount2++){
					if(strMap[intCount1][intCount2].equals("w")){
						//System.out.println(strMap[intCount1][intCount2]);
						g.drawImage(imgwatertile, intX + intCount2 *45, intY + intCount1 * 45, null);
					}
				}
	
			}
			for(intCount3 = 0; intCount3 < 10; intCount3++){
				for(intCount4 = 0; intCount4 <10; intCount4++){
					if(strMap[intCount3][intCount4].equals("w")){
						//System.out.println(strMap[intCount1][intCount2]);
						g.drawImage(imgwatertile, intX1 + intCount4 *45, intY1 + intCount3 * 45, null);
					}
				}
			}
		}else if(intMapChoice == 2){
			for(intCount1 = 0; intCount1 < 10; intCount1++){
				for(intCount2 = 0; intCount2 <10; intCount2++){
					if(strMap[intCount1][intCount2].equals("w")){
						//System.out.println(strMap[intCount1][intCount2]);
						g.drawImage(imgstreettile, intX + intCount2 *45, intY + intCount1 * 45, null);
					}
				}
	
			}
			for(intCount3 = 0; intCount3 < 10; intCount3++){
				for(intCount4 = 0; intCount4 <10; intCount4++){
					if(strMap[intCount3][intCount4].equals("w")){
						//System.out.println(strMap[intCount1][intCount2]);
						g.drawImage(imgstreettile, intX1 + intCount4 *45, intY1 + intCount3 * 45, null);
					}
				}
			}
		}else if(intMapChoice ==3){
			for(intCount1 = 0; intCount1 < 10; intCount1++){
				for(intCount2 = 0; intCount2 <10; intCount2++){
					if(strMap[intCount1][intCount2].equals("w")){
						//System.out.println(strMap[intCount1][intCount2]);
						g.drawImage(imgspacetile, intX + intCount2 *45, intY + intCount1 * 45, null);
					}
				}
	
			}
			for(intCount3 = 0; intCount3 < 10; intCount3++){
				for(intCount4 = 0; intCount4 <10; intCount4++){
					if(strMap[intCount3][intCount4].equals("w")){
						//System.out.println(strMap[intCount1][intCount2]);
						g.drawImage(imgspacetile, intX1 + intCount4 *45, intY1 + intCount3 * 45, null);
					}
				}
			}
			g.drawImage(imgstars, 32,135,null);
			g.drawImage(imgstars, 502,135,null);

		}
			
	}
	//constructor
	public apanel(){
		InputStream imageclass = null;
		
		//Water
		imageclass = this.getClass().getResourceAsStream("watertile.png");
		if(imageclass != null){
			try{
				imgwatertile = ImageIO.read(imageclass);
			}catch(IOException e){
				System.out.println("Unable to load image from jar");
			}
		}
		if(imgwatertile == null){
			try{
				imgwatertile = ImageIO.read(new File("watertile.png"));
			}catch(IOException e){
				System.out.println("Unable to load images");
			}
		}
		
		//Street
		imageclass = this.getClass().getResourceAsStream("streettile.png");
		if(imageclass != null){
			try{
				imgstreettile = ImageIO.read(imageclass);
			}catch(IOException e){
				System.out.println("Unable to load image from jar");
			}
		}
		if(imgstreettile == null){
			try{
				imgstreettile = ImageIO.read(new File("streettile.png"));
			}catch(IOException e){
				System.out.println("Unable to load images");
			}
		}

		//Space
		
		imageclass = this.getClass().getResourceAsStream("spacetile.png");
		if(imageclass != null){
			try{
				imgspacetile = ImageIO.read(imageclass);
			}catch(IOException e){
				System.out.println("Unable to load image from jar");
			}
		}
		if(imgspacetile == null){
			try{
				imgspacetile = ImageIO.read(new File("spacetile.png"));
			}catch(IOException e){
				System.out.println("Unable to load images");
			}
		}
		
		imageclass = this.getClass().getResourceAsStream("stars.png");
		if(imageclass != null){
			try{
				imgstars = ImageIO.read(imageclass);
			}catch(IOException e){
				System.out.println("Unable to load image from jar");
			}
		}
		if(imgstars == null){
			try{
				imgstars = ImageIO.read(new File("stars.png"));
			}catch(IOException e){
				System.out.println("Unable to load images");
			}
		}
		
		//Boats
		
		//Boat 2
		imageclass = this.getClass().getResourceAsStream("2boath.png");
		if(imageclass != null){
			try{
				img2boath = ImageIO.read(imageclass);
			}catch(IOException e){
				System.out.println("Unable to load image from jar");
			}
		}
		if(img2boath == null){
			try{
				img2boath = ImageIO.read(new File("2boath.png"));
			}catch(IOException e){
				System.out.println("Unable to load images");
			}
		}
	
		imageclass = this.getClass().getResourceAsStream("2boatv.png");
		if(imageclass != null){
			try{
				img2boatv = ImageIO.read(imageclass);
			}catch(IOException e){
				System.out.println("Unable to load image from jar");
			}
		}
		if(img2boatv == null){
			try{
				img2boatv = ImageIO.read(new File("2boatv.png"));
			}catch(IOException e){
				System.out.println("Unable to load images");
			}
		}
		
		//Boat 3
		imageclass = this.getClass().getResourceAsStream("3boath.png");
		if(imageclass != null){
			try{
				img3boath = ImageIO.read(imageclass);
			}catch(IOException e){
				System.out.println("Unable to load image from jar");
			}
		}
		if(img3boath == null){
			try{
				img3boath = ImageIO.read(new File("3boath.png"));
			}catch(IOException e){
				System.out.println("Unable to load images");
			}
		}
		
		imageclass = this.getClass().getResourceAsStream("3boatv.png");
		if(imageclass != null){
			try{
				img3boatv = ImageIO.read(imageclass);
			}catch(IOException e){
				System.out.println("Unable to load image from jar");
			}
		}
		if(img3boatv == null){
			try{
				img3boatv = ImageIO.read(new File("3boatv.png"));
			}catch(IOException e){
				System.out.println("Unable to load images");
			}
		}
	
		//Boat 4
		imageclass = this.getClass().getResourceAsStream("4boath.png");
		if(imageclass != null){
			try{
				img4boath = ImageIO.read(imageclass);
			}catch(IOException e){
				System.out.println("Unable to load image from jar");
			}
		}
		if(img4boath == null){
			try{
				img4boath = ImageIO.read(new File("4boath.png"));
			}catch(IOException e){
				System.out.println("Unable to load images");
			}
		}
		
		imageclass = this.getClass().getResourceAsStream("4boatv.png");
		if(imageclass != null){
			try{
				img4boatv = ImageIO.read(imageclass);
			}catch(IOException e){
				System.out.println("Unable to load image from jar");
			}
		}
		if(img4boatv == null){
			try{
				img4boatv = ImageIO.read(new File("4boatv.png"));
			}catch(IOException e){
				System.out.println("Unable to load images");
			}
		}
		
		//Boat 5
		imageclass = this.getClass().getResourceAsStream("5boath.png");
		if(imageclass != null){
			try{
				img5boath = ImageIO.read(imageclass);
			}catch(IOException e){
				System.out.println("Unable to load image from jar");
			}
		}
		if(img5boath == null){
			try{
				img5boath = ImageIO.read(new File("5boath.png"));
			}catch(IOException e){
				System.out.println("Unable to load images");
			}
		}
		
		imageclass = this.getClass().getResourceAsStream("5boatv.png");
		if(imageclass != null){
			try{
				img5boatv = ImageIO.read(imageclass);
			}catch(IOException e){
				System.out.println("Unable to load image from jar");
			}
		}
		if(img5boatv == null){
			try{
				img5boatv = ImageIO.read(new File("5boatv.png"));
			}catch(IOException e){
				System.out.println("Unable to load images");
			}
		}
		
		
		//Cars
		
		//Car 2
		imageclass = this.getClass().getResourceAsStream("2carh.png");
		if(imageclass != null){
			try{
				img2carh = ImageIO.read(imageclass);
			}catch(IOException e){
				System.out.println("Unable to load image from jar");
			}
		}
		if(img2carh == null){
			try{
				img2carh = ImageIO.read(new File("2carh.png"));
			}catch(IOException e){
				System.out.println("Unable to load images");
			}
		}
		
		imageclass = this.getClass().getResourceAsStream("2carv.png");
		if(imageclass != null){
			try{
				img2carv = ImageIO.read(imageclass);
			}catch(IOException e){
				System.out.println("Unable to load image from jar");
			}
		}
		if(img2carv == null){
			try{
				img2carv = ImageIO.read(new File("2carv.png"));
			}catch(IOException e){
				System.out.println("Unable to load images");
			}
		}
		
		//Car 3
		imageclass = this.getClass().getResourceAsStream("3carh.png");
		if(imageclass != null){
			try{
				img3carh = ImageIO.read(imageclass);
			}catch(IOException e){
				System.out.println("Unable to load image from jar");
			}
		}
		if(img3carh == null){
			try{
				img3carh = ImageIO.read(new File("3carh.png"));
			}catch(IOException e){
				System.out.println("Unable to load images");
			}
		}
		
		imageclass = this.getClass().getResourceAsStream("3carv.png");
		if(imageclass != null){
			try{
				img3carv = ImageIO.read(imageclass);
			}catch(IOException e){
				System.out.println("Unable to load image from jar");
			}
		}
		if(img3carv == null){
			try{
				img3carv = ImageIO.read(new File("3carv.png"));
			}catch(IOException e){
				System.out.println("Unable to load images");
			}
		}
		
		//Car 4
		imageclass = this.getClass().getResourceAsStream("4carh.png");
		if(imageclass != null){
			try{
				img4carh = ImageIO.read(imageclass);
			}catch(IOException e){
				System.out.println("Unable to load image from jar");
			}
		}
		if(img4carh == null){
			try{
				img4carh = ImageIO.read(new File("4carh.png"));
			}catch(IOException e){
				System.out.println("Unable to load images");
			}
		}
		
		imageclass = this.getClass().getResourceAsStream("4carv.png");
		if(imageclass != null){
			try{
				img4carv = ImageIO.read(imageclass);
			}catch(IOException e){
				System.out.println("Unable to load image from jar");
			}
		}
		if(img4carv == null){
			try{
				img4carv = ImageIO.read(new File("4carv.png"));
			}catch(IOException e){
				System.out.println("Unable to load images");
			}
		}
		
		//Car 5
		imageclass = this.getClass().getResourceAsStream("5carh.png");
		if(imageclass != null){
			try{
				img5carh = ImageIO.read(imageclass);
			}catch(IOException e){
				System.out.println("Unable to load image from jar");
			}
		}
		if(img5carh == null){
			try{
				img5carh = ImageIO.read(new File("5carh.png"));
			}catch(IOException e){
				System.out.println("Unable to load images");
			}
		}
		
		imageclass = this.getClass().getResourceAsStream("5carv.png");
		if(imageclass != null){
			try{
				img5carv = ImageIO.read(imageclass);
			}catch(IOException e){
				System.out.println("Unable to load image from jar");
			}
		}
		if(img5carv == null){
			try{
				img5carv = ImageIO.read(new File("5carv.png"));
			}catch(IOException e){
				System.out.println("Unable to load images");
			}
		}
		
		//Rockets
		
		//Rocket 2
		imageclass = this.getClass().getResourceAsStream("2rocketh.png");
		if(imageclass != null){
			try{
				img2rocketh = ImageIO.read(imageclass);
			}catch(IOException e){
				System.out.println("Unable to load image from jar");
			}
		}
		if(img2rocketh == null){
			try{
				img2rocketh = ImageIO.read(new File("2rocketh.png"));
			}catch(IOException e){
				System.out.println("Unable to load images");
			}
		}
		
		imageclass = this.getClass().getResourceAsStream("2rocketv.png");
		if(imageclass != null){
			try{
				img2rocketv = ImageIO.read(imageclass);
			}catch(IOException e){
				System.out.println("Unable to load image from jar");
			}
		}
		if(img2rocketv == null){
			try{
				img2rocketv = ImageIO.read(new File("2rocketv.png"));
			}catch(IOException e){
				System.out.println("Unable to load images");
			}
		}
		
		//Rocket 3
		imageclass = this.getClass().getResourceAsStream("3rocketh.png");
		if(imageclass != null){
			try{
				img3rocketh = ImageIO.read(imageclass);
			}catch(IOException e){
				System.out.println("Unable to load image from jar");
			}
		}
		if(img3rocketh == null){
			try{
				img3rocketh = ImageIO.read(new File("3rocketh.png"));
			}catch(IOException e){
				System.out.println("Unable to load images");
			}
		}
		
		imageclass = this.getClass().getResourceAsStream("3rocketv.png");
		if(imageclass != null){
			try{
				img3rocketv = ImageIO.read(imageclass);
			}catch(IOException e){
				System.out.println("Unable to load image from jar");
			}
		}
		if(img3rocketv == null){
			try{
				img3rocketv = ImageIO.read(new File("3rocketv.png"));
			}catch(IOException e){
				System.out.println("Unable to load images");
			}
		}
		//Rocket 4
		imageclass = this.getClass().getResourceAsStream("4rocketh.png");
		if(imageclass != null){
			try{
				img4rocketh = ImageIO.read(imageclass);
			}catch(IOException e){
				System.out.println("Unable to load image from jar");
			}
		}
		if(img4rocketh == null){
			try{
				img4rocketh = ImageIO.read(new File("4rocketh.png"));
			}catch(IOException e){
				System.out.println("Unable to load images");
			}
		}
		
		imageclass = this.getClass().getResourceAsStream("4rocketv.png");
		if(imageclass != null){
			try{
				img4rocketv = ImageIO.read(imageclass);
			}catch(IOException e){
				System.out.println("Unable to load image from jar");
			}
		}
		if(img4rocketv == null){
			try{
				img4rocketv = ImageIO.read(new File("4rocketv.png"));
			}catch(IOException e){
				System.out.println("Unable to load images");
			}
		}
		
		//Rocket 5
		imageclass = this.getClass().getResourceAsStream("5rocketh.png");
		if(imageclass != null){
			try{
				img5rocketh = ImageIO.read(imageclass);
			}catch(IOException e){
				System.out.println("Unable to load image from jar");
			}
		}
		if(img5rocketh == null){
			try{
				img5rocketh = ImageIO.read(new File("5rocketh.png"));
			}catch(IOException e){
				System.out.println("Unable to load images");
			}
		}
		
		imageclass = this.getClass().getResourceAsStream("5rocketv.png");
		if(imageclass != null){
			try{
				img5rocketv = ImageIO.read(imageclass);
			}catch(IOException e){
				System.out.println("Unable to load image from jar");
			}
		}
		if(img5rocketv == null){
			try{
				img5rocketv = ImageIO.read(new File("5rocketv.png"));
			}catch(IOException e){
				System.out.println("Unable to load images");
			}
		}
	}
}
