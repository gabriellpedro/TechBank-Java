package techbank;

import static techbank.Format.DoubleToString;
import static techbank.Format.formatandoValores;


public class Conta {
    
    private static Integer contadorContas = 1;
    
    private Integer numeroConta;
    private Pessoa pessoa;
    private Double saldo = 0.0;

    public Conta(Pessoa pessoa) {
        this.numeroConta = contadorContas;
        this.pessoa = pessoa;
        contadorContas += 1;
    }

    public static Integer getContadorContas() {
        return contadorContas;
    }

    public static void setContadorContas(Integer contadorContas) {
        Conta.contadorContas = contadorContas;
    }

    public Integer getNumeroConta() {
        return numeroConta;
    }

    public void setNumeroConta(Integer numeroConta) {
        this.numeroConta = numeroConta;
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    public Double getSaldo() {
        return saldo;
    }

    public void setSaldo(Double saldo) {
        this.saldo = saldo;
    }

    @Override
    public String toString() {
        return  "\nNúmero da Conta: "+ this.getNumeroConta() +
                "\nNome: "+this.pessoa.getNome() +
                "\nCPF: "+ this.pessoa.getCpf() +
                "\nE-mail: "+ this.pessoa.getEmail() +
                "\nSaldo: "+ this.getSaldo()+
                "\n\n";
    }
    
    public void depositar(Double valor){
        if(valor >0){
            setSaldo(getSaldo() + valor);
            System.out.println("Seu depósito foi realizado com sucesso!");
        }else{
            System.out.println("Não foi possível realizar o depósito");
        }
        
    }
    
    public void sacar(Double valor){
        if(valor >=0 && valor <= getSaldo()){
            setSaldo(getSaldo() - valor);
        }else{
            System.out.println("Não é possível realizar o saque, saldo insuficiente");
        }
    }
    
    public void transferir(Conta contaDeposito, Double valor){
        if(valor > 0){
            contaDeposito.saldo = contaDeposito.getSaldo() + valor;
            System.out.println("Depósito realizado com sucesso!");
        } else {
            System.out.println("Não foi possível realizar o depósito...");
        }
    }
    
    
}
