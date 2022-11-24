package game.Piece;
import game.UI.pieceMovingUI;
import game.location.Location;

public class PieceMoving {
    Location location = new Location();
    PawnPiece pawn = new PawnPiece();
    BishopPiece bishop = new BishopPiece();
    RookPiece rook = new RookPiece();
    QueenPiece queen = new QueenPiece();
    KnightPiece knight = new KnightPiece();

    public Boolean PieceMove(char char_now_x, char char_now_y, char char_next_x, char char_next_y, String Color){
        int now_x = char_now_x >= 65 && char_now_x <= 72 ? char_now_x - 65 : char_now_x >= 97 && char_now_x <= 104 ? char_now_x - 97 : -1;
        int now_y = 56 - char_now_y;
        int next_x = char_next_x >= 65 && char_next_x <= 72 ? char_next_x - 65 : char_next_x >= 97 && char_next_x <= 104 ? char_next_x - 97 : -1;
        int next_y = 56 - char_next_y;
        String nowPiece = location.LocationPiece(now_x, now_y);
        if(now_x >= 0 && now_x <= 7 && now_y >= 0 && now_y <= 7 && next_x >= 0 && next_y <= 7 ){
            if(Color == "White"){
                if(nowPiece == game.UI.chess.WhitePawn){
                    if(pawn.WhitePawnMove(now_x, now_y, next_x, next_y)){
                        return true;
                    }
                }
                else if(nowPiece == game.UI.chess.WhiteKnight){
                    if(knight.WhiteKnightMove(now_x, now_y, next_x, next_y)){
                        return true;
                    }
        
                }
                else if(nowPiece == game.UI.chess.WhiteBishop){
                    if(bishop.WhiteBishopMove(now_x, now_y, next_x, next_y)){
                        return true;
                    }
                }
                else if(nowPiece == game.UI.chess.WhiteRook){
                    if(rook.WhiteRookMove(now_x, now_y, next_x, next_y)){
                        return true;
                    }
    
                }
                else if(nowPiece == game.UI.chess.WhiteQueen){
                    if(queen.WhiteQueenMove(now_x, now_y, next_x, next_y)){
                        return true;
                    }
                }
                else if(nowPiece == game.UI.chess.WhiteKing){
    
                }
            }
            else if(Color == "Black"){
                if(nowPiece == game.UI.chess.BlackPawn){
                    pawn.BlackPawnMove(now_x, now_y, next_x, next_y);
                }
                else if(nowPiece == game.UI.chess.BlackKnight){
                    if(knight.BlackKnightMove(now_x, now_y, next_x, next_y)){
                        return true;
                    }
                }
                else if(nowPiece == game.UI.chess.BlackBishop){
                    if(bishop.BlackBishopMove(now_x, now_y, next_x, next_y)){
                        return true;
                    }
    
                }
                else if(nowPiece == game.UI.chess.BlackRook){
                    if(rook.BlackRookMove(now_x, now_y, next_x, next_y)){
                        return true;
                    }
    
                }
                else if(nowPiece == game.UI.chess.BlackQueen){
                    if(queen.BlackQueenMove(now_x, now_y, next_x, next_y)){
                        return true;
                    }
                }
                else if(nowPiece == game.UI.chess.BlackKing){
    
                }
            }
        }
        return false;
    }
}
