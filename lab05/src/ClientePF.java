import java.util.Date;

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

    // public String getClasseEconomica() {
    //     return classeEconomica;
    // }
    
    // public void setGeneroClasseEconomica(String classeEconomica) {
    //     this.classeEconomica = classeEconomica ;
    // }
     
    @Override
    public double calculaScore() {
        double score, fator = 0;
        int idade = calculaIdade();
        if(idade >= 18 & idade < 30) {
            fator = CalcSeguro.FATOR_18_30.getFator();
        } else if(idade >= 30 & idade < 60) {
            fator = CalcSeguro.FATOR_30_60.getFator();
        } else if(idade >= 60 & idade < 90) {
            fator = CalcSeguro.FATOR_60_90.getFator();
        }
        score = CalcSeguro.VALOR_BASE.getFator()*fator*this.getListaVeiculos().size(); //incluir o fator idade
        return score;
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

    @Override
    public String toString() {
        String infocliente;
        infocliente = "Nome: " + getNome() + "\n"
        + "Endereco: " + getEndereco() + "\n"
        + "Data Licenca: " + getDataLicenca() + "\n"
        + "Educacao: " + getEducacao() + "\n"
        + "Genero: " + getGenero() + "\n"
        + "Classe Economica: " + getClasseEconomica()+ "\n"
        + "CPF: " + getCPF() + "\n"
        + "Data de nascimento: " + getDataNascimento() + "\n"
        + "Veiculos: \n" 
        + imprimeVeiculos() + "\n"
        + "Valor seguro: " + getValorSeguro();
        return infocliente;
   }
}
