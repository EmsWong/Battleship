import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class controller {
    public static int snapToX(int intMousex){
        int intMouse = 0;
        if(intMousex % 45 < 23){
            intMousex = intMousex - (intMousex % 45) + 32;
        }
        else{
            intMousex = intMousex - (intMousex % 45) + 32;
        }
        intMouse = intMousex;
        return intMouse;
    }
    public static int snapToY(int intMousey){
        int intMouse = 0;
        if(intMousey % 45 < 23){
            intMousey = intMousey - (intMousey % 45) ;
        }
        else{
            intMousey = intMousey - (intMousey % 45) + 45;
        }
        intMouse = intMousey;
        return intMouse;
    }
    public static int boundxleft(int intMousex){
        if(intMousex < 32){
            intMousex = 32;
        }
        return intMousex;
    }
    public static int boundytop(int intMousey){
        if(intMousey < 135){
            intMousey = 135;
        }
        return intMousey;
    }
    public static int boundxright(int intPieceX2){
        if(intPieceX2 > 482){
            intPieceX2 = 482;
        }
        return intPieceX2;
    }
    public static int boundybottom(int intPieceY2){
        if(intPieceY2 > 585){
            intPieceY2 = 585;
        }
        return intPieceY2;
    }
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

    //for play again if needed
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

        return strMap;
    }

    public static boolean checkOverlap(String[][] mapfile, int intx1, int inty1, int intlength, boolean blnrotated){
        intx1 = ((intx1 - (intx1 % 45)) / 45);
        inty1 = ((inty1 - (inty1 % 45) - 135) / 45);

        System.out.println(intx1 + " " + inty1);

        intlength -= 1;

        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                if(j>8){
                    //System.out.print(mapfile[i][j]);
                }else{
                  //System.out.print(mapfile[i][j] + ",");
                }
            }
            //System.out.println();
        }

        System.out.println("inty:" +inty1);
        System.out.println("intx:"+intx1);
        System.out.println("length"+intlength);
        System.out.println(mapfile[9][7]);
       
        try{
            while(intlength >= 0 && !mapfile[inty1][intx1].equals("s") && !mapfile[inty1][intx1 + intlength].equals("s") && blnrotated == false){
                System.out.println("change");
                intlength -= 1;
            }

            while(intlength >= 0 && !mapfile[inty1 + intlength][intx1].equals("s") && !mapfile[inty1][intx1].equals("s") && blnrotated == true){
                System.out.println("HI");
                intlength -= 1;
            }
        }catch(ArrayIndexOutOfBoundsException e){
            int intnew = inty1 + intlength;
            System.out.println("inty1 + intlength :"+ intnew);
            System.out.println("intx1:" + intx1);
            System.out.println("Array");
        }

        System.out.println(intlength);
        if(intlength <= 0){
            return false;
        }else{
            return true;
        }
    }

    public static int hitmiss(String[][] mapfile, int intRow, int intCol){
        if(mapfile[intRow][intCol].equals("s")){
            return 1;
        }else{
            return 2;
        }
    }
}
