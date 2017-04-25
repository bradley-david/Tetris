import java.util.Arrays;

/**
 * Created by s641173 on 4/25/2017.
 */
public class Game {
    static char[][] board = new char[22][10];

    public static void run() {
        fillBoard();
    }

    static void fillBoard() {
        for (char[] c : board) {
            Arrays.fill(c, '0');
        }
    }
}
