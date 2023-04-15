import java.util.*;
import java.util.Date;

public class Cliente {

    private String nome;
    private String endereco;
    private Date dataLicenca;
    private String educacao;
    private String genero;
    private String classeEconomica;
    private List <Veiculo> listaVeiculos = new ArrayList<Veiculo>();

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

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEndereco() {
        return endereco ;
    }
    
    public void setEndereco(String endereco) {
        this.endereco = endereco ;
    }

    public Date getDataLicenca() {
        return dataLicenca;
    }

    public void setDataLicenca(Date dataLicenca) {
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

    public String toString() {
        String infocliente;
        infocliente = "Nome: " + getNome() + "\n"
        + "Endereço: " + getEndereco() + "\n"
        + "Data Licenca: " + getDataLicenca() + "\n"
        + "Educacao: " + getEducacao() + "\n"
        + "Genero: " + getGenero() + "\n"
        + "Classe Economica: " + getClasseEconomica();
        return infocliente;
   }

}