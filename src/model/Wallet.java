package model;

import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Properties;


public class Wallet {

    public static final int LIMITE_BILLETERA = 500000;

    /**
     * saldo de la billetera
     */ 
    private int saldo;
    private int id;
    private boolean tieneLimite;
    private int meta;
    
    
    /**
     * lista de transacciones de la Wallet
     */
    private ArrayList<Transaction> transactions;

    /**
     * Método contructor de la clase. <br>
     * <br>
     * saldo = 0; <br>
     * meta = 0; <br>
     * tieneLimite = true; <br>
     * transactions
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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    public ArrayList<Transaction> getTransactions() {
        return transactions;
    }

    public void setTransactions(ArrayList<Transaction> transactions) {
        this.transactions = transactions;
    }

    public int getSaldo(){
        return saldo;
    }

    public void setSaldo(int saldo) {
        this.saldo = saldo;
    }

    public String putSaldo(int valor) throws Exception{
        if(saldo + valor > LIMITE_BILLETERA && tieneLimite){
            throw new Exception("No puede superar el limite");
        }

        if (valor <= 0) {
            throw new Exception("No puede consignar un valor nulo o negativo");
        }
        saldo += valor;
        Transaction transaction = new Transaction(valor, "hoy", 1);
        transactions.add(transaction);
        if(verificarMeta()){System.out.println("Has superado la meta!");}
        return "Operación exitosa, nuevo saldo " + saldo;
    }

    public String getMoney(int valor) throws Exception{
        // if(valor > saldo){
        //     return "Saldo insuficiente";
        // }
        if (valor <= 0) {
            throw new Exception("No puede consignar un valor nulo o negativo");
        }

        if(valor > saldo){
            int saldoTemp = saldo;
            saldo = 0;
            return "Solo se retiró " + saldoTemp;
        }
        saldo -= valor;
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

        try {
            
            OutputStream ous = new FileOutputStream("./data/data.properties");

            Properties prop = new Properties();

            
            for (Transaction transaction : transactions){
                System.out.println(transaction);
            }

            prop.store(ous, null);
            
        } catch (Exception e) {
            //TODO: handle exception
        }

    }
    
}
