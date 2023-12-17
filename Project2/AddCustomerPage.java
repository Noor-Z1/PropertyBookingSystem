package BASIC.Project2;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class AddCustomerPage extends JFrame {

    private Integer id;
    private JPanel mainPanel;
    private JPanel customerPanel;
    private JLabel type;
    private JRadioButton standardRadioButton;
    private JRadioButton goldRadioButton;
    private JTextField nameEntry;
    private JTextField lastNameEntry;
    private JTextField dobEntry;
    private JTextField regDateEntry;
    private JLabel firstName;
    private JLabel lastName;
    private JLabel DOB;
    private JLabel regDate;
    private JLabel paymentMethod;
    private JTextField paymentEntry;
    private JButton submitButton;
    private JRadioButton op1;
    private JRadioButton op2;
    private JRadioButton op3;
    private JScrollPane scroll;
    private JLabel selectLevelOfGoldLabel;
    private Customer customer;

    private AddUserPage addUserPage;

    AddCustomerPage(int id)
    {

        selectLevelOfGoldLabel.setVisible(false);
        op1.setVisible(false);
        op2.setVisible(false);
        op3.setVisible(false);
        // also group the op buttons
        ButtonGroup buttonGroup = new ButtonGroup();
        buttonGroup.add(goldRadioButton);
        buttonGroup.add(standardRadioButton);

        ButtonGroup buttonGroup2 = new ButtonGroup();
        buttonGroup2.add(op1);
        buttonGroup2.add(op2);
        buttonGroup2.add(op3);

        setContentPane(mainPanel);
        setTitle("Add Customer");
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        pack();
        setVisible(true);



        // add action listen to the gold radio button
        goldRadioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                selectLevelOfGoldLabel.setVisible(true);
                op1.setVisible(true);
                op2.setVisible(true);
                op3.setVisible(true);
            }
        });

        standardRadioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                selectLevelOfGoldLabel.setVisible(false);
                op1.setVisible(false);
                op2.setVisible(false);
                op3.setVisible(false);
            }
        });


        // add action listener to the submit button

        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // here we want to validate all the fields

                // check if any of the fields are empty and display an error message
                if (nameEntry.getText().isEmpty() || lastNameEntry.getText().isEmpty() || dobEntry.getText().isEmpty() || regDateEntry.getText().isEmpty()  || paymentEntry.getText().isEmpty() || !buttonGroup.getSelection().isSelected()) {
                    JOptionPane.showMessageDialog(null, "Please fill in all the fields");
                    return;
                }

                // now check if gold button of button group is selected or not
                if (goldRadioButton.isSelected() && !op1.isSelected() && !op2.isSelected() && !op3.isSelected()) {
                    JOptionPane.showMessageDialog(null, "Please select a level of gold");
                    return;
                }

                // validate the inputs
                if (!nameEntry.getText().matches("[a-zA-Z]+")) {
                    JOptionPane.showMessageDialog(null, "Invalid first name");
                    return;
                }
                if (!lastNameEntry.getText().matches("[a-zA-Z]+")) {
                    JOptionPane.showMessageDialog(null, "Invalid last name");
                    return;
                }
                if (!dobEntry.getText().matches("\\d{2}/\\d{2}/\\d{4}")) {
                    JOptionPane.showMessageDialog(null, "Invalid date of birth");
                    return;
                }
                if (!regDateEntry.getText().matches("\\d{2}/\\d{2}/\\d{4}")) {
                    JOptionPane.showMessageDialog(null, "Invalid registration date");
                    return;
                }
                if (!paymentEntry.getText().matches("[a-zA-Z]+")) {
                    JOptionPane.showMessageDialog(null, "Invalid payment");
                    return;
                }

                // check whether to create standard or gold customer
                if (goldRadioButton.isSelected()) {
                    if (op1.isSelected()) {

                        customer = new Gold(id, paymentMethod.getText(), 1);


                    } else if (op2.isSelected()) {
                        customer = new Gold(id, paymentMethod.getText(), 2);
                    } else if (op3.isSelected()) {
                        customer = new Gold(id, paymentMethod.getText(), 3);
                    }
                } else {
                    customer = new Standard(id, paymentMethod.getText());
                }

                customer.setFirstName(nameEntry.getText());
                customer.setLastName(lastNameEntry.getText());
                customer.setDateOfBirth(getDate(dobEntry.getText()));
                customer.setRegistrationDate(getDate(regDateEntry.getText()));

                addUserPage.getUsers().add(customer);
                JOptionPane.showMessageDialog(null, "Customer added successfully");
                dispose();

            }
        });
    }



    public void setAddUserPage(AddUserPage addUserPage) {
        this.addUserPage = addUserPage;
    }
    private Date getDate(String dateStr) {

        // parse dob to a Date format
        Date date = new Date();
        boolean flag;
        do {
            flag = false;

            // do exception handling
            try {
                date = new SimpleDateFormat("dd/MM/yyyy").parse(dateStr);
            } catch (ParseException e) {
                System.out.println("\nInvalid date format");
                flag = true;
                System.out.println("Try again");
                System.out.print("Enter dob (dd/mm/yyyy): ");
            }
        }while (flag);
        return date;
    }
}
