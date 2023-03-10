import java.util.ArrayList;


public class Conta {
  private Agencia agencia;
  private Pessoa cliente;
  private ArrayList<Transacao> transacoes = new ArrayList<>();
  private int id;
  private String numero;
  private double saldo;
  private double limite;
  public static int contadorContas = 0;

  // construtor vazio
  public Conta() {
  
  }

  public Conta(Agencia agencia, Pessoa cliente, int id, String numero, double saldo, double limite) {
    this.agencia = agencia;
    this.cliente = cliente;
    this.id = id;
    this.numero = numero;
    this.saldo = saldo;
    this.limite = limite;
  }

  public Agencia getAgencia() {
    return agencia;
  }

  public void setAgencia(Agencia agencia) {
    this.agencia = agencia;
  }

  public Pessoa getCliente() {
    return cliente;
  }

  public void setCliente(Pessoa cliente) {
    this.cliente = cliente;
  }

  public ArrayList<Transacao> getTransacoes() {
    return transacoes;
  }

  public void setTransacoes(ArrayList<Transacao> transacoes) {
    this.transacoes = transacoes;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getNumero() {
    return numero;
  }

  public void setNumero(String numero) {
    this.numero = numero;
  }

  public double getSaldo() {
    return saldo;
  }

  public void setSaldo(double saldo) {
    this.saldo = saldo;
  }

  public double getLimite() {
    return limite;
  }

  public void setLimite(double limite) {
    this.limite = limite;
  }  
}
