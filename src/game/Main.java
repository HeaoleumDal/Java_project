package game;
import game.UI.uiDrawing;
import game.UI.pieceMovingUI;

public class Main {
    public static void main(String[] args) {  
        uiDrawing gameStart = new uiDrawing();
        pieceMovingUI pieceMovingUI = new pieceMovingUI();
        int mode = gameStart.DrawUi();
        try {
            pieceMovingUI.DrawMovingUI(mode);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}