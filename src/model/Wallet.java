package model;

public class Wallet {

    public static final int LIMITE_BILLETERA = 500000;
    public static final int TOPE_TRANSACCION = 200000; 
    public static final double TAZA_TRANSFERENCIA = 0.002; 

    /**
     * saldo de la billetera
     */ 
    private int saldo;
    private boolean tieneLimite;
    private int meta;
    private boolean topeTransaccion; 
    
    public Wallet(boolean limite) {
        super();
        saldo = 0;
        meta = 0;
        tieneLimite = limite;
        if (tieneLimite) {
            topeTransaccion = true; // si la billetera tiene límite, entonces también tendrá tope
        }        
    }

    public int getSaldo(){
        return saldo;
    }

    public String putSaldo(int valor){
        if (valor > TOPE_TRANSACCION && tieneLimite && topeTransaccion){
            return "No puede superar el valor máximo de transacción: " + TOPE_TRANSACCION;
        }
        if(saldo + valor > LIMITE_BILLETERA && tieneLimite){
            return "No puede superar el limite";
        }
        saldo += valor;
        if(verificarMeta()){System.out.println("Has superado la meta!");}
        return "Operación exitosa, nuevo saldo " + saldo;
    }

    public String getMoney(int valor) {
        if (valor > TOPE_TRANSACCION && tieneLimite && topeTransaccion){
            return "No puede superar el valor máximo de transacción: " + TOPE_TRANSACCION;
        }
        if(valor > saldo){
            int saldoTemp = saldo;
            saldo = 0;
            return "Solo se retiró " + saldoTemp;
        }
        saldo -= valor;
        return "Retiro exitoso, nuevo saldo " + saldo;
    }

    public String transfMoney(Wallet wallet, int valor){
        if (valor > TOPE_TRANSACCION && tieneLimite && topeTransaccion){
            return "No puede superar el valor máximo de transacción: " + TOPE_TRANSACCION;  
        }
        if (saldo - valor < 0){
            return "Saldo insuficiente";
        }
        wallet.saldo += valor;
        saldo -= valor * (1+TAZA_TRANSFERENCIA);
        return "Transferencia exitosa, nuevo saldo: " + saldo;   
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
    
}
