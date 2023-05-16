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
}
