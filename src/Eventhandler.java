import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import static java.util.Collections.swap;

public class Eventhandler implements ActionListener {
    JButton button;
    List<JButton> list;
    JPanel pl;
    updateGame update = new updateGame();
    public Eventhandler(JButton pressedButton, List<JButton> list, JPanel panel){
        button = pressedButton;
        this.list = list;
        pl = panel;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        int i = list.indexOf(button);
        int j = getValidMove(i);
        if(!(j == -1)) {
            swap(list, i, j);
            update.updatePanel();
        }

    }

    public int getValidMove(int i){
        if( !(i==0) && list.get(i - 1).getText().isEmpty()){ //kolla vänster
            return i-1;
        }
        else if(((i+1)<16) && list.get(i+1).getText().isEmpty()){ //kolla höger
            return i+1;
        }
        else if ((i-4)>0 && list.get(i-4).getText().isEmpty()) { //kolla uppe
            return i-4;
        }else if((i+4)<16 && list.get(i+4).getText().isEmpty()){ // kolla nere
            return i+4;
        }
        return -1;
    }

    private class updateGame{

        public void updatePanel(){
            pl.removeAll();
            for(JButton button :  list){
                pl.add(button);
            }
            pl.repaint();
            pl.revalidate();
        }

    }

}
