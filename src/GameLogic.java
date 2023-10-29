import javax.swing.*;
import java.awt.*;
import java.util.Collections;
import java.util.List;

public class GameLogic {

    JPanel pl;
    List<JButton> list;
    JLabel message;
    JButton[][] button;


    public GameLogic(JPanel pl, List<JButton> list, JLabel message, JButton[][] button) {
        this.pl = pl;
        this.list = list;
        this.message = message;
        this.button = button;
    }

    public void resetButtons() {

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
                button[i][j].setPreferredSize(new Dimension(60, 60));
                pl.add(button[i][j]);
            }
        }
        colours();
        pl.repaint();
        pl.revalidate();
    }

    public void shuffle() {

        pl.removeAll();
        Collections.shuffle(list);

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                button[i][j] = list.get(i * 4 + j);
                pl.add(button[i][j]);
            }
        }

        message.setVisible(false);
        pl.repaint();
        pl.revalidate();
    }

    public void colours() {

        int counter = 1;

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {


                if (counter % 2 == 0) {
                    button[i][j].setBackground(Color.BLACK);
                    button[i][j].setForeground(Color.white);
                } else {
                    button[i][j].setBackground(Color.WHITE);
                }
                button[i][j].setOpaque(true);
                button[i][j].setBorderPainted(false);
                counter++;
            }
            counter++;
        }
    }
}
