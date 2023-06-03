import java.sql.Date;

public class Validacao {

    //Valida cpf
    private static boolean ehIgual(String str, int tamanho_str, int pos_str) { // verifica se todos os digitos sao iguais
        if(pos_str + 1 == tamanho_str) {
            return true;
        }
        else if(str.charAt(pos_str) != str.charAt(pos_str+1)) {
            return false;
        }
        return ehIgual(str, tamanho_str, pos_str+1);
    }

    private static boolean verificarDigitosVerificadoresCPF(String cpf) { // confere os digitos verificadores
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
        else if (!verificarDigitosVerificadoresCPF(cpf)) {
            return false;
        }
        return true;
    }

    //Valida cnpj
    private static boolean verificarDigitosVerificadoresCNPJ(String CNPJ) { // confere os digitos verificadores
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
        CNPJ = CNPJ.replaceAll("\\/", "");
        tam_cnpj = CNPJ.length();

        if (tam_cnpj != 14) {
            return false;
        } else if (verificarDigitosVerificadoresCNPJ(CNPJ)) {
            return true;
        }
        return false;
    }

    //Validar nome
    public static boolean validarNome(String nome) {
        if(nome.length() == 0)
            return false;

        for (char ch: nome.toCharArray()) {
            if(!Character.isLetter(ch))
                return false;
        }
        return true;
    }

    public static boolean validarData(Date data) {
        int dia = data.getDate(),
        mes = data.getMonth()+1,
        ano = data.getYear() + 1900;
        if(dia < 1 || dia >= 31) {
            return false;
        }
        if(mes < 1 || mes > 12) {
            return false;
        }
        if(ano < 0) {
            return false;
        }
        return true;
    }
}
