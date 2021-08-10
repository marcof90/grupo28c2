package model;

public class Owner extends Usuario{
    private Wallet wallet;

    public Owner(String nNombre, int id) {
        super("", id);
        wallet = new Wallet(true);
        setNombre(nNombre);
    }

    @Override
    public String getNombre() {
        return super.getNombre();
    }

    public Wallet getWallet() {
        return wallet;
    }

    @Override
    public String toString() {
        // return super.toString();
        return "ID: "+getId()+" Nombre: " + getNombre();
    }
}
