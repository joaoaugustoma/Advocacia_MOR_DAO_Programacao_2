package gui.table;

import java.awt.Dimension;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import classes.Custas;
import classes.PessoaJuridica;
import dao.CustasDAO;
import dao.PessoaDAO;

public class MostrarCustas extends JPanel {
    // TODO Adicionar Facha com nome de cliente por cima
    JTable table;
    DefaultTableModel mTableModel;
    ResultSet rs;
    public static MostrarCustas instance;
    // Cria uma array temporaria, para adicionar os dados
    Object[] rows;

    public static MostrarCustas getInstance() {
        if (instance == null) {
            instance = new MostrarCustas();
        }
        return instance;
    }

    public MostrarCustas() {
        String[] columnNames = {"idCustas", "Nº do Processo", "Data do lançamento da custas", "Descrição", "Valor" };

        // final JTable table = new JTable(data, columnNames);
        mTableModel = new DefaultTableModel(columnNames, 0);
        table = new JTable(mTableModel);
        table.setPreferredScrollableViewportSize(new Dimension(800, 500));
        table.setFillsViewportHeight(true);
        table.getColumnModel().getColumn(0).setMinWidth(0);
        table.getColumnModel().getColumn(0).setMaxWidth(0);

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
        rs = CustasDAO.getInstance().VerificarCustas();

        while (rs.next()) {
            // add the values to the temporary row
            rows = new Object[] { rs.getInt("idCustas"), rs.getString("processos_idprocessos"), rs.getString("dataCusta"), rs.getString("descricao"), rs.getString("valor")};
            // add the temp row to the table
            mTableModel.addRow(rows);
        }
    }

    public void AdicionarInTabela(Custas Custas) throws SQLException{
        mTableModel = (DefaultTableModel) table.getModel();
        rows = new Object[] {Custas.getId(), Custas.getnProcessos(), Custas.getData(), Custas.getDescricao(), Custas.getValor()};
        mTableModel.addRow(rows);
    }

    public void RemoveFromTabela(int x){
        mTableModel.removeRow(x);
    }

    public JTable MontrarTabela() {
        return table;
    }
}