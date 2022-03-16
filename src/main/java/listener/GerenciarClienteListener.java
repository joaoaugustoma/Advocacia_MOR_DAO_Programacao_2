package listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import gui.GerenciarCliente;

public class GerenciarClienteListener implements ActionListener{
    
    @Override
    public void actionPerformed(ActionEvent e) {
        GerenciarCliente GerenciarCliente = new GerenciarCliente();
    }
}
