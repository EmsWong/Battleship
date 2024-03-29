import java.awt.*;
import javax.swing.*;
import java.awt.image.*;
import java.io.*;
import javax.imageio.*;

public class apanel extends JPanel{
	// Properties
	
	//Game Pieces
	/**Different variations of boat images*/
	BufferedImage img2h = null;
	BufferedImage img2v = null;
	BufferedImage img3h = null;
	BufferedImage img3v = null;
	BufferedImage img4h = null;
	BufferedImage img4v = null;
	BufferedImage img5h = null;
	BufferedImage img5v = null;

	//Maps
	/**Imamges for the map*/
	BufferedImage imgtile = null;
	BufferedImage imgstars = null;
	BufferedImage imghit = null;
	BufferedImage imgmiss = null;

	//Row and Column
	/**Variables to determine which row and column they have attack*/
	int intRow;
	int intCol;
	
	int intX = 32;
	int intY = 135;
	int intX1 = 502;
	int intY1 = 135;
	String strImage = "";
	int intMapChoice = 0;

	// game piece coordinates
	/**Coordinates for game pieces*/
	int int2px1 = 32;
	int int2py1 = 135;
	int int2px2 = 122;
	int int2py2 = 180;
	int int3apx1 = 32;
	int int3apy1 = 180;
	int int3apx2 = 167;
	int int3apy2 = 225;
	int int3bpx1 = 32;
	int int3bpy1 = 225;
	int int3bpx2 = 167;
	int int3bpy2 = 270;
	int int4px1 = 32;
	int int4py1 = 270;
	int int4px2 = 212;
	int int4py2 = 315;
	int int5px1 = 32;
	int int5py1 = 315;
	int int5px2 = 257;
	int int5py2 = 360;

	//Opponent board
	/**Variables for the opponents board*/
	int intguessx;
	int intguessy;
	int intCounter;

	// mouse variables
	/**Variables for the mouse*/
	int intMousex;
	int intMousey;
	boolean blnMove2 = false;
	boolean blnMove3a = false;
	boolean blnMove3b = false;
	boolean blnMove4 = false;
	boolean blnMove5 = false;

	// key variables
	/**Variables for the keys*/
	boolean blnRot2 = false;
	boolean blnRot3a = false;
	boolean blnRot3b = false;
	boolean blnRot4 = false;
	boolean blnRot5 = false;
	
	//maps
	/**Variables for maps*/
	String strMap[][] = new String[10][10];
	String strDotMap1[][] = new String[10][10];
	String strDotMap2[][] = new String[10][10];
	
	/**Varible to know if the game started*/
	boolean gameStarted = false;

	// Player variables
	/**Variables to indicate the players turn*/
	int intPlayerTurn = 0;
	int intPlayer;

	//hit or miss
	/**Variable to indicate if there a boat is hit or missed*/
	int intHit = 0;
	/**
     * Override how the JComponent is painted
     * Draws the map based on what theme is chosen
     * While playing the game it will draw dots based on where players attack
     * @param g graphics
     */
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		g.setColor(Color.WHITE);
		
		String strTheme[][];
		strTheme = new String[10][10];
		String strLine = "";
		String strSplit[];
		int intTemp;
		int intCount;
		
		
		//loads game map and game pieces based on what theme the host selected
		if(intMapChoice == 1){
			try{
				InputStreamReader themefile = new InputStreamReader(getClass().getResourceAsStream("theme.csv"));
				BufferedReader themeFile = new BufferedReader(themefile);
				try{
					strLine = themeFile.readLine();
				}catch(IOException e){
					
				}
				strSplit = strLine.split(",");
				strTheme[0][0] = strSplit[0];
				strTheme[0][1] = strSplit[1];
				strTheme[0][2] = strSplit[2];
				strTheme[0][3] = strSplit[3];
				strTheme[0][4] = strSplit[4];
				strTheme[0][5] = strSplit[5];
				strTheme[0][6] = strSplit[6];
				strTheme[0][7] = strSplit[7];
				strTheme[0][8] = strSplit[8];
				strTheme[0][9] = strSplit[9];

				themeFile.close();
			}catch(FileNotFoundException e){
				System.out.println("Can't load file");
			}catch(IOException e){
				System.out.println("Can't load file");
			}
		}else if(intMapChoice == 2){
			try{
				InputStreamReader themefile = new InputStreamReader(getClass().getResourceAsStream("theme.csv"));
				BufferedReader themeFile = new BufferedReader(themefile);
				try{
					strLine = themeFile.readLine();
					strLine = themeFile.readLine();
				}catch(IOException e){
					
				}
				strSplit = strLine.split(",");
				strTheme[0][0] = strSplit[0];
				strTheme[0][1] = strSplit[1];
				strTheme[0][2] = strSplit[2];
				strTheme[0][3] = strSplit[3];
				strTheme[0][4] = strSplit[4];
				strTheme[0][5] = strSplit[5];
				strTheme[0][6] = strSplit[6];
				strTheme[0][7] = strSplit[7];
				strTheme[0][8] = strSplit[8];
				strTheme[0][9] = strSplit[9];

				themeFile.close();
			}catch(FileNotFoundException e){
				System.out.println("Can't load file");
			}catch(IOException e){
				System.out.println("Can't load file");
			}

			
		}else if(intMapChoice == 3){
			try{
				InputStreamReader themefile = new InputStreamReader(getClass().getResourceAsStream("theme.csv"));
				BufferedReader themeFile = new BufferedReader(themefile);
				try{
					strLine = themeFile.readLine();
					strLine = themeFile.readLine();
					strLine = themeFile.readLine();
				}catch(IOException e){
					
				}
				strSplit = strLine.split(",");
				strTheme[0][0] = strSplit[0];
				strTheme[0][1] = strSplit[1];
				strTheme[0][2] = strSplit[2];
				strTheme[0][3] = strSplit[3];
				strTheme[0][4] = strSplit[4];
				strTheme[0][5] = strSplit[5];
				strTheme[0][6] = strSplit[6];
				strTheme[0][7] = strSplit[7];
				strTheme[0][8] = strSplit[8];
				strTheme[0][9] = strSplit[9];

				themeFile.close();
			}catch(FileNotFoundException e){
				System.out.println("Can't load file");
			}catch(IOException e){
				System.out.println("Can't load file");
			}
		}
		
