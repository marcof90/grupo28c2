package view;

import javax.swing.JFrame;
import java.awt.BorderLayout;

public class Interfaz extends JFrame{
    
    private PanelOpciones panelOpciones;

    public Interfaz(){
        super();

        setTitle("Wallet");
        setSize(500, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        this.panelOpciones = new PanelOpciones(this);

        add(panelOpciones, BorderLayout.SOUTH);
    }

    public static void main(String[] args) {
        Interfaz inter = new Interfaz();
        inter.setVisible(true);
    }

}
