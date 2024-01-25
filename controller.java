import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class controller {

    // Snaps the x-coordinate of the Mouse to the grid
    public static int snapToX(int intMousex){
        int intMouse;
        intMouse = (intMousex - 32) % 45;
        intMousex = intMousex - intMouse;
        return intMousex;
    }

    // Snaps the y-coordinate of the Mouse to the grid
    public static int snapToY(int intMousey){
        int intMouse;
        intMouse = (intMousey - 135) % 45;
        intMousey = intMousey - intMouse;
        return intMousey;
    }

    // Ensures the left side of the boat does not exceed the left side of the map
    public static int boundxleft(int intMousex){
        if(intMousex < 32){
            intMousex = 32;
        }
        return intMousex;
    }

    // Ensures the top of the boat does not exceed the top of the map
    public static int boundytop(int intMousey){
        if(intMousey < 135){
            intMousey = 135;
        }
        return intMousey;
    }

    // Ensures the right side of the boat does not exceed the right side of the map
    public static int boundxright(int intPieceX2){
        if(intPieceX2 > 482){
            intPieceX2 = 482;
        }
        return intPieceX2;
    }

    // Ensures the bottom of the boat does not exceed the bottom of the map
    public static int boundybottom(int intPieceY2){
        if(intPieceY2 > 585){
            intPieceY2 = 585;
        }
        return intPieceY2;
    }

    //Takes the coordinates of the boats, either erases its current position from the array or adds its current position in the array
    //and then rewrites the map.csv file with the updated map
    public static String[][] updateMap(String[][] mapfile, int intx1, int inty1, boolean blnrotated, int intlength, boolean blnErase){
        intx1 = (intx1 - 32) / 45;
        inty1 = (inty1 - 135) / 45;
        intlength -= 1;
        while(intlength >= 0 && blnrotated == false && blnErase == false){
            mapfile[inty1][intx1 + intlength] = "s";
            intlength -= 1;
        }

        while(intlength >= 0 && blnrotated == true && blnErase == false){
            mapfile[inty1 + intlength][intx1] = "s";
            intlength -= 1;
        }

        while(intlength >= 0 && blnrotated == false && blnErase == true){
            mapfile[inty1][intx1 + intlength] = "w";
            intlength -= 1;
        }

        while(intlength >= 0 && blnrotated == true && blnErase == true){
            mapfile[inty1 + intlength][intx1] = "w";
            intlength -= 1; 
        }

        try{
            PrintWriter mapcsv = new PrintWriter(new FileWriter("map.csv", false));
            for (int i = 0; i < 10; i++) {
                for (int j = 0; j < 10; j++) {
                    if(j>8){
                    //System.out.print(mapfile[i][j]);
                        mapcsv.print(mapfile[i][j]);
                    }else{
                        mapcsv.print(mapfile[i][j] + ",");
                    }
                }
                //System.out.println();
                mapcsv.println();
            }
            mapcsv.close();
        }catch(IOException e){

        }catch(ArrayIndexOutOfBoundsException e){

        }
        System.out.println();
        return mapfile;
    }

    //Resets the location of the boats on the map
    public static String[][] reloadMap(String[][] strMap){
        int intCount1;
        int intCount2;

        for(intCount1 = 0; intCount1 < 10; intCount1++){
			for(intCount2 = 0; intCount2 <10; intCount2++){
				strMap[intCount1][intCount2] = "w";		
			}
		}
        strMap[0][0] = "s";
        strMap[0][1] = "s";
        strMap[1][0] = "s";
        strMap[1][1] = "s";
        strMap[1][2] = "s";
        strMap[2][0] = "s";
        strMap[2][1] = "s";
        strMap[2][2] = "s";
        strMap[3][0] = "s";
        strMap[3][1] = "s";
        strMap[3][2] = "s";
        strMap[3][3] = "s";
        strMap[4][0] = "s";
        strMap[4][1] = "s";
        strMap[4][2] = "s";
        strMap[4][3] = "s";
        strMap[4][4] = "s";

        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                System.out.println(strMap[i][j] + " ");
            }
            System.out.println();
        }
        try{
            PrintWriter mapcsv = new PrintWriter(new FileWriter("map.csv", false));
            for (int i = 0; i < 10; i++) {
                for (int j = 0; j < 10; j++) {
                    if(j>8){
                        mapcsv.print(strMap[i][j]);
                    }else{
                        mapcsv.print(strMap[i][j] + ",");
                    }
                }
                mapcsv.println();
            }
            mapcsv.close();
        }catch(IOException e){

        }catch(ArrayIndexOutOfBoundsException e){

        }
        System.out.println();
        return strMap;
    }

    // Checks if boats will overlap when moved or rotated
    // Whole thing is hypothetical in the sense that IF the boat was to be moved to these new coordinates, would there be any issues
    public static boolean checkOverlap(String[][] mapfile, int intx1, int inty1, int intlength, boolean blnrotated){
        intx1 = ((intx1 - (intx1 % 45)) / 45);
        inty1 = ((inty1 - (inty1 % 45) - 135) / 45);

        System.out.println(intx1 + " " + inty1);

        intlength -= 1;

        System.out.println("inty:" +inty1);
        System.out.println("intx:"+intx1);
        System.out.println("length"+intlength);
       
        try{
            // checks if there is anything the boat will overlap with when horizontal throughout its entire length
            while(intlength >= 0 && !mapfile[inty1][intx1].equals("s") && !mapfile[inty1][intx1 + intlength].equals("s") && blnrotated == false){
                System.out.println("change");
                intlength -= 1;
            }

            // checks if there is anything the boat will overlap with when its vertical throughout its entire length
            while(intlength >= 0 && !mapfile[inty1 + intlength][intx1].equals("s") && !mapfile[inty1][intx1].equals("s") && blnrotated == true){
                System.out.println("HI");
                intlength -= 1;
            }
        }catch(ArrayIndexOutOfBoundsException e){
            int intnew = inty1 + intlength;
            System.out.println("inty1 + intlength :"+ intnew);
            System.out.println("intx1:" + intx1);
            System.out.println("Array");
        }catch(NullPointerException e){
            System.out.println("idk this exception");
        }

        System.out.println(intlength);
        if(intlength <= 0){
            return false;
        }else{
            return true;
        }
    }

    // checks if the opponent's attack will hit any of the player's boats
    public static int hitmiss(String[][] mapfile, int intRow, int intCol){
        if(mapfile[intRow][intCol].equals("s")){
            //boat was hit
            return 1;
        }else{
            //boats were missed
            return 2;
        }
    }

    //resets the dotmap to normal
    public static String[][] startDotMaps(String[][] strDotMap){
        int intCount1;
        int intCount2;

        for(intCount1 = 0; intCount1 < 10; intCount1++){
			for(intCount2 = 0; intCount2 <10; intCount2++){
				strDotMap[intCount1][intCount2] = "n";	
			}
		}
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                if(j>8){
                    System.out.print(strDotMap[i][j]);
                }else{
                  System.out.print(strDotMap[i][j] + ",");
                }
            }
            System.out.println();
        }
        return strDotMap;
    }

    //updates any dot map with the location of the dot and whether or not it was a hit or miss
    public static String[][] updateDotMaps(String[][] strDotMap, boolean blnHitMiss, int intRow, int intCol){
        if(blnHitMiss == true){
            strDotMap[intRow][intCol] = "h";
        }else{
            strDotMap[intRow][intCol] = "m";
        }
        return strDotMap;
    }

    //checks if all the boats have been hit on the dot map
    public static boolean checkGameOver(String[][] strDotMap){
        int intBoatsHit = 0;
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                if(strDotMap[i][j].equals("h")){
                    intBoatsHit += 1;
                }
            }
        }

        if(intBoatsHit == 17){
            return true;
        }else{
            return false;
        }
        
    }
}
