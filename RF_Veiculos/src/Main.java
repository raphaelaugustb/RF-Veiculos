
import com.rfveiculos.models.Concessionaria;
public class Main {
    public static void main(String[] args) {
        Concessionaria rfVeiculos = getRfVeiculos();
        //TODO
    }

    private static Concessionaria getRfVeiculos() {
        Concessionaria rfVeiculos = new Concessionaria("RF_Veiculos","14.929.978/0001-47");

        rfVeiculos.adicionarNovoCliente();
        rfVeiculos.adicionarNovoCliente();
        rfVeiculos.removerCliente();
        System.out.println(rfVeiculos.getClientesCadastrados());
        System.out.println(rfVeiculos.getClientesCadastrados());
        return rfVeiculos;
    }
}