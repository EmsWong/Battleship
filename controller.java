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
        while(intlength >= intx1 && blnrotated == false){
            mapfile[intx1 + intlength][inty1] = "s";
            intlength -= 1;
        }

        while(intlength >= intx1 && blnrotated == true){
            mapfile[intx1][inty1 + intlength] = "s";
            intlength -= 1;
        }

        return mapfile;
    }
}
