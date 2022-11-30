package game.Piece;
import game.UI.*;
import game.location.Location;
public class castling {
    Location location = new Location();

    /**
     * 
     * @param wqr White Queen Rook - 화이트의 퀸쪽 룩
     * @param wkr White King Rook - 화이트의 킹쪽 룩
     * @param bqr Black Queen Rook - 블랙의 퀸쪽 룩
     * @param bkr Black King Rook - 블랙의 킹쪽 룩
     * @param 한 번도 움직인 적이 없다면 false
     * @param white_castling 만약 화이트가 캐슬링에 성공했다면 true
     * @param black_castling 만약 블랙이 캐슬링에 성공했다면 true
     */
    public static boolean wqr, wkr, bqr, bkr, white_king, black_king = false;

    /**
     * 
     * @param x 입력받은 현재 위치의 x 값
     * @param y 입력받은 현재 위치의 y 값
     * 
     * @Note 입력 받을 현재 위치의 기물이 움직였다면 
     */
    public void isMove(int x, int y){
        if(x == 0 && y == 0 && location.LocationPiece(x, y) == chess.BlackRook){ // 왼쪽 위
            bqr = true;
        }
        else if(x == 0 && y == 7 && location.LocationPiece(x, y) == chess.WhiteRook){
            wqr = true;
        }
        else if(x == 7 && y == 0 && location.LocationPiece(x, y) == chess.BlackRook){
            bkr = true;
        }
        else if(x == 7 && y == 0 && location.LocationPiece(x, y) == chess.WhiteRook){
            wkr = true;
        }
        else if(location.LocationPiece(x, y) == chess.WhiteKing){
            white_king = true;
        }
        else if(location.LocationPiece(x, y) == chess.BlackKing){
            black_king = true;
        }
    }

    /**
     * 
     * @param now_x 현재 위치의 x값
     * @param now_y 현재 위치의 y값
     * @param next_x 다음 위치의 x값
     * @param next_y 다음 위치의 y값
     * @return 캐슬링 조건이 만족되었다면 true를 반환
     */
    public boolean Castling(int now_x, int now_y, int next_x, int next_y){
        boolean isCastling = false;
        if(Math.abs(now_x - next_x) == 2 && now_y == next_y){
            if(location.LocationPiece(now_x, now_y) == chess.WhiteKing){
                if(next_x > 4 && location.LocationIsNull(next_x, next_y) && location.LocationIsNull(now_x + 1, next_y)){
                    if(!wkr && !white_king){
                        isCastling = true;
                    }
                }
                else if(next_x < 4 && location.LocationIsNull(next_x, next_y) && location.LocationIsNull(next_x - 1, next_y) && location.LocationIsNull(next_x + 1, next_y)){
                    if(!wqr && !white_king){
                        isCastling = true;
                    }
                }
                else{
                    isCastling = false;
                }
            }
            else if(location.LocationPiece(now_x, now_y) == chess.BlackKing){
                if(next_x > 4 && location.LocationIsNull(next_x, next_y) && location.LocationIsNull(now_x + 1, next_y)){
                    if(!bkr && !black_king){
                        isCastling = true;
                    }
                }
                else if(next_x < 4 && location.LocationIsNull(next_x, next_y) && location.LocationIsNull(next_x - 1, next_y) && location.LocationIsNull(next_x + 1, next_y)){
                    if(!bqr && !black_king){
                        isCastling = true;
                    }
                }
            }
        }
        else{
            isCastling = false;
        }
        return isCastling;
    }
}
