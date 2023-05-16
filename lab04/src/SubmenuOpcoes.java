import java.util.Scanner;
public enum SubmenuOpcoes {
    CADASTRAR_CLIENTE("Cadastrar cliente"),
	CADASTRAR_VEICULO("veiculo"),
	CADASTRAR_SEGURADORA("seguradora"),
	LISTAR_CLIENTES("cliente"),
	LISTAR_SINISTROS_SEGURADORA("sinistro - seguradora"),
    LISTAR_SINISTROS_CLIENTE("sinistro - cliente"),
	LISTAR_VEICULOS_SEGURADORA("veiculo - seguradora"),
    LISTAR_VEICULOS_CLIENTE("veiculo - cliente"),
	EXCLUIR_CLIENTE("cliente"),
	EXCLUIR_VEICULO("veiculo"),
	EXCLUIR_SINISTRO("sininstro"),
	VOLTAR("Voltar");
	
	//atributo
	private final String descricao;
	
	//Construtor
	SubmenuOpcoes(String descricao){
		this.descricao = descricao;
	}
	
	//getter
	public String getDescricao() {
		return descricao;
	}

	// public static void exibirSubmenu(MenuOpcoes op) {
	// 	SubmenuOpcoes[] submenu = op.getSubmenu();
	// 	System.out.println(op.getDescricao());
	// 	for(int i=0; i<submenu.length; i++) {
	// 		System.out.println(i +" - " + submenu[i].getDescricao());
	// 	}
	// }

	// public static SubmenuOpcoes lerOpcaoSubmenu(MenuOpcoes op) {
	// 	Scanner scanner = new Scanner(System.in);
	// 	int opUsuario;
	// 	SubmenuOpcoes opUsuarioConst;
	// 	do {
	// 		System.out.println("Digite uma opcao: ");
	// 		opUsuario = scanner.nextInt();
	// 	}while(opUsuario < 0 || opUsuario > op.getSubmenu().length - 1);
	// 	opUsuarioConst = op.getSubmenu()[opUsuario];
	// 	return opUsuarioConst;
	// }

	// public static void executarOpcaoSubMenu(SubmenuOpcoes opSubmenu) {
	// 	switch(opSubmenu) {
	// 	case CADASTRAR_CLIENTE:
	// 		System.out.println("Chamar metodo cadastrar cliente");
	// 		break;
	// 	case CADASTRAR_VEICULO:
	// 		System.out.println("Chamar metodo cadastrar veiculo");
	// 		break;
	// 	case CADASTRAR_SEGURADORA:
	// 		System.out.println("Chamar metodo cadastrar seguradora");
	// 		break;
	// 	case LISTAR_CLIENTES:
	// 		System.out.println("Chamar metodo listar clientes");
	// 		break;
	// 	case LISTAR_SINISTROS_SEGURADORA:
	// 		System.out.println("Chamar metodo listar sinistros");
	// 		break;
	// 	case LISTAR_SINISTROS_CLIENTE:
	// 		System.out.println("Chamar metodo listar sinistros");
	// 		break;
	// 	case LISTAR_VEICULOS_SEGURADORA:
	// 		System.out.println("Chamar metodo listar veiculos");
	// 		break;
	// 	case LISTAR_VEICULOS_CLIENTE:
	// 		System.out.println("Chamar metodo listar veiculos");
	// 		break;
	// 	case EXCLUIR_CLIENTE:
	// 		System.out.println("Chamar metodo excluir cliente");
	// 		break;
	// 	case EXCLUIR_VEICULO:
	// 		System.out.println("Chamar metodo excluir veiculo");
	// 		break;
	// 	case EXCLUIR_SINISTRO:
	// 		System.out.println("Chamar metodo excluir sinistro");
	// 		break;
	// 	//case VOLTAR:
	// 	//	break;
	// 	}
	// }
}
