import java.util.Random;
//import java.util.Scanner;

public class Sinistro {

    final private int ID;
    private String data;
    private String endereco;
    private Seguradora seguradora;
    private Veiculo veiculo;
    private Cliente cliente;

    public Sinistro(String data, String endereco, Seguradora seguradora, Veiculo veiculo, Cliente cliente, int ID) {
        this.ID = ID;
        this.data = data;
        this.endereco = endereco;
        this.seguradora = seguradora;
        this.veiculo = veiculo;
        this.cliente = cliente;
    }

    //getters e setters

    public int getId() {
        return ID;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public Seguradora getSeguradora() {
        return seguradora;
    }

    public void setSeguradora(Seguradora seguradora) {
        this.seguradora = seguradora;
    }

    public Veiculo getVeiculo() {
        return veiculo;
    }

    public void setVeiculo(Veiculo veiculo) {
        this.veiculo = veiculo;
    }
    
    public Cliente getCliente() {
        return cliente;
    }

    public void setVeiculo(Cliente cliente) {
        this.cliente = cliente;
    }
    // gera um numero randomico entre 1 e 999999

    public static int geraId(Seguradora seguradora) {
        int n;
        do {
            Random rand = new Random();
            n = rand.nextInt(999999);
            n +=1;
            if(!seguradora.getListaID().contains(n)) {
                seguradora.addlistaID(n);;
                return n;
            }
        } while(seguradora.getListaID().contains(n));
        return 0;
    }
    
    //funcao de printar as variaveis do objeto
    public String toString() {
        String infoSinistro;
        infoSinistro = "ID: " + getId() + "\n"
        + "Data: " + getData() + "\n"
        + "Endereco: " + getEndereco() + "\n\n"
        + "Seguradora: \n"
        + getSeguradora() + "\n"
        + "Veiculo: \n"
        + getVeiculo() + "\n"
        + "Cliente: \n"
        + getCliente();
        return infoSinistro;
   }
}