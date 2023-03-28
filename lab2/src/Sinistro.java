import java.util.Random;
public class Sinistro {

    private int id;
    private String data;
    private String endereco;

    public Sinistro(String data, String endereco) {
        this.id = geraId();
        this.data = data;
        this.endereco = endereco;
    }

    //getters e setters

    public int getIdSinistro() {
        return id;
    }

    public void setIdSinistro(int id) {
        this.id = id;
    }

    public String getDataSinistro() {
        return data;
    }

    public void setDataSinistro(String data) {
        this.data = data;
    }

    public String getEnderecoSinistro() {
        return endereco;
    }

    public void setEnderecoSinistro(String endereco) {
        this.endereco = endereco;
    }

    // gera um numero randomico entre 1 e 999999

    public int geraId() {
        Random rand = new Random();
        int n = rand.nextInt(999999);
        n +=1;
        return n;
    }
    
    //funcao de printar as variaveis do objeto

    public void printSinistro() {
        System.out.println("ID: " + getIdSinistro());
        System.out.println("Data: " + getDataSinistro());
        System.out.println("Endereco: " + getEnderecoSinistro());
   }
}