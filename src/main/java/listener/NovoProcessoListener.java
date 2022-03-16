package listener;

import gui.NovoProcessoGUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class NovoProcessoListener implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        NovoProcessoGUI novoProcessoGUI = new NovoProcessoGUI();
    }
}
