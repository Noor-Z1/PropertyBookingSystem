package BASIC.Project2;

import javax.swing.*;
import java.util.ArrayList;


public class DeleteUser extends JFrame {

    private JPanel deletePanel;
    private JLabel idLabel;
    private JTextField idField;
    private JButton enter;
    private JPanel dP;
    private BASIC mainframe;

    public void setMainframe(BASIC mainframe) {
        this.mainframe = mainframe;
    }

    DeleteUser() {
        setContentPane(deletePanel);
        setTitle("Delete User");
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        pack();
        setVisible(true);

        enter.addActionListener(e -> {

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

            int id = Integer.parseInt(idField.getText());
            if (BASIC.checkUserExists(id)) {
                BASIC.deleteUser(id);
                JOptionPane.showMessageDialog(null, "User deleted successfully");
                dispose();

            } else {
                JOptionPane.showMessageDialog(null, "User does not exist, please try again!");
            }


        });
    }

}