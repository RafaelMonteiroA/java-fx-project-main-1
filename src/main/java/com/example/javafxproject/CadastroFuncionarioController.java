package com.example.javafxproject;

import com.example.javafxproject.cliente.Cliente;
import com.example.javafxproject.cliente.ClienteDao;
import com.example.javafxproject.funcionario.Funcionario;
import com.example.javafxproject.funcionario.FuncionarioDao;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class CadastroFuncionarioController {
    @FXML
    private TextField txfNome;
    @FXML
    private TextField txfCargo;
    @FXML
    private TextField txfDataNascimento;

    public void onActionCadastrar() {
        String nome = txfNome.getText();
        String cargo = txfCargo.getText();
        String dataNascimento = txfDataNascimento.getText();

        System.out.println(nome);
        System.out.println(cargo);
        System.out.println(dataNascimento);

        FuncionarioDao funcionarioDao = new FuncionarioDao();
        Funcionario funcionario = funcionarioDao.cadastrar(nome, cargo, dataNascimento);

        System.out.println(funcionario.getId());
        System.out.println(funcionario.getNome());
        System.out.println(funcionario.getCargo());
        System.out.println(funcionario.getDataNascimento());
    }

}