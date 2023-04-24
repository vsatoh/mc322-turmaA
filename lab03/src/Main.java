//import java.util.Scanner;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Main {
    public static void main(String[] args) throws Exception {
        ClientePF clientePF;
        ClientePJ clientePJ, clientePJ2;
        Seguradora seguradora;
        Veiculo veiculo1, veiculo2, veiculo3;
        Date data;
        SimpleDateFormat formatadata = new SimpleDateFormat("dd/MM/yyyy");
        data = formatadata.parse("17/04/2023");

        // Instanciando veiculos e chamando toString

        veiculo1 = new Veiculo("ABC", "honda", "alibaba", 2020);
        veiculo2 = new Veiculo("DEF", "fiat", "eren", 2021);
        veiculo3 = new Veiculo("GHI", "samsung", "sal marinho", 2021);
        System.out.println(veiculo1.toString());

        // Instanciando obejtos do tipo cliente e seguradora

        seguradora = new Seguradora("Seguros", "(11) 99999-9999", "nome@example.com", "Centro");
        clientePF = new ClientePF("Victor", "Centro", data, "superior completo", "Masculino", "media", "149.691.157-10", data);
        clientePJ = new ClientePJ("Abraao", "Centro", "12.345.678/0002-00",data);
        clientePJ2 = new ClientePJ("Alirio", "Centro", "00.000.000/0000-00",data);
        // Adicionando veiculos aos clientes

        clientePF.addlistaVeiculos(veiculo1);
        clientePJ.addlistaVeiculos(veiculo2);
        clientePJ2.addlistaVeiculos(veiculo3);
        // Cadastrando clientes na seguradora

        seguradora.cadastrarCliente(clientePJ);
        seguradora.cadastrarCliente(clientePF);

        // Chmando metodos de validacao

        System.out.println("CPF: " + clientePF.getCPF() + " eh " + ClientePF.validarCPF(clientePF.getCPF()));
        System.out.println("CNPJ: " + clientePJ.getCNPJ() + " eh " + ClientePJ.validarCNPJ(clientePJ.getCNPJ()));

        // toString dos clientes 

        System.out.println(clientePF.toString());
        System.out.println(clientePJ.toString());

        // Gerando sinistros

        seguradora.gerarSinistro(clientePJ, veiculo2, seguradora);
        seguradora.gerarSinistro(clientePF, veiculo1, seguradora);

        // Chamando tostring para o primeiro elemento da lista de sinistros
        System.out.println(seguradora.getlistaSinistros().get(0).toString());

        seguradora.visualizarSinistro(clientePF.getNome());

        seguradora.listarSinistros();

        seguradora.listarClientes();

        //Removendo cliente
        seguradora.removerCliente(clientePJ2);

        seguradora.listarClientes();
    }
}
