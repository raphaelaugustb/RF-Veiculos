import com.rfveiculos.Cliente.Cliente;
import com.rfveiculos.Veiculo.Carro;
import com.rfveiculos.Veiculo.Moto;
import com.rfveiculos.models.Concessionaria;
import com.rfveiculos.models.Veiculo;

import javax.swing.*;
import java.nio.file.FileStore;

public class Main {
    public static void main(String[] args) {

        Concessionaria rfVeiculos = getRfVeiculos();


        //TODO
        // Apagar cliente e veiculos e operacoes comerciais
        // Procurar por data
        // Encontrar veiculo por modelo,
        // encontrar veiculo por cor,
        // ordernar por maior e menor valor,
        // filtrar vendas por consultor e mostrar valor arrecadado.
        // verificar se o cliente ou lista VAZIA


    }

    private static Concessionaria getRfVeiculos() {
        Concessionaria rfVeiculos = new Concessionaria("RF_Veiculos","14.929.978/0001-47");

        System.out.println(rfVeiculos.filtrarPorCliente());
        rfVeiculos.adicionarNovoCliente();
        rfVeiculos.venderVeiculo();
        return rfVeiculos;
    }
}