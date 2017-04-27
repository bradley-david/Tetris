import java.io.File;
import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by s641173 on 4/25/2017.
 */
public class Game {
    static char[][] board = new char[22][10];

    public static void run() throws Exception {
        Scanner csvScanner = new Scanner(new File("gameSetup.csv"));
        TetrominoReader tReader = new TetrominoReader(csvScanner);
        tReader.read();
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

    static char[][] copy(char[][] orig) {
        char[][] ret = new char[orig.length][orig[0].length];
        for (int i = 0; i < orig.length; i++) {
            ret[i] = orig[i].clone();
        }
        return ret;
    }

}
