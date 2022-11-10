package game.UI;

public class chess {
    public final String nullPiece = "    ";

    public final String WhitePawn = " ♙  ";
    public final String WhiteRook = " ♖  ";
    public final String WhiteKnight = " ♘  ";
    public final String WhiteBishop = " ♗  ";
    public final String WhiteQueen = " ♕  ";
    public final String WhiteKing = " ♔  ";

    public final String BlackPawn = " ♟  ";
    public final String BlackRook = " ♜　";
    public final String BlackKnight = " ♞  ";
    public final String BlackBishop = " ♝  ";
    public final String BlackQueen = " ♛  ";
    public final String BlackKing = " ♚  ";

    public final String[] WhitePiece = {WhitePawn, WhiteRook, WhiteKnight, WhiteBishop, WhiteQueen, WhiteKing};
    public final String[] BlackPiece = {BlackPawn, BlackRook, BlackKnight, BlackBishop, BlackQueen, BlackKing};
    public final String[] Piece = {"Pawn", "Rook", "Knight", "Bishop", "Queen", "King"};

    public String[][] chessboard =
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
}