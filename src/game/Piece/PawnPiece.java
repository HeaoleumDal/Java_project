package game.Piece;
import game.UI.chess;
import game.location.Location;

public class PawnPiece{
    check check = new check();
    Location location = new Location();
    promotion promotion = new promotion();
    mate checkmate = new mate();

    public boolean WhitePawnMove(int now_x, int now_y, int next_x, int next_y) {
        String BeforePiece = location.LocationPiece(next_x, next_y);
        Boolean NextIsNull = true;
        if(enpassant.Enpassant(now_x, now_y, next_x, next_y)){
            chess.Swap(now_x, now_y, next_x, next_y, chess.WhitePawn);
            if(check.Check("White") == "White"){
                chess.Swap(next_x, next_y, now_x, now_y, chess.WhitePawn);
                chess.chessboard[next_y][next_x] = BeforePiece;
                return false;
            }
            chess.chessboard[next_y+1][next_x] = chess.nullPiece;
            checkmate.Checkmate("Black");
            return true;
        }
        if(PawnCatch(now_x, now_y, next_x, next_y)){
            chess.Swap(now_x, now_y, next_x, next_y, chess.WhitePawn);
            if(check.Check("White") == "White"){
                chess.Swap(next_x, next_y, now_x, now_y, chess.WhitePawn);
                chess.chessboard[next_y][next_x] = BeforePiece;
                return false;
            }
            promotion.Promotion(next_x, next_y, "White");
            checkmate.Checkmate("Black");
            return true;
        }
        if(now_x != next_x){
            return false;
        }
        for(int i = now_y - 1; i >= next_y; i--){
            if(location.LocationIsNull(next_x, i)){
                NextIsNull = true;
            }
            else{
                NextIsNull = false;
                break;
            }
        }
        if(NextIsNull){
            if(now_y == 6){
                if(now_y - next_y < 3 && now_y - next_y > 0 && location.LocationIsNull(next_x, next_y)){
                    chess.Swap(now_x, now_y, next_x, next_y, chess.WhitePawn);
                    if(check.Check("White") == "White"){
                        chess.Swap(next_x, next_y, now_x, now_y, chess.WhitePawn);
                        chess.chessboard[next_y][next_x] = BeforePiece;
                        return false;
                    }
                    if(Math.abs(now_y - next_y) == 2){
                        enpassant.white_before_x = now_x;
                        enpassant.white_before_y = now_y;
                        enpassant.white_now_x = next_x;
                        enpassant.white_now_y = next_y;
                    }
                    checkmate.Checkmate("Black");
                    return true;
                }
            }
            else{
                if(now_y - next_y < 2 && now_y - next_y > 0 && location.LocationIsNull(next_x, next_y)){
                    chess.Swap(now_x, now_y, next_x, next_y, chess.WhitePawn);
                    if(check.Check("White") == "White"){
                        chess.Swap(next_x, next_y, now_x, now_y, chess.WhitePawn);
                        chess.chessboard[next_y][next_x] = BeforePiece;
                        return false;
                    }
                    promotion.Promotion(next_x, next_y, "White");
                    checkmate.Checkmate("Black");
                    return true;
                }
            }
            return false;
        }
        else{
            return false;
        }
    }

    public Boolean BlackPawnMove(int now_x, int now_y, int next_x, int next_y){
        String BeforePiece = location.LocationPiece(next_x, next_y);
        Boolean NextIsNull = true;
        if(enpassant.Enpassant(now_x, now_y, next_x, next_y)){
            chess.Swap(now_x, now_y, next_x, next_y, chess.BlackPawn);
            if(check.Check("Black") == "Black"){
                chess.Swap(next_x, next_y, now_x, now_y, chess.BlackPawn);
                chess.chessboard[next_y][next_x] = BeforePiece;
                return false;
            }
            chess.chessboard[next_y-1][next_x] = chess.nullPiece;
            checkmate.Checkmate("White");
            return true;
        }
        if(PawnCatch(now_x, now_y, next_x, next_y)){
            chess.Swap(now_x, now_y, next_x, next_y, chess.BlackPawn);
            if(check.Check("Black") == "Black"){
                chess.Swap(next_x, next_y, now_x, now_y, chess.BlackPawn);
                chess.chessboard[next_y][next_x] = BeforePiece;
                return false;
            }
            promotion.Promotion(next_x, next_y, "Black");
            checkmate.Checkmate("White");
            return true;
        }
        if(now_x != next_x){
            return false;
        }
        for(int i = now_y + 1; i <= next_y; i++){
            if(location.LocationIsNull(next_x, i)){
                NextIsNull = true;
            }
            else{
                NextIsNull = false;
                break;
            }
        }
        if(NextIsNull){
            if(now_y == 1){
                if(next_y - now_y < 3 && next_y - now_y > 0 && location.LocationIsNull(next_x, next_y)){
                    chess.Swap(now_x, now_y, next_x, next_y, chess.BlackPawn);
                    if(check.Check("Black") == "Black"){
                        chess.Swap(next_x, next_y, now_x, now_y, chess.BlackPawn);
                        chess.chessboard[next_y][next_x] = BeforePiece;
                        return false;
                    }
                    if(Math.abs(now_y - next_y) == 2){
                        enpassant.black_before_x = now_x;
                        enpassant.black_before_y = now_y;
                        enpassant.black_now_x = next_x;
                        enpassant.black_now_y = next_y;
                    }
                    checkmate.Checkmate("White");
                    return true;
                }
            }
            else{
                if(next_y - now_y < 2 && next_y - now_y > 0 && location.LocationIsNull(next_x, next_y)){
                    chess.Swap(now_x, now_y, next_x, next_y, chess.BlackPawn);
                    if(check.Check("Black") == "Black"){
                        chess.Swap(next_x, next_y, now_x, now_y, chess.BlackPawn);
                        chess.chessboard[next_y][next_x] = BeforePiece;
                        return false;
                    }
                    promotion.Promotion(next_x, next_y, "Black");
                    checkmate.Checkmate("White");
                    return true;
                }
            }
            return false;
        }
        else{
            return false;
        }
    }

    public Boolean PawnCatch(int now_x, int now_y, int next_x, int next_y){
        String Color = location.LocationColor(now_x, now_y);

        if(!location.LocationIsNull(next_x, next_y)){
            if(Color == "White"){
                if(Math.abs(now_x - next_x) == 1 && now_y - next_y == 1){
                    if(location.LocationColor(next_x, next_y) != Color){
                        return true;
                    }
                }
            }
            else if(Color == "Black"){
                if(Math.abs(now_x - next_x) == 1 && next_y - now_y == 1){
                    if(location.LocationColor(next_x, next_y) != Color){
                        return true;
                    }
                }
            }
        }
        return false;
    }
}