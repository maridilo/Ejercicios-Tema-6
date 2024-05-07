package ejercicios;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.TreeSet;

public class ej10 {

    private static JTextArea textArea;
    private static JTextField nombreProductoField;
    private static JTextField nombreClienteField;
    private static JTextField precioTransaccionField;
    private static JTextField fechaTransaccionField;
    private static TreeSet<Venta> ventas = new TreeSet<>();

    public static void ejecutarEjercicio10() {
        nombreProductoField = new JTextField();
        nombreClienteField = new JTextField();
        precioTransaccionField = new JTextField();
        fechaTransaccionField = new JTextField();
        JButton addButton = new JButton("Add Sale");
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nombreProducto = nombreProductoField.getText();
                String nombreCliente = nombreClienteField.getText();
                double precioTransaccion = Double.parseDouble(precioTransaccionField.getText());
                LocalDate fechaTransaccion = LocalDate.parse(fechaTransaccionField.getText(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));
                Venta venta = new Venta(nombreProducto, nombreCliente, precioTransaccion, fechaTransaccion);
                ventas.add(venta);
                System.out.println("Venta añadida: " + venta);
                ventas.add(new Venta(nombreProducto, nombreCliente, precioTransaccion, fechaTransaccion));
                nombreProductoField.setText("");
                nombreClienteField.setText("");
                precioTransaccionField.setText("");
                fechaTransaccionField.setText("");
                updateTextArea();
            }
        });

        textArea = new JTextArea();
        textArea.setEditable(false);
        crearYMostrarGUI(addButton);
    }

    public static void updateTextArea() {
        StringBuilder sb = new StringBuilder();
        sb.append("Sales sorted by date, client name and transaction price:\n");
        for (Venta venta : ventas) {
            sb.append(venta).append("\n");
        }
        String text = sb.toString();
        System.out.println("Updating text area with: " + text);  // Print the text that will be set in the text area
        textArea.setText(text);
    }

    public static void crearYMostrarGUI(JButton addButton) {
        JFrame frame = new JFrame("Sales Records");
        frame.setSize(500, 400);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setLocationRelativeTo(null);

        JPanel panel = new JPanel(new GridLayout(5, 2));
        panel.add(new JLabel("Product Name:"));
        panel.add(nombreProductoField);
        panel.add(new JLabel("Client Name:"));
        panel.add(nombreClienteField);
        panel.add(new JLabel("Transaction Price:"));
        panel.add(precioTransaccionField);
        panel.add(new JLabel("Transaction Date (dd/MM/yyyy):"));
        panel.add(fechaTransaccionField);
        panel.add(addButton);

        frame.getContentPane().add(panel, BorderLayout.NORTH);
        frame.getContentPane().add(new JScrollPane(textArea), BorderLayout.CENTER);
        frame.setVisible(true);
    }
}

