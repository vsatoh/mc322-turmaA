import java.util.Date;

public class ClientePF extends Cliente {
    final private String cpf;
    private String genero;
    private Date dataLicenca;
    private String educacao;
    private Date dataNascimento;
    private String classeEconomica;

    public ClientePF(String nome, String endereco, Date dataLicenca, String educacao, String genero, String classeEconomica, String cpf, Date dataNascimento) {
        super(nome, endereco);
        this.dataLicenca = dataLicenca;
        this.educacao = educacao;
        this.genero = genero;
        this.classeEconomica = classeEconomica;
        this.cpf = cpf;
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

    public Date getDataLicenca() {
        return dataLicenca;
    }

    public void setDataLicenca(Date dataLicenca) {
        this.dataLicenca = dataLicenca;
    } 

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

    public String getClasseEconomica() {
        return classeEconomica;
    }
    
    public void setGeneroClasseEconomica(String classeEconomica) {
        this.classeEconomica = classeEconomica ;
    }
     
    public double calculaScore() {
        double score, fator;
        int idade = calculaIdade();
        if(idade >= 18 & idade < 30) {
            fator = CalcSeguro.FATOR_18_30.getFator();
        } else if(idade >= 30 & idade < 60) {
            fator = CalcSeguro.FATOR_30_60.getFator();
        } else if(idade >= 60 & idade < 90) {
            fator = CalcSeguro.FATOR_60_90.getFator();
        }
        score = CalcSeguro.VALOR_BASE.getFator()*fator*this.getListaVeiculos().length; //incluir o fator idade
        return score;
    }

    //calcula idade
    public int calculaIdade() {
        int diahj = 15, meshj = 5, anohj = 2023;
        int diac = this.getDataNascimento().getDate(),
        mesc = this.getDataNascimento().getMonth()+1,
        anoc = this.getDataNascimento().getYear();
        int idade = anohj-anoc;
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
        + imprimeVeiculos();
        return infocliente;
   }
}
