import java.text.Format;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;



public class Sistema {
  private ArrayList<Pessoa> pessoas = new ArrayList<>();
  private ArrayList<Banco> bancos = new ArrayList<>();

  String vinho = "\u001B[31m"; // Código de escape ANSI para cor vermelha
  String reset = "\u001B[0m"; 

  Scanner entrada = new Scanner(System.in);

  public static void main(String[] args) {
    Sistema s = new Sistema();
    s.menuPrincipal();
  }

  public void menuPrincipal() {
    while (true) {
      limparTela();

      System.out.println(vinho+"                                 _____           ____              _    \n" + //
          "     /\\                         / ____|         |  _ \\            | |   \n" + //
          "    /  \\   _ __ _ __ ___   __ _| (___   ___  ___| |_) | __ _ _ __ | | __\n" + //
          "   / /\\ \\ | '__| '_ ` _ \\ / _` |\\___ \\ / _ \\/ __|  _ < / _` | '_ \\| |/ /\n" + //
          "  / ____ \\| |  | | | | | | (_| |____) |  __/ (__| |_) | (_| | | | |   < \n" + //
          " /_/    \\_\\_|  |_| |_| |_|\\__,_|_____/ \\___|\\___|____/ \\__,_|_| |_|_|\\_\\"+reset+"\n\n");

      System.out.println("Bem-vindo(a) ao ArmaSecBank. Escolha a opção desejada");
      System.out.println(vinho+"1 -"+reset+" Administrar o Sistema");
      System.out.println(vinho+"2 -"+reset+" Acessar como Cliente");
      System.out.println(vinho+"3 -"+reset+" Sair");
      System.out.print("Sua opção: ");
      int opcao = Integer.parseInt(entrada.nextLine());

      switch (opcao) {
        case 1:
          menuAdministrarSistema();
          break;
        case 2:
          menuCliente();
          break;
        case 3:
          String artFim ="                          - -                 _                    _                        \n" +
                  "                         | | |               (_)                  | |                       \n" +
                  "   ___ _   _  __   _____ | | |_ __ _ _ __ ___ _    ___ _ __ ___   | |__  _ __ _____   _____ \n" +
                  "  / _ \\ | | | \\ \\ / / _ \\| | __/ _` | '__/ _ \\ |  / _ \\ '_ ` _ \\  | '_ \\| '__/ _ \\ \\ / / _ \\\n" +
                  " |  __/ |_| |  \\ V / (_) | | || (_| | | |  __/ | |  __/ | | | | | | |_) | | |  __/\\ V /  __/\n" +
                  "  \\___|\\__,_|   \\_/ \\___/|_|\\__\\__,_|_|  \\___|_|  \\___|_| |_| |_| |_.__/|_|  \\___| \\_/ \\___|" ;
          System.out.println(vinho+artFim+reset+"\n\n");

          System.exit(0);
      }
    }
  }

