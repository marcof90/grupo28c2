package model;

public class Company extends Usuario{
    private Wallet wallet;

    public Company(String nNombre) {
        super();
        wallet = new Wallet(false);
        setNombre(nNombre);
    }

    public Wallet myWallet() {
        return wallet;
    }
}
