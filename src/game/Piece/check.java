package game.Piece;
import decision_make.*;
import game.UI.*;
import game.location.*;

public class check {
    Decision_Making decision = new Decision_Making();
    Location location = new Location();

    public boolean Check(int x, int y){
        Boolean check = false;

        for(int i = 0; i < 8; i++){
            for(int j = 0; j < 8; j++){
                if(chess.chessboard[i][j] == chess.WhitePawn || chess.chessboard[i][j] == chess.BlackPawn){
                    if(PawnCheck(i, j)){
                        check = true;
                    }
                }
                else if(chess.chessboard[i][j] == chess.WhiteRook || chess.chessboard[i][j] == chess.BlackRook){
                    if(RookCheck(i, j)){
                        check = true;
                    }
                }
                else if(chess.chessboard[i][j] == chess.WhiteBishop || chess.chessboard[i][j] == chess.BlackBishop){
                    if(BishopCheck(i, j)){
                        check = true;
                    }
                }
                else if(chess.chessboard[i][j] == chess.WhiteQueen || chess.chessboard[i][j] == chess.WhiteQueen){
                    if(QueenCheck(i, j)){
                        check = true;
                    }
                }
            }
        }
        return check;
    }

    public boolean PawnCheck(int x, int y){
        if()
    }

    public boolean RookCheck(int x, int y){
        int xDiff = 0;
        int yDiff = 0;
        String Piece = location.LocationPiece(x, y);
        Boolean NextIsNull = true;
        for(int i = 0; i < 8; i++){
            for(int j = 0; j < 8; j++){
                xDiff = x - i;
                yDiff = 0;
                if(xDiff == 0 && yDiff != 0){

                    // 위로
                    if(now_y > next_y){
                        for(int i = 1; i <= now_y - next_y; i++){
                            if(location.LocationColor(now_x, next_y + i) == "Black"){
                                NextIsNull = false;
                            }
                        }
                    }
                    // 아래로
                    else if(now_y < next_y){
                        for(int i = 1; i <= next_y - now_y; i++){
                            if(location.LocationColor(now_x, now_y + i) == "Black"){
                                NextIsNull = false;
                            }
                        }
                    }
        
                    if(NextIsNull){
                        game.UI.chess.Swap(now_x, now_y, next_x, next_y, Piece);
                        return true;
                    }
                    else{
                        return false;
                    }
                }
                else if(yDiff == 0){
                    // 왼쪽으로
                    if(now_x > next_x){
                        for(int i = 1; i <= now_x - next_x; i++){
                            if(location.LocationColor(next_x + i, now_y) == "Black"){
                                NextIsNull = false;
                            }
                        }
                    }
                    // 오른쪽으로
                    else if(now_x < next_x){
                        for(int i = 1; i <= next_x - now_x; i++){
                            if(location.LocationColor(now_x + i, now_y) == "Black"){
                                NextIsNull = false;
                            }
                        }
                    }
        
                    if(NextIsNull){
                        game.UI.chess.Swap(now_x, now_y, next_x, next_y, Piece);
                        return true;
                    }
                    else{
                        return false;
                    }
                }
                else{
                    return false;
                }
            }
        }
    }

    public boolean KnightCheck(int x, int y){

    }

    public boolean BishopCheck(int x, int y){

    }

    public boolean QueenCheck(int x, int y){

    }
}
