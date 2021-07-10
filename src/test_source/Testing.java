package test_source;

import model.Wallet;

public class Testing {

    public Testing() {
        super();
        
    }

    public boolean assertTrue(String expected, String received){
        return expected.equals(received);

    }


    // prueba transferencia desde una billetera que tenga saldo 0

    public String testTransferZero() {

        var received = new String();
        var expected = "Transacción cancelada. Transferencia no puede ser mayor al saldo";
        var wallet1 = new Wallet(true);
        var wallet2 = new Wallet(true);

        received = wallet1.transferMoney(wallet2, 100000);

        return (this.assertTrue(expected, received)) ? "ok" : "fail";

    }

}
