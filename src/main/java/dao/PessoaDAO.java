package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import classes.Pessoa;
import classes.PessoaFisica;
import classes.PessoaJuridica;

@SuppressWarnings("SqlResolve")
public class PessoaDAO {
    private String sql;
    String tabelas = "nome, endereco, cep, bairro, cidade, uf, telefone, email";
    private static PessoaDAO instance;

    // Singleton PessoaDAO
    public static PessoaDAO getInstance() {
        if (instance == null) {
            instance = new PessoaDAO();
        }

        return instance;
    }

    // Busca todos as pessoas existentes de um banco de dados, e a coloca em um
    // vetor
    public ResultSet VerificarPessoa() {
        sql = "SELECT idpessoa," + tabelas
                + " , pf.cpf, pf.rg, pj.cnpj from PESSOA p LEFT JOIN PESSOAFISICA pf ON pf.PESSOA_IDPESSOA = p.IDPESSOA LEFT JOIN PESSOAJURIDICA pj ON pj.PESSOA_IDPESSOA = p.IDPESSOA;";
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

    public void EnviarPessoaFisica(PessoaFisica pessoaFisica) {
        // Não achei uma melhor solução
        // Gambiarra, manda informação das pessoas, e retorna o ID para ser usado por
        // pessoa Juridica
        int id = SendPessoaBD(pessoaFisica);
        try {
            String sql = "INSERT INTO pessoafisica (cpf,rg,pessoa_idpessoa) values (?,?,?)";
            PreparedStatement prepareStatement = JavaDataBaseConnection.getInstance().connection()
                    .prepareStatement(sql);
            prepareStatement.setLong(1, pessoaFisica.getCpf());
            prepareStatement.setLong(2, pessoaFisica.getRg());
            prepareStatement.setLong(3, id);

            prepareStatement.executeUpdate();
            prepareStatement.close();
        } catch (SQLException e) {
            System.out.println("Não foi possivel inserir pessoa juridica");
            e.getSQLState();
        }
    }

    public void EnviarPessoaJuridica(PessoaJuridica pessoaJuridica) {
        // Não achei uma melhor solução
        // Gambiarra, manda informação das pessoas, e retorna o ID para ser usado por
        // pessoa Juridica
        int id = SendPessoaBD(pessoaJuridica);
        try {
            String sql = "INSERT INTO PESSOAJURIDICA (CNPJ, PESSOA_IDPESSOA) VALUES (?, ?);";
            PreparedStatement prepareStatement = JavaDataBaseConnection.getInstance().connection()
                    .prepareStatement(sql);
            prepareStatement.setLong(1, pessoaJuridica.getCnpj());
            prepareStatement.setLong(2, id);

            prepareStatement.executeUpdate();
            prepareStatement.close();
        } catch (SQLException e) {
            System.out.println("Não foi possivel inserir pessoa juridica");
            e.getSQLState();
        }
    }

    // Envia a pessoa e retorna o seu id
    int SendPessoaBD(Pessoa pessoa) {
        Statement st;
        int id;
        try {
            String sql = "INSERT INTO pessoa (" + tabelas + ") values (\'" + pessoa.getNome() + "\', \'"
                    + pessoa.getEndereco() + "\', \'" + pessoa.getCep() + "\', \'" + pessoa.getBairro() + "\', \'"
                    + pessoa.getCidade() + "\', \'" + pessoa.getUf() + "\', \'" + pessoa.getTelefone(0) + "\', \'"
                    + pessoa.getEmail() + "\') RETURNING idpessoa";
            st = JavaDataBaseConnection.getInstance().connection().createStatement();
            ResultSet rs = st.executeQuery(sql);
            if (rs.next()) {
                id = rs.getInt("idpessoa");
                return id;
            }
        } catch (SQLException e) {
            System.out.println("Erro no SQL em SendPessoaBD Segue o Log:");
            e.printStackTrace();
        }
        return -1;
    }

    public boolean PessoaFisicaExist(String cpf) { // Conferir se funciona
        boolean flag = false;
        sql = "SELECT cpf FROM pessoafisica";
        try {
            Statement Statement = JavaDataBaseConnection.getInstance().connection().createStatement();
            ResultSet resultado = Statement.executeQuery(sql);

            while (resultado.next()) {
                String cpfBD = resultado.getString("cpf");
                if (cpfBD.intern() == cpf.intern()) {
                    flag = true;
                }
            }
        } catch (SQLException e) {
            System.out.println("Falha em buscar dados no banco de dados!!!");
            e.getSQLState();
        }
        return flag;
    }

    // Arrumar
    public boolean PessoaJuridicaExist(String cnpj) { // Conferir se funciona
        boolean flag = false;
        sql = "SELECT cnpj FROM pessoajuridica";
        try {
            Statement Statement = JavaDataBaseConnection.getInstance().connection().createStatement();
            ResultSet resultado = Statement.executeQuery(sql);

            while (resultado.next()) {
                String cnpjBD = resultado.getString("cnpj");
                if (cnpjBD.intern() == cnpj.intern()) {
                    flag = true;
                }
            }
        } catch (SQLException e) {
            System.out.println("Falha em buscar dados no banco de dados!!!");
            e.getSQLState();
        }
        return flag;
    }

    public boolean DeletePessoa(int ID) {
        sql = "DELETE from pessoafisica WHERE pessoa_idpessoa = " + ID
                + ";DELETE from pessoajuridica WHERE pessoa_idpessoa = " + ID + ";DELETE FROM pessoa WHERE idpessoa = "
                + ID + ";";
        try {
            PreparedStatement prepareStatement = JavaDataBaseConnection.getInstance().connection()
                    .prepareStatement(sql);
            prepareStatement.executeUpdate();
            prepareStatement.close();

            return true;
        } catch (SQLException e) {
            e.getSQLState();
            return false;
        }
    }
}