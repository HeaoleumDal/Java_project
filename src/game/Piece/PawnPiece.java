package game.Piece;
import game.UI.chess;
import game.location.Location;
public class PawnPiece{
    Location location = new Location();

    public boolean WhitePawnMove(int now_x, int now_y, int next_x, int next_y) {
        Boolean NextIsNull = true;
        for(int i = now_y - 1; i >= next_y; i--){
            System.out.println(chess.chessboard[now_x][i] + " " + now_x + " " + i);
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
            return false;
        }
        else{
            return true;
        }
    }

    public void BlackPawnMove(int now_x, int now_y, int next_x, int next_y){

    }
}