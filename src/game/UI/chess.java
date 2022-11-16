package game.UI;

public class chess {
    public static final String nullPiece = "    ";

    public static final String WhitePawn = " ♙  ";
    public static final String WhiteRook = " ♖  ";
    public static final String WhiteKnight = " ♘  ";
    public static final String WhiteBishop = " ♗  ";
    public static final String WhiteQueen = " ♕  ";
    public static final String WhiteKing = " ♔  ";

    public static final String BlackPawn = " ♟  ";
    public static final String BlackRook = " ♜　";
    public static final String BlackKnight = " ♞  ";
    public static final String BlackBishop = " ♝  ";
    public static final String BlackQueen = " ♛  ";
    public static final String BlackKing = " ♚  ";

    public static final String[] WhitePiece = {WhitePawn, WhiteRook, WhiteKnight, WhiteBishop, WhiteQueen, WhiteKing};
    public static final String[] BlackPiece = {BlackPawn, BlackRook, BlackKnight, BlackBishop, BlackQueen, BlackKing};
    public static final String[] Piece = {"Pawn", "Rook", "Knight", "Bishop", "Queen", "King"};

    public static String[][] chessboard =
    {
            { BlackRook, BlackKnight, BlackBishop, BlackQueen, BlackKing, BlackBishop, BlackKnight, BlackRook },
            { BlackPawn, BlackPawn, BlackPawn, BlackPawn, BlackPawn, BlackPawn, BlackPawn, BlackPawn, BlackPawn },
            { nullPiece, nullPiece, nullPiece, nullPiece, nullPiece, nullPiece, nullPiece, nullPiece },
            { nullPiece, nullPiece, nullPiece, nullPiece, nullPiece, nullPiece, nullPiece, nullPiece },
            { nullPiece, nullPiece, nullPiece, nullPiece, nullPiece, nullPiece, nullPiece, nullPiece },
            { nullPiece, nullPiece, nullPiece, nullPiece, nullPiece, nullPiece, nullPiece, nullPiece },
            { WhitePawn, WhitePawn, WhitePawn, WhitePawn, WhitePawn, WhitePawn, WhitePawn, WhitePawn },
            { WhiteRook, WhiteKnight, WhiteBishop, WhiteQueen, WhiteKing, WhiteBishop, WhiteKnight, WhiteRook }
    };

    public chess(){
        String board[][] = this.chessboard;
    }

    
    public static void Swap(int now_x, int now_y, int next_x, int next_y, String Piece){
        chessboard[next_y][next_x] = Piece;
        chessboard[now_y][now_x] = nullPiece;
    }
}