package game.Piece;
import game.UI.*;
import game.location.*;

public class check {
    Location location = new Location();

    static String Null = "N";
    static String CanMove = "O";

    static String[][] white_checkboard = // 화이트의 움직일 수 있는 경로
    {
        {Null, Null, Null, Null, Null, Null, Null, Null},
        {Null, Null, Null, Null, Null, Null, Null, Null},
        {Null, Null, Null, Null, Null, Null, Null, Null},
        {Null, Null, Null, Null, Null, Null, Null, Null},
        {Null, Null, Null, Null, Null, Null, Null, Null},
        {Null, Null, Null, Null, Null, Null, Null, Null},
        {Null, Null, Null, Null, Null, Null, Null, Null},
        {Null, Null, Null, Null, Null, Null, Null, Null}
    };
    static String[][] black_checkboard = // 블랙의 움직일 수 있는 경로
    {
        {Null, Null, Null, Null, Null, Null, Null, Null},
        {Null, Null, Null, Null, Null, Null, Null, Null},
        {Null, Null, Null, Null, Null, Null, Null, Null},
        {Null, Null, Null, Null, Null, Null, Null, Null},
        {Null, Null, Null, Null, Null, Null, Null, Null},
        {Null, Null, Null, Null, Null, Null, Null, Null},
        {Null, Null, Null, Null, Null, Null, Null, Null},
        {Null, Null, Null, Null, Null, Null, Null, Null}
    };

    public String Check(String Color){ // 체크 여부를 판단하는 메서드, Color = 움직일 말의 색깔
        CheckBoard();
        String check = "None"; // 체크가 된 색깔 -> 다음 턴에 잡힐 색깔
        for(int y = 0; y < 8; y++){
            for(int x = 0; x < 8; x++){
                if(Color == "White"){ // 움직일 말의 색깔이 화이트라면
                    if(location.LocationPiece(x, y) == chess.BlackKing && white_checkboard[y][x] == CanMove){ // 상대 말을 잡을 수 있다면
                        check = "Black"; // 블랙이 체크가 됨
                    }
                    else if(location.LocationPiece(x, y) == chess.WhiteKing && black_checkboard[y][x] == CanMove){ // 화이트가 놓은 말이 자충수라면
                        check = "White"; // 화이트가 체크가 됨
                    }
                }
                else if(Color == "Black"){
                    if(location.LocationPiece(x, y) == chess.WhiteKing && black_checkboard[y][x] == CanMove){ // 상대 말을 잡을 수 있다면
                        check = "White"; // 블랙이 체크가 됨
                    }
                    else if(location.LocationPiece(x, y) == chess.BlackKing && white_checkboard[y][x] == CanMove){ // 블랙이 놓은 말이 자충수라면
                        check = "Black"; // 화이트가 체크가 됨
                    }
                }
            }
        }
        if(check != "None"){
            System.out.println(Color + " Check");
        }
        return check;
    }

    public void CheckBoard(){ // 모든 기물의 이동 경로를 파악해 2차원 배열에 저장하는 메서드
        ClearBoard();
        for(int y = 0; y < 8; y++){
            for(int x = 0; x < 8; x++){
                PawnCheck(x, y);
                RookCheck(x, y);
                KnightCheck(x, y);
                BishopCheck(x, y);
                QueenCheck(x, y);
            }
        }
    }

    public void ClearBoard(){
        for(int i = 0; i < 8; i++){
            for(int j = 0; j < 8; j++){
                white_checkboard[j][i] = Null;
                black_checkboard[j][i] = Null;
            }
        }
    }

