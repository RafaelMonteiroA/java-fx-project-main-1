package com.example.javafxproject;

import com.example.javafxproject.CadastroSabor.CadastroSaborDAO;
import com.example.javafxproject.CadastroSabor.CadastroSabores;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

import java.sql.SQLException;

public class CadastroSaborController {
    @FXML
    private TextField txfId;
    @FXML
    private TextField txfSabor;
    @FXML
    private TextField txfPreco;

    @FXML
    public void onActionCadastrarSabor() throws SQLException {
        String sabor = txfSabor.getText();
        String preco = txfPreco.getText();

        System.out.println(sabor);
        System.out.println(preco);

        CadastroSaborDAO cadastroSaborDAO = new CadastroSaborDAO();
        CadastroSabores cadastroSabores = cadastroSaborDAO.cadastrar(preco, sabor);

        System.out.println(cadastroSabores.getId());
        System.out.println(cadastroSabores.getPreco());
        System.out.println(cadastroSabores.getsabor());
    }
}