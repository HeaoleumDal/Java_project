package game.Piece;
import game.UI.chess;
import game.location.Location;

public class KnightPiece 
{
    Location location = new Location();

    public boolean WhiteKnightMove(int now_x, int now_y, int next_x, int next_y) 
    {
        String Piece = location.LocationPiece(now_x, now_y);
        int xDiff = Math.abs(next_x - now_x);
        int yDiff = Math.abs(next_y - now_y);
        Boolean NextIsNull = true;
        Boolean canMove = (0 < xDiff && xDiff <= 2) && (0 < yDiff && yDiff <= 2) ? true : false;
    
        //행마하기
        if(canMove)
        {
            if(location.LocationColor(next_x, next_y) == "White"){
                NextIsNull = false;
            }

            if(NextIsNull)
            {
                game.UI.chess.Swap(now_x, now_y, next_x, next_y, Piece);
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
        String Piece = location.LocationPiece(now_x, now_y);
        int xDiff = Math.abs(next_x - now_x);
        int yDiff = Math.abs(next_y - now_y);
        Boolean NextIsNull = true;
        Boolean canMove = (0 < xDiff && xDiff <= 2) && (0 < yDiff && yDiff <= 2) ? true : false;
    
        //행마하기
        if(canMove)
        {
            if(location.LocationColor(next_x, next_y) == "black")
            {
                NextIsNull = false;
            }

            if(NextIsNull)
            {
                game.UI.chess.Swap(now_x, now_y, next_x, next_y, Piece);
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

