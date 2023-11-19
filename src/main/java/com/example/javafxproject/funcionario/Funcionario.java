package com.example.javafxproject.funcionario;

public class Funcionario {
    private Integer id;
    private String nome;
    private String cargo;
    private String dataNascimento;

    public Funcionario(Integer id, String nome, String cargo, String dataNascimento) {
        this.id = id;
        this.nome = nome;
        this.cargo = cargo;
        this.dataNascimento = dataNascimento;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public String getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(String dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

}