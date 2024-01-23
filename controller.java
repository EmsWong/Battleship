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
    public static String[][] updateMap(String[][] mapfile, int intx1, int inty1, boolean blnrotated, int intlength){
        intx1 = (intx1 - 32) / 45;
        inty1 = (inty1 - 135) / 45;
        intlength -= 1;
        while(intlength >= 0 && blnrotated == false){
            System.out.println(intx1);
            System.out.println(inty1);
            System.out.println(intlength);
            mapfile[inty1][intx1 + intlength] = "s";
            intlength -= 1;
        }

        while(intlength >= 0 && blnrotated == true){
            mapfile[inty1 + intlength][intx1] = "s";
            intlength -= 1;
        }

        try{
            PrintWriter mapcsv = new PrintWriter(new FileWriter("map.csv", true));
            for (int i = 0; i < 10; i++) {
                for (int j = 0; j < 10; j++) {
                    if(j > 8){
                        System.out.print(mapfile[i][j]);
                    }else{
                        System.out.print(mapfile[i][j] + ",");
                    }
                }
                System.out.println();
            }
            mapcsv.close();
        }catch(IOException e){

        }catch(ArrayIndexOutOfBoundsException e){

        }

        return mapfile;
    }
}
