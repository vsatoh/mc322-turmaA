import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        String n_cadastro;
        Cliente cadastro_Cliente;
        Scanner entrada = new Scanner(System.in);

        System.out.println("Cadastro:");
        System.out.println("(1) - Cliente");
        System.out.println("(2) - Seguradora");
        System.out.println("(3) - Sinistro");
        System.out.println("(4) - Veiculo");
        
        n_cadastro = entrada.nextLine();
        if(n_cadastro.equals("1")) {
            String nome;
            String cpf;
            String dataNascimento;
            int idade;
            String idade_s;
            String endereco;

            System.out.print("Nome: ");
            nome = entrada.nextLine();
            System.out.print("Data de Nascimento: ");
            dataNascimento = entrada.nextLine();
            System.out.print("Idade: ");
            idade_s = entrada.nextLine();
            idade = Integer.parseInt(idade_s);
            System.out.print("Endereco: ");
            endereco = entrada.nextLine();
            System.out.print("CPF:");
            cpf = entrada.nextLine();
            cadastro_Cliente = new Cliente(nome, cpf, dataNascimento, idade, endereco);

            while(!cadastro_Cliente.validarCPF(cpf)) {
                System.out.println("CPF invalido!");
                System.out.println("Insira novamente: ");
                cpf = entrada.nextLine();
            }
            System.out.println("Cliente cadastrado com sucesso!");
        }
        entrada.close();
    }
}
