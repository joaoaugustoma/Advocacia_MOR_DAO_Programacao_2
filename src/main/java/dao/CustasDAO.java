package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import classes.Custas;

public class CustasDAO {
    private String sql;
    String tabelas = "processos_idprocessos, dataCusta, descricao, valor ";
    private static CustasDAO instance;

    public static CustasDAO getInstance(){
        if (instance == null) {
            instance = new CustasDAO();
        }

        return instance;
    }

    public ResultSet VerificarCustas() {
        sql = "SELECT idcustas," + tabelas + " from custas";
        try {
            Statement Statement = JavaDataBaseConnection.getInstance().connection().createStatement();
            ResultSet resultado = Statement.executeQuery(sql);

            return resultado;
        } catch (SQLException e) {
            System.out.println("Falha em buscar dados no banco de dados!!!");
            e.printStackTrace();
        }
        return null;
    }

    //Envia a Custas e retorna o seu id
    public int SendCustasBD(Custas Custas) {
        Statement st;
        int id;
        try {
            String sql = "INSERT INTO custas (" + tabelas + ") values (\'" + Custas.getnProcessos() + "\', \'" + Custas.getData() + "\', \'" + Custas.getDescricao() + "\', \'" + Custas.getValor() + "\') RETURNING idcustas";
            st = JavaDataBaseConnection.getInstance().connection().createStatement();
            ResultSet rs = st.executeQuery(sql);
            if (rs.next()) {
                id = rs.getInt("idcustas");
                return id;
            }
        } catch (SQLException e) {
            System.out.println("Erro no SQL em SendCustasBD Segue o Log:");
            e.printStackTrace();
        }
        return -1;
    }

    public boolean DeleteCustas(int ID){
        sql = "delete from Custass where idCustas = " + ID;
        try {
            PreparedStatement prepareStatement = JavaDataBaseConnection.getInstance().connection().prepareStatement(sql);
            prepareStatement.executeUpdate();
            prepareStatement.close();
            return true;

        } catch (SQLException e) {
            e.getSQLState();
            return false;
        }
    }

}
