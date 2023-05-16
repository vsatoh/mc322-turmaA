import java.util.Scanner;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Main {
    public static void main(String[] args) throws Exception {
        // ClientePF clientePF;
        // ClientePJ clientePJ, clientePJ2;
        // Seguradora seguradora;
        // Veiculo veiculo1, veiculo2, veiculo3;
        // Date data;
        // SimpleDateFormat formatadata = new SimpleDateFormat("dd/MM/yyyy");
        // Scanner entrada = new Scanner(System.in);
        // data = formatadata.parse("02/07/2002");

        // // Instanciando veiculos e chamando toString

        // veiculo1 = new Veiculo("ABC", "honda", "alibaba", 2020);
        // veiculo2 = new Veiculo("DEF", "fiat", "eren", 2021);
        // veiculo3 = new Veiculo("GHI", "samsung", "sal marinho", 2021);
        // System.out.println(veiculo1.toString());

        // // Instanciando obejtos do tipo cliente e seguradora
        // String nome;
        // String telefone;
        // String email;
        // String endereco;

        // System.out.print("Nome: ");
        // nome = entrada.nextLine();
        // System.out.print("Telefone: ");
        // telefone = entrada.nextLine();
        // System.out.print("Email: ");
        // email = entrada.nextLine();
        // System.out.print("Endereco: ");
        // endereco = entrada.nextLine();

        // seguradora = new Seguradora(nome, telefone, email, endereco);
        // clientePF = new ClientePF("Victor", "Centro", 0, formatadata.parse("02/07/2002"), "superior completo", "Masculino", "media", "149.691.157-10", data);
        // clientePJ = new ClientePJ("Abraao", "Centro", 0, "12.345.678/0002-00", formatadata.parse("16/05/2002"), 100);
        // clientePJ2 = new ClientePJ("Alirio", "Centro", 0, "00.000.000/0000-00", formatadata.parse("16/05/2002"), 200);
        // // Adicionando veiculos aos clientes

        // clientePF.addlistaVeiculos(veiculo1);
        // clientePJ.addlistaVeiculos(veiculo2);
        // clientePJ2.addlistaVeiculos(veiculo3);
        // // Cadastrando clientes na seguradora

        // seguradora.cadastrarCliente(clientePJ);
        // seguradora.cadastrarCliente(clientePF);

        // // Chmando metodos de validacao

        // System.out.println("CPF: " + clientePF.getCPF() + " eh " + Validacao.validarCPF(clientePF.getCPF()));
        // System.out.println("CNPJ: " + clientePJ.getCNPJ() + " eh " + Validacao.validarCNPJ(clientePJ.getCNPJ()));

        // // toString dos clientes 

        // System.out.println(clientePF.toString());
        // System.out.println(clientePJ.toString());

        // // Gerando sinistros

        // seguradora.gerarSinistro(clientePJ, veiculo2);
        // seguradora.gerarSinistro(clientePF, veiculo1);

        // // Chamando tostring para o primeiro elemento da lista de sinistros
        // System.out.println(seguradora.getlistaSinistros().get(0).toString());

        // seguradora.visualizarSinistro(clientePF.getNome());

        // seguradora.listarSinistros();

        // seguradora.listarClientes();

        // System.out.println("receita total: R$ " + seguradora.calcularReceita());

        // entrada.close();

		MenuOpcoes op;
		do {
			exibirMenuExterno();
			op = lerOpcaoMenuExterno();
			executarOpcaoMenuExterno(op);
		}while(op != MenuOpcoes.SAIR);
		System.out.println("Saiu do sistema");
    }
    	//exibir menu externo
	private static void exibirMenuExterno() {
		MenuOpcoes menuOpcoes[] = MenuOpcoes.values();
		System.out.println("Menu principal");
		for(MenuOpcoes op: menuOpcoes) {
			System.out.println(op.ordinal() + " - " + op.getDescricao());
		}
	}
	
	/* exibir submenus
	 * se a lista de constantes do submenu for percorrida da mesma forma que o meu externo, a opção Voltar
	 * é printada com a posição que está na lista do enum (9 - Voltar). Por isso, a lista é percorrida 
	 * de forma diferente, tendo i como o inteiro correspondente. Assim, para listar o submenu de cadastros,
	 * por exemplo, vai ser printado "3 - Voltar".
	 */
	private static void exibirSubmenu(MenuOpcoes op) {
		SubmenuOpcoes[] submenu = op.getSubmenu();
		System.out.println(op.getDescricao());
		for(int i=0; i<submenu.length; i++) {
			System.out.println(i +" - " + submenu[i].getDescricao());
		}
	}
	
	//ler opções do menu externo
	private static MenuOpcoes lerOpcaoMenuExterno() {
		Scanner scanner = new Scanner(System.in);
		int opUsuario;
		MenuOpcoes opUsuarioConst;
		do {
			System.out.println("Digite uma opcao: ");
			opUsuario = scanner.nextInt();
		}while(opUsuario < 0 || opUsuario > MenuOpcoes.values().length - 1);
		opUsuarioConst = MenuOpcoes.values()[opUsuario];
		return opUsuarioConst;
	}
	
	//ler opção dos submenus
	private static SubmenuOpcoes lerOpcaoSubmenu(MenuOpcoes op) {
		Scanner scanner = new Scanner(System.in);
		int opUsuario;
		SubmenuOpcoes opUsuarioConst;
		do {
			System.out.println("Digite uma opcao: ");
			opUsuario = scanner.nextInt();
		}while(opUsuario < 0 || opUsuario > op.getSubmenu().length - 1);
		opUsuarioConst = op.getSubmenu()[opUsuario];
		return opUsuarioConst;
	}
	
	//executar opções do menu externo
	private static void executarOpcaoMenuExterno(MenuOpcoes op) {
		switch(op) {
			case CADASTROS:
			case LISTAR:
			case EXCLUIR:
				executarSubmenu(op);
				break;
			case GERAR_SINISTRO:
				System.out.println("Executar metodo gerar Sinistro");
				break;
			case TRANSFERIR_SEGURO:
				System.out.println("Executar metodo tranferir seguro");
				break;
			case CALCULAR_RECEITA:
				System.out.println("Executar metodo calcular receita");
				break;
			//case SAIR:
		}
	}
	
	public static void executarOpcaoSubMenu(SubmenuOpcoes opSubmenu) {
		switch(opSubmenu) {
		case CADASTRAR_CLIENTE:
			System.out.println("Chamar metodo cadastrar cliente");
			break;
		case CADASTRAR_VEICULO:
			System.out.println("Chamar metodo cadastrar veiculo");
			break;
		case CADASTRAR_SEGURADORA:
			System.out.println("Chamar metodo cadastrar seguradora");
			break;
		case LISTAR_CLIENTES:
			System.out.println("Chamar metodo listar clientes");
			break;
		case LISTAR_SINISTROS:
			System.out.println("Chamar metodo listar sinistros");
			break;
		case LISTAR_VEICULOS:
			System.out.println("Chamar metodo listar veiculos");
			break;
		case EXCLUIR_CLIENTE:
			System.out.println("Chamar metodo excluir cliente");
			break;
		case EXCLUIR_VEICULO:
			System.out.println("Chamar metodo excluir veiculo");
			break;
		case EXCLUIR_SINISTRO:
			System.out.println("Chamar metodo excluir sinistro");
			break;
		//case VOLTAR:
		//	break;
		}
	}
	
	//executa os submenus: exibição do menu, leitura da opção e execução dos métodos
	private static void executarSubmenu(MenuOpcoes op) {
		SubmenuOpcoes opSubmenu;
		do {
			exibirSubmenu(op);
			opSubmenu = lerOpcaoSubmenu(op);
			executarOpcaoSubMenu(opSubmenu);
		}while(opSubmenu != SubmenuOpcoes.VOLTAR);
	}
}
