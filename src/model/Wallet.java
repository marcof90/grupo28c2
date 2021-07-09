package model;

public class Wallet {

    public static final int LIMITE_BILLETERA = 500000;

    public static final int TOPE_TRANSACCION = 200000; // lstpgh

    public static final double TASA_TRANSFERENCIA = 0.2 / 100;  // lstpgh


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

/*  // lstpgh

    public String putSaldo(int valor){
        if(saldo + valor > LIMITE_BILLETERA && tieneLimite){
            return "No puede superar el limite";
        }
        saldo += valor;
        if(verificarMeta()){System.out.println("Has superado la meta!");}
        return "Operación exitosa, nuevo saldo " + saldo;
    }

*/

/*  // lstpgh

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

*/  

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
        if (saldo >= meta && meta > 0){
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
    



/**

  putSaldo(valor: int) String // actualizar saldo, consignar

  in:  Wallet, valor
  out: "mensaje resultado operación"

  - validarValor()
  - verificarMeta()

*/


    public String putSaldo(int valor){
        if (tieneLimite){
            if (valor > TOPE_TRANSACCION){
                return "No puede superar el tope de transacción";
            }
        }
        if(saldo + valor > LIMITE_BILLETERA){
            return "No puede superar el límite";
        }

        saldo += valor;  // actualiza saldo

        if (verificarMeta()){
            System.out.println("Has superado la meta!");
        }        
        return "Operación exitosa, nuevo saldo " + saldo;
    }



/**

  getMoney(valor: int) String // actualizar saldo, retirar

  in:  Wallet, valor
  out: "mensaje resultado operación"

  - validarValor()

*/

    public String getMoney(int valor) {
        if (tieneLimite && valor > TOPE_TRANSACCION){
            saldo -= TOPE_TRANSACCION;
            return "No puede superar el tope de transacción. Solo se retiró " + TOPE_TRANSACCION;
        }
        if(valor > saldo){
            int saldoTemp = saldo;
            saldo = 0;
            return "Solo se retiró " + saldoTemp;
        }
        saldo -= valor;
        return "Retiro exitoso, nuevo saldo " + saldo;
    }


/**
  
  transferMoney(destino: Wallet, valor: int): String  // transferir dinero

  in:  origen: Wallet, destino: Wallet, valor: int
  out: "estado operación": String

 - validarValor()
 - retirarDinero(origen)
 - consignarDinero(destino)
 - descontarTasa(destino)

  casos: tranferencia supera tope
      transferencia supera saldo
      transferencia supera límite

*/


    public String transferMoney(Wallet destino, int valor){
        if (tieneLimite && valor > TOPE_TRANSACCION){
            return "Transacción cancelada. No se puede superar el tope de transacción";
        }
        if (valor > saldo){
            return "Transacción cancelada. Transferencia no puede ser mayor al saldo";
        }
        if (destino.tieneLimite && valor + destino.saldo > LIMITE_BILLETERA){
            return "Transacción cancelada. No se puede superar el límite destino";
        }

        saldo -= valor;

        destino.saldo += valor - (valor * TASA_TRANSFERENCIA);

        return "Transferencia exitosa, nuevo saldo " + saldo;
    }
}

