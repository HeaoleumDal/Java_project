package game.location;

import game.UI.chess;

public class Location {

    public Boolean LocationIsNull(int x, int y) {
        if(game.UI.chess.chessboard[y][x] == game.UI.chess.nullPiece) {
            return true;
        }
        return false;
    }

    public String LocationPiece(int x, int y){
        if(LocationIsNull(x, y)){
            return game.UI.chess.nullPiece;
        }
        return game.UI.chess.chessboard[y][x];
    }

    public String LocationColor(int x, int y){
        String Color = "";
        if(LocationIsNull(x, y)){
            Color = "Null";
        }
        for (int i = 0; i < game.UI.chess.Piece.length; i++) {
            if(LocationPiece(x, y) == game.UI.chess.WhitePiece[i]){
                Color = "White";
            }
            else if(LocationPiece(x, y) == game.UI.chess.BlackPiece[i]){
                Color = "Black";
            }
        }
        return Color;
    }
}
