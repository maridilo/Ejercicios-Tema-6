package ejercicios;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.*;

public class ej4 {
    private static List<String> listaCadenas;
    private static final String OPCION_AGREGAR = "Agregar cadena";
    private static final String OPCION_ELIMINAR = "Eliminar última cadena";

    private static ej4 ej4 = new ej4();
    private static JList<String> listComponent;
    private static DefaultListModel<String> listModel;

    public static void crearYMostrarGUI() {
        JFrame frame = new JFrame("Lista de Cadenas");
        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setLocationRelativeTo(null);

        JPanel panelPrincipal = new JPanel(new BorderLayout());

        listModel = new DefaultListModel<>();
        listComponent = new JList<>(listModel);
        JScrollPane scrollPane = new JScrollPane(listComponent);

        JButton agregarButton = new JButton(OPCION_AGREGAR);
        agregarButton.addActionListener(e -> agregarCadena());

        JButton eliminarButton = new JButton(OPCION_ELIMINAR);
        eliminarButton.addActionListener(e -> eliminarUltimaCadena());

        JPanel panelBotones = new JPanel(new GridLayout(1, 2, 10, 10));
        panelBotones.add(agregarButton);
        panelBotones.add(eliminarButton);

        panelPrincipal.add(scrollPane, BorderLayout.CENTER);
        panelPrincipal.add(panelBotones, BorderLayout.SOUTH);

        frame.getContentPane().add(panelPrincipal);
        frame.setVisible(true);
    }

    public ej4() {
        listaCadenas = new ArrayList<>();
    }

    public void agregarCadena(String cadena) {
        if (cadena != null && !cadena.isEmpty()) {
            listaCadenas.add(cadena);
        }
    }

    public static void eliminarUltimaCadena() {
        if (!listaCadenas.isEmpty()) {
            listaCadenas.remove(listaCadenas.size() - 1);
        }
        actualizarLista();
    }

    public List<String> obtenerListaCadenas() {
        return listaCadenas;
    }

    private static void agregarCadena() {
        String cadena = JOptionPane.showInputDialog("Introduce una cadena:");
        ej4.agregarCadena(cadena);
        actualizarLista();
    }

    private static void actualizarLista() {
        listModel.clear();
        List<String> listaCadenas = ej4.obtenerListaCadenas();
        listaCadenas.forEach(listModel::addElement);
    }
}
