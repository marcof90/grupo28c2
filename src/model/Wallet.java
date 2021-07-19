package model;

import java.util.ArrayList;

public class Wallet {

    public static final int LIMITE_BILLETERA = 500000;

    /**
     * saldo de la billetera
     */ 
    private int saldo;
    private boolean tieneLimite;
    private int meta;

    /**
     * lista de transacciones de la Wallet
     */
    private ArrayList<Transaction> transactions;

    /**
     * Metodo constructor de la clase. <p>
     * saldo = 0; <p>
     * meta = 0; <p>
     * tieneLimite = true; <p>
     * transactions = new ArrayList<>(); <p>
     * saldo = 0; <p>
     * @param limite limite que tiene la wallet según tipo
     */    
    public Wallet(boolean limite) {
        super();
        saldo = 0;
        meta = 0;
        tieneLimite = limite;
        transactions = new ArrayList<>();        
        transactions.size();
    }
    
    public Wallet(boolean limite, int saldo) {
        super();
        this.saldo = saldo;
        meta = 0;
        tieneLimite = limite;
    }

    public int getSaldo(){
        return saldo;
    }

    public String putSaldo(int valor){
        if(saldo + valor > LIMITE_BILLETERA && tieneLimite){
            return "No puede superar el limite";
        }
        saldo += valor;
        Transaction transaction = new Transaction(valor, "hoy", 1);
        transactions.add(transaction);
        if(verificarMeta()){System.out.println("Has superado la meta!");}
        return "Operación exitosa, nuevo saldo " + saldo;
    }

    public String getMoney(int valor) {
        // if(valor > saldo){
        //     return "Saldo insuficiente";
        // }
        if(valor > saldo){
            int saldoTemp = saldo;
            saldo = 0;
            return "Solo se retiró " + saldoTemp;
        }
        saldo -= valor;
        Transaction transaction = new Transaction(valor, "hoy", 2);
        transactions.add(transaction);
        return "Retiro exitoso, nuevo saldo " + saldo;
    }

    public String definirMeta(int valor){
        if(valor == 0){
            meta = valor;
            return "Nueva meta agregada!";    
        }
        if(valor > LIMITE_BILLETERA && tieneLimite){
            return "No puedes establecer una meta más alta que el limite";
        }
        if(valor < 0){
            return "valor ingresado no válido";
        }
        if(valor <= saldo){
            return "Ya has superado este valor";
        }        
        meta = valor;
        return "Nueva meta agregada!";
    }

    public boolean verificarMeta(){
        if(saldo >= meta && meta > 0){
            return true;
        }
        return false;
    }

    public String breakLimite(){
        if (!tieneLimite){
            return "Error. Su cuenta es sin límites";
        }
        if (saldo < 10000){
            return "Error. Romper el limite tiene un costo de 10000, usted tiene " + saldo;
        }
        saldo -= 10000;
        tieneLimite = false;
        return "Operación exitosa. Su cuenta ahora es sin límites, nuevo saldo: " + saldo;
    }

    public String compararBilleteras(Wallet otraWallet){        
        if(saldo > otraWallet.getSaldo()){
            return "Tienes más saldo!";
        }
        else if(saldo == otraWallet.getSaldo()){
            return "Ambos saldos son iguales";
        }else{
            return "Tienes menos saldo :(";
        }
    }
    
    public void displayExtractos(){
        for (Transaction transaction : transactions) {
            System.out.println(transaction);
        }
    }
}
