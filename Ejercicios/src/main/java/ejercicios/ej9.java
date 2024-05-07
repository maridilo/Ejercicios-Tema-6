package ejercicios;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.TreeSet;

public class ej9 {

    private static JTextArea textArea;
    private static JTextField firstNameField;
    private static JTextField lastNameField;
    private static TreeSet<Persona> people = new TreeSet<>();

    public static void ejecutarEjercicio9() {
        firstNameField = new JTextField();
        lastNameField = new JTextField();
        JButton addButton = new JButton("Add Person");
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String firstName = firstNameField.getText();
                String lastName = lastNameField.getText();
                people.add(new Persona(firstName, lastName));
                firstNameField.setText("");
                lastNameField.setText("");
                updateTextArea();
            }
        });

        textArea = new JTextArea();
        textArea.setEditable(false);
        crearYMostrarGUI(addButton);
    }

    public static void updateTextArea() {
        StringBuilder sb = new StringBuilder();
        sb.append("People sorted by last name:\n");
        for (Persona persona : people) {
            sb.append(persona).append("\n");
        }
        textArea.setText(sb.toString());
    }

    public static void crearYMostrarGUI(JButton addButton) {
        JFrame frame = new JFrame("Sorted People");
        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setLocationRelativeTo(null);

        JPanel panel = new JPanel(new GridLayout(3, 2));
        panel.add(new JLabel("First Name:"));
        panel.add(firstNameField);
        panel.add(new JLabel("Last Name:"));
        panel.add(lastNameField);
        panel.add(addButton);

        frame.getContentPane().add(panel, BorderLayout.NORTH);
        frame.getContentPane().add(new JScrollPane(textArea), BorderLayout.CENTER);
        frame.setVisible(true);
    }
}