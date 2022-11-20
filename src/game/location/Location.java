package game.location;

import game.UI.chess;

public class Location {

    public Boolean NowLocationIsNull(int x, int y) {
        if(game.UI.chess.chessboard[y][x] == game.UI.chess.nullPiece) {
            return true;
        }
        return false;
    }

    public Boolean NextLocationIsNull(int x, int y){
        if(game.UI.chess.chessboard[y][x] == game.UI.chess.nullPiece){
            return true;
        }
        return false;
    }

    public String NowLocationPiece(int x, int y){
        if(NowLocationIsNull(x, y)){
            return game.UI.chess.nullPiece;
        }
        return game.UI.chess.chessboard[y][x];
    }

    public String NextLocationPiece(int x, int y){
        if(NextLocationIsNull(x, y)){
            return game.UI.chess.nullPiece;
        }
        return game.UI.chess.chessboard[y][x];
    }

    public String NowLocationColor(int x, int y){
        String Color = "";
        if(NowLocationIsNull(x, y)){
            Color = "Null";
        }
        for (int i = 0; i < game.UI.chess.Piece.length; i++) {
            if(NowLocationPiece(x, y) == game.UI.chess.WhitePiece[i]){
                Color = "White";
            }
            else if(NowLocationPiece(x, y) == game.UI.chess.BlackPiece[i]){
                Color = "Black";
            }
        }
        return Color;
    }

    public String NextLocationColor(int x, int y){
        String Color = "";
        if(NextLocationIsNull(x, y)){
            Color = "Null";
        }
        for (int i = 0; i < game.UI.chess.Piece.length; i++) {
            if(NextLocationPiece(x, y) == game.UI.chess.WhitePiece[i]){
                Color = "White";
            }
            else if(NextLocationPiece(x, y) == game.UI.chess.BlackPiece[i]){
                Color = "Black";
            }
        }
        return Color;
    }
}
