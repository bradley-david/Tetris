import java.awt.*;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by David on 4/25/2017.
 */
public class Tetrominos {
    public static char[][] I;
    public static char[][] O;
    public static char[][] T;
    public static char[][] S;
    public static char[][] Z;
    public static char[][] J;
    public static char[][] L;
    public static ArrayList<char[][]> allTetrominos = new ArrayList<>();
    public static HashMap<String, char[][]> stringToCharArray = new HashMap<>();

    static {
        stringToCharArray.put("I",I);

    }


}
