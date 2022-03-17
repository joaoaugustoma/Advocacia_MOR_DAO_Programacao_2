package gui;

import gui.form.*;
import javax.swing.*;
import java.awt.*;

import javax.swing.JFrame;

public class CadastrarProcessos extends JFrame {
    public CadastrarProcessos() throws HeadlessException {
        montarJanela();

        JPanel novoProcessos = new NovoProcessos(this);
        JPanel mainPanel = new JPanel();
        novoProcessos.setLayout(new BoxLayout(novoProcessos, BoxLayout.Y_AXIS));
        novoProcessos.add(Box.createHorizontalStrut(5));
        
        mainPanel.add(novoProcessos);
        add(mainPanel);

        setVisible(true);
    }

    void montarJanela() {
        setTitle("Uns & Outros Associados | Cadastrar Processos");
        setSize(350, 490);
        setLocation(500, 180);
    }
}
