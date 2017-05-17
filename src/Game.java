import java.io.File;
import java.util.*;

/**
 * Created by s641173 on 4/25/2017.
 */
public class Game {
    static char[][] board = new char[22][10];
    static ArrayList<Block> newPiece = new ArrayList();
    static Block currentBlock;
    //test

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
    /*returns array of rotated piece given it can fit in board*/
    static void rotateCounterClockwise(Block b) {
        int[] pos = b.pos;
        char[][] piece = b.piece;

        int row = piece.length;
        int col = piece[0].length;

        if (row != col) //means we have a box
            return;

        char[][] rotated = new char[row][col];
        for (int r = 0; r < row; r++) {
            for (int c = 0; c < col; c++) {
                rotated[r][c] = piece[c][row - 1 - r];
            }
        }

        if (canPlace(pos[0], pos[1], rotated))
            b.piece = rotated;

    }

    /*returns array of rotated piece given it can fit in board*/
    static void rotateClockwise(Block b) {
        int[] pos = b.pos;
        char[][] piece = b.piece;

        int row = piece.length;
        int col = piece[0].length;

        if (row != col) //means we have a box
            return;

        char[][] rotated = new char[row][col];
        for (int r = 0; r < row; r++) {
            for (int c = 0; c < col; c++) {
                rotated[r][c] = piece[col - 1 - c][r];
            }
        }

        if (canPlace(pos[0], pos[1], rotated))
            b.piece = rotated;

    }

    static void moveLeft(Block b) {
        int[] pos = b.pos;
        char[][] piece = b.piece;

        if (canPlace(pos[0], pos[1] - 1, piece))
            pos[1]--;
    }

    static void moveRight(Block b) {
        int[] pos = b.pos;
        char[][] piece = b.piece;

        if (canPlace(pos[0], pos[1] + 1, piece))
            pos[1]++;
    }

    /*
        prints 2D array
     */
    static void print(char[][] c) {
        for (char[] d : c)
            System.out.println(Arrays.toString((d)));
    }

    /*places piece if it can and returns true, otherwise returns false*/
    static boolean place(int row, int col, char[][] piece) {

        if (canPlace(row, col, piece)) {
            for (int r = 0; r < piece.length; r++) {
                for (int c = 0; c < piece[r].length; c++) {
                    if (row + r >= 0 && row + r < board.length && col + c >= 0 && col + c < board[row].length) {
                        board[row + r][col + c] = piece[r][c];
                    }
                }
            }
        }
        return false;


    }

    /*returns true if piece can fit at designated row, col, otherwise returns false*/
    static boolean canPlace(int row, int col, char[][] piece) {
        for (int r = 0; r < piece.length; r++) {
            for (int c = 0; c < piece[r].length; c++) {
                if (piece[r][c] != '0') {
                    if (row + r >= 0 && row + r < board.length && col + c >= 0 && col + c < board[row].length) {
                        if (board[row + r][col + c] != '0') {
                            return false;
                        }
                    } else {
                        return false;
                    }
                }
            }
        }

        return true;
    }

    /* returns false if it doesn't drop, true if it does */
    static void tick(Block b) {
        int[] pos = b.pos;
        char[][] piece = b.piece;
        if (canPlace(pos[0] + 1, pos[1], piece)) {
            pos[0]++;
        }
        else
            place(pos[0], pos[1], piece);
    }

    /*drops piece vertically to lowest clear space*/
    static void hardDrop(Block b) {
        int[] pos = b.pos;
        char[][] piece = b.piece;

        while (canPlace(pos[0] + 1, pos[1], piece))
            pos[0]++;

        place(pos[0], pos[1], piece);
    }

    /*adds 7 pieces to next set of pieces in random order*/
    static void addNewPieces() {
        ArrayList<Block> news = new ArrayList<>();
        news.add(new Block(new int[]{2, 3}, Tetrominos.I));
        news.add(new Block(new int[]{2, 3}, Tetrominos.J));
        news.add(new Block(new int[]{2, 3}, Tetrominos.L));
        news.add(new Block(new int[]{2, 3}, Tetrominos.O));
        news.add(new Block(new int[]{2, 3}, Tetrominos.S));
        news.add(new Block(new int[]{2, 3}, Tetrominos.T));
        news.add(new Block(new int[]{2, 3}, Tetrominos.Z));


        Collections.shuffle(news);
        newPiece.addAll(news);
    }

    static void pressSpace(){
        hardDrop(currentBlock);
    }

    static void PressUp(){
        rotateCounterClockwise(currentBlock);
    }

    static void PressZ() {
        rotateClockwise(currentBlock);
    }

    static void holdDown() {
        tick(currentBlock);
    }

    static void holdLeft() {
        moveLeft(currentBlock);

    }

    static void holdRight() {
        moveRight(currentBlock);
    }

    static void tickGUI() {
        tick(currentBlock);
    }



}
