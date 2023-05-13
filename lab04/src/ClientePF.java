import java.util.Date;

public class ClientePF extends Cliente {
    final private String cpf;
    private String genero;
    private Date dataLicenca;
    private String educacao;
    private Date dataNascimento;
    private String classeEconomica;

    public ClientePF(String nome, String endereco, Date dataLicenca, String educacao, String genero, String classeEconomica, String cpf, Date dataNascimento) {
        super(nome, endereco);
        this.dataLicenca = dataLicenca;
        this.educacao = educacao;
        this.genero = genero;
        this.classeEconomica = classeEconomica;
        this.cpf = cpf;
        this.dataNascimento = dataNascimento;
    }
    
    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    } 

    public String getCPF() {
        return cpf;
    }

    public Date getDataLicenca() {
        return dataLicenca;
    }

    public void setDataLicenca(Date dataLicenca) {
        this.dataLicenca = dataLicenca;
    } 

    public String getEducacao() {
        return educacao ;
    }
    
    public void setEducacao(String educacao) {
        this.educacao = educacao ;
    }

    public String getGenero() {
        return genero;
    }
    
    public void setGenero(String genero) {
        this.genero = genero ;
    }

    public String getClasseEconomica() {
        return classeEconomica;
    }
    
    public void setGeneroClasseEconomica(String classeEconomica) {
        this.classeEconomica = classeEconomica ;
    }

    private static boolean ehIgual(String str, int tamanho_str, int pos_str) { // verifica se todos os digitos sao iguais
        if(pos_str + 1 == tamanho_str) {
            return true;
        }
        else if(str.charAt(pos_str) != str.charAt(pos_str+1)) {
            return false;
        }
        return ehIgual(str, tamanho_str, pos_str+1);
    }

    private static boolean verificarDigitosVerificadores(String cpf) { // confere os digitos verificadores
        int soma = 0;
        int primeiroDigito;
        int segundoDigito;
        boolean resultado;

        for (int i = 0; i < 9; i++) {
            soma += Character.getNumericValue(cpf.charAt(i)) * (10 - i);
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

    public static boolean validarCPF(String cpf) { // funcao validar cpf
        int tam_cpf;
        cpf = cpf.replaceAll("\\.", "");
        cpf = cpf.replaceAll("\\-", "");
        tam_cpf = cpf.length();
        if (tam_cpf != 11) {
            return false;
        }
        else if (ehIgual(cpf, tam_cpf, 0)) {
            return false;
        } 
        else if (!verificarDigitosVerificadores(cpf)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        String infocliente;
        infocliente = "Nome: " + getNome() + "\n"
        + "Endereco: " + getEndereco() + "\n"
        + "Data Licenca: " + getDataLicenca() + "\n"
        + "Educacao: " + getEducacao() + "\n"
        + "Genero: " + getGenero() + "\n"
        + "Classe Economica: " + getClasseEconomica()+ "\n"
        + "CPF: " + getCPF() + "\n"
        + "Data de nascimento: " + getDataNascimento() + "\n"
        + "Veiculos: \n" 
        + imprimeVeiculos();
        return infocliente;
   }
}
