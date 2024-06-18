package com.rfveiculos.models;

import com.rfveiculos.Cliente.Cliente;
import com.rfveiculos.Cliente.CriarNovoCliente;
import com.rfveiculos.Cliente.VerificarCliente;
import com.rfveiculos.ConsultorVendas.ConsultorVendas;
import com.rfveiculos.ConsultorVendas.CriarConsultorDeVendas;
import com.rfveiculos.OperacaoComercial.OperacaoComercial;
import com.rfveiculos.Veiculo.Carro;
import com.rfveiculos.Veiculo.CriarNovoVeiculo;
import com.rfveiculos.Veiculo.EncontrarVeiculo;
import com.rfveiculos.Veiculo.Moto;

import java.time.LocalDate;
import java.util.*;

public class Concessionaria {
    private final String nome;
    private final List<Veiculo> veiculosCadastrados;
    private final List<OperacaoComercial> operacoesComercias;
    private final List<Cliente> clientesCadastrados;
    private final List<ConsultorVendas> listaConsultoresdeVendas;
    private final String cpf;
    // Metodos Importantes
    private VerificarCliente verificarCliente = new VerificarCliente();
    private CriarNovoCliente criarNovoCliente = new CriarNovoCliente();
    private CriarNovoVeiculo criarNovoVeiculo = new CriarNovoVeiculo();
    private EncontrarVeiculo encontrarVeiculo = new EncontrarVeiculo();
    private CriarConsultorDeVendas criarConsultorDeVendas = new CriarConsultorDeVendas();

    public Concessionaria(String nome, String cpf) {
        this.listaConsultoresdeVendas = new ArrayList<>();
        this.veiculosCadastrados = new ArrayList<>();
        this.operacoesComercias = new ArrayList<>();
        this.clientesCadastrados = new ArrayList<>();
        this.nome = nome;
        this.cpf = cpf;
    }


    public void adicionarNovoVeiculo() {
        Veiculo veiculoAdicionar = criarNovoVeiculo.criarNovoVeiculo();
        veiculosCadastrados.add(veiculoAdicionar);
    }

    public void adicionarNovoCliente() {
        Cliente clienteAdicionar = criarNovoCliente.criarNovoCliente();
        clientesCadastrados.add(clienteAdicionar);
    }
    public ConsultorVendas adicionarConsultorVendas(){
            ConsultorVendas consultorVendas = criarConsultorDeVendas.criarConsultorVendas();
           listaConsultoresdeVendas.add(consultorVendas);
           return  consultorVendas;
    }
    public void comprarVeiculo() {
        Cliente cliente = verificarCliente.verificarCliente(clientesCadastrados);
        Veiculo veiculoComprado = criarNovoVeiculo.criarNovoVeiculo();
        ConsultorVendas consultorVendas = adicionarConsultorVendas();
        String comprador = this.nome + ": " + consultorVendas.getNome();
        OperacaoComercial operacaoComercialCompra = new OperacaoComercial(
                comprador,
                cliente.getNome(),
                veiculoComprado,
                "Compra", cliente.getCpf(), cliente.getId());
        veiculosCadastrados.add(veiculoComprado);
        operacoesComercias.add(operacaoComercialCompra);
        consultorVendas.adicionarOperacaoComercial(operacaoComercialCompra);
    }

    public void venderVeiculo() {
        Cliente cliente = verificarCliente.verificarCliente(clientesCadastrados);
        Veiculo veiculoComprado = encontrarVeiculo.encontrarVeiculo(veiculosCadastrados);
        ConsultorVendas consultorVendas = adicionarConsultorVendas();
        String vendedor = this.nome + ": " + consultorVendas.getNome();
            OperacaoComercial operacaoComercialCompra = new OperacaoComercial(
                    cliente.getNome(),
                    vendedor,
                    veiculoComprado,
                    "Venda", cliente.getCpf(), cliente.getId());
            veiculosCadastrados.remove(veiculoComprado);
            operacoesComercias.add(operacaoComercialCompra);
            consultorVendas.adicionarOperacaoComercial(operacaoComercialCompra);
    }

