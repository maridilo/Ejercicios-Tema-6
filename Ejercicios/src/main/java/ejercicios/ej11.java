package ejercicios;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ej11 {
    private static JTextArea inputTextArea;
    private static JTextArea outputTextArea;

    public static void ordenarArchivo(String archivoSalida) {
        JFrame frame = new JFrame("Ordered Lines");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(500, 400);
        frame.setLocationRelativeTo(null);

        inputTextArea = new JTextArea(10, 40);
        outputTextArea = new JTextArea(10, 40);
        outputTextArea.setEditable(false);

        JButton ordenarButton = new JButton("Ordenar");
        ordenarButton.addActionListener(e -> {
            try {
                // Dividir el texto en líneas
                List<String> lineas = Arrays.asList(inputTextArea.getText().split("\\n"));

                // Ordenar las líneas
                Collections.sort(lineas);

                Path rutaSalida = Paths.get(archivoSalida);

                // Escribir las líneas ordenadas en el archivo de salida
                Files.write(rutaSalida, lineas);

                mostrarLineasOrdenadas(lineas);
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        });

        JPanel panel = new JPanel(new GridLayout(1, 3));
        panel.add(new JScrollPane(inputTextArea));
        panel.add(ordenarButton);
        panel.add(new JScrollPane(outputTextArea));

        frame.getContentPane().add(panel);
        frame.setVisible(true);
    }

    private static void mostrarLineasOrdenadas(List<String> lineas) {
        outputTextArea.setText("");
        for (String linea : lineas) {
            outputTextArea.append(linea + "\n");
        }
    }
}
