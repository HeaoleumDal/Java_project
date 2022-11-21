package game.Piece;
import game.UI.chess;
import game.location.Location;
public class BishopPiece{
    Location location = new Location();

    public boolean WhiteBishopMove(int now_x, int now_y, int next_x, int next_y) 
    {
        Boolean canMove = true;
        int xDiff = next_x - now_x;
        int yDiff = next_y - now_y;
        int xyDiff = xDiff + yDiff;

        //말 잡았을 때
        if(BishopCatch(now_x, now_y, next_x, next_y)){
            chess.Swap(now_x, now_y, next_x, next_y, chess.WhiteBishop);
            return true;
        }
        
        //움직일 수 있는 조건
        if(Math.abs(xDiff) - Math.abs(yDiff) == 0)
        {
            canMove = true;
        }
        else
        {
            canMove = false;
        }

        //행마하기
        if(canMove & xyDiff == 0) 
        {
            if(xDiff > yDiff) 
            {
                for(int i = 1; i < xDiff; i++)
                {
                    //x + i, y - i
                    if(location.LocationIsNull(now_x + i, now_y - i) || !(location.LocationColor(now_x + i, now_y - i) == "White")) 
                    {
                        chess.Swap(now_x, now_y, next_x, next_y, chess.WhiteBishop);
                    }
                }
            } 
            else 
            {
                for(int i = 1; i < yDiff; i++) 
                {
                    //x - i, y + i
                    if(location.LocationIsNull(now_x - i, now_y + i) || !(location.LocationColor(now_x - i, now_y + i) == "White")) 
                    {
                        chess.Swap(now_x, now_y, next_x, next_y, chess.WhiteBishop);
                    }
                }
            }
            return false;
        } 

        else if(canMove & xyDiff > 0) 
        {
            for(int i = 1; i < xDiff; i++) 
            {
                //x + i, y + i
                if(location.LocationIsNull(now_x + i, now_y + i) || !(location.LocationColor(now_x + i, now_y + i) == "White")) 
                {
                    chess.Swap(now_x, now_y, next_x, next_y, chess.WhiteBishop);
                }
            }
            return false;
        }

        else if(canMove)
        {
            for(int i = 1; i < Math.abs(xDiff); i++) 
            {
                //x - i, y - i
                if(location.LocationIsNull(now_x - i, now_y - i) || !(location.LocationColor(now_x - i, now_y - i) == "White")) 
                {
                    chess.Swap(now_x, now_y, next_x, next_y, chess.WhiteBishop);
                }
            }
            return false;
        }
        else
        {
            return true;
        }
    }

    public Boolean BlackBishopMove(int now_x, int now_y, int next_x, int next_y){
        Boolean canMove = true;
        int xDiff = next_x - now_x;
        int yDiff = next_y - now_y;
        int xyDiff = xDiff + yDiff;

        //말 잡았을 때
        if(BishopCatch(now_x, now_y, next_x, next_y)){
            chess.Swap(now_x, now_y, next_x, next_y, chess.BlackBishop);
            return true;
        }
        
        //움직일 수 있는 조건
        if(Math.abs(xDiff) - Math.abs(yDiff) == 0)
        {
            canMove = true;
        }
        else
        {
            canMove = false;
        }

        //행마하기
        if(canMove & xyDiff == 0) 
        {
            if(xDiff > yDiff) 
            {
                for(int i = 1; i < xDiff; i++) 
                {
                    //x + i, y - i
                    if(location.LocationIsNull(now_x + i, now_y - i) || !(location.LocationColor(now_x + i, now_y - i) == "Black")) 
                    {
                        chess.Swap(now_x, now_y, next_x, next_y, chess.BlackBishop);
                    }
                }
            } 
            else 
            {
                for(int i = 1;  i < yDiff; i++) 
                {
                    //x - i, y + i
                    if(location.LocationIsNull(now_x - i, now_y + i) || !(location.LocationColor(now_x - i, now_y + i) == "Black")) 
                    {
                        chess.Swap(now_x, now_y, next_x, next_y, chess.BlackBishop);
                    }
                }
            }
            return false;
        } 

        else if(canMove & xyDiff > 0) 
        {
            for(int i = 1; i < xDiff; i++) 
            {
                //x + i, y + i
                if(location.LocationIsNull(now_x + i, now_y + i) || !(location.LocationColor(now_x + i, now_y + i) == "Black")) 
                {
                    chess.Swap(now_x, now_y, next_x, next_y, chess.BlackBishop);
                }
            }
            return false;
        }

        else if(canMove)
        {
            for(int i = 1; i < Math.abs(xDiff); i++) 
            {
                //x - i, y - i
                if(location.LocationIsNull(now_x - i, now_y - i) || !(location.LocationColor(now_x - i, now_y - i) == "Black")) 
                {
                    chess.Swap(now_x, now_y, next_x, next_y, chess.BlackBishop);
                }
            }
            return false;
        }
        else
        {
            return true;
        }
    }

    public Boolean BishopCatch(int now_x, int now_y, int next_x, int next_y){
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