  public void menuAdministrarSistema() {
    int numTentativas = 0;
    long tempoUltimoErro = 0;

    Autenticacao autenticacao = new Autenticacao("admin", "admin");

    while (true) {
      limparTela();
      System.out.println(vinho+"\n:: L O G I N ::\n"+reset);
      System.out.print("Usuário: ");
      String usuario = entrada.nextLine();
      System.out.print("Senha: ");
      String senha = entrada.nextLine();

      if (autenticacao.verificaCredenciais(usuario, senha)) {
        break;
      } else {
        numTentativas++;
        if (numTentativas == 2) {
          long tempoAtual = System.currentTimeMillis();
          if (tempoAtual < tempoUltimoErro + 30000) {
            System.out.println("Você excedeu o número de tentativas. Tente novamente mais tarde.");
            try {
              Thread.sleep(tempoUltimoErro + 30000 - tempoAtual);
            } catch (InterruptedException ex) {
              Thread.currentThread().interrupt();
            }
            numTentativas = 0;
            tempoUltimoErro = System.currentTimeMillis();
            continue;
          } else {
            numTentativas = 0;
            tempoUltimoErro = System.currentTimeMillis();
          }
        }
        System.out.println("Usuário ou senha inválidos. Tente novamente.");
      }
    }

    while (true) {
      limparTela();

      System.out.println(vinho+"              _           _       \n" +
          "     /\\      | |         (_)      \n"+
          "    /  \\   _ __ _ __ ___   __ ___ \n" +
          "   / /\\ \\ / _` | '_ ` _ \\| | '_  \\\n" +
          "  / ____ \\ (_| | | | | | | | | | |\n" +
          " /_/    \\_\\__,_|_| |_| |_|_|_| |_|"+reset+"\n\n");
      System.out.println("Bem-vindo(a) ao ArmaSecBank. Escolha a opção desejada");


      System.out.println(vinho+"1 -"+reset+" Gerenciar Bancos");
      System.out.println(vinho+"2 -"+reset+" Gerenciar Pessoas");
      System.out.println(vinho+"3 -"+reset+" Gerenciar Agências");
      System.out.println(vinho+"4 -"+reset+" Gerenciar Contas");
      System.out.println(vinho+"5 -"+reset+" Voltar Menu Anterior");
      System.out.print("Sua opção: ");
      int opcao = Integer.parseInt(entrada.nextLine());

      switch (opcao) {
        case 1:
          menuGerenciarBancos();
          break;
        case 2:
          menuGerenciarPessoas();
          break;
        case 3:
          menuGerenciarAgencias();
          break;
        case 4:
          menuGerenciarContas();
          break;
        case 5:
          return;
        default:
          System.out.println("Opção inválida. Tente novamente.");
      }
    }
  }

  
  public int menuGerenciarBancos(){
    Banco temp;
    String pesquisaBanco;
    
    while(true){
      limparTela();
      System.out.println(vinho+"\n:: G E R E N C I A R   B A N C O S ::\n"+reset);
      System.out.println("Escolha a opção desejada");
      System.out.println(vinho+"1 -"+reset+" Novo Banco");
      System.out.println(vinho+"2 -"+reset+" Listar Bancos");
      System.out.println(vinho+"3 -"+reset+" Pesquisar Banco");
      System.out.println(vinho+"4 -"+reset+" Excluir Banco");
      System.out.println(vinho+"5 -"+reset+" Atualizar Banco");
      System.out.println(vinho+"6 -"+reset+" Voltar Menu Anterior");
      System.out.print("Sua opção: ");
      int opcao = Integer.parseInt(entrada.nextLine());
    
      switch(opcao){
        case 1:
          System.out.print("\nNúmero do Banco: ");
          String numeroBanco = entrada.nextLine();
          System.out.print("Nome do Banco: ");
          String nomeBanco = entrada.nextLine();
        
          Banco.contadorBancos++;
        
          Banco b = new Banco(Banco.contadorBancos, nomeBanco, numeroBanco);
          bancos.add(b);
        
          System.out.println("\nO banco foi criado com sucesso");
        
          break;  
        
        case 2:
          if(bancos.isEmpty()){
            System.out.println("\nNão há nenhum banco cadastrado.");  
          }
          else{
            for(int i = 0; i < bancos.size(); i++){
              temp = bancos.get(i);
              System.out.println("\nId: " + temp.getId());
              System.out.println("Número: " + temp.getNumero());
              System.out.println("Nome: " + temp.getNome());
              System.out.println("Quant Agências: " + temp.getAgencias().size());
            }  
          }
          
          break;
        
        case 3:
          System.out.print("\nInforme o id, número ou nome do Banco: ");
          pesquisaBanco = entrada.nextLine();

          temp = pesquisarBanco(pesquisaBanco);
          if(temp == null){
            System.out.println("\nO banco não foi encontrado.");  
          }
          else{

            System.out.println("\nId: " + temp.getId());
            System.out.println("Número: " + temp.getNumero());
            System.out.println("Nome: " + temp.getNome());
            System.out.println("Quant Agências: " + temp.getAgencias().size());
          }
        
          break;    
          
        case 4:
          System.out.print("\nInforme o id, número ou nome do Banco a ser excluído: ");
          pesquisaBanco = entrada.nextLine();

          temp = pesquisarBanco(pesquisaBanco);
          if(temp == null){
            System.out.println("\nO banco não foi encontrado.");  
          }
          else{

            bancos.remove(temp);
            System.out.println("\nBanco excluído com sucesso.");
          }
        
          break;  
          
        case 5:
          System.out.print("\nInforme o id, número ou nome do Banco a ser atualizado: ");
          pesquisaBanco = entrada.nextLine();
          temp = pesquisarBanco(pesquisaBanco);
          if(temp == null){
            System.out.println("\nO banco não foi encontrado.");  
          }
          else{
            System.out.println("\nDados atuais deste banco:");
            System.out.println("\nId: " + temp.getId());
            System.out.println("Número: " + temp.getNumero());
            System.out.println("Nome: " + temp.getNome());
            System.out.println("Quant Agências: " + temp.getAgencias().size());
            
            System.out.println("\nInforme os novos dados:");
            System.out.print("\nNovo Número do Banco: ");
            String novoNumeroBanco = entrada.nextLine();
            System.out.print("Novo Nome do Banco: ");
            String novoNomeBanco = entrada.nextLine();
            
            temp.setNome(novoNomeBanco);
            temp.setNumero(novoNumeroBanco);
            System.out.println("\nBanco atualizado com sucesso.");
          }
        
          break;  
          
        case 6:
          return 0;
      }
    }
  }
  
  public Banco pesquisarBanco(String pesquisaBanco){
    Banco b = null;
    
    for(int i = 0; i < bancos.size(); i++){
      if(Integer.toString(bancos.get(i).getId()).equals(pesquisaBanco)){
        return bancos.get(i);  
      }
      else if(bancos.get(i).getNome().contains(pesquisaBanco)){
        return bancos.get(i);  
      }
      else if(bancos.get(i).getNumero().contains(pesquisaBanco)){
        return bancos.get(i);  
      }
    }
    
    return b;
  }
  
