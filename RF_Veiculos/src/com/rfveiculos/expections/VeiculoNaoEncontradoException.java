package com.rfveiculos.expections;

public class VeiculoNaoEncontradoException extends Exception{
    String veiculoError;
    public VeiculoNaoEncontradoException(){
        this.veiculoError = "Veículo não encontrado";
    }
}
