package game.Piece;
import game.UI.chess;
import game.location.Location;
public class PawnPiece {
    chess chess = new chess();
    Location location = new Location();

    public void WhitePawnMove(int now_x, int now_y, int next_x, int next_y) {
        if(now_y == 6){
            if(now_y - next_y < 3 || now_y - next_y >= 0 && location.NextLocationIsNull(next_x, next_y)){
                chess.chessboard[next_y][next_x] = chess.WhitePawn;
                chess.chessboard[now_y][now_x] = chess.nullpiece;
            }
        }
        else{
            if(now_y - next_y < 2 || now_y - next_y >= 0 && location.NextLocationIsNull(next_x, next_y)){
                chess.chessboard[next_y][next_x] = chess.WhitePawn;
                chess.chessboard[now_y][now_x] = chess.nullpiece;
            }
        }
    }

    public void BlackPawnMove(int now_x, int now_y, int next_x, int next_y){

    }
}
