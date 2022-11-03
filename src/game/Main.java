package game;
import game.UI.uiDrawing;

public class Main {
    public static void main(String[] args) {  
        uiDrawing gameStart = new uiDrawing();
        int mode = gameStart.DrawUi();
        System.out.println(mode);


    }
}