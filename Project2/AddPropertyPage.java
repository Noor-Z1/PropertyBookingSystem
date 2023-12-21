package BASIC.Project2;

import javax.swing.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class AddPropertyPage extends javax.swing.JFrame {


    private JPanel propPanel;
    private JScrollPane pane;
    private JRadioButton sharedButton;
    private JRadioButton fullButton;
    private JTextField idField;
    private JTextField roomsEntry;
    private JTextField roomsEntry2;
    private JTextField cityEntry;
    private JTextField priceEntry;
    private JTextField sizeEntry;
    private JLabel typeLabel;
    private JLabel idLabel;
    private JLabel roomsLabel;
    private JLabel rooms2;
    private JLabel cityLabel;
    private JLabel priceLabel;
    private JLabel sizeLabel;
    private JTextField hostIdEntry;
    private JButton submitButton;
    private JLabel hostIdlabel;

    private Property property;

    AddPropertyPage() {

        setContentPane(propPanel);
        setTitle("Add Property");
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        ButtonGroup buttonGroup = new ButtonGroup();
        buttonGroup.add(sharedButton);
        buttonGroup.add(fullButton);
        sizeLabel.setVisible(false);
        sizeEntry.setVisible(false);
        pane.setVisible(true);
        setVisible(true);
        pack();
        fullButton.addActionListener(e -> {
            sizeLabel.setVisible(true);
            sizeEntry.setVisible(true);

        });
        sharedButton.addActionListener(e -> {
            sizeLabel.setVisible(false);
            sizeEntry.setVisible(false);

        });

        submitButton.addActionListener(e -> {

            // check if any of the fields are empty
            if (idField.getText().isEmpty() || roomsEntry.getText().isEmpty() || cityEntry.getText().isEmpty() || priceEntry.getText().isEmpty() || hostIdEntry.getText().isEmpty() || !buttonGroup.getSelection().isSelected()) {
                JOptionPane.showMessageDialog(null, "Please fill in all the fields");
                return;
            }
            if (fullButton.isSelected() && sizeEntry.getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Please fill in all the fields");
                return;
            }

            // check if an integer is entered
            try {
                Integer.parseInt(idField.getText());
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(null, "Please enter an integer");
                return;
            }
            // check if an integer is entered
            try {
                Integer.parseInt(roomsEntry.getText());
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(null, "Please enter an integer for number of rooms");
                return;
            }
            // checks if rooms2 is also integer
            try {
                Integer.parseInt(roomsEntry2.getText());
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(null, "Please enter an integer for number of rooms");
                return;
            }

            // check if city is a string



            // check if price is a double
            try {
                Double.parseDouble(priceEntry.getText());
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(null, "Please enter a double/real value for price");

            }

            // check which property to create and create it
            if (sharedButton.isSelected()) {
                SharedProperty p = new SharedProperty();
                p.setPropertyId(Integer.parseInt(idField.getText()));
                p.setNoBedRooms(Integer.parseInt(roomsEntry.getText()));
                p.setNoRooms(Integer.parseInt(roomsEntry2.getText()));
                p.setCity(cityEntry.getText());
                p.setPricePerDay(Double.parseDouble(priceEntry.getText()));
                property = p;
            }
            else{
                FullProperty p = new FullProperty();
                p.setPropertyId(Integer.parseInt(idField.getText()));
                p.setNoBedRooms(Integer.parseInt(roomsEntry.getText()));
                p.setNoRooms(Integer.parseInt(roomsEntry2.getText()));
                p.setCity(cityEntry.getText());
                p.setPricePerDay(Double.parseDouble(priceEntry.getText()));
                p.setPropertySize(Double.parseDouble(sizeEntry.getText()));
                property = p;
            }

            // before adding property to mainframe, need to check if host id exists
            int id = Integer.parseInt(hostIdEntry.getText());
            if (!BASIC.checkUserExists(id)) {
                JOptionPane.showMessageDialog(null, "Host ID does not exist, Redirecting to Add Host Page");
                // redirect to add host page
                AddHostPage addHostPage = new AddHostPage(id);
                addHostPage.setAddPropertyPage(this);
                this.setVisible(false);

                // wait for other frame to close
                addHostPage.addWindowListener(new WindowAdapter() {
                    @Override
                    public void windowClosed(WindowEvent e) {
                        // check if the other frame's host is not null
                        setVisible(true);
                        if (addHostPage.getHost() != null) {
                            property.setHost(addHostPage.getHost());
                            System.out.println(property);
                            BASIC.properties.add(property);
                            JOptionPane.showMessageDialog(null, "Property added successfully");
                            dispose();
                        }
                        else {
                            JOptionPane.showMessageDialog(null, "You did not add a host! Please click submit and add a host");
                        }
                    }
                });
            }
            else{
                property.setHost((Host) (BASIC.getUser(id)));
                BASIC.properties.add(property);
                System.out.println(property);
                JOptionPane.showMessageDialog(null, "Property added successfully");
                dispose();
            }
        });

    }
}


