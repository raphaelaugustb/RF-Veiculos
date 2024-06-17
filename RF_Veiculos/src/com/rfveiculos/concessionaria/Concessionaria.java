package com.rfveiculos.concessionaria;

import com.rfveiculos.cliente.Cliente;
import com.rfveiculos.veiculo.Veiculo;

import java.util.*;

public class Concessionaria {
    private String nome;
    private List<Veiculo> veiculosCadastrados;
    private List<Veiculo> veiculosVendidos;
    private List<Veiculo> veiculosComprados;
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
    public void ComprarVeiculo(Cliente cliente, String nomeVeiculo){
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
            veiculosComprados.add(veiculoComprado);
            veiculosCadastrados.add(veiculoComprado);
            cliente.getVeiculosVendidos().add(veiculoComprado);
            cliente.getVeiculosComprados().remove(veiculoComprado);
            saldo -= veiculoComprado.getPreco();
            cliente.mudarSaldoCliente(veiculoComprado.getPreco());
        }
    }
    public void venderVeiculo(Cliente cliente, String nomeVeiculo){
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
            veiculosCadastrados.remove(veiculoComprado);
            veiculosVendidos.add(veiculoComprado);
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

    public String getNome() {
        return nome;
    }

    public List<Veiculo> filtrarVeiculosCadastrados() {
        return veiculosCadastrados;
    }

    public List<Veiculo> filtrarVeiculosVendidos() {
        return veiculosVendidos;
    }

    public List<Veiculo> filtrarVeiculosComprados() {
        return veiculosComprados;
    }
}
