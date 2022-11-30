package game.Piece;
import javax.lang.model.util.ElementScanner14;

import game.UI.chess;
import game.location.Location;

public class KingPiece {
    Location location = new Location();
    RookPiece rookPiece = new RookPiece();
    check check = new check();
    Boolean firstMove = true;
    
    public boolean WhiteKingMove(int now_x, int now_y, int next_x, int next_y){
        String BeforePiece = location.LocationPiece(next_x, next_y);
        boolean swap = true;
        if(location.LocationIsNull(next_x, next_y)){

            //캐슬링
            if(firstMove == true && rookPiece.firstMove == true && Math.abs(next_x - now_x) == 2)
            {
                System.out.println("castling!");
                if((next_x - now_x) > 0 && location.LocationIsNull(now_x + 1, now_y))
                {
                    System.out.println("kingside!");
                    chess.Swap(next_x, next_y, now_x, now_y, chess.WhiteKing);
                    chess.Swap(now_x, now_y, now_x - 2, now_y, chess.WhiteRook);
                    chess.chessboard[next_y][next_x] = BeforePiece;
                    return false;
                }
                else if((next_x - now_x) < 0 && location.LocationIsNull(now_x - 1, now_y) && location.LocationIsNull(now_x - 3, now_y))
                {
                    System.out.println("queenside!");
                    chess.Swap(next_x, next_y, now_x, now_y, chess.WhiteKing);
                    chess.Swap(now_x, now_y, now_x + 3, now_y, chess.WhiteRook);
                    chess.chessboard[next_y][next_x] = BeforePiece;
                    return false;
                }
                else
                {
                    return false;
                }
            }

            //행마하기
            if(Math.abs(now_x - next_x) == 1 && now_y == next_y){ // 좌우
                firstMove = false;
                chess.Swap(now_x, now_y, next_x, next_y, chess.WhiteKing);
                if(check.Check("White") == "White"){
                    chess.Swap(next_x, next_y, now_x, now_y, chess.WhiteKing);
                    chess.chessboard[next_y][next_x] = BeforePiece;
                    return false;
                }
            }
            else if(Math.abs(now_y - next_y) == 1 && now_x == next_x){ //상하
                firstMove = false;
                chess.Swap(now_x, now_y, next_x, next_y, chess.WhiteKing);
                if(check.Check("White") == "White"){
                    chess.Swap(next_x, next_y, now_x, now_y, chess.WhiteKing);
                    chess.chessboard[next_y][next_x] = BeforePiece;
                    return false;
                }
            }
            else if(Math.abs(now_x - next_x) == 1 && Math.abs(now_y - next_y) == 1){ //대각선
                firstMove = false;
                chess.Swap(now_x, now_y, next_x, next_y, chess.WhiteKing);
                if(check.Check("White") == "White"){
                    chess.Swap(next_x, next_y, now_x, now_y, chess.WhiteKing);
                    chess.chessboard[next_y][next_x] = BeforePiece;
                    return false;
                }
            }
            else{
                swap = false;
            }
        }
        else{
            swap = false;
        }
        return swap;
    }
    
    public boolean BlackKingMove(int now_x, int now_y, int next_x, int next_y){
        String BeforePiece = location.LocationPiece(next_x, next_y);
        boolean swap = true;
        if(location.LocationIsNull(next_x, next_y)){
            if(Math.abs(now_x - next_x) == 1 && now_y == next_y){ // 좌우
                chess.Swap(now_x, now_y, next_x, next_y, chess.BlackKing);
                if(check.Check("Black") == "Black"){
                    chess.Swap(next_x, next_y, now_x, now_y, chess.BlackKing);
                    chess.chessboard[next_y][next_x] = BeforePiece;
                    return false;
                }
            }
            else if(Math.abs(now_y - next_y) == 1 && now_x == next_x){ //상하
                chess.Swap(now_x, now_y, next_x, next_y, chess.BlackKing);
                if(check.Check("Black") == "Black"){
                    chess.Swap(next_x, next_y, now_x, now_y, chess.BlackKing);
                    chess.chessboard[next_y][next_x] = BeforePiece;
                    return false;
                }
            }
            else if(Math.abs(now_x - next_x) == 1 && Math.abs(now_y - next_y) == 1){ //대각선
                chess.Swap(now_x, now_y, next_x, next_y, chess.BlackKing);
                if(check.Check("Black") == "Black"){
                    chess.Swap(next_x, next_y, now_x, now_y, chess.BlackKing);
                    chess.chessboard[next_y][next_x] = BeforePiece;
                    return false;
                }
            }
            else{
                swap = false;
            }
        }
        else{
            swap = false;
        }
        return swap;
    }
}
