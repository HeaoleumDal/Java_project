package game.Piece;
import game.UI.chess;
import game.location.Location;
public class PawnPiece{
    chess chess = new chess();
    Location location = new Location();

    public void WhitePawnMove(int now_x, int now_y, int next_x, int next_y) {
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
        
        for(int i = 0; i < 8; i++){
            for(int j = 0; j < 8; j++){
                System.out.print(chess.chessboard[i][j] + " ");
            }
            System.out.println();
        }
    }

    public void BlackPawnMove(int now_x, int now_y, int next_x, int next_y){

    }
}
