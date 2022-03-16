package gui;

import gui.form.*;
import javax.swing.*;
import java.awt.*;

import javax.swing.JFrame;

public class CadastrarVaras extends JFrame {
    public CadastrarVaras() throws HeadlessException {
        montarJanela();

        JPanel novoVaras = new NovoVaras();
        JPanel mainPanel = new JPanel();
        novoVaras.setLayout(new BoxLayout(novoVaras, BoxLayout.Y_AXIS));
        novoVaras.add(Box.createHorizontalStrut(5));
        
        mainPanel.add(novoVaras);
        add(mainPanel);

        setVisible(true);
    }

    void montarJanela() {
        setTitle("Uns & Outros Associados | Cadastrar varas");
        setSize(350, 350);
        setLocation(200, 50);
    }
}
