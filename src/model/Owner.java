package model;

public class Owner extends Usuario{
    private Wallet wallet;

    public Owner(String nNombre) {
        super();
        wallet = new Wallet(true);
        setNombre(nNombre);
    }

    public Wallet getWallet() {
        return wallet;
    }

    @Override
    public String toString(){
        //todo auto.generated metdo stub
        //return super.toString();
        return "Nombre: "+getNombre();
    }
}
