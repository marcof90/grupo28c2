package model;

public class Owner extends Usuario{
    private Wallet wallet;

    public Owner(String nNombre) {
        super();
        wallet = new Wallet(true);
        setNombre(nNombre);
    }

    @Override
    public String getNombre() {
        // TODO Auto-generated method stub
        return super.getNombre();
    }

    public Wallet getWallet() {
        return wallet;
    }
}
