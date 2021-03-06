package gui;

import gui.form.*;
import javax.swing.*;
import java.awt.*;

public class CadastrarCliente extends JFrame {
    public CadastrarCliente() throws HeadlessException {
        montarJanela();

        JPanel novoCliente = new NovoCliente(this);
        JPanel mainPanel = new JPanel();
        novoCliente.setLayout(new BoxLayout(novoCliente, BoxLayout.Y_AXIS));
        novoCliente.add(Box.createHorizontalStrut(5));
        
        mainPanel.add(novoCliente);
        add(mainPanel);

        setVisible(true);
    }

    void montarJanela() {
        setTitle("Uns & Outros Associados | Cadastrar Pessoa");
        setSize(350, 480);
        setLocation(500, 180);
    }
}
