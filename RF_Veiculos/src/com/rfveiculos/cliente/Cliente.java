package com.rfveiculos.cliente;

import com.rfveiculos.veiculo.Veiculo;

import java.util.*;

public class Cliente {
    private String nome;
    private double saldo;
    private List<Veiculo> veiculosComprados;
    private List<Veiculo> veiculosVendidos;
    public Cliente(String nome, double saldo){
        this.nome = nome;
        this.saldo = saldo;
        veiculosComprados = new ArrayList<>();
        veiculosVendidos = new ArrayList<>();
    }
}
