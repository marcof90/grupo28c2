package view;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import model.Wallet;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PanelWallet extends JPanel implements ActionListener{
    
    private JLabel lblSaldo;
    private JLabel lblId;
    private JLabel lblTipo;

    private JButton btnCargar;
    private JButton btnRetirar;

    private int activeWallet;

    private Interfaz interfaz;

    public PanelWallet(Interfaz i) {
        super();
        setLayout(new GridLayout(5, 1));
        setBorder(new EmptyBorder(20, 20, 20, 10));
        
        interfaz = i;
        activeWallet = -1;

        lblSaldo = new JLabel("Saldo:");
        lblId = new JLabel("ID:");
        lblTipo = new JLabel("Tipo:");

        btnCargar = new JButton("Cargar");
        btnRetirar = new JButton("retirar");

        btnCargar.addActionListener(this);
        btnRetirar.addActionListener(this);

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
        setActiveWallet(w.getId());
    }

    public int getactiveWallet() {
        return activeWallet;
    }

    public void setActiveWallet(int activeWallet) {
        this.activeWallet = activeWallet;
    }

    public void cargarWallet() {
        String value = JOptionPane.showInputDialog(interfaz, "Digita la cantidad a cargar");
        try {
            int valueInt = Integer.parseInt(value);
            interfaz.insertTransaction(1, valueInt);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(interfaz, "Verifica los datos que ingresaste", 
            "Error en el dato ingresado", JOptionPane.ERROR_MESSAGE);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals(btnCargar.getActionCommand())) {
            cargarWallet();
        }
    }    

}
