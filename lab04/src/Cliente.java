import java.util.*;
//import java.util.Date;

public class Cliente {

    private String nome;
    private String endereco;
    private List <Veiculo> listaVeiculos = new ArrayList<Veiculo>();

    // Funcao construtuora

    public Cliente(String nome, String endereco) {
        this.nome = nome;
        this.endereco = endereco;
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

    public List <Veiculo> getListaVeiculos() {
        return listaVeiculos;
    }
    
    public void setListaVeiculos(List <Veiculo> listaVeiculos) {
        this.listaVeiculos = listaVeiculos ;
    }

    public void addlistaVeiculos(Veiculo veiculo) {
        this.listaVeiculos.add(veiculo);
   }

   public String imprimeVeiculos() {
    String listaveiculomodelado = "";
    for(Veiculo i: getListaVeiculos()) {
        listaveiculomodelado += i.toString() + "\n";
    }
    return listaveiculomodelado;
    }

    public String toString() {
        String infocliente;
        infocliente = "Nome: " + getNome() + "\n"
        + "Endereço: " + getEndereco() + "\n"
        + "Veiculos: " + getListaVeiculos();
        return infocliente;
   }

}