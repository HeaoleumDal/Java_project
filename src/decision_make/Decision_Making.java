package decision_make;
import game.UI.chess;

public class Decision_Making {
    private int[] Current_Piece_Import;
    private int[] NPX;
    private int[] NPY;
    private int[][] Import_Board; // 말의 저장도가 저장되어 있는 보드
    public int[][] Chess_Current_Board; //  탐색이 끝난 말의 중요도가 저장되어 있는 부드

    //location.NowLocationPiece() // 현재위치
    //location.NextLocationPiece() // 나중위치

    public void clear(){
        Import_Board = new int[8][8];
        Current_Piece_Import = new int[8];
        Chess_Current_Board = new int[8][8];
        NPX = new int[20];
        NPY = new int[20];
    }

    public void Each_Search(){
        
    }

    public void All_Each_Search(){
        int max = 0;
        for(int i = 0;i<8;i++){
            Each_Search();
            //if(max < )
        }
    }

    public void Importing_Board(String[][] CI_Board){
        for(int i = 0; i< 8;i++){
            for(int j = 0;j<8;j++){
                if(CI_Board[i][j] == chess.WhitePawn || CI_Board[i][j] == chess.BlackPawn) Import_Board[i][j]=1;
                else if(CI_Board[i][j] == chess.WhiteRook || CI_Board[i][j] == chess.BlackRook) Import_Board[i][j]=2;
                else if(CI_Board[i][j] == chess.WhiteKnight || CI_Board[i][j] == chess.BlackKnight) Import_Board[i][j]=3;
                else if(CI_Board[i][j] == chess.WhiteBishop || CI_Board[i][j] == chess.BlackBishop) Import_Board[i][j]=4;
                else if(CI_Board[i][j] == chess.WhiteQueen || CI_Board[i][j] == chess.BlackQueen) Import_Board[i][j]=5;
                else if(CI_Board[i][j] == chess.WhiteKing || CI_Board[i][j] == chess.BlackKing) Import_Board[i][j]=6;
                   
            }
        }
    }

    public int Each_Search(int cX, int cY){ // 이걸 for문으로 여러번 반복
        int important = 0;
        // 탐색 진행
        return important;
    }

    public void All_Search(){
        int max = 0;
        for(int i = 0; i< 8;i++){
            for(int j = 0; j< 8;j++){
                //if()
            }
        }
    }
}
