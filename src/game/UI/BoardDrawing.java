package game.UI;

public class BoardDrawing{
    
    public void DrawChessBoard() {
        StringBuffer board = new StringBuffer();
        board.append("\n");
        board.append("=============================================\n");
        board.append("                     CHESS\n");
        board.append("   ┏━━━━┳━━━━┳━━━━┳━━━━┳━━━━┳━━━━┳━━━━┳━━━━┓\n");
        int ascii = 8;
        for (int i = 0; i < 8; i++)
        {
            board.append(ascii + "  ┃");
            for (int j = 0; j < 8; j++)
            {
                board.append(game.UI.chess.chessboard[i][j] + "┃");
            }
            board.append("\n");
            ascii--;
            board.append("   ");
            if (i != 7)
            {
                board.append("┣━━━━╋━━━━╋━━━━╋━━━━╋━━━━╋━━━━╋━━━━╋━━━━┫\n");
            }
        }
        board.append("┗━━━━┻━━━━┻━━━━┻━━━━┻━━━━┻━━━━┻━━━━┻━━━━┛\n");
        board.append("      A    B    C    D    E    F    G    H\n");
        board.append("=============================================");
        board.append("\n");
        System.out.println(board);
    }
}