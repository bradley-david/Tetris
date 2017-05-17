
import javax.swing.*;
import java.awt.*;

public class GUI extends JFrame {
    private char[][] board;
    private ImageIcon[][] icons = new ImageIcon[22][10];
    private JPanel panel = new JPanel();

    public GUI(char[][] b) {
        board = b;
        setSize(200, 400);
 //       setResizable(false);
        panel.setLayout(new GridLayout(20, 10));

        add(panel);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        placePieces();
        repaint();
    }

    public void placePieces() {
        panel.removeAll();//remove all pieces
        for (int i = 2; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                icons[i][j] = new ImageIcon(Tetrominos.imageMap.get(board[i][j]).getScaledInstance(panel.getWidth(),panel.getHeight(),Image.SCALE_FAST));
                panel.add(new JLabel(icons[i][j]));
            }
        }
    }

    @Override
    public void repaint() {

    }

    private static class Square extends JButton {

    }

    public char[][] getBoard() {
        return board;
    }
}
