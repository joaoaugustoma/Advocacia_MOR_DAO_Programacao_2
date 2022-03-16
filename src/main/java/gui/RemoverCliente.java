package gui;

import gui.form.*;
import javax.swing.*;
import java.awt.*;

public class RemoverCliente extends JFrame{
    public RemoverCliente() throws HeadlessException {
        montarJanela();

        JPanel selecionarCliente = new SelecionarCliente();
        JPanel mainPanel = new JPanel();
        selecionarCliente.setLayout(new BoxLayout(selecionarCliente, BoxLayout.Y_AXIS));
        selecionarCliente.add(Box.createHorizontalStrut(5));
        
        mainPanel.add(selecionarCliente);
        add(mainPanel);

        setVisible(true);
    }

    void montarJanela() {
        setTitle("Uns & Outros Associados | Remover Cliente");
        setSize(350, 550);
        setLocation(200, 50);
    }
}
