package dao;

import classes.Tribunais;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TribunaisDAO {
    private String sql;
    private String tabelas = "descricao, endereco";
    private static TribunaisDAO instance;

    public static TribunaisDAO getInstance() {
        if (instance == null) {
            instance = new TribunaisDAO();
        }
        return instance;
    }

    public ResultSet verificarTribunais() {
        sql = "SELECT idtribunais," + tabelas + " , descricao, endereco from tribunais  ";

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
    public int sendTribunaisBD(Tribunais tribunais){
        Statement st;
        int id;
        try {
            String sql = "INSERT INTO tribunais (" + tabelas + ") values (\'" + tribunais.getEndereco() + "\', \'"
                    + tribunais.getDescricao() + "\') RETURNING idtribunais";
            st = JavaDataBaseConnection.getInstance().connection().createStatement();
            ResultSet rs = st.executeQuery(sql);
            if (rs.next()) {
                id = rs.getInt("idtribunais");
                return id;
            }
        } catch (SQLException e) {
            System.out.println("Erro no SQL em SendVarasBD Segue o Log:");
            e.printStackTrace();
        }
        return -1;
    }


    public boolean deleteTribunais(int ID) {
        sql = "delete from tribunais where idtribunais = " + ID;
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

    public ResultSet consultaVaras(int id) throws SQLException {
        sql = "select * from varas where tribunais_idtribunais = " + id;
        Statement Statement = JavaDataBaseConnection.getInstance().connection().createStatement();
        ResultSet resultado = Statement.executeQuery(sql);

        return resultado;
    }
}
