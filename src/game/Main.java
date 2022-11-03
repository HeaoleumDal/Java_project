package game;
import game.UI.uiDrawing;
import game.UI.chess;
import game.UI.pieceMovingUI;

public class Main {
    public static void main(String[] args) {  
        uiDrawing gameStart = new uiDrawing();
        pieceMovingUI pieceMovingUI = new pieceMovingUI();
        //chess chess = new chess();
        int mode = gameStart.DrawUi();
        try {
            pieceMovingUI.DrawMovingUI(mode);
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        //System.out.println(mode);
        //chess.Print();




    }
}