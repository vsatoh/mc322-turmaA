import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        String n_cadastro;
        Cliente cadastro_Cliente;
        Seguradora cadastro_Seguradora;
        Sinistro cadastro_Sinistro;
        Veiculo cadastro_Veiculo;
        Scanner entrada = new Scanner(System.in);

        System.out.println("Cadastro:");
        System.out.println("(1) - Cliente");
        System.out.println("(2) - Seguradora");
        System.out.println("(3) - Sinistro");
        System.out.println("(4) - Veiculo");
        
        n_cadastro = entrada.nextLine();
        while(!n_cadastro.equals("0")) {
            if(n_cadastro.equals("1")) {
                //criação do objeto Cliente
                String nome;
                String cpf;
                String dataNascimento;
                int idade;
                String idade_s;
                String endereco;
    
                System.out.print("Nome: ");
                nome = entrada.nextLine();
                System.out.print("CPF: ");
                cpf = entrada.nextLine();
                System.out.print("Data de Nascimento: ");
                dataNascimento = entrada.nextLine();
                System.out.print("Idade: ");
                idade_s = entrada.nextLine();
                idade = Integer.parseInt(idade_s);
                System.out.print("Endereco: ");
                endereco = entrada.nextLine();
                //cadastro_Cliente = new Cliente(nome, cpf, dataNascimento, idade, endereco);
    
                while(!cadastro_Cliente.validarCPF(cpf)) {
                    System.out.println("CPF invalido!");
                    System.out.println("Insira novamente: ");
                    cpf = entrada.nextLine();
                }
                System.out.println("Cliente cadastrado com sucesso!");
            } 
            else if(n_cadastro.equals("2")) {
                //criação do objeto Seguradora
                String nome;
                String telefone;
                String email;
                String endereco;
    
                System.out.print("Nome: ");
                nome = entrada.nextLine();
                System.out.print("Telefone: ");
                telefone = entrada.nextLine();
                System.out.print("Email: ");
                email = entrada.nextLine();
                System.out.print("Endereco: ");
                endereco = entrada.nextLine();
    
                //cadastro_Seguradora = new Seguradora(nome, telefone, email, endereco);      
                //cadastro_Seguradora.printSeguradora();     
            }
            else if(n_cadastro.equals("3")) {
                //criação do objeto Sinistro

                String data;
                String endereco;
    
                System.out.print("Data: ");
                data = entrada.nextLine();
                System.out.print("Endereco: ");
                endereco = entrada.nextLine();
    
                //cadastro_Sinistro = new Sinistro(data, endereco);
                //cadastro_Sinistro.printSinistro();
            }
            else if(n_cadastro.equals("4")) {
                //criação do objeto Veiculo
 
                String placa;
                String marca;
                String modelo;
    
                System.out.print("Placa: ");
                placa = entrada.nextLine();
                System.out.print("Marca: ");
                marca = entrada.nextLine();
                System.out.print("Modelo: ");
                modelo = entrada.nextLine();
    
                //cadastro_Veiculo = new Veiculo(placa, marca, modelo);
                //cadastro_Veiculo.printVeiculo();
            }
        }
        entrada.close();
    }
}
