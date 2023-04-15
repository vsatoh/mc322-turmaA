import java.util.*;
public class Seguradora {
    private String nome;
    private String telefone;
    private String email;
    private String endereco;
    private List <Sinistro> listaSinistros = new ArrayList<Sinistro>();
    private List <Cliente> listaClientes = new ArrayList<Cliente>();


     // Funcao construtuora

     public Seguradora(String nome, String telefone, String email, String endereco, List <Sinistro> listaSinistros, List <Cliente> listaClientes) {
          this.nome = nome;
          this.telefone = telefone;
          this.email = email;
          this.endereco = endereco;
          this.listaSinistros = listaSinistros;
          this.listaClientes = listaClientes;
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

     //funcao de printar as variaveis do objeto
     public String toString() {
          String infoSeguradora;
          infoSeguradora = "Nome: " + getNome() + "\n"
          + "Telefone: " + getTelefone() + "\n"
          + "Email: " + getEmail() + "\n"
          + "Endereco: " + getEndereco() + "\n";
          return infoSeguradora;
     }
}