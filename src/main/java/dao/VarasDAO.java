package dao;

import classes.Varas;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class VarasDAO {
    private  String sql;
    String tabelas = "nvaras, descricao";
    private static VarasDAO instance;

    // Singleton varasDAO
    public static VarasDAO getInstance() {
        if (instance == null) {
            instance = new VarasDAO();
        }

        return instance;
    }

    // Busca todos as varas existentes de um banco de dados, e a coloca em um
    //vetor
    public ResultSet Verificarvaras() {
        sql = "SELECT idvaras," + tabelas + " , nvaras, descricao from varas  ";

        try {
            Statement Statement = JavaDataBaseConnection.getInstance().connection().createStatement();
            ResultSet resultado = Statement.executeQuery(sql);

            return  resultado;
        } catch (SQLException e) {
            System.out.println("Falha em buscar dados no banco de dados!!!");
            e.printStackTrace();
        }
        return null;
    }



    //Envia a pessoa e retorna o seu id
    public int SendvarasBD(Varas varas){
        Statement st;
        int id;
        try {
            String sql = "INSERT INTO varas (" + tabelas + ") values (\'" + varas.getNVaras() + "\', \'"
                    + varas.getDescricao() + "\') RETURNING idvaras";
            st = JavaDataBaseConnection.getInstance().connection().createStatement();
            ResultSet rs = st.executeQuery(sql);
            if (rs.next()) {
                id = rs.getInt("idvaras");
                return id;
            }
        } catch (SQLException e) {
            System.out.println("Erro no SQL em SendVarasBD Segue o Log:");
            e.printStackTrace();
        }
        return -1;
    }


    public boolean DeleteVaras(int ID) {
        sql = "delete from varas where idvaras = " + ID;
        try {
            PreparedStatement prepareStatement = JavaDataBaseConnection.getInstance().connection().prepareStatement(sql);
            prepareStatement.executeUpdate();
            prepareStatement.close();
            System.out.println(sql);
            return true;

        } catch (SQLException e) {
            e.getSQLState();
            return false;
        }
    }
}
