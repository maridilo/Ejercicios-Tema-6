package ejercicios;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class ej5 {

    private static List<String> listaCadenas;
    private static DefaultListModel<String> listModel;

    public ej5() {
        listaCadenas = new ArrayList<>();
        listModel = new DefaultListModel<>();
    }

    public void agregarCadena(int posicion, String cadena) {
        if (cadena != null && !cadena.isEmpty() && posicion >= 0 && posicion <= listaCadenas.size()) {
            listaCadenas.add(posicion, cadena);
            actualizarLista();
        }
    }

    public void eliminarCadena(int posicion) {
        if (posicion >= 0 && posicion < listaCadenas.size()) {
            listaCadenas.remove(posicion);
            actualizarLista();
        }
    }

    public static List<String> obtenerListaCadenas() {
        return listaCadenas;
    }

    private void actualizarLista() {
        listModel.clear();
        for (String cadena : listaCadenas) {
            listModel.addElement(cadena);
        }
    }

    public void crearYMostrarGUI() {
        JFrame frame = new JFrame("Lista de Cadenas");
        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setLocationRelativeTo(null);

        JPanel panelPrincipal = new JPanel(new BorderLayout());

        JList<String> listComponent = new JList<>(listModel);
        JScrollPane scrollPane = new JScrollPane(listComponent);

        JButton agregarButton = new JButton("Agregar cadena");
        agregarButton.addActionListener(e -> {
            String cadena = JOptionPane.showInputDialog("Introduce una cadena:");
            String posicionStr = JOptionPane.showInputDialog("Introduce la posición:");
            int posicion = Integer.parseInt(posicionStr); // Línea 58
            SwingUtilities.invokeLater(() -> agregarCadena(posicion, cadena));
        });

        JButton eliminarButton = new JButton("Eliminar cadena");
        eliminarButton.addActionListener(e -> {
            String posicionStr = JOptionPane.showInputDialog("Introduce la posición de la cadena a eliminar:");
            int posicion = Integer.parseInt(posicionStr);
            SwingUtilities.invokeLater(() -> eliminarCadena(posicion));
        });

        JPanel panelBotones = new JPanel(new GridLayout(1, 2, 10, 10));
        panelBotones.add(agregarButton);
        panelBotones.add(eliminarButton);

        panelPrincipal.add(scrollPane, BorderLayout.CENTER);
        panelPrincipal.add(panelBotones, BorderLayout.SOUTH);

        frame.getContentPane().add(panelPrincipal);
        frame.setVisible(true);
    }
}

