package com.example.javafxproject.CadastroSabor;

public class CadastroSabores {
    private Integer id;
    private String preco;
    private String sabor;

    public CadastroSabores(Integer id, String preco, String sabor) {
        this.id = id;
        this.preco = preco;
        this.sabor = sabor;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPreco() {
        return preco;
    }

    public void setPreco(String preco) {
        this.preco = preco;
    }

    public String getsabor() {
        return sabor;
    }

    public void setsabor(String sabor) {
        this.sabor = sabor;
    }

}
