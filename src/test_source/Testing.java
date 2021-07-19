package test_source;

import model.Owner;
import model.Wallet;

public class Testing {

    public Testing() {
        super();
    }

    public void escenarioWallet() {
        Wallet wallet1 = new Wallet(false);
        Wallet wallet2 = new Wallet(true);
        
        wallet1.putSaldo(Wallet.LIMITE_BILLETERA + 1);
        boolean r1 = assertTrue(Wallet.LIMITE_BILLETERA + 1, wallet1.getSaldo());
        System.out.println("Prueba limite " + ((r1)? "Paso": "No paso"));

        wallet2.putSaldo(Wallet.LIMITE_BILLETERA + 1);
        boolean r2 = assertTrue(0, wallet2.getSaldo());
        System.out.println("Prueba limite " + ((r2)? "Paso": "No paso"));

    }

    public void escenarioOwner(){
        Owner owner1 = new Owner("Juan");
        Owner owner2 = new Owner("Pedro");

        boolean r1 = assertTrue("Juan", owner1.getNombre());        
        System.out.println("Prueba nombre " + ((r1)? "Paso": "No paso" ));

        boolean r2 = assertTrue("Pedro", owner2.getNombre());
        System.out.println("Prueba nombre " + ((r2)? "Paso": "No paso" ));
    }

    public boolean assertTrue(String expected, String received){
        return expected.equals(received);
    }
    
    public boolean assertFalse(String expected, String received) {
        return !expected.equals(received);
    }

    public boolean assertTrue(int expected, int received){
        return expected == received;
    }

    public boolean assertFalse(int expected, int received){
        return !(expected == received);
    }
    

}
