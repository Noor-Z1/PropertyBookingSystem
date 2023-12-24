package BASIC.Project2;

import javax.swing.*;
import javax.swing.table.DefaultTableColumnModel;
import javax.swing.table.JTableHeader;
import java.awt.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Objects;

public class ListUsersPage extends JFrame {
    private JPanel mainPanel;

    ListUsersPage() {
        Object[] column1 = {"Customer ID", "Name", "Surname", "dob", "registration date", "Preferred Payment","Customer Type", "Gold level"};
        Object[][] data1 = new Object[BASIC.users.size()][column1.length];

        Object[] column2 = {"Customer ID", "Name", "Surname", "dob", "registration date", "Tax number"};
        Object[][] data2 = new Object[BASIC.users.size()][column2.length];

        for (int i = 0; i < BASIC.users.size(); i++) {

             if (BASIC.users.get(i) instanceof Customer )
             {
                 System.out.println("here");
                 Customer c = (Customer) BASIC.users.get(i);
                 data1[i][0] = c.getUserId();
                 data1[i][1] = c.getFirstName();
                 data1[i][2] = c.getLastName();
                 data1[i][3] = c.getDateOfBirth();
                 data1[i][4] = c.getRegistrationDate();
                 if(c.getClass() == Gold.class)
                 {
                     data1[i][5] = c.getPreferredPaymentMethod();
                     data1[i][6] = "Gold";
                     data1[i][7] = ((Gold) c).getGoldLevel();

                 }
                 else {
                     data1[i][5] = c.getPreferredPaymentMethod();
                     data1[i][6] = "Standard";
                     data1[i][7] = 0;
                 }

             }
             else {
                 System.out.println("here2");
                 Host h = (Host) BASIC.users.get(i);
                 data2[i][0] = h.getUserId();
                 data2[i][1] = h.getFirstName();
                 data2[i][2] = h.getLastName();
                 data2[i][3] = h.getDateOfBirth();
                 data2[i][4] = h.getRegistrationDate();
                 data2[i][5] = h.getTaxNumber();
             }

        }

        for (int i = 0; i < data1.length; i++) {
            for (int j = 0; j < data1[i].length; j++) {
                System.out.println(data1[i][j]);
            }
        }
        for (int i = 0; i < data2.length; i++) {
            for (int j = 0; j < data2[i].length; j++) {
                System.out.println(data2[i][j]);
            }
        }

        if (data1.length!=0 ) {
            JTable customerTable = new JTable(data1, column1);
            customerTable.setVisible(true);
            customerTable.setBounds(50, 50, 200, 300);
            mainPanel.add(customerTable);

        }
        if (data2.length!=0 ) {
            JTable hostTable = new JTable(data2, column2);
            hostTable.setVisible(true);
            hostTable.setBounds(300, 400, 200, 300);
            mainPanel.add(hostTable);

        }

        setLocationRelativeTo(null);
        setTitle("List Users");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setContentPane(mainPanel);
        setSize(800,400);
        setVisible(true);

    }

}

