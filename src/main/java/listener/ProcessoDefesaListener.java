package listener;

import gui.ProcessoDefesaGUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ProcessoDefesaListener implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        ProcessoDefesaGUI processoDefesaGUI = new ProcessoDefesaGUI();
    }
}
