import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Eventhandler implements ActionListener {
    JButton button;
    public Eventhandler(JButton pressedButton){
        button = pressedButton;
    }
    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
