package game.Piece;
import game.UI.chess;
import game.location.Location;
import game.Piece.PieceSwap;
public class PawnPiece{
    chess chess = new chess();
    Location location = new Location();
    PieceSwap swap = new PieceSwap();

    public void WhitePawnMove(int now_x, int now_y, int next_x, int next_y) {
        if(now_y == 6){
            if(now_y - next_y < 3 && now_y - next_y > 0 && location.NextLocationIsNull(next_x, next_y)){
                swap.Swap(now_x, now_y, next_x, next_y, chess.WhitePawn);
            }
        }
        else{
            if(now_y - next_y < 2 && now_y - next_y > 0 && location.NextLocationIsNull(next_x, next_y)){
                swap.Swap(now_x, now_y, next_x, next_y, chess.WhitePawn);
            }
        }
    }

    public void BlackPawnMove(int now_x, int now_y, int next_x, int next_y){

    }
}
