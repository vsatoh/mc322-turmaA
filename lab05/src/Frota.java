import java.util.List;
import java.util.*;

public class Frota {

    private String code;
    private List <Veiculo> listaVeiculos = new ArrayList<Veiculo>();

    public Frota(String code) {
        this.code = code;
    }

    public String getCode() {
        return this.code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public List <Veiculo> getListaVeiculos() {
        return listaVeiculos;
    }

    public void setListaVeiculos(List <Veiculo> listaVeiculos) {
        this.listaVeiculos = listaVeiculos ;
    }

    public boolean addVeiculo(Veiculo veiculo) {
        //verificar se o carro existe
        //verificar se o carro ja esta na lista
        if(getListaVeiculos().contains(veiculo)) {
            System.out.println("Veiculo ja cadastrado");
            return false;
        }
        this.listaVeiculos.add(veiculo);
        System.out.println("Veiculo cadastrado com sucesso");
        return true
    }

    public boolean removeVeiculo(Veiculo veiculo) {
        if(!getListaVeiculos().contains(veiculo)) {
            System.out.println("Veiculo nao encontrado");
            return false;
        }
        this.listaVeiculos.remove(veiculo);
        System.out.println("Veiculo removido com sucesso");
        return true;
    }
}
