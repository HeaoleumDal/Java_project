package game.location;

public class Location {
    public void NowLocationIsNull(char char_x, char char_y) {
        int x = char_x - 49;
        int y = 72 - char_y;

        System.out.println(y);
    }
}
