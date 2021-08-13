package controller;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import model.Owner;
import model.Transaction;
import services.JavaMySQL;

public class Controlador {
    
    private ArrayList<Owner> owners;

    private JavaMySQL serviceDB;

    public Controlador() {
        super();
        owners = new ArrayList<>();
        serviceDB = new JavaMySQL();
        checkConnect();
    }

    public void checkConnect() {
        try {
            if(serviceDB.getConnect().isValid(30)){
                fillUserData(serviceDB.getUsersDB());
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void fillUserData(ResultSet rs) {
        try {
            while (rs.next()) {
                Owner owner = new Owner(rs.getString("name"), rs.getInt("id"));
                owners.add(owner);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void fillTransactionsData(int id_user, int id_wallet) {
        ResultSet rs = serviceDB.getWalletTransaccions(id_wallet);
        owners.get(id_user).getWallet().setTransactions(new ArrayList<>());
        try {
            while (rs.next()) {
                Transaction t = new Transaction(rs.getInt("amount"), "", rs.getInt("transaction_type"));
                owners.get(id_user).getWallet().getTransactions().add(t);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public ArrayList<Owner> getOwners() {
        return owners;
    }

    public boolean addOwner(String nombre) {
        if (nombre==null || nombre.equalsIgnoreCase("")) {
            return false;
        }
        Owner cliente = new Owner(nombre, owners.size());
        owners.add(cliente);
        serviceDB.insertUser(nombre);
        return true;
    }

    public void insertTransaction(int amount, int type, int id_wallet ) {
        serviceDB.insertTransaction(amount, type, id_wallet);
    }

    public void updateSaldoWallet(int amount, int id) {
        serviceDB.updateSaldoWallet(amount, id);
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

    public String[] getDataTransaccions(int id){
        String[] dataTransactions = new String[owners.get(id).getWallet().getTransactions().size()];
        for (int i = 0; i < dataTransactions.length; i++) {
            dataTransactions[i] = owners.get(id).getWallet().getTransactions().get(i).toString();
        }
        return dataTransactions;
    }

    public Owner getWalletUser(int id) {
        ResultSet rs = serviceDB.getWalletUser(owners.get(id).getId());
        try {
            while (rs.next()) {
                owners.get(id).getWallet().setSaldo(rs.getInt("saldo"));
                owners.get(id).getWallet().setId(rs.getInt("id"));
            }
            return owners.get(id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
