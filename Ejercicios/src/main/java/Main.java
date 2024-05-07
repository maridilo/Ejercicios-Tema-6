import ejercicios.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Main {
    private static final String EJERCICIO_1 = "Ejercicio 1";
    private static final String EJERCICIO_2 = "Ejercicio 2";
    private static final String EJERCICIO_3 = "Ejercicio 3";
    private static final String EJERCICIO_4 = "Ejercicio 4";
    private static final String EJERCICIO_5 = "Ejercicio 5";

    private static JLabel resultadoLabel;

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                crearYMostrarGUI();
            }
        });
    }

    public static void crearYMostrarGUI() {
        JFrame frame = new JFrame("Selección de Ejercicio");
        frame.setSize(500, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);

        JPanel panelPrincipal = new JPanel(new BoxLayout(frame.getContentPane(), BoxLayout.Y_AXIS));

        JPanel panelCentral = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.insets = new Insets(5, 5, 5, 5);

        panelPrincipal.setLayout(new BorderLayout());

        JComboBox<String> comboBox = new JComboBox<>();

        resultadoLabel = new JLabel();
        JScrollPane scrollPane = new JScrollPane(resultadoLabel);
        resultadoLabel.setHorizontalAlignment(SwingConstants.CENTER);

        JLabel tituloLabel = new JLabel("<html><h2>Selección de Ejercicio</h2></html>");
        tituloLabel.setHorizontalAlignment(SwingConstants.CENTER);
        panelPrincipal.add(scrollPane, BorderLayout.CENTER);

        JButton ejecutarButton = new JButton("Ejecutar");
        ejecutarButton.setHorizontalAlignment(SwingConstants.CENTER);
        ejecutarButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ejecutarEjercicioSeleccionado(comboBox.getSelectedItem());
            }
        });

        comboBox.addItem("Ejercicio 1");
        comboBox.addItem("Ejercicio 2");
        comboBox.addItem("Ejercicio 3");
        comboBox.addItem("Ejercicio 4");
        comboBox.addItem("Ejercicio 5");

        panelCentral.add(tituloLabel, gbc);
        gbc.gridy++;
        panelCentral.add(comboBox, gbc);
        gbc.gridy++;
        panelCentral.add(ejecutarButton, gbc);

        panelPrincipal.add(panelCentral, BorderLayout.NORTH);
        panelPrincipal.add(scrollPane, BorderLayout.CENTER);

        frame.getContentPane().add(panelPrincipal);
        frame.setVisible(true);
    }

    public static void ejecutarEjercicioSeleccionado(Object seleccion) {
        if (seleccion != null && seleccion instanceof String) {
            String ejercicio = (String) seleccion;
            switch (ejercicio) {
                case "Ejercicio 1":
                    ejecutarEjercicio1();
                    break;
                case "Ejercicio 2":
                    ejecutarEjercicio2();
                    break;
                case "Ejercicio 3":
                    String resultadoEj3 = ej3.ejecutarEjercicio3();
                    resultadoLabel.setText("<html>" + resultadoEj3.replace("\n", "<br>") + "</html>");
                    break;
                case "Ejercicio 4":
                    ejecutarEjercicio4();
                    break;
                case "Ejercicio 5":
                    ejecutarEjercicio5();
                    break;
                default:
                    resultadoLabel.setText("Ejercicio no encontrado");
            }
        }
    }

    public static void ejecutarEjercicio1() {
        ej1<Integer> parejaEnteros = new ej1<>(10, 20);
        ej1<String> parejaStrings = new ej1<>("Hola", "Mundo");

        String resultado = "<html>Primer entero: " + parejaEnteros.obtenerPrimero() + ", Segundo entero: "
                + parejaEnteros.obtenerSegundo() + "<br>Primer string: " + parejaStrings.obtenerPrimero()
                + ", Segundo string: " + parejaStrings.obtenerSegundo() + "</html>";

        resultadoLabel.setText(resultado);
    }

    public static void ejecutarEjercicio2() {
        // Crear una lista de datos reales
        List<Double> lista = new ArrayList<>();
        Random random = new Random();

        // Introducir 100 valores aleatorios en la lista
        for (int i = 0; i < 100; i++) {
            lista.add(random.nextDouble());
        }

        // Mostrar los valores por pantalla
        StringBuilder stringBuilder = new StringBuilder();
        for (Double valor : lista) {
            stringBuilder.append(valor).append("\n");
        }

        resultadoLabel.setText(stringBuilder.toString());
    }

    public static void ejecutarEjercicio3() {
        ej3.ejecutarEjercicio3();
    }

    public static void ejecutarEjercicio4() {
        ej4 ej4 = new ej4();
        ej4.crearYMostrarGUI();

        List<String> listaCadenas = ej4.obtenerListaCadenas();
        StringBuilder stringBuilder = new StringBuilder();
        for (String cadena : listaCadenas) {
            stringBuilder.append(cadena).append("\n");
        }

        resultadoLabel.setText(stringBuilder.toString());
    }

    public static void ejecutarEjercicio5() {
        ej5 ej5 = new ej5();
        ej5.crearYMostrarGUI();

        List<String> listaCadenas = ej5.obtenerListaCadenas();
        StringBuilder stringBuilder = new StringBuilder();
        for (String cadena : listaCadenas) {
            stringBuilder.append(cadena).append("\n");
        }

        resultadoLabel.setText(stringBuilder.toString());
    }
}

