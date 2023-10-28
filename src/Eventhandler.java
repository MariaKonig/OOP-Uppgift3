import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import static java.util.Collections.swap;

public class Eventhandler implements ActionListener {
    JButton button;
    List<JButton> list;
    JPanel pl;
    public Eventhandler(JButton pressedButton, List<JButton> list, JPanel panel){
        button = pressedButton;
        this.list = list;
        pl = panel;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        int i = list.indexOf(button);
        int j = i+1;
        swap(list,  i, j);
        updatePanel();

    }
    public void updatePanel(){
        pl.removeAll();
        for(JButton button :  list){
            pl.add(button);
        }
        pl.repaint();
        pl.revalidate();
    }
}
