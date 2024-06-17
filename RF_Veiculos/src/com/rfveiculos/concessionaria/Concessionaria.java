package com.rfveiculos.concessionaria;

import com.rfveiculos.veiculo.Veiculo;

import java.util.*;

public class Concessionaria {
    private String nome;
    private List<Veiculo> veiculosCadastrados;
    private List<Veiculo> veiculosVendidos;
    private List<Veiculo> veiculosComprados;
    public Concessionaria(String nome){
        this.nome = nome;
        this.veiculosCadastrados = new ArrayList<>();
        this.veiculosVendidos = new ArrayList<>();
        this.veiculosComprados = new ArrayList<>();
    }


}
