package model;

public class Owner extends Usuario{
    private Wallet wallet;

    public Owner(String nNombre) {
        super("dhjasd",5);
        wallet = new Wallet(true);
        setNombre(nNombre);
    }  

    public Wallet getWallet() {
        return wallet;
    }

    @Override
    public String toString() {
        // TODO Auto-generated method stub
        // return super.toString();
        return "Nombre: "+ getNombre();
    }
}
