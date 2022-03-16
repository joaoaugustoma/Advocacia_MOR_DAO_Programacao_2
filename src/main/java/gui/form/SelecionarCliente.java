package gui.form;

import java.awt.CardLayout;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import classes.PessoaFisica;
import classes.PessoaJuridica;
import dao.PessoaDAO;
import gui.table.MostarAudiencia;

public class SelecionarCliente extends JPanel{
    JTextField cpfTextField, cnpJTextField;
    public JPanel card1, card2;
    private final JRadioButton pessoaFisicaRadio, pessoaJuridicaRadio;

    public SelecionarCliente() {
        JLabel tipoPessoaLabel = new JLabel("Selecione o tipo de pessoa:");
        radioButtonHandler radioButtonHandler = new radioButtonHandler();
        pessoaFisicaRadio = new JRadioButton("Pessoa Física", false);
        pessoaFisicaRadio.addItemListener(radioButtonHandler);
        pessoaJuridicaRadio = new JRadioButton("Pessoa Jurídica", false);
        pessoaJuridicaRadio.addItemListener(radioButtonHandler);
        add(tipoPessoaLabel);
        add(pessoaJuridicaRadio);
        add(pessoaFisicaRadio);

        card1 = new JPanel();
        cpfTextField = new JTextField(11);
        card1.add(new JLabel("CPF"));
        card1.add(cpfTextField);
        add(card1);
        card1.setVisible(false);

        card2 = new JPanel();
        cnpJTextField = new JTextField(14);
        card2.add(new JLabel("CNPJ"));
        card2.add(cnpJTextField);
        add(card2);
        card2.setVisible(false);

        JButton removerPessoa = new JButton("remover pessoa");
        add(removerPessoa);

        RemoverPessoaListener removerPessoaAction = new RemoverPessoaListener();
        removerPessoa.addActionListener(removerPessoaAction);

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

    public class RemoverPessoaListener implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            if (pessoaFisicaRadio.isSelected() && !cpfTextField.getText().isEmpty()) {
                if(PessoaDAO.getInstance().PessoaFisicaExist(cpfTextField.getText())){
                    
                    PessoaDAO.getInstance().DeletePessoaFisica(cpfTextField.getText());
                    if(!PessoaDAO.getInstance().PessoaFisicaExist(cpfTextField.getText()))
                        JOptionPane.showMessageDialog(null, "Usúario removido!!", "",
                        JOptionPane.INFORMATION_MESSAGE);
                    else
                        JOptionPane.showMessageDialog(null, "Não foi possível remover do Banco de Dados!!", "",
                        JOptionPane.INFORMATION_MESSAGE);
                    
                        // Precisa arrumar tabela
                    //MostrarClientes.getInstance().AdicionarFInTabela(pessoaFisica); 
                    //PessoaDAO.getInstance().EnviarPessoaFisica(pessoaFisica);
                }
                else
                    JOptionPane.showMessageDialog(null, "Pessoa não encontrada!!", "",
                    JOptionPane.INFORMATION_MESSAGE);

            } else if (pessoaJuridicaRadio.isSelected() && !cnpJTextField.getText().isEmpty()) {
                if(PessoaDAO.getInstance().PessoaJuridicaExist(cnpJTextField.getText())){
                    
                    PessoaDAO.getInstance().DeletePessoaJuridica(cnpJTextField.getText());
                    if(!PessoaDAO.getInstance().PessoaJuridicaExist(cnpJTextField.getText()))
                        JOptionPane.showMessageDialog(null, "Usúario removido!!", "",
                        JOptionPane.INFORMATION_MESSAGE);
                    else
                        JOptionPane.showMessageDialog(null, "Não foi possível remover do Banco de Dados!!", "",
                        JOptionPane.INFORMATION_MESSAGE);
                    
                        // Precisa arrumar tabela
                    //MostrarClientes.getInstance().AdicionarFInTabela(pessoaFisica); 
                }
                else
                    JOptionPane.showMessageDialog(null, "Pessoa não encontrada!!", "",
                    JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null, "Todos os campos devem ser preenchidos!!", "",
                        JOptionPane.INFORMATION_MESSAGE);
            }
        }
    }
}
