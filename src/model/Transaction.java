package model;

public class Transaction {
    private int amount;
    private String fecha;
    /**
     * 1 ingreso
     * 2 egreso
     */
    private int type;

    public Transaction(int amount, String fecha, int type) {
        super();
        this.amount = amount;
        this.fecha = fecha;
        this.type = type;
    }
    public int getAmount() {
        return amount;
    }    
    public String getFecha() {
        return fecha;
    }    
    public int getType() {
        return type;
    }

    public String toString(){
        return "Monto: "+amount+", Fecha: "+fecha+", Tipo: "+ ((type== 1)? "Ingreso":"Egreso");
    }

}
