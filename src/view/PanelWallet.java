package view;

import javax.swing.JButton;
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

    private JButton btnCargar;
    private JButton btnRetirar;

    private int activeUser;

    private Interfaz interfaz;

    public PanelWallet (Interfaz i) {

        super();
        setLayout(new GridLayout(5, 1));
        setBorder(new EmptyBorder(20, 20, 20, 10));
        interfaz = i;

        lblSaldo = new JLabel("Saldo:");
        lblId = new JLabel("ID:");
        lblTipo = new JLabel("Tipo:");

        btnCargar = new JButton("Cargar");
        btnRetirar = new JButton("Retirar");

        JPanel panelBotones = new JPanel();
        panelBotones.setLayout(new GridLayout(1, 2));
        panelBotones.add(btnCargar);
        panelBotones.add(btnRetirar);

        add(new JLabel("Wallet"));
        add(lblSaldo);
        add(lblId);
        add(lblTipo);
        add(panelBotones);
    }

    public void updateWallet(Wallet w) {
        lblSaldo.setText("Saldo: "+w.getSaldo());
        lblId.setText("ID: "+w.getId());
        setActiveUser(w.getId());
    }

    public int getActiveUser() {
        return activeUser;
    }

    public void setActiveUser(int activeUser) {
        this.activeUser = activeUser;
    }

    

}
