package gui.table;

import classes.Tribunais;
import classes.Varas;
import dao.TribunaisDAO;
import dao.VarasDAO;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MostrarTribunais extends JPanel {

    JTable table;
    DefaultTableModel mTableModel;
    ResultSet rs;
    public static MostrarTribunais instance;
    // Cria uma array temporaria, para adicionar os dados
    Object[] rows;

    public static MostrarTribunais getInstance(){
        if (instance == null) {
            instance = new MostrarTribunais();
        }
        return instance;
    }

    public MostrarTribunais(){
        String[] columnNames = { "idtribunias","Descrição Tribunal", "Endereço Tribunal"};
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
        rs = TribunaisDAO.getInstance().verificarTribunais();

        while (rs.next()) {
            // add the values to the temporary row
            rows = new Object[] {rs.getInt("idtribunais"), rs.getString("descricao"), rs.getString("endereco")};
            // add the temp row to the table
            mTableModel.addRow(rows);
        }
    }

    public void AdicionarInTabela(Tribunais tribunais){
        mTableModel = (DefaultTableModel) table.getModel();
        rows = new Object[] {tribunais.getId(), tribunais.getDescricao(), tribunais.getEndereco()};
        mTableModel.addRow(rows);
    }
    public void RemoveFromTabela(int x){
        mTableModel.removeRow(x);
    }

    public JTable MontrarTabela() {
        return table;
    }
}
