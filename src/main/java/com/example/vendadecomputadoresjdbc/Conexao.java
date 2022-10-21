package com.example.vendadecomputadoresjdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {
    String url;
    String user;
    String password;


    public static Connection connection;

    public Conexao(String url, String user, String password) throws ClassNotFoundException, SQLException {

        this.url = url;
        this.user = user;
        this.password = password;


    }

    public void realizaConexao() throws SQLException {
        try {
            //Aqui passamos o caminho do driver que conecta com nosso banco
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection(url,
                    user, password);


        } catch (Error | SQLException e) {
            System.out.println("Erro na conexao com o banco de dados");
        } catch (ClassNotFoundException e) {
            System.out.println("Classe nao encontrada");
            throw new RuntimeException(e);
        }

    }

    public Connection getConnection() {
        return connection;
    }

    public void fechaConexao() throws SQLException {
        connection.close();

    }


}
