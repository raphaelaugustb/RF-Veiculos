package com.rfveiculos.ConsultorVendas;import
        java.util.*;
import com.rfveiculos.OperacaoComercial.OperacaoComercial;

public class ConsultorVendas {
    private  final String nome;
    List<OperacaoComercial> listaVendas;
    int id;

    public ConsultorVendas(String nome) {
        this.nome = nome;
        this.listaVendas = new ArrayList<>();
        id ++;
    }
    public void adicionarOperacaoComercial(OperacaoComercial operacaoComercial){
        listaVendas.add(operacaoComercial);
    }

    public String getNome() {
        return nome;
    }

    public List<OperacaoComercial> getListaVendas() {
        return listaVendas;
    }
}
