package iva;

import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Iva extends JFrame implements ActionListener {

    private JLabel mensaje;
    private JButton boton;
    private JTextField caja;

    public String selectIva;

    public Iva() {
        super();
        configurarVentana();
        crearComponentes();
    }

    private void configurarVentana() {
        this.setTitle("Calculadora de IVA");
        this.setSize(500, 400);
        this.setLocationRelativeTo(null);
        this.setLayout(null);
        this.setResizable(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

    private void crearComponentes() {
        mensaje = new JLabel();
        mensaje.setText("Ingrese la cantidad a calcular");
        mensaje.setBounds(165, 75, 170, 70);
        mensaje.setForeground(Color.BLACK);

        this.add(mensaje);

        boton = new JButton();
        boton.setText("Clickeame");
        boton.setBounds(80, 210, 300, 30);
        boton.addActionListener(this);
        this.add(boton);

        caja = new JTextField();
        caja.setBounds(170, 120, 100, 30);
        this.add(caja);

        String[] ivaList = new String[]{"IVA", "16", "8"};
        JComboBox<String> iva = new JComboBox<>(ivaList);
        iva.setBounds(170, 160, 100 , 25);
        iva.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                selectIva = iva.getItemAt(iva.getSelectedIndex());
            }
        });
        this.add(iva);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String resultado = caja.getText();
        double dato = Double.parseDouble(resultado);
        String resultado2 = selectIva;
        double dato2 = Double.parseDouble(resultado2);
        double total = dato * (dato2 / 100);
        double ivaT = dato + total;
        String ivaTotal = Double.toString(ivaT);
        JOptionPane.showMessageDialog(this, "el valor es: " + ivaTotal);
    }

    public static void main(String[] args) {
        Iva ventana = new Iva();
        ventana.setVisible(true);
    }

}
