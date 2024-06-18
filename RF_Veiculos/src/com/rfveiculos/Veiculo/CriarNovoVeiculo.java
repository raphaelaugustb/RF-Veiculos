package com.rfveiculos.Veiculo;

import com.rfveiculos.models.Veiculo;

import java.util.Scanner;

public class CriarNovoVeiculo {
    public  Veiculo criarNovoVeiculo() {
        Scanner scannerVeiculo = new Scanner(System.in);
        System.out.println("Cadastre novo veiculo");
        System.out.println("Tipo de Veiculo");
        String tipoVeiculo = scannerVeiculo.nextLine();
        System.out.println("Marca do veiculo");
        String marcaVeiculo = scannerVeiculo.nextLine();
        System.out.println("Modelo do veiculo");
        String modelVeiculo = scannerVeiculo.nextLine();
        System.out.println("Cor do veículo");
        String corVeiculo = scannerVeiculo.nextLine();
        System.out.println("Preço do veiculo");
        double precoVeiculo = scannerVeiculo.nextDouble();
        System.out.println("Ano de lançamento");
        int anoLancamento = scannerVeiculo.nextInt();
        System.out.println("Veiculo Cadastrado");
        switch (tipoVeiculo){
            case "Moto" ->{
                return new Moto(modelVeiculo, precoVeiculo, marcaVeiculo, corVeiculo, anoLancamento);
            }
            case "Carro" -> {
                return new Carro(modelVeiculo, precoVeiculo, marcaVeiculo, corVeiculo, anoLancamento);
            }
            default -> {
                return new Veiculo(modelVeiculo, precoVeiculo, marcaVeiculo, corVeiculo, anoLancamento);
            }
        }

    }

}
