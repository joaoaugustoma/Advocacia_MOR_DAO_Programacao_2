package gui.table;

import classes.Varas;
import dao.TribunaisDAO;
import dao.VarasDAO;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MostrarResultadoConsultaTribunais extends JPanel {
    JTable table;
    DefaultTableModel mTableModel;
    ResultSet rs;
    Object[] rows;
    public static MostrarResultadoConsultaTribunais instance;

    public static MostrarResultadoConsultaTribunais getInstance(){
        if (instance == null) {
            instance = new MostrarResultadoConsultaTribunais();
        }
        return instance;
    }

    public void mostrarResultadoConsultaTribunais(int id) {
        String[] columnNames = { "nº Vara", "Descrição Vara"};
        // final JTable table = new JTable(data, columnNames);
        mTableModel = new DefaultTableModel(columnNames, 0);
        table = new JTable(mTableModel);
        table.setPreferredScrollableViewportSize(new Dimension(800, 500));
        table.setFillsViewportHeight(true);

        // Create the scroll pane and add the table to it.
        JScrollPane scrollPane = new JScrollPane(table);

        // Add the scroll pane to this panel.
        add(scrollPane);

        AdicionarInfoTabela(id);
        setVisible(false);
    }

    public boolean AdicionarInfoTabela(int id ) {
        try {
            rs = TribunaisDAO.getInstance().consultaVaras(id);
            while (rs.next()) {
                // add the values to the temporary row
                rows = new Object[] {rs.getString("nvaras"), rs.getString("descricao")};
                // add the temp row to the table
                mTableModel.addRow(rows);
            }
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public void AdicionarInTabela(Varas varas){
        mTableModel = (DefaultTableModel) table.getModel();
        rows = new Object[] { varas.getNVaras(), varas.getDescricao()};
        mTableModel.addRow(rows);
    }

    public JTable MontrarTabela() {

        return table;
    }
}