  public int menuGerenciarPessoas(){
    Pessoa temp;
    String pesquisaPessoa;
    
    while(true){
      limparTela();
      System.out.println(vinho+"\n:: G E R E N C I A R   P E S S O A S ::\n"+reset);
      System.out.println("Escolha a opção desejada");
      System.out.println(vinho+"1 -"+reset+" Nova Pessoa (Futuro Cliente)");
      System.out.println(vinho+"2 -"+reset+" Listar Pessoas");
      System.out.println(vinho+"3 -"+reset+" Pesquisar Pessoa");
      System.out.println(vinho+"4 -"+reset+" Excluir Pessoa");
      System.out.println(vinho+"5 -"+reset+" Atualizar Pessoa");
      System.out.println(vinho+"6 -"+reset+" Voltar Menu Anterior");
      System.out.print("Sua opção: ");
      int opcao = Integer.parseInt(entrada.nextLine());
    
      switch(opcao){
        case 1:
          System.out.print("\nNome: ");
          String nomePessoa = entrada.nextLine();
          System.out.print("Idade: ");
          int idadePessoa = Integer.parseInt(entrada.nextLine());
          System.out.print("Sexo: ");
          char sexoPessoa = entrada.nextLine().charAt(0);
        

          Pessoa.contadorPessoas++;
        
          Pessoa p = new Pessoa(Pessoa.contadorPessoas, nomePessoa, idadePessoa, sexoPessoa);
          pessoas.add(p);
        
          System.out.println("\nA pessoa foi criada com sucesso");
        
          break;  
        
        case 2:
          if(pessoas.isEmpty()){
            System.out.println("\nNão há nenhuma pessoa cadastrada.");  
          }
          else{
            for(int i = 0; i < pessoas.size(); i++){
              temp = pessoas.get(i); // obtém a pessoa da iteração atual
              System.out.println("\nId: " + temp.getId());
              System.out.println("Nome: " + temp.getNome());
              System.out.println("Idade: " + temp.getIdade());
              System.out.println("Sexo: " + temp.getSexo());
              System.out.println("Quant Contas Bancárias: " + temp.getContas(bancos).size());
            }  
          }
          break;
        
        case 3:
          System.out.print("\nInforme o id ou nome da pessoa: ");
          pesquisaPessoa = entrada.nextLine();
          temp = pesquisarPessoa(pesquisaPessoa);
          if(temp == null){ // pessoa não encotrado
            System.out.println("\nA pessoa não foi encontrada.");  
          }
          else{
            System.out.println("\nId: " + temp.getId());
            System.out.println("Nome: " + temp.getNome());
            System.out.println("Idade: " + temp.getIdade());
            System.out.println("Sexo: " + temp.getSexo());
            System.out.println("Quant Contas Bancárias: " + temp.getContas(bancos).size());
          }
        
          break;    
          
        case 4: // vamos excluir uma pessoa
          System.out.print("\nInforme o id ou nome da pessoa a ser excluída: ");
          pesquisaPessoa = entrada.nextLine();
          // chamamos o método que pesquisa a pessoa
          temp = pesquisarPessoa(pesquisaPessoa);
          if(temp == null){ // pessoa não encontrada
            System.out.println("\nA pessoa não foi encontrada.");  
          }
          else{

            if(temp.getContas(bancos).size() > 0){
              System.out.println("\nOps! Esta pessoa possui contas bancárias. Exclua as contas primeiro.");  
            }
            else{
              pessoas.remove(temp);
              System.out.println("\nPessoa excluída com sucesso.");
            }
          }
        
          break;  
          
        case 5:
          System.out.print("\nInforme o id ou nome da pessoa a ser atualizada: ");
          pesquisaPessoa = entrada.nextLine();
          temp = pesquisarPessoa(pesquisaPessoa);
          if(temp == null){
            System.out.println("\nA pessoa não foi encontrada.");  
          }
          else{
            System.out.println("\nDados atuais desta pessoa:");
            System.out.println("\nId: " + temp.getId());
            System.out.println("Nome: " + temp.getNome());
            System.out.println("Idade: " + temp.getIdade());
            System.out.println("Sexo: " + temp.getSexo());
            System.out.println("Quant Contas Bancárias: " + temp.getContas(bancos).size());
            
            System.out.println("\nInforme os novos dados:");
            System.out.print("\nNovo Nome: ");
            String novoNomePessoa = entrada.nextLine();
            System.out.print("Nova Idade: ");
            int novaIdadePessoa = Integer.parseInt(entrada.nextLine());
            System.out.print("Novo Sexo: ");
            char novoSexoPessoa = entrada.nextLine().charAt(0);
            
            temp.setNome(novoNomePessoa);
            temp.setIdade(novaIdadePessoa);
            temp.setSexo(novoSexoPessoa);
            System.out.println("\nPessoa atualizada com sucesso.");
          }
        
          break;  
          
        case 6:
          return 0;
      }
    }
  }
  
