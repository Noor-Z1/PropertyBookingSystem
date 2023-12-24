package BASIC.Project2;

import javax.swing.*;

public class GetBookingCostPage extends JFrame {
    private JPanel costPanel;
    private JLabel userIdLabel;
    private JTextField userIdField;
    private JButton costButton;
    private JTextField propIdField;
    private JLabel propIDLabel;

    public GetBookingCostPage() {
        setContentPane(costPanel);
        setTitle("Get Booking Cost");
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
        setSize(200, 150);

        costButton.addActionListener(e -> {
            // check if something is entered
            if (userIdField.getText().isEmpty() || propIdField.getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Please enter all details");
                return;
            }
            // check if an integer is entered
            try {
                Integer.parseInt(userIdField.getText());
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(null, "Please enter an integer");
                return;
            }

            try {
                Integer.parseInt(propIdField.getText());
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(null, "Please enter an integer");
                return;
            }
            if (!BASIC.checkUserExists(Integer.parseInt(userIdField.getText()))) {
                JOptionPane.showMessageDialog(null, "User does not exist");
                return;
            }
            if (!BASIC.checkPropertyExists(Integer.parseInt(propIdField.getText()))) {
                JOptionPane.showMessageDialog(null, "Property does not exist");
                return;
            }

            JOptionPane.showMessageDialog(null, BASIC.getBookingCost(Integer.parseInt(userIdField.getText()), Integer.parseInt(propIdField.getText())));

        });
    }

}
