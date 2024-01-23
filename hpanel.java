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
	
	BufferedImage imgboat2 = null;
	BufferedImage imgboat3a = null;
	BufferedImage imgboat3b = null;
	BufferedImage imgboat4 = null;
	BufferedImage imgboat5 = null;
	
	int intPanel;
	
	//Methods
	public void paintComponent(Graphics g){
		//Properties
		String strMap[][] = new String[10][10];
		String strLines = "";
		String strSplits[];
		int intMapCol = 0;
		int intMapRow = 0;
		int intCount1;
		int intCount2;
		int intCount3;
		int intCount4;
		
		int intX = 32;
		int intY = 135;
		int intX1 = 502;
		int intY1 = 135;
			
		
		try{
			BufferedReader mapFile = new BufferedReader(new FileReader("map.csv"));
			
			while(intMapRow <= 9 && strLines != null){
				try{
					strLines = mapFile.readLine();
				}catch(IOException e){
					
				}
				strSplits = strLines.split(",");
				strMap[intMapRow][0] = strSplits[0];
				strMap[intMapRow][1] = strSplits[1];
				strMap[intMapRow][2] = strSplits[2];
				strMap[intMapRow][3] = strSplits[3];
				strMap[intMapRow][4] = strSplits[4];
				strMap[intMapRow][5] = strSplits[5];
				strMap[intMapRow][6] = strSplits[6];
				strMap[intMapRow][7] = strSplits[7];
				strMap[intMapRow][8] = strSplits[8];
				strMap[intMapRow][9] = strSplits[9];
				intMapRow += 1;
			}
			
			mapFile.close();
		}catch(FileNotFoundException e){
			System.out.println("Can't load file");
		}catch(IOException e){
			System.out.println("Can't load file");

		}
		
		for(intCount1 = 0; intCount1 < 10; intCount1++){
			for(intCount2 = 0; intCount2 <10; intCount2++){
				if(strMap[intCount1][intCount2].equals("w")){
					g.drawImage(imgtile, intX + intCount2 *45, intY + intCount1 * 45, null);
				}
				if(strMap[intCount1][intCount2].equals("s")){
					g.drawImage(imgtile, intX + intCount2 *45, intY + intCount1 * 45, null);
				}
			}

		}
		for(intCount3 = 0; intCount3 < 10; intCount3++){
			for(intCount4 = 0; intCount4 <10; intCount4++){
				if(strMap[intCount3][intCount4].equals("w")){
					g.drawImage(imgtile, intX1 + intCount4 *45, intY1 + intCount3 * 45, null);
				}
				if(strMap[intCount3][intCount4].equals("s")){
					g.drawImage(imgtile, intX1 + intCount4 *45, intY1 + intCount3 * 45, null);
				}
			}
		}
		if(intPanel == 1){
			
		}else if(intPanel == 2){
			g.drawImage(imghit, 167, 270, null);
			g.drawImage(imghit, 167, 315, null);
			g.drawImage(imgmiss, 77, 360, null);
			g.drawImage(imgmiss, 392, 225, null);
			g.drawImage(imgmiss, 302, 450, null);
		}else if(intPanel == 3){
			
		}	
	}
	
	//constructor
	public hpanel(){
		InputStream imageclass = null;
		
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
		
	}
}
