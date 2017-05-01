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
        //GUI gui = new GUI(board);

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

    /*returns false if it can't drop, returns true if it can*/
    static boolean drop(int row, int col, char[][] piece, boolean place) {
        for (int r = 0; r < piece.length; r++) {
            for (int c = 0; c < piece[r].length; c++) {
                if (piece[r][c] != '0') {
                    if (row + r >= 0 && row + r < board.length && col + c >= 0 && col + c < board[row].length) {
                        if (piece[r][c] != '0' && board[row + r][col + c] != '0') {

                            return false;
                        }
                    } else {
                        System.out.println("here");
                        return false;
                    }
                }
            }
        }
        if (place) {
            for (int r = 0; r < piece.length; r++) {
                for (int c = 0; c < piece[r].length; c++) {
                    if (piece[r][c] != '0') {
                        board[row + r][col + c] = piece[r][c];
                    }
                }
            }
        }

        return true;


    }

    /* returns false if it doesn't drop, true if it does */
    static boolean tick(int[] pos, char[][] piece) {
        if (drop(pos[0] + 1, pos[1], piece, false)) {
            pos[0] += 1;
            return false;
        } else {
            drop(pos[0], pos[1], piece, true);
            return true;
        }
    }
}
