package BASIC.Project2;


import javax.swing.*;

public class GetUserBookingPage extends JFrame {


    private JScrollPane scroll;
    private JPanel panel1;
    private JTabbedPane tabbedPane1;
    private JPanel user;
    private JButton enterButton;
    private JLabel idLabel;
    private JTextField idField;
    private JTextArea textArea1;

    public GetUserBookingPage() {

        setContentPane(scroll);
        setTitle("User Bookings");
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(600, 400);
        setVisible(true);


        enterButton.addActionListener(e -> {
           // check if id is entered
            String id = idField.getText();
            if (id.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Please enter an ID", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            if (!id.matches("\\d+")) {
                JOptionPane.showMessageDialog(null, "Please enter a valid ID", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

           textArea1.setText(BASIC.getUserBooking(Integer.parseInt(id)));

        });
    }
}
