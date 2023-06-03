import java.util.Date;
import java.util.List;

public class ClientePJ extends Cliente {
    final private String CNPJ;
    private Date dataFundacao;
    // private int qntdeFuncionarios;
    // private double valorSeguro;
    private List <Frotas> listaFrota = new Arraylist<Frotas>();

    public ClientePJ(String nome, String telefone, String endereco, String email String CNPJ, Date dataFundacao) {
        super(nome, telefone, endereco, email);
        this.CNPJ = CNPJ;
        this.dataFundacao = dataFundacao;
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

    // public void setQntdeFuncionarios(int qntdeFuncionarios) {
    //     this.qntdeFuncionarios = qntdeFuncionarios;
    // } 

    // public int getQntdeFuncionarios() {
    //     return qntdeFuncionarios;
    // }

    @Override
    public double calculaScore() {
        double score;
        score = CalcSeguro.VALOR_BASE.getFator()*(1+(qntdeFuncionarios)/100)*this.getListaVeiculos().size();
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
        + imprimeVeiculos() + "\n"
        + "Valor seguro: " + getValorSeguro();
        return infocliente;
   }
}
