package game.UI;
import java.util.Scanner;

public class uiDrawing {
    public int DrawUi()
    {
        BoardDrawing newchess = new BoardDrawing();
        Scanner sc = new Scanner(System.in);
        int gameMode;

        StringBuffer systemUI = new StringBuffer();
        systemUI.append("=============================================\n");
        //심심해서 넣은 로고
        systemUI.append("     ▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄\n");
        systemUI.append("     █░░░░░░░░▀█▄▀▄▀██████░▀█▄▀▄▀██████░\n");
        systemUI.append("     ░░░░░░░░░░░▀█▄█▄███▀░░░ ▀██▄█▄███▀░\n");
        systemUI.append("=============================================\n");
        systemUI.append("                 ─ Game Mode ─\n");
        systemUI.append("                    1. PVP\n");
        systemUI.append("                    2. PVE\n");
        systemUI.append("                    3. EVE\n");
        systemUI.append("=============================================");
        System.out.println(systemUI);

        System.out.println("게임 모드를 선택하세요");
        System.out.print("> ");
        gameMode = sc.nextInt();
        System.out.println("\n");

        switch(gameMode)
        {
            case 1:
                System.out.println("PVP 모드로 선택하셨습니다.");
                newchess.DrawChessBoard();

                break;
            case 2:
                //System.out.println("pve");

                break;
            case 3:
                System.out.println("eve");
                break;
            case 4:
                
            default:
                System.out.println("다시 입력해주세요\n");
                DrawUi();
                break;
            
        
        }
        return gameMode;


    }
}