    public void PawnCheck(int x, int y){ // 잡을 수 있는 경로만 확인함
        if(location.LocationPiece(x, y) == chess.WhitePawn){
            if(x - 1 >= 0 && y - 1 >= 0){
                if(location.LocationColor(x - 1, y - 1) != "White"){
                    white_checkboard[y-1][x-1] = CanMove;
                }
            }
            if(x + 1 <= 7 && y - 1 >= 0){
                if(location.LocationColor(x + 1, y - 1) != "White"){
                    white_checkboard[y-1][x+1] = CanMove;
                }
            }
        }
        else if(location.LocationPiece(x, y) == chess.BlackPawn){
            if(x - 1 >= 0 && y + 1 <= 7){
                if(location.LocationColor(x - 1, y + 1) != "Black"){
                    black_checkboard[y+1][x-1] = CanMove;
                }
            }
            if(x + 1 <= 7 && y + 1 <= 7){
                if(location.LocationColor(x + 1, y + 1) != "Black"){
                    black_checkboard[y+1][x+1] = CanMove;
                }
            }
        }
    }

    public void RookCheck(int x, int y){
        String Color = location.LocationColor(x, y);
        if(location.LocationPiece(x, y) == chess.WhiteRook || location.LocationPiece(x, y) == chess.BlackRook){
            for(int i = x + 1; i < 8; i++){ // 오른쪽으로
                if(!location.LocationIsNull(i, y)){
                    if(location.LocationColor(i, y) != Color){
                        if(Color == "White"){
                            white_checkboard[y][i] = CanMove;
                        }
                        else if(Color == "Black"){
                            black_checkboard[y][i] = CanMove;
                        }
                    }
                    break;
                }
                else if(location.LocationIsNull(i, y) && Color == "White"){
                    white_checkboard[y][i] = CanMove;
                }
                else if(location.LocationIsNull(i, y) && Color == "Black"){
                    black_checkboard[y][i] = CanMove;
                }
            }
            for(int i = x - 1; i >= 0 ; i--){ // 왼쪽으로
                if(!location.LocationIsNull(i, y)){
                    if(location.LocationColor(i, y) != Color){
                        if(Color == "White"){
                            white_checkboard[y][i] = CanMove;
                        }
                        else if(Color == "Black"){
                            black_checkboard[y][i] = CanMove;
                        }
                    }
                    break;
                }
                else if(location.LocationIsNull(i, y) && Color == "White"){
                    white_checkboard[y][i] = CanMove;
                }
                else if(location.LocationIsNull(i, y) && Color == "Black"){
                    black_checkboard[y][i] = CanMove;
                }
            }
            for(int i = y - 1; i >= 0 ; i--){ // 위로
                if(!location.LocationIsNull(x, i)){
                    if(location.LocationColor(x, i) != Color){
                        if(Color == "White"){
                            white_checkboard[i][x] = CanMove;
                        }
                        else if(Color == "Black"){
                            black_checkboard[i][x] = CanMove;
                        }
                    }
                    break;
                }
                else if(location.LocationIsNull(x, i) && Color == "White"){
                    white_checkboard[i][x] = CanMove;
                }
                else if(location.LocationIsNull(x, i) && Color == "Black"){
                    black_checkboard[i][x] = CanMove;
                }
            }
            for(int i = y + 1; i < 8 ; i++){ // 아래로
                if(!location.LocationIsNull(x, i)){
                    if(location.LocationColor(x, i) != Color){
                        if(Color == "White"){
                            white_checkboard[i][x] = CanMove;
                        }
                        else if(Color == "Black"){
                            black_checkboard[i][x] = CanMove;
                        }
                    }
                    break;
                }
                else if(location.LocationIsNull(x, i) && Color == "White"){
                    white_checkboard[i][x] = CanMove;
                }
                else if(location.LocationIsNull(x, i) && Color == "Black"){
                    black_checkboard[i][x] = CanMove;
                }
            }
        }
    }

