package dao;

import java.sql.*;

public class JavaDataBaseConnection {
    Connection connection;

    private static JavaDataBaseConnection instance;

    public static JavaDataBaseConnection getInstance(){
        if (instance == null){
            instance = new JavaDataBaseConnection();
        }

        return instance;
    }

    public Connection connection() {
        String url = "jdbc:postgresql:unsoutrosassociados";
        String user = "postgres";
        String pwd = "1234os";

        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("Driver não encontrado!" + e);
        }

        try {
            connection = DriverManager.getConnection(url, user, pwd);
            Statement statement = connection.createStatement();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return connection;
    }
}