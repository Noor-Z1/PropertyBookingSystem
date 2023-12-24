package BASIC.Project2;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class AddHostPage extends JFrame{

    private Integer id;
    private JPanel mainPanel;
    private JPanel hostPanel;
    private JTextField firstNameEntry;
    private JTextField lastNameEntry;
    private JTextField dobEntry;
    private JTextField regDateEntry;
    private JTextField taxEntry;
    private JLabel firstName;
    private JLabel lastName;
    private JButton submit;
    private JLabel DOB;
    private JLabel regDate;
    private JLabel tax;
    private Host host;
    private AddUserPage addUserPage;
    private AddPropertyPage addPropertyPage;


    public AddHostPage(int id) {

        setContentPane(mainPanel);
        setTitle("Add Host");
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setSize(250,400);
        setVisible(true);

        submit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // check if any of the fields are empty and display an error message
                if (firstNameEntry.getText().isEmpty() || lastNameEntry.getText().isEmpty() || dobEntry.getText().isEmpty() || regDateEntry.getText().isEmpty() || taxEntry.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Please fill in all the fields");
                    return;
                }

                // validate the inputs
                if (!firstNameEntry.getText().matches("^[A-Za-z ]+$")) {
                    JOptionPane.showMessageDialog(null, "Invalid first name");
                    return;
                }
                if (!lastNameEntry.getText().matches("^[A-Za-z ]+$")) {
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
                if (!taxEntry.getText().matches("\\d+")) {
                    JOptionPane.showMessageDialog(null, "Invalid tax number");
                    return;
                }

                host = new Host(id, 0);
                // if no problem
                host.setFirstName(firstNameEntry.getText());
                host.setLastName(lastNameEntry.getText());
                host.setDateOfBirth(getDate(dobEntry.getText()));
                host.setRegistrationDate(getDate(regDateEntry.getText()));
                host.setTaxNumber(Integer.parseInt(taxEntry.getText()));

                if (addUserPage != null) {
                    addUserPage.getUsers().add(host);
                }
                else if (addPropertyPage != null) {
                    //addPropertyPage.getProperties().add(host);
                }

                JOptionPane.showMessageDialog(null, "Host added successfully");
                dispose();


            }
        });




    }

    public Host getHost() {
        return host;
    }

    public void setAddUserPage(AddUserPage addUserPage) {
        this.addUserPage = addUserPage;
    }

    public void setAddPropertyPage(AddPropertyPage addPropertyPage) {
        this.addPropertyPage = addPropertyPage;
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
