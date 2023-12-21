package BASIC.Project2;

import javax.swing.*;

public class GetDiscountForUserPage extends JFrame {

    private JPanel discountPanel;
    private JTextField idField;
    private JButton enterButton;
    private JLabel discLabel;

    public GetDiscountForUserPage() {
        setContentPane(discountPanel);
        setTitle("Get Discount");
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        pack();
        setVisible(true);

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

            // check if user exists
            if (!BASIC.checkUserExists(Integer.parseInt(idField.getText()))) {
                JOptionPane.showMessageDialog(null, "User not found");
                return;
            }

            // display discount
            double discount = BASIC.getDiscountForUser(Integer.parseInt(idField.getText()));

            if (discount == 0) {
                JOptionPane.showMessageDialog(null, "User is not a customer! You entered a Host ID. Try again");

            } else {
                JOptionPane.showMessageDialog(null, "Discount: " + discount);
                dispose();
            }

        });

    }


}
