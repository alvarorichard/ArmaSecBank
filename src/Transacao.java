import java.util.Date;

/*
  A classe Transacao registra todas as transações ocorridas nas contas
  bancárias, ou seja, os depósitos, saques e transferências. Veja que cada
  conta possui um ArrayList de objetos da classe Transacao
*/

public class Transacao {
  private Conta conta;
  private int id;
  private Date data;
  private String historico;
  private double valor;
  private char letra;
  public static int contadorTransacoes = 0;

  public Transacao() {
  
  }

  public Transacao(Conta conta, int id, Date data, String historico, double valor, char letra) {
    this.conta = conta;
    this.id = id;
    this.data = data;
    this.historico = historico;
    this.valor = valor;
    this.letra = letra;
  }

  public Conta getConta() {
    return conta;
  }

  public void setConta(Conta conta) {
    this.conta = conta;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public Date getData() {
    return data;
  }

  public void setData(Date data) {
    this.data = data;
  }

  public String getHistorico() {
    return historico;
  }

  public void setHistorico(String historico) {
    this.historico = historico;
  }

  public double getValor() {
    return valor;
  }

  public void setValor(double valor) {
    this.valor = valor;
  }

  public char getLetra() {
    return letra;
  }

  public void setLetra(char letra) {
    this.letra = letra;
  }
}
