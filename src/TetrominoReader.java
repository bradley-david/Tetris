import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

import static java.lang.System.out;

/**
 * Class that reads tetrominos out of gameSetup.csv
 */

public class TetrominoReader {
    private Scanner sc;
    private int lines;

    public TetrominoReader(Scanner scanner) {
        sc = scanner;
        //guarantees that we are at the right line
        String line = sc.nextLine();
        if (!line.split(",")[0].equals("TETROMINOS")) {
            throw new RuntimeException();
        }
        lines = Integer.parseInt(line.split(",")[1]);
    }

    //initialize all reference arrays in Tetromino.java
    public void read() {
        for (int line = 0; line < lines; line++) {
            String[] ln = sc.nextLine().split(",");
            int rows = Integer.parseInt(ln[1]);
            int cols = Integer.parseInt(ln[2]);
            char[][] tet = new char[rows][cols];
            for (int row = 0; row < rows; row++) {
                char[] temp = new char[cols];
                String[] s = sc.nextLine().split(",");
                line++;
                for (int i = 0; i < s.length; i++) {
                    temp[i] = s[i].charAt(0);
                }
                tet[row] = temp;
            }
            switch (ln[0]) {
                case "I":
                    Tetromino.I = tet;
                    break;
                case "O":
                    Tetromino.O = tet;
                    break;
                case "T":
                    Tetromino.T = tet;
                    break;
                case "S":
                    Tetromino.S = tet;
                    break;
                case "Z":
                    Tetromino.Z = tet;
                    break;
                case "J":
                    Tetromino.J = tet;
                    break;
                case "L":
                    Tetromino.L = tet;
                    break;
            }
        }
        Tetromino.allTetrominos.add(Tetromino.I);
        Tetromino.allTetrominos.add(Tetromino.O);
        Tetromino.allTetrominos.add(Tetromino.T);
        Tetromino.allTetrominos.add(Tetromino.S);
        Tetromino.allTetrominos.add(Tetromino.Z);
        Tetromino.allTetrominos.add(Tetromino.L);
        Tetromino.allTetrominos.add(Tetromino.J);

    }

}
