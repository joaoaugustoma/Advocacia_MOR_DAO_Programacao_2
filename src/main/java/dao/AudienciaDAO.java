package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


import classes.Audiencia;

public class AudienciaDAO {
    private String sql;
    String tabelas = "dataaudiencia, parecer";
    private static AudienciaDAO instance;

    public static AudienciaDAO getInstance(){
        if (instance == null) {
            instance = new AudienciaDAO();
        }

        return instance;
    }

    public ResultSet VerificarAudiencia() {
        sql = "SELECT idaudiencias," + tabelas + " from audiencias";
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

    //Envia a audiencia e retorna o seu id
    public int SendAudienciaBD(Audiencia audiencia) {
        Statement st;
        int id;
        try {
            String sql = "INSERT INTO audiencias (" + tabelas + ") values (\'" + audiencia.getData() + "\', \'"
                    + audiencia.getParecer() + "\') RETURNING idaudiencias";
                st = JavaDataBaseConnection.getInstance().connection().createStatement();
                ResultSet rs = st.executeQuery(sql);
                if (rs.next()) {
                    id = rs.getInt("idaudiencias");
                    return id;
                }
        } catch (SQLException e) {
            System.out.println("Erro no SQL em SendAudienciaBD Segue o Log:");
            e.printStackTrace();
        }
        return -1;
    }

    public boolean DeleteAudiencia(int ID){
        sql = "delete from audiencias where idaudiencias = " + ID;
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
