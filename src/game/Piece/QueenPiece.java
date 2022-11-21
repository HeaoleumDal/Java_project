package game.Piece;
import game.UI.chess;
import game.location.Location;
import game.Piece.*;

public class QueenPiece {
    Location location = new Location();
    BishopPiece bishop = new BishopPiece();
    RookPiece rook = new RookPiece();

    public boolean WhiteQueenMove(int now_x, int now_y, int next_x, int next_y){

        if((now_x == next_x && now_y != next_y) || (now_x != next_x && now_y == next_y)){
            return rook.WhiteRookMove(now_x, now_y, next_x, next_y);
        }
        else if(Math.abs(now_x - next_x) == Math.abs(now_y - next_y) && now_x - next_x != 0){
            return bishop.WhiteBishopMove(now_x, now_y, next_x, next_y);
        }
        else{
            return false;
        }
    }

    public boolean BlackQueenMove(int now_x, int now_y, int next_x, int next_y){

        if((now_x == next_x && now_y != next_y) || (now_x != next_x && now_y == next_y)){
            return rook.BlackRookMove(now_x, now_y, next_x, next_y);
        }
        else if(Math.abs(now_x - next_x) == Math.abs(now_y - next_y) && now_x - next_x != 0){
            return bishop.BlackBishopMove(now_x, now_y, next_x, next_y);
        }
        else{
            return false;
        }
    }
}
