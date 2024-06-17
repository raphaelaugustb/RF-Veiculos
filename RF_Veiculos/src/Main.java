import com.rfveiculos.cliente.Cliente;
import com.rfveiculos.concessionaria.Concessionaria;
import com.rfveiculos.veiculo.Carro;
import com.rfveiculos.veiculo.Veiculo;

public class Main {
    public static void main(String[] args) {
        Concessionaria rfVeiculos = new Concessionaria("RF_Veiculos", 0);
        Cliente raphael = new Cliente("Raphael", 3000);
        Cliente elcio = new Cliente("Elcio", 6000);
        Veiculo Fiat_UNO = new Carro("Fiat Uno", 2000, "Fiat","Azul", 2000);
        rfVeiculos.adicionarNovosVeiculos(Fiat_UNO);
        rfVeiculos.venderVeiculo(raphael, "Fiat Uno");
        System.out.println(raphael.getSaldo());
        raphael.venderVeiculo(elcio, "Fiat Uno");

    }
}