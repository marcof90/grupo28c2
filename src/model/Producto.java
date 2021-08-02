package model;

public class Producto {
    public static final float PRECIO_BASE = 1500000;
    public final static String CIUDAD_BASE = "Barranquilla";

    private String ciudad;
    private float valor;

    public Producto() {
        super();
        ciudad = CIUDAD_BASE;
        valor = PRECIO_BASE;
    }

    public Producto(String ciudad) {
        super();
        this.ciudad = ciudad;
        if (ciudad.equalsIgnoreCase("Bogotá")) {
            valor = (float) (PRECIO_BASE * 1.15);
        } else {
            valor = PRECIO_BASE;
        }
    }

    public String getCiudad() {
        return ciudad;
    }

    public float getValor() {
        return valor;
    }

    public void name() {
        
        Producto p1 = new Producto();
        System.out.println(p1.getCiudad());
        System.out.println(p1.getValor());

        Producto p2 = new Producto("Bogotá");
        System.out.println(p2.getCiudad());
        System.out.println(p2.getValor());
    }

    public void arreglodeProductos() {
        Producto[] arreglodeProductos = new Producto[3];
        arreglodeProductos[0] = new Producto();
        arreglodeProductos[1] = new Producto("Bogotá");
        arreglodeProductos[2] = new Producto("Cali");
        double total = 0.0;
        for (Producto producto : arreglodeProductos) {
            total += producto.getValor();
        }
        System.out.println(total);
    }

}
