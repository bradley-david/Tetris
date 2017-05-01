
import javax.swing.*;
import java.awt.*;

public class GUI extends JFrame {
    private char[][] board;
    private JPanel panel = new JPanel();

    public GUI(char[][] b) {
        board = b;
        setSize(300, 600);
        setResizable(false);
        panel.setLayout(new GridLayout(20, 10));
        placePieces();
        add(panel);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public void placePieces() {
        panel.removeAll();//remove all pieces
        for (int i = 2; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                panel.add(new JLabel(new ImageIcon(Tetrominos.imageMap.get(board[i][j]))));
            }
        }
    }

    private static class Square extends JButton {

    }
}
