public class main{
    public static void main(String[] args){
        String nullpiece = "    ";
        String WhitePawn = " ♙  ";
        String WhiteRook = " ♖  ";
        String WhiteKnight = " ♘  ";
        String WhiteBishop = " ♗  ";
        String WhiteQueen = " ♕  ";
        String WhiteKing = " ♔  ";

        String BlackRook = " ♜　";
        String BlackKngiht = " ♞  ";
        String BlackBishop = " ♝  ";
        String BlackQueen = " ♛  ";
        String BlackKing = " ♚  ";
        String BlackPawn = " ♟  ";

        String[][] chess = {
            {WhiteRook, WhiteKnight, WhiteBishop, WhiteQueen, WhiteKing, WhiteBishop, WhiteKnight, WhiteRook},
            {WhitePawn, WhitePawn, WhitePawn, WhitePawn, WhitePawn, WhitePawn, WhitePawn, WhitePawn},
            {nullpiece, nullpiece, nullpiece, nullpiece, nullpiece, nullpiece, nullpiece, nullpiece},
            {nullpiece, nullpiece, nullpiece, nullpiece, nullpiece, nullpiece, nullpiece, nullpiece},
            {nullpiece, nullpiece, nullpiece, nullpiece, nullpiece, nullpiece, nullpiece, nullpiece},
            {nullpiece, nullpiece, nullpiece, nullpiece, nullpiece, nullpiece, nullpiece, nullpiece},
            {BlackPawn, BlackPawn, BlackPawn, BlackPawn, BlackPawn, BlackPawn, BlackPawn, BlackPawn},
            {BlackRook, BlackKngiht, BlackBishop, BlackQueen, BlackKing, BlackBishop, BlackKngiht, BlackRook}
        };
    }
}