  public Pessoa pesquisarPessoa(String pesquisaPessoa){
    Pessoa p = null;
    
    for(int i = 0; i < pessoas.size(); i++){
      if(Integer.toString(pessoas.get(i).getId()).equals(pesquisaPessoa)){
        return pessoas.get(i);  
      }
      else if(pessoas.get(i).getNome().contains(pesquisaPessoa)){
        return pessoas.get(i);  
      }
    }
    
    return p;
  }
  
  public int menuGerenciarAgencias(){
    Agencia temp;
    String pesquisaAgencia;
    Banco bancoAtual = null;
    
    while(bancoAtual == null){
      System.out.print("\nInforme o id, número ou nome do banco: ");
      String pesquisaBanco = entrada.nextLine();
      Banco b = pesquisarBanco(pesquisaBanco);
      if(b == null){ // banco não encotrado
        System.out.print("\nO banco não foi encontrado.\n\nDigite 1 para pesquisar novamente ou 2 para voltar ao menu anterior: ");
        int opcao = Integer.parseInt(entrada.nextLine());
        if(opcao == 2){
          return 1;
        }
      }
      else{
        bancoAtual = b;
      }
    }
    

    while(true){
      limparTela();
      System.out.println(vinho+"\n:: G E R E N C I A R   A G Ê N C I A S ::\n"+reset);
      System.out.println("Banco selecionado: " + bancoAtual.getNome() + "\n");
      
      System.out.println("Escolha a opção desejada");
      System.out.println(vinho+"1 -"+reset+" Nova Agência");
      System.out.println(vinho+"2 -"+reset+" Listar Agências");
      System.out.println(vinho+"3 -"+reset+" Pesquisar Agência");
      System.out.println(vinho+"4 -"+reset+" Excluir Agência");
      System.out.println(vinho+"5 -"+reset+" Atualizar Agência");
      System.out.println(vinho+"6 -"+reset+" Voltar Menu Anterior");
      System.out.print("Sua opção: ");
      int opcao = Integer.parseInt(entrada.nextLine());
    
      switch(opcao){
        case 1:
          System.out.print("\nNúmero da Agência: ");
          String numeroAgencia = entrada.nextLine();
          System.out.print("Cidade/Estado da Agência: ");
          String cidadeAgencia = entrada.nextLine();
        

          Agencia.contadorAgencias++;
        

          Agencia a = new Agencia(bancoAtual, Agencia.contadorAgencias, numeroAgencia, cidadeAgencia);

          bancoAtual.getAgencias().add(a);
        

          System.out.println("\nA Agência foi criada com sucesso");
        
          break;  
          
        case 2:
          if(bancoAtual.getAgencias().isEmpty()){
            System.out.println("\nNão há nenhuma agência cadastrada neste banco.");  
          }
          else{
            for(int i = 0; i < bancoAtual.getAgencias().size(); i++){
              temp = bancoAtual.getAgencias().get(i);
              System.out.println("\nId: " + temp.getId());
              System.out.println("Número: " + temp.getNumero());
              System.out.println("Cidade/Estado: " + temp.getCidade());
              System.out.println("Quant Contas Bancárias: " + temp.getContas().size());
            }  
          }
          
          break;
          
        case 3: // vamos pesquisar uma agência
          System.out.print("\nInforme o id, número ou cidade da agência: ");
          pesquisaAgencia = entrada.nextLine();

          temp = pesquisarAgencia(bancoAtual, pesquisaAgencia);
          if(temp == null){ // agência não encotrada
            System.out.println("\nA agência não foi encontrada.");  
          }
          else{

            System.out.println("\nId: " + temp.getId());
            System.out.println("Número: " + temp.getNumero());
            System.out.println("Cidade/Estado: " + temp.getCidade());
            System.out.println("Quant Contas Bancárias: " + temp.getContas().size());
          }
        
          break;    
        
        case 4:
          System.out.print("\nInforme o id, número ou cidade da agência: ");
          pesquisaAgencia = entrada.nextLine();

          temp = pesquisarAgencia(bancoAtual, pesquisaAgencia);
          if(temp == null){
            System.out.println("\nA agência não foi encontrada.");  
          }
          else{

            bancoAtual.getAgencias().remove(temp);
            System.out.println("\nAgência excluída com sucesso.");
          }
        
          break;  
          
        case 5:
          System.out.print("\nInforme o id, número ou cidade da agência: ");
          pesquisaAgencia = entrada.nextLine();
          temp = pesquisarAgencia(bancoAtual, pesquisaAgencia);
          if(temp == null){
            System.out.println("\nA agência não foi encontrada.");  
          }
          else{
            System.out.println("\nDados atuais desta agência:");
            System.out.println("\nId: " + temp.getId());
            System.out.println("Número: " + temp.getNumero());
            System.out.println("Cidade/Estado: " + temp.getCidade());
            System.out.println("Quant Contas Bancárias: " + temp.getContas().size());
            
            System.out.println("\nInforme os novos dados:");
            System.out.print("\nNovo Número da Agência: ");
            String novoNumeroAgencia = entrada.nextLine();
            System.out.print("Nova Cidade/Estado da Agência: ");
            String novaCidadeAgencia = entrada.nextLine();
            
            temp.setNumero(novoNumeroAgencia);
            temp.setCidade(novaCidadeAgencia);
            System.out.println("\nAgência atualizada com sucesso.");
          }
        
          break;
          
        case 6:
          return 0;
      }
    }
  }
  
