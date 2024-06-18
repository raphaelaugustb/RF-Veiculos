package com.rfveiculos.OperacaoComercial;

import com.rfveiculos.models.Veiculo;

import java.time.LocalDate;
import java.util.Random;


public class OperacaoComercial {
    private final String comprador;
    private final String vendedor;
    private final Veiculo veiculo;
    private final LocalDate dataOperacao;
    private final String tipoOperacao;
    private final String cpfCliente;
    private final int idCliente;
    int id;
    public OperacaoComercial(String comprador, String vendedor, Veiculo veiculo, String tipoOperacao, String cpfCliente, int idCliente){
            this.comprador = comprador;
            this.vendedor = vendedor;
            this.veiculo = veiculo;
            dataOperacao = LocalDate.now();
            this.tipoOperacao = tipoOperacao;
           this.cpfCliente = cpfCliente;
           this.idCliente = idCliente;
        id = new Random().nextInt();
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

    public int getIdCliente() {
        return idCliente;
    }

    public int getId() {
        return id;
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
                ", id=" + id +
                '}';
    }
}
