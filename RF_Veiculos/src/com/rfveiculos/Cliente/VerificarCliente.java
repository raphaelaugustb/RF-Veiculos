package com.rfveiculos.Cliente;

import javax.swing.*;
import java.util.*;
import java.util.Scanner;

public class VerificarCliente {
    public Cliente verificarCliente(List<Cliente> clientesCadastrados) {
        CriarNovoCliente criarNovoCliente = new CriarNovoCliente();
        Scanner scanner = new Scanner(System.in);
        Cliente clienteVerificado = null;
        if (!clientesCadastrados.isEmpty()) {
            for (Cliente c : clientesCadastrados) {
                System.out.println("Digite o cpf do cliente");
                String cpfCliente = scanner.nextLine();
                if (c.getCpf().equalsIgnoreCase(cpfCliente)) {
                    clienteVerificado = c;
                }
            }
        } else {
            System.out.println("Lista Vazia");
        }
        if (clienteVerificado != null) {
            return clienteVerificado;
        } else {
            return criarNovoCliente.criarNovoCliente();
        }

    }
}
