package game.UI;
import java.io.*;
import java.util.StringTokenizer;
import game.location.Location;


public class pieceMovingUI {
    int turn = 0;
    Location location = new Location();
    public void DrawMovingUI(int mode) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        //PVP
        if(mode == 1)
        {
            while(turn < 100)
            {
                if(turn % 2 == 0)
                {
                    System.out.println("WHITE TURN!\n");
                    System.out.println("=============================================\n");
                    System.out.println("움직일 말의 위치를 입력하세요");
                    System.out.print("> ");
                    StringTokenizer st_now = new StringTokenizer(br.readLine(), " ");
                    char white_now_y = st_now.nextToken().charAt(0);
                    char white_now_x = st_now.nextToken().charAt(0);
                    System.out.println("말을 옮길 위치를 입력하세요");
                    System.out.print("> ");
                    StringTokenizer st_next = new StringTokenizer(br.readLine(), " ");
                    char white_next_y = st_next.nextToken().charAt(0);
                    char white_next_x = st_next.nextToken().charAt(0); 
                    //location.NowLocationIsNull(white_now_x, white_now_y);
                    turn++;
                }
                else if(turn % 2 != 0)
                {
                    System.out.println("BLACK TURN!\n");
                    System.out.println("움직일 말의 위치를 입력하세요");
                    System.out.print("> ");
                    StringTokenizer st_now = new StringTokenizer(br.readLine(), " ");
                    char black_now_y = st_now.nextToken().charAt(0);
                    char black_now_x = st_now.nextToken().charAt(0);
                    System.out.println("말을 옮길 위치를 입력하세요");
                    System.out.print("> ");
                    StringTokenizer st_next = new StringTokenizer(br.readLine(), " ");
                    char black_next_y = st_next.nextToken().charAt(0);
                    char black_next_x = st_next.nextToken().charAt(0);
                    turn++;
                }
            }                  
        }
        else if(mode == 2)
        {

        }
        else if(mode == 3)
        {

        }
    }

    public void BattleUI()
    {
        StringBuffer battle = new StringBuffer();
        battle.append("=============================================\n");
        battle.append("================= 메뉴 선택 ==================\n");
        battle.append("1. 계속하기\n");
        battle.append("2. 기권하기\n");
        battle.append("=============================================");
        System.out.println(battle);
    }

}
