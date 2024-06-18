package com.rfveiculos.ConsultorVendas;

import java.util.Scanner;

public class CriarConsultorDeVendas {
    public ConsultorVendas criarConsultorVendas(){
        Scanner scannerVendedor = new Scanner(System.in);
        System.out.println("Digite o nome do vendendor");
        String nomeVendedor = scannerVendedor.nextLine();
        return new ConsultorVendas(nomeVendedor);
    }
}
