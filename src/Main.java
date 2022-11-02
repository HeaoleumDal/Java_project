

public class Main {
    public static void main(String[] args) {   
        StringBuffer board = new StringBuffer();
        board.append("=============================================\n");
        board.append("                     CHESS\n");
        board.append("   ┏━━━━┳━━━━┳━━━━┳━━━━┳━━━━┳━━━━┳━━━━┳━━━━┓\n");
        int j = 72;
        for(int i = 0 ; i < 15 ; i++) 
        {
            if(i % 2 == 0)
            {  
                //65 ~ 72
                while(j > 64)
                {
                    board.append((char)j);
                    board.append("  ");
                    board.append("┃    ┃    ┃    ┃    ┃    ┃    ┃    ┃    ┃\n");
                    j--;
                    break;
                }
            }
            else if(i % 2 != 0)
            {
                board.append("   ");
                board.append("┣━━━━╋━━━━╋━━━━╋━━━━╋━━━━╋━━━━╋━━━━╋━━━━┫\n");
                //break;
            }
        }
        board.append("   ┗━━━━┻━━━━┻━━━━┻━━━━┻━━━━┻━━━━┻━━━━┻━━━━┛\n");
        board.append("      1    2    3    4    5    6    7    8\n");
        board.append("=============================================\n");
        System.out.println(board);
    }
}