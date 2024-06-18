package com.rfveiculos.models;

import com.rfveiculos.Cliente.Cliente;
import com.rfveiculos.OperacaoComercial.OperacaoComercial;
import java.time.LocalDate;
import java.util.*;

public class Comercial {
    private final String nome;
    private final List<Veiculo> veiculosCadastrados;
    private final List<OperacaoComercial> operacoesComercias;
    private final List<Cliente> clientesCadastrados;
    private final String cpf;

    public Comercial(String nome, String cpf) {
        this.veiculosCadastrados = new ArrayList<>();
        this.operacoesComercias = new ArrayList<>();
        this.clientesCadastrados = new ArrayList<>();
        this.nome = nome;
        this.cpf = cpf;
    }

    public void adicionarNovoVeiculo() {
        Veiculo veiculoAdicionar = criarNovoVeiculo();
        veiculosCadastrados.add(veiculoAdicionar);
    }

    public void adicionarNovoCliente() {
        Cliente clienteAdicionar = criarNovoCliente();
        clientesCadastrados.add(clienteAdicionar);
    }

    private Veiculo encontrarVeiculo(String nomeVeiculo, List<Veiculo> veiculos) {
        Veiculo veiculoComprado = null;
        for (Veiculo v : veiculos) {
            if (v.getModelo().equalsIgnoreCase(nomeVeiculo)) {
                veiculoComprado = v;
                break;
            }
        }
        return veiculoComprado;
    }

    private Cliente criarNovoCliente() {
        System.out.println("Cadastre um Novo Cliente");
        Scanner scannerCliente = new Scanner(System.in);
        System.out.println("Nome do Cliente");
        String nomeCliente = scannerCliente.nextLine();
        System.out.println("Cpf do cliente");
        String cpfCliente = scannerCliente.nextLine();
        System.out.println("Cliente Cadastrado");
        return new Cliente(nomeCliente, cpfCliente);
    }

    protected Veiculo criarNovoVeiculo() {
        Scanner scannerVeiculo = new Scanner(System.in);
        System.out.println("Cadastre novo veiculo");
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
        return new Veiculo(modelVeiculo, precoVeiculo, marcaVeiculo, corVeiculo, anoLancamento);
    }

    public Cliente verificarCliente() {
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
            return criarNovoCliente();
        }

    }

    public void comprarVeiculo(String consultorVendas) {
        Cliente cliente = verificarCliente();

        Veiculo veiculoComprado = criarNovoVeiculo();
        String comprador = this.nome + ": " + consultorVendas;
        OperacaoComercial operacaoComercialCompra = new OperacaoComercial(
                comprador,
                cliente.getNome(),
                veiculoComprado,
                "Compra", cliente.getCpf(), cliente.getId());
        veiculosCadastrados.add(veiculoComprado);
        operacoesComercias.add(operacaoComercialCompra);
    }



    public String imprimirNotaFiscal(Cliente cliente, String nomeVeiculo){
        OperacaoComercial operacaoNotaFiscal = null;
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
    public void venderVeiculo(Cliente cliente, String consultorVendas, String nomeVeiculo) {
        Veiculo veiculoComprado = encontrarVeiculo(nomeVeiculo, veiculosCadastrados);
        if (veiculoComprado == null){
            System.out.println("Veiculo não encontrado cadastre esse carro");
        } else {
            String vendedor = this.nome + ": " + consultorVendas;
            OperacaoComercial operacaoComercialCompra = new OperacaoComercial(
                    cliente.getNome(),
                    vendedor,
                    veiculoComprado,
                    "Venda", cliente.getCpf(), cliente.getId());
            veiculosCadastrados.remove(veiculoComprado);
            operacoesComercias.add(operacaoComercialCompra);
        }
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
       Cliente cliente = verificarCliente();
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
