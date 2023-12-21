package BASIC.Project2;

import javax.swing.*;

public class ListUsersPage extends JFrame {
    private JPanel mainPanel;
    private JTable customerTable;
    private JTable hostTable;

    ListUsersPage() {
        String[] column1 = {"Customer ID", "Name", "Surname", "dob", "registration date", "Customer Type", "Gold level"};
        Object[][] data1 = new Object[BASIC.users.size()][column1.length];

        String[] column2 = {"Customer ID", "Name", "Surname", "dob", "registration date", "Tax number"};
        Object[][] data2 = new Object[BASIC.users.size()][column1.length];
        for (int i = 0; i < BASIC.users.size(); i++) {
             if (BASIC.users.get(i) instanceof Customer)
             {
                 Customer c = (Customer) BASIC.users.get(i);
                 data1[i][0] = c.getUserId();
                 data1[i][1] = c.getFirstName();
                 data1[i][2] = c.getLastName();
                 data1[i][3] = c.getDateOfBirth();
                 data1[i][4] = c.getRegistrationDate();
                 if(c instanceof Gold)
                 {
                     data1[i][5] = "Gold";
                     data1[i][6] = ((Gold) c).getGoldLevel();
                 }
                 else {
                     data1[i][5] = "Standard";
                     data1[i][6] = null;
                 }
             }
             else {
                 Host h = (Host) BASIC.users.get(i);
                 data2[i][0] = h.getUserId();
                 data2[i][1] = h.getFirstName();
                 data2[i][2] = h.getLastName();
                 data2[i][3] = h.getDateOfBirth();
                 data2[i][4] = h.getRegistrationDate();
                 data2[i][5] = h.getTaxNumber();
             }

        }
        customerTable = new JTable(data1, column1);
        hostTable = new JTable(data2, column2);

        customerTable.setBounds(30,40,200,300);
        hostTable.setBounds(300,40,200,300);
        mainPanel.add(customerTable);
        mainPanel.add(hostTable);
        setContentPane(mainPanel);
        setSize(300,400);
        setVisible(true);

    }

}

