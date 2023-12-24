package BASIC.Project2;

import javax.swing.*;

public class PropertyDetailsPage extends JFrame {

    private JScrollPane mainPanel;
    private JPanel panel1;
    private JTabbedPane tabbedPane1;
    private JPanel prop;
    private JButton enterButton;
    private JLabel idLabel;
    private JTextField idField;
    private JTextArea textArea1;

    PropertyDetailsPage() {
        setContentPane(mainPanel);
        setTitle("Property Details");
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
        pack();

        enterButton.addActionListener(e -> {
            // check if something is entered
            if (idField.getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Please enter an ID");
                return;
            }
            // check if an integer is entered
            try {
                Integer.parseInt(idField.getText());
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(null, "Please enter an integer");
                return;
            }

            // check if property exists and display details
            textArea1.setText(BASIC.getPropertyDetails(Integer.parseInt(idField.getText())));

        });
    }

}
