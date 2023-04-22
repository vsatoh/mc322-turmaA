//import java.util.Scanner;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Main {
    public static void main(String[] args) throws Exception {
        ClientePF clientePF;
        ClientePJ clientePJ;
        Seguradora seguradora;
        Veiculo veiculo1, veiculo2;
        Date data;
        SimpleDateFormat formatadata = new SimpleDateFormat("dd/MM/yyyy");
        data = formatadata.parse("17/04/2023");

        veiculo1 = new Veiculo("ABC", "honda", "alibaba", 2020);
        veiculo2 = new Veiculo("DEF", "fiat", "eren", 2021);
        
        seguradora = new Seguradora("Seguros", "(11) 99999-9999", "nome@example.com", "Centro");
        clientePF = new ClientePF("Victor", "Centro", data, "superior completo", "Masculino", "media", "149.691.157-10", data);
        clientePJ = new ClientePJ("Abraao", "Centro", "12.345.678/0002-00",data);

        seguradora.cadastrarCliente(clientePJ);
        seguradora.cadastrarCliente(clientePF);

        clientePF.addlistaVeiculos(veiculo1);
        clientePF.addlistaVeiculos(veiculo2);
        clientePJ.addlistaVeiculos(veiculo2);

        System.out.println(clientePF.toString());
        // seguradora.gerarSinistro(clientePJ, veiculo2, seguradora);
        // seguradora.gerarSinistro(clientePF, veiculo1, seguradora);
        // //seguradora.visualizarSinistro(clientePF.getNome());
        // seguradora.listarSinistros();

    }
}
