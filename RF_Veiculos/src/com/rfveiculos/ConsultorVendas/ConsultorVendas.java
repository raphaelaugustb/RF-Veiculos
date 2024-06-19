package com.rfveiculos.ConsultorVendas;import
        java.util.*;
import com.rfveiculos.OperacaoComercial.OperacaoComercial;

public class ConsultorVendas {
    private  final String nome;
    private final List<OperacaoComercial> listaVendas;
    private final int id;
    private double valorArrecadado;

    public ConsultorVendas(String nome) {
        this.nome = nome;
        this.listaVendas = new ArrayList<>();
        id =    Math.abs( new Random().nextInt());
        valorArrecadado =0;
    }
    public void incrementarValorArrecadado(double valorCarro){
        valorArrecadado += valorCarro;
    }
    public void adicionarOperacaoComercial(OperacaoComercial operacaoComercial){
        listaVendas.add(operacaoComercial);
    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public List<OperacaoComercial> getListaVendas() {
        return listaVendas;
    }

    @Override
    public String toString() {
        return "ConsultorVendas{" +
                "nome='" + nome + '\'' +
                ", listaVendas=" + listaVendas +
                ", id=" + id +
                '}';
    }
}
