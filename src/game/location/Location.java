package game.location;

import game.UI.chess;

public class Location {
    chess chess = new chess();

    public Boolean NowLocationIsNull(int x, int y) {
        if(chess.chessboard[y][x] == chess.nullpiece) {
            return true;
        }
        return false;
    }

    public Boolean NextLocationIsNull(int x, int y){
        if(chess.chessboard[y][x] == chess.nullpiece){
            return true;
        }
        return false;
    }

    public String NowLocationPiece(int x, int y){
        if(NowLocationIsNull(x, y)){
            return chess.nullpiece;
        }
        return chess.chessboard[y][x];
    }

    public String NextLocationPiece(int x, int y){
        if(NextLocationIsNull(x, y)){
            return chess.nullpiece;
        }
        return chess.chessboard[y][x];
    }

    public String NowLocationColor(int x, int y){
        String Color = "";
        if(NowLocationIsNull(x, y)){
            Color = "Null";
        }
        for (int i = 0; i < chess.Piece.length; i++) {
            if(NowLocationPiece(x, y) == chess.WhitePiece[i]){
                Color = "White";
            }
            else if(NowLocationPiece(x, y) == chess.BlackPiece[i]){
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
        for (int i = 0; i < chess.Piece.length; i++) {
            if(NextLocationPiece(x, y) == chess.WhitePiece[i]){
                Color = "White";
            }
            else if(NextLocationPiece(x, y) == chess.BlackPiece[i]){
                Color = "Black";
            }
        }
        return Color;
    }
}
