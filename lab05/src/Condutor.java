import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Condutor {
    final private String cpf;
    private String nome;
    private String telefone;
    private String endereco;
    private String email;
    private Date dataNasc;
    private List <Sinistro> listaSinistros = new ArrayList<Sinistro>();

    public Condutor(String cpf, String nome, String telefone, String endereco, String email, Date dataNasc) {
        this.cpf = cpf;
        this.nome = nome;
        this.telefone = telefone;
        this.endereco = endereco;
        this.email = email;
        this.dataNasc = dataNasc;
    }

    public String getCPF() {
        return cpf;
    }
    
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

    public Date getDataNascimento() {
        return dataNasc;
    }

    public void setDataNascimento(Date dataNasc) {
        this.dataNasc = dataNasc;
    } 

    public List <Sinistro> getListaSinistro() {
        return listaSinistros;
    }

    public void setListaSinistro(List <Sinistro> listaSinistros) {
        this.listaSinistros = listaSinistros;
    }

    //calcula idade
    public int calculaIdade() {
        int diahj = 15, meshj = 5, anohj = 2023;
        int diac = this.getDataNascimento().getDate(),
        mesc = this.getDataNascimento().getMonth()+1,
        anoc = this.getDataNascimento().getYear() + 1900;
        int idade = anohj - anoc;
        if((meshj < mesc) | meshj == mesc & diahj < diac) {
            idade -= 1;
        }
        return idade;
    }

    public boolean adicionarSinistro(int ID, Seguro seguro) {
        for(int i = 0; i < seguro.getListaSinistro().size(); i++) {
            if(seguro.getListaSinistro().get(i).getId() == ID) {
                this.listaSinistros.add(seguro.getListaSinistro().get(i));
                System.out.println("SInistro adiionado com sucesso!");
                return true;
            }
        }
        System.out.println("Sinistro não encontrado");
        return false;
    }
    
    public String toString() {
        String infoCondutor;
        infoCondutor = "Nome: " + getNome() + "\n"
        + "Telefone: " + getTelefone() + "\n"
        + "CPF: " + getCPF() + "\n"
        + "Endereco" + getEndereco() + "\n"
        + "Email: " + getEmail() + "\n"
        + "Data de Nascimento" + getDataNascimento() + "\n";
        return infoCondutor;
    }
}
