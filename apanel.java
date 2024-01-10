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
	int intX = 100;
	int intY = 100;



	//methods
	//override how the JComponent is painted
	public void paintComponent(Graphics g){
		g.setColor(Color.BLACK);
		g.fillRect(32,135,450,450);

		g.fillRect(522,135,450,450);
		
		g.setColor(Color.BLUE);
		g.drawImage(img2boath, 0, 0, null);
		//g.fillRect(0,0,50,50);
		
		/*
		public void drawMap(int intMapChoice){
			//LOADS MAP INTO 2D ARRAY
			String strMap[][];
			strMap = new String[10][10];
			String strMapChoice = "";
			String strLine;
			String strSplit[];
			
			int intMapCol = 0;
			int intMapRow = 0;
			
			// CHOOSES THE CORRECT CSV FILE TO LOAD INTO ARRAY
			if (intMapChoice == 1){
				strMapChoice = "map.csv";
			} else if (intMapChoice == 2){
				strMapChoice = "map2.csv";
			}
			
			TextInputFile mapFile = new TextInputFile(strMapChoice);
			
			while (intMapRow <= 9){
				strLine = mapFile.readLine();
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
			
			int intCount1 = 0;
			int intCount2 = 0;
			while (intCount1 < 20){
				while (intCount2 < 20){
					if (strMap[intCount1][intCount2].equals("w")){
						//System.out.println(strMap[intCount1][intCount2]);
						g.drawImage(imgWater, intCount2 * 45, intCount1 * 45);
					}
				}
			}
		}
		*/

	}
	//constructor
	public apanel(){

		if(img2boath == null){
			try{
				img2boath = ImageIO.read(new File("2boath.png"));
			}catch(IOException e){
				System.out.println("Could not open image");
			}
		}
	}
}
