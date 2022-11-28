package game.Piece;
import game.UI.*;
import game.location.*;

public class check {
    Location location = new Location();

    static String Null = "N";
    static String CanMove = "O";
    static String CantMove = "X";

    static String[][] white_checkboard = // 화이트의 움직일 수 있는 경로
    {
        {Null, Null, Null, Null, Null, Null, Null, Null},
        {Null, Null, Null, Null, Null, Null, Null, Null},
        {Null, Null, Null, Null, Null, Null, Null, Null},
        {Null, Null, Null, Null, Null, Null, Null, Null},
        {Null, Null, Null, Null, Null, Null, Null, Null},
        {Null, Null, Null, Null, Null, Null, Null, Null},
        {Null, Null, Null, Null, Null, Null, Null, Null},
        {Null, Null, Null, Null, Null, Null, Null, Null}
    };
    static String[][] black_checkboard = // 블랙의 움직일 수 있는 경로
    {
        {Null, Null, Null, Null, Null, Null, Null, Null},
        {Null, Null, Null, Null, Null, Null, Null, Null},
        {Null, Null, Null, Null, Null, Null, Null, Null},
        {Null, Null, Null, Null, Null, Null, Null, Null},
        {Null, Null, Null, Null, Null, Null, Null, Null},
        {Null, Null, Null, Null, Null, Null, Null, Null},
        {Null, Null, Null, Null, Null, Null, Null, Null},
        {Null, Null, Null, Null, Null, Null, Null, Null}
    };

    public String Check(String Color){ // 체크 여부를 판단하는 메서드, Color = 움직일 말의 색깔
        CheckBoard();
        String check = "None"; // 체크가 된 색깔 -> 다음 턴에 잡힐 색깔
        for(int y = 0; y < 8; y++){
            for(int x = 0; x < 8; x++){
                if(Color == "White"){ // 움직일 말의 색깔이 화이트라면
                    if(chess.chessboard[y][x] == chess.BlackKing && white_checkboard[y][x] == CanMove){ // 상대 말을 잡을 수 있다면
                        check = "Black"; // 블랙이 체크가 됨
                    }
                    else if(chess.chessboard[y][x] == chess.WhiteKing && black_checkboard[y][x] == CanMove){ // 화이트가 놓은 말이 자충수라면
                        check = "White"; // 화이트가 체크가 됨
                    }
                }
                else if(Color == "Black"){
                    if(chess.chessboard[y][x] == chess.WhiteKing && black_checkboard[y][x] == CanMove){ // 상대 말을 잡을 수 있다면
                        check = "White"; // 블랙이 체크가 됨
                    }
                    else if(chess.chessboard[y][x] == chess.BlackKing && white_checkboard[y][x] == CanMove){ // 블랙이 놓은 말이 자충수라면
                        check = "Black"; // 화이트가 체크가 됨
                    }
                }
            }
        }
        return check;
    }

    public void CheckBoard(){ // 모든 기물의 이동 경로를 파악해 2차원 배열에 저장하는 메서드
        for(int y = 0; y < 8; y++){
            for(int x = 0; x < 8; x++){
                PawnCheck(x, y);
                RookCheck(x, y);
                KnightCheck(x, y);
                BishopCheck(x, y);
                QueenCheck(x, y);
            }
        }
        PrintBoard();
    }

    public void PrintBoard(){
        for(int y = 0; y < 8; y++){
            for(int x = 0; x < 8; x++){
                System.out.print(white_checkboard[y][x]);
            }
            System.out.println("");
        }
        System.out.println("================");
        for(int y = 0; y < 8; y++){
            for(int x = 0; x < 8; x++){
                System.out.print(black_checkboard[y][x]);
            }
            System.out.println("");
        }
    }

    public void PawnCheck(int x, int y){ // 잡을 수 있는 경로만 확인함
        if(chess.chessboard[y][x] == chess.WhitePawn){
            if(x - 1 >= 0 && y - 1 >= 0){
                white_checkboard[y-1][x-1] = CanMove;
            }
            if(x + 1 <= 7 && y - 1 >= 0){
                white_checkboard[y-1][x+1] = CanMove;
            }
        }
        else if(chess.chessboard[y][x] == chess.BlackPawn){
            if(x - 1 >= 0 && y + 1 <= 7){
                black_checkboard[y+1][x-1] = CanMove;
            }
            if(x + 1 <= 7 && y + 1 <= 7){
                black_checkboard[y+1][x+1] = CanMove;
            }
        }
    }

    public void RookCheck(int x, int y){
        String Color = location.LocationColor(x, y);
        if(chess.chessboard[y][x] == chess.WhiteRook || chess.chessboard[y][x] == chess.BlackRook){
            for(int i = x + 1; i < 8; i++){ // 오른쪽으로
                if(!location.LocationIsNull(x, y)){
                    break;
                }
                else if(Color == "White"){
                    white_checkboard[y][x] = CanMove;
                }
                else if(Color == "Black"){
                    black_checkboard[y][x] = CanMove;
                }
            }
            for(int i = x - 1; i >= 0 ; i--){ // 왼쪽으로
                if(!location.LocationIsNull(x, y)){
                    break;
                }
                else if(Color == "White"){
                    white_checkboard[y][x] = CanMove;
                }
                else if(Color == "Black"){
                    black_checkboard[y][x] = CanMove;
                }
            }
            for(int i = y - 1; i >= 0 ; i--){ // 위으로
                if(!location.LocationIsNull(x, y)){
                    break;
                }
                else if(Color == "White"){
                    white_checkboard[y][x] = CanMove;
                }
                else if(Color == "Black"){
                    black_checkboard[y][x] = CanMove;
                }
            }
            for(int i = y + 1; i < 8 ; i++){ // 아래로
                if(!location.LocationIsNull(x, y)){
                    break;
                }
                else if(Color == "White"){
                    white_checkboard[y][x] = CanMove;
                }
                else if(Color == "Black"){
                    black_checkboard[y][x] = CanMove;
                }
            }
        }
    }

    public void KnightCheck(int x, int y){

    }

    public void BishopCheck(int x, int y){

    }

    public void QueenCheck(int x, int y){

    }
}
