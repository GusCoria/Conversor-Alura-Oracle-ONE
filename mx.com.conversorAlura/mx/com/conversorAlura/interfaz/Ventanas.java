package mx.com.conversorAlura.interfaz;

import javax.swing.*;

import mx.com.conversorAlura.conversor.ConversorMonedaLogic;
import mx.com.conversorAlura.conversor.ConversorTemperaturaLogic;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;

public class Ventanas extends JFrame implements ActionListener {

	private static final long serialVersionUID = 3528020562269692194L;
	private JComboBox<String> modoSeleccion;
    private JPanel panelConversion;
    
    // Componentes para el conversor de monedas
    private JComboBox<String> opcionesMoneda;
    private JTextField cantidadMonedaInput;
    private JLabel resultadoMonedaLabel;
    
    // Componentes para el conversor de temperatura
    private JComboBox<String> opcionesTemperatura;
    private JTextField cantidadTemperaturaInput;
    private JLabel resultadoTemperaturaLabel;

    public Ventanas() {
        // Configura la ventana principal
        setTitle("Conversor de Moneda y Temperatura");
        setSize(600, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);  // Centra la ventana en la pantalla

        // Crear un arreglo de opciones de modo
        String[] modos = {"Conversor de Moneda", "Conversor de Temperatura"};
        modoSeleccion = new JComboBox<>(modos);
        modoSeleccion.addActionListener(this);

        // Crear un panel para organizar los componentes de la ventana
        JPanel panelModo = new JPanel();
        panelModo.add(new JLabel("Selecciona el modo:"));
        panelModo.add(modoSeleccion);

        panelConversion = new JPanel();
        panelConversion.setLayout(new CardLayout());

        // Agregar componentes del conversor de monedas
        JPanel panelMoneda = new JPanel();
        panelMoneda.setLayout(new GridLayout(4, 2));
        String[] opcionesMonedaArray = {"Dólares estadounidenses (USD) -> Pesos (MXN)", 
            "Euros (EUR) -> Pesos (MXN)", "Libras esterlinas (GBP) -> Pesos (MXN)", 
            "Yenes japoneses (JPY) -> Pesos (MXN)","Won Coreano (KRW) -> Pesos (MXN)",
            "Pesos (MXN) -> Dólares estadounidenses (USD)","Pesos (MXN) -> Euros (EUR)",
            "Pesos (MXN) -> Libras esterlinas (GBP)","Pesos (MXN) -> Yenes japoneses (JPY)",
            "Pesos (MXN) -> Won Coreano (KRW)"};

        opcionesMoneda = new JComboBox<>(opcionesMonedaArray);
        cantidadMonedaInput = new JTextField(5);
        JButton botonMoneda = new JButton("Convertir");
        botonMoneda.addActionListener(this);
        JButton botonSalidaM = new JButton("Salir");
        botonSalidaM.addActionListener(this);
        resultadoMonedaLabel = new JLabel("");
    
        panelMoneda.add(new JLabel("Cantidad a convertir:"));
        panelMoneda.add(cantidadMonedaInput);
        panelMoneda.add(new JLabel("Selecciona la moneda:"));
        panelMoneda.add(opcionesMoneda);
        panelMoneda.add(new JLabel(""));
        panelMoneda.add(botonMoneda);
        panelMoneda.add(resultadoMonedaLabel);
        panelMoneda.add(botonSalidaM);

        // Agregar componentes del conversor de temperatura
        JPanel panelTemperatura = new JPanel();
        panelTemperatura.setLayout(new GridLayout(4, 2));
        String[] opcionesTemperaturaArray = {"Fahrenheit (°F) -> Celsius (°C)",
            "Kelvin (K) -> Celsius (°C)","Celsius (°C) -> Fahrenheit (°F)", "Celsius (°C) -> Kelvin (K)"};
        opcionesTemperatura = new JComboBox<>(opcionesTemperaturaArray);
        cantidadTemperaturaInput = new JTextField(10);
        JButton botonTemperatura = new JButton("Convertir");
        botonTemperatura.addActionListener(this);
        JButton botonSalidaT = new JButton("Salir");
        botonSalidaT.addActionListener(this);
        resultadoTemperaturaLabel = new JLabel("");

        panelTemperatura.add(new JLabel("Temperatura a convertir:"));
        panelTemperatura.add(cantidadTemperaturaInput);
        panelTemperatura.add(new JLabel("Selecciona la unidad:"));
        panelTemperatura.add(opcionesTemperatura);
        panelTemperatura.add(new JLabel(""));
        panelTemperatura.add(botonTemperatura);
        panelTemperatura.add(resultadoTemperaturaLabel);
        panelTemperatura.add(botonSalidaT);

        // Agregar los paneles de conversión al panel principal usando CardLayout
        panelConversion.add(panelMoneda, "Conversor de Moneda");
        panelConversion.add(panelTemperatura, "Conversor de Temperatura");

        // Agregar el panel de modo y el panel de conversión a la ventana principal
        getContentPane().setLayout(new BorderLayout());
        getContentPane().add(panelModo, BorderLayout.NORTH);
        getContentPane().add(panelConversion, BorderLayout.CENTER);
    }

    @Override
    public void actionPerformed(ActionEvent evento) {
        if (evento.getSource() == modoSeleccion) {
            // Cambia entre el conversor de monedas y el conversor de temperatura
            CardLayout cardLayout = (CardLayout) panelConversion.getLayout();
            String modoSeleccionado = (String) modoSeleccion.getSelectedItem();
            cardLayout.show(panelConversion, modoSeleccionado);
        } else if (evento.getActionCommand().equals("Convertir")) {
            try {
                if (panelConversion.getComponent(0).isVisible()) {
                    // Conversor de Moneda
                    double cantidad = Double.parseDouble(cantidadMonedaInput.getText());
                    String monedaSeleccionada = (String) opcionesMoneda.getSelectedItem();
                    ConversorMonedaLogic moneda = new ConversorMonedaLogic();
                    double resultado = moneda.realizarConversion(cantidad, monedaSeleccionada);
                    DecimalFormat df = new DecimalFormat("#.###");
                    resultadoMonedaLabel.setText("Resultado de la conversión: " + df.format(resultado));
                } else {
                    // Conversor de Temperatura
                    double temperatura = Double.parseDouble(cantidadTemperaturaInput.getText());
                    String unidadSeleccionada = (String) opcionesTemperatura.getSelectedItem();
                    ConversorTemperaturaLogic temp = new ConversorTemperaturaLogic();
                    double resultado = temp.realizarConversion(temperatura, unidadSeleccionada);
                    DecimalFormat df = new DecimalFormat("#.###");
                    resultadoTemperaturaLabel.setText("Resultado de la conversión: " + df.format(resultado));
                }
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Por favor, ingresa un numero valido.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }else if (evento.getActionCommand().equals("Salir")) {
            int opcion = JOptionPane.showConfirmDialog(this, "¿Deseas salir de la aplicación?", "Confirmar salida", JOptionPane.YES_NO_OPTION);
            if (opcion == JOptionPane.YES_OPTION) {
                System.exit(0);
            }
        }
    }
}