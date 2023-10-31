import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Buttons extends JFrame {

    JPanel pl = new JPanel();
    JPanel pl2 = new JPanel();
    JPanel pl3 = new JPanel();
    JButton[][] button = new JButton[4][4];
    JButton startButton = new JButton("Play");
    JButton resetButton = new JButton("Reset");
    JLabel message = new JLabel("<html>Grattis,<br/> du vann!</html>");
    List<JButton> list = new ArrayList<>();
    GameLogic game = new GameLogic(pl, list, message, button);
    Stopwatch timer;
    public Buttons() {

        setLayout(new BorderLayout());

        pl.setLayout(new GridLayout(4, 4, 0, 0));
        pl2.setLayout(new BorderLayout());
        pl3.setLayout(new GridLayout());

        add(pl, BorderLayout.CENTER);
        add(pl2, BorderLayout.EAST);

        pl2.setBackground(Color.WHITE);
        pl2.setPreferredSize(new Dimension(150,70));
        pl.setPreferredSize(new Dimension(400,400));

        startButton.setPreferredSize(new Dimension(300,40));
        resetButton.setPreferredSize(new Dimension(30,40));


        pl3.add(startButton);
        pl3.add(resetButton);
        pl2.add(message);
        pl2.add(pl3, BorderLayout.SOUTH);


        message.setVisible(false);

        startButton.addActionListener(e -> {
            game.shuffle();
            if (timer != null) {
                timer.start();
            }

        });
        resetButton.addActionListener(e -> {
            game.resetButtons();
            if (timer != null) {
                timer.reset();
            }
        });
        timer = new Stopwatch();
        pl2.add(timer.getTimeLabel(), BorderLayout.NORTH);

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
