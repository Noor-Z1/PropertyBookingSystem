package BASIC.Project2;

import javax.swing.*;

public class ListPropertiesPage extends JFrame {


    private JPanel mainPanel;

    ListPropertiesPage () {

        Object[] column1 = {"Property ID", "no of Bed Rooms", "no of Rooms", "city", "price per day", "Inspection", "Property Type", "Property Size"};
        Object[][] data1 = new Object[BASIC.properties.size()][column1.length];


        for (int i = 0; i < BASIC.properties.size(); i++) {
            if (BASIC.properties.get(i) instanceof SharedProperty) {
                Property p = BASIC.properties.get(i);
                data1[i][0] = p.getPropertyId();
                data1[i][1] = p.getNoBedRooms();
                data1[i][2] = p.getNoRooms();
                data1[i][3] = p.getCity();
                data1[i][4] = p.getPricePerDay();
                data1[i][5] = p.getInspection();
                data1[i][6] = "Shared Property";
                data1[i][7] = "NA";
            } else {
                FullProperty p = (FullProperty) BASIC.properties.get(i);
                data1[i][0] = p.getPropertyId();
                data1[i][1] = p.getNoBedRooms();
                data1[i][2] = p.getNoRooms();
                data1[i][3] = p.getCity();
                data1[i][4] = p.getPricePerDay();
                data1[i][5] = p.getInspection();
                data1[i][6] = "Full Property";
                data1[i][7] = p.getPropertySize();

            }
        }


        if (BASIC.properties.isEmpty()) {
            JOptionPane.showMessageDialog(null, "No Properties Available");
        }
        else {
            JTable propertiesTable = new JTable(data1, column1);
            propertiesTable.setVisible(true);
            propertiesTable.setBounds(50, 50, 300, 300);
            mainPanel.add(propertiesTable);
        }

        setLocationRelativeTo(null);
        setTitle("List Properties");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setContentPane(mainPanel);
        setSize(650,400);
        setVisible(true);

    }


}
