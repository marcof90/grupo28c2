package view;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import Controller.Controlador;

import java.awt.BorderLayout;
import java.awt.GridLayout;

public class Interfaz extends JFrame{
    
    //se crea el atributo o relacion
    private PanelOpciones panelOpciones;
    private PanelOwners panelOwners;
    private PanelWallet panelWallet;
    private PanelTransactions panelTransactions;

    private Controlador control;

    public Interfaz() {
        super();
        setSize(700, 400);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        setTitle("Wallet");

        //inicializar
        panelOpciones = new PanelOpciones(this);
        panelOwners = new PanelOwners(this);
        panelWallet = new PanelWallet(this);
        panelTransactions = new PanelTransactions(this);

        JPanel panelCentro = new JPanel();
        panelCentro.setLayout(new GridLayout(1, 3));
        panelCentro.add(panelOwners);
        panelCentro.add(panelWallet);
        panelCentro.add(panelTransactions);
        control = new Controlador();
        //modificar las propiedades
        
        //agregar
        add(panelOpciones, BorderLayout.SOUTH);
        add(panelCentro, BorderLayout.CENTER);
        updateList();
    }

    public boolean addOwner(String nombre) {
        return control.addOwner(nombre);            
    }

    public String listarOwners(){
        return control.listarOwners();
    }

    public void updateList(){
        panelOwners.updateList(control.getDataOwners());
    }

    public void getWalletUser(int id) {
        panelWallet.updateWallet(control.getWalletUser(id).getWallet());
        fillTransactionsData(id);
    }

    public void fillTransactionsData(int id){
        control.fillTransactionsData(id, control.getOwners().get(id).getWallet().getId());
        updateListTransactions(id);
    }

    public void updateListTransactions(int id) {
        panelTransactions.updateList(control.getDataTransaccions(id));
    }

    public void updateSaldoWallet(int amount) {
        control.updateSaldoWallet(amount+control.getOwners().get(panelOwners.getSelectedIndex()).getWallet().getSaldo(), 
        control.getOwners().get(panelOwners.getSelectedIndex()).getWallet().getId());
    }

    public void insertTransaction(int type, int value) {
        System.out.println(panelWallet.getactiveWallet());
        if (panelWallet.getactiveWallet()==-1) {
            JOptionPane.showMessageDialog(this, "Debes seleccionar un usuario de la lista");
        }else{
            control.insertTransaction(value, type, panelWallet.getactiveWallet());
            updateSaldoWallet(value);
            getWalletUser(panelOwners.getSelectedIndex());
        }
    }

    public static void main(String[] args) {
        Interfaz inter = new Interfaz();
        inter.setVisible(true);
    }
}
