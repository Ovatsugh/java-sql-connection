package br.com.projetobanco.src.maven;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ConexaoDB {

    public void adduser(String nome, int matricula, double nota) {
        String url = "jdbc:mysql://localhost:3306/turma";
        String user = "root";
        String password = "1234";

        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection connection = DriverManager.getConnection(url, user, password);

            System.out.println("Conectado com sucesso na database " + url);

            String query = "INSERT INTO Aluno(nomeAluno, matriculaAluno, notaAluno)  "
                    + "VALUES(?, ?, ?)";

            // Preparando a consulta SQL
            PreparedStatement pstmt = connection.prepareStatement(query);

            pstmt.setString(1, nome);
            pstmt.setInt(2, matricula);
            pstmt.setDouble(3, nota);
           
            // Executando a consulta
            pstmt.executeUpdate();

            // Fechando recursos
            pstmt.close();
            connection.close();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
