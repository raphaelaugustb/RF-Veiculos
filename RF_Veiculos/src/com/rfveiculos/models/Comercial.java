package com.rfveiculos.models;

import com.rfveiculos.Cliente.Cliente;
import com.rfveiculos.OperacaoComercial.OperacaoComercial;
import com.rfveiculos.expections.VeiculoNaoEncontradoException;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Comercial {
    private String nome;
    private List<Veiculo> veiculosCadastrados;
    private List<OperacaoComercial> veiculosVendidos;
    private List<OperacaoComercial> veiculosComprados;
    private List<OperacaoComercial> todaOperacoesComercias;

    public Comercial(String nome) {
        this.veiculosComprados = new ArrayList<>();
        this.veiculosVendidos = new ArrayList<>();
        this.veiculosCadastrados = new ArrayList<>();
        this.todaOperacoesComercias = new ArrayList<>();
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
        OperacaoComercial operacaoComercialCompra = new OperacaoComercial(comprador , cliente.getNome(), veiculoComprado);
        veiculosCadastrados.add(veiculoComprado);
        veiculosComprados.add(operacaoComercialCompra);
        cliente.veiculosVendidos.add(operacaoComercialCompra);
        cliente.veiculosCadastrados.remove(veiculoComprado);
    }

    public void venderVeiculo(Comercial cliente, String consultorVendas, String nomeVeiculo) {
        Veiculo veiculoComprado = encontrarVeiculoCompra(nomeVeiculo, veiculosCadastrados);
        String vendedor = this.nome+": " + consultorVendas;
            OperacaoComercial operacaoComercialCompra = new OperacaoComercial(cliente.getNome(), vendedor, veiculoComprado);
            veiculosCadastrados.remove(veiculoComprado);
            veiculosVendidos.add(operacaoComercialCompra);
            cliente.veiculosCadastrados.add(veiculoComprado);
            cliente.veiculosComprados.add(operacaoComercialCompra);

    }

    @Override
    public String toString() {
        return "Concessionaria{" +
                "nome='" + nome + '\'' +
                ", veiculosCadastrados=" + veiculosCadastrados +
                ", veiculosVendidos=" + veiculosVendidos +
                ", veiculosComprados=" + veiculosComprados +
                '}';
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
                return comercial.filtrarVeiculosVendidos();
            }
            case "Venda": {
                return comercial.filtrarVeiculosComprados();
            } case "Todos":{
                return comercial.todaOperacoesComercias();
            }
            default: {
                return null;
            }
        }
    }

    private List<OperacaoComercial> todaOperacoesComercias() {
        return todaOperacoesComercias;
    }

    public String getNome() {
        return nome;
    }

    public List<Veiculo> filtrarVeiculosCadastrados() {
        return veiculosCadastrados;
    }

    public List<OperacaoComercial> filtrarVeiculosVendidos() {
        return veiculosVendidos;
    }

    public List<OperacaoComercial> filtrarVeiculosComprados() {
        return veiculosComprados;
    }



}
