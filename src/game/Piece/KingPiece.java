package game.Piece;
import game.UI.chess;
import game.location.Location;

public class KingPiece {
    Location location = new Location();
    check check = new check();
    castling castling = new castling();
    mate checkmate = new mate();

    public boolean WhiteKingMove(int now_x, int now_y, int next_x, int next_y){
        String BeforePiece = location.LocationPiece(next_x, next_y);
        boolean swap = true;
        if(castling.Castling(now_x, now_y, next_x, next_y)){
            if(next_x > 4){
                BeforePiece = chess.chessboard[7][7];
                chess.Swap(now_x, now_y, next_x, next_y, chess.WhiteKing);
                chess.chessboard[next_y][next_x - 1] = chess.WhiteRook;
                chess.chessboard[7][7] = chess.nullPiece;
                if(check.Check("White") == "White"){
                    chess.Swap(next_x, next_y, now_x, now_y, chess.WhiteKing);
                    chess.chessboard[next_y][next_x - 1] = chess.nullPiece;
                    chess.chessboard[7][7] = chess.WhiteRook;
                    return false;
                }
                checkmate.Checkmate("Black");
                return true;
            }
            else if(next_x < 4){
                BeforePiece = chess.chessboard[7][0];
                chess.Swap(now_x, now_y, next_x, next_y, chess.WhiteKing);
                chess.chessboard[next_y][next_x + 1] = chess.WhiteRook;
                chess.chessboard[7][0] = chess.nullPiece;
                if(check.Check("White") == "White"){
                    chess.Swap(next_x, next_y, now_x, now_y, chess.WhiteKing);
                    chess.chessboard[next_y][next_x + 1] = chess.nullPiece;
                    chess.chessboard[7][0] = chess.WhiteRook;
                    return false;
                }
                checkmate.Checkmate("Black");
                return true;
            }
        }
        if(location.LocationIsNull(next_x, next_y)){
            if(Math.abs(now_x - next_x) == 1 && now_y == next_y){ // 좌우
                chess.Swap(now_x, now_y, next_x, next_y, chess.WhiteKing);
                if(check.Check("White") == "White"){
                    chess.Swap(next_x, next_y, now_x, now_y, chess.WhiteKing);
                    chess.chessboard[next_y][next_x] = BeforePiece;
                    return false;
                }
                checkmate.Checkmate("Black");
            }
            else if(Math.abs(now_y - next_y) == 1 && now_x == next_x){ //상하
                chess.Swap(now_x, now_y, next_x, next_y, chess.WhiteKing);
                if(check.Check("White") == "White"){
                    chess.Swap(next_x, next_y, now_x, now_y, chess.WhiteKing);
                    chess.chessboard[next_y][next_x] = BeforePiece;
                    return false;
                }
                checkmate.Checkmate("Black");
            }
            else if(Math.abs(now_x - next_x) == 1 && Math.abs(now_y - next_y) == 1){ //대각선
                chess.Swap(now_x, now_y, next_x, next_y, chess.WhiteKing);
                if(check.Check("White") == "White"){
                    chess.Swap(next_x, next_y, now_x, now_y, chess.WhiteKing);
                    chess.chessboard[next_y][next_x] = BeforePiece;
                    return false;
                }
                checkmate.Checkmate("Black");
            }
            else{
                swap = false;
            }
        }
        else{
            swap = false;
        }
        return swap;
    }

    public boolean BlackKingMove(int now_x, int now_y, int next_x, int next_y){
        String BeforePiece = location.LocationPiece(next_x, next_y);
        boolean swap = true;
        if(castling.Castling(now_x, now_y, next_x, next_y)){
            if(next_x > 4){
                BeforePiece = chess.chessboard[0][7];
                chess.Swap(now_x, now_y, next_x, next_y, chess.BlackKing);
                chess.chessboard[next_y][next_x - 1] = chess.BlackRook;
                chess.chessboard[0][7] = chess.nullPiece;
                if(check.Check("Black") == "Black"){
                    chess.Swap(next_x, next_y, now_x, now_y, chess.BlackKing);
                    chess.chessboard[next_y][next_x - 1] = chess.nullPiece;
                    chess.chessboard[0][7] = chess.BlackRook;
                    return false;
                }
                checkmate.Checkmate("White");
                return true;
            }
            else if(next_x < 4){
                BeforePiece = chess.chessboard[0][0];
                chess.Swap(now_x, now_y, next_x, next_y, chess.BlackKing);
                chess.chessboard[next_y][next_x + 1] = chess.BlackRook;
                chess.chessboard[0][0] = chess.nullPiece;
                if(check.Check("Black") == "Black"){
                    chess.Swap(next_x, next_y, now_x, now_y, chess.BlackKing);
                    chess.chessboard[next_y][next_x + 1] = chess.nullPiece;
                    chess.chessboard[0][0] = chess.BlackRook;
                    return false;
                }
                checkmate.Checkmate("White");
                return true;
            }
        }
        if(location.LocationIsNull(next_x, next_y)){
            if(Math.abs(now_x - next_x) == 1 && now_y == next_y){ // 좌우
                chess.Swap(now_x, now_y, next_x, next_y, chess.BlackKing);
                if(check.Check("Black") == "Black"){
                    chess.Swap(next_x, next_y, now_x, now_y, chess.BlackKing);
                    chess.chessboard[next_y][next_x] = BeforePiece;
                    return false;
                }
                checkmate.Checkmate("White");
            }
            else if(Math.abs(now_y - next_y) == 1 && now_x == next_x){ //상하
                chess.Swap(now_x, now_y, next_x, next_y, chess.BlackKing);
                if(check.Check("Black") == "Black"){
                    chess.Swap(next_x, next_y, now_x, now_y, chess.BlackKing);
                    chess.chessboard[next_y][next_x] = BeforePiece;
                    return false;
                }
                checkmate.Checkmate("White");
            }
            else if(Math.abs(now_x - next_x) == 1 && Math.abs(now_y - next_y) == 1){ //대각선
                chess.Swap(now_x, now_y, next_x, next_y, chess.BlackKing);
                if(check.Check("Black") == "Black"){
                    chess.Swap(next_x, next_y, now_x, now_y, chess.BlackKing);
                    chess.chessboard[next_y][next_x] = BeforePiece;
                    return false;
                }
                checkmate.Checkmate("White");
            }
            else{
                swap = false;
            }
        }
        else{
            swap = false;
        }
        return swap;
    }
}