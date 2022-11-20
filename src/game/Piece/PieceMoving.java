package game.Piece;
import game.location.Location;
import game.Piece.*;

public class PieceMoving {
    Location location = new Location();
    PawnPiece pawn = new PawnPiece();

    public Boolean PieceMove(char char_now_x, char char_now_y, char char_next_x, char char_next_y, String Color){
        int now_x = char_now_x - 49;
        int now_y = 72 - char_now_y;
        int next_x = char_next_x - 49;
        int next_y = 72 - char_next_y;
        String nowPiece = location.NowLocationPiece(now_x, now_y);
        if(now_x >= 0 && now_x <= 7 && now_y >= 0 && now_y <= 7 && next_x >= 0 && next_y <= 7 ){
            if(Color == "White"){
                if(nowPiece == game.UI.chess.WhitePawn){
                    if(pawn.WhitePawnMove(now_x, now_y, next_x, next_y)){
                        return true;
                    }
                }
                else if(nowPiece == game.UI.chess.WhiteKnight){
        
                }
                else if(nowPiece == game.UI.chess.WhiteBishop){
    
                }
                else if(nowPiece == game.UI.chess.WhiteRook){
    
                }
                else if(nowPiece == game.UI.chess.WhiteQueen){
    
                }
                else if(nowPiece == game.UI.chess.WhiteKing){
    
                }
            }
            else if(Color == "Black"){
                if(nowPiece == game.UI.chess.BlackPawn){
                    pawn.BlackPawnMove(now_x, now_y, next_x, next_y);
                }
                else if(nowPiece == game.UI.chess.BlackKnight){
        
                }
                else if(nowPiece == game.UI.chess.BlackBishop){
    
                }
                else if(nowPiece == game.UI.chess.BlackRook){
    
                }
                else if(nowPiece == game.UI.chess.BlackQueen){
    
                }
                else if(nowPiece == game.UI.chess.BlackKing){
    
                }
            }
        }
        return true;
    }
}
