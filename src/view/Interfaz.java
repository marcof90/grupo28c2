package view;

import javax.swing.JFrame;

import controller.Controlador;

import java.awt.BorderLayout;

public class Interfaz extends JFrame{
    
    private PanelOpciones panelOpciones;

    private Controlador control;

    public Interfaz(){
        super();

        this.control = new Controlador();

        setTitle("Wallet");
        setSize(500, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        this.panelOpciones = new PanelOpciones(this);

        add(panelOpciones, BorderLayout.SOUTH);
    }

    public boolean addOwner(String nombre){
        return control.addOwner(nombre);
    }

    public static void main(String[] args) {
        Interfaz inter = new Interfaz();
        inter.setVisible(true);
    }

}
