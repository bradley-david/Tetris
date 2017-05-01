import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
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
    public static HashMap<Character, Color> colorMap = new HashMap<>();
    public static HashMap<Character, BufferedImage> imageMap = new HashMap<>();

    static {
        colorMap.put('c', Color.cyan);
        colorMap.put('y', Color.yellow);
        colorMap.put('p', new Color(147, 33, 158));
        colorMap.put('g', Color.green);
        colorMap.put('r', Color.red);
        colorMap.put('b', Color.blue);
        colorMap.put('o', Color.orange);
        colorMap.put('0', Color.black);
        try {
            imageMap.put('c', ImageIO.read(new File("c.png")));
            imageMap.put('y', ImageIO.read(new File("y.png")));
            imageMap.put('p', ImageIO.read(new File("p.png")));
            imageMap.put('g', ImageIO.read(new File("g.png")));
            imageMap.put('r', ImageIO.read(new File("r.png")));
            imageMap.put('b', ImageIO.read(new File("b.png")));
            imageMap.put('o', ImageIO.read(new File("o.png")));
            imageMap.put('0', ImageIO.read(new File("0.png")));
        } catch (IOException ex) {
            System.err.println("Image not found!");
        }
    }


}
