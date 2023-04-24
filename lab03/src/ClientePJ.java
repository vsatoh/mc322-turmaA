import java.util.Date;

public class ClientePJ extends Cliente {
    final private String CNPJ;
    private Date dataFundacao;

    public ClientePJ(String nome, String endereco, String CNPJ, Date dataFundacao) {
        super(nome, endereco);
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

    private static boolean verificarDigitosVerificadores(String CNPJ) { // confere os digitos verificadores
        int soma = 0;
        int resto;
        int primeiroDigito;
        int segundoDigito;
        boolean resultado;

        for (int i = 0; i < 12; i++) {
            soma += Character.getNumericValue(CNPJ.charAt(i)) * (9-(i+4) % 8);
        }

        resto = soma % 11;
        if (resto < 2) {
            primeiroDigito = 0;
        } 
        else {
            primeiroDigito = 11 - resto;
        }

        soma = 0;
        for (int i = 0; i < 13; i++) {
            soma += Character.getNumericValue(CNPJ.charAt(i)) * (9-(i+3) % 8);
        }

        resto = soma % 11;
        if (resto < 2) {
            segundoDigito = 0;
        } 
        else {
            segundoDigito = 11 - resto;
        }

        resultado = (primeiroDigito == Character.getNumericValue(CNPJ.charAt(11)) && segundoDigito == Character.getNumericValue(CNPJ.charAt(12)));

        return resultado;
    }


    public static boolean validarCNPJ(String CNPJ) {
        int tam_cnpj;
        CNPJ = CNPJ.replaceAll("\\.", "");
        CNPJ = CNPJ.replaceAll("\\-", "");
        tam_cnpj = CNPJ.length();

        if (tam_cnpj != 14) {
            return false;
        } else if (verificarDigitosVerificadores(CNPJ)) {
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        String infocliente;
        infocliente = "Nome: " + getNome() + "\n"
        + "Endereco: " + getEndereco() + "\n"
        + "CNPJ: " + getCNPJ() + "\n"
        + "Data de fundacao: " + getDataFundacao() + "\n"
        + "Veiculos: \n" 
        + imprimeVeiculos();
        return infocliente;
   }
}
