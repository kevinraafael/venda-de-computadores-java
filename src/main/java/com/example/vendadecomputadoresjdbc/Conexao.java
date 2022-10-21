package com.example.vendadecomputadoresjdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Conexao {
    String url = "jdbc:postgresql://localhost:5432/postgres";
    String user = "postgres";
    String password = "postgres";
    public Connection connection;

    public Conexao(String url, String user, String password) throws ClassNotFoundException, SQLException {

        this.url = url;
        this.user = user;
        this.password = password;


    }

    public void realizaConexao() throws SQLException {
        try{
            Class.forName("org.postgresql.Driver"); //Aqui passamos o caminho do drive que conecta com nosso banco
            connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres",
                    "postgres", "1234");

            ResultSet userTest = connection.createStatement().executeQuery("select * from pessoa");
            while (userTest.next()) {
                System.out.println(userTest.getString("nome"));
            }
        }catch (Error | SQLException e){
            System.out.println("Erro na conexao com o banco de dados");
        } catch (ClassNotFoundException e) {
            System.out.println("Classe nao encontrada");
            throw new RuntimeException(e);
        }finally {
            connection.close();
        }

    }



}
