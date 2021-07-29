package view;

import model.Company;
import model.Owner;

public class VistaUser {

    public static void main2(String[] args) throws Exception {
        Owner owner1 = new Owner("Susen");
        Owner owner2 = new Owner("Luisa");
        System.out.println(owner1.getNombre());
        System.out.println(owner2.getNombre());
        owner1.getWallet().putSaldo(100000);

        Company empresa = new Company("Nestle");
        String response = empresa.myWallet().putSaldo(1000000);
        System.out.println(response);

    }
    
}
