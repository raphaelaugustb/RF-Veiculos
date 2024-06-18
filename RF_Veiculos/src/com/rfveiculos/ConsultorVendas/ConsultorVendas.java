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
        id = new Random().nextInt();
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
