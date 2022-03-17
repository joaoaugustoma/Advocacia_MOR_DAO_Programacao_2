package gui.form;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.sql.Date;
import java.sql.SQLException;

import classes.Processos;
import dao.ProcessosDAO;
import gui.table.MostrarProcessos;
import listener.VoltarListener;

public class NovoProcessos extends JPanel {
    
    JTextField diaAberturaTextField, mesAberturaTextField, anoAberturaTextField, diaConclusaoTextField, mesConclusaoTextField, anoConclusaoTextField, situacaoTextField, idAudienciaTextField, idClienteTextField, idParteContrariaTextField;

    JFrame jfvoltar;

    public NovoProcessos(JFrame jf) {

        jfvoltar = jf;

        JLabel idAudienciaJLabel = new JLabel("ID da audiência:");
        idAudienciaTextField = new JTextField(10);
        add(idAudienciaJLabel);
        add(idAudienciaTextField);

        JLabel clienteJLabel = new JLabel("ID do cliente:");
        idClienteTextField = new JTextField(10);
        add(clienteJLabel);
        add(idClienteTextField);

        JLabel parteContrariaLabel = new JLabel("ID Parte contrária:");
        idParteContrariaTextField = new JTextField(10);
        add(parteContrariaLabel);
        add(idParteContrariaTextField);

        JLabel diaAberturaJLabel = new JLabel("Dia de Abertura do Processo:");
        diaAberturaTextField = new JTextField(10);
        add(diaAberturaJLabel);
        add(diaAberturaTextField);

        JLabel mesAberturaJLabel = new JLabel("Mês de Abertura do Processo:");
        mesAberturaTextField = new JTextField(10);
        add(mesAberturaJLabel);
        add(mesAberturaTextField);

        JLabel anoAberturaJLabel = new JLabel("Ano de Abertura do Processo:");
        anoAberturaTextField = new JTextField(10);
        add(anoAberturaJLabel);
        add(anoAberturaTextField);

        JLabel diaConclusaoLabel = new JLabel("Dia de Conclusão do Processo:");
        diaConclusaoTextField = new JTextField(10);
        add(diaConclusaoLabel);
        add(diaConclusaoTextField);

        JLabel mesConclusaoLabel = new JLabel("Mes de Conclusão do Processo:");
        mesConclusaoTextField = new JTextField(10);
        add(mesConclusaoLabel);
        add(mesConclusaoTextField);

        JLabel anoConclusaoLabel = new JLabel("Ano de Conclusão do Processo:");
        anoConclusaoTextField = new JTextField(10);
        add(anoConclusaoLabel);
        add(anoConclusaoTextField);

        JLabel situacaoLabel = new JLabel("Situação:");
        situacaoTextField = new JTextField(10);
        add(situacaoLabel);
        add(situacaoTextField);

        JButton submitProcessos = new JButton("Salvar");
        add(submitProcessos);

        JButton VoltarBTN = new JButton("Voltar");
        VoltarListener VoltarListener = new VoltarListener(jf);
        VoltarBTN.addActionListener((ActionListener) VoltarListener);

        SubmitProcessosListener submitProcessosAction = new SubmitProcessosListener();
        submitProcessos.addActionListener(submitProcessosAction);

        add(VoltarBTN);
        setVisible(true);
    }

    public class SubmitProcessosListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            Processos Processos = new Processos();

            if (!diaAberturaTextField.getText().isEmpty() && !mesAberturaTextField.getText().isEmpty() && !anoAberturaTextField.getText().isEmpty() && !diaConclusaoTextField.getText().isEmpty() && !mesConclusaoTextField.getText().isEmpty() && !anoConclusaoTextField.getText().isEmpty() && !situacaoTextField.getText().isEmpty()) {

                int diaAbertura = Integer.parseInt(diaAberturaTextField.getText());
                int mesAbertura = Integer.parseInt(mesAberturaTextField.getText()) - 1;
                int anoAbertura = Integer.parseInt(anoAberturaTextField.getText()) - 1900;

                int diaConclusao = Integer.parseInt(diaConclusaoTextField.getText());
                int mesConclusao = Integer.parseInt(mesConclusaoTextField.getText()) - 1;
                int anoConclusao = Integer.parseInt(anoConclusaoTextField.getText()) - 1900;

                Processos.setIdAudiencia(Integer.parseInt(idAudienciaTextField.getText()));
                Processos.setIdNomeCliente(Integer.parseInt(idClienteTextField.getText()));
                Processos.setIdParteContraria(Integer.parseInt(idParteContrariaTextField.getText()));
                Processos.setDataAbertura(new Date(anoAbertura, mesAbertura, diaAbertura));
                Processos.setDataConclusao(new Date(anoConclusao, mesConclusao, diaConclusao));
                Processos.setSituacao(situacaoTextField.getText());

                int id = 0;
                try {
                    id = ProcessosDAO.getInstance().SendProcessosBD(Processos);
                    Processos.setId(id);
                    MostrarProcessos.getInstance().AdicionarInTabela(Processos);
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(null, "Dados inválidos!!", "",
                            JOptionPane.INFORMATION_MESSAGE);
                    ex.printStackTrace();
                }

                jfvoltar.dispose();
            } else {
            JOptionPane.showMessageDialog(null, "Todos os campos devem ser preenchidos!!", "",
                    JOptionPane.INFORMATION_MESSAGE);
            }
        }
    }
}
