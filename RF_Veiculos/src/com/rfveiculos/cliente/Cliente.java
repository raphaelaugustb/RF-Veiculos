package com.rfveiculos.cliente;

import com.rfveiculos.veiculo.Veiculo;

import java.util.*;

public class Cliente {
    private String nome;
    private double saldo;
    private List<Veiculo> veiculosComprados;
    private List<Veiculo> veiculosVendidos;
    public Cliente(String nome, double saldo){
        this.nome = nome;
        this.saldo = saldo;
        veiculosComprados = new ArrayList<>();
        veiculosVendidos = new ArrayList<>();
    }
    public void adicionarVeiculoComprado(Veiculo veiculo){
        veiculosComprados.add(veiculo);
    }
    public void comprarNovoVeiculo(Cliente cliente, String nomeVeiculo ){
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
            cliente.getVeiculosVendidos().add(veiculoComprado);
            cliente.getVeiculosComprados().remove(veiculoComprado);
            saldo -= veiculoComprado.getPreco();
            mudarSaldoCliente(veiculoComprado.getPreco());
        }
    }

    public void mudarSaldoCliente(double saldo) {
        this.saldo += saldo;
    }

    public void venderVeiculo(Cliente cliente, String nomeVeiculo ) {
        Veiculo veiculoComprado = null;
        Boolean saldoPositivo = false;
        for (Veiculo v : veiculosComprados) {
            if (v.getModelo().equalsIgnoreCase(nomeVeiculo) && cliente.getSaldo() >= v.getPreco()) {
                veiculoComprado = v;
                saldoPositivo = true;
                break;
            }
        }
        if (saldoPositivo) {
            veiculosComprados.remove(veiculoComprado);
            veiculosVendidos.add(veiculoComprado);
            cliente.adicionarVeiculoComprado(veiculoComprado);
            double valorVeiculoComprado = veiculoComprado.getPreco();
            saldo += valorVeiculoComprado;
        } else {
            System.out.println("Saldo Insuficiente");
        }

    }
    public String getNome() {
        return nome;
    }

    public double getSaldo() {
        return saldo;
    }

    public List<Veiculo> getVeiculosComprados() {
        return veiculosComprados;
    }

    public List<Veiculo> getVeiculosVendidos() {
        return veiculosVendidos;
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "nome='" + nome + '\'' +
                ", saldo=" + saldo +
                ", veiculosComprados=" + veiculosComprados +
                ", veiculosVendidos=" + veiculosVendidos +
                '}';
    }
}
