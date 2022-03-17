package gui.form;

import classes.Tribunais;
import dao.TribunaisDAO;
import gui.table.MostrarResultadoConsultaTribunais;
import listener.VoltarListener;

import javax.swing.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class ConsultarTribunais extends JPanel {

    JFrame jfvoltar;
    JTextField consultaTextField;

    public ConsultarTribunais(JFrame jf) {
        jfvoltar = jf;

        JLabel consultaLabel = new JLabel("Nº do tribunal:");
        consultaTextField = new JTextField(10);
        add(consultaLabel);
        add(consultaTextField);

        JButton submitConsulta = new JButton("Consultar");
        add(submitConsulta);

        SubmitConsultaListener submitConsultaListener = new SubmitConsultaListener();
        submitConsulta.addActionListener(submitConsultaListener);

        JButton VoltarBTN = new JButton("Voltar");
        VoltarListener VoltarListener = new VoltarListener(jf);
        VoltarBTN.addActionListener((ActionListener) VoltarListener);

        add(VoltarBTN);
        setVisible(true);
    }

    private class SubmitConsultaListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            int idTribunal;
            if (!consultaTextField.getText().isEmpty()) {
                idTribunal = Integer.parseInt(consultaTextField.getText());

                    MostrarResultadoConsultaTribunais.getInstance().mostrarResultadoConsultaTribunais(idTribunal);
                    add(new JScrollPane(MostrarResultadoConsultaTribunais.getInstance().MontrarTabela()));

//                    JOptionPane.showMessageDialog(null, "Tribunal não encontrado!!", "", JOptionPane.INFORMATION_MESSAGE);
//                    System.out.println("Erro no SQL em SendCustasBD Segue o Log:");

//                jfvoltar.dispose();
            } else {
                JOptionPane.showMessageDialog(null, "Todos os campos devem ser preenchidos!!", "",
                        JOptionPane.INFORMATION_MESSAGE);
            }
        }
    }
}
