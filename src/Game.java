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

    static char[][] rotateCounterClockwise(char[][] t) {
        int row = t.length;
        int col = t[0].length;

        if (row != col) //means we have a box
            return t;

        char[][] rotated = new char[row][col];
        for (int r = 0; r < row; r++) {
            for (int c = 0; c < col; c++) {
                rotated[r][c] = t[c][row - 1 - r];
            }
        }

        return rotated;
    }

    static char[][] rotateClockwise(char[][] t) {
        int row = t.length;
        int col = t[0].length;

        if (row != col) //means we have a box
            return t;

        char[][] rotated = new char[row][col];
        for (int r = 0; r < row; r++) {
            for (int c = 0; c < col; c++) {
                rotated[r][c] = t[col - 1 - c][r];
            }
        }

        return rotated;
    }

    /*
        prints 2D array
     */
    static void print(char[][] c) {
        for (char[] d : c)
            System.out.println(Arrays.toString((d)));
    }
}
