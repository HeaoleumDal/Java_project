package game.Piece;
import game.location.*;
import java.util.*;

public class promotion{
    Location location = new Location();
    Scanner sc = new Scanner(System.in);
    String Piece = new String();
    public void Promotion(int x, int y, String Color) {
        Boolean ErrorPiece = false;
        if(Color == "White" && y == 0) {
            do {
                System.out.println("=============================================");
                System.out.println("어느 기물로 승진하시겠습니까?");
                System.out.println("Rook, Knight, Bishop, Queen");
                System.out.print("> ");
                Piece = sc.nextLine();
                if(Piece.equals("Rook") || Piece.equals("rook")) {
                    game.UI.chess.chessboard[y][x] = game.UI.chess.WhiteRook;
                }
                else if(Piece.equals("Knight") || Piece.equals("knight")) {
                    game.UI.chess.chessboard[y][x] = game.UI.chess.WhiteKnight;
                }
                else if(Piece.equals("Bishop") || Piece.equals("bishop")) {
                    game.UI.chess.chessboard[y][x] = game.UI.chess.WhiteBishop;
                }
                else if(Piece.equals("Queen") || Piece.equals("queen")) {
                    game.UI.chess.chessboard[y][x] = game.UI.chess.WhiteQueen;
                }
                else {
                    ErrorPiece = true;
                }
                Piece = "";
            } while (ErrorPiece);
        }
        else if(Color == "Black" && y == 7) {
            do {
                System.out.println("=============================================");
                System.out.println("어느 기물로 승진하시겠습니까?");
                System.out.println("Rook, Knight, Bishop, Queen");
                System.out.print("> ");
                Piece = sc.nextLine();
                if(Piece.equals("Rook") || Piece.equals("rook")) {
                    game.UI.chess.chessboard[y][x] = game.UI.chess.BlackRook;
                }
                else if(Piece.equals("Knight") || Piece.equals("knight")) {
                    game.UI.chess.chessboard[y][x] = game.UI.chess.BlackKnight;
                }
                else if(Piece.equals("Bishop") || Piece.equals("bishop")) {
                    game.UI.chess.chessboard[y][x] = game.UI.chess.BlackBishop;
                }
                else if(Piece.equals("Queen") || Piece.equals("queen")) {
                    game.UI.chess.chessboard[y][x] = game.UI.chess.BlackQueen;
                }
                else {
                    ErrorPiece = true;
                }
            } while (ErrorPiece);
        }
    }
}
