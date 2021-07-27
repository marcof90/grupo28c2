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

    //crear atributos o relacion
    private JButton btnSaldo;
    private JButton btnCarga;


    //interfaz
    private Interfez interfez;


    public PanelOpciones(Interfez inter) {
        super();

        interfez = inter;

        setLayout(new GridLayout(1, 2));
        setBorder(new TitledBorder("Opciones"));

        //se inicializan
        btnSaldo = new JButton(BTN_SALDO);
        btnCarga = new JButton(BTN_CARGA);

        //se modifican las propiedades
        btnCarga.setActionCommand(BTN_CARGA); 
        btnSaldo.setActionCommand(BTN_SALDO);

        btnCarga.addActionListener(this);
        btnSaldo.addActionListener(this);

        //se agregan los botones 
        add(btnSaldo);
        add(btnCarga);


    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        if (e.getActionCommand().equals(BTN_SALDO)){
            //System.out.println("el saldo");
            JOptionPane.showMessageDialog(this, "el saldo es:","Tu saldo",JOptionPane.INFORMATION_MESSAGE);

        }else if (e.getActionCommand().equals(BTN_CARGA)){
            System.out.println("cargar saldo");
        }
        
    }

    
}
