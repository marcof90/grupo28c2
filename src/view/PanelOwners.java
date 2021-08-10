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

    public PanelOwners (Interfaz inter) {
        super();
        setLayout(new GridLayout());
        setBorder(new TitledBorder(("Clientes")));

        selectedIndex = -1;
        interfaz = inter;

        // String[] datos = {"uno", "dos", "tres"};

        listaOwners = new JList<>();

        listaOwners.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        listaOwners.addListSelectionListener(this);

        add(listaOwners);
    }

    public int getSelectedIndex() {
        return selectedIndex;
    }

    public void setSelectedIndex(int selectedIndex) {
        this.selectedIndex = selectedIndex;
    }

    public void updateList (String[] nombres) {
        listaOwners.setListData(nombres);
    }

    @Override
    public void valueChanged(ListSelectionEvent e) {
        //!false == true ... resultado  true
        if (!e.getValueIsAdjusting()) {
            System.out.println(listaOwners.getSelectedIndex());
            setSelectedIndex(listaOwners.getSelectedIndex());
            interfaz.getWalletUser(selectedIndex);
            // System.out.println(listaOwners.getSelectedValue());
        }
    }

}
