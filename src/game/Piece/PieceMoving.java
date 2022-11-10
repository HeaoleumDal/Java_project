package game.Piece;
import game.UI.chess;
import game.location.Location;
import game.Piece.PawnPiece;

public class PieceMoving {
    chess chess = new chess();
    Location location = new Location();
    PawnPiece pawn = new PawnPiece();

    public void PieceMove(char char_now_x, char char_now_y, char char_next_x, char char_next_y, String Color){
        int now_x = char_now_x - 49;
        int now_y = 72 - char_now_y;
        int next_x = char_next_x - 49;
        int next_y = 72 - char_next_y;
        String nowPiece = location.NowLocationPiece(now_x, now_y);
        if(now_x >= 0 && now_x <= 7 && now_y >= 0 && now_y <= 7 && next_x >= 0 && next_y <= 7 ){
            if(Color == "White"){
                if(nowPiece == chess.WhitePawn){
                    pawn.WhitePawnMove(now_x, now_y, next_x, next_y);
                }
                else if(nowPiece == chess.WhiteKnight){
        
                }
                else if(nowPiece == chess.WhiteBishop){
    
                }
                else if(nowPiece == chess.WhiteRook){
    
                }
                else if(nowPiece == chess.WhiteQueen){
    
                }
                else if(nowPiece == chess.WhiteKing){
    
                }
            }
            else if(Color == "Black"){
                if(nowPiece == chess.BlackPawn){
                    pawn.BlackPawnMove(now_x, now_y, next_x, next_y);
                }
                else if(nowPiece == chess.BlackKnight){
        
                }
                else if(nowPiece == chess.BlackBishop){
    
                }
                else if(nowPiece == chess.BlackRook){
    
                }
                else if(nowPiece == chess.BlackQueen){
    
                }
                else if(nowPiece == chess.BlackKing){
    
                }
            }
        }
        else{

        }
    }
}
