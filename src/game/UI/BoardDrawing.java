package game.UI;
import game.UI.chess;

public class BoardDrawing{
    chess chess = new chess();
    
    public void DrawChessBoard() {
        StringBuffer board = new StringBuffer();
        board.append("\n");
        board.append("=============================================\n");
        board.append("                     CHESS\n");
        board.append("   ┏━━━━┳━━━━┳━━━━┳━━━━┳━━━━┳━━━━┳━━━━┳━━━━┓\n");
        int ascii = 72;
        for (int i = 0; i < 8; i++)
        {
            board.append((char) ascii + "  ┃");
            for (int j = 0; j < 8; j++)
            {
                board.append(chess.chessboard[i][j] + "┃");
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
        board.append("      1    2    3    4    5    6    7    8\n");
        board.append("=============================================");
        System.out.println(board);
    }
}