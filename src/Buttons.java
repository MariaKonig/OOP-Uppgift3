import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Buttons extends JFrame {

    JPanel pl = new JPanel();
    JButton[][] button = new JButton[4][4];
    List<JButton> list = new ArrayList<JButton>();

    public Buttons() {
        this.add(pl);

        pl.setLayout(new GridLayout(4, 4, 0, 0));
        int counter = 1;


        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                if (counter <= 15) {
                    button[i][j] = new JButton(String.valueOf(counter++));
                    pl.add(button[i][j]);
                    list.add(button[i][j]);
                    button[i][j].addActionListener(new Eventhandler(button[i][j]));
                } else {
                    button[i][j] = new JButton();
                    pl.add(button[i][j]);
                    list.add(button[i][j]);
                }

                button[i][j].setMargin(new Insets(0, 0, 0, 0));
                button[i][j].setPreferredSize(new Dimension(50, 50));

            }
        }

        pack();
        setVisible(true);



        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    private JPanel shuffle() {

        pl.removeAll();
        Collections.shuffle(list);

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
}
