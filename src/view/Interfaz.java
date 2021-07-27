package view;

import javax.swing.JFrame;
import java.awt.BorderLayout;

public class Interfaz extends JFrame {
    
    private PanelOpciones panelOpciones;

    public Interfaz() {
        super();
        setSize(500, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        //inicializar
        panelOpciones = new PanelOpciones(this);

        //modificar las propiedades

        //agregar
        add(panelOpciones, BorderLayout.SOUTH);
    }

    public static void main(String[] args) {
        Interfaz inter = new Interfaz();
        inter.setVisible(true);
    }

}
