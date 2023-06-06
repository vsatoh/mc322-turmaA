import java.util.Date;
import java.util.List;
import java.util.Scanner;


public class ClientePJ extends Cliente {
    final private String CNPJ;
    private Date dataFundacao;
    private int qntdeFuncionarios;
    // private double valorSeguro;
    private List <Frota> listaFrota = new Arraylist<Frotas>();

    public ClientePJ(String nome, String telefone, String endereco, String email String CNPJ, Date dataFundacao, int qntdeFuncionarios) {
        super(nome, telefone, endereco, email);
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

    public int getQntdeFuncionarios() {
        return qntdeFuncionarios;
    }

    public boolean cadastrarFrota() {
        Scanner entrada = new Scanner(System.in);
        Frota frota;
        String code;
        code = entrada.nextLine();
        for(int i = 0; i < listaFrota.size(); i++) {
            if(listaFrota.get(i).getCode().equals(code)) {
                System.out.println("Erro - Frota ja cadastrada!");
                return false;
            }
        }
        frota = new Frota(code);
        
        this.listaFrota.add(frota);
        System.out.println("Nova frota cadastrada com sucesso");
        return true
    }

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

    public int calculaIdade() {
        int diahj = 15, meshj = 5, anohj = 2023;
        int diac = this.getDataFundacao().getDate(),
        mesc = this.getDataFundacao().getMonth()+1,
        anoc = this.getDataFundacao().getYear() + 1900;
        int idade = anohj - anoc;
        if((meshj < mesc) | meshj == mesc & diahj < diac) {
            idade -= 1;
        }
        return idade;
    }
}
