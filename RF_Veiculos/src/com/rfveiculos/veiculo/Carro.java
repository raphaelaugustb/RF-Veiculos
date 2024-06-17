package com.rfveiculos.veiculo;

public class Carro  extends Veiculo{
    public Carro(String modelo, double preco, String marca, String cor, int anoDeLancamento) {
        super(modelo, preco, marca, cor, anoDeLancamento);
        this.setTipoVeiculo("Carro");
    }


}
