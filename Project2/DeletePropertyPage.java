package BASIC.Project2;

import javax.swing.*;


public class DeletePropertyPage extends JFrame {
    private JPanel deleteP;
    private JLabel deleteLabel;
    private JTextField idField;
    private JButton confirm;

    public DeletePropertyPage() {
        setContentPane(deleteP);
        setTitle("Delete Property");
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        pack();
        setVisible(true);

        confirm.addActionListener(e -> {
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

            // check if property exists
            if (!BASIC.checkPropertyExists(Integer.parseInt(idField.getText()))) {
                JOptionPane.showMessageDialog(null, "Property does not exist");
                return;
            }

            // delete property
            BASIC.deleteProperty(Integer.parseInt(idField.getText()));
            dispose();

        });
    }

}
