package com.rfveiculos.models;

import com.rfveiculos.Cliente.Cliente;
import com.rfveiculos.OperacaoComercial.OperacaoComercial;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicReference;

public class Comercial {
    private String nome;
    private List<Veiculo> veiculosCadastrados;
    private List<OperacaoComercial> operacoesComercias;
    private String cpf;
    public Comercial(String nome, String cpf) {
        this.veiculosCadastrados = new ArrayList<>();
        this.operacoesComercias = new ArrayList<>();
        this.nome = nome;
        this.cpf = cpf;
    }

    public void adicionarNovosVeiculos(Veiculo veiculo) {
        veiculosCadastrados.add(veiculo);
    }

    private Veiculo encontrarVeiculoCompra(String nomeVeiculo, List<Veiculo> veiculos) {
        Veiculo veiculoComprado = null;
        for (Veiculo v : veiculos) {
            if (v.getModelo().equalsIgnoreCase(nomeVeiculo)) {
                veiculoComprado = v;
                break;
            }
        }
      return veiculoComprado;
    }

    public void comprarVeiculo(Comercial clienteComercial, String consultorVendas, String nomeVeiculo) {
        Veiculo veiculoComprado = encontrarVeiculoCompra(nomeVeiculo, clienteComercial.veiculosCadastrados);
        String comprador = this.nome+": " + consultorVendas;
        OperacaoComercial operacaoComercialCompra = new OperacaoComercial(
                comprador ,
                clienteComercial.getNome(),
                veiculoComprado,
                "Compra", clienteComercial.getCpf());
        veiculosCadastrados.add(veiculoComprado);
        clienteComercial.veiculosCadastrados.remove(veiculoComprado);
        todaOperacoesComercias().add(operacaoComercialCompra);
        clienteComercial.todaOperacoesComercias().add(operacaoComercialCompra);
    }
    public String imprimirNotaFiscal(Cliente cliente, String nomeVeiculo){
        OperacaoComercial operacaoNotaFiscal = null;
        for(OperacaoComercial o : operacoesComercias){
            if (o.getVeiculo().getModelo() == nomeVeiculo && cliente.getCpf() == o.getCpfCliente()){
                operacaoNotaFiscal = o;
            }
        };
        String notaFiscal =
                "  -----------------------------------------------------------------------------------------------" + "\n"
                        + "                                       NOTA FISCAL" + "\n"+
                "                      Nome: " + cliente.getNome()+ "               Cpf: " + cliente.getCpf() +"\n"+
                "                      Tipo de veiculo: " + operacaoNotaFiscal.getVeiculo().getTipoVeiculo() + "    Tipo de operação: " +
                          operacaoNotaFiscal.getTipoOperacao() + "\n"
                +"                      Data: " + operacaoNotaFiscal.getDataOperacao() + "          Vendedor: " + operacaoNotaFiscal.getVendedor() +"\n"
                +"                      Marca: "+ operacaoNotaFiscal.getVeiculo().getMarca()+ "               Modelo: " + operacaoNotaFiscal.getVeiculo().getModelo() +
                          "\n"
                +"                      Ano: "+  operacaoNotaFiscal.getVeiculo().getAnoDeLancamento() +"                 Cor: " + operacaoNotaFiscal.getVeiculo().getCor() +
                          "\n" + "\n"
                          + "         Empresa: " + nome + " "+this.cpf + "  Data de impressão: " + LocalDate.now()+"\n"+ "\n"+
                "  -----------------------------------------------------------------------------------------------";
        if (operacaoNotaFiscal == null){
            System.out.println("Venda ou Compra nao encontrada");
            return null;
        } else {
            return notaFiscal;
        }

    }
    public void venderVeiculo(Comercial clienteComercial, String consultorVendas, String nomeVeiculo) {
        Veiculo veiculoComprado = encontrarVeiculoCompra(nomeVeiculo, veiculosCadastrados);
        String vendedor = this.nome+": " + consultorVendas;
            OperacaoComercial operacaoComercialCompra = new OperacaoComercial(
                    clienteComercial.getNome(),
                    vendedor,
                    veiculoComprado,
                    "Venda", clienteComercial.getCpf());
            veiculosCadastrados.remove(veiculoComprado);
            clienteComercial.veiculosCadastrados.add(veiculoComprado);
           todaOperacoesComercias().add(operacaoComercialCompra);
           clienteComercial.todaOperacoesComercias().add(operacaoComercialCompra);

    }