		String strImage = strTheme[0][1];
		InputStream imageclass = null;

		//loads game pieces and tiles
		imageclass = this.getClass().getResourceAsStream("Resources/"+strImage);
		if(imageclass != null){
			try{
				imgtile = ImageIO.read(imageclass);
			}catch(IOException e){
				System.out.println("Unable to load image from jar");
			}
		}
		if(imgtile == null){
			try{
				imgtile = ImageIO.read(new File("Resources/"+strImage));
			}catch(IOException e){
				System.out.println("Unable to load images");
			}
		}
		
		strImage = strTheme[0][2];
		imageclass = null;
		
		imageclass = this.getClass().getResourceAsStream("Resources/"+strImage);
		if(imageclass != null){
			try{
				img2h = ImageIO.read(imageclass);
			}catch(IOException e){
				System.out.println("Unable to load image from jar");
			}
		}
		if(img2h == null){
			try{
				img2h = ImageIO.read(new File("Resources/"+strImage));
			}catch(IOException e){
				System.out.println("Unable to load images");
			}
		}
		
		strImage = strTheme[0][3];
		imageclass = null;
		
		imageclass = this.getClass().getResourceAsStream("Resources/"+strImage);
		if(imageclass != null){
			try{
				img2v = ImageIO.read(imageclass);
			}catch(IOException e){
				System.out.println("Unable to load image from jar");
			}
		}
		if(img2v == null){
			try{
				img2v = ImageIO.read(new File("Resources/"+strImage));
			}catch(IOException e){
				System.out.println("Unable to load images");
			}
		}
		
		strImage = strTheme[0][4];
		imageclass = null;
		
		imageclass = this.getClass().getResourceAsStream("Resources/"+strImage);
		if(imageclass != null){
			try{
				img3h = ImageIO.read(imageclass);
			}catch(IOException e){
				System.out.println("Unable to load image from jar");
			}
		}
		if(img3h == null){
			try{
				img3h = ImageIO.read(new File("Resources/"+strImage));
			}catch(IOException e){
				System.out.println("Unable to load images");
			}
		}

		strImage = strTheme[0][5];
		imageclass = null;
		
		imageclass = this.getClass().getResourceAsStream("Resources/"+strImage);
		if(imageclass != null){
			try{
				img3v = ImageIO.read(imageclass);
			}catch(IOException e){
				System.out.println("Unable to load image from jar");
			}
		}
		if(img3v == null){
			try{
				img3v = ImageIO.read(new File("Resources/"+strImage));
			}catch(IOException e){
				System.out.println("Unable to load images");
			}
		}

		strImage = strTheme[0][6];
		imageclass = null;
		
		imageclass = this.getClass().getResourceAsStream("Resources/"+strImage);
		if(imageclass != null){
			try{
				img4h = ImageIO.read(imageclass);
			}catch(IOException e){
				System.out.println("Unable to load image from jar");
			}
		}
		if(img4h == null){
			try{
				img4h = ImageIO.read(new File("Resources/"+strImage));
			}catch(IOException e){
				System.out.println("Unable to load images");
			}
		}

		strImage = strTheme[0][7];
		imageclass = null;
		
		imageclass = this.getClass().getResourceAsStream("Resources/"+strImage);
		if(imageclass != null){
			try{
				img4v = ImageIO.read(imageclass);
			}catch(IOException e){
				System.out.println("Unable to load image from jar");
			}
		}
		if(img4v == null){
			try{
				img4v = ImageIO.read(new File("Resources/"+strImage));
			}catch(IOException e){
				System.out.println("Unable to load images");
			}
		}

		strImage = strTheme[0][8];
		imageclass = null;
		
