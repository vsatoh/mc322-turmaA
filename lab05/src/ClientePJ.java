import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import java.util.*;
public class ClientePJ extends Cliente {
    final private String CNPJ;
    private Date dataFundacao;
    private int qntdeFuncionarios;
    private List <Frota> listaFrota = new Arraylist<Frota>();

    public ClientePJ(String nome, String telefone, String endereco, String email, String CNPJ, Date dataFundacao, int qntdeFuncionarios) {
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

    public List <Frota> getListaFrota() {
        return listaFrota
    }

    public void setListaFrota(List <Frota> listaFrota) {
        this.listaFrota = listaFrota;
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

    public boolean getVeiculosPorFrota(Frota frota) {
        if(!getListaFrota().contains(frota)) {
            System.out.println("Nao foi possivel listar os veiculos! - Frota nao encontrada");
            return false;
        }
        System.out.println("Veiculos encontrados na frota: ");
        for(Veiculo veiculo : frota.getListaVeiculos()) {
            System.out.println(veiculo.toString());
        }
        System.out.println("Fim da lista");
        return true;
    }

    public boolean atualizarFrota(String code, Veiculo veiculo) {
        System.out.println("Adicionar (1) ou Remover (2) veiculo?");
        Scanner entrada = new Scanner(System.in);
        String opcao = entrada.nextLine();
        if(opcao.equals("1")) {
            for(Frota frota : getListaFrota()) {
                if(frota.getCode().equals(code)) {
                    return frota.addVeiculo(veiculo);
                }
            }
            System.out.println("Frota nao encontrada");
            return false;
        }
        else if(opcao.equals("2")) {
            for(Frota frota : getListaFrota()) {
                if(frota.getCode().equals(code)) {   
                    return frota.removeVeiculo(veiculo);
                }
            }
            System.out.println("Frota nao encontrada");
            return false;
        }
        System.out.println("Opcao invalida");
        return false;
    }

    public boolean atualizarFrota(String code) {
        for(int i = 0; i < getListaFrota().size(); i++) {
            if(getListaFrota().get(i).getCode().equals(code)) {
                getListaFrota().remove(i);
                System.out.println("frota removida com sucesso!");
                return true;
            }
        }
        System.out.println("Frota nao encontrada");
        return false;
    }


    @Override
    public String toString() {
        String infocliente;
        infocliente = "Nome: " + getNome() + "\n"
        + "Telefone: " + getTelefone() + "\n"
        + "Endereço: " + getEndereco() + "\n"
        + "Email: " + getEmail() + "\n"
        + "CNPJ: " + getCNPJ() + "\n"
        + "Data de fundacao: " + getDataFundacao() + "\n"
        + "Frota: " + getListaFrota();
        return infocliente;
   }
}
