package decision_make;
import game.UI.chess;
import game.location.Location;
import decision_make.Decision_Making;

public class Black_Decision {
    private int[][] Import_Board;
    private int[][] Settlexy = new int[20][2];
    private int Each_Max; // 각 말들이 가질 수 있는 최대값
    private int Max; // 각 팀에서 가질 수 있는 최대값
    private int Max_x, Max_y;
    public int count = 0;
    Location location = new Location();

    public void BlackImporting_Board(String[][] CI_Board) {
        count = 0;
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                Importing_Board(i, j, CI_Board);
                Settling_Board(i, j);
            }
        }
    }

    public void Importing_Board(int i, int j, String[][] CI_Board) {
        if (CI_Board[i][j] == chess.WhitePawn)
            Import_Board[i][j] = 1;
        else if (CI_Board[i][j] == chess.BlackPawn)
            Import_Board[i][j] = -1; // Pawn

        else if (CI_Board[i][j] == chess.WhiteRook)
            Import_Board[i][j] = 3;
        else if (CI_Board[i][j] == chess.BlackRook)
            Import_Board[i][j] = -3; // Rook

        else if (CI_Board[i][j] == chess.WhiteKnight)
            Import_Board[i][j] = 2;
        else if (CI_Board[i][j] == chess.BlackKnight)
            Import_Board[i][j] = -2; // Knight

        else if (CI_Board[i][j] == chess.WhiteBishop)
            Import_Board[i][j] = 2;
        else if (CI_Board[i][j] == chess.BlackBishop)
            Import_Board[i][j] = -2; // Bishop

        else if (CI_Board[i][j] == chess.WhiteQueen)
            Import_Board[i][j] = 5;
        else if (CI_Board[i][j] == chess.BlackQueen)
            Import_Board[i][j] = -5; // Queen

        else if (CI_Board[i][j] == chess.WhiteKing)
            Import_Board[i][j] = 6;
        else if (CI_Board[i][j] == chess.BlackKing)
            Import_Board[i][j] = -6; // King
    }

    public void Settling_Board(int i, int j){
        if(location.LocationPiece(i, j) == chess.BlackPawn){
            Settlexy[count][0] = i;
            Settlexy[count++][1] = j;
        }
        else if(location.LocationPiece(i, j) == chess.BlackRook){
            Settlexy[count][0] = i;
            Settlexy[count++][1] = j;
        }
        else if(location.LocationPiece(i, j) == chess.BlackKnight){
            Settlexy[count][0] = i;
            Settlexy[count++][1] = j;
        }
        else if(location.LocationPiece(i, j) == chess.BlackBishop){
            Settlexy[count][0] = i;
            Settlexy[count++][1] = j;
        }
        else if(location.LocationPiece(i, j) == chess.BlackQueen){
            Settlexy[count][0] = i;
            Settlexy[count++][1] = j;
        }
        else if(location.LocationPiece(i, j) == chess.BlackKing){
            Settlexy[count][0] = i;
            Settlexy[count++][1] = j;
        }
    }
}
