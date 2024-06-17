package com.rfveiculos.veiculo;

public class Veiculo {
    private String modelo;
    private double preco;
    private String marca;
    private String cor;
    private int anoDeLancamento;
    private String tipoVeiculo;

    public Veiculo(String modelo, double preco, String marca, String cor, int anoDeLancamento) {
        this.modelo = modelo;
        this.preco = preco;
        this.marca = marca;
        this.cor = cor;
        this.anoDeLancamento = anoDeLancamento;
         this.tipoVeiculo = "Veiculo";
    }

    public String getTipoVeiculo() {
        return tipoVeiculo;
    }

    public void setTipoVeiculo(String tipoVeiculo) {
        this.tipoVeiculo = tipoVeiculo;
    }

    public String getModelo() {
        return modelo;
    }

    public int getAnoDeLancamento() {
        return anoDeLancamento;
    }

    public String getCor() {
        return cor;
    }

    public double getPreco() {
        return preco;
    }

    public String getMarca() {
        return marca;
    }

    @Override
    public String toString() {
        return "Veiculo{" +
                "modelo='" + modelo + '\'' +
                ", preco=" + preco +
                ", marca='" + marca + '\'' +
                ", cor='" + cor + '\'' +
                ", anoDeLancamento=" + anoDeLancamento +
                ", tipoVeiculo='" + tipoVeiculo + '\'' +
                '}' + "\n";
    }
}
