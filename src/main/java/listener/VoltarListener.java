package listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

public class VoltarListener implements ActionListener {
    
    JFrame jf;

    public VoltarListener(JFrame jf){
        this.jf = jf;
    }

    public void actionPerformed(ActionEvent e){
        jf.dispose();
    }
}
