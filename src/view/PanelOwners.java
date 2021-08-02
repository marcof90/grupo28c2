package view;

import javax.swing.JList;
import javax.swing.JPanel;

public class PanelOwners extends JPanel{
    
    private JList listaOwners;

    private Interfaz interfaz;

    public PanelOwners(Interfaz inter) {
        super();
        interfaz = inter;

        String[] datos = {"uno", "dos", "tres"};

        listaOwners = new JList<>(datos);

        add(listaOwners);
    }

}
