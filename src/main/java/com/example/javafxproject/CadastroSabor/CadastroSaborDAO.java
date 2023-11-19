package com.example.javafxproject.CadastroSabor;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.example.javafxproject.Conexao;

public class CadastroSaborDAO {
    public CadastroSabores cadastrar(String preco, String sabor) {
        CadastroSabores cadastroSabores = null;
        String sql = "INSERT INTO CadastroSabores (preco, sabor) VALUES (?, ?);";

        try (
                Connection connection = Conexao.getConnection();
                PreparedStatement statement = connection
                        .prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
        ) {
            statement.setString(1, preco);
            statement.setString(2, sabor);
            statement.executeUpdate();

            ResultSet rs = statement.getGeneratedKeys();

            if(rs.next()) {
                cadastroSabores = new CadastroSabores(rs.getInt(1), preco, sabor);
            }

            rs.close();

            return cadastroSabores;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public List<CadastroSabores> listarTodos() {
        String sql = "SELECT * FROM CadastroSabores;";
        List<CadastroSabores> cadastroSabores = new ArrayList<>();

        try (
                Connection connection = Conexao.getConnection();
                Statement statement = connection.createStatement();
                ResultSet rs = statement.executeQuery(sql);
        ) {
            while(rs.next()) {
                cadastroSabores.add(
                        new CadastroSabores(
                                rs.getInt("id"),
                                rs.getString("preco"),
                                rs.getString("sabor")
                        )
                );
            }
        } catch (Exception e) {
            e.printStackTrace();
            return cadastroSabores;
        }

        return cadastroSabores;

    }

    public CadastroSabores buscarPorId(Integer id) {
        String sql = "SELECT * FROM CadastroSabores WHERE id = ?;";

        try (
                Connection connection = Conexao.getConnection();
                PreparedStatement statement = connection.prepareStatement(sql);
        ) {
            statement.setInt(1, id);
            ResultSet rs = statement.executeQuery();

            if (rs.next()) {
                return new CadastroSabores(
                        rs.getInt("id"),
                        rs.getString("preco"),
                        rs.getString("sabor")
                );
            }

            rs.close();

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

        return null;
    }
}