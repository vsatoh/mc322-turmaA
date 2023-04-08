import java.util.*;
import java.util.Date;

public class Cliente {

    private String nome;
    private String endereco;
    private Date dataLicenca;
    private String educacao;
    private String genero;
    private String classeEconomica;
    private List <Veiculo> listaVeiculos = new ArrayList<Veiculo>();;

    // Funcao construtuora

    public Cliente(String nome, String endereco, Date dataLicenca, String educacao, String genero, String classeEconomica, List <Veiculo> listaVeiculos) {
        this.nome = nome;
        this.endereco = endereco;
        this.dataLicenca = dataLicenca;
        this.educacao = educacao;
        this.genero = genero;
        this.classeEconomica = classeEconomica;
        this.listaVeiculos = listaVeiculos;
    }

    //getters e setters

    public String getNomeCliente() {
        return nome;
    }

    public void setNomeCliente(String nome) {
        this.nome = nome;
    }

    public String getEnderecoCliente() {
        return endereco ;
    }
    
    public void setEnderecoCliente(String endereco) {
        this.endereco = endereco ;
    }

    public Date getDataLicencaCliente() {
        return dataLicenca;
    }

    public void setDataLicencaCliente(Date dataLicenca) {
        this.dataLicenca = dataLicenca;
    } 

    public String getEducacao() {
        return educacao ;
    }
    
    public void setEducacao(String educacao) {
        this.educacao = educacao ;
    }

    public String getGenero() {
        return genero;
    }
    
    public void setGenero(String genero) {
        this.genero = genero ;
    }

    public String getClasseEconomica() {
        return classeEconomica;
    }
    
    public void setGeneroClasseEconomica(String classeEconomica) {
        this.classeEconomica = classeEconomica ;
    }

    // public List <Veiculo> getListaVeiculos() {
    //     return listaVeiculos;
    // }
    
    // public List <Veiculo> setGeneroClasseListaVeiculos(List <Veiculo> listaVeiculos) {
    //     this.listaVeiculos = listaVeiculos ;
    // }


}