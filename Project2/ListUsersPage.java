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

        Object[] column2 = {"Customer ID", "Name", "Surname", "dob", "registration date", "Type", "Tax number"};
        Object[][] data2 = new Object[BASIC.users.size()][column2.length];

        boolean flag1 = false;
        boolean flag2 = false;
        int j = 0;
        int k = 0;

        for (int i = 0; i < BASIC.users.size(); i++) {

             if (BASIC.users.get(i) instanceof Customer )
             {
                 System.out.println("here");
                 Customer c = (Customer) BASIC.users.get(i);
                 data1[k][0] = c.getUserId();
                 data1[k][1] = c.getFirstName();
                 data1[k][2] = c.getLastName();
                 data1[k][3] = c.getDateOfBirth();
                 data1[k][4] = c.getRegistrationDate();
                 if(c.getClass() == Gold.class)
                 {
                     data1[k][5] = c.getPreferredPaymentMethod();
                     data1[k][6] = "Gold";
                     data1[k][7] = ((Gold) c).getGoldLevel();

                 }
                 else {
                     data1[k][5] = c.getPreferredPaymentMethod();
                     data1[k][6] = "Standard";
                     data1[k][7] = 0;
                 }
                 flag1 = true;
                 k += 1;
             }
             else {
                 System.out.println("here2");
                 Host h = (Host) BASIC.users.get(i);
                 data2[j][0] = h.getUserId();
                 data2[j][1] = h.getFirstName();
                 data2[j][2] = h.getLastName();
                 data2[j][3] = h.getDateOfBirth();
                 data2[j][4] = h.getRegistrationDate();
                 data2[j][5] = "Host";
                 data2[j][6] = h.getTaxNumber();
                 j += 1;
                 flag2 = true;
             }

        }


        if (flag1 )  {
            JLabel customerLabel = new JLabel("Customers");
            mainPanel.add(customerLabel);
            JTable customerTable = new JTable(data1, column1);
            customerTable.setVisible(true);
            customerTable.setBounds(50, 50, 300, 300);
            mainPanel.add(customerTable);

        }
        if (flag2) {
            JLabel hostLabel = new JLabel("Hosts");
            hostLabel.setHorizontalTextPosition(SwingConstants.CENTER);
            mainPanel.add(hostLabel);
            JTable hostTable = new JTable(data2, column2);
            hostTable.setVisible(true);
            hostTable.setBounds(50, 50 , 300, 300);
            mainPanel.add(hostTable);

        }

        setLocationRelativeTo(null);
        setTitle("List Users");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setContentPane(mainPanel);
        setSize(650,400);
        setVisible(true);

    }

}

