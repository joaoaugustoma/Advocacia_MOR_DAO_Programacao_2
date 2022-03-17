package dao;

import classes.Processos;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class ProcessosDAO {
    private  String sql;
    String tabelas = "dataabertura, dataconclusao, situacao";
    private static ProcessosDAO instance;

    // Singleton ProcessosDAO
    public static ProcessosDAO getInstance() {
        if (instance == null) {
            instance = new ProcessosDAO();
        }

        return instance;
    }

    // Busca todos as Processos existentes de um banco de dados, e a coloca em um
    //vetor
    public ResultSet VerificarProcessos() {
        sql = "SELECT idprocessos," + tabelas + " from Processos  ";

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
    public int SendProcessosBD(Processos Processos){
        Statement st;
        int id;
        try {
            String sql = "INSERT INTO Processos (" + tabelas + ") values (\'" + Processos.getDataAbertura() + "\', \'"
                    + Processos.getDataConclusao() + "\',\'" + Processos.getSituacao() + "\') RETURNING idprocessos";
            st = JavaDataBaseConnection.getInstance().connection().createStatement();
            ResultSet rs = st.executeQuery(sql);
            if (rs.next()) {
                id = rs.getInt("idprocessos");
                return id;
            }
        } catch (SQLException e) {
            System.out.println("Erro no SQL em SendProcessosBD Segue o Log:");
            e.printStackTrace();
        }
        return -1;
    }


    public boolean deleteProcessos(int ID) {
        sql = "delete from Processos where idprocessos = " + ID;
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
