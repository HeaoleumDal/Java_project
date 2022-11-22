package decision_make;
import game.UI.chess;

public class Black_Decision {
    private int[][] Import_Board;

    public void BlackImporting_Board(String[][] CI_Board){
        for(int i = 0; i< 8;i++){
            for(int j = 0;j<8;j++){
                if(CI_Board[i][j] == chess.WhitePawn) Import_Board[i][j]=1;
                else if(CI_Board[i][j] == chess.BlackPawn) Import_Board[i][j]=-1; // Pawn

                else if(CI_Board[i][j] == chess.WhiteRook) Import_Board[i][j]=3;
                else if(CI_Board[i][j] == chess.BlackRook) Import_Board[i][j]=-3; // Rook

                else if(CI_Board[i][j] == chess.WhiteKnight) Import_Board[i][j]=2;
                else if(CI_Board[i][j] == chess.BlackKnight) Import_Board[i][j]=-2; // Knight

                else if(CI_Board[i][j] == chess.WhiteBishop) Import_Board[i][j]=2;
                else if(CI_Board[i][j] == chess.BlackBishop) Import_Board[i][j]=-2; //Bishop 

                else if(CI_Board[i][j] == chess.WhiteQueen) Import_Board[i][j]=5;
                else if(CI_Board[i][j] == chess.BlackQueen) Import_Board[i][j]=-5; // Queen

                else if(CI_Board[i][j] == chess.WhiteKing) Import_Board[i][j]=6;
                else if(CI_Board[i][j] == chess.BlackKing) Import_Board[i][j]=-6; // King
                
            }
        }
    }
}
