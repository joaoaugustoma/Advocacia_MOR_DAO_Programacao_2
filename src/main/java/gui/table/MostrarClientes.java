package gui.table;

import java.awt.Dimension;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTable.*;
import javax.swing.table.DefaultTableModel;

import classes.Pessoa;
import classes.PessoaFisica;
import classes.PessoaJuridica;
import dao.PessoaDAO;

public class MostrarClientes extends JPanel {
    // TODO Adicionar Facha com nome de cliente por cima
    JTable table;
    DefaultTableModel mTableModel;
    ResultSet rs;
    public static MostrarClientes instance;
    // Cria uma array temporaria, para adicionar os dados
    Object[] rows;

    public static MostrarClientes getInstance() {
        if (instance == null) {
            instance = new MostrarClientes();
        }
        return instance;
    }

    public MostrarClientes() {
        String[] columnNames = { "nome", "endereco", "cep", "bairro", "cidade", "uf", "telefone", "email", "CPF", "RG", "CNPJ" };

        // final JTable table = new JTable(data, columnNames);
        mTableModel = new DefaultTableModel(columnNames, 0);
        table = new JTable(mTableModel);
        table.setPreferredScrollableViewportSize(new Dimension(800, 500));
        table.setFillsViewportHeight(true);

        // Create the scroll pane and add the table to it.
        JScrollPane scrollPane = new JScrollPane(table);

        // Add the scroll pane to this panel.
        add(scrollPane);

        try {
            AdicionarInfoTabela();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void AdicionarInfoTabela() throws SQLException {
        rs = PessoaDAO.getInstance().VerificarPessoa();

        while (rs.next()) {
            // add the values to the temporary row
            rows = new Object[] { rs.getString("nome"), rs.getString("endereco"), rs.getString("cep"),
                    rs.getString("bairro"), rs.getString("cidade"), rs.getString("uf"), rs.getString("telefone"),
                    rs.getString("email"), rs.getString("cpf"), rs.getString("rg"), rs.getString("cnpj") };
            // add the temp row to the table
            mTableModel.addRow(rows);
        }
    }

    public void AdicionarJInTabela(PessoaJuridica pessoa) {
        mTableModel = (DefaultTableModel) table.getModel();
        rows = new Object[] { pessoa.getNome(), pessoa.getEndereco(), pessoa.getCep(), pessoa.getBairro(),
                pessoa.getCidade(), pessoa.getUf(), pessoa.getTelefone(0), pessoa.getEmail(),"","",pessoa.getCnpj() };
        mTableModel.addRow(rows);
    }

    public void AdicionarFInTabela(PessoaFisica pessoa) {
        mTableModel = (DefaultTableModel) table.getModel();
        rows = new Object[] { pessoa.getNome(), pessoa.getEndereco(), pessoa.getCep(), pessoa.getBairro(),
                pessoa.getCidade(), pessoa.getUf(), pessoa.getTelefone(0), pessoa.getEmail(),pessoa.getCpf(),pessoa.getRg(),"" };
        mTableModel.addRow(rows);
    }

    public JTable MontarTabela() {
        return table;
    }
}