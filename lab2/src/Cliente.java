public class Cliente {

    private String nome;
    private String cpf;
    private String dataNascimento;
    private int idade;
    private String endereco;

    public void CriaSeguradora(String nome, String telefone, String email, String endereco) {
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
    
    public String setEmail() {
    return email;
    }

    public void getEmail(String email) {
    this.email = email;
    }

    public String getEndereco () {
        return endereco ;
    }
    
    public void setEndereco ( String endereco ) {
        this . endereco = endereco ;
    }
}