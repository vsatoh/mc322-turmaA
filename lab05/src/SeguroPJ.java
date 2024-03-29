import java.util.Date;

public class SeguroPJ extends Seguro {
    private Frota frota;
    private ClientePJ cliente;

    public SeguroPF(int ID, Date dataInicio, Date dataFim, Seguradora seguradora, int valorMensal, Frota frota, ClientePJ cliente) {
        super(ID, dataInicio, dataFim, seguradora, valorMensal);
        this.frota = frota;
        this.cliente = cliente;
    }

    public Frota getFrota() {
        return frota;
    }

    public void setFrota(Frota frota) {
        this.frota = frota;
    }

    public ClientePJ getCliente() {
        return cliente;
    }

    public void setCliente(ClientePJ cliente) {
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
        int anosPosFundacao = getCliente().calculaIdade();
        valor = CalcSeguro.VALOR_BASE.getFator()*(10 + getCliente().getQntdeFuncionarios()/10)*(1 + 1/(anosPosFundacao + 2))*(1 + 1/(getCliente().getListaVeiculos().size() + 2))*(2 + getListaSinistro().size()/10)*(5 + condutor.getListaSinistro().size()/10); 
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
