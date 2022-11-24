package decision_make;
import game.UI.chess;
import game.location.Location;

public class Decision_Making {
    private int[] Current_Piece_Import;
    private int[] NPX;
    private int[] NPY;
    private int[][] Import_Board; // 말의 저장도가 저장되어 있는 보드
    public int[][] Chess_Current_Board; //  탐색이 끝난 말의 중요도가 저장되어 있는 부드
    Location location = new Location();

    public boolean CanMove(int now_dx, int now_dy, int next_dx, int next_dy, String[][] Board){

        if((next_dx >= 0 || next_dx <= 7) && (next_dy >= 0 || next_dy <= 7)){
            // Pawn Move
            if(location.LocationPiece(now_dx,now_dy) == chess.BlackPawn){
                if((now_dy - 1 == next_dy)){
                    return true;
                }
                else if((now_dy - 2 == next_dy && now_dy == 1)) return true;
            }
            if(location.LocationPiece(now_dx,now_dy) == chess.WhitePawn){
                if((now_dy - 1 == next_dy)){
                    return true;
                }
                else if((now_dy - 2 == next_dy && now_dy == 6)) return true;
            }
    
            // Rook Move
            if(location.LocationPiece(now_dx,now_dy) == chess.BlackRook || location.LocationPiece(now_dx,now_dy) == chess.WhiteRook){
                for(int i=1;i<=7;i++){
                    if(now_dx + i == next_dx && now_dx + i <= 7) return true;
                    if(now_dx - i == next_dx && now_dx - i >= 0) return true;
                    if(now_dy + i == next_dy && now_dy + i <= 7) return true;
                    if(now_dy - i == next_dy && now_dy - i >= 0) return true;
                }
            }
            // Knight Move
            if(location.LocationPiece(now_dx,now_dy) == chess.BlackKnight || location.LocationPiece(now_dx,now_dy) == chess.WhiteKnight){
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
            if(location.LocationPiece(now_dx,now_dy) == chess.BlackBishop || location.LocationPiece(now_dx,now_dy) == chess.WhiteBishop){
                for(int i=1;i<=7;i++){
                    if((now_dx + i == next_dx && now_dx + i <= 7) && (now_dy + i == next_dy && now_dy + i <= 7)) return true; // 아래로, 오른쪽 - 4 사분면
                    if((now_dx - i == next_dx && now_dx - i >= 0) && (now_dy + i == next_dy && now_dy + i <= 7)) return true; // 위로, 오른쪽 - 1 사분면
                    if((now_dx + i == next_dx && now_dx + i <= 7) && (now_dy - i == next_dy && now_dy - i >= 0)) return true; // 아래로, 왼쪽 - 3 사분면
                    if((now_dx - i == next_dx && now_dx - i >= 0) && (now_dy - i == next_dy && now_dy - i >= 0)) return true; // 위로, 왼쪽 - 2 사분면
                }
            }
            // Queen
            if(location.LocationPiece(now_dx,now_dy) == chess.BlackQueen || location.LocationPiece(now_dx,now_dy) == chess.WhiteQueen){
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
            if(location.LocationPiece(now_dx,now_dy) == chess.BlackKing && location.LocationPiece(now_dx,now_dy) == chess.WhiteKing){
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
    //location.NowLocationPiece() // 현재위치
    //location.NextLocationPiece() // 나중위치
    // public void clear(){
    //     Import_Board = new int[8][8];
    //     Current_Piece_Import = new int[8];
    //     Chess_Current_Board = new int[8][8];
    //     NPX = new int[20];
    //     NPY = new int[20];
    // }

    // public void Each_Search(){

    // }

    // public void All_Each_Search(){
    //     int max = 0;
    //     for(int i = 0;i<8;i++){
    //         Each_Search();
    //         //if(max < )
    //     }
    // }

    // public int Each_Search(int cX, int cY){ // 이걸 for문으로 여러번 반복
    //     int important = 0;
    //     // 탐색 진행
    //     return important;
    // }

    // public void All_Search(){
    //     int max = 0;
    //     for(int i = 0; i< 8;i++){
    //         for(int j = 0; j< 8;j++){
    //             //if()
    //         }
    //     }
    // }
}
