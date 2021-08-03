package view;

import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

import java.awt.GridLayout;

public class PanelOwners extends JPanel{
    
    private JList<String> listaOwners;

    private Interfaz interfaz;

    public PanelOwners (Interfaz inter) {
        super();
        setLayout(new GridLayout());
        setBorder(new TitledBorder(("Clientes")));
        interfaz = inter;

        // String[] datos = {"uno", "dos", "tres"};

        listaOwners = new JList<>();

        add(listaOwners);
    }

    public void updateList (String[] nombres) {
        listaOwners.setListData(nombres);
    }

}
