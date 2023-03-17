public class Cliente {

    private String nome;
    private String cpf;
    private String dataNascimento;
    private int idade;
    private String endereco;

    public void CriaSeguradora(String nome, String cpf, String dataNascimento, int idade, String endereco) {
        this.nome = nome;
        this.cpf = cpf;
        this.dataNascimento = dataNascimento;
        this.idade = idade;
        this.endereco = endereco;
    }

    public String getNomeCliente() {
        return nome;
    }

    public void setNomeCliente(String nome) {
        this.nome = nome;
    }

    public String getDataNascimentoCliente() {
        return dataNascimento;
    }

    public void setDataNascimentoCliente(String dataNascimento) {
        this.dataNascimento = dataNascimento;
    } 
    
    public String getCpfCliente() {
        return cpf;
    }

    public void setCpfCliente(String cpf) {
        this.cpf = cpf;
    } 

    public int setIdadeCliente() {
        return idade;
    }

    public void getIdadeCliente(int idade) {
        this.idade = idade;
    }

    public String getEnderecoCliente() {
        return endereco ;
    }
    
    public void setEnderecoCliente(String endereco) {
        this.endereco = endereco ;
    }
}