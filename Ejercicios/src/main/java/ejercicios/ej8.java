package ejercicios;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;

public class ej8 {
    private Map<Integer, Character> mapa;
    private JFrame frame;
    private JTextField numeroField;
    private JTextField letraField;
    private JTextArea textArea;

    public ej8() {
        mapa = new HashMap<>();
        crearYMostrarGUI();
    }

    public void crearYMostrarGUI() {
        frame = new JFrame("Número a Letra");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(400, 300);
        frame.setLocationRelativeTo(null);

        JPanel panel = new JPanel(new GridLayout(3, 2));

        JLabel numeroLabel = new JLabel("Número:");
        numeroField = new JTextField();

        JLabel letraLabel = new JLabel("Letra:");
        letraField = new JTextField();

        JButton agregarButton = new JButton("Agregar");
        agregarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int numero = Integer.parseInt(numeroField.getText());
                char letra = letraField.getText().charAt(0);
                mapa.put(numero, letra);
                numeroField.setText("");
                letraField.setText("");
            }
        });

        JButton recuperarButton = new JButton("Recuperar");
        recuperarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int numero = Integer.parseInt(numeroField.getText());
                char letra = mapa.getOrDefault(numero, ' ');
                textArea.setText("La letra correspondiente al número " + numero + " es: " + letra);
            }
        });

        textArea = new JTextArea();
        textArea.setEditable(false);

        panel.add(numeroLabel);
        panel.add(numeroField);
        panel.add(letraLabel);
        panel.add(letraField);
        panel.add(agregarButton);
        panel.add(recuperarButton);

        frame.add(panel, BorderLayout.NORTH);
        frame.add(new JScrollPane(textArea), BorderLayout.CENTER);

        frame.setVisible(true);
    }
}
