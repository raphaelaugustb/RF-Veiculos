package com.rfveiculos.models;

import com.rfveiculos.Cliente.Cliente;
import com.rfveiculos.Cliente.CriarNovoCliente;
import com.rfveiculos.Cliente.VerificarCliente;
import com.rfveiculos.ConsultorVendas.ConsultorVendas;
import com.rfveiculos.ConsultorVendas.CriarConsultorDeVendas;
import com.rfveiculos.OperacaoComercial.OperacaoComercial;
import com.rfveiculos.Veiculo.CriarNovoVeiculo;
import com.rfveiculos.Veiculo.EncontrarVeiculo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class Concessionaria {
    private final String nome;
    private final List<Veiculo> listaVeiculosCadastrados;
    private final List<OperacaoComercial> listaOperacoesComerciais;
    private final List<Cliente> listaClientesCadastrados;
    private final List<ConsultorVendas> listaConsultoresCadastrados;
    private final String cpf;
    // Metodos Importantes
    private final VerificarCliente verificarCliente = new VerificarCliente();
    private final CriarNovoCliente criarNovoCliente = new CriarNovoCliente();
    private final CriarNovoVeiculo criarNovoVeiculo = new CriarNovoVeiculo();
    private final EncontrarVeiculo encontrarVeiculo = new EncontrarVeiculo();
    private final CriarConsultorDeVendas criarConsultorDeVendas = new CriarConsultorDeVendas();

    public Concessionaria(String nome, String cpf) {
        this.listaConsultoresCadastrados = new ArrayList<>();
        this.listaVeiculosCadastrados = new ArrayList<>();
        this.listaOperacoesComerciais = new ArrayList<>();
        this.listaClientesCadastrados = new ArrayList<>();
        this.nome = nome;
        this.cpf = cpf;
    }


    @SuppressWarnings("unused")
    public void adicionarNovoVeiculo() {
        Veiculo veiculoAdicionar = criarNovoVeiculo.criarNovoVeiculo();
        listaVeiculosCadastrados.add(veiculoAdicionar);
    }

    public void adicionarNovoCliente() {
        Cliente clienteAdicionar = criarNovoCliente.criarNovoCliente();
        listaClientesCadastrados.add(clienteAdicionar);
    }
    public ConsultorVendas adicionarConsultorVendas(){
            ConsultorVendas consultorVendas = criarConsultorDeVendas.criarConsultorVendas();
           listaConsultoresCadastrados.add(consultorVendas);
           return  consultorVendas;
    }
    @SuppressWarnings("unused")
    public void comprarVeiculo() {
        Cliente cliente = verificarCliente.verificarCliente(listaClientesCadastrados);
        Veiculo veiculoComprado = criarNovoVeiculo.criarNovoVeiculo();
        ConsultorVendas consultorVendas = adicionarConsultorVendas();
        String comprador = this.nome + ": " + consultorVendas.getNome();
        OperacaoComercial operacaoComercialCompra = new OperacaoComercial(
                comprador,
                cliente.getNome(),
                veiculoComprado,
                "Compra", cliente.getCpf(), cliente.getId());
        listaVeiculosCadastrados.add(veiculoComprado);
        listaOperacoesComerciais.add(operacaoComercialCompra);
        consultorVendas.adicionarOperacaoComercial(operacaoComercialCompra);
    }

    @SuppressWarnings("unused")
    public void venderVeiculo() {
        Cliente cliente = verificarCliente.verificarCliente(listaClientesCadastrados);
        Veiculo veiculoComprado = encontrarVeiculo.encontrarVeiculo(listaVeiculosCadastrados);
        ConsultorVendas consultorVendas = adicionarConsultorVendas();
        String vendedor = this.nome + ": " + consultorVendas.getNome();
            OperacaoComercial operacaoComercialCompra = new OperacaoComercial(
                    cliente.getNome(),
                    vendedor,
                    veiculoComprado,
                    "Venda", cliente.getCpf(), cliente.getId());
            listaVeiculosCadastrados.remove(veiculoComprado);
            listaOperacoesComerciais.add(operacaoComercialCompra);
            consultorVendas.adicionarOperacaoComercial(operacaoComercialCompra);
            consultorVendas.incrementarValorArrecadado(veiculoComprado.getPreco());
    }
    @SuppressWarnings("unused")
    public void removerVeiculo(){
        System.out.println(listaVeiculosCadastrados);
        Scanner scanner = new Scanner(System.in);
        System.out.println("Digite o ID do carro");
        int idDigitado = scanner.nextInt();
        Veiculo veiculoRemover = null;
        for (Veiculo v : listaVeiculosCadastrados) {
            if (v.getId() == idDigitado) {
                veiculoRemover = v;
            }
        }
        listaVeiculosCadastrados.remove(veiculoRemover);
    }
    public void removerCliente(){
        System.out.println(listaClientesCadastrados);
        Scanner scanner = new Scanner(System.in);
        System.out.println("Digite o ID do cliente");
        int idDigitado = scanner.nextInt();
        Cliente clienteRemover = null;
        for (Cliente c : listaClientesCadastrados) {
            if (c.getId() == idDigitado) {
                clienteRemover = c;
            }
        }
        listaClientesCadastrados.remove(clienteRemover);
    }
    @SuppressWarnings("unused")
    public void removerConsultor(){
        System.out.println(listaConsultoresCadastrados);
        Scanner scanner = new Scanner(System.in);
        System.out.println("Digite o ID do Consultor");
        int idDigitado = scanner.nextInt();
        ConsultorVendas consultorRemover = null;
        for (ConsultorVendas c : listaConsultoresCadastrados) {
            if (c.getId() == idDigitado) {
                consultorRemover = c;
            }
        }
        listaConsultoresCadastrados.remove(consultorRemover);

    }
    @SuppressWarnings("unused")
    public void removerOperacaoBancaria(){
        System.out.println(listaOperacoesComerciais);
        Scanner scanner = new Scanner(System.in);
        System.out.println("Digite o ID da Operação");
        int idDigitado = scanner.nextInt();
        OperacaoComercial operacaoComercialRemover = null;
        for (OperacaoComercial o : listaOperacoesComerciais) {
            if (o.getId() == idDigitado) {
                operacaoComercialRemover = o;
            }
        }
        listaOperacoesComerciais.remove(operacaoComercialRemover);
    }
    public ConsultorVendas filtrarPorConsultorVendas(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Digite o nome do consultor:");
        String nomeConsultor = scanner.nextLine();
        ConsultorVendas consultorVendas = null;
        for (ConsultorVendas c : listaConsultoresCadastrados) {
            if (c.getNome().equalsIgnoreCase(nomeConsultor)) {
                consultorVendas = c;
            }
        }
        if (consultorVendas != null){
            return  consultorVendas;
        } else {
            System.out.println("Consultor nao encontrado");
            return null;
        }
    }
    private String encontrarMarca(){
        System.out.println("Digite a marca do veículo");
        Scanner marcaVeiculo = new Scanner(System.in);
        return  marcaVeiculo.nextLine();
    }
    private String encontrarModelo(){
        System.out.println("Digite o modelo do veículo");
        Scanner marcaVeiculo = new Scanner(System.in);
        return  marcaVeiculo.nextLine();
    }

    public List<Veiculo> filtrarPorModelo(){
        String modeloVeiculo = encontrarModelo();
        return listaVeiculosCadastrados.stream().filter(v -> Objects.equals(v.getMarca(), modeloVeiculo)).toList();
    }
    public List<Veiculo> filtrarPorMarca(){
        String marcaVeiculo = encontrarMarca();
        return listaVeiculosCadastrados.stream().filter(v -> Objects.equals(v.getMarca(), marcaVeiculo)).toList();
    }
    private int[] encontrarAno(){
        Scanner scannerAno = new Scanner(System.in);
        System.out.println("Ano de inicio");
        int anoInicial = scannerAno.nextInt();
        System.out.println("Ano de Final");
        int anoFinal = scannerAno.nextInt();
        return new int[]{
                anoInicial,
                anoFinal
        };
    }
    public List<Veiculo> filtrarPorAno(){
        List<Veiculo> veiculoPorAno = new ArrayList<>();
        int[] anoRegulador = encontrarAno();
        String marca = encontrarMarca();
        listaVeiculosCadastrados.forEach(v -> {
            int anoLancamentoVeiculo = v.getAnoDeLancamento();
            if (anoLancamentoVeiculo >= anoRegulador[0] && anoLancamentoVeiculo <= anoRegulador[1] && Objects.equals(marca, "Todos")) {
                veiculoPorAno.add(v);
            }
            if (anoLancamentoVeiculo >= anoRegulador[0] && anoLancamentoVeiculo <= anoRegulador[1] && v.getMarca().equalsIgnoreCase(marca)) {
                veiculoPorAno.add(v);
            }
        });
        return veiculoPorAno;
    }

    public List<Veiculo> filtrarCarrosValor() {
        List<Veiculo> veiculoFaixaPreco = new ArrayList<>();
        Scanner scannerFiltro = new Scanner(System.in);
        System.out.println("Valor inicial");
        int valorInicial = scannerFiltro.nextInt();
        System.out.println("Valor Final");
        int valorFinal = scannerFiltro.nextInt();
        System.out.println("Tipo de veículo\n.Carro\n.Moto\nTodos");
        String tipoVeiculo = scannerFiltro.nextLine();
        listaVeiculosCadastrados.forEach(v -> {
            double precoVeiculo = v.getPreco();
            switch (tipoVeiculo) {
                case "Todos":{
                    if (precoVeiculo >= valorInicial && precoVeiculo <= valorFinal) {
                        veiculoFaixaPreco.add(v);
                    }
                }
                case "Carro":{
                    if (precoVeiculo >= valorInicial && precoVeiculo <= valorFinal && v.getTipoVeiculo().equalsIgnoreCase(tipoVeiculo)) {
                        veiculoFaixaPreco.add(v);
                    }
                }
                case "Moto":{
                    if (precoVeiculo >= valorInicial && precoVeiculo <= valorFinal && v.getTipoVeiculo().equalsIgnoreCase(tipoVeiculo)) {
                        veiculoFaixaPreco.add(v);
                    }
                }
            }

        });
        return veiculoFaixaPreco;
    }

    public List<OperacaoComercial> filtrarPorCliente() {
        Cliente cliente = verificarCliente.verificarCliente(listaClientesCadastrados);
       Scanner tipoOperacao = new Scanner(System.in);
        System.out.println("Digite o tipo de operação:\n.Compra \n.Venda \n.Todos");
        switch (tipoOperacao.nextLine()) {
            case "Compra" -> {
                return listaOperacoesComerciais.stream().filter(o ->
                 o.getTipoOperacao() == "Compra" && o.getidCliente() == cliente.getId()
                ).toList();
            }
            case "Venda" -> {
                return listaOperacoesComerciais.stream().filter(o ->
                   o.getTipoOperacao() == "Venda" && o.getidCliente() == cliente.getId()
                ).toList();
            } case "Todos" -> {
                return listaOperacoesComerciais.stream().filter(o -> o.getidCliente() == cliente.getId()).toList();
            }
            default -> {
                return null;
            }
        }
    }
    @SuppressWarnings("unused")
    public List<OperacaoComercial> filtrarVeiculosVendidos() {
        return this.listaOperacoesComerciais.stream().filter(v -> v.getTipoOperacao() == "Venda").toList();
    }

    public List<OperacaoComercial> filtrarVeiculosComprados() {
        return  this.listaOperacoesComerciais.stream().filter(v -> v.getTipoOperacao() == "Compra").toList();
    }


    public String imprimirNotaFiscal(){
        Cliente cliente = verificarCliente.verificarCliente(listaClientesCadastrados);
        OperacaoComercial operacaoNotaFiscal = null;
        Scanner getVeiculo = new Scanner(System.in);
        System.out.println("Digite o nome do veículo");
        String nomeVeiculo = getVeiculo.nextLine();
        for(OperacaoComercial o : listaOperacoesComerciais){
            if (o.getVeiculo().getModelo().equalsIgnoreCase(nomeVeiculo)&& Objects.equals(cliente.getCpf(), o.getCpfCliente())){
                operacaoNotaFiscal = o;
            }
        }
        String notaFiscal =
                "  --------------------------------------------------------------------------------------------------------------" + "\n"
                        + "                                                 NOTA FISCAL" + "\n"+
                        "                                Nome: " + cliente.getNome()+ "               Cpf: " + cliente.getCpf() +"\n"+
                        "                                Tipo de veiculo: " + operacaoNotaFiscal.getVeiculo().getTipoVeiculo() + "    Tipo de operação: " +
                        operacaoNotaFiscal.getTipoOperacao() + "\n"
                        +"                                Data: " + operacaoNotaFiscal.getDataOperacao() + "          Vendedor: " + operacaoNotaFiscal.getVendedor() +"\n"
                        +"                                Marca: "+ operacaoNotaFiscal.getVeiculo().getMarca()+ "               Modelo: " + operacaoNotaFiscal.getVeiculo().getModelo() +
                        "\n"
                        +"                                Ano: "+  operacaoNotaFiscal.getVeiculo().getAnoDeLancamento() +"                 Cor: " + operacaoNotaFiscal.getVeiculo().getCor() +
                        "\n" + "\n"
                        + "   Empresa: " + nome +" "+this.cpf + "   "+ "Comprador: " + operacaoNotaFiscal.getComprador()+ "   " + "  Data de impressão: " + LocalDate.now()+"\n"+ "\n"+
                        "  --------------------------------------------------------------------------------------------------------------";
        if (operacaoNotaFiscal == null){
            System.out.println("Venda ou Compra nao encontrada");
            return null;
        } else {
            return notaFiscal;
        }
    }
    public String getNome() {
        return nome;
    }

    public String getCpf() {
        return cpf;
    }

    public List<OperacaoComercial> getOperacoesComercias() {
        return listaOperacoesComerciais;
    }

    public List<Cliente> getClientesCadastrados() {
        return listaClientesCadastrados;
    }

    public List<ConsultorVendas> getConsultoresCadastrados() {
        return listaConsultoresCadastrados;
    }

    public List<Veiculo> getVeiculosCadastrados() {
        return listaVeiculosCadastrados;
    }

    @Override
    public String toString() {
        return "Concessionaria{" +
                "nome='" + nome + '\'' +
                ", listaVeiculosCadastrados=" + listaVeiculosCadastrados +
                ", listaOperacoesComerciais=" + listaOperacoesComerciais +
                ", listaClientesCadastrados=" + listaClientesCadastrados +
                ", listaConsultoresCadastrados=" + listaConsultoresCadastrados +
                ", cpf='" + cpf + '\'' +
                ", verificarCliente=" + verificarCliente +
                ", criarNovoCliente=" + criarNovoCliente +
                ", criarNovoVeiculo=" + criarNovoVeiculo +
                ", encontrarVeiculo=" + encontrarVeiculo +
                ", criarConsultorDeVendas=" + criarConsultorDeVendas +
                '}';
    }
}
