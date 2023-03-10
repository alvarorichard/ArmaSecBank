public class Autenticacao {
    private String nomeUsuario;
    private String senha;

    public Autenticacao(String nomeUsuario, String senha) {
        this.nomeUsuario = nomeUsuario;
        this.senha = senha;
    }

    public boolean verificaCredenciais(String nomeUsuario, String senha) {
        return this.nomeUsuario.equals(nomeUsuario) && this.senha.equals(senha);
    }

    public void setNomeUsuario(String nomeUsuario) {
        this.nomeUsuario = nomeUsuario;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
}
