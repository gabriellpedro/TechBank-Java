package techbank;

import static techbank.TechBank.contasBancarias;
import static techbank.TechBank.scan;

public class Operacoes {
    
    public static void operacoes(){
        System.out.println("|-----------------------------------|");
        System.out.println("|----- Bem Vindos ao Tech Bank -----|");
        System.out.println("|-----------------------------------|");
        System.out.println("|------- Seleciona uma opcao -------|");
        System.out.println("|-----------------------------------|");
        System.out.println("| 1 - Criar conta    |");
        System.out.println("| 2 - Sacar          |");
        System.out.println("| 3 - Depositar      |");
        System.out.println("| 4 - Transferir     |");
        System.out.println("| 5 - Listar Contas  |");
        System.out.println("| 6 - Sair           |");
        
        int operacao = scan.nextInt();
        
        
        switch(operacao){
            case 1:
                criarConta();
                break;
            case 2:
                sacar();
                break;
            case 3:
                depositar();
                break;
            case 4:
                transferir();
                break;
            case 5:
                listarContas();
                break;
            case 6:
                System.out.println("Obrigado e até mais!");
                System.exit(0);
            default:
                System.out.println("Opções inválidas");
                operacoes();
                break;
        }
        
    }
    
    public static void criarConta(){
        System.out.println("\nNome:");
        String nome = scan.next();
        
        System.out.println("\nCPF:");
        String cpf = scan.next();
        
        System.out.println("\nE-mail:");
        String email = scan.next();
        
        Pessoa pessoa = new Pessoa(nome, cpf, email);
        Conta conta = new Conta(pessoa);
        
        contasBancarias.add(conta);
        
        System.out.println("Conta criada com sucesso!");
        
        operacoes();
        
    }
    
    private static Conta encontrarConta(Integer numeroConta){
        Conta conta = null;
        if(contasBancarias.size() > 0){
            for(Conta c: contasBancarias){
                if(c.getNumeroConta() == numeroConta){
                    conta = c;
                }
            }
        }else{
            System.out.println("Conta não encontrada");
        }
        return conta;
    }
    
    public static void depositar(){
        System.out.println("Conta para depósito:");
        Integer numeroContaDeposito  = scan.nextInt();
        
        Conta conta = encontrarConta(numeroContaDeposito);
        
        if(conta != null){
            System.out.println("Valor de depósito");
            Double valorDeposito = scan.nextDouble();
            conta.depositar(valorDeposito);
        }else{
            System.out.println("Conta não encontrada...");
        }        
        operacoes();
    }
    
    public static void sacar(){
        System.out.println("Conta para saque:");
        Integer numeroContaDeposito  = scan.nextInt();
        
        Conta conta = encontrarConta(numeroContaDeposito);
        
        if(conta != null){
            System.out.println("Valor de saque");
            Double valorSaque = scan.nextDouble();
            conta.sacar(valorSaque);
        }else{
            System.out.println("Conta não encontrada...");
        }        
        operacoes();
    }
    
    public static void transferir(){
         System.out.println("Conta remetente:");
         Integer numeroContaRemetente = scan.nextInt();
         
         Conta contaRemetente = encontrarConta(numeroContaRemetente);
         
         if(contaRemetente != null){
              System.out.println("Conta destinatária:");
            Integer numeroContaDestinataria = scan.nextInt();
         
            Conta contaDestinataria = encontrarConta(numeroContaDestinataria);
            
            if(contaDestinataria != null){
                System.out.println("Digite o valor para transferencia:");
                Double valorTransferencia = scan.nextDouble();
                contaDestinataria.transferir(contaDestinataria, valorTransferencia);
                contaRemetente.setSaldo(contaRemetente.getSaldo() - valorTransferencia);
                System.out.println(contaRemetente.toString());
                System.out.println(contaDestinataria.toString());
            }else{
                System.out.println("Conta Destinataria não encontrada...");
            }            
         }

         operacoes();
         
    }
    
    public static void listarContas(){
        if(contasBancarias.size() > 0){
            for(Conta conta: contasBancarias){
                System.out.println(conta);
            }
        }else{
            System.out.println("Lista vazia");
        }
        operacoes();
    }
    
}
