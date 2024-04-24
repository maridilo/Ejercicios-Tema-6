import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

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
        frame.setSize(500,400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);

        JPanel panelPrincipal = new JPanel();
        panelPrincipal.setLayout(new BorderLayout());

        JPanel panelCentral = new JPanel(new GridLayout(3, 1, 10, 10));
        JComboBox<String> comboBox = new JComboBox<>();
        resultadoLabel = new JLabel();
        resultadoLabel.setHorizontalAlignment(SwingConstants.CENTER);

        JLabel tituloLabel = new JLabel("<html>Una pareja de datos puede contener dos valores de cualquier tipo.</html>");
        tituloLabel.setHorizontalAlignment(SwingConstants.CENTER);

        JButton ejecutarButton = new JButton("Ejecutar");
        ejecutarButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ejecutarEjemploSeleccionado(comboBox.getSelectedItem());
            }
        });

        comboBox.addItem("Ejemplo 1");
        comboBox.addItem("Ejemplo 2");
        comboBox.addItem("Ejemplo 3");
        comboBox.addItem("Ejemplo 4");
        comboBox.addItem("Ejemplo 5");
        comboBox.addItem("Ejemplo 6");
        comboBox.addItem("Ejemplo 7");
        comboBox.addItem("Ejemplo 8");
        comboBox.addItem("Ejemplo 9");
        comboBox.addItem("Ejemplo 10");
        comboBox.addItem("Ejemplo 11");
        comboBox.addItem("Ejemplo 12");

        panelCentral.add(comboBox);
        panelCentral.add(tituloLabel);
        panelCentral.add(ejecutarButton);

        panelPrincipal.add(panelCentral, BorderLayout.NORTH);
        panelPrincipal.add(resultadoLabel, BorderLayout.CENTER);

        frame.getContentPane().add(panelPrincipal);
        frame.setVisible(true);
    }

    public static void ejecutarEjemploSeleccionado(Object seleccion) {
        if (seleccion != null && seleccion instanceof String) {
            String ejemplo = (String) seleccion;
            switch (ejemplo) {
                case "Ejemplo 1":
                    ejecutarEjemplo1();
                    break;
                // Agrega más casos aquí para otros ejemplos
                default:
                    resultadoLabel.setText("Ejemplo no encontrado");
            }
        }
    }


    public static void ejecutarEjemplo1() {
        ej1<Integer> parejaEnteros = new ej1<>(10, 20);
        ej1<String> parejaStrings = new ej1<>("Hola", "Mundo");

        String resultado = "<html>Primer entero: " + parejaEnteros.obtenerPrimero() + ", Segundo entero: "
                + parejaEnteros.obtenerSegundo() + "<br>Primer string: " + parejaStrings.obtenerPrimero()
                + ", Segundo string: " + parejaStrings.obtenerSegundo() + "</html>";

        resultadoLabel.setText(resultado);
        }
    }

