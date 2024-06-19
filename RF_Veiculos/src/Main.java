
import com.rfveiculos.models.Concessionaria;
import com.rfveiculos.models.Veiculo;

import java.util.Scanner;

public class Main {

    public static void rodarAplicacao(){
        Concessionaria rfVeiculos = new Concessionaria("RF_Veiculos","14.929.978/0001-47");
        int i = 1;
        while (i == 1) {
            System.out.println("Gostaria de acessar qual aba?\n1.Cliente\n2.Veículo\n3.Operacao Bancária\n4.Fechar Apliacação");
            Scanner selecionarOpcao = new Scanner(System.in);

            switch (selecionarOpcao.nextInt()) {
                case 1 -> {
                    Scanner opcaoCliente = new Scanner(System.in);
                    System.out.println("Selecione a opção desejada\n1.Adicionar novo cliente\n2.Filtrar compras e vendas do cliente\n" +
                            "3.Clientes cadastrados\n4.Remover Cliente\n5.Fechar Aplicação");
                    switch (opcaoCliente.nextInt()) {
                        case 1 -> {
                            rfVeiculos.adicionarNovoCliente();
                        }
                        case 2 -> {
                            rfVeiculos.filtrarPorCliente();
                        }
                        case 3 -> {
                            System.out.println(  rfVeiculos.getClientesCadastrados());

                        }
                        case 4 -> {
                            rfVeiculos.removerCliente();
                        }
                        case 5 -> {
                            i = 0;
                        }
                        default -> {
                            System.out.println("Opção inválida");
                        }
                    }
                }
                case 2 -> {
                    Scanner opcaoVeiculo = new Scanner(System.in);
                    System.out.println("Selecione a opção desejada:\n1.Adicionar veículo\n2.Vender veiculo" +
                            "\n3.Comprar veiculo\n4.Remover veículo\n5.Veiculos Cadastrados\n6.Filtrar por marca\n7.Filtrar por modelo\n8.Filtrar por ano\n9.Filtrar por valorx\n10.Fechar aplicação");
                    switch (opcaoVeiculo.nextInt()) {
                        case 1 -> {
                            rfVeiculos.adicionarNovoVeiculo();
                        }
                        case 2 -> {
                            rfVeiculos.venderVeiculo();
                        }
                        case 3 -> {
                            rfVeiculos.comprarVeiculo();
                        }
                        case 4 -> {
                            rfVeiculos.removerVeiculo();
                        }
                        case 5 -> {
                            System.out.println(rfVeiculos.getVeiculosCadastrados());
                        }
                        case 6 -> {
                            rfVeiculos.filtrarPorMarca();
                        }
                        case 7 -> {
                            rfVeiculos.filtrarPorModelo();
                        }
                        case 8 -> {
                            rfVeiculos.filtrarPorAno();
                        }
                        case 9 -> {
                            rfVeiculos.filtrarCarrosValor();
                        } case 10 -> {
                            i = 0;
                        }
                        default -> {
                            System.out.println("Opção inválida");
                        }
                    }
                }
                case 3 -> {
                    Scanner opcaoOperacao = new Scanner(System.in);
                    System.out.println("1.Adicionar consultor\n2.Listar consultores\n3.Filtrar Vendas\n4.Filtrar Compras\n5.Filtrar consulto de vendas\n6.Imprimir nota fiscal\n7. Listar todas as operações comercias\n 8.Fechar Aplicação");
                    switch (opcaoOperacao.nextInt()) {
                        case 1: {
                            rfVeiculos.adicionarConsultorVendas();
                        }
                        case 2: {
                            rfVeiculos.getConsultoresCadastrados();
                        }
                        case 3: {
                            System.out.println(rfVeiculos.filtrarVeiculosVendidos());
                        }
                        case 4: {
                            System.out.println(rfVeiculos.filtrarVeiculosComprados());
                        }
                        case 5: {
                            rfVeiculos.filtrarPorConsultorVendas();
                        }
                        case 6: {
                            rfVeiculos.imprimirNotaFiscal();
                        }
                        case 7: {
                            rfVeiculos.getOperacoesComercias();
                        } case 8: {
                            i=0;
                        }
                    }

                } case 4 -> {
                    i = 0;
                }

                default -> {
                    System.out.println("Ação invalida");
                }

            }
        }
    }
    public static void main(String[] args) {
        rodarAplicacao();
    }


}