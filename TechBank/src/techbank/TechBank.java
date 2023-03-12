package techbank;


import java.util.ArrayList;
import java.util.Scanner;
import static techbank.Operacoes.operacoes;


public class TechBank {
    
    static Scanner scan = new Scanner(System.in);
    static ArrayList<Conta> contasBancarias;
    
    public static void main(String[] args) {
               
        contasBancarias = new ArrayList<Conta>();
        operacoes();
        
    }  


}
