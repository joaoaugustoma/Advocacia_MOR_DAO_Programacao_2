package gui.table;

import java.awt.Dimension;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTable.*;
import javax.swing.table.DefaultTableModel;

import dao.ProcessosDAO;
import classes.Processos;
import gui.table.MostrarProcessos;

public class MostrarProcessos extends JPanel {

    JTable table;
    DefaultTableModel mTableModel;
    ResultSet rs;
    public static MostrarProcessos instance;
    // Cria uma array temporaria, para adicionar os dados
    Object[] rows;

    public static MostrarProcessos getInstance(){
        if (instance == null) {
            instance = new MostrarProcessos();
        }
        return instance;
    }

    public MostrarProcessos(){
        String[] columnNames = { "Nº Processo","Data Abertura", "Data Conclusão", "Situação"};
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
        rs = ProcessosDAO.getInstance().VerificarProcessos();

        while (rs.next()) {
            // add the values to the temporary row
            rows = new Object[] {rs.getInt("idProcessos"), rs.getString("dataabertura"), rs.getString("dataconclusao"), rs.getString("situacao")};
            // add the temp row to the table
            mTableModel.addRow(rows);
        }
    }

    public void AdicionarInTabela(Processos processos){
        mTableModel = (DefaultTableModel) table.getModel();
        rows = new Object[] {processos.getId(), processos.getDataAbertura(), processos.getDataConclusao(), processos.getSituacao()};
        mTableModel.addRow(rows);
    }
    public void RemoveFromTabela(int x){
        mTableModel.removeRow(x);
    }

    public JTable MontrarTabela() {
        return table;
    }
}
