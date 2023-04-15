import java.util.Random;
public class Sinistro {

    final private int id;
    private String data;
    private String endereco;
    private Seguradora seguradora;
    private Veiculo veiculo;

    public Sinistro(String data, String endereco, Seguradora seguradora, Veiculo veiculo) {
        this.id = geraId();
        this.data = data;
        this.endereco = endereco;
        this.seguradora = seguradora;
        this.veiculo = veiculo;
    }

    //getters e setters

    public int getId() {
        return id;
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
    // gera um numero randomico entre 1 e 999999

    public int geraId() {
        Random rand = new Random();
        int n = rand.nextInt(999999);
        n +=1;
        return n;
    }
    
    //funcao de printar as variaveis do objeto
    public String toString() {
        String infoSinistro;
        infoSinistro = "ID: " + getId() + "\n"
        + "Data: " + getData() + "\n"
        + "Endereco: " + getEndereco() + "\n"
        + "Seguradora: " + getSeguradora() + "\n"
        + "Veiculo: " + getVeiculo() + "\n";
        return infoSinistro;
   }
}