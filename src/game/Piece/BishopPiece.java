package game.Piece;
import game.UI.chess;
import game.location.Location;
public class BishopPiece{
    check check = new check();
    Location location = new Location();

    public boolean WhiteBishopMove(int now_x, int now_y, int next_x, int next_y) 
    {
        String BeforePiece = location.LocationPiece(next_x, next_y);
        String Piece = location.LocationPiece(now_x, now_y);
        int xDiff = next_x - now_x;
        int yDiff = next_y - now_y;
        boolean canMove = Math.abs(xDiff) - Math.abs(yDiff) == 0 ? true : false;
        Boolean NextIsNull = true;
        if(canMove){
            // 오른쪽 위
            if(now_x < next_x && now_y > next_y){
                for(int i = 1; i <= Math.abs(xDiff); i++){
                    if(location.LocationColor(now_x + i, now_y - i) == "White"){
                        NextIsNull = false;
                    }
                }
            }
            // 왼쪽 위
            if(now_x > next_x && now_y > next_y){
                for(int i = 1; i <= Math.abs(xDiff); i++){
                    if(location.LocationColor(now_x - i, now_y - i) == "White"){
                        NextIsNull = false;
                    }
                }
            }
            // 오른쪽 아래
            if(now_x < next_x && now_y < next_y){
                for(int i = 1; i <= Math.abs(xDiff); i++){
                    if(location.LocationColor(now_x + i, now_y + i) == "White"){
                        NextIsNull = false;
                    }
                }
            }
            // 왼쪽 아래
            if(now_x > next_x && now_y < next_y){
                for(int i = 1; i <= Math.abs(xDiff); i++){
                    if(location.LocationColor(now_x - i, now_y + i) == "White"){
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

    public Boolean BlackBishopMove(int now_x, int now_y, int next_x, int next_y)
    {
        String BeforePiece = location.LocationPiece(next_x, next_y);
        String Piece = location.LocationPiece(now_x, now_y);
        int xDiff = next_x - now_x;
        int yDiff = next_y - now_y;
        boolean canMove = Math.abs(xDiff) - Math.abs(yDiff) == 0 ? true : false;
        Boolean NextIsNull = true;
        if(canMove){
            // 오른쪽 위
            if(now_x < next_x && now_y > next_y){
                for(int i = 1; i <= Math.abs(xDiff); i++){
                    if(location.LocationColor(now_x + i, now_y - i) == "Black"){
                        NextIsNull = false;
                    }
                }
            }
            // 왼쪽 위
            if(now_x > next_x && now_y > next_y){
                for(int i = 1; i <= Math.abs(xDiff); i++){
                    if(location.LocationColor(now_x - i, now_y - i) == "Black"){
                        NextIsNull = false;
                    }
                }
            }
            // 오른쪽 아래
            if(now_x < next_x && now_y < next_y){
                for(int i = 1; i <= Math.abs(xDiff); i++){
                    if(location.LocationColor(now_x + i, now_y + i) == "Black"){
                        NextIsNull = false;
                    }
                }
            }
            // 왼쪽 아래
            if(now_x > next_x && now_y < next_y){
                for(int i = 1; i <= Math.abs(xDiff); i++){
                    if(location.LocationColor(now_x - i, now_y + i) == "Black"){
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