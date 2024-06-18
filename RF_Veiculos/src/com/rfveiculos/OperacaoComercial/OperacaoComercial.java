package com.rfveiculos.OperacaoComercial;

import com.rfveiculos.Veiculo.Veiculo;

import java.time.LocalDate;


public class OperacaoComercial {
    String comprador;
    String vendedor;
    Veiculo veiculo;
    LocalDate dataOperacao;
    public OperacaoComercial(String comprador, String vendedor, Veiculo veiculo){
            this.comprador = comprador;
            this.vendedor = vendedor;
            this.veiculo = veiculo;
            dataOperacao = LocalDate.now();
    }

    public String getVendedor() {
        return vendedor;
    }

    public Veiculo getVeiculo() {
        return veiculo;
    }

    public String getComprador() {
        return comprador;
    }

    @Override
    public String toString() {
        return "OperacaoComercial{" +
                "comprador='" + comprador + '\'' +
                ", vendedor='" + vendedor + '\'' +
                ", veiculo=" + veiculo +
                ", dataOperacao=" + dataOperacao +
                '}';
    }
}
