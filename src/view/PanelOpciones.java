package view;

import java.awt.GridLayout;
import javax.swing.border.TitledBorder;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class PanelOpciones extends JPanel implements ActionListener {

    public final static String BTN_SALDO = "ver saldo";
    public final static String BTN_CARGA = "Cargar Saldo";
    public final static String BTN_AGREGAR = "Agregar Cliente";
    public final static String BTN_LISTAR =  "Listar clientes";
    
    //crear atributos o relacion
    private JButton btnSaldo;
    private JButton btnCarga;
    private JButton btnAgregar;
    private JButton btnListar;



    //interfaz
    private Interfez interfez;


    public PanelOpciones(Interfez inter) {
        super();

        interfez = inter;

        setLayout(new GridLayout(1, 4));
        setBorder(new TitledBorder("Opciones"));

        //se inicializan
        btnSaldo = new JButton(BTN_SALDO);
        btnCarga = new JButton(BTN_CARGA);
        btnAgregar = new JButton(BTN_AGREGAR);
        btnListar = new JButton(BTN_LISTAR);



        //se modifican las propiedades
        btnAgregar.setActionCommand(BTN_AGREGAR);
        btnCarga.setActionCommand(BTN_CARGA); 
        btnSaldo.setActionCommand(BTN_SALDO);
        btnListar.setActionCommand(BTN_LISTAR);

        btnAgregar.addActionListener(this);
        btnCarga.addActionListener(this);
        btnSaldo.addActionListener(this);
        btnListar.addActionListener(this);

        //se agregan los botones 
        add(btnAgregar);
        add(btnSaldo);
        add(btnCarga);
        add(btnListar);


    }
    public void agregarCliente() {
        String nombre = JOptionPane.showInputDialog("Digite el nombre del cliente");
            if (nombre != null && !nombre.trim().equalsIgnoreCase("")) {
               if (interfez.addOwner(nombre)){
                    JOptionPane.showMessageDialog(interfez, "Se agrego el usuario");
                }else{
                    JOptionPane.showMessageDialog(interfez, "No se pudo agregar usuario");
                }
             
            }else{
                JOptionPane.showMessageDialog(interfez,"Revisa los datos");
            }
    }

    public void listarOwners(){
        JOptionPane.showMessageDialog(interfez, interfez.listrOwners(),"listados de clientes",JOptionPane.INFORMATION_MESSAGE);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        if (e.getActionCommand().equals(BTN_SALDO)){
            //System.out.println("el saldo");
            JOptionPane.showMessageDialog(this, "el saldo es:","Tu saldo",JOptionPane.INFORMATION_MESSAGE);

        }else if (e.getActionCommand().equals(BTN_CARGA)){
            System.out.println("cargar saldo");
        }else if (e.getActionCommand().equals(btnAgregar.getActionCommand())){
           agregarCliente(); 
        }else if (e.getActionCommand().equals(BTN_LISTAR)) {
           listarOwners(); 
        }
        
    }

    
}
