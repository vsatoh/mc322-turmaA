import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        // String nome;
        // Scanner entrada = new Scanner(System.in);
        // nome = entrada.nextLine();
        // System.out.println(nome);

        Seguradora teste = new Seguradora("ola","1100000000","nome@example.com","purgatorio");
        System.out.println(teste.getNome());
        System.out.println(teste.getTelefone());
        System.out.println(teste.getEndereco());
        System.out.println(teste.getEmail());
        // entrada.close();
    }
}
