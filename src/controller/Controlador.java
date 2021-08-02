package controller;
import java.util.ArrayList;
import model.Owner;

public class Controlador {

    private ArrayList<Owner> owners;

    public Controlador() {
        super();
        owners = new ArrayList<>();
    }

    public ArrayList<Owner> getOwners() {
        return owners;
    }

    public boolean addOwner(String nombre){
        if (nombre==null || nombre.equalsIgnoreCase("")){
            return false;
        }

        Owner cliente = new Owner(nombre);
        owners.add(cliente);
        return true;

    }
     
    
}
