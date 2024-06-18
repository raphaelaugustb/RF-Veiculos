package com.rfveiculos.Concessionaria;

import com.rfveiculos.Cliente.Cliente;
import com.rfveiculos.OperacaoComercial.OperacaoComercial;
import com.rfveiculos.Veiculo.Veiculo;

import java.util.*;

public class Concessionaria {
    private String nome;
    private List<Veiculo> veiculosCadastrados;
    private List<OperacaoComercial> veiculosVendidos;
    private List<OperacaoComercial> veiculosComprados;
    private int saldo;
    public Concessionaria(String nome, int saldoConcessionaria){
        this.nome = nome;
        this.veiculosCadastrados = new ArrayList<>();
        this.veiculosVendidos = new ArrayList<>();
        this.veiculosComprados = new ArrayList<>();
        this.saldo = saldoConcessionaria;
    }

    public void adicionarNovosVeiculos(Veiculo veiculo ){
        veiculosCadastrados.add(veiculo);
    }
    public void ComprarVeiculo(String vendedor, Cliente cliente, String nomeVeiculo){
        Veiculo veiculoComprado = null;
        Boolean saldoPositivo = false;
        for (Veiculo v: cliente.getVeiculosComprados()){
            if (v.getModelo().equalsIgnoreCase(nomeVeiculo) && this.saldo >= v.getPreco()){
                veiculoComprado = v;
                saldoPositivo = true;
                break;
            }
        }
        if (saldoPositivo) {
            OperacaoComercial operacaoComercialCompra = new OperacaoComercial(cliente.getNome(),vendedor,veiculoComprado);
            veiculosComprados.add(operacaoComercialCompra);
            veiculosCadastrados.add(veiculoComprado);
            cliente.getVeiculosVendidos().add(veiculoComprado);
            cliente.getVeiculosComprados().remove(veiculoComprado);
            saldo -= veiculoComprado.getPreco();
            cliente.mudarSaldoCliente(veiculoComprado.getPreco());
        }
    }
    public void venderVeiculo(String vendedor,Cliente cliente, String nomeVeiculo){
    Veiculo veiculoComprado = null;
    Boolean saldoPositivo = false;
        for (Veiculo v: veiculosCadastrados){
            if (v.getModelo().equalsIgnoreCase(nomeVeiculo) && cliente.getSaldo() >= v.getPreco()){
              veiculoComprado = v;
              saldoPositivo = true;
              break;
            }
        }
        if (saldoPositivo) {
            OperacaoComercial operacaoComercialCompra = new OperacaoComercial(this.nome, cliente.getNome(), veiculoComprado);
            veiculosCadastrados.remove(veiculoComprado);
            veiculosVendidos.add(operacaoComercialCompra);
            cliente.adicionarVeiculoComprado(veiculoComprado);
            cliente.mudarSaldoCliente(-veiculoComprado.getPreco());
            saldo += veiculoComprado.getPreco();
        }

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
    public List<Veiculo> filtrarCarrosValor(int valorInicial , int valorFinal , String tipoVeiculo){
        List<Veiculo> veiculoFaixaPreco = new ArrayList<>();
        veiculosCadastrados.forEach(v -> {
            double precoVeiculo= v.getPreco();
            if (tipoVeiculo == "Todos"){
                if (precoVeiculo >= valorInicial && precoVeiculo  <= valorFinal){
                    veiculoFaixaPreco.add(v);
                }
            }
            if (precoVeiculo >= valorInicial && precoVeiculo  <= valorFinal && Objects.equals(v.getTipoVeiculo(), tipoVeiculo)){
                veiculoFaixaPreco.add(v);
            }
        });
        return  veiculoFaixaPreco;
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
