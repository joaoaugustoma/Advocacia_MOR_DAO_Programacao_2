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

public class NovoTribunais extends JPanel {

    JTextField descricaoTextField, enderecoTextField;

    public NovoTribunais() {

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

        SubmitTribunaisListener submitTribunaisListener = new SubmitTribunaisListener();
        submitvaras.addActionListener(submitTribunaisListener);

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
            } else {
            JOptionPane.showMessageDialog(null, "Todos os campos devem ser preenchidos!!", "",
                    JOptionPane.INFORMATION_MESSAGE);
            }
        }
    }
}
