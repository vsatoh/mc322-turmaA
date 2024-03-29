import java.util.Scanner;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class Main {

	private static ArrayList<Seguradora> listaSeguradoras = new ArrayList<>();

	public static ClientePF coletaInfoPF() {
		SimpleDateFormat formatadata = new SimpleDateFormat("dd/MM/yyyy");
		Scanner entrada = new Scanner(System.in);
		String nome, endereco, cpf, genero, email, telefone, educacao;
		String data2;
		Date dataNascimento = null;

		do {
			System.out.println("Nome: ");
			nome = entrada.nextLine();
		} while(!Validacao.validarNome(nome));

		System.out.println("Telefone: ");
		telefone = entrada.nextLine();

		System.out.println("Endereco: ");
		endereco = entrada.nextLine();

		System.out.println("email: ");
		email = entrada.nextLine();

		do {
			System.out.println("CPF: ");
			cpf = entrada.nextLine();
		} while(!Validacao.validarCPF(cpf));

		do {
			System.out.println("Genero: ");
			genero = entrada.nextLine();
		} while(!Validacao.validarNome(genero));


		do {
			System.out.println("Educacao (somente letras): ");
			educacao = entrada.nextLine();
		} while(!Validacao.validarNome(educacao));

		// System.out.println("Data Licenca: ");
		// data1 = entrada.nextLine();

		// try {
		// 	dataLicenca = formatadata.parse(data1);
		// } catch (Exception e) {
		// 	e.printStackTrace();
		// }
		
		System.out.println("Data Nascimento: ");
		data2 = entrada.nextLine();
		try {
			dataNascimento = formatadata.parse(data2);
		} catch (Exception e) {
			e.printStackTrace();
		}

		ClientePF cliente = new ClientePF(nome, telefone, endereco, email, cpf, genero, educacao, dataNascimento);
		return cliente;
	}

	public static ClientePJ coletaInfoPJ() {
		SimpleDateFormat formatadata = new SimpleDateFormat("dd/MM/yyyy");
		Scanner entrada = new Scanner(System.in);
		String nome, telefone, endereco, email, CNPJ;
		Date dataFundacao = null;
		int qntdeFuncionarios;
		String data;

		do {
			System.out.println("Nome: ");
			nome = entrada.nextLine();
		} while(!Validacao.validarNome(nome));

		System.out.println("Telefone: ");
		telefone = entrada.nextLine();

		System.out.println("Endereco: ");
		endereco = entrada.nextLine();

		System.out.println("email: ");
		email = entrada.nextLine();

		do {
			System.out.println("CNPJ: ");
			CNPJ = entrada.nextLine();
		} while(!Validacao.validarCNPJ(CNPJ));

		System.out.println("Data fundacao: ");
		data = entrada.nextLine();

		try {
			dataFundacao = formatadata.parse(data);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		do {
			System.out.println("Quantidade de funcionarios: ");
			qntdeFuncionarios = entrada.nextInt();
		} while(qntdeFuncionarios < 0);

		ClientePJ cliente = new ClientePJ(nome, telefone, endereco, email, CNPJ, dataFundacao, qntdeFuncionarios);
		return cliente;
	}

	public static Veiculo coletaInfoVeiculo() {
		String placa;
		String marca;
		String modelo;
		int anoFabricacao;
		Scanner entrada = new Scanner(System.in);

		System.out.println("Placa: ");
		placa = entrada.nextLine();
		System.out.println("Marca: ");
		marca = entrada.nextLine();
		System.out.println("Modelo: ");
		modelo = entrada.nextLine();

		do {
			System.out.println("Ano fabricacao: ");
			anoFabricacao = entrada.nextInt();
		} while(anoFabricacao < 0);
		
		Veiculo carro = new Veiculo(placa, marca, modelo, anoFabricacao);
		return carro;
	}

	public static Seguradora coletaInfoSeguradora() {
		String nome;
		String telefone;
		String email;
		String endereco;
		Scanner entrada = new Scanner(System.in);

		do {
			System.out.println("Nome: ");
			nome = entrada.nextLine();
		} while(!Validacao.validarNome(nome));

		System.out.println("Telefone: ");
		telefone = entrada.nextLine();

		System.out.println("Email: ");
		email = entrada.nextLine();

		System.out.println("Endereco: ");
		endereco = entrada.nextLine();

		Seguradora seguradora = new Seguradora(nome, telefone, email, endereco);
		return seguradora;
	}



	public static int encontraSeguradora() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Nome seguradora: ");
		String nome = scanner.nextLine();
		for(int i = 0; i < listaSeguradoras.size(); i++) {
			if(listaSeguradoras.get(i).getNome().equals(nome)) {
				return i;
			}
		}
		return -1;
	}

	public static Cliente encontraCliente(String nome) {
		for(Seguradora s: listaSeguradoras) {
			for(Cliente c: s.getlistaClientes()) {
				if(c.getNome().equals(nome))
					return c;
			}
		}
		return null;
	}

	public static Veiculo encontraVeiculo() {
		Scanner entrada = new Scanner(System.in);
		System.out.println("QUal a placa do veiculo: ");
		String placa = entrada.nextLine();
		int s = encontraSeguradora();
		for(Cliente c: listaSeguradoras.get(s).getlistaClientes()) {
			for(Veiculo v: c.getListaVeiculos()) {
				if(v.getPlaca().equals(placa)) {
					return v;
				}
			}
		}
		return null;
	}

	public static void menuCadastroCliente() {
		int posseg = 0;
		do {
			posseg = encontraSeguradora();
		} while (posseg == -1);
		System.out.println("Pessoa Física (1) ou Jurídica (2) ?");
		Scanner scanner = new Scanner(System.in);
		int tipopessoa = scanner.nextInt();
		System.out.println("Insira as informacoes abaixo: ");
		if(tipopessoa == 1) {
			ClientePF clientePF = coletaInfoPF();
			listaSeguradoras.get(posseg).cadastrarCliente(clientePF);
		} else if(tipopessoa == 2) {
			ClientePJ clientePJ = coletaInfoPJ();
			listaSeguradoras.get(posseg).cadastrarCliente(clientePJ);
		}
	}

	public static void listarSinistrosCliente() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Nome cliente: ");
		String nome = scanner.nextLine();
		for (int j = 0; j < listaSeguradoras.size(); j++) {
			for (int i = 0; i < listaSeguradoras.get(j).getlistaSinistros().size(); i++) {
				if(listaSeguradoras.get(j).getlistaSinistros().get(i).getCliente().getNome().equals(nome)) {
					System.out.println(listaSeguradoras.get(j).getlistaSinistros().get(i).toString());
				}
		   }
		}
    }

	public static void listarVeiculosSeguradora() {
		int pos = encontraSeguradora();
		for (Cliente c: listaSeguradoras.get(pos).getlistaClientes()) {
			for (Veiculo v: c.getListaVeiculos()) {
				System.out.println(v.toString());
			}
		}
	}

	public static void listarVeiculosCliente() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Nome cliente: ");
		String nome = scanner.nextLine();
		Cliente c = encontraCliente(nome);
		for (Veiculo v: c.getListaVeiculos()){
			System.out.println(v.toString());
		}
	}

	public static void excluirCliente() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Digite o nome do cliente: ");
		String nome = scanner.nextLine();
		int s = encontraSeguradora();
		int pos = 0;
		for(int i = 0; i < listaSeguradoras.get(s).getlistaClientes().size(); i++) {
			if(listaSeguradoras.get(s).getlistaClientes().get(i).getNome().equals(nome))
				pos = i;
		}
		listaSeguradoras.get(s).getlistaClientes().remove(pos);
	}

	public static void excluirSinistro() {
		int s = encontraSeguradora();
		System.out.println("Digite o nome do cliente: ");
		Veiculo carro = encontraVeiculo();
		for(Sinistro si : listaSeguradoras.get(s).getlistaSinistros()) {
			if(si.getVeiculo().equals(carro)) {
				listaSeguradoras.get(s).removelistaSinistros(si);
			}
		}
	}
	//transferir seguro
	public static void transferirSeguro() {
		int posseg = encontraSeguradora();
		String ncliente1, ncliente2;
		Scanner scanner = new Scanner(System.in);
		System.out.println("Digite o nome do cliente que deseja transferir o seguro: ");
		ncliente1 = scanner.nextLine();
		System.out.println("Digite o nome do cliente que receberá o seguro: ");
		ncliente2 = scanner.nextLine();
		Cliente cliente1 = encontraCliente(ncliente1);
		Cliente cliente2 = encontraCliente(ncliente2);
		for(Veiculo carro: cliente1.getListaVeiculos()) {
			for(Sinistro s: listaSeguradoras.get(posseg).getlistaSinistros()) {
				if(s.getVeiculo() == carro) {
					cliente2.addlistaVeiculos(carro);
					cliente1.removelistaVeiculos(carro);
				}
			}
		}
		listaSeguradoras.get(posseg).calcularPrecoSeguroCliente(cliente2);
		cliente2.setValorSeguro(0.0);
	}

	private static void exibirMenuExterno() {
		MenuOpcoes menuOpcoes[] = MenuOpcoes.values();
		System.out.println("Menu principal");
		for(MenuOpcoes op: menuOpcoes) {
			System.out.println(op.ordinal() + " - " + op.getDescricao());
		}
	}

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
		int posseg = 0;
		switch(op) {
			case CADASTROS:
			case LISTAR:
			case EXCLUIR:
				executarSubmenu(op);
				break;
			case GERAR_SINISTRO:
				posseg = encontraSeguradora();
				Veiculo v = encontraVeiculo();
				Scanner entrada = new Scanner(System.in);
				String nomecliente = entrada.nextLine();
				Cliente cliente = encontraCliente(nomecliente);
				listaSeguradoras.get(posseg).gerarSinistro(cliente, v);		
				break;
			case TRANSFERIR_SEGURO:
				transferirSeguro();
				break;
			case CALCULAR_RECEITA:
				posseg = encontraSeguradora();
				listaSeguradoras.get(posseg).calcularReceita();
				break;
			//case SAIR:
		}
	}
	
	private static void executarOpcaoSubMenu(SubmenuOpcoes opSubmenu) {
		int posseg;
		Seguradora seguradora;
		switch(opSubmenu) {
		case CADASTRAR_CLIENTE:
			menuCadastroCliente();
			break;
		case CADASTRAR_VEICULO:
			System.out.println("Insira as informacoes abaixo: ");
			Veiculo carro = coletaInfoVeiculo();
			break;
		case CADASTRAR_SEGURADORA:
			System.out.println("Insira as informacoes abaixo: ");
			seguradora = coletaInfoSeguradora();
			listaSeguradoras.add(seguradora);
			break;
		case LISTAR_CLIENTES:
			posseg = encontraSeguradora();
			listaSeguradoras.get(posseg).listarClientes();
			break;
		case LISTAR_SINISTROS_SEGURADORA:
			posseg = encontraSeguradora();
			listaSeguradoras.get(posseg).listarSinistros();
			break;
		case LISTAR_SINISTROS_CLIENTE:
			listarSinistrosCliente();
			break;
		case LISTAR_VEICULOS_SEGURADORA:
			listarVeiculosSeguradora();
			break;
		case LISTAR_VEICULOS_CLIENTE:
			listarVeiculosCliente();
			break;
		case EXCLUIR_CLIENTE:
			excluirCliente();
			break;
		case EXCLUIR_VEICULO:
			System.out.println("Chamar metodo excluir veiculo");
			break;
		case EXCLUIR_SINISTRO:
			excluirSinistro();
			break;
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

    public static void main(String[] args) throws Exception {
        ClientePF clientePF;
        ClientePJ clientePJ, clientePJ2;
        Seguradora seguradora;
        Veiculo veiculo1, veiculo2, veiculo3;
        Date data;
        SimpleDateFormat formatadata = new SimpleDateFormat("dd/MM/yyyy");
        Scanner entrada = new Scanner(System.in);
        data = formatadata.parse("02/07/2002");

        // Instanciando veiculos e chamando toString

        veiculo1 = new Veiculo("ABC", "honda", "alibaba", 2020);
        veiculo2 = new Veiculo("DEF", "fiat", "eren", 2021);
        veiculo3 = new Veiculo("GHI", "samsung", "sal marinho", 2021);
        System.out.println(veiculo1.toString());

        // Instanciando obejtos do tipo cliente e seguradora

        seguradora = new Seguradora("seguros shark", "00000000", "seguros@example.com", "rua 4");
        clientePF = new ClientePF("Victor", "Centro", 0, formatadata.parse("02/07/2002"), "superior completo", "Masculino", "media", "149.691.157-10", data);
        clientePJ = new ClientePJ("Abraao", "Centro", 0, "12.345.678/0002-00", formatadata.parse("16/05/2002"), 100);
        clientePJ2 = new ClientePJ("Alirio", "Centro", 0, "00.000.000/0000-00", formatadata.parse("16/05/2002"), 200);
        // Adicionando veiculos aos clientes

        clientePF.addlistaVeiculos(veiculo1);
        clientePJ.addlistaVeiculos(veiculo2);
        clientePJ2.addlistaVeiculos(veiculo3);
        // Cadastrando clientes na seguradora

        seguradora.cadastrarCliente(clientePJ);
        seguradora.cadastrarCliente(clientePF);

        // Chmando metodos de validacao

        System.out.println("CPF: " + clientePF.getCPF() + " eh " + Validacao.validarCPF(clientePF.getCPF()));
        System.out.println("CNPJ: " + clientePJ.getCNPJ() + " eh " + Validacao.validarCNPJ(clientePJ.getCNPJ()));

        // toString dos clientes 

        System.out.println(clientePF.toString());
        System.out.println(clientePJ.toString());

        // Gerando sinistros

        seguradora.gerarSinistro(clientePJ, veiculo2);
        seguradora.gerarSinistro(clientePF, veiculo1);

        // Chamando tostring para o primeiro elemento da lista de sinistros
        System.out.println(seguradora.getlistaSinistros().get(0).toString());

        seguradora.visualizarSinistro(clientePF.getNome());

        seguradora.listarSinistros();

        seguradora.listarClientes();

        System.out.println("receita total: R$ " + seguradora.calcularReceita());

		MenuOpcoes op;
		do {
			exibirMenuExterno();
			op = lerOpcaoMenuExterno();
			executarOpcaoMenuExterno(op);
		}while(op != MenuOpcoes.SAIR);
		System.out.println("Saiu do sistema");
		entrada.close();
    }
}