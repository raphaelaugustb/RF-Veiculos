package com.rfveiculos.Cliente;

import com.rfveiculos.models.Comercial;


public class Cliente extends Comercial {
    String cpf;
    public Cliente(String nome ,String cpf){
        super(nome);
        this.cpf = cpf;
    }


}
