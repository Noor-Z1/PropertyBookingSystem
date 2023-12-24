package BASIC.Project2;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.text.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;



/** Represents a class that manages users and properties for a booking system.
 * @author Noor Ul Zain
 * @version 2.0
 * @see User
 * @see Property
 */
public class BASIC extends JFrame {
    static ArrayList<User> users = new ArrayList<>();
    static ArrayList<Property> properties = new ArrayList<>();

    private JPanel mainPanel;
    private JPanel menuPanel;
    private JMenuBar mb;
    private JList<String> menuList;
    private JLabel welcomeLabel;
    private JScrollPane mainPane;
    private JButton selectButton;
    private JFileChooser fileNavi;

    public JButton getSelectButton() {
        return selectButton;
    }

    BASIC() {

        JMenu m1 = new JMenu("File");
        JMenuItem load = new JMenuItem("Load Data");
        JMenuItem save = new JMenuItem("Save Data");
        m1.add(load);
        m1.add(save);
        m1.setBackground(Color.BLACK);

        load.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // want to use JFileChooser
                File selectedFiles[] = showFileChooser();
                if (selectedFiles == null) {
                    return;
                }
                loadData(selectedFiles);
            }
        });

        save.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                saveData();
            }
        });

        JMenu m2 = new JMenu("Help");
        m2.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {

                String msg = "Welcome to our Property Booking System. \n" +
                        "Here you can add users, properties, and bookings. \n" +
                        "You can also get details of a user, property, or booking. \n" +
                        "Note that if you want to load your previous data, \n" +
                        "select Load Data from the File menu. \n" +
                        "Also, if you want to save your data, \n" +
                        "select Save Data from the File menu. \n" +
                        "Have fun!";
                JOptionPane.showMessageDialog(null, msg, "Help", JOptionPane.INFORMATION_MESSAGE);
            }
        });


        JMenu m3 = new JMenu("About");
        m3.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                JOptionPane.showMessageDialog(null, "A Property Booking System \nDeveloped by Noor Ul Zain \nVersion 1.0", "About", JOptionPane.INFORMATION_MESSAGE);
            }
        });

        JMenu m4 = new JMenu("Useful Info");
        m4.addMouseListener(new MouseAdapter() {

            String msg = "If you accidentally close the application, \n" +
                    "we will automatically save your data, in case you want to load it later.\n" +
                    "Thank you for using our service. \n";

            @Override
            public void mousePressed(MouseEvent e) {
                JOptionPane.showMessageDialog(null, msg, "Useful Info", JOptionPane.INFORMATION_MESSAGE);
            }

        });

        // add things to JList
        menuList.setListData(new String[]{
                "Add User",
                "Delete User",
                "Get User Details",
                "Add Property",
                "Delete Property",
                "Get Property Details",
                "Add Booking",
                "Get Booking Cost",
                "Get User Booking",
                "List Users",
                "List Properties",
                "Get Discount for User",
                "Add Inspection to Property",
                "Compare Property Prices (per day)",
                "Exit"});
        menuList.setForeground(Color.white);
        menuList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        menuList.setSelectedIndex(0);

        mb.setBackground(Color.WHITE);
        mb.setForeground(Color.pink);
        mb.add(m1);
        mb.add(m2);
        mb.add(m3);
        mb.add(m4);
        setContentPane(mainPane);
        setTitle("Bed and Breafast");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setSize(500, 400);
        setJMenuBar(mb);
        setVisible(true);

    }

    private File[] showFileChooser() {
        JFileChooser fileChooser = new JFileChooser();

        // Enable multiple file selection
        fileChooser.setMultiSelectionEnabled(true);

        // Show the file chooser dialog and get the result
        int result = fileChooser.showOpenDialog(this);

        // Check if the user selected a file
        if (result == JFileChooser.APPROVE_OPTION) {
            // Get the selected file
            File[] selectedFiles = fileChooser.getSelectedFiles();
            return selectedFiles;
        }
        return null;
    }


    public static void main(String[] args) {
        BASIC myframe = new BASIC();
        myframe.getSelectButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                myframe.setVisible(false);

                if (myframe.menuList.getSelectedIndex() == 0) {
                    AddUserPage nextPage = new AddUserPage();
                    nextPage.addWindowListener(new WindowAdapter() {
                        @Override
                        public void windowClosed(WindowEvent e) {
                            myframe.setVisible(true);
                            System.out.println(users); // for testing
                        }
                    });

                } else if (myframe.menuList.getSelectedIndex() == 1) {
                    DeleteUser nextPage = new DeleteUser();
                    nextPage.addWindowListener(new WindowAdapter() {
                        @Override
                        public void windowClosed(WindowEvent e) {
                            myframe.setVisible(true);
                            System.out.println(users);  // for testing
                        }
                    });
                } else if (myframe.menuList.getSelectedIndex() == 2) {
                    UserDetailsPage nextPage = new UserDetailsPage();
                    nextPage.addWindowListener(new WindowAdapter() {
                        @Override
                        public void windowClosed(WindowEvent e) {
                            myframe.setVisible(true);
                        }
                    });
                } else if (myframe.menuList.getSelectedIndex() == 3) {
                    AddPropertyPage nextPage = new AddPropertyPage();
                    nextPage.addWindowListener(new WindowAdapter() {
                        @Override
                        public void windowClosed(WindowEvent e) {
                            myframe.setVisible(true);
                            System.out.println(properties);
                        }
                    });
                } else if (myframe.menuList.getSelectedIndex() == 4) {
                    DeletePropertyPage nextPage = new DeletePropertyPage();
                    nextPage.addWindowListener(new WindowAdapter() {
                        @Override
                        public void windowClosed(WindowEvent e) {
                            myframe.setVisible(true);
                            System.out.println(properties);
                        }
                    });
                } else if (myframe.menuList.getSelectedIndex() == 5) {
                    PropertyDetailsPage nextPage = new PropertyDetailsPage();
                    nextPage.addWindowListener(new WindowAdapter() {
                        @Override
                        public void windowClosed(WindowEvent e) {
                            myframe.setVisible(true);
                        }
                    });

                } else if (myframe.menuList.getSelectedIndex() == 6) {
                    AddBookingPage nextPage = new AddBookingPage();
                    nextPage.addWindowListener(new WindowAdapter() {
                        @Override
                        public void windowClosed(WindowEvent e) {
                            myframe.setVisible(true);
                        }
                    });
                } else if (myframe.menuList.getSelectedIndex() == 7) {
                    GetBookingCostPage nextPage = new GetBookingCostPage();

                } else if (myframe.menuList.getSelectedIndex() == 8) {
                    GetUserBookingPage nextPage = new GetUserBookingPage();
                } else if (myframe.menuList.getSelectedIndex() == 9) {
                    ListUsersPage nextPage = new ListUsersPage();
                    nextPage.addWindowListener(new WindowAdapter() {
                        @Override
                        public void windowClosed(WindowEvent e) {
                            myframe.setVisible(true);
                        }
                    });
                } else if (myframe.menuList.getSelectedIndex() == 10) {
                    ListPropertiesPage nextPage = new ListPropertiesPage();
                } else if (myframe.menuList.getSelectedIndex() == 11) {
                    GetDiscountForUserPage nextPage = new GetDiscountForUserPage();
                    nextPage.addWindowListener(new WindowAdapter() {
                        @Override
                        public void windowClosed(WindowEvent e) {
                            myframe.setVisible(true);
                        }
                    });
                } else if (myframe.menuList.getSelectedIndex() == 12) {
                    AddInspectiontoPropertyPage nextPage = new AddInspectiontoPropertyPage();
                    nextPage.addWindowListener(new WindowAdapter() {
                        @Override
                        public void windowClosed(WindowEvent e) {
                            myframe.setVisible(true);
                        }
                    });
                } else if (myframe.menuList.getSelectedIndex() == 13) {
                    ComparePropertyPricesPage nextPage = new ComparePropertyPricesPage();
                    nextPage.addWindowListener(new WindowAdapter() {
                        @Override
                        public void windowClosed(WindowEvent e) {
                            myframe.setVisible(true);
                        }
                    });
                } else if (myframe.menuList.getSelectedIndex() == 14) {
                    System.exit(0);
                }

            }
        });

        myframe.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                int choice = JOptionPane.showConfirmDialog(null,
                        "Do you want to save your data before closing?",
                        "Save Data",
                        JOptionPane.YES_NO_OPTION);

                if (choice == JOptionPane.YES_OPTION) {
                    // Save data here or call a method to handle data saving
                    saveData();
                    // Close the frame
                }
            }

        });

    }



    public static void setUsers(ArrayList<User> users) {
        BASIC.users = users;
    }

    public static ArrayList<User> getUsers() {
        return users;
    }

    public static ArrayList<Property> getProperties() {
        return properties;
    }

    public static void setProperties(ArrayList<Property> properties) {
        BASIC.properties = properties;
    }

    public static User getUser(int id) {
        for (User user : users) {
            if (user.getUserId() == id) {
                return user;
            }
        }
        return null;
    }


    public static void loadData(File[] selectedFiles) {
        // load data from selected files
        for (File file : selectedFiles) {
            // your code to load data from each file goes here
            if (file.getName().equals("gold.dat")) {
                loadGoldData(file);
            } else if (file.getName().equals("standard.dat")) {
                loadStandardData(file);
            } else if (file.getName().equals("host.dat")) {
                loadHostData(file);
            } else if (file.getName().equals("sharedProperty.dat")) {
                loadSharedPropertyData(file);
            } else if (file.getName().equals("fullProperty.dat")) {
                loadFullPropertyData(file);
            }
        }
    }

    private static void loadStandardData(File file) {
        // want to use DataInputStream
        try {
            // Create DataInputStream object
            DataInputStream dinput = new DataInputStream(new FileInputStream(file));

            try {
                while ((dinput.available() > 0)) {

                    int userId = dinput.readInt();
                    String dateOfBirth = dinput.readUTF();
                    String firstName = dinput.readUTF();
                    String lastName = dinput.readUTF();
                    String registrationDate = dinput.readUTF();
                    String preferredPaymentMethod = dinput.readUTF();

                    Standard s = new Standard(userId, preferredPaymentMethod);
                    s.setDateOfBirth(getDate(dateOfBirth, new Scanner(System.in)));
                    s.setFirstName(firstName);
                    s.setLastName(lastName);
                    s.setRegistrationDate(getDate(registrationDate, new Scanner(System.in)));
                    users.add(s);

                    dinput.readUTF();
                }

            } catch (IOException e) {
                e.printStackTrace();
            }

        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        }

    }




    private static void loadGoldData(File file) {
        try {
            // Create DataInputStream object
            DataInputStream dinput = new DataInputStream(new FileInputStream(file));

            try {
                while ((dinput.available() > 0)) {

                    int userId = dinput.readInt();
                    String dateOfBirth = dinput.readUTF();
                    String firstName = dinput.readUTF();
                    String lastName = dinput.readUTF();
                    String registrationDate = dinput.readUTF();
                    String preferredPaymentMethod = dinput.readUTF();
                    int goldlevel = dinput.readInt();

                    Gold s = new Gold(userId, preferredPaymentMethod, goldlevel);
                    s.setDateOfBirth(getDate(dateOfBirth, new Scanner(System.in)));
                    s.setFirstName(firstName);
                    s.setLastName(lastName);
                    s.setRegistrationDate(getDate(registrationDate, new Scanner(System.in)));
                    s.setGoldLevel(goldlevel);
                    users.add(s);

                    dinput.readUTF();
                }

            } catch (IOException e) {
                e.printStackTrace();
            }

        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        }

    }

    private static void loadHostData(File file) {
        try {
            // Create DataInputStream object
            DataInputStream dinput = new DataInputStream(new FileInputStream(file));

            try {
                while ((dinput.available() > 0)) {

                    int userId = dinput.readInt();
                    String dateOfBirth = dinput.readUTF();
                    String firstName = dinput.readUTF();
                    String lastName = dinput.readUTF();
                    String registrationDate = dinput.readUTF();
                    Double taxNumber = dinput.readDouble();

                    Host s = new Host(userId, taxNumber);
                    s.setDateOfBirth(getDate(dateOfBirth, new Scanner(System.in)));
                    s.setFirstName(firstName);
                    s.setLastName(lastName);
                    s.setRegistrationDate(getDate(registrationDate, new Scanner(System.in)));
                    users.add(s);

                    dinput.readUTF();
                }

            } catch (IOException e) {
                e.printStackTrace();
            }

        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        }


    }

    private static void loadSharedPropertyData(File file) {
    }
    private static void loadFullPropertyData(File file) {
    }



    public static void saveData() {
        File f1 = new File("gold.dat");
        File f2 = new File("standard.dat");
        File f3 = new File("host.dat");
        File f4 = new File("sharedProperty.dat");
        File f5 = new File("fullProperty.dat");

        String dateFormatPattern = "dd/MM/yyyy";

        // Create a SimpleDateFormat object with the specified pattern
        SimpleDateFormat dateFormat = new SimpleDateFormat(dateFormatPattern);


        // save data to selected files using DataOutputStream
        try {
            // Create DataOutputStream objects for each file
            DataOutputStream dos1 = new DataOutputStream(new FileOutputStream(f1));
            DataOutputStream dos2 = new DataOutputStream(new FileOutputStream(f2));
            DataOutputStream dos3 = new DataOutputStream(new FileOutputStream(f3));
            DataOutputStream dos4 = new DataOutputStream(new FileOutputStream(f4));
            DataOutputStream dos5 = new DataOutputStream(new FileOutputStream(f5));


            for (User user : users) {
                if (user instanceof Gold) {
                    dos1.writeInt(user.getUserId());
                    dos1.writeUTF(dateFormat.format(user.getDateOfBirth()));
                    dos1.writeUTF(user.getFirstName());
                    dos1.writeUTF(user.getLastName());
                    dos1.writeUTF(dateFormat.format(user.getRegistrationDate()));
                    dos1.writeUTF(((Gold) user).getPreferredPaymentMethod());
                    dos1.writeInt(((Gold) user).getGoldLevel());
                    dos1.writeUTF("\n");
                } else if (user instanceof Standard) {
                    dos2.writeInt(user.getUserId());
                    dos2.writeUTF(dateFormat.format(user.getDateOfBirth()));
                    dos2.writeUTF(user.getFirstName());
                    dos2.writeUTF(user.getLastName());
                    dos2.writeUTF(dateFormat.format(user.getRegistrationDate()));
                    dos2.writeUTF(((Standard) user).getPreferredPaymentMethod());
                    dos2.writeUTF("\n");
                } else if (user instanceof Host) {
                    dos3.writeInt(user.getUserId());
                    dos3.writeUTF(dateFormat.format(user.getDateOfBirth()));
                    dos3.writeUTF(user.getFirstName());
                    dos3.writeUTF(user.getLastName());
                    dos3.writeUTF(dateFormat.format(user.getRegistrationDate()));
                    dos3.writeDouble(((Host) user).getTaxNumber());
                    dos3.writeUTF("\n");
                }
            }

            for (Property property : properties) {
                if (property instanceof SharedProperty) {
                    dos4.writeInt(property.getPropertyId());
                    dos4.writeInt(property.getNoBedRooms());
                    dos4.writeInt(property.getNoRooms());
                    dos4.writeUTF(property.getCity());
                    dos4.writeDouble(property.getPricePerDay());

                    Host h = property.getHost();
                    dos4.writeInt(h.getUserId());
                    dos4.writeUTF(dateFormat.format(h.getDateOfBirth()));
                    dos4.writeUTF(h.getFirstName());
                    dos4.writeUTF(h.getLastName());
                    dos4.writeUTF(dateFormat.format(h.getRegistrationDate()));
                    dos4.writeDouble(h.getTaxNumber());
                    dos4.writeUTF("\n");
                } else if (property instanceof FullProperty) {
                    dos5.writeInt(property.getPropertyId());
                    dos5.writeInt(property.getNoBedRooms());
                    dos5.writeInt(property.getNoRooms());
                    dos5.writeUTF(property.getCity());
                    dos5.writeDouble(property.getPricePerDay());
                    dos5.writeDouble(((FullProperty) property).getPropertySize());

                    Host h = property.getHost();
                    dos5.writeInt(h.getUserId());
                    dos5.writeUTF(dateFormat.format(h.getDateOfBirth()));
                    dos5.writeUTF(h.getFirstName());
                    dos5.writeUTF(h.getLastName());
                    dos5.writeUTF(dateFormat.format(h.getRegistrationDate()));
                    dos5.writeDouble(h.getTaxNumber());
                    dos5.writeUTF("\n");
                }
            }

            System.out.println("Data saved successfully.");
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("Error writing to file: " + e.getMessage());
        }

    }




    /**
     * This is an auxiliary function used to parse the date
     *
     * @param dateStr This is the date in string format
     * @param sc      This is the scanner object used to take input
     * @return The date in Date format
     */
    private static Date getDate(String dateStr, Scanner sc) {

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
            }

        } while (flag);
        return date;
    }


    /**
     * This is an auxiliary function used to check if a user exists with the id specified
     *
     * @param id This is the user id
     * @return true if user exists else false
     */
    static boolean checkUserExists(int id) {
        for (User user : users) {
            if (user.getUserId() == id) {
                System.out.println("User already exists!\n");
                return true;
            }
        }
        return false;
    }


    /**
     * This function is used to delete a user object from the static users list
     * based on the user id
     *
     * @param id This is the user id
     */
    public static void deleteUser(int id) {

        // first check if user exists
        // then find the index of the user with the specified id
        int i, originalSize;
        originalSize = users.size();

        System.out.println("\n--------DELETE USER--------\n");

        for (i = 0; i < users.size(); i++) {
            if (users.get(i).getUserId() == id) {
                users.remove(i);
                System.out.println("User deleted successfully");
                break;
            }
        }

        // if the size of the user list has not changed
        if (originalSize == users.size()) {
            System.out.println("User not found");
        }
    }

    /**
     * This function is used to display the details of a user given the user id
     *
     * @param userId This is the user id
     */
    public static String getUserDetails(int userId) {

        int i;
        System.out.println("\n----GET USER DETAILS----\n");

        // first check if user exists
        // then find the index of the user with the specified id
        for (i = 0; i < users.size(); i++) {
            if (users.get(i).getUserId() == userId) {
                return users.get(i).toString();
            }
        }
        return "User not found";

    }

    /**
     * This function is used to add a property object to the static properties list
     * Properties can be of type Shared or Full
     * Necessary details are requested from the caller
     *
     * @see Property
     * @see SharedProperty
     * @see FullProperty
     */
    public static void addProperty() {

        int id, choice;
        Scanner sc = new Scanner(System.in);
        System.out.println("\n----ADD PROPERTY----\n");

        //let's check if property already exists
        do {
            System.out.print("Enter Property ID: ");
            id = sc.nextInt();

        } while (checkPropertyExists(id));


        do {
            System.out.print("Which type of property are you adding?\n 1.Shared or 2.Full:  ");
            choice = sc.nextInt();
        } while (choice != 1 && choice != 2);

        if (choice == 1) {
            properties.add(new SharedProperty(id, 0, 0, "", 0));
        } else {
            System.out.println("Enter the size of the property: ");
            double size = sc.nextDouble();
            properties.add(new FullProperty(id, size));

        }


        System.out.print("Enter Number of Bed Rooms: ");
        int noBedRooms = sc.nextInt();
        System.out.print("Enter Number of Rooms: ");
        int noRooms = sc.nextInt();
        System.out.print("Enter City: ");
        String city = sc.next();
        System.out.print("Enter Price Per Day: ");
        double pricePerDay = sc.nextDouble();

        properties.get(properties.size() - 1).setNoBedRooms(noBedRooms);
        properties.get(properties.size() - 1).setNoRooms(noRooms);
        properties.get(properties.size() - 1).setCity(city);
        properties.get(properties.size() - 1).setPricePerDay(pricePerDay);

        System.out.println("Please add Host details");
        System.out.print("Enter Host ID: ");
        id = sc.nextInt();

        if (hostExists(id)) {
            System.out.println("Host already exists!");
            properties.get(properties.size() - 1).setHost(getspecificHost(id));


        } else {
            System.out.print("Enter first name: ");
            String firstName = sc.next();
            System.out.print("Enter last name: ");
            String lastName = sc.next();
            System.out.println("Enter Host Date of Birth: ");
            Date a = getDate(sc.next(), sc);
            System.out.print("Enter registration date (dd/mm/yyyy): ");
            String regDate = sc.next();
            Date b = getDate(regDate, sc);
            System.out.print("Enter the tax number: ");
            double taxNumber = sc.nextDouble();

            properties.get(properties.size() - 1).setHost(new Host(id, a, firstName, lastName, b, taxNumber));

        }
        System.out.println("\nProperty with its host added successfully");
    }

    /**
     * This is an auxiliary function used to get a particular host object
     *
     * @param id This is the host id
     * @return Host object
     */
    private static Host getspecificHost(int id) {
        for (User user : users) {
            if (user instanceof Host && user.getUserId() == id)
                return (Host) user;
        }
        return null;
    }

    /**
     * This is an auxiliary function used to check if a host already exists with the id specified
     *
     * @param id This is the host id
     * @return true if host exists else false
     */
    private static boolean hostExists(int id) {

        for (User user : users) {
            if (user.getClass() == Host.class && user.getUserId() == id)
                return true;
        }
        return false;
    }

    /**
     * This is an auxiliary function used to check if a property already exists with the id specified
     *
     * @param id This is the property id
     * @return true if property exists else false
     */
    static boolean checkPropertyExists(int id) {
        for (Property property : properties) {
            if (property.getPropertyId() == id) {
                System.out.println("Property already exists!\n");
                return true;
            }
        }
        return false;

    }

    /**
     * This function is used to delete a property object from the static properties list
     *
     * @param propertyId This is the property id
     * @see Property
     */
    public static void deleteProperty(int propertyId) {

        int originalSize;
        originalSize = properties.size();
        System.out.println("\n----DELETE PROPERTY----\n");

        for (int i = 0; i < properties.size(); i++) {
            if (properties.get(i).getPropertyId() == propertyId) {
                properties.remove(i);
                System.out.println("Property deleted successfully");
                break;
            }
        }

        // if the size has not changed, property not found
        if (originalSize == properties.size()) {
            System.out.println("Property not found");
        }

    }

    /**
     * This function is used to display the details of a property including its host
     *
     * @param propertyId This is the property id
     */
    public static String getPropertyDetails(int propertyId) {

        int found = 0;

        System.out.println("\n----GET PROPERTY DETAILS----\n");
        for (Property property : properties) {
            if (property.getPropertyId() == propertyId) {
                return property.toString();
            }
        }
        return "Property not found";
    }


    /**
     * This function is used to add a booking object to the bookings list of a particular user
     *
     * @param userId     This is the user id
     * @param propertyId This is the property id
     */
    public static void addBooking(int userId, int propertyId, String startDate, String endDate) {

        // first we check if the user exists
        // then we check if the property exists
        // then we add the booking

        boolean flag = false;
        int uindex = 0, pindex = 0;
        Scanner sc = new Scanner(System.in);

        for (int i = 0; i < users.size(); i++) {
            if (users.get(i).getUserId() == userId && users.get(i) instanceof Customer) {
                uindex = i;
                flag = true;
            }
        }
        if (!flag) {
            System.out.println("User not found");
        } else {
            flag = false;
            for (int i = 0; i < properties.size(); i++) {
                if (properties.get(i).getPropertyId() == propertyId) {
                    pindex = i;
                    flag = true;
                    break;
                }
            }
            if (!flag) {
                System.out.println("Property not found");
            } else {
                // parse dates to a Date format
                Date a = getDate(startDate, sc);
                Date b = getDate(endDate, sc);
                // access the user object and add the booking with the specified dates and property
                ((Customer) users.get(uindex)).addBooking(new Booking(a, b, true, properties.get(pindex)));
                System.out.println("Booking added successfully");
            }
        }
    }


    /**
     * This function is used to display the bookings of a user
     * If the user does not exist or has no bookings, an appropriate message will be displayed
     *
     * @param userId This is the user id
     */
    public static String getUserBooking(int userId) {

        boolean found = false;

        int index = 0;

        for (User u : users) {
            if (u.getUserId() == userId && u instanceof Customer) {
                found = true;
                index = users.indexOf(u);
                break;
            }
        }

        String msg = "";
        if (!found) {
            msg += "User does not exist, Try again!";
        } else if (((Customer) users.get(index)).getBookings().isEmpty()) {
            msg += "User has no bookings!";
        } else {
            System.out.println("\n-------User bookings--------\n");
            Customer u = (Customer) users.get(index);
            for (int i = 0; i < u.getBookings().size(); i++) {
                msg += u.getBookings().get(i).getStartDate() + " till " + u.getBookings().get(i).getEndDate() + "\n";
                msg += "For the " + u.getBookings().get(i).getProperty();
            }
        }
        return msg;
    }

    /**
     * This function displays the total booking cost of the bookings made by a particular user
     * for a particular property
     *
     * @param userId     This is the user id
     * @param propertyId This is the property id
     */
    public static String getBookingCost(int userId, int propertyId) {
        // first identify the booking object for a given user for a given property

        boolean found = false;
        boolean found2 = false;

        String s = "";

        System.out.println("\n----GET BOOKING COST----\n");
        for (User user : users) {

            if (user.getUserId() == userId && user instanceof Customer) {
                {
                    found = true;
                    Customer u = (Customer) user;
                    for (int j = 0; j < u.getBookings().size(); j++) {
                        if (u.getBookings().get(j).getProperty().getPropertyId() == propertyId) {
                            found2 = true;
                            s += ("For the property of Id:  " + u.getBookings().get(j).getProperty().getPropertyId()) + "\n";
                            s += "Booking Start Date: " + u.getBookings().get(j).getStartDate() + "\n";
                            s += ("Booking End Date: " + u.getBookings().get(j).getEndDate()) + "\n";
                            double cost = u.getBookings().get(j).totalCost();
                            cost = cost - (cost * getDiscountForUser(userId));
                            s += "Total Cost: " + cost + "\n\n";
                        }
                    }
                }

            }
        }

        return s;

    }

    /**
     * This function displays all the Users in the system, in a string format
     */
    public static void listUsers() {
        System.out.println("\n----LISTING USERS----\n");
        for (User user : users) {
            System.out.println(user);
            System.out.println();
        }

    }

    /**
     * This function displays all the Properties in the system, in a string format
     */
    public static void listProperties() {
        System.out.println("\n----LISTING PROPERTIES----\n");
        for (Property property : properties) {
            System.out.println(property);
            System.out.println();
        }
    }


    /**
     * This function is used to get the discount percentage of a user
     *
     * @param userId This is the user id
     * @return The discount percentage
     */
    public static double getDiscountForUser(int userId) {
        for (User user : users) {
            if (user.getUserId() == userId && user instanceof Customer) {
                return ((Customer) user).discountPercentage();
            }
        }
        return 0;
    }

    public static void addInspectionToProperty(int propertyId, String str) {

        // check if property exists
        boolean found = false;
        for (Property property : properties) {
            if (property.getPropertyId() == propertyId) {
                Date date = new Date();
                // for testing
//                SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yy");
//                String d = formatter.format(date);
//                System.out.print("Current date: "+d);
                property.addInspection(date, str);
                found = true;
                //displaying for testing purposes
                System.out.println("Inspection added successfully: \n " + property.getInspection());
                break;
            }
        }

        if (!found) {
            System.out.println("Property not found");
        }

    }

    /**
     * This function is used to compare the prices of two properties
     *
     * @param id1 This is the first property id
     * @param id2 This is the second property id
     */
    public static String comparePropertyPricesPerDay(int id1, int id2) {

        System.out.println("\n----COMPARE PROPERTY PRICES PER DAY----\n");
        Property p1 = null;
        Property p2 = null;

        for (Property property : properties) {
            if (property.getPropertyId() == id1) {
                p1 = property;
            }
            if (property.getPropertyId() == id2) {
                p2 = property;
            }
        }

        int compare = p1.compareTo(p2);
        if (compare > 0) {
            return "Property ID " + id2 + " is cheaper";
        } else if (compare < 0) {
            return "Property ID " + id1 + " is cheaper";
        } else {
            return "they have the same price!";
        }

    }


    /**
     * This function is used to exit the CLI booking application from the main method
     * of BASIC class
     */
    public static void exit() {
        System.out.println("Exiting...");
        System.out.println("Goodbye!");
    }

}