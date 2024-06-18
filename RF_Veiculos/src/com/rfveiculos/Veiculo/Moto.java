package com.rfveiculos.Veiculo;

import com.rfveiculos.models.Veiculo;

public class Moto extends Veiculo {
    String tipoVeiculo;
    public Moto(String modelo, double preco, String marca, String cor, int anoDeLancamento) {
        super(modelo, preco, marca, cor, anoDeLancamento);
        this.setTipoVeiculo("Moto");
    }
}
