import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Buttons extends JFrame {

    JPanel pl = new JPanel();
    JPanel pl2 = new JPanel();
    JButton[][] button = new JButton[4][4];
    JButton startButton = new JButton("Play");
    JButton resetButton = new JButton("Reset");
    JLabel message = new JLabel("<html>Grattis,<br/> du vann!</html>");
    List<JButton> list = new ArrayList<>();
    GameLogic game = new GameLogic(pl, list, message, button);

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

        startButton.addActionListener(e -> game.shuffle());
        resetButton.addActionListener(e -> game.resetButtons());

        game.resetButtons();
        game.colours();

        pack();
        setVisible(true);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        Buttons b = new Buttons();
    }
}
