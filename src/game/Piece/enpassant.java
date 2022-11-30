package game.Piece;
import game.location.*;

public class enpassant {
    static Location location = new Location();
    public static int white_before_x, white_before_y, white_now_x, white_now_y = 0;
    public static int black_before_x, black_before_y, black_now_x, black_now_y = 0;

    public static boolean Enpassant(int now_x, int now_y, int next_x, int next_y){
        if(location.LocationColor(now_x, now_y) == "White"){
            if(Math.abs(black_now_x - now_x) == 1 && black_now_y == now_y && black_now_x == next_x){
                if(black_now_y != 0){
                    if(Math.abs(now_x - next_x) == 1 && now_y - next_y == 1){
                        black_before_x = 0;
                        black_before_y = 0;
                        black_now_x = 0;
                        black_now_y = 0;
                        return true;
                    }
                }
            }
        }
        else if(location.LocationColor(now_x, now_y) == "Black"){
            if(Math.abs(white_now_x - now_x) == 1 && white_now_y == now_y && white_now_x == next_x){
                if(white_now_y != 0){
                    if(Math.abs(now_x - next_x) == 1 && next_y - now_y == 1){
                        white_before_x = 0;
                        white_before_y = 0;
                        white_now_x = 0;
                        white_now_y = 0;
                        return true;
                    }
                }
            }
        }
        return false;
    }
}
