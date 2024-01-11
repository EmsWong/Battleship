import java.awt.*;
import javax.swing.*;
import java.awt.image.*;
import java.io.*;
import javax.imageio.*;

public class apanel extends JPanel{
	// Properties
	BufferedImage img2boath = null;
	BufferedImage img2boatv = null;
	BufferedImage img3boath = null;
	BufferedImage img3boatv = null;
	BufferedImage img4boath = null;
	BufferedImage img4boatv = null;
	BufferedImage img5boath = null;
	BufferedImage img5boatv = null;
	BufferedImage img2carh = null;
	BufferedImage img2carv = null;
	BufferedImage img3carh = null;
	BufferedImage img3carv = null;
	BufferedImage img4carh = null;
	BufferedImage img4carv = null;
	BufferedImage img5carh = null;
	BufferedImage img5carv = null;
	BufferedImage img2rocketh = null;
	BufferedImage imgwatertile = null;
	BufferedImage imgspacetile = null;
	BufferedImage imgstreettile = null;
	BufferedImage imgstars = null;
	int intX = 32;
	int intY = 135;
	int intX1 = 522;
	int intY1 = 135;
	String strImage = "";
	int intMapChoice =1;



	//methods
	//override how the JComponent is painted
	public void paintComponent(Graphics g){
		g.setColor(Color.BLACK);
		g.fillRect(32,135,450,450);

		g.fillRect(522,135,450,450);
		
		g.setColor(Color.BLUE);
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
			g.drawImage(imgstars, 522,135,null);

		}
			
	}
	//constructor
	public apanel(){

		if(imgwatertile == null){
			try{
				//img2boath = ImageIO.read(new File("2boath.png"));
				imgwatertile = ImageIO.read(new File("watertile.png"));
			}catch(IOException e){
				System.out.println("Could not open image");
			}
		}
		if(imgstreettile == null){
			try{
				imgstreettile = ImageIO.read(new File("streettile.png"));
			}catch(IOException e){
				System.out.println("Could not open image");
			}
		}
		if(imgspacetile == null){
			try{
				imgspacetile = ImageIO.read(new File("spacetile.png"));
			}catch(IOException e){
				System.out.println("Could not open image");
			}
		}
		if(imgstars == null){
			try{
				imgstars = ImageIO.read(new File("stars.png"));
			}catch(IOException e){
				System.out.println("Could not open image");
			}
		}
	}
}
