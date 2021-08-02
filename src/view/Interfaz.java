package view;

import javax.swing.JFrame;

import controller.Controlador;

import java.awt.BorderLayout;

public class Interfaz extends JFrame{
    
    //se crea el atributo o relacion
    private PanelOpciones panelOpciones;
    private PanelOwners panelOwners;

    private Controlador control;

    public Interfaz() {
        super();
        setSize(500, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        setTitle("Wallet");

        //inicializar
        panelOpciones = new PanelOpciones(this);
        panelOwners = new PanelOwners(this);
        control = new Controlador();

        //modificar las propiedades

        //agregar
        add(panelOpciones, BorderLayout.SOUTH);
        add(panelOwners, BorderLayout.WEST);
    }

    public boolean addOwner(String nombre) {
        return control.addOwner(nombre);            
    }

    public String listarOwners(){
        return control.listarOwners();
    }

    public static void main(String[] args) {
        Interfaz inter = new Interfaz();
        inter.setVisible(true);
    }
}
