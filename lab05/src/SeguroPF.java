import java.util.Date;

public class SeguroPF extends Seguro {
    private Veiculo veiculo;
    private ClientePF cliente;

    public SeguroPF(int ID, Date dataInicio, Date dataFim, Seguradora seguradora, int valorMensal, Veiculo veiculo, ClientePF cliente) {
        super(ID, dataInicio, dataFim, seguradora, valorMensal);
        this.veiculo = veiculo;
        this.cliente = cliente;
    }

    public Veiculo getVeiculo() {
        return veiculo;
    }

    public void setVeiculo(Veiculo veiculo) {
        this.veiculo = veiculo;
    }

    public ClientePF getCliente() {
        return cliente;
    }

    public void setCliente(ClientePF cliente) {
        this.cliente = cliente;
    }

    public boolean autorizarCondutor(Condutor condutor) {
        if(getListaCondutor().contains(condutor)) {
            System.out.println("Condutor ja autorizado!");
            return false;
        }
        System.out.println("Condutor autorizado com sucesso!");
        this.getListaCondutor().add(condutor);
        return true;
    }

    public boolean desautorizarCondutor(Condutor condutor) {
        if(!getListaCondutor().contains(condutor)) {
            System.out.println("Condutor nao encontrado!");
            return false;
        }
        System.out.println("Condutor desautorizado com sucesso!");
        this.getListaCondutor().remove(condutor);
        return true;
    }

    public double calcularValor(String cpf) {
        double valor, fator = 0;
        Condutor condutor = buscaCondutor(cpf);
        int idade = condutor.calculaIdade();
        if(idade < 30) {
            fator = CalcSeguro.FATOR_18_30.getFator();
        } else if(idade >= 30 & idade < 60) {
            fator = CalcSeguro.FATOR_30_60.getFator();
        } else if(idade >= 60 & idade < 90) {
            fator = CalcSeguro.FATOR_60_90.getFator();
        }
        valor = CalcSeguro.VALOR_BASE.getFator()*fator*(1 + 1/(getCliente().getListaVeiculos().size() + 2))*(2 + getListaSinistro().size()/10)*(5 + condutor.getListaSinistro().size()/10); 
        return valor;
    }

    //Funcao de gerar sinistro
    public boolean gerarSinistro(Veiculo veiculo, Condutor condutor) {
        Sinistro sinistro;
        if(getCliente().getListaVeiculos().contains(veiculo) || getListaCondutor().contains(condutor)) {
            System.out.println("Nao foi possivel gerar sinistro");
            return false;
        }
        System.out.println("Sinistro gerado com sucesso!");
        sinistro = new Sinistro(Sinistro.geraId(getSeguradora()), "21/04/2023", "centro", condutor, this);
        this.getListaSinistro().add(sinistro);
        return true;
    }

}