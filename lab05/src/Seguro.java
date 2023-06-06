import java.util.*;

public abstract class Seguro {

    final private int ID;
    private Date dataInicio;
    private Date dataFim;
    private Seguradora seguradora;
    private List <Sinistro> listaSinistros = new ArrayList<Sinistro>();
    private List <Condutor> listaCondutor = new ArrayList<Condutor>();
    private int valorMensal;


    public Seguro(int ID, Date dataInicio, Date dataFim, Seguradora seguradora, int valorMensal) {
        this.ID = ID;
        this.dataInicio = dataInicio;
        this.dataFim = dataFim;
        this.seguradora = seguradora;
        this.valorMensal = valorMensal;
    }

    //getters e setters

    public int getId() {
        return ID;
    }

    public Date getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(Date dataInicio) {
        this.dataInicio = dataInicio;
    }

    public Date getDataFim() {
        return dataFim;
    }

    public void setDataFim(Date dataFim) {
        this.dataFim = dataFim;
    }

    public Seguradora getSeguradora() {
        return seguradora;
    }

    public void setSeguradora(Seguradora seguradora) {
        this.seguradora = seguradora;
    }

    public List <Condutor> getListaCondutor() {
        return listaCondutor;
    }

    public void setListaCondutor(List <Sinistro> listaCondutor) {
        this.listaCondutor = listaCondutor ;
    }

    public List <Sinistro> getListaSinistro() {
        return listaSinistros;
    }

    public void setListaSinistro(List <Sinistro> listaSinistros) {
        this.listaSinistros = listaSinistros ;
    }
    
    public Condutor buscaCondutor(String cpf) {
        for(int i = 0; i < getListaCondutor().size(); i++) {
            if(getListaCondutor().get(i).getCPF().equals(cpf)) {
                return getListaCondutor().get(i);
            }
        }
    }
    public boolean desautorizarCondutor(Condutor condutor);

    public boolean autorizarCondutor(Condutor condutor);

    public double calcularValor();
    
    public Sinistro gerarSinistro();
}