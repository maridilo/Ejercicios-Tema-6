import javax.swing.*;
import java.awt.event.*;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                crearYMostrarGUI();
            }
        });
    }

    public static void crearYMostrarGUI() {
        JFrame frame = new JFrame("Selección de Ejercicio");
        frame.setSize(400,300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);

        JPanel panelPrincipal = new JPanel();
        JComboBox<String> comboBox = new JComboBox<>();
        JButton ejecutarButton = new JButton("Ejecutar");

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

        ejecutarButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String seleccion = (String) comboBox.getSelectedItem();
                switch (seleccion) {
                    case "Ejemplo 1":
                        ejecutarEjemplo1();
                        break;
                    // Agrega más casos aquí para otros ejemplos
                }
            }
        });

        panelPrincipal.add(comboBox);
        panelPrincipal.add(ejecutarButton);

        JPanel panel = new JPanel();
        JLabel labelEntero = new JLabel("Primer entero: 10, Segundo entero: 20");
        JLabel labelString = new JLabel("Primer string: Hola, Segundo string: Mundo");

        panel.add(labelEntero);
        panel.add(labelString);

        frame.getContentPane().add(panelPrincipal);
        frame.pack();
        frame.setVisible(true);
    }

    public static void ejecutarEjemplo1() {
        ej1<Integer> parejaEnteros = new ej1<>(10, 20);
        System.out.println("Primer entero: " + parejaEnteros.obtenerPrimero());
        System.out.println("Segundo entero: " + parejaEnteros.obtenerSegundo());

        ej1<String> parejaStrings = new ej1<>("Hola", "Mundo");
        System.out.println("Primer string: " + parejaStrings.obtenerPrimero());
        System.out.println("Segundo string: " + parejaStrings.obtenerSegundo());
    }

}

