package game.Piece;
import game.UI.chess;
import game.location.Location;

public class KnightPiece 
{
    check check = new check();
    Location location = new Location();
    mate checkmate = new mate();

    public boolean WhiteKnightMove(int now_x, int now_y, int next_x, int next_y) 
    {
        String BeforePiece = location.LocationPiece(next_x, next_y);
        String Piece = location.LocationPiece(now_x, now_y);
        int xDiff = Math.abs(next_x - now_x);
        int yDiff = Math.abs(next_y - now_y);
        Boolean NextIsNull = true;
        boolean canMove = false;
        if(xDiff + yDiff == 3){
            if((xDiff == 2 && yDiff == 1) || (xDiff == 1 && yDiff == 2)){
                canMove = true;
            }
        }
    
        //행마하기
        if(canMove)
        {
            if(location.LocationColor(next_x, next_y) == "White"){
                NextIsNull = false;
            }

            if(NextIsNull)
            {
                chess.Swap(now_x, now_y, next_x, next_y, Piece);
                if(check.Check("White") == "White"){
                    chess.Swap(next_x, next_y, now_x, now_y, chess.WhiteKnight);
                    chess.chessboard[next_y][next_x] = BeforePiece;
                    return false;
                }
                checkmate.Checkmate("Black");
                return true;
            }
            else
            {
                return false;
            }
        }
        else
        {
            return false;
        }
    }

    public Boolean BlackKnightMove(int now_x, int now_y, int next_x, int next_y)
    {
        String BeforePiece = location.LocationPiece(next_x, next_y);
        String Piece = location.LocationPiece(now_x, now_y);
        int xDiff = Math.abs(next_x - now_x);
        int yDiff = Math.abs(next_y - now_y);
        Boolean NextIsNull = true;
        boolean canMove = false;
        if(xDiff + yDiff == 3){
            if((xDiff == 2 && yDiff == 1) || (xDiff == 1 && yDiff == 2)){
                canMove = true;
            }
        }
    
        //행마하기
        if(canMove)
        {
            if(location.LocationColor(next_x, next_y) == "Black"){
                NextIsNull = false;
            }

            if(NextIsNull)
            {
                chess.Swap(now_x, now_y, next_x, next_y, Piece);
                if(check.Check("Black") == "Black"){
                    chess.Swap(next_x, next_y, now_x, now_y, Piece);
                    chess.chessboard[next_y][next_x] = BeforePiece;
                    return false;
                }
                checkmate.Checkmate("White");
                return true;
            }
            else
            {
                return false;
            }
        }
        else
        {
            return false;
        }
    }
}

