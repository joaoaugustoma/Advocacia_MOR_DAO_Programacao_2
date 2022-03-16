package gui.table;

import java.awt.Dimension;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import classes.Audiencia;
import classes.PessoaJuridica;
import dao.AudienciaDAO;
import dao.PessoaDAO;

public class MostrarAudiencia extends JPanel {
    // TODO Adicionar Facha com nome de cliente por cima
    JTable table;
    DefaultTableModel mTableModel;
    ResultSet rs;
    public static MostrarAudiencia instance;
    // Cria uma array temporaria, para adicionar os dados
    Object[] rows;

    public static MostrarAudiencia getInstance() {
        if (instance == null) {
            instance = new MostrarAudiencia();
        }
        return instance;
    }

    public MostrarAudiencia() {
        String[] columnNames = {"idaudiencias", "dataaudiencia", "parecer" };

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
        rs = AudienciaDAO.getInstance().VerificarAudiencia();

        while (rs.next()) {
            // add the values to the temporary row
            rows = new Object[] { rs.getInt("idaudiencias"), rs.getString("dataaudiencia"), rs.getString("parecer")};
            // add the temp row to the table
            mTableModel.addRow(rows);
        }
    }

    public void AdicionarInTabela(Audiencia audiencia) {
        mTableModel = (DefaultTableModel) table.getModel();
        rows = new Object[] {audiencia.getId(), audiencia.getData(), audiencia.getParecer()};
        mTableModel.addRow(rows);
    }

    public void RemoveFromTabela(int x){
        mTableModel.removeRow(x);
    }

    public JTable MontrarTabela() {
        return table;
    }
}