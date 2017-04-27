import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

import static java.lang.System.out;

/**
 * Class that reads Tetrominoss out of gameSetup.csv
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

    //initialize all reference arrays in Tetrominos.java
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
                    Tetrominos.I = tet;
                    break;
                case "O":
                    Tetrominos.O = tet;
                    break;
                case "T":
                    Tetrominos.T = tet;
                    break;
                case "S":
                    Tetrominos.S = tet;
                    break;
                case "Z":
                    Tetrominos.Z = tet;
                    break;
                case "J":
                    Tetrominos.J = tet;
                    break;
                case "L":
                    Tetrominos.L = tet;
                    break;
            }
        }
        Tetrominos.allTetrominos.add(Tetrominos.I);
        Tetrominos.stringToCharArray.put("I", Tetrominos.I);
        Tetrominos.allTetrominos.add(Tetrominos.O);
        Tetrominos.stringToCharArray.put("O", Tetrominos.O);
        Tetrominos.allTetrominos.add(Tetrominos.T);
        Tetrominos.stringToCharArray.put("T", Tetrominos.T);
        Tetrominos.allTetrominos.add(Tetrominos.S);
        Tetrominos.stringToCharArray.put("S", Tetrominos.S);
        Tetrominos.allTetrominos.add(Tetrominos.Z);
        Tetrominos.stringToCharArray.put("Z", Tetrominos.Z);
        Tetrominos.allTetrominos.add(Tetrominos.L);
        Tetrominos.stringToCharArray.put("L", Tetrominos.L);
        Tetrominos.allTetrominos.add(Tetrominos.J);
        Tetrominos.stringToCharArray.put("J",Tetrominos.J);

    }

}
