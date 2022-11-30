package game.Piece;
import game.UI.chess;
import game.location.Location;

public class RookPiece 
{
    check check = new check();
    Location location = new Location();

    public boolean WhiteRookMove(int now_x, int now_y, int next_x, int next_y) 
    {
        String BeforePiece = location.LocationPiece(next_x, next_y);
        String Piece = location.LocationPiece(now_x, now_y);
        Boolean NextIsNull = true;
        int xDiff = now_x - next_x;
        int yDiff = now_y - next_y;
    
        //행마하기
        if(xDiff == 0 && yDiff != 0){
            // 위로
            if(now_y > next_y){
                for(int i = 1; i <= now_y - next_y; i++){
                    if(location.LocationColor(now_x, now_y - i) == "White"){
                        NextIsNull = false;
                    }
                }
            }
            // 아래로
            else if(now_y < next_y){
                for(int i = 1; i <= next_y - now_y; i++){
                    if(location.LocationColor(now_x, now_y + i) == "White"){
                        NextIsNull = false;
                    }
                }
            }

            if(NextIsNull){
                chess.Swap(now_x, now_y, next_x, next_y, Piece);
                if(check.Check("White") == "White"){
                    chess.Swap(next_x, next_y, now_x, now_y, Piece);
                    chess.chessboard[next_y][next_x] = BeforePiece;
                    return false;
                }
                return true;
            }
            else{
                return false;
            }
        }
        else if(xDiff != 0 && yDiff == 0){
            // 왼쪽으로
            if(now_x > next_x){
                for(int i = 1; i <= now_x - next_x; i++){
                    if(location.LocationColor(now_x - i, now_y) == "White"){
                        NextIsNull = false;
                    }
                }
            }
            // 오른쪽으로
            else if(now_x < next_x){
                for(int i = 1; i <= next_x - now_x; i++){
                    if(location.LocationColor(now_x + i, now_y) == "White"){
                        NextIsNull = false;
                    }
                }
            }

            if(NextIsNull){
                chess.Swap(now_x, now_y, next_x, next_y, Piece);
                if(check.Check("White") == "White"){
                    chess.Swap(next_x, next_y, now_x, now_y, Piece);
                    chess.chessboard[next_y][next_x] = BeforePiece;
                    return false;
                }
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

    public Boolean BlackRookMove(int now_x, int now_y, int next_x, int next_y)
    {
        String BeforePiece = location.LocationPiece(next_x, next_y);
        String Piece = location.LocationPiece(now_x, now_y);
        Boolean NextIsNull = true;
        int xDiff = now_x - next_x;
        int yDiff = now_y - next_y;
    
        //행마하기
        if(xDiff == 0 && yDiff != 0){
            // 위로
            if(now_y > next_y){
                for(int i = 1; i <= now_y - next_y; i++){
                    if(location.LocationColor(now_x, now_y - i) == "Black"){
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
                chess.Swap(now_x, now_y, next_x, next_y, Piece);
                if(check.Check("Black") == "Black"){
                    chess.Swap(next_x, next_y, now_x, now_y, Piece);
                    chess.chessboard[next_y][next_x] = BeforePiece;
                    return false;
                }
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
                    if(location.LocationColor(now_x - i, now_y) == "Black"){
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
                chess.Swap(now_x, now_y, next_x, next_y, Piece);
                if(check.Check("Black") == "Black"){
                    chess.Swap(next_x, next_y, now_x, now_y, Piece);
                    chess.chessboard[next_y][next_x] = BeforePiece;
                    return false;
                }
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