    public void KnightCheck(int x, int y){
        String Color = location.LocationColor(x, y);
        if(location.LocationPiece(x, y) == chess.WhiteKnight || location.LocationPiece(x, y) == chess.BlackKnight){
            if(x + 1 < 8 && y - 2 >= 0){ // 1시 방향 이동
                if(location.LocationColor(x + 1, y - 2) != Color && Color == "White"){
                    white_checkboard[y - 2][x + 1] = CanMove;
                }
                else if(location.LocationColor(x + 1, y - 2) != Color && Color == "Black"){
                    black_checkboard[y - 2][x + 1] = CanMove;
                }
            }
            if(x + 2 < 8 && y - 1 >= 0){ // 2시 방향 이동
                if(location.LocationColor(x + 2, y - 1) != Color && Color == "White"){
                    white_checkboard[y - 1][x + 2] = CanMove;
                }
                else if(location.LocationColor(x + 2, y - 1) != Color && Color == "Black"){
                    black_checkboard[y - 1][x + 2] = CanMove;
                }
            }
            if(x + 2 < 8 && y + 1 < 8){ // 4시 방향 이동
                if(location.LocationColor(x + 2, y + 1) != Color && Color == "White"){
                    white_checkboard[y + 1][x + 2] = CanMove;
                }
                else if(location.LocationColor(x + 2, y + 1) != Color && Color == "Black"){
                    black_checkboard[y + 1][x + 2] = CanMove;
                }
            }
            if(x + 1 < 8 && y + 2 < 8){ // 5시 방향 이동
                if(location.LocationColor(x + 1, y + 2) != Color && Color == "White"){
                    white_checkboard[y + 2][x + 1] = CanMove;
                }
                else if(location.LocationColor(x + 1, y + 2) != Color && Color == "Black"){
                    black_checkboard[y + 2][x + 1] = CanMove;
                }
            }
            if(x - 1 >= 0 && y + 2 < 8){ // 7시 방향 이동
                if(location.LocationColor(x - 1, y + 2) != Color && Color == "White"){
                    white_checkboard[y + 2][x - 1] = CanMove;
                }
                else if(location.LocationColor(x - 1, y + 2) != Color && Color == "Black"){
                    black_checkboard[y + 2][x - 1] = CanMove;
                }
            }
            if(x - 2 >= 0 && y + 1 < 8){ // 8시 방향 이동
                if(location.LocationColor(x - 2, y + 1) != Color && Color == "White"){
                    white_checkboard[y + 1][x - 2] = CanMove;
                }
                else if(location.LocationColor(x - 2, y + 1) != Color && Color == "Black"){
                    black_checkboard[y + 1][x - 2] = CanMove;
                }
            }
            if(x - 2 >= 0 && y - 1 >= 0){ // 10시 방향 이동
                if(location.LocationColor(x - 2, y - 1) != Color && Color == "White"){
                    white_checkboard[y - 1][x - 2] = CanMove;
                }
                else if(location.LocationColor(x - 2, y - 1) != Color && Color == "Black"){
                    black_checkboard[y - 1][x - 2] = CanMove;
                }
            }
            if(x - 1 >= 0 && y - 2 >= 0){ // 10시 방향 이동
                if(location.LocationColor(x - 1, y - 2) != Color && Color == "White"){
                    white_checkboard[y - 2][x - 1] = CanMove;
                }
                else if(location.LocationColor(x - 1, y - 2) != Color && Color == "Black"){
                    black_checkboard[y - 2][x - 1] = CanMove;
                }
            }
        }
    }

