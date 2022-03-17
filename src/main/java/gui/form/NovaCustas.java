package gui.form;

import java.awt.CardLayout;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.Date;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import classes.Custas;
import dao.CustasDAO;
import gui.table.MostrarCustas;
import listener.VoltarListener;

public class NovaCustas extends JPanel {

    JTextField nTextField, diaJTextField, mesJTextField, anoJTextField, descricaoTextField, valorTextField;

    JFrame jfvoltar;

    public NovaCustas(JFrame jf) {

        jfvoltar = jf;

        JLabel nLabel = new JLabel("Nº do Processo:");
        nTextField = new JTextField(10);
        add(nLabel);
        add(nTextField);

        JLabel diaJLabel = new JLabel("Dia da Custa");
        diaJTextField = new JTextField(2);
        add(diaJLabel);
        add(diaJTextField);

        JLabel mesJLabel = new JLabel("Mês da Custa");
        mesJTextField = new JTextField(2);
        add(mesJLabel);
        add(mesJTextField);

        JLabel anoJLabel = new JLabel("Ano da Custa");
        anoJTextField = new JTextField(2);
        add(anoJLabel);
        add(anoJTextField);

        JLabel descricaoLabel = new JLabel("Descrição da Custas:");
        descricaoTextField = new JTextField(10);
        add(descricaoLabel);
        add(descricaoTextField);

        JLabel valorLabel = new JLabel("Valor da Custas:");
        valorTextField = new JTextField(10);
        add(valorLabel);
        add(valorTextField);

        JButton submitCustas = new JButton("Salvar");
        add(submitCustas);

        JButton VoltarBTN = new JButton("Voltar");
        VoltarListener VoltarListener = new VoltarListener(jf);
        VoltarBTN.addActionListener((ActionListener) VoltarListener);

        SubmitCustasListener submitCustasAction = new SubmitCustasListener();
        submitCustas.addActionListener(submitCustasAction);

        add(VoltarBTN);
        setVisible(true);
    }

    public class SubmitCustasListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            Custas Custas = new Custas();

            if (!nTextField.getText().isEmpty() && !diaJTextField.getText().isEmpty()
                    && !descricaoTextField.getText().isEmpty() && !valorTextField.getText().isEmpty()) {
                int dia = Integer.parseInt(diaJTextField.getText());
                int mes = Integer.parseInt(mesJTextField.getText()) - 1;
                int ano = Integer.parseInt(anoJTextField.getText()) - 1900;

                Custas.setNProcessos(Integer.parseInt(nTextField.getText()));
                Custas.setData(new Date(ano, mes, dia));
                Custas.setDescricao(descricaoTextField.getText());
                Custas.setValor(valorTextField.getText());
                try {
                    int id = CustasDAO.getInstance().SendCustasBD(Custas);
                    Custas.setId(id);
                    MostrarCustas.getInstance().AdicionarInTabela(Custas);
                } catch (SQLException ex) {
                    ex.printStackTrace();
                    JOptionPane.showMessageDialog(null, "Processo não encontrado!!", "",
                        JOptionPane.INFORMATION_MESSAGE);
                }
                jfvoltar.dispose();
            } else {
                JOptionPane.showMessageDialog(null, "Todos os campos devem ser preenchidos!!", "",
                        JOptionPane.INFORMATION_MESSAGE);
            }
        }
    }
}
