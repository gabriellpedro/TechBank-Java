
package techbank;


public class Pessoa {
    
    private static Integer ContadorPessoas = 1;
    
    private String nome;
    private String cpf;
    private String email;

    public Pessoa(String nome, String cpf, String email) {
        this.nome = nome;
        this.cpf = cpf;
        this.email = email;
        ContadorPessoas += 1;
    }

    public static Integer getContadorPessoas() {
        return ContadorPessoas;
    }

    public static void setContadorPessoas(Integer ContadorPessoas) {
        Pessoa.ContadorPessoas = ContadorPessoas;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Nome: "+this.getNome() +
                "\nCPF:"+this.getCpf() +
                "\nE-mail: "+this.getEmail();
    }
    
    
    
    
}
