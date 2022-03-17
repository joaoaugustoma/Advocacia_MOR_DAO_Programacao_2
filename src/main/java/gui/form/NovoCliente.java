package gui.form;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import classes.PessoaFisica;
import classes.PessoaJuridica;
import dao.PessoaDAO;
import gui.table.MostrarClientes;
import listener.VoltarListener;

public class NovoCliente extends JPanel {

    JTextField nomeTextField, enderecoTextField, cepTextField, bairroTextField, cidadeTextField, ufTextField,
            telefoneTextField, emailTextField, cpfTextField, rgTextField, cnpJTextField;
    public JPanel card1, card2;
    private final JRadioButton pessoaFisicaRadio, pessoaJuridicaRadio;

    JFrame jfvoltar;

    public NovoCliente(JFrame jf) {

        jfvoltar = jf;

        JLabel tipoPessoaLabel = new JLabel("Tipo pessoa:");
        radioButtonHandler radioButtonHandler = new radioButtonHandler();
        pessoaFisicaRadio = new JRadioButton("Pessoa Física", false);
        pessoaFisicaRadio.addItemListener(radioButtonHandler);
        pessoaJuridicaRadio = new JRadioButton("Pessoa Jurídica", false);
        pessoaJuridicaRadio.addItemListener(radioButtonHandler);
        add(tipoPessoaLabel);
        add(pessoaJuridicaRadio);
        add(pessoaFisicaRadio);

        JLabel nomeLabel = new JLabel("Nome completo:");
        nomeTextField = new JTextField(10);
        add(nomeLabel);
        add(nomeTextField);

        JLabel enderecoLabel = new JLabel("Endereco:");
        enderecoTextField = new JTextField(10);
        add(enderecoLabel);
        add(enderecoTextField);

        JLabel cepLabel = new JLabel("CEP:");
        cepTextField = new JTextField(10);
        add(cepLabel);
        add(cepTextField);

        JLabel bairroLabel = new JLabel("Bairro:");
        bairroTextField = new JTextField(10);
        add(bairroLabel);
        add(bairroTextField);

        JLabel cidadeLabel = new JLabel("Cidade:");
        cidadeTextField = new JTextField(10);
        add(cidadeLabel);
        add(cidadeTextField);

        JLabel ufLabel = new JLabel("Estado:");
        ufTextField = new JTextField(10);
        add(ufLabel);
        add(ufTextField);

        JLabel telefoneLabel = new JLabel("Telefone:");
        telefoneTextField = new JTextField(10);
        add(telefoneLabel);
        add(telefoneTextField);

        JLabel emailLabel = new JLabel("E-mail:");
        emailTextField = new JTextField(10);
        add(emailLabel);
        add(emailTextField);

        card1 = new JPanel();
        cpfTextField = new JTextField(11);
        rgTextField = new JTextField(7);
        card1.add(new JLabel("CPF"));
        card1.add(cpfTextField);
        card1.add(new JLabel("RG"));
        card1.add(rgTextField);
        add(card1);
        card1.setVisible(false);

        card2 = new JPanel();
        cnpJTextField = new JTextField(14);
        card2.add(new JLabel("CNPJ"));
        card2.add(cnpJTextField);
        add(card2);
        card2.setVisible(false);

        JButton submitPessoa = new JButton("Salvar");
        add(submitPessoa);

        SubmitPessoaListener submitPessoaAction = new SubmitPessoaListener();
        submitPessoa.addActionListener(submitPessoaAction);

        JButton VoltarBTN = new JButton("Voltar");
        VoltarListener VoltarListener = new VoltarListener(jf);
        VoltarBTN.addActionListener((ActionListener) VoltarListener);
        
        add(VoltarBTN);
        setVisible(true);
    }

    private class radioButtonHandler implements ItemListener {

        @Override
        public void itemStateChanged(ItemEvent event) {
            if (pessoaFisicaRadio.isSelected()) {
                pessoaJuridicaRadio.setSelected(false);
                card1.setVisible(true);
                card2.setVisible(false);
            }
            if (pessoaJuridicaRadio.isSelected()) {
                pessoaFisicaRadio.setSelected(false);
                card1.setVisible(false);
                card2.setVisible(true);
            }
        }
    }

    public class SubmitPessoaListener implements ActionListener {
        PessoaFisica pessoaFisica = new PessoaFisica();
        PessoaJuridica pessoaJuridica = new PessoaJuridica();

        public void actionPerformed(ActionEvent e) {
            if (!nomeTextField.getText().isEmpty() && !enderecoTextField.getText().isEmpty()
                    && !cepTextField.getText().isEmpty() && !bairroTextField.getText().isEmpty()
                    && !cidadeTextField.getText().isEmpty() && !ufTextField.getText().isEmpty()
                    && !telefoneTextField.getText().isEmpty() && !emailTextField.getText().isEmpty()
                    && pessoaFisicaRadio.isSelected()) {
                pessoaFisica.setNome(nomeTextField.getText());
                pessoaFisica.setEndereco(enderecoTextField.getText());
                pessoaFisica.setCep(cepTextField.getText());
                pessoaFisica.setBairro(bairroTextField.getText());
                pessoaFisica.setCidade(cidadeTextField.getText());
                pessoaFisica.setUf(ufTextField.getText());
                pessoaFisica.setTelefone(telefoneTextField.getText());
                pessoaFisica.setEmail(emailTextField.getText());
                pessoaFisica.setCpf(Long.valueOf(cpfTextField.getText()));
                pessoaFisica.setRg(Long.valueOf(rgTextField.getText()));

                MostrarClientes.getInstance().AdicionarFInTabela(pessoaFisica);
                PessoaDAO.getInstance().EnviarPessoaFisica(pessoaFisica);
                jfvoltar.dispose();

            } else if (!nomeTextField.getText().isEmpty() && !enderecoTextField.getText().isEmpty()
                    && !cepTextField.getText().isEmpty() && !bairroTextField.getText().isEmpty()
                    && !cidadeTextField.getText().isEmpty() && !ufTextField.getText().isEmpty()
                    && !telefoneTextField.getText().isEmpty() && !emailTextField.getText().isEmpty()
                    && pessoaJuridicaRadio.isSelected()) {
                pessoaJuridica.setNome(nomeTextField.getText());
                pessoaJuridica.setEndereco(enderecoTextField.getText());
                pessoaJuridica.setCep(cepTextField.getText());
                pessoaJuridica.setBairro(bairroTextField.getText());
                pessoaJuridica.setCidade(cidadeTextField.getText());
                pessoaJuridica.setUf(ufTextField.getText());
                pessoaJuridica.setTelefone(telefoneTextField.getText());
                pessoaJuridica.setEmail(emailTextField.getText());
                pessoaJuridica.setCnpj(Long.valueOf(cnpJTextField.getText()));

                MostrarClientes.getInstance().AdicionarJInTabela(pessoaJuridica);
                PessoaDAO.getInstance().EnviarPessoaJuridica(pessoaJuridica);
                jfvoltar.dispose();
            } else {
                JOptionPane.showMessageDialog(null, "Todos os campos devem ser preenchidos!!", "",
                        JOptionPane.INFORMATION_MESSAGE);
            }
        }
    }
}