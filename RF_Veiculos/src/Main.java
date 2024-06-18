import com.rfveiculos.Cliente.Cliente;
import com.rfveiculos.Concessionaria.Concessionaria;
import com.rfveiculos.Veiculo.Carro;
import com.rfveiculos.Veiculo.Moto;
import com.rfveiculos.models.Veiculo;

public class Main {
    public static void main(String[] args) {
        Concessionaria rfVeiculos = new Concessionaria("RF_Veiculos");
        Cliente raphael = new Cliente("Raphael", 3000);
        Cliente elcio = new Cliente("Elcio", 6000);
        Veiculo fiat_uno = new Carro("Fiat Uno", 1000, "Fiat","Azul", 2000);
        Veiculo fiat_mobi = new Carro("Fiat Mobi", 3000, "Fiat","Amarelo", 2000);
        Veiculo honda_pcx = new Moto("Honda PCX", 1000, "Honda","Branca", 2000);
        Veiculo volkswagen_gol = new Carro("Volkswagen Gol", 2000, "Volkswagen","Preto", 2000);

        rfVeiculos.adicionarNovosVeiculos(honda_pcx);
        rfVeiculos.adicionarNovosVeiculos(fiat_uno);
        rfVeiculos.adicionarNovosVeiculos(fiat_mobi);
        rfVeiculos.adicionarNovosVeiculos(volkswagen_gol);

    }
}