    public void BishopCheck(int x, int y){
        String Color = location.LocationColor(x, y);
        int xDiff = 8 - x;
        int yDiff = 8 - y;
        if(location.LocationPiece(x, y) == chess.WhiteBishop || location.LocationPiece(x, y) == chess.BlackBishop){
            // 오른쪽 위 x + i, y - i
            if(xDiff >= y){
                for(int i = 1; i < 8; i++){
                    if(y - i >= 0){
                        if(location.LocationIsNull(x + i, y - i)){
                            if(Color == "White"){
                                white_checkboard[y - i][x + i] = CanMove;
                            }
                            else if(Color == "Black"){
                                black_checkboard[y - i][x + i] = CanMove;
                            }
                        }
                        else if(location.LocationColor(x + i, y - i) != Color){
                            if(Color == "White"){
                                white_checkboard[y - i][x + i] = CanMove;
                            }
                            else if(Color == "Black"){
                                black_checkboard[y - i][x + i] = CanMove;
                            }
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
                            if(Color == "White"){
                                white_checkboard[y - i][x + i] = CanMove;
                            }
                            else if(Color == "Black"){
                                black_checkboard[y - i][x + i] = CanMove;
                            }
                        }
                        else if(location.LocationColor(x + i, y - i) != Color){
                            if(Color == "White"){
                                white_checkboard[y - i][x + i] = CanMove;
                            }
                            else if(Color == "Black"){
                                black_checkboard[y - i][x + i] = CanMove;
                            }
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
            // 오른쪽 아래 x + i, y + i
            if(xDiff >= yDiff){
                for(int i = 1; i < 8; i++){
                    if(y + i < 8){
                        if(location.LocationIsNull(x + i, y + i)){
                            if(Color == "White"){
                                white_checkboard[y + i][x + i] = CanMove;
                            }
                            else if(Color == "Black"){
                                black_checkboard[y + i][x + i] = CanMove;
                            }
                        }
                        else if(location.LocationColor(x + i, y + i) != Color){
                            if(Color == "White"){
                                white_checkboard[y + i][x + i] = CanMove;
                            }
                            else if(Color == "Black"){
                                black_checkboard[y + i][x + i] = CanMove;
                            }
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
                            if(Color == "White"){
                                white_checkboard[y + i][x + i] = CanMove;
                            }
                            else if(Color == "Black"){
                                black_checkboard[y + i][x + i] = CanMove;
                            }
                        }
                        else if(location.LocationColor(x + i, y + i) != Color){
                            if(Color == "White"){
                                white_checkboard[y + i][x + i] = CanMove;
                            }
                            else if(Color == "Black"){
                                black_checkboard[y + i][x + i] = CanMove;
                            }
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
            // 왼쪽 아래 x - i, y + i
            if(x >= yDiff){
                for(int i = 1; i < 8; i++){
                    if(y + i < 8){
                        if(location.LocationIsNull(x - i, y + i)){
                            if(Color == "White"){
                                white_checkboard[y + i][x - i] = CanMove;
                            }
                            else if(Color == "Black"){
                                black_checkboard[y + i][x - i] = CanMove;
                            }
                        }
                        else if(location.LocationColor(x - i, y + i) != Color){
                            if(Color == "White"){
                                white_checkboard[y + i][x - i] = CanMove;
                            }
                            else if(Color == "Black"){
                                black_checkboard[y + i][x - i] = CanMove;
                            }
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
                            if(Color == "White"){
                                white_checkboard[y + i][x - i] = CanMove;
                            }
                            else if(Color == "Black"){
                                black_checkboard[y + i][x - i] = CanMove;
                            }
                        }
                        else if(location.LocationColor(x - i, y + i) != Color){
                            if(Color == "White"){
                                white_checkboard[y + i][x - i] = CanMove;
                            }
                            else if(Color == "Black"){
                                black_checkboard[y + i][x - i] = CanMove;
                            }
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
            // 왼쪽 위 x - i, y - i
            if(x >= y){
                for(int i = 1; i < 8; i++){
                    if(y - i >= 0){
                        if(location.LocationIsNull(x - i, y - i)){
                            if(Color == "White"){
                                white_checkboard[y - i][x - i] = CanMove;
                            }
                            else if(Color == "Black"){
                                black_checkboard[y - i][x - i] = CanMove;
                            }
                        }
                        else if(location.LocationColor(x - i, y - i) != Color){
                            if(Color == "White"){
                                white_checkboard[y - i][x - i] = CanMove;
                            }
                            else if(Color == "Black"){
                                black_checkboard[y - i][x - i] = CanMove;
                            }
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
                            if(Color == "White"){
                                white_checkboard[y - i][x - i] = CanMove;
                            }
                            else if(Color == "Black"){
                                black_checkboard[y - i][x - i] = CanMove;
                            }
                        }
                        else if(location.LocationColor(x - i, y - i) != Color){
                            if(Color == "White"){
                                white_checkboard[y - i][x - i] = CanMove;
                            }
                            else if(Color == "Black"){
                                black_checkboard[y - i][x - i] = CanMove;
                            }
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
        }
    }

    public void QueenCheck(int x, int y){
        String Color = location.LocationColor(x, y);
        int xDiff = 8 - x;
        int yDiff = 8 - y;
        if(location.LocationPiece(x, y) == chess.WhiteQueen || location.LocationPiece(x, y) == chess.BlackQueen){
            for(int i = x + 1; i < 8; i++){ // 오른쪽으로
                if(!location.LocationIsNull(i, y)){
                    if(location.LocationColor(i, y) != Color){
                        if(Color == "White"){
                            white_checkboard[y][i] = CanMove;
                        }
                        else if(Color == "Black"){
                            black_checkboard[y][i] = CanMove;
                        }
                    }
                    break;
                }
                else if(location.LocationIsNull(i, y) && Color == "White"){
                    white_checkboard[y][i] = CanMove;
                }
                else if(location.LocationIsNull(i, y) && Color == "Black"){
                    black_checkboard[y][i] = CanMove;
                }
            }
            for(int i = x - 1; i >= 0 ; i--){ // 왼쪽으로
                if(!location.LocationIsNull(i, y)){
                    if(location.LocationColor(i, y) != Color){
                        if(Color == "White"){
                            white_checkboard[y][i] = CanMove;
                        }
                        else if(Color == "Black"){
                            black_checkboard[y][i] = CanMove;
                        }
                    }
                    break;
                }
                else if(location.LocationIsNull(i, y) && Color == "White"){
                    white_checkboard[y][i] = CanMove;
                }
                else if(location.LocationIsNull(i, y) && Color == "Black"){
                    black_checkboard[y][i] = CanMove;
                }
            }
            for(int i = y - 1; i >= 0 ; i--){ // 위로
                if(!location.LocationIsNull(x, i)){
                    if(location.LocationColor(x, i) != Color){
                        if(Color == "White"){
                            white_checkboard[i][x] = CanMove;
                        }
                        else if(Color == "Black"){
                            black_checkboard[i][x] = CanMove;
                        }
                    }
                    break;
                }
                else if(location.LocationIsNull(x, i) && Color == "White"){
                    white_checkboard[i][x] = CanMove;
                }
                else if(location.LocationIsNull(x, i) && Color == "Black"){
                    black_checkboard[i][x] = CanMove;
                }
            }
            for(int i = y + 1; i < 8 ; i++){ // 아래로
                if(!location.LocationIsNull(x, i)){
                    if(location.LocationColor(x, i) != Color){
                        if(Color == "White"){
                            white_checkboard[i][x] = CanMove;
                        }
                        else if(Color == "Black"){
                            black_checkboard[i][x] = CanMove;
                        }
                    }
                    break;
                }
                else if(location.LocationIsNull(x, i) && Color == "White"){
                    white_checkboard[i][x] = CanMove;
                }
                else if(location.LocationIsNull(x, i) && Color == "Black"){
                    black_checkboard[i][x] = CanMove;
                }
            }
            // 오른쪽 위 x + i, y - i
            if(xDiff >= y){
                for(int i = 1; i < 8; i++){
                    if(y - i >= 0){
                        if(location.LocationIsNull(x + i, y - i)){
                            if(Color == "White"){
                                white_checkboard[y - i][x + i] = CanMove;
                            }
                            else if(Color == "Black"){
                                black_checkboard[y - i][x + i] = CanMove;
                            }
                        }
                        else if(location.LocationColor(x + i, y - i) != Color){
                            if(Color == "White"){
                                white_checkboard[y - i][x + i] = CanMove;
                            }
                            else if(Color == "Black"){
                                black_checkboard[y - i][x + i] = CanMove;
                            }
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
                            if(Color == "White"){
                                white_checkboard[y - i][x + i] = CanMove;
                            }
                            else if(Color == "Black"){
                                black_checkboard[y - i][x + i] = CanMove;
                            }
                        }
                        else if(location.LocationColor(x + i, y - i) != Color){
                            if(Color == "White"){
                                white_checkboard[y - i][x + i] = CanMove;
                            }
                            else if(Color == "Black"){
                                black_checkboard[y - i][x + i] = CanMove;
                            }
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
            // 오른쪽 아래 x + i, y + i
            if(xDiff >= yDiff){
                for(int i = 1; i < 8; i++){
                    if(y + i < 8){
                        if(location.LocationIsNull(x + i, y + i)){
                            if(Color == "White"){
                                white_checkboard[y + i][x + i] = CanMove;
                            }
                            else if(Color == "Black"){
                                black_checkboard[y + i][x + i] = CanMove;
                            }
                        }
                        else if(location.LocationColor(x + i, y + i) != Color){
                            if(Color == "White"){
                                white_checkboard[y + i][x + i] = CanMove;
                            }
                            else if(Color == "Black"){
                                black_checkboard[y + i][x + i] = CanMove;
                            }
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
                            if(Color == "White"){
                                white_checkboard[y + i][x + i] = CanMove;
                            }
                            else if(Color == "Black"){
                                black_checkboard[y + i][x + i] = CanMove;
                            }
                        }
                        else if(location.LocationColor(x + i, y + i) != Color){
                            if(Color == "White"){
                                white_checkboard[y + i][x + i] = CanMove;
                            }
                            else if(Color == "Black"){
                                black_checkboard[y + i][x + i] = CanMove;
                            }
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
            // 왼쪽 아래 x - i, y + i
            if(x >= yDiff){
                for(int i = 1; i < 8; i++){
                    if(y + i < 8){
                        if(location.LocationIsNull(x - i, y + i)){
                            if(Color == "White"){
                                white_checkboard[y + i][x - i] = CanMove;
                            }
                            else if(Color == "Black"){
                                black_checkboard[y + i][x - i] = CanMove;
                            }
                        }
                        else if(location.LocationColor(x - i, y + i) != Color){
                            if(Color == "White"){
                                white_checkboard[y + i][x - i] = CanMove;
                            }
                            else if(Color == "Black"){
                                black_checkboard[y + i][x - i] = CanMove;
                            }
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
                            if(Color == "White"){
                                white_checkboard[y + i][x - i] = CanMove;
                            }
                            else if(Color == "Black"){
                                black_checkboard[y + i][x - i] = CanMove;
                            }
                        }
                        else if(location.LocationColor(x - i, y + i) != Color){
                            if(Color == "White"){
                                white_checkboard[y + i][x - i] = CanMove;
                            }
                            else if(Color == "Black"){
                                black_checkboard[y + i][x - i] = CanMove;
                            }
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
            // 왼쪽 위 x - i, y - i
            if(x >= y){
                for(int i = 1; i < 8; i++){
                    if(y - i >= 0){
                        if(location.LocationIsNull(x - i, y - i)){
                            if(Color == "White"){
                                white_checkboard[y - i][x - i] = CanMove;
                            }
                            else if(Color == "Black"){
                                black_checkboard[y - i][x - i] = CanMove;
                            }
                        }
                        else if(location.LocationColor(x - i, y - i) != Color){
                            if(Color == "White"){
                                white_checkboard[y - i][x - i] = CanMove;
                            }
                            else if(Color == "Black"){
                                black_checkboard[y - i][x - i] = CanMove;
                            }
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
                            if(Color == "White"){
                                white_checkboard[y - i][x - i] = CanMove;
                            }
                            else if(Color == "Black"){
                                black_checkboard[y - i][x - i] = CanMove;
                            }
                        }
                        else if(location.LocationColor(x - i, y - i) != Color){
                            if(Color == "White"){
                                white_checkboard[y - i][x - i] = CanMove;
                            }
                            else if(Color == "Black"){
                                black_checkboard[y - i][x - i] = CanMove;
                            }
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
        }
    }
}

