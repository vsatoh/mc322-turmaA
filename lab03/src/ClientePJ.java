import java.util.*;
import java.util.Date;

public class ClientePJ extends Cliente {
    private String CNPJ;
    private Date dataFundacao;

    public ClientePJ(String nome, String endereco, Date dataLicenca, String educacao, String genero, String classeEconomica, List <Veiculo> listaVeiculos, String CNPJ, Date dataFundacao) {
        super(nome, endereco, dataLicenca, educacao, genero, classeEconomica, listaVeiculos);
        this.CNPJ = CNPJ;
        this.dataFundacao = dataFundacao;
    }
    
    public Date getDataFundacao() {
        return dataFundacao;
    }

    public void setDataFundacao(Date dataFundacao) {
        this.dataFundacao = dataFundacao;
    } 

    public String getCNPJCliente() {
        return CNPJ;
    }

    public void setCNPJCliente(String CNPJ) {
        this.CNPJ = CNPJ;
    } 

    private boolean verificarDigitosVerificadores(String CNPJ) { // confere os digitos verificadores
        int soma = 0;
        int primeiroDigito;
        int segundoDigito;
        boolean resultado;

        for (int i = 0; i < 12; i++) {
            soma += Character.getNumericValue(CNPJ.charAt(i)) * (5 - i);
        }

        primeiroDigito = (soma * 10) % 11;
        if (primeiroDigito == 10) {
            primeiroDigito = 0;
        }

        soma = 0;
        for (int i = 0; i < 10; i++) {
            soma += Character.getNumericValue(cpf.charAt(i)) * (11 - i);
        }

        segundoDigito = (soma * 10) % 11;
        if (segundoDigito == 10) {
            segundoDigito = 0;
        }

        resultado = (primeiroDigito == Character.getNumericValue(cpf.charAt(9)) && segundoDigito == Character.getNumericValue(cpf.charAt(10)));

        return resultado;
    }


    public boolean validarCNPJ(String CNPJ) {
        int tam_cnpj;
        CNPJ = CNPJ.replaceAll("\\.", "");
        CNPJ = CNPJ.replaceAll("\\-", "");
        tam_cnpj = CNPJ.length();

        if (tam_cnpj != 14) {
            return false;
        }

    }
}
