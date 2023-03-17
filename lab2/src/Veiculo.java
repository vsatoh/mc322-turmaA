public class Veiculo {
    
    private String placa;
    private String marca;
    private String modelo;

    public void CriaVeiculo(String placa, String marca, String modelo) {
        this.placa = placa;
        this.marca = marca;
        this.modelo = modelo;
    }

    public String getPlacaVeiculo() {
        return placa;
    }

    public void setPlacaVeiculo(String placa) {
        this.placa = placa;
    }

    public String getMarcaVeiculo() {
        return marca;
    }

    public void setMarcaVeiculo(String marca) {
        this.marca = marca;
    }

    public String getModeloVeiculo() {
        return modelo;
    }

    public void setModeloVeiculo(String modelo) {
        this.modelo = modelo;
    }

}
