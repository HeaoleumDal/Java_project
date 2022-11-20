package game.Piece;
import game.UI.chess;
import game.location.Location;
public class PawnPiece{
    Location location = new Location();

    public boolean WhitePawnMove(int now_x, int now_y, int next_x, int next_y) {
        Boolean NextIsNull = true;
        if(PawnCatch(now_x, now_y, next_x, next_y)){
            chess.Swap(now_x, now_y, next_x, next_y, chess.WhitePawn);
            return true;
        }
        for(int i = now_y - 1; i >= next_y; i--){
            if(location.NextLocationIsNull(next_x, i)){
                NextIsNull = true;
            }
            else{
                NextIsNull = false;
                break;
            }
        }
        if(NextIsNull){
            if(now_y == 6){
                if(now_y - next_y < 3 && now_y - next_y > 0 && location.NextLocationIsNull(next_x, next_y)){
                    chess.Swap(now_x, now_y, next_x, next_y, chess.WhitePawn);
                }
            }
            else{
                if(now_y - next_y < 2 && now_y - next_y > 0 && location.NextLocationIsNull(next_x, next_y)){
                    chess.Swap(now_x, now_y, next_x, next_y, chess.WhitePawn);
                }
            }
            return true;
        }
        else{
            return false;
        }
    }

    public Boolean BlackPawnMove(int now_x, int now_y, int next_x, int next_y){
        Boolean NextIsNull = true;
        if(PawnCatch(now_x, now_y, next_x, next_y)){
            chess.Swap(now_x, now_y, next_x, next_y, chess.BlackPawn);
            return true;
        }
        for(int i = now_y + 1; i <= next_y; i++){
            if(location.NextLocationIsNull(next_x, i)){
                NextIsNull = true;
            }
            else{
                NextIsNull = false;
                break;
            }
        }
        if(NextIsNull){
            if(now_y == 1){
                if(next_y - now_y < 3 && next_y - now_y > 0 && location.NextLocationIsNull(next_x, next_y)){
                    chess.Swap(now_x, now_y, next_x, next_y, chess.BlackPawn);
                }
            }
            else{
                if(next_y - now_y < 2 && next_y - now_y > 0 && location.NextLocationIsNull(next_x, next_y)){
                    chess.Swap(now_x, now_y, next_x, next_y, chess.BlackPawn);
                }
            }
            return false;
        }
        else{
            return true;
        }
    }

    public Boolean PawnCatch(int now_x, int now_y, int next_x, int next_y){
        String Color = location.NowLocationColor(now_x, now_y);
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