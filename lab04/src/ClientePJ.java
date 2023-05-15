import java.util.Date;

public class ClientePJ extends Cliente {
    final private String CNPJ;
    private Date dataFundacao;
    private int qntdeFuncionarios;

    public ClientePJ(String nome, String endereco, String CNPJ, Date dataFundacao, int qntdeFuncionarios) {
        super(nome, endereco);
        this.CNPJ = CNPJ;
        this.dataFundacao = dataFundacao;
        this.qntdeFuncionarios = qntdeFuncionarios;
    }
    
    public Date getDataFundacao() {
        return dataFundacao;
    }

    public void setDataFundacao(Date dataFundacao) {
        this.dataFundacao = dataFundacao;
    } 

    public String getCNPJ() {
        return CNPJ;
    }

    public void setQntdeFuncionarios(int qntdeFuncionarios) {
        this.qntdeFuncionarios = qntdeFuncionarios;
    } 

    public String getQntdeFuncionarios() {
        return qntdeFuncionarios;
    }

    public double calculaScore() {
        double score;
        score = CalcSeguro.VALOR_BASE*(1+(qntdeFuncionarios)/100)*this.getListaVeiculos().length;
        return score;
    }

    @Override
    public String toString() {
        String infocliente;
        infocliente = "Nome: " + getNome() + "\n"
        + "Endereco: " + getEndereco() + "\n"
        + "CNPJ: " + getCNPJ() + "\n"
        + "Data de fundacao: " + getDataFundacao() + "\n"
        + "Veiculos: \n" 
        + imprimeVeiculos();
        return infocliente;
   }
}
