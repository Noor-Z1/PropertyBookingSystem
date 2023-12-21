package BASIC.Project2;

import javax.swing.*;

public class AddInspectiontoPropertyPage extends JFrame {

    private JPanel inspPanel;
    private JTabbedPane tabbedPane1;
    private JPanel addInsp;
    private JLabel idLabel;
    private JTextField idEntry;
    private JLabel inspectionLabel;
    private JTextField inspectionField;
    private JButton addButton;


    AddInspectiontoPropertyPage() {
        setContentPane(inspPanel);
        setTitle("Add Inspection to Property");
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        pack();
        setVisible(true);

        addButton.addActionListener(e -> {
            // check if something is entered
            if (idEntry.getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Please enter an ID");
                return;
            }
            // check if an integer is entered
            try {
                Integer.parseInt(idEntry.getText());
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(null, "Please enter an integer");
                return;
            }

            if(inspectionField.getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Please enter an inspection");
                return;
            }

            // check if a string message which can have spaces is entered in the inspectionField
            if (!inspectionField.getText().matches("[a-zA-Z0-9 ]+")) {
                JOptionPane.showMessageDialog(null, "Please enter a string message");
                return;
            }

            // check if property exists
            if (!BASIC.checkPropertyExists(Integer.parseInt(idEntry.getText()))) {
                JOptionPane.showMessageDialog(null, "Property with ID " + idEntry.getText() + " does not exist");
                return;
            }

            // now add the inspection to the property
            BASIC.addInspectionToProperty(Integer.parseInt(idEntry.getText()), inspectionField.getText());
            JOptionPane.showMessageDialog(null, "Inspection added successfully");
            dispose();
        });

    }

}
