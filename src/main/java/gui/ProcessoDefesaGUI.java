package gui;

import gui.form.NovoCliente;

import javax.swing.*;
import java.awt.*;

public class ProcessoDefesaGUI extends JFrame {
    public ProcessoDefesaGUI() throws HeadlessException {
        setTitle("Uns & Outros Associados | Processo de Defesa");
        setSize(500, 300);
        setLocation(500, 300);

        JPanel mainPanel = new JPanel();

        mainPanel.add(new NovoCliente());

        add(mainPanel);
        setVisible(true);
    }
}
