public enum SubmenuCadastrar {
    CADASTRAR_CLIENTE(1),
	CADASTRAR_VEICULO(2),
	CADASTRAR_SEGURADORA(3),
	VOLTAR(4);
	
	//atributo
	private final int descricao;
	
	//Construtor
	SubmenuOpcoes(int descricao){
		this.descricao = descricao;
	}
	
	//getter
	public int getDescricao() {
		return descricao;
	}
}
