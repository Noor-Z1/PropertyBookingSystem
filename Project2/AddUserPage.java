package BASIC.Project2;

import javax.swing.*;
import java.awt.event.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Objects;
import java.util.Scanner;

public class AddUserPage extends JFrame {

    private JPanel mainPanel;
    private JPanel userPanel;
    private JTextField textField1;
    private JButton enterButton;
    private JLabel addLabel;
    private JLabel typeLabel;
    private JRadioButton customerRadioButton;
    private JRadioButton hostRadioButton;
    private JButton ExitButton;
    private static ArrayList<User> users = new ArrayList<>();
    private BASIC mainframe;

    AddUserPage() {
        setContentPane(mainPanel);
        setTitle("Bed and Breafast");
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        ButtonGroup buttonGroup = new ButtonGroup();
        buttonGroup.add(customerRadioButton);
        buttonGroup.add(hostRadioButton);
        pack();
        setVisible(true);

        ExitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if (users!=null) {
                    mainframe.setUsers(users);
                }
                dispose();
            }
        });

        enterButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (Objects.equals(textField1.getText(), ""))
                {
                    JOptionPane.showMessageDialog(null, "You haven't entered any ID");
                }
                else if (!customerRadioButton.isSelected() && !hostRadioButton.isSelected())
                {
                    JOptionPane.showMessageDialog(null, "Either Customer or Host should be selected!");
                }
                else {
                    while (checkUserExists(Integer.parseInt(textField1.getText()))) {
                        JOptionPane.showMessageDialog(null, "User already exists! Try again");
                        break;
                    }

                    if (!checkUserExists(Integer.parseInt(textField1.getText()))) {


                        // create new user or redirect to new page based on the option selected
                        int id = Integer.parseInt(textField1.getText());
                        int i = customerRadioButton.isSelected() ? 1 : 2;

                        if (i == 1) {
                            AddCustomerPage window = new AddCustomerPage(id);
                            window.setAddUserPage(AddUserPage.this);
                            setVisible(false);

                            window.addWindowListener(new WindowAdapter() {
                                @Override
                                public void windowClosed(WindowEvent e) {
                                    // close this frame also when the other frame is closed
                                    setVisible(true);
                                }
                            });

                        } else {
                            AddHostPage window = new AddHostPage(id);
                            window.setAddUserPage(AddUserPage.this);
                            setVisible(false);

                            window.addWindowListener(new WindowAdapter() {
                                @Override
                                public void windowClosed(WindowEvent e) {
                                    // close this frame also when the other frame is closed
                                    setVisible(true);
                                    //System.out.println(users);
                                }
                            });
                        }
                    }


                }

            }
        });
    }



    private boolean checkUserExists(int id) {
        for (User user : users){
            if (user.getUserId() == id){
                System.out.println("User already exists!\n");
                return true;
            }
        }
        return false;
    }

    public ArrayList<User> getUsers() {
        return users;
    }


}
