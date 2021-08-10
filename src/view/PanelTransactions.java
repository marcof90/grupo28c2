package view;

import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

import java.awt.GridLayout;

public class PanelTransactions extends JPanel{
    
    private Interfaz interfaz;

    private JList<String> listaTransacciones;

    public PanelTransactions (Interfaz i) {

        super();
        interfaz = i;
        setLayout(new GridLayout());
        setBorder(new TitledBorder("Transacciones"));
        listaTransacciones = new JList<>();

        add(listaTransacciones);
    }

    public void updateList(String[] listadoTransacciones) {
        listaTransacciones.setListData(listadoTransacciones);
    }
    
}
