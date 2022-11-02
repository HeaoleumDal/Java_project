package game.UI;

public class chess {
    public final String nullpiece = "    ";
    public final String WhitePawn = " ♙  ";
    public final String WhiteRook = " ♖  ";
    public final String WhiteKnight = " ♘  ";
    public final String WhiteBishop = " ♗  ";
    public final String WhiteQueen = " ♕  ";
    public final String WhiteKing = " ♔  ";

    public final String BlackRook = " ♜　";
    public final String BlackKnight = " ♞  ";
    public final String BlackBishop = " ♝  ";
    public final String BlackQueen = " ♛  ";
    public final String BlackKing = " ♚  ";
    public final String BlackPawn = " ♟  ";

    public String[][] chessboard =
    {
            { BlackRook, BlackKnight, BlackBishop, BlackQueen, BlackKing, BlackBishop, BlackKnight, BlackRook },
            { BlackPawn, BlackPawn, BlackPawn, BlackPawn, BlackPawn, BlackPawn, BlackPawn, BlackPawn },
            { nullpiece, nullpiece, nullpiece, nullpiece, nullpiece, nullpiece, nullpiece, nullpiece },
            { nullpiece, nullpiece, nullpiece, nullpiece, nullpiece, nullpiece, nullpiece, nullpiece },
            { nullpiece, nullpiece, nullpiece, nullpiece, nullpiece, nullpiece, nullpiece, nullpiece },
            { nullpiece, nullpiece, nullpiece, nullpiece, nullpiece, nullpiece, nullpiece, nullpiece },
            { WhitePawn, WhitePawn, WhitePawn, WhitePawn, WhitePawn, WhitePawn, WhitePawn, WhitePawn },
            { WhiteRook, WhiteKnight, WhiteBishop, WhiteQueen, WhiteKing, WhiteBishop, WhiteKnight, WhiteRook }
    };
}