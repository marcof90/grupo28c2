package model;

public class Wallet {

    public static final int LIMITE_BILLETERA = 500000;

    /**
     * saldo de la billetera
     */ 
    private int saldo;
    private boolean tieneLimite;
    private int meta;
    
    public Wallet(boolean limite) {
        super();
        saldo = 0;
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

}
