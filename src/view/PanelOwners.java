package view;

import javax.swing.JList;
import javax.swing.JPanel;

public class PanelOwners extends JPanel {
    
    private JList listaOwners;

    private Interfez interfez;
    
    public PanelOwners (Interfez inter) {
        super ();
        interfez = inter;

        String[] datos = {"uno" , "dos", "tres"};

        listaOwners = new JList<>(datos);

        add(listaOwners);


    }
}
