package com.rfveiculos.OperacaoComercial;

import com.rfveiculos.models.Veiculo;

import java.time.LocalDate;


public class OperacaoComercial {
    private String comprador;
    private String vendedor;
    private Veiculo veiculo;
    private LocalDate dataOperacao;
    private String tipoOperacao;
    private String cpfCliente;
    private int idCliente;
    public OperacaoComercial(String comprador, String vendedor, Veiculo veiculo, String tipoOperacao, String cpfCliente, int idCliente){
            this.comprador = comprador;
            this.vendedor = vendedor;
            this.veiculo = veiculo;
            dataOperacao = LocalDate.now();
            this.tipoOperacao = tipoOperacao;
           this.cpfCliente = cpfCliente;
           this.idCliente = idCliente;
    }
    public int getidCliente(){return  idCliente;}
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
                ", idCliente=" + idCliente +
                '}';
    }
}
