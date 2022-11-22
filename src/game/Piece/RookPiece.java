package game.Piece;
import game.UI.chess;
import game.location.Location;

public class RookPiece 
{
    Location location = new Location();

    public boolean WhiteRookMove(int now_x, int now_y, int next_x, int next_y) 
    {
        String Piece = location.LocationPiece(now_x, now_y);
        int xDiff = Math.abs(now_x - next_x) + 1;
        int yDiff = Math.abs(now_y - next_y) + 1;
    
        //행마하기
        if(now_x == next_x)
        {
            //위로
            if(now_y > next_y)
            {
                for(int i = 1 ; i < yDiff ; i++)
                {
                    if(location.LocationIsNull(now_x, now_y - i) || !(location.LocationColor(now_x, now_y - i) == "White"))
                    {
                        chess.Swap(now_x, now_y, next_x, next_y, Piece); 
                    }
                }
                return false;
            }
            //아래로
            else
            {
                for(int i = 1 ; i < yDiff ; i++)
                {
                    if(location.LocationIsNull(now_x, now_y + i) || !(location.LocationColor(now_x, now_y + i) == "White"))
                    {
                        chess.Swap(now_x, now_y, next_x, next_y, Piece); 
                    }
                }
                return false;
            }
        }
        //오른쪽으로
        else if(now_x < next_x)
        {
            for(int i = 1 ; i < xDiff ; i++)
            {
                if(location.LocationIsNull(now_x + i, now_y) || !(location.LocationColor(now_x + i, now_y) == "White"))
                {
                    chess.Swap(now_x, now_y, next_x, next_y, Piece); 
                }
            }
            return false;
        }
        //왼쪽으로
        else if(now_x > next_x)
        {
            for(int i = 1 ; i < xDiff ; i++)
            {
                if(location.LocationIsNull(now_x - i, now_y) || !(location.LocationColor(now_x - i, now_y) == "White"))
                {
                    chess.Swap(now_x, now_y, next_x, next_y, Piece); 
                }
            }
            return false;
        }
        else
        {
            return true;
        }
        
    }

    public Boolean BlackRookMove(int now_x, int now_y, int next_x, int next_y)
    {
        String Piece = location.LocationPiece(now_x, now_y);
        int xDiff = Math.abs(now_x - next_x) + 1;
        int yDiff = Math.abs(now_y - next_y) + 1;
    
        //행마하기
        if(now_x == next_x)
        {
            //위로
            if(now_y > next_y)
            {
                for(int i = 1 ; i < yDiff ; i++)
                {
                    if(location.LocationIsNull(now_x, now_y - i) || !(location.LocationColor(now_x, now_y - i) == "Black"))
                    {
                        chess.Swap(now_x, now_y, next_x, next_y, Piece); 
                    }
                }
                return false;
            }
            //아래로
            else
            {
                for(int i = 1 ; i < yDiff ; i++)
                {
                    if(location.LocationIsNull(now_x, now_y + i) || !(location.LocationColor(now_x, now_y + i) == "Black"))
                    {
                        chess.Swap(now_x, now_y, next_x, next_y, Piece); 
                    }
                }
                return false;
            }

        }
        //오른쪽으로
        else if(now_x < next_x)
        {
            for(int i = 1 ; i < xDiff ; i++)
            {
                if(location.LocationIsNull(now_x + i, now_y) || !(location.LocationColor(now_x + i, now_y) == "Black"))
                {
                    chess.Swap(now_x, now_y, next_x, next_y, Piece); 
                }
            }
            return false;
        }
        //왼쪽으로
        else if(now_x > next_x)
        {
            for(int i = 1 ; i < xDiff ; i++)
            {
                if(location.LocationIsNull(now_x - i, now_y) || !(location.LocationColor(now_x - i, now_y) == "Black"))
                {
                    chess.Swap(now_x, now_y, next_x, next_y, Piece); 
                }
            }
            return false;
        }
        else
        {
            return true;
        }
    }
}
