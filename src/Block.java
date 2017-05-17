/**
 * Created by s641173 on 5/17/2017.
 */


public class Block {
    char[][] piece;
    int[] pos;
    public Block(int[] p, char[][] b) {
        piece = b;
        pos = p;
    }

    public String toString() {
        return "Row: " + pos[0] + ", Col: ";
    }
}
