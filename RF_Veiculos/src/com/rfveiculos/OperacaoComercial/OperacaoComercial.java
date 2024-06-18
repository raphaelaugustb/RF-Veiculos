package com.rfveiculos.OperacaoComercial;

import com.rfveiculos.models.Veiculo;

import java.time.LocalDate;


public class OperacaoComercial {
    String comprador;
    String vendedor;
    Veiculo veiculo;
    LocalDate dataOperacao;
    String tipoOperacao;
    public OperacaoComercial(String comprador, String vendedor, Veiculo veiculo, String tipoOperacao){
            this.comprador = comprador;
            this.vendedor = vendedor;
            this.veiculo = veiculo;
            dataOperacao = LocalDate.now();
            this.tipoOperacao = tipoOperacao;
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
    public String getTipoOperacao(){
        return tipoOperacao;
    }

    @Override
    public String toString() {
        return "OperacaoComercial{" +
                "comprador='" + comprador + '\'' +
                ", vendedor='" + vendedor + '\'' +
                ", veiculo=" + veiculo +
                ", dataOperacao=" + dataOperacao +
                ", tipoOperacao='" + tipoOperacao + '\'' +
                '}' + "\n";
    }
}
