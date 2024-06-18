package com.rfveiculos.Exceptions;

public class VeiculoNaoEncontradoException extends Exception{
    String veiculoError;
    public VeiculoNaoEncontradoException(){
        this.veiculoError = "Veículo não encontrado";
    }
}
