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
}
