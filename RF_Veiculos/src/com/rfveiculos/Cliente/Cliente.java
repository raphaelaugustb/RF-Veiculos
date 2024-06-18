package com.rfveiculos.Cliente;

import com.rfveiculos.models.Comercial;


public class Cliente {
    private int id = 1;
    private String cpf;
    private String  nome;
    public void CalcularId() {
        id++;
    }

    public Cliente(String nome, String cpf){
        this.nome = nome;
        this.cpf = cpf;
        id ++;
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
