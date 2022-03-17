package gui.table;

import java.awt.Dimension;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTable.*;
import javax.swing.table.DefaultTableModel;

import dao.VarasDAO;
import classes.Varas;
import gui.table.MostrarVaras;

public class MostrarVaras extends JPanel {

    JTable table;
    DefaultTableModel mTableModel;
    ResultSet rs;
    public static MostrarVaras instance;
    // Cria uma array temporaria, para adicionar os dados
    Object[] rows;

    public static MostrarVaras getInstance(){
        if (instance == null) {
            instance = new MostrarVaras();
        }
        return instance;
    }

    public MostrarVaras(){
        String[] columnNames = { "idvaras","nº Vara", "Descrição Vara"};
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
        rs = VarasDAO.getInstance().Verificarvaras();

        while (rs.next()) {
            // add the values to the temporary row
            rows = new Object[] {rs.getInt("idvaras"), rs.getString("nvaras"), rs.getString("descricao"), rs.getString("tribunais_idtribunais")};
            // add the temp row to the table
            mTableModel.addRow(rows);
        }
    }

    public void AdicionarInTabela(Varas varas){
        mTableModel = (DefaultTableModel) table.getModel();
        rows = new Object[] {varas.getId(), varas.getNVaras(), varas.getDescricao(), varas.getIdtribunais()};
        mTableModel.addRow(rows);
    }
    public void RemoveFromTabela(int x){
        mTableModel.removeRow(x);
    }

    public JTable MontrarTabela() {
        return table;
    }
}
