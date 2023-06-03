import java.util.Random;
//import java.util.Scanner;

public class Sinistro {

    final private int ID;
    private Date data;
    private String endereco;
    private Condutor condutor;
    private Seguro seguro;

    public Sinistro(int ID, Date data, String endereco, Condutor condutor, Seguro seguro) {
        this.ID = ID;
        this.data = data;
        this.endereco = endereco;
        this.condutor = condutor;
        this.seguro = seguro;
    }

    //getters e setters

    public int getId() {
        return ID;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public Condutor getCondutor() {
        return condutor;
    }

    public void setCondutor(Condutor condutor) {
        this.condutor = condutor;
    }

    public Seguro getSeguro() {
        return seguro;
    }

    public void setSeguro(Seguro seguro) {
        this.seguro = seguro;
    }

    // gera um numero randomico entre 1 e 999999

    public static int geraId(Seguradora seguradora) {
        int n;
        do {
            Random rand = new Random();
            n = rand.nextInt(999999);
            n +=1;
            if(!seguradora.getListaID().contains(n)) {
                seguradora.addlistaID(n);
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
        + "Condutor: \n"
        + getCondutor() + "\n"
        + "Seguro: \n"
        + getSeguro();
        return infoSinistro;
   }
}