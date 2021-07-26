package view;

import model.Wallet;

public class Vista {
        
    public static void main(String[] args) {
        Wallet wallet1 = new Wallet(true);
        //Wallet wallet1 = new Wallet(false);
        Wallet wallet2 = new Wallet(false);
        try {
            System.out.println(wallet1.getSaldo()/0);
        } catch (Exception e) {
            System.out.println("uy paso algo raro");
        }

        try {
            String saldo1 = wallet1.putSaldo(600000);
            // System.out.println(wallet1.getSaldo());
            System.out.println(saldo1);
            wallet1.putSaldo(600000);
            wallet1.putSaldo(600000);
            wallet1.putSaldo(605000);
            wallet2.putSaldo(600200);
            wallet2.putSaldo(600000);
            wallet2.putSaldo(600000);
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        //String saldo1 = wallet1.putSaldo(10000);
<<<<<<< HEAD
       
=======
        String saldo1 = wallet1.putSaldo(600000);
        // System.out.println(wallet1.getSaldo());
        System.out.println(saldo1);
        wallet2.putSaldo(600000);
        wallet2.putSaldo(600000);
        wallet2.putSaldo(605000);
        wallet2.putSaldo(600200);
        wallet2.putSaldo(600000);
        wallet2.putSaldo(500000);
>>>>>>> 61265ee9655e4890b8288bcd621bed8665b8e2e2
        // System.out.println(wallet2.getSaldo());
        wallet2.displayExtractos();
        //System.out.println(wallet1.breakLimit());
        //System.out.println(wallet2.breakLimit());
    }

}
