public enum MenuOperacoes {
	CADASTROS(1 , new SubmenuOpcoes[] {
        SubmenuCadastrar.CADASTRAR_CLIENTE,
        SubmenuCadastrar.CADASTRAR_VEICULO,
        SubmenuCadastrar.CADASTRAR_SEGURADORA,
        SubmenuCadastrar.VOLTAR
	}),
	LISTAR(2 , new SubmenuOpcoes[] {
        SubmenuListar.LISTAR_CLIENTES,
        SubmenuListar.LISTAR_SINISTROS_SEGURADORA,
        SubmenuListar.LISTAR_SINISTROS_CLIENTE,
        SubmenuListar.LISTAR_VEICULOS_SEGURADORA,
        SubmenuListar.LISTAR_VEICULOS_CLIENTE,
        SubmenuListar.VOLTAR
	}),
	EXCLUIR(3 , new SubmenuOpcoes[] {
			SubmenuOpcoes.EXCLUIR_CLIENTE,
			SubmenuOpcoes.EXCLUIR_VEICULO,
			SubmenuOpcoes.EXCLUIR_SINISTRO,
			SubmenuOpcoes.VOLTAR}),
	GERAR_SINISTRO(4 , new SubmenuOpcoes[] {SubmenuOpcoes.VOLTAR}),
	TRANSFERIR_SEGURO(5 , new SubmenuOpcoes[] {SubmenuOpcoes.VOLTAR}),
	CALCULAR_RECEITA_SEGURO(6, new SubmenuOpcoes[] {SubmenuOpcoes.VOLTAR}),
	SAIR(0 , new SubmenuOpcoes[] {});
	
	//atributos
	private final String descricao;
	private final SubmenuOpcoes[] submenu;
	
	//Construtor
	MenuOpcoes(String descricao, SubmenuOpcoes[] submenu){
		this.descricao = descricao;
		this.submenu = submenu;
	}
	
	//getters
	public String getDescricao() {
		return descricao;
	}
	
	public SubmenuOpcoes[] getSubmenu() {
		return submenu;
	}
}
