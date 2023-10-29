import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Buttons extends JFrame {

    JPanel pl = new JPanel();
    JPanel pl2 = new JPanel();
    JButton[][] button = new JButton[4][4];
    JButton startButton = new JButton("Start");
    JButton resetButton = new JButton("Reset");
    JLabel message = new JLabel("<html>Grattis,<br/> du vann!</html>");
    List<JButton> list = new ArrayList<JButton>();

    public Buttons() {

        setLayout(new BorderLayout());
        pl.setLayout(new GridLayout(4, 4, 0, 0));
        add(pl, BorderLayout.CENTER);
        add(pl2, BorderLayout.EAST);

        pl2.add(startButton);
        pl2.add(resetButton);
        pl2.add(message);
        pl2.setLayout(new BoxLayout(pl2, BoxLayout.Y_AXIS));
        message.setVisible(false);


        int counter = 1;

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                if (counter <= 15) {
                    button[i][j] = new JButton(String.valueOf(counter++));
                    pl.add(button[i][j]);
                    list.add(button[i][j]);
                    button[i][j].addActionListener(new Eventhandler(button[i][j], list, pl, message));
                } else {
                    button[i][j] = new JButton();
                    pl.add(button[i][j]);
                    list.add(button[i][j]);
                }

                button[i][j].setMargin(new Insets(0, 0, 0, 0));
                button[i][j].setPreferredSize(new Dimension(50, 50));

            }
        }

        startButton.addActionListener(e -> shuffle());
        resetButton.addActionListener(e -> resetButtons());

        pack();
        setVisible(true);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    private void resetButtons() {
        pl.removeAll();
        list.clear();
        message.setVisible(false);

        int counter = 1;
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                if (counter <= 15) {
                    button[i][j] = new JButton(String.valueOf(counter++));
                    list.add(button[i][j]);
                    button[i][j].addActionListener(new Eventhandler(button[i][j], list, pl, message));
                } else {
                    button[i][j] = new JButton();
                    list.add(button[i][j]);
                }

                button[i][j].setMargin(new Insets(0, 0, 0, 0));
                button[i][j].setPreferredSize(new Dimension(50, 50));
                pl.add(button[i][j]);
            }
        }

        pl.repaint();
        pl.revalidate();
    }

    private JPanel shuffle() {

        pl.removeAll();
        Collections.shuffle(list);
        message.setVisible(false);

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                button[i][j] = list.get(i * 4 + j);
                pl.add(button[i][j]);
            }
        }
        pl.repaint();
        pl.revalidate();
        return pl;
    }

    public static void main(String[] args) {
        Buttons b = new Buttons();
    }
}
