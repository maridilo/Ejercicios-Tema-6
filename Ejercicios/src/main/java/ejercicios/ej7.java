package ejercicios;

import javax.swing.*;
import java.awt.*;
import java.util.Map;

public class ej7 {
    private Map<String, Integer> mapa;
    private JTextArea textArea;

    public ej7() {
        mapa = new java.util.HashMap<>();
        mapa.put("cero", 0);
        mapa.put("uno", 1);
        mapa.put("dos", 2);
        mapa.put("tres", 3);
        mapa.put("cuatro", 4);
        mapa.put("cinco", 5);
        mapa.put("seis", 6);
        mapa.put("siete", 7);
        mapa.put("ocho", 8);
        mapa.put("nueve", 9);
        mapa.put("diez", 10);
    }

    public void listarContenido() {
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<String, Integer> entrada : mapa.entrySet()) {
            sb.append(entrada.getKey()).append(": ").append(entrada.getValue()).append("\n");
            textArea.setText(sb.toString());
        }
    }
        public void crearYMostrarGUI() {
            JFrame frame = new JFrame("Lista de Números");
            frame.setSize(400, 300);
            frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            frame.setLocationRelativeTo(null);

            textArea = new JTextArea();
            textArea.setEditable(false);
            JScrollPane scrollPane = new JScrollPane(textArea);

            frame.getContentPane().add(scrollPane);
            frame.setVisible(true);

            listarContenido();
        }
    }
