package game.Piece;
import game.UI.chess;
import game.location.Location;

public class RookPiece 
{
    Location location = new Location();

    public boolean WhiteRookMove(int now_x, int now_y, int next_x, int next_y) 
    {
        String Piece = location.LocationPiece(now_x, now_y);
        String Color = location.LocationColor(now_x, now_y);
        Boolean NextIsNull = true;
        int xDiff = now_x - next_x;
        int yDiff = now_y - next_y;
    
        //행마하기
        if(xDiff == 0 && yDiff != 0){

            // 위로
            if(now_y > next_y){
                for(int i = 1; i <= now_y - next_y; i++){
                    if(location.LocationColor(now_x, next_y + i) == Color){
                        NextIsNull = false;
                    }
                }
            }
            // 아래로
            else if(now_y < next_y){
                for(int i = 1; i <= next_y - now_y; i++){
                    if(location.LocationColor(now_x, now_y + i) == Color){
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
                    if(location.LocationColor(next_x + i, now_y) == Color){
                        NextIsNull = false;
                    }
                }
            }
            // 오른쪽으로
            else if(now_x < next_x){
                for(int i = 1; i <= next_x - now_x; i++){
                    if(location.LocationColor(now_x + i, now_y) == Color){
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
