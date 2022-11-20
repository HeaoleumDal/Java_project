package game.UI;
import java.io.*;
import java.util.Scanner;
import java.util.StringTokenizer;
import game.UI.BoardDrawing;
import game.Piece.PieceMoving;

public class pieceMovingUI {
    int turn = 0;
    BoardDrawing boardDrawing = new BoardDrawing();
    PieceMoving piecemoving = new PieceMoving();
    Scanner scanner = new Scanner(System.in);

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
                    if(BattleUI() == 2){
                        break;
                    }
                    System.out.println("=============================================");
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
                    piecemoving.PieceMove(white_now_x, white_now_y, white_next_x, white_next_y, "White");
                    boardDrawing.DrawChessBoard();
                    turn++;
                }
                else if(turn % 2 != 0)
                {
                    System.out.println("BLACK TURN!\n");
                    if(BattleUI() == 2){
                        break;
                    }
                    System.out.println("=============================================");
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
                    piecemoving.PieceMove(black_now_x, black_now_y, black_next_x, black_next_y, "Black");
                    boardDrawing.DrawChessBoard();
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

    public int BattleUI()
    {
        System.out.println("================= 메뉴 선택 =================");
        System.out.println("1. 계속 하기");
        System.out.println("2. 기권 하기");
        System.out.println("=============================================\n");
        System.out.print("> ");
        int menu = scanner.nextInt();
        return menu;
    }

}
