package BASIC.Project2;

import javax.swing.*;
import java.awt.*;

public class ComparePropertyPricesPage extends JFrame{

    private JPanel contentPane;
    private JTextField idField1;
    private JTextField idField2;
    private JTextArea comparisonText;
    private JLabel idLabel1;
    private JLabel idLabel2;
    private JButton enterButton;


    public ComparePropertyPricesPage() {
        setContentPane(contentPane);
        setTitle("Compare Property Prices");
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        pack();
        setVisible(true);

        enterButton.addActionListener(e -> {
            // check if something is entered
            if (idField1.getText().isEmpty() || idField2.getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Please enter an ID");
                return;
            }
            // check if an integer is entered
            try {
                Integer.parseInt(idField1.getText());
                Integer.parseInt(idField2.getText());
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(null, "Please enter an integer");
                return;
            }

            // check if IDs are valid
            if (idField1.getText().equals(idField2.getText())) {
                JOptionPane.showMessageDialog(null, "Please enter different IDs");
                return;
            }
            // check if IDs exist
            if (!BASIC.checkPropertyExists(Integer.parseInt(idField1.getText())) || !BASIC.checkPropertyExists(Integer.parseInt(idField2.getText()))) {
                JOptionPane.showMessageDialog(null, "Property not found");
                return;
            }

            // display comparison
            String comparison = BASIC.comparePropertyPricesPerDay(Integer.parseInt(idField1.getText()), Integer.parseInt(idField2.getText()));
            comparisonText.setText(comparison);
            comparisonText.setForeground(Color.white);


        });

    }

}
