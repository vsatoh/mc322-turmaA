public enum SubmenuExcluir {
    EXCLUIR_CLIENTE(1),
	EXCLUIR_VEICULO(2),
	EXCLUIR_SINISTRO(3),
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
