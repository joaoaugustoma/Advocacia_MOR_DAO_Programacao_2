package gui.form;

import java.awt.CardLayout;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.Date;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import classes.Audiencia;
import dao.AudienciaDAO;
import gui.table.MostarAudiencia;

public class NovaAudiencia extends JPanel {
    JTextField diaJTextField, mesJTextField, anoJTextField, parecerJTextField;

    public NovaAudiencia() {
        JLabel diaJLabel = new JLabel("Dia");
        diaJTextField = new JTextField(2);
        add(diaJLabel);
        add(diaJTextField);

        JLabel mesJLabel = new JLabel("Mês");
        mesJTextField = new JTextField(2);
        add(mesJLabel);
        add(mesJTextField);

        JLabel anoJLabel = new JLabel("Ano");
        anoJTextField = new JTextField(2);
        add(anoJLabel);
        add(anoJTextField);

        JLabel parecerJLabel = new JLabel("Parecer");
        parecerJTextField = new JTextField(2);
        add(parecerJLabel);
        add(parecerJTextField);

        JButton submitAudiencia = new JButton("Salvar");
        add(submitAudiencia);

        submitAudienciaListener submitAudienciaAction = new submitAudienciaListener();
        submitAudiencia.addActionListener(submitAudienciaAction);

        setVisible(true);
    }

    public class submitAudienciaListener implements ActionListener {
        Audiencia audiencia = new Audiencia();

        @Override
        public void actionPerformed(ActionEvent e) {
            if (!diaJTextField.getText().isEmpty() && !mesJTextField.getText().isEmpty()
                    && !anoJTextField.getText().isEmpty() && !parecerJTextField.getText().isEmpty()) {
                int dia = Integer.parseInt(diaJTextField.getText());
                int mes = Integer.parseInt(mesJTextField.getText()) - 1;
                int ano = Integer.parseInt(anoJTextField.getText()) - 1900;

                audiencia.setData(new Date(ano, mes, dia));
                audiencia.setParecer(parecerJTextField.getText());

                int id = AudienciaDAO.getInstance().SendAudienciaBD(audiencia);
                audiencia.setId(id);
                MostarAudiencia.getInstance().AdicionarInTabela(audiencia);
                
            } else {
                JOptionPane.showMessageDialog(null, "Todos os campos devem ser preenchidos!!", "",
                        JOptionPane.INFORMATION_MESSAGE);
            }
        }
    }
}
