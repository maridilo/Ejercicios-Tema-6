package ejercicios;

import javax.swing.*;
import java.awt.*;
import java.util.TreeSet;

public class ej6 {
    private TreeSet<String> cadenas;
    private DefaultListModel<String> listModel;

    public ej6() {
        cadenas = new TreeSet<>();
    }

    public void agregarCadena(String cadena) {
        if (cadena != null && !cadena.isEmpty()) {
            cadenas.add(cadena);
            actualizarLista();
        }
    }

    public void eliminarCadena(String cadena) {
        if (cadena != null && !cadena.isEmpty()) {
            cadenas.remove(cadena);
            actualizarLista();
        }
    }

    private void actualizarLista() {
        listModel.clear();
        for (String cadena : cadenas) {
            listModel.addElement(cadena);
        }
    }

    public void crearYMostrarGUI() {
        JFrame frame = new JFrame("Lista de Cadenas");
        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setLocationRelativeTo(null);

        JPanel panelPrincipal = new JPanel(new BorderLayout());

        listModel = new DefaultListModel<>();
        JList<String> listComponent = new JList<>(listModel);
        JScrollPane scrollPane = new JScrollPane(listComponent);

        JButton agregarButton = new JButton("Agregar cadena");
        agregarButton.addActionListener(e -> {
            String cadena = JOptionPane.showInputDialog("Introduce una cadena:");
            agregarCadena(cadena);
        });

        JButton eliminarButton = new JButton("Eliminar cadena");
        eliminarButton.addActionListener(e -> {
            String cadena = JOptionPane.showInputDialog("Introduce la cadena a eliminar:");
            eliminarCadena(cadena);
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
