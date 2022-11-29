package decision_make;
import game.UI.chess;
import game.location.Location;

public class Decision_Making {
    private int[] Current_Piece_Import;
    private int[] NPX;
    private int[] NPY;
    private int[][] Import_Board; // 말의 저장도가 저장되어 있는 보드
    public int[][] Chess_Current_Board; //  탐색이 끝난 말의 중요도가 저장되어 있는 보드
    Location location = new Location();

    public boolean checkEnemy(int x, int y, int color){ // Black = 0, White = 1
      if(color == 0){
        for(int i=0;i<6;i++){
          if(location.LocationPiece(x,y) == chess.WhitePiece[i]) return true;
        }
      }
      else if(color == 1){
        for(int i=0;i<6;i++){
          if(location.LocationPiece(x,y) == chess.BlackPiece[i]) return true;
        }
      }
    }

    public boolean CanMove(int now_dx, int now_dy, int next_dx, int next_dy, String[][] Board){

        if((next_dx >= 0 || next_dx <= 7) && (next_dy >= 0 || next_dy <= 7)){
            // Pawn Move
            if(location.LocationPiece(now_dx,now_dy) == chess.BlackPawn && (checkEnemy(next_dx, next_dy,0) == true)){
                if((now_dy - 1 == next_dy)){
                    return true;
                }
                else if((now_dy - 2 == next_dy && now_dy == 1)) return true;
            }
            if(location.LocationPiece(now_dx,now_dy) == chess.WhitePawn && (checkEnemy(next_dx, next_dy,1) == true)){
                if((now_dy - 1 == next_dy)){
                    return true;
                }
                else if((now_dy - 2 == next_dy && now_dy == 6)) return true;
            }

            // Rook Move
            if((location.LocationPiece(now_dx,now_dy) == chess.BlackRook && checkEnemy(next_dx, next_dy,0) == true) || (location.LocationPiece(now_dx,now_dy) == chess.WhiteRook && checkEnemy(next_dx, next_dy,1) == true)){
                for(int i=1;i<=7;i++){
                    if(now_dx + i == next_dx && now_dx + i <= 7) return true;
                    if(now_dx - i == next_dx && now_dx - i >= 0) return true;
                    if(now_dy + i == next_dy && now_dy + i <= 7) return true;
                    if(now_dy - i == next_dy && now_dy - i >= 0) return true;
                }
            }
            // Knight Move
            if((location.LocationPiece(now_dx,now_dy) == chess.BlackKnight && checkEnemy(next_dx, next_dy,0) == true) || (location.LocationPiece(now_dx,now_dy) == chess.WhiteKnight && checkEnemy(next_dx, next_dy,1) == true)){
                if(now_dx - 2 == next_dx && now_dy - 1 == next_dy) return true;
                if(now_dx - 2 == next_dx && now_dy + 1 == next_dy) return true;
                if(now_dx - 1 == next_dx && now_dy - 2 == next_dy) return true;
                if(now_dx - 1 == next_dx && now_dy + 2 == next_dy) return true;
                if(now_dx + 1 == next_dx && now_dy - 2 == next_dy) return true;
                if(now_dx + 1 == next_dx && now_dy + 2 == next_dy) return true;
                if(now_dx + 2 == next_dx && now_dy - 1 == next_dy) return true;
                if(now_dx + 2 == next_dx && now_dy + 1 == next_dy) return true;
            }
            // Bishop Move
            if((location.LocationPiece(now_dx,now_dy) == chess.BlackBishop && checkEnemy(next_dx, next_dy,0) == true) || (location.LocationPiece(now_dx,now_dy) == chess.WhiteBishop && checkEnemy(next_dx, next_dy,1) == true)){
                for(int i=1;i<=7;i++){
                    if((now_dx + i == next_dx && now_dx + i <= 7) && (now_dy + i == next_dy && now_dy + i <= 7)) return true; // 아래로, 오른쪽 - 4 사분면
                    if((now_dx - i == next_dx && now_dx - i >= 0) && (now_dy + i == next_dy && now_dy + i <= 7)) return true; // 위로, 오른쪽 - 1 사분면
                    if((now_dx + i == next_dx && now_dx + i <= 7) && (now_dy - i == next_dy && now_dy - i >= 0)) return true; // 아래로, 왼쪽 - 3 사분면
                    if((now_dx - i == next_dx && now_dx - i >= 0) && (now_dy - i == next_dy && now_dy - i >= 0)) return true; // 위로, 왼쪽 - 2 사분면
                }
            }
            // Queen
            if((location.LocationPiece(now_dx,now_dy) == chess.BlackQueen && checkEnemy(next_dx, next_dy,0) == true) || (location.LocationPiece(now_dx,now_dy) == chess.WhiteQueen && checkEnemy(next_dx, next_dy,1) == true)){
                for(int i=1;i<=7;i++){
                    if(now_dx + i == next_dx && now_dx + i <= 7) return true; // -y 방향
                    if(now_dx - i == next_dx && now_dx - i >= 0) return true; // +y 방향
                    if(now_dy + i == next_dy && now_dy + i <= 7) return true; // -x 방향
                    if(now_dy - i == next_dy && now_dy - i >= 0) return true; // +x 방향
                    if((now_dx + i == next_dx && now_dx + i <= 7) && (now_dy + i == next_dy && now_dy + i <= 7)) return true; // 아래로, 오른쪽 - 4 사분면
                    if((now_dx - i == next_dx && now_dx - i >= 0) && (now_dy + i == next_dy && now_dy + i <= 7)) return true; // 위로, 오른쪽 - 1 사분면
                    if((now_dx + i == next_dx && now_dx + i <= 7) && (now_dy - i == next_dy && now_dy - i >= 0)) return true; // 아래로, 왼쪽 - 3 사분면
                    if((now_dx - i == next_dx && now_dx - i >= 0) && (now_dy - i == next_dy && now_dy - i >= 0)) return true; // 위로, 왼쪽 - 2 사분면
                }
            }
            //King
            if((location.LocationPiece(now_dx,now_dy) == chess.BlackKing && checkEnemy(next_dx, next_dy,0) == true) || (location.LocationPiece(now_dx,now_dy) == chess.WhiteKing && checkEnemy(next_dx, next_dy,1) == true)){
                if(now_dx + 1 == next_dx && now_dx + 1 <= 7) return true; // -y 방향
                if(now_dx - 1 == next_dx && now_dx - 1 >= 0) return true; // +y 방향
                if(now_dy + 1 == next_dy && now_dy + 1 <= 7) return true; // -x 방향
                if(now_dy - 1 == next_dy && now_dy - 1 >= 0) return true; // +x 방향
                if((now_dx + 1 == next_dx && now_dx + 1 <= 7) && (now_dy + 1 == next_dy && now_dy + 1 <= 7)) return true; // 아래로, 오른쪽 - 4 사분면
                if((now_dx - 1 == next_dx && now_dx - 1 >= 0) && (now_dy + 1 == next_dy && now_dy + 1 <= 7)) return true; // 위로, 오른쪽 - 1 사분면
                if((now_dx + 1 == next_dx && now_dx + 1 <= 7) && (now_dy - 1 == next_dy && now_dy - 1 >= 0)) return true; // 아래로, 왼쪽 - 3 사분면
                if((now_dx - 1 == next_dx && now_dx - 1 >= 0) && (now_dy - 1 == next_dy && now_dy - 1 >= 0)) return true; // 위로, 왼쪽 - 2 사분면
            }
            return false;
        }
        else return false;
    }
}
