import java.util.*;
//import java.util.Date;

public class Cliente {

    private String nome;
    private String endereco;
    private List <Veiculo> listaVeiculos = new ArrayList<Veiculo>();
    private double valorSeguro;

    // Funcao construtuora

    public Cliente(String nome, String endereco, double valorSeguro) { //tem  mudar essa maldade aqui
        this.nome = nome;
        this.endereco = endereco;
        this.valorSeguro = valorSeguro;
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

    public double getValorSeguro() {
        return valorSeguro;
    }

    public void setValorSeguro(double valorSeguro) {
        this.valorSeguro = valorSeguro;
    }


    public void addlistaVeiculos(Veiculo veiculo) {
        this.listaVeiculos.add(veiculo);
    }

    public void removelistaVeiculos(Veiculo veiculo) {
        this.listaVeiculos.remove(veiculo);
    }

   public String imprimeVeiculos() {
        String listaveiculomodelado = "";
        for(Veiculo i: getListaVeiculos()) {
            listaveiculomodelado += i.toString() + "\n";
        }
        return listaveiculomodelado;
    }

    public double calculaScore() {
        double score = CalcSeguro.VALOR_BASE.getFator();
        return score;
    }

    public String toString() {
        String infocliente;
        infocliente = "Nome: " + getNome() + "\n"
        + "Endereço: " + getEndereco() + "\n"
        + "Veiculos: " + getListaVeiculos() + "\n"
        + "Valor seguro: " + getValorSeguro();
        return infocliente;
   }

}