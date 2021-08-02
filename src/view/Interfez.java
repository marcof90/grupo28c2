package view;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import controller.Controlador;

//import org.graalvm.compiler.replacements.nodes.CStringConstant;


public class Interfez extends JFrame{

    //se crea el atributo o relacion
    private PanelOpciones panelOpciones;

    private Controlador control;

    public Interfez() {
        super();
        setSize(500, 400); //tamaño de la ventana
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        
        //inicializar 
        panelOpciones = new PanelOpciones(this);
        control = new Controlador();

        //modificar 

        //agregar 
        add(panelOpciones, BorderLayout.SOUTH);

    }

    public boolean addOwner(String nombre){
        return control.addOwner(nombre);

    }


    public static void main(String[] args) {
        Interfez inter = new Interfez();
        inter.setVisible(true);
        }
}