    @Override
    public String toString() {
        return "Concessionaria{" +
                "nome='" + nome + '\'' +
                ", veiculosCadastrados=" + veiculosCadastrados +
                '}';
    }
    public List<Veiculo> filtrarPorMarca(String marca){
        return veiculosCadastrados.stream().filter(v -> v.getMarca() == marca).toList();
    }
    public List<Veiculo> filtrarPorAno(int anoInicial, int anoFinal, String marca){
        List<Veiculo> veiculoPorAno = new ArrayList<>();
        veiculosCadastrados.forEach(v -> {
            int anoLancamentoVeiculo = v.getAnoDeLancamento();
            if (anoLancamentoVeiculo >= anoInicial && anoLancamentoVeiculo <= anoFinal && marca == "Todos") {
                veiculoPorAno.add(v);
            }
            if (anoLancamentoVeiculo >= anoInicial && anoLancamentoVeiculo <= anoFinal && Objects.equals(v.getMarca(), marca)) {
                veiculoPorAno.add(v);
            }
            ;
        });
        return veiculoPorAno;
    }

    public List<Veiculo> filtrarCarrosValor(int valorInicial, int valorFinal, String tipoVeiculo) {
        List<Veiculo> veiculoFaixaPreco = new ArrayList<>();
        veiculosCadastrados.forEach(v -> {
            double precoVeiculo = v.getPreco();
            switch (tipoVeiculo) {
                case "Todos":{
                    if (precoVeiculo >= valorInicial && precoVeiculo <= valorFinal) {
                        veiculoFaixaPreco.add(v);
                    }
                }
                case "Carro":{
                    if (precoVeiculo >= valorInicial && precoVeiculo <= valorFinal && Objects.equals(v.getTipoVeiculo(), tipoVeiculo)) {
                        veiculoFaixaPreco.add(v);
                    }
                }
                case "Moto":{
                    if (precoVeiculo >= valorInicial && precoVeiculo <= valorFinal && Objects.equals(v.getTipoVeiculo(), tipoVeiculo)) {
                        veiculoFaixaPreco.add(v);
                    }
                }
            }

        });
        return veiculoFaixaPreco;
    }

    public List<OperacaoComercial> filtrarPorCliente(Comercial comercial, String tipoOperacao) {
        switch (tipoOperacao) {
            case "Compra": {
                return comercial.filtrarVeiculosComprados();
            }
            case "Venda": {
                return comercial.filtrarVeiculosVendidos();
            } case "Todos":{
                return comercial.todaOperacoesComercias();
            }
            default: {
                return null;
            }
        }
    }

    private List<OperacaoComercial> getOperacoesComercias() {
        return operacoesComercias;
    }

    private List<Veiculo> getVeiculosCadastrados() {
        return veiculosCadastrados;
    }

    private List<OperacaoComercial> todaOperacoesComercias() {
        return operacoesComercias;
    }

    public String getNome() {
        return nome;
    }

    public List<Veiculo> filtrarVeiculosCadastrados() {
        return veiculosCadastrados;
    }

    public List<OperacaoComercial> filtrarVeiculosVendidos() {
         return this.operacoesComercias.stream().filter(v -> v.getTipoOperacao() == "Venda").toList();
    }

    public List<OperacaoComercial> filtrarVeiculosComprados() {
        return  this.operacoesComercias.stream().filter(v -> v.getTipoOperacao() == "Compra").toList();
    }

    public String getCpf() {
        return cpf;
    }
}
