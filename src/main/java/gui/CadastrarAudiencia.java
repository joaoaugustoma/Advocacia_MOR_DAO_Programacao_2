package gui;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import gui.form.NovaAudiencia;

public class CadastrarAudiencia extends JFrame {
    public CadastrarAudiencia() {
        montarJanela();

        JPanel novaAudiencia = new NovaAudiencia(this);
        JPanel mainPanel = new JPanel();
        novaAudiencia.setLayout(new BoxLayout(novaAudiencia, BoxLayout.Y_AXIS));
        novaAudiencia.add(Box.createHorizontalStrut(5));

        mainPanel.add(novaAudiencia);
        add(mainPanel);

        setVisible(true);
    }

    void montarJanela() {
        setTitle("Uns & Outros Associados | Cadastrar Audiencia");
        setSize(350, 550);
        setLocation(200, 50);
    }
}
