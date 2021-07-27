package view;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PanelOpciones extends JPanel implements ActionListener{
    
    public final static String BTN_SALDO = "Ver Saldo";
    public final static String BTN_CARGAR = "Cargar Saldo";

    //crear atributo o relacion
    private JButton btnSaldo;
    private JButton btnCargar;

    //Interfaz
    private Interfaz interfaz;

    public PanelOpciones(Interfaz inter) {
        super();

        interfaz = inter;

        setLayout(new GridLayout(1, 2));
        setBorder(new TitledBorder("Opciones"));
        //se inicializan
        btnSaldo = new JButton(BTN_SALDO);
        btnCargar = new JButton(BTN_CARGAR);

        //se modifican las propiedades (opcional)
        btnSaldo.setActionCommand(BTN_SALDO);
        btnCargar.setActionCommand(BTN_CARGAR);

        btnCargar.addActionListener(this);
        btnSaldo.addActionListener(this);

        //se agregan
        add(btnSaldo);
        add(btnCargar);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        if (e.getActionCommand().equals(BTN_SALDO)) {
            JOptionPane.showMessageDialog(interfaz, "El saldo es:", "Tu saldo", JOptionPane.INFORMATION_MESSAGE);
            // System.out.println("el saldo");
        }else if(e.getActionCommand().equals(BTN_CARGAR)){
            System.out.println("Cargar");
        }
    }

}
