package com.example.javafxproject.funcionario;

import com.example.javafxproject.Conexao;
import com.example.javafxproject.cliente.Cliente;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class FuncionarioDao {
    public Funcionario cadastrar(String nome, String cargo,String dataNascimento) {
        Funcionario funcionario = null;
        String sql = "INSERT INTO Funcionario (nome, cargo, data_nascimento) VALUES (?, ?, ?);";

        try (
                Connection connection = Conexao.getConnection();
                PreparedStatement statement = connection
                        .prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
        ) {
            statement.setString(1, nome);
            statement.setString(1, cargo);
            statement.setString(3, dataNascimento);
            statement.executeUpdate();

            ResultSet rs = statement.getGeneratedKeys();

            if(rs.next()) {
                funcionario = new Funcionario(rs.getInt(1), nome, cargo, dataNascimento);
            }

            rs.close();

            return funcionario;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public List<Funcionario> listarTodos() {
        String sql = "SELECT * FROM Funcionario;";
        List<Funcionario> funcionarios = new ArrayList<>();

        try (
                Connection connection = Conexao.getConnection();
                Statement statement = connection.createStatement();
                ResultSet rs = statement.executeQuery(sql);
        ) {
            while(rs.next()) {
                funcionarios.add(
                        new Funcionario(
                                rs.getInt("id"),
                                rs.getString("nome"),
                                rs.getString("cargo"),
                                rs.getString("dataNascimento")
                        )
                );
            }
        } catch (Exception e) {
            e.printStackTrace();
            return funcionarios;
        }

        return funcionarios;

    }

    public Funcionario buscarPorId(Integer id) {
        String sql = "SELECT * FROM Funcionario WHERE id = ?;";

        try (
                Connection connection = Conexao.getConnection();
                PreparedStatement statement = connection.prepareStatement(sql);
        ) {
            statement.setInt(1, id);
            ResultSet rs = statement.executeQuery();

            if (rs.next()) {
                return new Funcionario(
                        rs.getInt("id"),
                        rs.getString("nome"),
                        rs.getString("cargo"),
                        rs.getString("dataNascimento")
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