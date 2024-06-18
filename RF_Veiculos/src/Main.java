import com.rfveiculos.Cliente.Cliente;
import com.rfveiculos.Concessionaria.Concessionaria;
import com.rfveiculos.Veiculo.Carro;
import com.rfveiculos.Veiculo.Moto;
import com.rfveiculos.models.Veiculo;

public class Main {
    public static void main(String[] args) {
        Concessionaria rfVeiculos = new Concessionaria("RF_Veiculos","14.929.978/0001-47");
        Cliente raphael = new Cliente("Raphael", "299.567.293-34");
        Cliente elcio = new Cliente("Elcio", "938-000-287-203");
        Veiculo fiat_uno = new Carro("Fiat Uno", 1000, "Fiat","Azul", 2002);
        Veiculo fiat_mobi = new Carro("Fiat Mobi", 3000, "Fiat","Amarelo", 2001);
        Veiculo honda_pcx = new Moto("Honda PCX", 1000, "Honda","Branca", 2000);
        Veiculo volkswagen_gol = new Carro("Volkswagen Gol", 2000, "Volkswagen","Preto", 2000);

        rfVeiculos.adicionarNovosVeiculos(honda_pcx);
        rfVeiculos.adicionarNovosVeiculos(fiat_uno);
        rfVeiculos.adicionarNovosVeiculos(fiat_mobi);
        rfVeiculos.adicionarNovosVeiculos(volkswagen_gol);
        // Funcao de venda, Parametros: Objeto, Consultor:String / NomeVeiculo:String
        rfVeiculos.venderVeiculo(elcio, "Ronaldo", "Fiat Mobi");
        System.out.println(rfVeiculos.filtrarVeiculosVendidos());

        System.out.println(rfVeiculos.filtrarVeiculosComprados());
        // Funcao de filtrar por valor, Parametros: Valor inicial, Valor final/ TipoVeiculo:Todos,Moto,Carro
        rfVeiculos.filtrarCarrosValor(1000, 2000, "Todos");
        System.out.println(rfVeiculos.imprimirNotaFiscal(elcio, "Fiat Mobi"));
        //TODO
        // Encontrar veiculo por modelo,
        // encontrar veiculo por cor,
        // ordernar por maior e menor valor,
        // filtrar vendas por consultor e mostrar valor arrecadado.
        // verificar se o cliente ou lista VAZIA


    }
}