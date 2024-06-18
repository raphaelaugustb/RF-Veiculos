package com.rfveiculos.OperacaoComercial;

import com.rfveiculos.models.Veiculo;

import java.time.LocalDate;


public class OperacaoComercial {
    String comprador;
    String vendedor;
    Veiculo veiculo;
    LocalDate dataOperacao;
    String tipoOperacao;
    String cpfCliente;
    public OperacaoComercial(String comprador, String vendedor, Veiculo veiculo, String tipoOperacao, String cpfCliente){
            this.comprador = comprador;
            this.vendedor = vendedor;
            this.veiculo = veiculo;
            dataOperacao = LocalDate.now();
            this.tipoOperacao = tipoOperacao;
           this.cpfCliente = cpfCliente;
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

    public String getCpfCliente() {
        return cpfCliente;
    }

    public LocalDate getDataOperacao() {
        return dataOperacao;
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
                ", cpfCliente='" + cpfCliente + '\'' +
                '}';
    }
}