		imageclass = this.getClass().getResourceAsStream("Resources/"+strImage);
		if(imageclass != null){
			try{
				img5h = ImageIO.read(imageclass);
			}catch(IOException e){
				System.out.println("Unable to load image from jar");
			}
		}
		if(img5h == null){
			try{
				img5h = ImageIO.read(new File("Resources/"+strImage));
			}catch(IOException e){
				System.out.println("Unable to load images");
			}
		}

		strImage = strTheme[0][9];
		imageclass = null;
		
		imageclass = this.getClass().getResourceAsStream("Resources/"+strImage);
		if(imageclass != null){
			try{
				img5v = ImageIO.read(imageclass);
			}catch(IOException e){
				System.out.println("Unable to load image from jar");
			}
		}
		if(img5v == null){
			try{
				img5v = ImageIO.read(new File("Resources/"+strImage));
			}catch(IOException e){
				System.out.println("Unable to load images");
			}
		}
		
		//LOADS MAP INTO 2D ARRAY
		String strLines = "";
		String strSplits[];
		int intMapCol = 0;
		int intMapRow = 0;
		int intCount1;
		int intCount2;
		int intCount3;
		int intCount4;
			
		// Reads the csv file for the map
		try{	
			InputStreamReader mapfile = new InputStreamReader(getClass().getResourceAsStream("map.csv"));
			BufferedReader mapFile = new BufferedReader(mapfile);

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
		
		//draws the tiles for the player map
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

		//draws the tiles for the opponent map
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
		
		//draws stars for the 3rd theme
		if(intMapChoice == 3){
			g.drawImage(imgstars, 32,135,null);
			g.drawImage(imgstars, 502,135,null);
		}

		int intcheck = 0;

		// if statements to check if the horizontal or vertical version of the game pieces should be drawn
		if(blnRot2 == false){
			g.drawImage(img2h, int2px1, int2py1, null);
		}else{
			g.drawImage(img2v, int2px1, int2py1, null);
		}

		if(blnRot3a == false){
			g.drawImage(img3h, int3apx1, int3apy1, null);
		}else{
			g.drawImage(img3v, int3apx1, int3apy1, null);
		}

		if(blnRot3b == false){
			g.drawImage(img3h, int3bpx1, int3bpy1, null);
		}else{
			g.drawImage(img3v, int3bpx1, int3bpy1, null);
		}

		if(blnRot4 == false){
			g.drawImage(img4h, int4px1, int4py1, null);
		}else{
			g.drawImage(img4v, int4px1, int4py1, null);
		}
		
		if(blnRot5 == false){
			g.drawImage(img5h, int5px1, int5py1, null);
		}else{
			g.drawImage(img5v, int5px1, int5py1, null);
		}

		//loads an array that holds 2 dot maps.
		//   - dotmap1 is responsible for what is being drawn on the left map. the array holds where the opponent has hit/missed
		//   - dotmap2 is responsible for what is being drawn on the right map. the array holds where the player has hit/missed
		if(gameStarted == true){
			try{
				int intDotX;
				int intDotY;
				for (int i = 0; i < 10; i++) {
					for (int j = 0; j < 10; j++) {
						if(strDotMap1[i][j].equals("n")){
							//nothing is drawn there
						}else if(strDotMap1[i][j].equals("h")){
							intDotX = 32 + (j * 45);
							intDotY = 135 + (i * 45);
							g.drawImage(imghit, intDotX, intDotY, null);
						}else if(strDotMap1[i][j].equals("m")){
							intDotX = 32 + (j * 45);
							intDotY = 135 + (i * 45);
							g.drawImage(imgmiss, intDotX, intDotY, null);
						}
					}
				}
				for (int i = 0; i < 10; i++) {
					for (int j = 0; j < 10; j++) {
						if(strDotMap2[i][j].equals("n")){
							//nothing is drawn there
						}else if(strDotMap2[i][j].equals("h")){
							intDotX = 502 + (j * 45);
							intDotY = 135 + (i * 45);
							g.drawImage(imghit, intDotX, intDotY, null);
						}else if(strDotMap2[i][j].equals("m")){
							intDotX = 502 + (j * 45);
							intDotY = 135 + (i * 45);
							g.drawImage(imgmiss, intDotX, intDotY, null);
						}
					}
				}
			}catch(NumberFormatException e){
				System.out.println("Unable to parse number");
			}catch(ArrayIndexOutOfBoundsException e){
				System.out.println("array out of bounds");
			}
		}
		
		

		

	}
	//constructor
	/**
     * Constructor for apanel
     */
	public apanel(){
		InputStream imageclass = null;
		
		
		imageclass = this.getClass().getResourceAsStream("Resources/stars.png");
		if(imageclass != null){
			try{
				imgstars = ImageIO.read(imageclass);
			}catch(IOException e){
				System.out.println("Unable to load image from jar");
			}
		}
		if(imgstars == null){
			try{
				imgstars = ImageIO.read(new File("Resources/stars.png"));
			}catch(IOException e){
				System.out.println("Unable to load images");
			}
		}

		imageclass = null;
		
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

		imageclass = null;
		
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
