package view;

import javax.swing.JFrame;

import Controller.Controlador;

import java.awt.BorderLayout;

public class Interfaz extends JFrame {
    
    private PanelOpciones panelOpciones;
    private PanelOwners panelOwners;

    private Controlador control;

    public Interfaz() {
        super();
        setSize(600, 450);
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
        add(panelOwners, BorderLayout.CENTER);
        updateList();
    }

    public boolean addOwner(String nombre) {
        return control.addOwner(nombre);
    }

    public String listarOwners(){
        return control.listarOwners();
    }

    public void updateList() {
        panelOwners.updateList(control.getDataOwners());
    }

    public static void main(String[] args) {
        Interfaz inter = new Interfaz();
        inter.setVisible(true);
    }

}
