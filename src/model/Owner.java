package model;

public class Owner extends Usuario{
    private Wallet wallet;

    public Owner(String nNombre, int id) {
        super("",id);
        wallet = new Wallet(true);
        setNombre(nNombre);
    }  

    public Wallet getWallet() {
        return wallet;
    }

    @Override
    public String toString() {
        // return super.toString();
        return "ID: "+getId()+"  Nombre: "+ getNombre();
    }
}
