package com.rfveiculos.Cliente;


import java.util.Random;

public class Cliente {
    private int id = 1;
    private String cpf;
    private String  nome;


    public Cliente(String nome, String cpf){
        this.nome = nome;
        this.cpf = cpf;
        id = new Random().nextInt();
    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getCpf() {
        return cpf;
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "id=" + id +
                ", cpf='" + cpf + '\'' +
                ", nome='" + nome + '\'' +
                '}';
    }
}
