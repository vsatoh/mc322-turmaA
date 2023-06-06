import java.util.*;
//import java.util.Date;

public abstract class Cliente {

    private String nome;
    private String telefone;
    private String endereco;
    private String email;


    // Funcao construtuora

    public Cliente(String nome, String telefone, String endereco, String email) { //tem  mudar essa maldade aqui
        this.nome = nome;
        this.telefone = telefone;
        this.endereco = endereco;
        this.email = email;
    }

    //getters e setters

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEndereco() {
        return endereco ;
    }
    
    public void setEndereco(String endereco) {
        this.endereco = endereco ;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    // public List <Veiculo> getListaVeiculos() {
    //     return listaVeiculos;
    // }
    
    // public void setListaVeiculos(List <Veiculo> listaVeiculos) {
    //     this.listaVeiculos = listaVeiculos ;
    // }

    // public double getValorSeguro() {
    //     return valorSeguro;
    // }

    // public void setValorSeguro(double valorSeguro) {
    //     this.valorSeguro = valorSeguro;
    // }


    // public void addlistaVeiculos(Veiculo veiculo) {
    //     this.listaVeiculos.add(veiculo);
    // }

    // public void removelistaVeiculos(Veiculo veiculo) {
    //     this.listaVeiculos.remove(veiculo);
    // }

    // public double calculaScore() {
    //     double score = CalcSeguro.VALOR_BASE.getFator();
    //     return score;
    // }

    public String toString() {
        String infocliente;
        infocliente = "Nome: " + getNome() + "\n"
        + "Telefone: " + getTelefone() + "\n"
        + "Endereço: " + getEndereco() + "\n"
        + "Email: " + getEmail();
        return infocliente;
   }

}