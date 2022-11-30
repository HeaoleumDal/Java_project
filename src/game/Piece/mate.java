package game.Piece;

import game.UI.*;
import game.location.Location;


public class mate {
    BoardDrawing board = new BoardDrawing();
    public static String CHECKMATE = "";
    Location location = new Location();
    String Null = "X";
    String toKing = "O";
    String King = "K";

    public void Checkmate(String Color){
        String[][] to_King = reverseKing(Color);

        for(int i = 0; i < 8; i++){
            for(int j = 0; j < 8; j++){
                if(!location.LocationIsNull(j, i)){
                    if(Color == "White"){
                        if(check.black_checkboard[j][i] != check.CanMove && to_King[j][i] == toKing){
                            System.out.print("\nBlack Win");
                            board.DrawChessBoard();
                            System.exit(0);
                        }
                    }
                    else if(Color == "Black"){
                        if(check.white_checkboard[j][i] != check.CanMove && to_King[j][i] == toKing){
                            System.out.print("\nWhite Win");
                            board.DrawChessBoard();
                            System.exit(0);
                        }
                    }
                }
            }
        }
    }

    public void Stalemate(int x, int y){

    }

    /**
     * 
     * @return 킹에게 갈 수 있는 모든 경로를 저장한 2차원 배열을 반환함
     */
    public String[][] reverseKing(String Color){ 
        String[][] to_King = {
            {Null, Null, Null, Null, Null, Null, Null, Null},
            {Null, Null, Null, Null, Null, Null, Null, Null},
            {Null, Null, Null, Null, Null, Null, Null, Null},
            {Null, Null, Null, Null, Null, Null, Null, Null},
            {Null, Null, Null, Null, Null, Null, Null, Null},
            {Null, Null, Null, Null, Null, Null, Null, Null},
            {Null, Null, Null, Null, Null, Null, Null, Null},
            {Null, Null, Null, Null, Null, Null, Null, Null}
        };
        int[] position = new int[2]; 
        int x, y;
        if(Color == "White"){
            position = location.PiecePosition(chess.WhiteKing);
        }
        else if(Color == "Black"){
            position = location.PiecePosition(chess.BlackKing);
        }
        x = position[0];
        y = position[1];
        int xDiff = 8 - x;
        int yDiff = 8 - y;
        to_King[y][x] = King;
        // 룩 or 퀸 상하좌우
        for(int i = x + 1; i < 8; i++){
            if(!location.LocationIsNull(i, y)){
                if(location.LocationColor(i, y) != Color){
                    to_King[y][i] = toKing;
                }
                break;
            }
            else if(location.LocationIsNull(i, y)){
                to_King[y][i] = toKing;
            }
        }
        for(int i = x - 1; i >= 0; i--){
            if(!location.LocationIsNull(i, y)){
                if(location.LocationColor(i, y) != Color){
                    to_King[y][i] = toKing;
                }
                break;
            }
            else if(location.LocationIsNull(i, y)){
                to_King[y][i] = toKing;
            }
        }
        for(int i = y + 1; i < 8; i++){
            if(!location.LocationIsNull(x, i)){
                if(location.LocationColor(x, i) != Color){
                    to_King[i][x] = toKing;
                }
                break;
            }
            else if(location.LocationIsNull(x, i)){
                to_King[i][x] = toKing;
            }
        }
        for(int i = y - 1; i >= 0; i--){
            if(!location.LocationIsNull(x, i)){
                if(location.LocationColor(x, i) != Color){
                    to_King[i][x] = toKing;
                }
                break;
            }
            else if(location.LocationIsNull(x, i)){
                to_King[i][x] = toKing;
            }
        }
        // 비숍 or 퀸 대각선 or 폰 catch
        if(xDiff >= y){
            for(int i = 1; i < 8; i++){
                if(y - i >= 0){
                    if(location.LocationIsNull(x + i, y - i)){
                        to_King[y - i][x + i] = toKing;
                    }
                    else if(!location.LocationIsNull(x + i, y - i) && location.LocationColor(x + i, y - i) != Color){
                        to_King[y - i][x + i] = toKing;
                        break;
                    }
                    else{
                        break;
                    }
                }
                else{
                    break;
                }
            }
        }
        else if(xDiff < y){
            for(int i = 1; i < 8; i++){
                if(x + i < 8){
                    if(location.LocationIsNull(x + i, y - i)){
                        to_King[y - i][x + i] = toKing;
                    }
                    else if(!location.LocationIsNull(x + i, y - i) && location.LocationColor(x + i, y - i) != Color){
                        to_King[y - i][x + i] = toKing;
                        break;
                    }
                    else{
                        break;
                    }
                }
                else{
                    break;
                }
            }
        }
        if(xDiff >= yDiff){
            for(int i = 1; i < 8; i++){
                if(y + i < 8){
                    if(location.LocationIsNull(x + i, y + i)){
                        to_King[y + i][x + i] = toKing;
                    }
                    else if(!location.LocationIsNull(x + i, y + i) && location.LocationColor(x + i, y + i) != Color){
                        to_King[y + i][x + i] = toKing;
                        break;
                    }
                    else{
                        break;
                    }
                }
                else{
                    break;
                }
            }
        }
        else if(xDiff < yDiff){
            for(int i = 1; i < 8; i++){
                if(x + i < 8){
                    if(location.LocationIsNull(x + i, y + i)){
                        to_King[y + i][x + i] = toKing;
                    }
                    else if(!location.LocationIsNull(x + i, y + i) && location.LocationColor(x + i, y + i) != Color){
                        to_King[y + i][x + i] = toKing;
                        break;
                    }
                    else{
                        break;
                    }
                }
            }
        }
        if(x >= yDiff){
            for(int i = 1; i < 8; i++){
                if(y + i < 0){
                    if(location.LocationIsNull(x - i, y + i)){
                        to_King[y + i][x - i] = toKing;
                    }
                    else if(!location.LocationIsNull(x - i, y + i) && location.LocationColor(x - i, y + i) != Color){
                        to_King[y + i][x - i] = toKing;
                        break;
                    }
                    else{
                        break;
                    }
                }
                else{
                    break;
                }
            }
        }
        else if(x < yDiff){
            for(int i = 1; i < 8; i++){
                if(x - i >= 0){
                    if(location.LocationIsNull(x - i, y + i)){
                        to_King[y + i][x - i] = toKing;
                    }
                    else if(!location.LocationIsNull(x - i, y + i) && location.LocationColor(x - i, y + i) != Color){
                        to_King[y + i][x - i] = toKing;
                        break;
                    }
                    else{
                        break;
                    }
                }
                else{
                    break;
                }
            }
        }
        if(x >= y){
            for(int i = 1; i < 8; i++){
                if(y - i >= 0){
                    if(location.LocationIsNull(x - i, y - i)){
                        to_King[y - i][x - i] = toKing;
                    }
                    else if(!location.LocationIsNull(x - i, y - i) && location.LocationColor(x - i, y - i) != Color){
                        to_King[y - i][x - i] = toKing;
                        break;
                    }
                    else{
                        break;
                    }
                }
                else{
                    break;
                }
            }
        }
        else if(x < y){
            for(int i = 1; i < 8; i++){
                if(x - i >= 0){
                    if(location.LocationIsNull(x - i, y - i)){
                        to_King[y - i][x - i] = toKing;
                    }
                    else if(!location.LocationIsNull(x - i, y - i) && location.LocationColor(x - i, y - i) != Color){
                        to_King[y - i][x - i] = toKing;
                        break;
                    }
                    else{
                        break;
                    }
                }
            }
        }
        // 나이트
        if(x + 1 < 8 && y - 2 >= 0){ // 1시
            if(location.LocationColor(x + 1, y - 2) != Color){
                to_King[y - 2][x + 1] = toKing;   
            }
        }
        if(x + 2 < 8 && y - 1 >= 0){ // 2시
            if(location.LocationColor(x + 2, y - 1) != Color){
                to_King[y - 1][x + 2] = toKing;
            }
        }
        if(x + 2 < 8 && y + 1 < 8){ // 4시
            if(location.LocationColor(x + 2, y + 1) != Color){
                to_King[y + 1][x + 2] = toKing;
            }
        }
        if(x + 1 < 8 && y + 2 < 8){ // 5시
            if(location.LocationColor(x + 1, y + 2) != Color){
                to_King[y + 2][x + 1] = toKing;
            }
        }
        if(x - 1 >= 0 && y + 2 < 8){ // 7시
            if(location.LocationColor(x - 1, y + 2) != Color){
                to_King[y + 2][x - 1] = toKing;
            }
        }
        if(x - 2 >= 0 && y + 1 < 8){ // 8시
            if(location.LocationColor(x - 2, y + 1) != Color){
                to_King[y + 1][x - 2] = toKing;
            }
        }
        if(x - 2 >= 0 && y - 1 >= 0){ // 10시
            if(location.LocationColor(x - 2, y - 1) != Color){
                to_King[y - 1][x - 2] = toKing;
            }
        }
        if(x - 1 >= 0 && y - 2 >= 0){ // 11시
            if(location.LocationColor(x - 1, y - 2) != Color){
                to_King[y - 2][x - 1] = toKing;
            }
        }
        return to_King;
    }

}
