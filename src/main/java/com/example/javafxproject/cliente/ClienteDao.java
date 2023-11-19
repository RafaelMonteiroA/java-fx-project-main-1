package com.example.javafxproject.cliente;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.example.javafxproject.Conexao;

public class ClienteDao {
    public Cliente cadastrar(String nome, String dataNascimento) {
        Cliente cliente = null;
        String sql = "INSERT INTO clientes (nome, data_nascimento) VALUES (?, ?);";

        try (
                Connection connection = Conexao.getConnection();
                PreparedStatement statement = connection
                        .prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
        ) {
            statement.setString(1, nome);
            statement.setString(2, dataNascimento);
            statement.executeUpdate();

            ResultSet rs = statement.getGeneratedKeys();

            if(rs.next()) {
                cliente = new Cliente(rs.getInt(1), nome, dataNascimento);
            }

            rs.close();

            return cliente;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public List<Cliente> listarTodos() {
        String sql = "SELECT * FROM clientes;";
        List<Cliente> clientes = new ArrayList<>();

        try (
                Connection connection = Conexao.getConnection();
                Statement statement = connection.createStatement();
                ResultSet rs = statement.executeQuery(sql);
        ) {
            while(rs.next()) {
                clientes.add(
                        new Cliente(
                                rs.getInt("id"),
                                rs.getString("nome"),
                                rs.getString("dataNascimento")
                        )
                );
            }
        } catch (Exception e) {
            e.printStackTrace();
            return clientes;
        }

        return clientes;

    }

    public Cliente buscarPorId(Integer id) {
        String sql = "SELECT * FROM clientes WHERE id = ?;";

        try (
                Connection connection = Conexao.getConnection();
                PreparedStatement statement = connection.prepareStatement(sql);
        ) {
            statement.setInt(1, id);
            ResultSet rs = statement.executeQuery();

            if (rs.next()) {
                return new Cliente(
                        rs.getInt("id"),
                        rs.getString("nome"),
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