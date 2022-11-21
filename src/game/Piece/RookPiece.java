package game.Piece;
import game.UI.chess;
import game.location.Location;

public class RookPiece 
{
    Location location = new Location();

    public boolean WhiteRookMove(int now_x, int now_y, int next_x, int next_y) 
    {
        int xDiff = Math.abs(now_x - next_x) + 1;
        int yDiff = Math.abs(now_y - next_y) + 1;

        //말 잡았을 때
        if(RookCatch(now_x, now_y, next_x, next_y)){
            chess.Swap(now_x, now_y, next_x, next_y, chess.WhiteRook);
            return true;
        }
    
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
                        chess.Swap(now_x, now_y, next_x, next_y, chess.WhiteRook); 
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
                        chess.Swap(now_x, now_y, next_x, next_y, chess.WhiteRook); 
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
                    chess.Swap(now_x, now_y, next_x, next_y, chess.WhiteRook); 
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
                    chess.Swap(now_x, now_y, next_x, next_y, chess.WhiteRook); 
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
        int xDiff = Math.abs(now_x - next_x) + 1;
        int yDiff = Math.abs(now_y - next_y) + 1;

        //말 잡았을 때
        if(RookCatch(now_x, now_y, next_x, next_y)){
            chess.Swap(now_x, now_y, next_x, next_y, chess.BlackRook);
            return true;
        }
    
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
                        chess.Swap(now_x, now_y, next_x, next_y, chess.BlackRook); 
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
                        chess.Swap(now_x, now_y, next_x, next_y, chess.BlackRook); 
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
                    chess.Swap(now_x, now_y, next_x, next_y, chess.BlackRook); 
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
                    chess.Swap(now_x, now_y, next_x, next_y, chess.BlackRook); 
                }
            }
            return false;
        }
        else
        {
            return true;
        }
    }

    public Boolean RookCatch(int now_x, int now_y, int next_x, int next_y){
        String Color = location.LocationColor(now_x, now_y);
        if(Math.abs(now_x - next_x) == 1 && Math.abs(now_y - next_y) == 1){
            if(Color == "White"){
                if(now_y > next_y){
                    return true;
                }
                else{
                    return false;
                }
            }
            else if(Color == "Black"){
                if(now_y < next_y){
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
        else{
            return false;
        }
    }
}