  public Agencia pesquisarAgencia(Banco b, String pesquisaAgencia){
    Agencia a = null;
    

    for(int i = 0; i < b.getAgencias().size(); i++){

      if(Integer.toString(b.getAgencias().get(i).getId()).equals(pesquisaAgencia)){
        return b.getAgencias().get(i);  
      }
      else if(b.getAgencias().get(i).getNumero().contains(pesquisaAgencia)){
        return b.getAgencias().get(i);  
      }

      else if(b.getAgencias().get(i).getCidade().contains(pesquisaAgencia)){
        return b.getAgencias().get(i);  
      }
    }
    
    return a;
  }
  
  public int menuGerenciarContas(){
    Conta temp;
    String pesquisaConta;
    Banco bancoAtual = null;
    Agencia agenciaAtual = null;
    
    while(bancoAtual == null){
      System.out.print("\nInforme o id, número ou nome do banco: ");
      String pesquisaBanco = entrada.nextLine();
      Banco b = pesquisarBanco(pesquisaBanco);
      if(b == null){
        System.out.print("\nO banco não foi encontrado.\n\nDigite 1 para pesquisar novamente ou 2 para voltar ao menu anterior: ");
        int opcao = Integer.parseInt(entrada.nextLine());
        if(opcao == 2){
          return 1;
        }
      }
      else{

        bancoAtual = b;
      }
    }
    
    while(agenciaAtual == null){
      System.out.print("\nInforme o id, número ou cidade da agência: ");
      String pesquisaAgencia = entrada.nextLine();
      Agencia a = pesquisarAgencia(bancoAtual, pesquisaAgencia);
      if(a == null){
        System.out.print("\nA Agência não foi encontrada.\n\nDigite 1 para pesquisar novamente ou 2 para voltar ao menu anterior: ");
        int opcao = Integer.parseInt(entrada.nextLine());
        if(opcao == 2){
          return 1;
        }
      }
      else{
        agenciaAtual = a;
      }
    }
    

    while(true){
      limparTela();
      System.out.println(vinho+"\n:: G E R E N C I A R   C O N T A S ::\n"+reset);
      System.out.println("Banco selecionado: " + bancoAtual.getNome());
      System.out.println("Agência selecionada: " + agenciaAtual.getNumero() + " - " + agenciaAtual.getCidade() + "\n");
      
      System.out.println("Escolha a opção desejada");
      System.out.println(vinho+"1 -"+reset+" Abertura de Nova Conta");
      System.out.println(vinho+"2 -"+reset+" Listar Contas");
      System.out.println(vinho+"3 -"+reset+" Pesquisar Conta");
      System.out.println(vinho+"4 -"+reset+" Excluir Conta");
      System.out.println(vinho+"5 -"+reset+" Atualizar Conta");
      System.out.println(vinho+"6 -"+reset+" Voltar Menu Anterior");
      System.out.print("Sua opção: ");
      int opcao = Integer.parseInt(entrada.nextLine()); // lê a opção do usuário
    
      switch(opcao){
        case 1:
          System.out.print("\nNúmero da Conta: ");
          String numeroConta = entrada.nextLine();
          System.out.print("Limite da Conta: ");
          double limiteConta = Double.parseDouble(entrada.nextLine());
          

          Pessoa cliente = null;
          while(cliente == null){
            System.out.print("Informe o id ou nome do cliente: ");
            String pesquisaPessoa = entrada.nextLine();
            cliente = pesquisarPessoa(pesquisaPessoa);
            if(cliente == null){
              System.out.print("\nCliente não encontrado.\n\nDigite 1 para pesquisar novamente ou 2 para voltar ao menu anterior: ");
              int opcaoTemp = Integer.parseInt(entrada.nextLine());
              if(opcaoTemp == 2){
                return 1;
              }
            }
          }
        
          Conta.contadorContas++;
        
          Conta c = new Conta(agenciaAtual, cliente,  Conta.contadorContas, numeroConta, 0.0, limiteConta);
          agenciaAtual.getContas().add(c);
          
          System.out.println("\nUma nova conta foi criada para o cliente: " + cliente.getNome()
            + "\ncom saldo inicial de R$ 0,00 e limite inicial de R$ " + limiteConta);
        
          break;  
        
        case 2:
          if(agenciaAtual.getContas().isEmpty()){
            System.out.println("\nNão há nenhuma conta cadastrada nesta agência.");  
          }
          else{
            for(int i = 0; i < agenciaAtual.getContas().size(); i++){
              temp = agenciaAtual.getContas().get(i);
              System.out.println("\nId da conta bancária: " + temp.getId());
              System.out.println("Número da conta: " + temp.getNumero());
              System.out.println("Cliente: " + temp.getCliente().getNome());
              System.out.println("Agência: " + agenciaAtual.getNumero() + " - " + agenciaAtual.getCidade());
              System.out.println("Banco: " + bancoAtual.getNumero() + " - " + bancoAtual.getNome());
              System.out.println("Saldo atual: " + temp.getSaldo());
              System.out.println("Limite atual: " + temp.getLimite());
            }  
          }
          
          break;
        
        case 3:
          System.out.print("\nInforme o id, número ou nome do cliente da conta: ");
          pesquisaConta = entrada.nextLine();
          temp = pesquisarConta(agenciaAtual, pesquisaConta);
          if(temp == null){
            System.out.println("\nA conta não foi encontrada nesta agência.");  
          }
          else{
            System.out.println("\nId da conta bancária: " + temp.getId());
            System.out.println("Número da conta: " + temp.getNumero());
            System.out.println("Cliente: " + temp.getCliente().getNome());
            System.out.println("Agência: " + agenciaAtual.getNumero() + " - " + agenciaAtual.getCidade());
            System.out.println("Banco: " + bancoAtual.getNumero() + " - " + bancoAtual.getNome());
            System.out.println("Saldo atual: " + temp.getSaldo());
            System.out.println("Limite atual: " + temp.getLimite());
          }
        
          break;    
        
        case 4:
          System.out.print("\nInforme o id, número ou nome do cliente da conta: ");
          pesquisaConta = entrada.nextLine();
          temp = pesquisarConta(agenciaAtual, pesquisaConta);
          if(temp == null){
            System.out.println("\nA conta não foi encontrada nesta agência.");  
          }
          else{

            agenciaAtual.getContas().remove(temp);
            System.out.println("\nConta excluída com sucesso.");
          }
        
          break;  
      
        case 5:
          System.out.print("\nInforme o id, número ou nome do cliente da conta: ");
          pesquisaConta = entrada.nextLine();
          temp = pesquisarConta(agenciaAtual, pesquisaConta);
          if(temp == null){
            System.out.println("\nA conta não foi encontrada.");  
          }
          else{

            System.out.println("\nDados atuais desta agência:");
            System.out.println("\nId: " + temp.getId());
            System.out.println("Número da conta: " + temp.getNumero());
            System.out.println("Cliente: " + temp.getCliente().getNome());
            System.out.println("Agência: " + agenciaAtual.getNumero() + " - " + agenciaAtual.getCidade());
            System.out.println("Banco: " + bancoAtual.getNumero() + " - " + bancoAtual.getNome());
            System.out.println("Saldo atual: " + temp.getSaldo());
            System.out.println("Limite atual: " + temp.getLimite());
            
            System.out.println("\nInforme os novos dados da conta:");
            System.out.print("\nNovo Número da Conta: ");
            String novoNumeroConta = entrada.nextLine();
            System.out.print("Novo Limite da Conta: ");
            double novoLimiteConta = Double.parseDouble(entrada.nextLine());
            
            // vamos atualizar os dados desta conta no ArrayList da agência atual
            temp.setNumero(novoNumeroConta);
            temp.setLimite(novoLimiteConta);
            System.out.println("\nConta atualizada com sucesso.");
          }
        
          break;
          
        case 6:
          return 0;
      }
    }
  }
  
