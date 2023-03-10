import java.util.ArrayList;

/*
  Esta é a classe Pessoa. Uma pessoa pode estar associada a uma ou mais
  contas bancárias
*/

public class Pessoa {
  private int id;
  private String nome;
  private int idade;
  private char sexo;
  public static int contadorPessoas = 0;
  public Pessoa() {
  
  }
  
  public Pessoa(int id, String nome, int idade, char sexo) {
    this.id = id;
    this.nome = nome;
    this.idade = idade;
    this.sexo = sexo;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getNome() {
    return nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public int getIdade() {
    return idade;
  }

  public void setIdade(int idade) {
    this.idade = idade;
  }

  public char getSexo() {
    return sexo;
  }

  public void setSexo(char sexo) {
    this.sexo = sexo;
  }
  

  public ArrayList<Conta> getContas(ArrayList<Banco> bancos) {
    ArrayList<Conta> contas = new ArrayList<>();
    
    for(int i = 0; i < bancos.size(); i++){
      Banco banco = bancos.get(i);
      for(int j = 0; j < banco.getAgencias().size(); j++){
        Agencia agencia = banco.getAgencias().get(j);
        for(int x = 0; x < agencia.getContas().size(); x++){
          Conta conta = agencia.getContas().get(x);
          if(conta.getCliente().getId() == this.getId()){
            contas.add(conta);
          }
        }
      }
    }
    
    return contas;
  }
}
