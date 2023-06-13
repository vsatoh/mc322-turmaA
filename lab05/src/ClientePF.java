import java.util.Date;
import java.util.*;
public class ClientePF extends Cliente {
    final private String cpf;
    private String genero;
    private String educacao;
    private Date dataNascimento;
    private List <Veiculo> listaVeiculos = new ArrayList<Veiculo>();

    public ClientePF(String nome, String telefone, String endereco, String email, String cpf, String genero, String educacao, Date dataNascimento) {
        super(nome, telefone, endereco, email);
        this.cpf = cpf;
        this.genero = genero;
        this.educacao = educacao;
        this.dataNascimento = dataNascimento;
    }
    
    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    } 

    public String getCPF() {
        return cpf;
    }

    // public Date getDataLicenca() {
    //     return dataLicenca;
    // }

    // public void setDataLicenca(Date dataLicenca) {
    //     this.dataLicenca = dataLicenca;
    // } 

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

    public List <Veiculo> getListaVeiculos() {
        return listaVeiculos;
    }

    public void setListaVeiculos(List <Veiculo> listaVeiculos) {
        this.listaVeiculos = listaVeiculos ;
    }

    // public String getClasseEconomica() {
    //     return classeEconomica;
    // }
    
    // public void setGeneroClasseEconomica(String classeEconomica) {
    //     this.classeEconomica = classeEconomica ;
    // }
    
    public boolean addVeiculo(Veiculo veiculo) {
        //verificar se o carro existe
        //verificar se o carro ja esta na lista
        if(getListaVeiculos().contains(veiculo)) {
            System.out.println("Veiculo ja cadastrado");
            return false;
        }
        this.listaVeiculos.add(veiculo);
        System.out.println("Veiculo cadastrado com sucesso");
        return true
    }

    public boolean removeVeiculo(Veiculo veiculo) {
        if(!getListaVeiculos().contains(veiculo)) {
            System.out.println("Veiculo nao encontrado");
            return false;
        }
        this.listaVeiculos.remove(veiculo);
        System.out.println("Veiculo removido com sucesso");
        return true;
    }

    public String imprimeVeiculos() {
        String listaveiculomodelado = "";
        for(Veiculo i: getListaVeiculos()) {
            listaveiculomodelado += i.toString() + "\n";
        }
        return listaveiculomodelado;
    }

    @Override
    public String toString() {
        String infocliente;
        infocliente = "Nome: " + getNome() + "\n"
        + "Telefone: " + getTelefone() + "\n"
        + "Endereço: " + getEndereco() + "\n"
        + "Email: " + getEmail() + "\n"
        + "Educacao: " + getEducacao() + "\n"
        + "Genero: " + getGenero() + "\n"
        + "CPF: " + getCPF() + "\n"
        + "Data de nascimento: " + getDataNascimento() + "\n"
        + "Veiculos: \n" 
        + imprimeVeiculos() + "\n"
        return infocliente;
   }
}
