package gui.form;

import classes.Tribunais;
import classes.Varas;
import dao.TribunaisDAO;
import dao.VarasDAO;
import gui.table.MostrarTribunais;
import gui.table.MostrarVaras;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import listener.VoltarListener;

public class NovoTribunais extends JPanel {

    JTextField descricaoTextField, enderecoTextField;

    JFrame jfvoltar;

    public NovoTribunais(JFrame jf) {

        jfvoltar = jf;

        JLabel descricaoLabel = new JLabel("Descrição do tribunal:");
        descricaoTextField = new JTextField(10);
        add(descricaoLabel);
        add(descricaoTextField);

        JLabel enderecoLabel = new JLabel("Endereço do tribunal:");
        enderecoTextField = new JTextField(10);
        add(enderecoLabel);
        add(enderecoTextField);

        JButton submitvaras = new JButton("Salvar");
        add(submitvaras);

        JButton VoltarBTN = new JButton("Voltar");
        VoltarListener VoltarListener = new VoltarListener(jf);
        VoltarBTN.addActionListener((ActionListener) VoltarListener);

        SubmitTribunaisListener submitTribunaisListener = new SubmitTribunaisListener();
        submitvaras.addActionListener(submitTribunaisListener);

        add(VoltarBTN);
        setVisible(true);
    }

    public class SubmitTribunaisListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            Tribunais tribunais = new Tribunais();

            if (!descricaoTextField.getText().isEmpty() && !enderecoTextField.getText().isEmpty()) {
                tribunais.setDescricao(descricaoTextField.getText());
                tribunais.setEndereco(enderecoTextField.getText());

                int id = TribunaisDAO.getInstance().sendTribunaisBD(tribunais);
                tribunais.setId(id);
                MostrarTribunais.getInstance().AdicionarInTabela(tribunais);
                jfvoltar.dispose();
            } else {
            JOptionPane.showMessageDialog(null, "Todos os campos devem ser preenchidos!!", "",
                    JOptionPane.INFORMATION_MESSAGE);
            }
        }
    }
}
