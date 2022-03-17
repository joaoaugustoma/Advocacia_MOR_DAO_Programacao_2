package gui.form;

import java.awt.CardLayout;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;


import classes.Varas;
import dao.VarasDAO;
import gui.table.MostrarVaras;
import listener.VoltarListener;

public class NovoVaras extends JPanel {
    
    JTextField nVaraTextField, descricaoTextField;

    JFrame jfvoltar;

    public NovoVaras(JFrame jf) {

        jfvoltar = jf;

        JLabel nVaraLabel = new JLabel("Nº da Vara:");
        nVaraTextField = new JTextField(10);
        add(nVaraLabel);
        add(nVaraTextField);

        JLabel descricaoLabel = new JLabel("Descrição da varas:");
        descricaoTextField = new JTextField(10);
        add(descricaoLabel);
        add(descricaoTextField);

        JButton submitvaras = new JButton("Salvar");
        add(submitvaras);

        JButton VoltarBTN = new JButton("Voltar");
        VoltarListener VoltarListener = new VoltarListener(jf);
        VoltarBTN.addActionListener((ActionListener) VoltarListener);

        SubmitvarasListener submitvarasAction = new SubmitvarasListener();
        submitvaras.addActionListener(submitvarasAction);

        add(VoltarBTN);
        setVisible(true);
    }

    public class SubmitvarasListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            Varas varas = new Varas();

            if (!nVaraTextField.getText().isEmpty() && !descricaoTextField.getText().isEmpty()) {
                varas.setNVaras(nVaraTextField.getText());
                varas.setDescricao(descricaoTextField.getText());

                int id = VarasDAO.getInstance().SendvarasBD(varas);
                varas.setId(id);
                MostrarVaras.getInstance().AdicionarInTabela(varas);
                jfvoltar.dispose();
            } else {
            JOptionPane.showMessageDialog(null, "Todos os campos devem ser preenchidos!!", "",
                    JOptionPane.INFORMATION_MESSAGE);
            }
        }
    }
}
