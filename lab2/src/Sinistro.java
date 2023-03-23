import java.util.Random;
public class Sinistro {

    private int id;
    private String data;
    private String endereco;

    public Sinistro(int id, String data, String endereco) {
        this.id = id;
        this.data = data;
        this.endereco = endereco;
    }

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

    public int geraId() {
        Random rand = new Random();
        int n = rand.nextInt(999999);
        n +=1;
        return n;
    }
}