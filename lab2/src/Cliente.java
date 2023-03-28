public class Cliente {

    private String nome;
    private String cpf;
    private String dataNascimento;
    private int idade;
    private String endereco;

    // Funcao construtuora

    public Cliente(String nome, String cpf, String dataNascimento, int idade, String endereco) {
        this.nome = nome;
        this.cpf = cpf;
        this.dataNascimento = dataNascimento;
        this.idade = idade;
        this.endereco = endereco;
    }

    //getters e setters

    public String getNomeCliente() {
        return nome;
    }

    public void setNomeCliente(String nome) {
        this.nome = nome;
    }

    public String getDataNascimentoCliente() {
        return dataNascimento;
    }

    public void setDataNascimentoCliente(String dataNascimento) {
        this.dataNascimento = dataNascimento;
    } 
    
    public String getCpfCliente() {
        return cpf;
    }

    public void setCpfCliente(String cpf) {
        this.cpf = cpf;
    } 

    public int getIdadeCliente() {
        return idade;
    }

    public void setIdadeCliente(int idade) {
        this.idade = idade;
    }

    public String getEnderecoCliente() {
        return endereco ;
    }
    
    public void setEnderecoCliente(String endereco) {
        this.endereco = endereco ;
    }

    public void printCliente() { //printa as infos do cliente
        System.out.println("Nome: " + getNomeCliente());
        System.out.println("CPF: " + getCpfCliente());
        System.out.println("Data de Nascimento: " + getDataNascimentoCliente());
        System.out.println("Idade: " + getIdadeCliente());
        System.out.println("Endereco: " + getEnderecoCliente());
    }


    private boolean ehIgual(String str, int tamanho_str, int pos_str) { // verifica se todos os digitos sao iguais
        if(pos_str + 1 == tamanho_str) {
            return true;
        }
        else if(str.charAt(pos_str) != str.charAt(pos_str+1)) {
            return false;
        }
        return ehIgual(str, tamanho_str, pos_str+1);
    }

    private boolean verificarDigitosVerificadores(String cpf) { // confere os digitos verificadores
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

    public boolean validarCPF(String cpf) { // funcao validar cpf
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
}