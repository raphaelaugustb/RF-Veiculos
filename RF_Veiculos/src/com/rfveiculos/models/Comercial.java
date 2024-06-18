package com.rfveiculos.models;

import com.rfveiculos.OperacaoComercial.OperacaoComercial;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Comercial {
    private String nome;
    private List<Veiculo> veiculosCadastrados;
    private List<OperacaoComercial> operacoesComercias;

    public Comercial(String nome) {
        this.veiculosCadastrados = new ArrayList<>();
        this.operacoesComercias = new ArrayList<>();
        this.nome = nome;
    }

    public void adicionarNovosVeiculos(Veiculo veiculo) {
        veiculosCadastrados.add(veiculo);
    }

    private Veiculo encontrarVeiculoCompra(String nomeVeiculo, List<Veiculo> veiculos) {
        Veiculo veiculoComprado = null;
        for (Veiculo v : veiculos) {
            if (v.getModelo().equalsIgnoreCase(nomeVeiculo)) {
                veiculoComprado = v;
                break;
            }
        }
      return veiculoComprado;
    }

    public void comprarVeiculo(Comercial cliente, String consultorVendas, String nomeVeiculo) {
        Veiculo veiculoComprado = encontrarVeiculoCompra(nomeVeiculo, cliente.veiculosCadastrados);
        String comprador = this.nome+": " + consultorVendas;
        OperacaoComercial operacaoComercialCompra = new OperacaoComercial(
                comprador ,
                cliente.getNome(),
                veiculoComprado,
                "Compra");
        veiculosCadastrados.add(veiculoComprado);
        cliente.veiculosCadastrados.remove(veiculoComprado);
        todaOperacoesComercias().add(operacaoComercialCompra);
        cliente.todaOperacoesComercias().add(operacaoComercialCompra);
    }

    public void venderVeiculo(Comercial cliente, String consultorVendas, String nomeVeiculo) {
        Veiculo veiculoComprado = encontrarVeiculoCompra(nomeVeiculo, veiculosCadastrados);
        String vendedor = this.nome+": " + consultorVendas;
            OperacaoComercial operacaoComercialCompra = new OperacaoComercial(
                    cliente.getNome(),
                    vendedor,
                    veiculoComprado,
                    "Venda");
            veiculosCadastrados.remove(veiculoComprado);
            cliente.veiculosCadastrados.add(veiculoComprado);
           todaOperacoesComercias().add(operacaoComercialCompra);
           cliente.todaOperacoesComercias().add(operacaoComercialCompra);

    }

    @Override
    public String toString() {
        return "Concessionaria{" +
                "nome='" + nome + '\'' +
                ", veiculosCadastrados=" + veiculosCadastrados +
                '}';
    }
    public List<Veiculo> filtrarPorMarca(String marca){
        return veiculosCadastrados.stream().filter(v -> v.getMarca() == marca).toList();
    }
    public List<Veiculo> filtrarPorAno(int anoInicial, int anoFinal, String marca){
        List<Veiculo> veiculoPorAno = new ArrayList<>();
        veiculosCadastrados.forEach(v -> {
            int anoLancamentoVeiculo = v.getAnoDeLancamento();
            if (anoLancamentoVeiculo >= anoInicial && anoLancamentoVeiculo <= anoFinal && marca == "Todos") {
                veiculoPorAno.add(v);
            }
            if (anoLancamentoVeiculo >= anoInicial && anoLancamentoVeiculo <= anoFinal && Objects.equals(v.getMarca(), marca)) {
                veiculoPorAno.add(v);
            }
            ;
        });
        return veiculoPorAno;
    }

    public List<Veiculo> filtrarCarrosValor(int valorInicial, int valorFinal, String tipoVeiculo) {
        List<Veiculo> veiculoFaixaPreco = new ArrayList<>();
        veiculosCadastrados.forEach(v -> {
            double precoVeiculo = v.getPreco();
            switch (tipoVeiculo) {
                case "Todos":{
                    if (precoVeiculo >= valorInicial && precoVeiculo <= valorFinal) {
                        veiculoFaixaPreco.add(v);
                    }
                }
                case "Carro":{
                    if (precoVeiculo >= valorInicial && precoVeiculo <= valorFinal && Objects.equals(v.getTipoVeiculo(), tipoVeiculo)) {
                        veiculoFaixaPreco.add(v);
                    }
                }
                case "Moto":{
                    if (precoVeiculo >= valorInicial && precoVeiculo <= valorFinal && Objects.equals(v.getTipoVeiculo(), tipoVeiculo)) {
                        veiculoFaixaPreco.add(v);
                    }
                }
            }

        });
        return veiculoFaixaPreco;
    }

    public List<OperacaoComercial> filtrarPorCliente(Comercial comercial, String tipoOperacao) {
        switch (tipoOperacao) {
            case "Compra": {
                return comercial.filtrarVeiculosComprados();
            }
            case "Venda": {
                return comercial.filtrarVeiculosVendidos();
            } case "Todos":{
                return comercial.todaOperacoesComercias();
            }
            default: {
                return null;
            }
        }
    }

    private List<OperacaoComercial> getOperacoesComercias() {
        return operacoesComercias;
    }

    private List<Veiculo> getVeiculosCadastrados() {
        return veiculosCadastrados;
    }

    private List<OperacaoComercial> todaOperacoesComercias() {
        return operacoesComercias;
    }

    public String getNome() {
        return nome;
    }

    public List<Veiculo> filtrarVeiculosCadastrados() {
        return veiculosCadastrados;
    }

    public List<OperacaoComercial> filtrarVeiculosVendidos() {
         return this.operacoesComercias.stream().filter(v -> v.getTipoOperacao() == "Venda").toList();
    }

    public List<OperacaoComercial> filtrarVeiculosComprados() {
        return  this.operacoesComercias.stream().filter(v -> v.getTipoOperacao() == "Compra").toList();
    }



}
