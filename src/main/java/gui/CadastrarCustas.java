package gui;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import gui.form.NovaCustas;

public class CadastrarCustas extends JFrame {
    public CadastrarCustas() {
        montarJanela();

        JPanel novaCustas = new NovaCustas(this);
        JPanel mainPanel = new JPanel();
        novaCustas.setLayout(new BoxLayout(novaCustas, BoxLayout.Y_AXIS));
        novaCustas.add(Box.createHorizontalStrut(5));

        mainPanel.add(novaCustas);
        add(mainPanel);

        setVisible(true);
    }

    void montarJanela() {
        setTitle("Uns & Outros Associados | Cadastrar Custas");
        setSize(350, 330);
        setLocation(500, 180);
    }
}
