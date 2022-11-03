package game.UI;
import java.io.*;
import java.util.StringTokenizer;

public class pieceMovingUI {
    public void DrawMovingUI(int mode) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        if(mode == 1)
        {
            StringBuffer moving = new StringBuffer();

            moving.append("WHITE TURN!\n");
            moving.append("움직일 말의 위치를 입력하세요");
            System.out.println(moving);
            System.out.print("> ");
            StringTokenizer st_now = new StringTokenizer(br.readLine(), " ");
            char now_y = st_now.nextToken().charAt(0);
            char now_x = st_now.nextToken().charAt(0);
            System.out.println("말을 옮길 위치를 입력하세요");
            System.out.print("> ");
            StringTokenizer st_next = new StringTokenizer(br.readLine(), " ");
            char next_y = st_next.nextToken().charAt(0);
            char next_x = st_next.nextToken().charAt(0);
                  
        }
    }

}
