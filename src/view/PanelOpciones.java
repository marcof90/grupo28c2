package view;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class PanelOpciones extends JPanel implements ActionListener {

    public static final String  BTN_SALDO = "Ver Saldo";
    public static final String  BTN_CARGAR = "Cargar";
    public static final String  BTN_AGREGAR = "Agregar";


    private JButton btnSaldo;
    private JButton btnCargar;
    private JButton btnAgregar;

    
    private Interfaz interfaz;


    public PanelOpciones(Interfaz inter){
        super();
     
        this.interfaz = inter;

        setLayout(new GridLayout(1,2));
        setBorder(new TitledBorder("Opciones"));

        this.btnSaldo = new JButton(BTN_SALDO);
        this.btnAgregar = new JButton(BTN_AGREGAR);
        this.btnCargar = new JButton(BTN_CARGAR);

        btnSaldo.setActionCommand(BTN_SALDO);
        btnAgregar.setActionCommand(BTN_AGREGAR);
        btnCargar.setActionCommand(BTN_CARGAR);


        btnSaldo.addActionListener(this);
        btnAgregar.addActionListener(this);
        btnCargar.addActionListener(this);

        //btnCargar.addActionListener();

        add(btnSaldo);
        add(btnAgregar);
        add(btnCargar);
    }

    private void agregarCliente(){
        String nombre = JOptionPane.showInputDialog("Digite el nombre del cliente");
        if (interfaz.addOwner(nombre)){
            JOptionPane.showMessageDialog(interfaz, "Se agregó el usuario");
        }else{
            JOptionPane.showMessageDialog(interfaz, "No se pudo agregar el usuario");
        }
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals(BTN_SALDO)) {
            JOptionPane.showMessageDialog(interfaz, "El saldo es: ", "Tu saldo", JOptionPane.INFORMATION_MESSAGE);
            // System.out.println("El saldo");
        }
        else if (e.getActionCommand().equals(BTN_AGREGAR)){
            agregarCliente();
        }
        else if (e.getActionCommand().equals(BTN_CARGAR)){
            System.out.println("Cargar");
        }
    }


}
