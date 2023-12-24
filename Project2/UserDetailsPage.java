package BASIC.Project2;

import javax.swing.*;

public class UserDetailsPage extends JFrame {

    private JTabbedPane tabbedPane1;
    private JPanel panel1;
    private JPanel user;
    private JButton enterButton;
    private JTextField idField;
    private JLabel idLabel;
    private JTextArea textArea1;
    private JScrollPane scroll;

    public UserDetailsPage() {
        setContentPane(scroll);
        setTitle("User Details");
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setSize(400, 300);
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

            textArea1.setText(BASIC.getUserDetails(Integer.parseInt(idField.getText())));

        });


    }


}
