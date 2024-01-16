import java.awt.*;
import javax.swing.*;
import java.awt.image.*;
import java.io.*;
import javax.imageio.*;

public class apanel extends JPanel{
	// Properties
	
	//Game Pieces
	BufferedImage img2h = null;
	BufferedImage img2v = null;
	BufferedImage img3h = null;
	BufferedImage img3v = null;
	BufferedImage img4h = null;
	BufferedImage img4v = null;
	BufferedImage img5h = null;
	BufferedImage img5v = null;

	//Maps
	BufferedImage imgtile = null;
	BufferedImage imgstars = null;

	//Row and Column
	int intRow;
	int intCol;

	int intX = 32;
	int intY = 135;
	int intX1 = 502;
	int intY1 = 135;
	String strImage = "";
	int intMapChoice = 0;



	//methods
	//override how the JComponent is painted
	public void paintComponent(Graphics g){
		g.setColor(Color.BLACK);
		//g.fillRect(32,135,450,450);

		//g.fillRect(522,135,450,450);
		
		//g.setColor(Color.BLUE);
		//g.drawImage(img2boath, 0, 0, null);
		//g.fillRect(0,0,50,50);
		String strTheme[][];
		strTheme = new String[1][10];
		String strLine = "";
		String strSplit[];

		if(intMapChoice == 1){
			try{
				BufferedReader themeFile = new BufferedReader(new FileReader("theme.csv"));
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

			String strImage = strTheme[0][1];
			InputStream imageclass = null;
	
			imageclass = this.getClass().getResourceAsStream(strImage);
			if(imageclass != null){
				try{
					imgtile = ImageIO.read(imageclass);
				}catch(IOException e){
					System.out.println("Unable to load image from jar");
				}
			}
			if(imgtile == null){
				try{
					imgtile = ImageIO.read(new File(strImage));
				}catch(IOException e){
					System.out.println("Unable to load images");
				}
			}
			
			strImage = strTheme[0][2];
			imageclass = null;
			
			imageclass = this.getClass().getResourceAsStream(strImage);
			if(imageclass != null){
				try{
					img2h = ImageIO.read(imageclass);
				}catch(IOException e){
					System.out.println("Unable to load image from jar");
				}
			}
			if(img2h == null){
				try{
					img2h = ImageIO.read(new File(strImage));
				}catch(IOException e){
					System.out.println("Unable to load images");
				}
			}
			
			strImage = strTheme[0][3];
			imageclass = null;
			
			imageclass = this.getClass().getResourceAsStream(strImage);
			if(imageclass != null){
				try{
					img2v = ImageIO.read(imageclass);
				}catch(IOException e){
					System.out.println("Unable to load image from jar");
				}
			}
			if(img2v == null){
				try{
					img2v = ImageIO.read(new File(strImage));
				}catch(IOException e){
					System.out.println("Unable to load images");
				}
			}
			
			strImage = strTheme[0][4];
			imageclass = null;
			
			imageclass = this.getClass().getResourceAsStream(strImage);
			if(imageclass != null){
				try{
					img3h = ImageIO.read(imageclass);
				}catch(IOException e){
					System.out.println("Unable to load image from jar");
				}
			}
			if(img3h == null){
				try{
					img3h = ImageIO.read(new File(strImage));
				}catch(IOException e){
					System.out.println("Unable to load images");
				}
			}

			strImage = strTheme[0][5];
			imageclass = null;
			
			imageclass = this.getClass().getResourceAsStream(strImage);
			if(imageclass != null){
				try{
					img3v = ImageIO.read(imageclass);
				}catch(IOException e){
					System.out.println("Unable to load image from jar");
				}
			}
			if(img3v == null){
				try{
					img3v = ImageIO.read(new File(strImage));
				}catch(IOException e){
					System.out.println("Unable to load images");
				}
			}

			strImage = strTheme[0][6];
			imageclass = null;
			
			imageclass = this.getClass().getResourceAsStream(strImage);
			if(imageclass != null){
				try{
					img4h = ImageIO.read(imageclass);
				}catch(IOException e){
					System.out.println("Unable to load image from jar");
				}
			}
			if(img4h == null){
				try{
					img4h = ImageIO.read(new File(strImage));
				}catch(IOException e){
					System.out.println("Unable to load images");
				}
			}

			strImage = strTheme[0][7];
			imageclass = null;
			
			imageclass = this.getClass().getResourceAsStream(strImage);
			if(imageclass != null){
				try{
					img4v = ImageIO.read(imageclass);
				}catch(IOException e){
					System.out.println("Unable to load image from jar");
				}
			}
			if(img4v == null){
				try{
					img4v = ImageIO.read(new File(strImage));
				}catch(IOException e){
					System.out.println("Unable to load images");
				}
			}

			strImage = strTheme[0][8];
			imageclass = null;
			
			imageclass = this.getClass().getResourceAsStream(strImage);
			if(imageclass != null){
				try{
					img5h = ImageIO.read(imageclass);
				}catch(IOException e){
					System.out.println("Unable to load image from jar");
				}
			}
			if(img5h == null){
				try{
					img5h = ImageIO.read(new File(strImage));
				}catch(IOException e){
					System.out.println("Unable to load images");
				}
			}

			strImage = strTheme[0][9];
			imageclass = null;
			
			imageclass = this.getClass().getResourceAsStream(strImage);
			if(imageclass != null){
				try{
					img5v = ImageIO.read(imageclass);
				}catch(IOException e){
					System.out.println("Unable to load image from jar");
				}
			}
			if(img5v == null){
				try{
					img5v = ImageIO.read(new File(strImage));
				}catch(IOException e){
					System.out.println("Unable to load images");
				}
			}
		}else if(intMapChoice == 2){
			try{
				BufferedReader themeFile = new BufferedReader(new FileReader("theme.csv"));
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

			String strImage = strTheme[0][1];
			InputStream imageclass = null;
	
			imageclass = this.getClass().getResourceAsStream(strImage);
			if(imageclass != null){
				try{
					imgtile = ImageIO.read(imageclass);
				}catch(IOException e){
					System.out.println("Unable to load image from jar");
				}
			}
			if(imgtile == null){
				try{
					imgtile = ImageIO.read(new File(strImage));
				}catch(IOException e){
					System.out.println("Unable to load images");
				}
			}
			
			strImage = strTheme[0][2];
			imageclass = null;
			
			imageclass = this.getClass().getResourceAsStream(strImage);
			if(imageclass != null){
				try{
					img2h = ImageIO.read(imageclass);
				}catch(IOException e){
					System.out.println("Unable to load image from jar");
				}
			}
			if(img2h == null){
				try{
					img2h = ImageIO.read(new File(strImage));
				}catch(IOException e){
					System.out.println("Unable to load images");
				}
			}
			
			strImage = strTheme[0][3];
			imageclass = null;
			
			imageclass = this.getClass().getResourceAsStream(strImage);
			if(imageclass != null){
				try{
					img2v = ImageIO.read(imageclass);
				}catch(IOException e){
					System.out.println("Unable to load image from jar");
				}
			}
			if(img2v == null){
				try{
					img2v = ImageIO.read(new File(strImage));
				}catch(IOException e){
					System.out.println("Unable to load images");
				}
			}
			
			strImage = strTheme[0][4];
			imageclass = null;
			
			imageclass = this.getClass().getResourceAsStream(strImage);
			if(imageclass != null){
				try{
					img3h = ImageIO.read(imageclass);
				}catch(IOException e){
					System.out.println("Unable to load image from jar");
				}
			}
			if(img3h == null){
				try{
					img3h = ImageIO.read(new File(strImage));
				}catch(IOException e){
					System.out.println("Unable to load images");
				}
			}

			strImage = strTheme[0][5];
			imageclass = null;
			
			imageclass = this.getClass().getResourceAsStream(strImage);
			if(imageclass != null){
				try{
					img3v = ImageIO.read(imageclass);
				}catch(IOException e){
					System.out.println("Unable to load image from jar");
				}
			}
			if(img3v == null){
				try{
					img3v = ImageIO.read(new File(strImage));
				}catch(IOException e){
					System.out.println("Unable to load images");
				}
			}

			strImage = strTheme[0][6];
			imageclass = null;
			
			imageclass = this.getClass().getResourceAsStream(strImage);
			if(imageclass != null){
				try{
					img4h = ImageIO.read(imageclass);
				}catch(IOException e){
					System.out.println("Unable to load image from jar");
				}
			}
			if(img4h == null){
				try{
					img4h = ImageIO.read(new File(strImage));
				}catch(IOException e){
					System.out.println("Unable to load images");
				}
			}

			strImage = strTheme[0][7];
			imageclass = null;
			
			imageclass = this.getClass().getResourceAsStream(strImage);
			if(imageclass != null){
				try{
					img4v = ImageIO.read(imageclass);
				}catch(IOException e){
					System.out.println("Unable to load image from jar");
				}
			}
			if(img4v == null){
				try{
					img4v = ImageIO.read(new File(strImage));
				}catch(IOException e){
					System.out.println("Unable to load images");
				}
			}

			strImage = strTheme[0][8];
			imageclass = null;
			
			imageclass = this.getClass().getResourceAsStream(strImage);
			if(imageclass != null){
				try{
					img5h = ImageIO.read(imageclass);
				}catch(IOException e){
					System.out.println("Unable to load image from jar");
				}
			}
			if(img5h == null){
				try{
					img5h = ImageIO.read(new File(strImage));
				}catch(IOException e){
					System.out.println("Unable to load images");
				}
			}

			strImage = strTheme[0][9];
			imageclass = null;
			
			imageclass = this.getClass().getResourceAsStream(strImage);
			if(imageclass != null){
				try{
					img5v = ImageIO.read(imageclass);
				}catch(IOException e){
					System.out.println("Unable to load image from jar");
				}
			}
			if(img5v == null){
				try{
					img5v = ImageIO.read(new File(strImage));
				}catch(IOException e){
					System.out.println("Unable to load images");
				}
			}
		}else if(intMapChoice == 3){
			try{
				BufferedReader themeFile = new BufferedReader(new FileReader("theme.csv"));
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
			
			String strImage = strTheme[0][1];
			InputStream imageclass = null;
	
			imageclass = this.getClass().getResourceAsStream(strImage);
			if(imageclass != null){
				try{
					imgtile = ImageIO.read(imageclass);
				}catch(IOException e){
					System.out.println("Unable to load image from jar");
				}
			}
			if(imgtile == null){
				try{
					imgtile = ImageIO.read(new File(strImage));
				}catch(IOException e){
					System.out.println("Unable to load images");
				}
			}
			
			strImage = strTheme[0][2];
			imageclass = null;
			
			imageclass = this.getClass().getResourceAsStream(strImage);
			if(imageclass != null){
				try{
					img2h = ImageIO.read(imageclass);
				}catch(IOException e){
					System.out.println("Unable to load image from jar");
				}
			}
			if(img2h == null){
				try{
					img2h = ImageIO.read(new File(strImage));
				}catch(IOException e){
					System.out.println("Unable to load images");
				}
			}
			
			strImage = strTheme[0][3];
			imageclass = null;
			
			imageclass = this.getClass().getResourceAsStream(strImage);
			if(imageclass != null){
				try{
					img2v = ImageIO.read(imageclass);
				}catch(IOException e){
					System.out.println("Unable to load image from jar");
				}
			}
			if(img2v == null){
				try{
					img2v = ImageIO.read(new File(strImage));
				}catch(IOException e){
					System.out.println("Unable to load images");
				}
			}
			
			strImage = strTheme[0][4];
			imageclass = null;
			
			imageclass = this.getClass().getResourceAsStream(strImage);
			if(imageclass != null){
				try{
					img3h = ImageIO.read(imageclass);
				}catch(IOException e){
					System.out.println("Unable to load image from jar");
				}
			}
			if(img3h == null){
				try{
					img3h = ImageIO.read(new File(strImage));
				}catch(IOException e){
					System.out.println("Unable to load images");
				}
			}

			strImage = strTheme[0][5];
			imageclass = null;
			
			imageclass = this.getClass().getResourceAsStream(strImage);
			if(imageclass != null){
				try{
					img3v = ImageIO.read(imageclass);
				}catch(IOException e){
					System.out.println("Unable to load image from jar");
				}
			}
			if(img3v == null){
				try{
					img3v = ImageIO.read(new File(strImage));
				}catch(IOException e){
					System.out.println("Unable to load images");
				}
			}

			strImage = strTheme[0][6];
			imageclass = null;
			
			imageclass = this.getClass().getResourceAsStream(strImage);
			if(imageclass != null){
				try{
					img4h = ImageIO.read(imageclass);
				}catch(IOException e){
					System.out.println("Unable to load image from jar");
				}
			}
			if(img4h == null){
				try{
					img4h = ImageIO.read(new File(strImage));
				}catch(IOException e){
					System.out.println("Unable to load images");
				}
			}

			strImage = strTheme[0][7];
			imageclass = null;
			
			imageclass = this.getClass().getResourceAsStream(strImage);
			if(imageclass != null){
				try{
					img4v = ImageIO.read(imageclass);
				}catch(IOException e){
					System.out.println("Unable to load image from jar");
				}
			}
			if(img4v == null){
				try{
					img4v = ImageIO.read(new File(strImage));
				}catch(IOException e){
					System.out.println("Unable to load images");
				}
			}

			strImage = strTheme[0][8];
			imageclass = null;
			
			imageclass = this.getClass().getResourceAsStream(strImage);
			if(imageclass != null){
				try{
					img5h = ImageIO.read(imageclass);
				}catch(IOException e){
					System.out.println("Unable to load image from jar");
				}
			}
			if(img5h == null){
				try{
					img5h = ImageIO.read(new File(strImage));
				}catch(IOException e){
					System.out.println("Unable to load images");
				}
			}

			strImage = strTheme[0][9];
			imageclass = null;
			
			imageclass = this.getClass().getResourceAsStream(strImage);
			if(imageclass != null){
				try{
					img5v = ImageIO.read(imageclass);
				}catch(IOException e){
					System.out.println("Unable to load image from jar");
				}
			}
			if(img5v == null){
				try{
					img5v = ImageIO.read(new File(strImage));
				}catch(IOException e){
					System.out.println("Unable to load images");
				}
			}
		}
		
		
		
		//LOADS MAP INTO 2D ARRAY
		String strMap[][];
		strMap = new String[10][10];
		String strLines = "";
		String strSplits[];
		int intMapCol = 0;
		int intMapRow = 0;
		int intCount1;
		int intCount2;
		int intCount3;
		int intCount4;
			
		
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
					//System.out.println(strMap[intCount1][intCount2]);
					g.drawImage(imgtile, intX + intCount2 *45, intY + intCount1 * 45, null);
				}
			}

		}
		for(intCount3 = 0; intCount3 < 10; intCount3++){
			for(intCount4 = 0; intCount4 <10; intCount4++){
				if(strMap[intCount3][intCount4].equals("w")){
					//System.out.println(strMap[intCount1][intCount2]);
					g.drawImage(imgtile, intX1 + intCount4 *45, intY1 + intCount3 * 45, null);
				}
			}
		}
		//g.drawImage(imgstars, 32,135,null);
		//g.drawImage(imgstars, 502,135,null);
		g.drawImage(img2h, 502, 135, null);
		g.drawImage(img3h, 502, 180, null);
		g.drawImage(img3h, 502, 225, null);
		g.drawImage(img4h, 502, 270, null);
		g.drawImage(img5h, 502, 315, null);
	}

	
		
	
	//constructor
	public apanel(){
		/* 
		InputStream imageclass = null;
		
		
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
		*/
	}
}
