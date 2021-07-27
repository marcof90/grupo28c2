package view;

import java.awt.BorderLayout;

import javax.swing.JFrame;

//import org.graalvm.compiler.replacements.nodes.CStringConstant;


public class Interfez extends JFrame{

    private PanelOpciones panelOpciones;

    public Interfez() {
        super();
        setSize(500, 400); //tamaño de la ventana
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        //inicializar 
        panelOpciones = new PanelOpciones(this);

        //modificar 

        //agregar 
        add(panelOpciones, BorderLayout.SOUTH);

    }

    public static void main(String[] args) {
        Interfez inter = new Interfez();
        inter.setVisible(true);
        }
}
