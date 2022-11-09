package game.location;
import javax.swing.text.ElementIterator;

import game.UI.chess;

public class Location {
    chess chess = new chess();
    public Boolean NowLocationIsNull(char now_x, char now_y) {
        int x = now_x - 49;
        int y = 72 - now_y;

        if(chess.chessboard[x][y] == chess.nullpiece) {
            return true;
        }
        return false;
    }

    public Boolean NextLocationIsNull(char next_x, char next_y){
        int x = next_x - 49;
        int y = 72 - next_y;

        if(chess.chessboard[x][y] == chess.nullpiece){
            return true;
        }
        return false;
    }

    public String NowLocationPiece(char now_x, char now_y){
        int x = now_x - 49;
        int y = 72 - now_y;

        if(NowLocationIsNull(now_x, now_y)){
            return chess.nullpiece;
        }
        return chess.chessboard[x][y];
    }

    public String NextLocationPiece(char next_x, char next_y){
        int x = next_x - 49;
        int y = 72 - next_y;

        if(NextLocationIsNull(next_x, next_y)){
            return chess.nullpiece;
        }
        return chess.chessboard[x][y];
    }

    public String NowLocationColor(char now_x, char now_y){
        int x = now_x - 49;
        int y = 72 - now_y;
        String Color = "";

        if(NowLocationIsNull(now_x, now_y)){
            Color = "Null";
        }
        for (int i = 0; i < chess.Piece.length; i++) {
            if(NowLocationPiece(now_x, now_y) == chess.WhitePiece[i]){
                Color = "White";
            }
            else if(NowLocationPiece(now_x, now_y) == chess.BlackPiece[i]){
                Color = "Black";
            }
        }
        return Color;
    }
    public String NextLocationColor(char next_x, char next_y){
        int x = next_x - 49;
        int y = 72 - next_y;
        String Color = "";

        if(NextLocationIsNull(next_x, next_y)){
            Color = "Null";
        }
        for (int i = 0; i < chess.Piece.length; i++) {
            if(NextLocationPiece(next_x, next_y) == chess.WhitePiece[i]){
                Color = "White";
            }
            else if(NextLocationPiece(next_x, next_y) == chess.BlackPiece[i]){
                Color = "Black";
            }
        }
        return Color;
    }
}
