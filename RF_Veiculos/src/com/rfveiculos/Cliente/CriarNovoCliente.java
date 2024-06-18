package com.rfveiculos.Cliente;

import java.util.Scanner;
public class CriarNovoCliente {
    public Cliente criarNovoCliente() {
    System.out.println("Cadastre um Novo Cliente");
    Scanner scannerCliente = new Scanner(System.in);
    System.out.println("Nome do Cliente");
    String nomeCliente = scannerCliente.nextLine();
    System.out.println("Cpf do cliente");
    String cpfCliente = scannerCliente.nextLine();
    System.out.println("Cliente Cadastrado");
    return new Cliente(nomeCliente, cpfCliente);
}

}
