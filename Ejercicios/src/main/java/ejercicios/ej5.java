package ejercicios;

import java.util.ArrayList;
import java.util.List;
import javax.swing.*;
import java.awt.*;

public class ej5 {

    private List<String> listaCadenas;
    private static DefaultListModel<String> listModel;
    private static JList<String> listComponent;

    public ej5() {
        listaCadenas = new ArrayList<>();
    }

    public void agregarCadena(int posicion, String cadena) {
        if (cadena != null && !cadena.isEmpty() && posicion >= 0 && posicion <= listaCadenas.size()) {
            listaCadenas.add(posicion, cadena);
        }
    }

    public void eliminarCadena(int posicion) {
        if (posicion >= 0 && posicion < listaCadenas.size()) {
            listaCadenas.remove(posicion);
        }
    }

    public List<String> obtenerListaCadenas() {
        return listaCadenas;
    }

    private void actualizarLista() {
        listModel.clear();
        List<String> listaCadenas = obtenerListaCadenas();
        listaCadenas.forEach(listModel::addElement);
    }

    public void crearYMostrarGUI() {
        listaCadenas = new ArrayList<>();

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
            String posicionStr = JOptionPane.showInputDialog("Introduce la posición:");
            int posicion = Integer.parseInt(posicionStr);
            SwingWorker<Void, Void> worker = new SwingWorker<Void, Void> () {
                @Override
                protected Void doInBackground() throws Exception {
                    agregarCadena(posicion, cadena);
                    return null;
                }
            @Override
            protected void done() {
                actualizarLista();
            }
        };
        worker.execute();
    });

        JButton eliminarButton = new JButton("Eliminar cadena");
        eliminarButton.addActionListener(e -> {
            String posicionStr = JOptionPane.showInputDialog("Introduce la posición de la cadena a eliminar:");
            int posicion = Integer.parseInt(posicionStr);
            SwingWorker<Void, Void> worker = new SwingWorker<Void, Void>() {
                @Override
                protected Void doInBackground() throws Exception {
                    eliminarCadena(posicion);
                    return null;
                }

                @Override
                protected void done() {
                    actualizarLista();
                }
            };
            worker.execute();
        });

        JPanel panelBotones = new JPanel(new GridLayout(1, 2, 10, 10));
        panelBotones.add(agregarButton);
        panelBotones.add(eliminarButton);

        panelPrincipal.add(scrollPane, BorderLayout.CENTER);
        panelPrincipal.add(panelBotones, BorderLayout.SOUTH);

        frame.getContentPane().add(panelPrincipal);
        frame.setVisible(true);

        listaCadenas = new ArrayList<>();
    }
}
