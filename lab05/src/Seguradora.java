import java.util.*;
import java.util.List;
// import java.text.SimpleDateFormat;
// import java.util.Date;
public class Seguradora {
    private String nome;
    private String telefone;
    private String email;
    private String endereco;
    private List <Sinistro> listaSinistros = new ArrayList<Sinistro>();
    private List <Cliente> listaClientes = new ArrayList<Cliente>();
    private List <Integer> listaID = new ArrayList<Integer>();


     // Funcao construtuora

     public Seguradora(String nome, String telefone, String email, String endereco) {
          this.nome = nome;
          this.telefone = telefone;
          this.email = email;
          this.endereco = endereco;
     }

     //getters e setters

     public String getNome() {
          return nome;
     }

     public void setNome(String nome) {
          this.nome = nome;
     }

     public String getTelefone() {
          return telefone;
     }

     public void setTelefone(String telefone) {
          this.telefone = telefone;
     } 
     
     public String getEmail() {
          return email;
     }

     public void setEmail(String email) {
          this.email = email;
     }

     public String getEndereco() {
          return endereco ;
     }
     
     public void setEndereco ( String endereco ) {
          this.endereco = endereco ;
     }

     public List <Sinistro> getlistaSinistros() {
          return listaSinistros;
     }

     public void setlistaSinistros (List <Sinistro> listaSinistros) {
          this.listaSinistros = listaSinistros;
     }

     public List <Cliente> getlistaClientes() {
          return listaClientes;
     }

     public void setlistaClientes (List <Cliente> listaClientes) {
          this.listaClientes = listaClientes;
     }

     public List <Integer> getListaID() {
          return listaID;
     }

     public void setListaID (List <Integer> listaID) {
          this.listaID = listaID;
     }

     //Adiciona ou remove itens da lista

     public void addlistaID(int n) {
          this.listaID.add(n);
     }

     public void removelistaID(int n) {
          this.listaID.remove(n);
     }

     public void addlistaSinistros(Sinistro sinistro) {
          this.listaSinistros.add(sinistro);
     }

     public void removelistaSinistros(Sinistro sinistro) {
          this.listaSinistros.remove(sinistro);
     }

     public void addlistaClientes(ClientePF cliente) {
          this.listaClientes.add(cliente);
     }

     public void addlistaClientes(ClientePJ cliente) {
          this.listaClientes.add(cliente);
     }

     public void removelistaClientes(Cliente cliente) {
          this.listaClientes.remove(cliente);
     }

     public void removelistaClientes(ClientePF cliente) {
          this.listaClientes.remove(cliente);
     }

     public void removelistaClientes(ClientePJ cliente) {
          this.listaClientes.remove(cliente);
     }

     //funcao de printar as variaveis do objeto
     public String toString() {
          String infoSeguradora;
          infoSeguradora = "Nome: " + getNome() + "\n"
          + "Telefone: " + getTelefone() + "\n"
          + "Email: " + getEmail() + "\n"
          + "Endereco: " + getEndereco() + "\n";
          return infoSeguradora;
     }

     //Funcoes de adicionar remover cliente
     public boolean cadastrarCliente(ClientePF cliente) {
          if(!getlistaClientes().contains(cliente)) {
               addlistaClientes(cliente);
               System.out.println("Cliente cadastrado com sucesso!");
               return true;
          }
          System.out.println("Nao foi possivel cadastrar o cliente");
          return false;
     }
     
     public boolean cadastrarCliente(ClientePJ cliente) {
          if(!getlistaClientes().contains(cliente)) {
               addlistaClientes(cliente);
               System.out.println("Cliente cadastrado com sucesso!");
               return true;
          }
          System.out.println("Nao foi possivel cadastrar o cliente");
          return false;
     }

     public boolean removerCliente(ClientePF cliente) {
          if(getlistaClientes().contains(cliente)) {
               removelistaClientes(cliente);
               System.out.println("Cliente removido com sucesso!");
               return true;
          }
          System.out.println("Nao foi possivel remover cliente");
          return false;
     }
     
     public boolean removerCliente(ClientePJ cliente) {
          if(getlistaClientes().contains(cliente)) {
               removelistaClientes(cliente);
               System.out.println("Cliente removido com sucesso!");
               return true;
          }
          System.out.println("Nao foi possivel remover cliente");
          return false;
     }

     public boolean visualizarSinistro(String cliente) {
          for (int i = 0; i < getlistaSinistros().size(); i++) {
               if(getlistaSinistros().get(i).getCliente().getNome().equals(cliente)) {
                    System.out.println(getlistaSinistros().get(i).toString());
                    return true;
               }
          }
          return false;
     }

     public void listarSinistros() {
          for (int i = 0; i < getlistaSinistros().size(); i++) {
               System.out.println(getlistaSinistros().get(i).toString());
          }
     }

     public void listarClientes() {
          for (int i = 0; i < getlistaClientes().size(); i++) {
               System.out.println(getlistaClientes().get(i).toString());
          }
     }

     public int numeroSinistros(Cliente cliente) { //numero de sinistros
          int cont = 0;
          for (int i = 0; i < getlistaSinistros().size(); i++) {
               if(getlistaSinistros().get(i).getCliente().getNome().equals(cliente.getNome())) {
                    cont += 1;
               }
          }
          return cont;
     }

     public double calcularPrecoSeguroCliente(Cliente cliente) {
          int pos = getlistaClientes().indexOf(cliente);
          return cliente.calculaScore()*(1 + numeroSinistros(cliente));
     }

     public double calcularReceita() {
          double soma = 0;
          for(int i = 0; i < getlistaClientes().size(); i++) {
               soma += getlistaClientes().get(i).getValorSeguro();
          }
          return soma/2;
     }
}