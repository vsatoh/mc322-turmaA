public enum SubmenuListar {
    LISTAR_CLIENTES(1),
	LISTAR_SINISTROS_SEGURADORA(2),
	LISTAR_SINISTROS_CLIENTE(3),
    LISTAR_VEICULOS_SEGURADORA(4),
    LISTAR_VEICULOS_CLIENTE(5),
	VOLTAR(6);
	
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