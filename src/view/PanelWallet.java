package view;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

import model.Wallet;

import java.awt.GridLayout;

public class PanelWallet extends JPanel{
    
    private JLabel lblSaldo;
    private JLabel lblId;
    private JLabel lblTipo;

    private Interfaz interfaz;

    public PanelWallet(Interfaz i) {
        super();
        setLayout(new GridLayout(4, 1));
        setBorder(new EmptyBorder(20, 20, 10, 10));
        interfaz = i;

        lblSaldo = new JLabel("Saldo:");
        lblId = new JLabel("ID:");
        lblTipo = new JLabel("Tipo:");

        add(new JLabel("Wallet"));
        add(lblSaldo);
        add(lblId);
        add(lblTipo);
    }

    public void updateWallet(Wallet w) {
        lblSaldo.setText("Saldo: "+w.getSaldo());
        lblId.setText("ID: "+w.getId());
    }

}
