package com.example.javafxproject;

import com.example.javafxproject.cliente.Cliente;
import com.example.javafxproject.cliente.ClienteDao;

import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;

public class CadastroClienteController {
    @FXML
    private TextField txfNome;
    @FXML
    private TextField txfDataNascimento;

    public void onActionCadastrar() {
        String nome = txfNome.getText();
        String dataNascimento = txfDataNascimento.getText();

        System.out.println(nome);
        System.out.println(dataNascimento);

        ClienteDao clienteDao = new ClienteDao();
        Cliente cliente = clienteDao.cadastrar(nome, dataNascimento);

        System.out.println(cliente.getId());
        System.out.println(cliente.getNome());
        System.out.println(cliente.getDataNascimento());
    }

}