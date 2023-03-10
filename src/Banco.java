import java.util.ArrayList;

/*
  Esta é a classe Banco. A classe Sistema possui uma ArrayList de bancos
  e cada banco possui uma ArrayList de agências
*/

public class Banco {
  private ArrayList<Agencia> agencias = new ArrayList<>(); // lista de agências
  private int id; // identificação do banco no sistema. Não pode repetir
  private String nome; // nome do banco
  private String numero; // número do banco (104 Caixa Econômica, 001 Banco do Brasil, etc
  public static int contadorBancos = 0; // auto incremento para o identificador de cada banco
  
  // construtor vazio
  public Banco() {
  
  }

  public Banco(int id, String nome, String numero) {
    this.id = id;
    this.nome = nome;
    this.numero = numero;
  }
  
  // permite obter a lista de agências
  public ArrayList<Agencia> getAgencias() {
    return agencias;
  }

  // define a lista de agências. Raramente usado
  public void setAgencias(ArrayList<Agencia> agencias) {
    this.agencias = agencias;
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

  public String getNumero() {
    return numero;
  }

  public void setNumero(String numero) {
    this.numero = numero;
  }
}
