package gui;

import gui.form.NovoTribunais;
import gui.form.NovoVaras;

import javax.swing.*;
import java.awt.*;

public class CadastrarTribunais extends JFrame {
    public CadastrarTribunais() throws HeadlessException {
        montarJanela();

        JPanel novoTribunais = new NovoTribunais(this);
        JPanel mainPanel = new JPanel();
        novoTribunais.setLayout(new BoxLayout(novoTribunais, BoxLayout.Y_AXIS));
        novoTribunais.add(Box.createHorizontalStrut(5));
        
        mainPanel.add(novoTribunais);
        add(mainPanel);

        setVisible(true);
    }

    void montarJanela() {
        setTitle("Uns & Outros Associados | Cadastrar tribunais");
        setSize(350, 195);
        setLocation(500, 180);
    }
}
