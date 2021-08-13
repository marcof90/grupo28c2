package view;

import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.ListSelectionModel;
import javax.swing.border.TitledBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import java.awt.GridLayout;

public class PanelOwners extends JPanel implements ListSelectionListener{
    
    private int selectedIndex;

    private JList<String> listaOwners;

    private Interfaz interfaz;

    public PanelOwners(Interfaz inter) {
        super();
        setLayout(new GridLayout());
        setBorder(new TitledBorder("Clientes"));
        
        selectedIndex = -1;
        interfaz = inter;
        listaOwners = new JList<>();

        listaOwners.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        listaOwners.addListSelectionListener(this);

        add(listaOwners);
    }

    /**
     * metodo que retorna el indice seleccionado de la lista de owners
     * @return selectedIndex
     */
    public int getSelectedIndex() {
        return selectedIndex;
    }

    public void setSelectedIndex(int selectedIndex) {
        this.selectedIndex = selectedIndex;
    }

    public void updateList(String[] nombres) {
        listaOwners.setListData(nombres);
    }

    @Override
    public void valueChanged(ListSelectionEvent e) {
        // !false == true ... resultado true
        if(!e.getValueIsAdjusting()){
            setSelectedIndex(listaOwners.getSelectedIndex());
            interfaz.getWalletUser(selectedIndex);
        }        
    }


}
