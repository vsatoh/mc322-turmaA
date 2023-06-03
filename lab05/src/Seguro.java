import java.util.*;

public abstract class Seguro {

    final private int ID;
    private Date dataInicio;
    private Date dataFim;
    private Seguradora seguradora;
    private List <Sinistro> listaSinistros = new ArrayList<Sinistro>();
    private List <Condutor> listaCondutor = new ArrayList<Condutor>();
    private int valorMensal;


    public Sinistro(int ID, Date dataInicio, Date dataFim, Seguradora seguradora, int valorMensal) {
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

    public boolean desautorizarCondutor();

    public boolean autorizarCondutor();

    public double calcularValor();
    
    public Sinistro gerarSinistro();
}
