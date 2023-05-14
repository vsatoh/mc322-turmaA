public enum MenuOperacoes {
	CADASTROS(1 , new SubmenuCadastrar[] {
        SubmenuCadastrar.CADASTRAR_CLIENTE,
        SubmenuCadastrar.CADASTRAR_VEICULO,
        SubmenuCadastrar.CADASTRAR_SEGURADORA,
        SubmenuCadastrar.VOLTAR
	}),
	LISTAR(2 , new SubmenuListar[] {
        SubmenuListar.LISTAR_CLIENTES,
        SubmenuListar.LISTAR_SINISTROS_SEGURADORA,
        SubmenuListar.LISTAR_SINISTROS_CLIENTE,
        SubmenuListar.LISTAR_VEICULOS_SEGURADORA,
        SubmenuListar.LISTAR_VEICULOS_CLIENTE,
        SubmenuListar.VOLTAR
	}),
	EXCLUIR(3 , new SubmenuExcluir[] {
        SubmenuExcluir.EXCLUIR_CLIENTE,
        SubmenuExcluir.EXCLUIR_VEICULO,
        SubmenuExcluir.EXCLUIR_SINISTRO,
        SubmenuExcluir.VOLTAR}),
	GERAR_SINISTRO(4 , new SubmenuCadastrar[] {SubmenuCadastrar.VOLTAR}),
	TRANSFERIR_SEGURO(5 , new SubmenuCadastrar[] {SubmenuCadastrar.VOLTAR}),
	CALCULAR_RECEITA_SEGURO(6, new SubmenuCadastrar[] {SubmenuCadastrar.VOLTAR}),
	SAIR(0 , new SubmenuCadastrar[] {});
	
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