  public Conta pesquisarConta(Agencia agencia, String pesquisaConta){
    Conta c = null;
       
    for(int i = 0; i < agencia.getContas().size(); i++){
      if(Integer.toString(agencia.getContas().get(i).getId()).equals(pesquisaConta)){
        return agencia.getContas().get(i);  
      }
      else if(agencia.getContas().get(i).getNumero().contains(pesquisaConta)){
        return agencia.getContas().get(i);  
      }
      else if(agencia.getContas().get(i).getCliente().getNome().contains(pesquisaConta)){
        return agencia.getContas().get(i);  
      }
    }
    
    return c;
  }
  
  public Conta pesquisarContaPorId(int id){
    Conta c = null;
       

    for(int i = 0; i < bancos.size(); i++){
      Banco banco = bancos.get(i);
      for(int j = 0; j < banco.getAgencias().size(); j++){
        Agencia agencia = banco.getAgencias().get(j);
        for(int x = 0; x < agencia.getContas().size(); x++){
          Conta conta = agencia.getContas().get(x);
          if(conta.getId() == id){
            return conta;  
          }
        }
      }
    }
    
    return c;
  }
  
  public int menuCliente(){
    int idConta;
    Conta conta;
    Transacao transacao;
    NumberFormat nf = NumberFormat.getCurrencyInstance();
    Format formato = new SimpleDateFormat("dd/MM/yyyy");
    Pessoa cliente = null;

    int numTentativas = 0;
    long tempoUltimoErro = 0;

    Autenticacao autenticacao = new Autenticacao("user", "user");

    while (true) {
      limparTela();
      System.out.println(vinho+"\n:: L O G I N ::\n"+reset);
      System.out.print("Usuário: ");
      String usuario = entrada.nextLine();
      System.out.print("Senha: ");
      String senha = entrada.nextLine();

      if (autenticacao.verificaCredenciais(usuario, senha)) {
        break;
      } else {
        numTentativas++;
        if (numTentativas == 2) {
          long tempoAtual = System.currentTimeMillis();
          if (tempoAtual < tempoUltimoErro + 30000) {
            System.out.println("Você excedeu o número de tentativas. Tente novamente mais tarde.");
            try {
              Thread.sleep(tempoUltimoErro + 30000 - tempoAtual);
            } catch (InterruptedException ex) {
              Thread.currentThread().interrupt();
            }
            numTentativas = 0;
            tempoUltimoErro = System.currentTimeMillis();
            continue;
          } else {
            numTentativas = 0;
            tempoUltimoErro = System.currentTimeMillis();
          }
        }
        System.out.println("Usuário ou senha inválidos. Tente novamente.");
      }
    }

    while(cliente == null){
      System.out.print("\nPrezado(a) cliente, informe seu id ou nome: ");
      String pesquisaPessoa = entrada.nextLine();
      // chamamos o método que pesquisa a pessoa
      cliente = pesquisarPessoa(pesquisaPessoa);
      if(cliente == null){ // pessoa não encotrado
        System.out.print("\nCliente não encontrado.\n\nDigite 1 para pesquisar novamente ou 2 para voltar ao menu anterior: ");
        int opcaoTemp = Integer.parseInt(entrada.nextLine());
        if(opcaoTemp == 2){
          return 1;
        }
      }
    }
    
    while(true){
      limparTela();
      System.out.println(vinho+"\n:: A C E S S O   D O   C L I E N T E ::\n"+reset);
      System.out.println("Cliente Selecionado: " + cliente.getNome() + "\n");
      System.out.println("Escolha a opção desejada");
      System.out.println(vinho+"1 -"+reset+" Listar Minhas Contas Bancárias");
      System.out.println(vinho+"2 -"+reset+" Efetuar Depósito");
      System.out.println(vinho+"3 -"+reset+" Efetuar Saque");
      System.out.println(vinho+"4 -"+reset+" Efetuar Transferência");
      System.out.println(vinho+"5 -"+reset+" Obter Extrato");
      System.out.println(vinho+"6 -"+reset+" Voltar Menu Anterior");
      System.out.print("Sua opção: ");
      int opcao = Integer.parseInt(entrada.nextLine()); // lê a opção do usuário
    
      switch(opcao){
        case 1:
          for(int i = 0; i < cliente.getContas(bancos).size(); i++){
            Conta contaAtualTemp = cliente.getContas(bancos).get(i);
            System.out.println("\nId: " + contaAtualTemp.getId());
            System.out.println("Número da conta: " + contaAtualTemp.getNumero());
            System.out.println("Cliente: " + contaAtualTemp.getCliente().getNome());
            System.out.println("Agência: " + contaAtualTemp.getAgencia().getNumero() + " - " 
              + contaAtualTemp.getAgencia().getCidade());
            System.out.println("Banco: " + contaAtualTemp.getAgencia().getBanco().getNumero() + " - " 
              + contaAtualTemp.getAgencia().getBanco().getNome());
            System.out.println("Saldo atual: " + contaAtualTemp.getSaldo());
            System.out.println("Limite atual: " + contaAtualTemp.getLimite());
          }
            
          break;
        case 2:
          System.out.print("\nInforme o Id da Conta: ");
          idConta = Integer.parseInt(entrada.nextLine());
          System.out.print("Valor do Depósito: ");
          double valorDeposito = Double.parseDouble(entrada.nextLine());
          
          conta = pesquisarContaPorId(idConta);
          if(conta == null){
            System.out.print("\nConta não encontrada. Não foi possível efetuar o depósito.\n");
          }
          else{
            conta.setSaldo(conta.getSaldo() + valorDeposito);
            Transacao.contadorTransacoes++;
            transacao = new Transacao(conta, Transacao.contadorTransacoes, new Date(), 
              "DEPOSITO", valorDeposito, 'C');
            conta.getTransacoes().add(transacao);
            System.out.print("\nDepósito efetuado com sucesso.\n");
          }
          
          break;
        
        case 3:
          System.out.print("\nInforme o Id da Conta: ");
          idConta = Integer.parseInt(entrada.nextLine());
          System.out.print("Valor do Saque: ");
          double valorSaque = Double.parseDouble(entrada.nextLine());
          
          conta = pesquisarContaPorId(idConta);
          if(conta == null){ // conta não enconrada
            System.out.print("\nConta não encontrada. Não foi possível efetuar o saque.\n");
          }
          else{

            if(valorSaque > (conta.getSaldo() + conta.getLimite())){
              System.out.print("\nSaldo e limite insuficientes para este saque.\n");  
            }
            else{  
              conta.setSaldo(conta.getSaldo() - valorSaque);
              Transacao.contadorTransacoes++;
              transacao = new Transacao(conta, Transacao.contadorTransacoes, new Date(), 
                "SAQUE", valorSaque, 'D');
              conta.getTransacoes().add(transacao);
              System.out.print("\nSaque efetuado com sucesso.\n");
            }
          }
          
          break;  
          
        case 4:
          System.out.print("\nInforme o Id da Conta do Débito: ");
          idConta = Integer.parseInt(entrada.nextLine());
          System.out.print("Informe o Id da Conta do Crédito: ");
          int idContaCredito = Integer.parseInt(entrada.nextLine());
          System.out.print("Valor da Transferência: ");
          double valorTransferencia = Double.parseDouble(entrada.nextLine());
          
          conta = pesquisarContaPorId(idConta);
          Conta contaCredito = pesquisarContaPorId(idContaCredito);
          
          if(conta == null){
            System.out.print("\nConta de débito não foi encontrada. Não foi possível efetuar a transferência.\n");
          }
          else if(contaCredito == null){
            System.out.print("\nConta de crédito não foi encontrada. Não foi possível efetuar a transferência.\n");
          }
          else if(contaCredito.getId() == conta.getId()){
            System.out.print("\nAs contas de débito e crédito não podem ser a mesma.\n");
          }
          else{
            if(valorTransferencia > (conta.getSaldo() + conta.getLimite())){
              System.out.print("\nSaldo e limite insuficientes para esta transferência.\n");  
            }
            else{  
              conta.setSaldo(conta.getSaldo() - valorTransferencia);
              contaCredito.setSaldo(contaCredito.getSaldo() + valorTransferencia);
              
              Transacao.contadorTransacoes++;
              transacao = new Transacao(conta, Transacao.contadorTransacoes, new Date(), 
                "TRANSFERENCIA", valorTransferencia, 'D');
              conta.getTransacoes().add(transacao);
              
              Transacao.contadorTransacoes++;
              transacao = new Transacao(contaCredito, Transacao.contadorTransacoes, new Date(), 
                "TRANSFERENCIA", valorTransferencia, 'C');
              contaCredito.getTransacoes().add(transacao);
              
              System.out.print("\nTransferência efetuada com sucesso.\n");
            }
          }
          
          break;
         
        case 5:
          System.out.print("\nInforme o Id da Conta: ");
          idConta = Integer.parseInt(entrada.nextLine());
          
          conta = pesquisarContaPorId(idConta);
          if(conta == null){
            System.out.print("\nConta não encontrada. Não foi possível efetuar o depósito.\n");
          }
          else{

            System.out.println(vinho+"\n" +
              "        E X T R A T O   B A N C Á R I O         \n" +
              "------------------------------------------------\n" +
              "Cliente: " + conta.getCliente().getNome() + "\n" + 
              "Banco: " + conta.getAgencia().getBanco().getNome() + "\n" +
              "Agência: " + conta.getAgencia().getNumero() + " - " + conta.getAgencia().getCidade() + "\n" +
              "Conta: " + conta.getNumero() + "\n" +
              "------------------------------------------------\n" +
              "DATA        HISTORICO           DOC        VALOR\n" +
              "------------------------------------------------"+reset);

 
            for(int i = 0; i < conta.getTransacoes().size(); i++){
              Transacao t = conta.getTransacoes().get(i);
              
              String valorFormatado = nf.format(t.getValor());
              System.out.println(formato.format(t.getData()) + "  " + String.format("%-20s", t.getHistorico()) + 
                String.format("%1$5s", t.getId()).replace(' ', '0') +  
                String.format("%10s", valorFormatado.replace("R$ ", "")) + t.getLetra());
            }
            
            System.out.println(vinho+"------------------------------------------------");
            String valorFormatado = nf.format(conta.getSaldo());
            System.out.println("SALDO ATUAL:" + String.format("%36s", valorFormatado.replace("R$ ", "")));
            valorFormatado = nf.format(conta.getLimite());
            System.out.println("LIMITE:" + String.format("%41s", valorFormatado.replace("R$ ", "")));
            valorFormatado = nf.format(conta.getSaldo() + conta.getLimite());
            System.out.println("SALDO + LIMITE:" + String.format("%33s", valorFormatado.replace("R$ ", "")));
            System.out.println("------------------------------------------------"+reset);
          }
          
          break;  
          
        case 6:
          return 1; 
      }  
    }
  }
  

  public void limparTela(){
    /*
    try{
      String operatingSystem = System.getProperty("os.name"); //Check the current operating system
              
      if(operatingSystem.contains("Windows")){        
        ProcessBuilder pb = new ProcessBuilder("cmd", "/c", "cls");
        Process startProcess = pb.inheritIO().start();
        startProcess.waitFor();
      } else {
        ProcessBuilder pb = new ProcessBuilder("clear");
        Process startProcess = pb.inheritIO().start();

        startProcess.waitFor();
      } 
    }catch(Exception e){
      System.out.println(e);
    }
    */
  }
}
