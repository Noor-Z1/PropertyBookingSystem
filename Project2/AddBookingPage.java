package BASIC.Project2;

import javax.swing.*;
import java.util.ArrayList;

public class AddBookingPage extends JFrame {
    private JComboBox<String> customerComboBox;
    private JComboBox<String> propertyComboBox;
    private JTextField dateEntry1;
    private JTextField dateEntry2;
    private JPanel mainPanel;
    private JScrollPane scrollPane;
    private JLabel customerLabel;
    private JLabel propertyLabel;
    private JLabel dateLabel1;
    private JLabel dateLable2;
    private JButton addButton;

    AddBookingPage() {
        setContentPane(scrollPane);
        setTitle("Add Booking");
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(500, 400);
        setVisible(true);

        ArrayList<Integer> customer_list = new ArrayList<>();
        ArrayList<Integer> property_list = new ArrayList<>();

        for (User u : BASIC.users) {
            if (u instanceof Customer) {
                customerComboBox.addItem(((Customer) u).getFirstName() + " " + ((Customer) u).getLastName());
                customer_list.add(((Customer) u).getUserId());
            }
        }
        if (customerComboBox.getItemCount() == 0) {
            JOptionPane.showMessageDialog(null, "No customers found");
            dispose();
        }
        for (Property p : BASIC.properties) {
            propertyComboBox.addItem(p.getPropertyId() + " " + p.getCity());
            property_list.add(p.getPropertyId());
        }

        addButton.addActionListener(e -> {
            int customerIndex = customerComboBox.getSelectedIndex();
            int propertyIndex = propertyComboBox.getSelectedIndex();
            String date1 = dateEntry1.getText();
            String date2 = dateEntry2.getText();

            if (customerIndex == -1 || propertyIndex == -1 || date1.isEmpty() || date2.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Please fill all the fields");
            }
            // check date formats
            else if (!date1.matches("\\d{2}/\\d{2}/\\d{4}") || !date2.matches("\\d{2}/\\d{2}/\\d{4}")) {
                JOptionPane.showMessageDialog(null, "Invalid date format");
            }
            else {
                int customerId = customer_list.get(customerIndex);
                int propertyId = property_list.get(propertyIndex);
                BASIC.addBooking(customerId, propertyId, date1, date2);
                JOptionPane.showMessageDialog(null, "Booking added successfully");
                dispose();
            }
        });

    }
}
