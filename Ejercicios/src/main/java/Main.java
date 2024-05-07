import ejercicios.*;
import ejercicios.ej3;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Main {
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
        comboBox.addItem("Ejercicio 6");
        comboBox.addItem("Ejercicio 7");
        comboBox.addItem("Ejercicio 8");
        comboBox.addItem("Ejercicio 9");
        comboBox.addItem("Ejercicio 10");
        comboBox.addItem("Ejercicio 11");
        comboBox.addItem("Ejercicio 12");

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
        if (seleccion instanceof String) {
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
                case "Ejercicio 6":
                    ejecutarEjercicio6();
                    break;
                case "Ejercicio 7":
                    ejecutarEjercicio7();
                    break;
                case "Ejercicio 8":

                    break;
                case "Ejercicio 9":

                    break;
                case "Ejercicio 10":

                    break;
                case "Ejercicio 11":

                    break;
                case "Ejercicio 12":

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

    public static void ejecutarEjercicio6() {
        ej6 ej6 = new ej6();
        ej6.crearYMostrarGUI();
    }

    public static void ejecutarEjercicio7() {
        ej7 ej7 = new ej7();
        ej7.crearYMostrarGUI();
        ej7.listarContenido();
    }
}


