package game.location;
import game.UI.chess;

public class Location {

    public Boolean LocationIsNull(int x, int y) {
        if(chess.chessboard[y][x] == chess.nullPiece) {
            return true;
        }
        return false;
    }

    public String LocationPiece(int x, int y){
        if(LocationIsNull(x, y)){
            return chess.nullPiece;
        }
        return chess.chessboard[y][x];
    }

    public String LocationColor(int x, int y){
        String Color = "";
        if(LocationIsNull(x, y)){
            Color = "Null";
        }
        for (int i = 0; i < chess.Piece.length; i++) {
            if(LocationPiece(x, y) == chess.WhitePiece[i]){
                Color = "White";
            }
            else if(LocationPiece(x, y) == chess.BlackPiece[i]){
                Color = "Black";
            }
        }
        return Color;
    }

    /**
     * 
     * @param Piece 좌표 값을 알고 싶은 기물
     * @return 기물의 좌표값 [x, y]
     */
    public int[] PiecePosition(String Piece){
        int[] position = new int[2];
        for(int i = 0; i < 8; i++){
            for(int j = 0; j < 8; j++){
                if(LocationPiece(j, i) == Piece){
                    position[0] = j;
                    position[1] = i;
                }
            }
        }
        return position;
    }
}
