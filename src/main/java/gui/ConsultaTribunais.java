package gui;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import gui.form.ConsultarTribunais;

public class ConsultaTribunais extends JFrame {
    public ConsultaTribunais() {
        montarJanela();

        JPanel consultarTribunais = new ConsultarTribunais(this);
        JPanel mainPanel = new JPanel();

        mainPanel.add(consultarTribunais);
        add(mainPanel);

        setVisible(true);
    }

    void montarJanela() {
        setTitle("Uns & Outros Associados | Cadastrar varas");
        setSize(1200, 600);
        setLocation(200, 120);
    }
}