    public ConsultorVendas filtrarPorConsultorVendas(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Digite o nome do consultor:");
        String nomeConsultor = scanner.nextLine();
        ConsultorVendas consultorVendas = null;
        for (ConsultorVendas c : listaConsultoresdeVendas) {
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
            if (anoLancamentoVeiculo >= anoInicial && anoLancamentoVeiculo <= anoFinal && v.getMarca().equalsIgnoreCase(marca)) {
                veiculoPorAno.add(v);
            }
            ;
        });
        return veiculoPorAno;
    }

    public List<Veiculo> filtrarCarrosValor() {
        List<Veiculo> veiculoFaixaPreco = new ArrayList<>();
        Scanner scannerFiltro = new Scanner(System.in);
        System.out.println("Ano de inicio");
        int valorInicial = scannerFiltro.nextInt();
        System.out.println("Ano de Final");
        int valorFinal = scannerFiltro.nextInt();
        System.out.println("Tipo de veículo\n.Carro\n.Moto\nTodos");
        String tipoVeiculo = scannerFiltro.nextLine();
        veiculosCadastrados.forEach(v -> {
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
        Cliente cliente = verificarCliente.verificarCliente(clientesCadastrados);
       Scanner tipoOperacao = new Scanner(System.in);
        System.out.println("Digite o tipo de operação:\n.Compra \n.Venda \n.Todos");
        switch (tipoOperacao.nextLine()) {
            case "Compra" -> {
                return operacoesComercias.stream().filter(o ->
                 o.getTipoOperacao() == "Compra" && o.getidCliente() == cliente.getId()
                ).toList();
            }
            case "Venda" -> {
                return operacoesComercias.stream().filter(o ->
                   o.getTipoOperacao() == "Venda" && o.getidCliente() == cliente.getId()
                ).toList();
            } case "Todos" -> {
                return operacoesComercias.stream().filter(o -> o.getidCliente() == cliente.getId()).toList();
            }
            default -> {
                return null;
            }
        }
    }
    public List<OperacaoComercial> filtrarVeiculosVendidos() {
        return this.operacoesComercias.stream().filter(v -> v.getTipoOperacao() == "Venda").toList();
    }

    public List<OperacaoComercial> filtrarVeiculosComprados() {
        return  this.operacoesComercias.stream().filter(v -> v.getTipoOperacao() == "Compra").toList();
    }

    @Override
    public String toString() {
        return "Concessionaria{" +
                "nome='" + nome + '\'' +
                ", veiculosCadastrados=" + veiculosCadastrados +
                ", operacoesComercias=" + operacoesComercias +
                ", clientesCadastrados=" + clientesCadastrados +
                ", listaConsultoresdeVendas=" + listaConsultoresdeVendas +
                ", cpf='" + cpf + '\'' +
                ", verificarCliente=" + verificarCliente +
                ", criarNovoCliente=" + criarNovoCliente +
                ", criarNovoVeiculo=" + criarNovoVeiculo +
                ", encontrarVeiculo=" + encontrarVeiculo +
                '}';
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


    public String getCpf() {
        return cpf;
    }
    public String imprimirNotaFiscal(){
        Cliente cliente = verificarCliente.verificarCliente(clientesCadastrados);
        OperacaoComercial operacaoNotaFiscal = null;
        Scanner getVeiculo = new Scanner(System.in);
        System.out.println("Digite o nome do veículo");
        String nomeVeiculo = getVeiculo.nextLine();
        for(OperacaoComercial o : operacoesComercias){
            if (o.getVeiculo().getModelo().equalsIgnoreCase(nomeVeiculo)&& Objects.equals(cliente.getCpf(), o.getCpfCliente())){
                operacaoNotaFiscal = o;
            }
        };
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
}
