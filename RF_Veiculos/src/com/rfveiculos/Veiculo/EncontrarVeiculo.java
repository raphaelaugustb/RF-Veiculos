package com.rfveiculos.Veiculo;

import com.rfveiculos.models.Veiculo;

import java.util.List;
import java.util.Scanner;

public class EncontrarVeiculo {
    CriarNovoVeiculo criarNovoVeiculo = new CriarNovoVeiculo();
    public Veiculo encontrarVeiculo(List<Veiculo> veiculos) {
        Veiculo veiculoComprado = null;
        Scanner getVeiculo = new Scanner(System.in);
        System.out.println("Digite o nome do veículo");
        String nomeVeiculo = getVeiculo.nextLine();
        for (Veiculo v : veiculos) {
            if (v.getModelo().equalsIgnoreCase(nomeVeiculo) ){
                veiculoComprado = v;
                break;
            }
        }
        if (veiculoComprado == null) {
            System.out.println("Veiculo não encontrado cadastre esse carro");
            return criarNovoVeiculo.criarNovoVeiculo();
        } else {
            return veiculoComprado;
        }
    }
}
