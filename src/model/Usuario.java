package model;

public class Usuario {
    private int id;
    private String nombre;
    private char estado;
    private String[] tiposDocumento;
    private String documento;

    public Usuario() {
        super();
        tiposDocumento = new String[0];
    }

    public Usuario(String nombre, int numero) {
        super();
        id = numero;
        tiposDocumento = new String[6];
        tiposDocumento[0] = "CC";
        tiposDocumento[1] = "TI";
        tiposDocumento[2] = "Pasaporte";
        tiposDocumento[3] = "PEP";
        tiposDocumento[4] = "DNI";
        tiposDocumento[5] = "RC";
    }

    public int getId() {
        return id;
    }

    public char getEstado() {
        return estado;
    }

    public String getNombre() {
        return nombre;
    }

    public void setEstado(char estado) {
        this.estado = estado;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    } 
    
}
