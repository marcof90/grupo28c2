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

    public boolean addOwner(String nombre) {
        if (nombre==null || nombre.equalsIgnoreCase("")) {
            return false;
        }
        Owner cliente = new Owner(nombre);
        owners.add(cliente);
        return true;
    }

    public String listarOwners() {
        String listado = "";
        for (Owner owner : owners) {
            listado += owner + "\n";
        }
        return listado;
    }

    public String[] getDataOwners(){
        String[] dataOwners = new String[owners.size()];
        for (int i = 0; i < dataOwners.length; i++) {
            dataOwners[i] = owners.get(i).toString();
        }
        return dataOwners;
    }
}
