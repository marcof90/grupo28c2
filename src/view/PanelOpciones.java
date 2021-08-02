package view;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import javax.swing.border.TitledBorder;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PanelOpciones extends JPanel implements ActionListener {

    public final static String BTN_SALDO = "Ver Saldo";
    public final static String BTN_CARGAR = "Cargar Saldo";
    public final static String BTN_AGREGAR = "Agregar cliente";
    public final static String BTN_LISTAR = "Listar clientes";

    //crear atributo o relación
    private JButton btnSaldo;
    private JButton btnCargar;
    private JButton btnAgregar;
    private JButton btnListar;

    //Interfaz
    private Interfaz interfaz;

    public PanelOpciones(Interfaz inter){
        super();

        interfaz = inter;

        setLayout(new GridLayout(1, 3));
        setBorder(new TitledBorder("Opciones"));

        //se inicializan
        btnSaldo = new JButton(BTN_SALDO);
        btnCargar = new JButton(BTN_CARGAR);
        btnAgregar = new JButton(BTN_AGREGAR);
        btnListar = new JButton(BTN_LISTAR);

        //se modifican las propiedades (opcional)
        btnListar.setActionCommand(BTN_LISTAR);
        btnAgregar.setActionCommand(BTN_AGREGAR);
        btnSaldo.setActionCommand(BTN_SALDO);
        btnCargar.setActionCommand(BTN_CARGAR);

        btnListar.addActionListener(this);
        btnAgregar.addActionListener(this);
        btnCargar.addActionListener(this);
        btnSaldo.addActionListener(this);

        //se agregan
        add(btnListar);
        add(btnAgregar);
        add(btnSaldo);
        add(btnCargar);

    }

    public void agregarCliente() {
        String nombre = JOptionPane.showInputDialog("Digite el nombre del cliente.");
            if (nombre != null && !nombre.trim().equalsIgnoreCase("")) {
                if(interfaz.addOwner(nombre)){
                    JOptionPane.showMessageDialog(interfaz, "Se agregó el ususario.");
                }else{
                    JOptionPane.showMessageDialog(interfaz, "No se pudo agregar el usuario.");
                }
            }else{
                JOptionPane.showMessageDialog(interfaz, "Revisa los datos.");
            }
    }

    public void listarOwners(){
        JOptionPane.showMessageDialog(interfaz, interfaz.listarOwners(), "Lstado de clientes", JOptionPane.PLAIN_MESSAGE);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        if (e.getActionCommand().equals(BTN_SALDO)) {
            JOptionPane.showMessageDialog(interfaz, "El saldo es: ", "Tu saldo", JOptionPane.INFORMATION_MESSAGE);
            // System.out.println("el saldo");
        }else if ((e.getActionCommand().equals(BTN_CARGAR))){
            System.out.println("Cargar");
        }else if(e.getActionCommand().equals(btnAgregar.getActionCommand())){
            String nombre = JOptionPane.showInputDialog("Digite el nombre del cliente.");
            if (nombre != null && !nombre.trim().equalsIgnoreCase("")) {
                if(interfaz.addOwner(nombre)){
                    JOptionPane.showMessageDialog(interfaz, "Se agregó el ususario.");
                }else{
                    JOptionPane.showMessageDialog(interfaz, "No se pudo agregar el usuario.");
                }
            }else{
                JOptionPane.showMessageDialog(interfaz, "Revisa los datos.");
            }

        }else if(e.getActionCommand().equals(BTN_LISTAR)){
            listarOwners();
        }
    }

}
