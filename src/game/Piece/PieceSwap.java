package game.Piece;
import game.Piece.PieceMoving;
import game.UI.chess;
public class PieceSwap {
    chess chess = new chess();
    public void Swap(int now_x, int now_y, int next_x, int next_y, String Piece){
        chess.chessboard[next_y][next_x] = Piece;
        chess.chessboard[now_y][now_x] = chess.nullPiece;
        for(int i = 0; i < 8; i++){
            for(int j = 0; j < 8; j++){
                System.out.print(chess.chessboard[i][j] + " ");
            }
            System.out.println();
        }
    }
}
