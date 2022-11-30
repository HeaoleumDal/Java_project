package game.UI;
import java.io.*;
import java.util.Scanner;
import java.util.StringTokenizer;
//import javax.lang.model.util.ElementScanner14;

import game.Piece.PieceMoving;

public class pieceMovingUI {
    int turn = 0;
    BoardDrawing boardDrawing = new BoardDrawing();
    PieceMoving piecemoving = new PieceMoving();
    Scanner scanner = new Scanner(System.in);


    //체스 이동 입력 체크하기
    public boolean CheckTokenizer(char x, char y)
    {
        if((x >= 65 && x <= 72) || (y >= 1 && y <= 8))
        {
            return true;
        }
        return false;
    }


    public void DrawMovingUI(int mode) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        //PVP
        if(mode == 1)
        {
            while(true)
            {
                if(turn % 2 == 0)
                {
                    System.out.println("WHITE TURN!\n");
                    System.out.println("=============================================");
                    System.out.println("움직일 말의 위치를 입력하세요");
                    System.out.print("> ");
                    StringTokenizer st_now = new StringTokenizer(br.readLine(), " ");
                    char white_now_x = st_now.nextToken().charAt(0);
                    char white_now_y = st_now.nextToken().charAt(0);
                    //지금 위치 입력
                    if(CheckTokenizer(white_now_x, white_now_y) == true)
                    {
                        System.out.println("말을 옮길 위치를 입력하세요");
                        System.out.print("> ");
                        StringTokenizer st_next = new StringTokenizer(br.readLine(), " ");
                        char white_next_x = st_next.nextToken().charAt(0); 
                        char white_next_y = st_next.nextToken().charAt(0);
                        //옮길 위치 입력
                        if(CheckTokenizer(white_next_x, white_next_y) == true)
                        {
                            //옮기는 조건이 안되는 경우
                            if(!piecemoving.PieceMove(white_now_x, white_now_y, white_next_x, white_next_y, "White"))
                            {
                                System.out.println("\n말을 옮길 수 없습니다. 다시 입력해주세요\n");
                                DrawMovingUI(1);
                            }
                            //옮기기 성공!
                            else
                            {
                                boardDrawing.DrawChessBoard();
                                turn++;  
                            }
                        }
                        else if(CheckTokenizer(white_next_x, white_next_y) == false)
                        {
                            System.out.println("\n좌표 값이 없습니다. 다시 입력해주세요\n");
                            DrawMovingUI(1);
                        }
                    }
                    else if(CheckTokenizer(white_now_x, white_now_y) == false)
                    {
                        System.out.println("\n좌표 값이 없습니다. 다시 입력해주세요\n");
                        DrawMovingUI(1);
                    }
                    
                }
                else if(turn % 2 != 0)
                {
                    System.out.println("BLACK TURN!\n");
                    System.out.println("=============================================");
                    System.out.println("움직일 말의 위치를 입력하세요");
                    System.out.print("> ");
                    StringTokenizer st_now = new StringTokenizer(br.readLine(), " ");
                    char black_now_x = st_now.nextToken().charAt(0);
                    char black_now_y = st_now.nextToken().charAt(0);
                    //지금 위치 입력
                    if(CheckTokenizer(black_now_x, black_now_y) == true)
                    {
                        System.out.println("말을 옮길 위치를 입력하세요");
                        System.out.print("> ");
                        StringTokenizer st_next = new StringTokenizer(br.readLine(), " ");
                        char black_next_x = st_next.nextToken().charAt(0); 
                        char black_next_y = st_next.nextToken().charAt(0);
                        //옮길 위치 입력
                        if(CheckTokenizer(black_next_x, black_next_y) == true)
                        {
                            //옮기는 조건이 안되는 경우
                            if(!piecemoving.PieceMove(black_now_x, black_now_y, black_next_x, black_next_y, "Black"))
                            {
                                System.out.println("\n말을 옮길 수 없습니다. 다시 입력해주세요\n");
                                DrawMovingUI(1);
                            }
                            //옮기기 성공!
                            else
                            {
                                boardDrawing.DrawChessBoard();
                                turn++;  
                            }
                        }
                        else if(CheckTokenizer(black_next_x, black_next_y) == false)
                        {
                            System.out.println("\n좌표 값이 없습니다. 다시 입력해주세요\n");
                            DrawMovingUI(1);
                        }
                    }
                    else if(CheckTokenizer(black_now_x, black_now_y) == false)
                    {
                        System.out.println("\n좌표 값이 없습니다. 다시 입력해주세요\n");
                        DrawMovingUI(1);
                    }
                    
                }
            }                  
        }
        else if(mode == 2)
        {
            while(true)
            {
                if(turn % 2 == 0)
                {
                    System.out.println("Player TURN!\n");
                    System.out.println("=============================================");
                    System.out.println("움직일 말의 위치를 입력하세요");
                    System.out.print("> ");
                    StringTokenizer st_now = new StringTokenizer(br.readLine(), " ");
                    char player_now_x = st_now.nextToken().charAt(0);
                    char player_now_y = st_now.nextToken().charAt(0);
                    //지금 위치 입력
                    if(CheckTokenizer(player_now_x, player_now_y) == true)
                    {
                        System.out.println("말을 옮길 위치를 입력하세요");
                        System.out.print("> ");
                        StringTokenizer st_next = new StringTokenizer(br.readLine(), " ");
                        char player_next_x = st_next.nextToken().charAt(0); 
                        char player_next_y = st_next.nextToken().charAt(0);
                        //옮길 위치 입력
                        if(CheckTokenizer(player_next_x, player_next_y) == true)
                        {
                            //옮기는 조건이 안되는 경우
                            if(!piecemoving.PieceMove(player_now_x, player_now_y, player_next_x, player_next_y, "White"))
                            {
                                System.out.println("\n말을 옮길 수 없습니다. 다시 입력해주세요\n");
                                DrawMovingUI(1);
                            }
                            //옮기기 성공!
                            else
                            {
                                boardDrawing.DrawChessBoard();
                                turn++;  
                            }
                        }
                        else if(CheckTokenizer(player_next_x, player_next_y) == false)
                        {
                            System.out.println("\n좌표 값이 없습니다. 다시 입력해주세요\n");
                            DrawMovingUI(1);
                        }
                    }
                    else if(CheckTokenizer(player_now_x, player_now_y) == false)
                    {
                        System.out.println("\n좌표 값이 없습니다. 다시 입력해주세요\n");
                        DrawMovingUI(1);
                    }
                    
                }
                else if(turn % 2 != 0)
                {
                    //ai turn
                }
            }
        }
        else if(mode == 3)
        {

        }
    }
}
