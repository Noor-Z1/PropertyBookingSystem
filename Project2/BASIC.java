package BASIC.Project2;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
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
    private JTextArea welcomeToBedAndTextArea;
    private JMenu m;
    private JFileChooser fileNavi;

    BASIC() {
        m = new JMenu("File");
        m.setBackground(Color.BLACK);
        m.setForeground(Color.pink);
        fileNavi = new JFileChooser();
        JMenuItem load = new JMenuItem("Load Data");
        JMenuItem save = new JMenuItem("Save Data");
        load.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });

        m.add(load);
        m.add(save);
        mb.add(m);
        mb.add(new JMenu("Help"));
        setContentPane(mainPanel);
        setTitle("Bed and Breafast");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        pack();
        setVisible(true);

    }

    /**
     * This function is the main function/entry point of the BASIC class
     * It is where the CLI application is executed
     * and the management system is accessed
     *
     * @param args: command line arguments
     */
    public static void main(String[] args) {
        BASIC myframe = new BASIC();
        users.add(new Host(1, 22));
        myframe.setVisible(false);


//        AddUserPage add = new AddUserPage();
//        add.addWindowListener(new WindowAdapter() {
//            @Override
//            public void windowClosed(WindowEvent e) {
//
//                myframe.users = add.getUsers();
//                myframe.setVisible(true);
//                System.out.println(myframe.users);
//            }
//        });
//
//        DeleteUser delete = new DeleteUser(users);
//        delete.setMainframe(myframe);
//        delete.addWindowListener(new WindowAdapter() {
//            @Override
//            public void windowClosed(WindowEvent e) {
//
//                myframe.setVisible(true);
//                System.out.println(myframe.users);
//
//            }
//        });

        // now lets test add property
        AddPropertyPage add = new AddPropertyPage();
        add.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosed(WindowEvent e) {
                myframe.setVisible(true);
                System.out.println(myframe.properties);
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

    public static void menu() {

        System.out.println("\n----MENU----");

        System.out.println("3. Get User Details");
        System.out.println("5. Delete Property");
        System.out.println("6. Get Property Details");
        System.out.println("7. Add Booking");
        System.out.println("8. Get User Booking");
        System.out.println("9. Get Booking Cost");
        System.out.println("10. List Users");
        System.out.println("11. List Properties");
        System.out.println("12. Exit");


        System.out.println("13. Get Discount");
        System.out.println("14. Add Inspection to Property");
        System.out.println("15. Compare Property Prices (per day)");
        System.out.print("Enter your choice: ");

    }


    /**
     * This function is used to add a user object to the static users list of the BASIC class
     * A user can be either Host or Customer
     * Necessary details are requested from the caller
     *
     * @see Host
     * @see Customer
     */
    private static void addUser() {

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
                System.out.print("Enter dob (dd/mm/yyyy): ");
                dateStr = sc.next();
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
    public static void getPropertyDetails(int propertyId) {

        int found = 0;

        System.out.println("\n----GET PROPERTY DETAILS----\n");
        for (Property property : properties) {
            if (property.getPropertyId() == propertyId) {
                System.out.println(property);
                found = 1;
                break;
            }
        }
        if (found == 0) {
            System.out.println("This Property does not exist!");
        }
    }


    /**
     * This function is used to add a booking object to the bookings list of a particular user
     *
     * @param userId     This is the user id
     * @param propertyId This is the property id
     */
    public static void addBooking(int userId, int propertyId) {

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
                System.out.println("Please add booking details");
                System.out.println("Enter start date (dd/mm/yyyy): ");
                String startDate = sc.next();
                System.out.println("Enter end date (dd/mm/yyyy): ");
                String endDate = sc.next();
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
    public static void getUserBooking(int userId) {

        boolean found = false;

        int index = 0;

        for (User u : users) {
            if (u.getUserId() == userId && u instanceof Customer) {
                found = true;
                index = users.indexOf(u);
                break;
            }
        }

        if (!found) {
            System.out.println("User does not exist, Try again!");
        } else if (((Customer) users.get(index)).getBookings().isEmpty()) {
            System.out.println("User has no bookings!");
        } else {
            System.out.println("\n-------User bookings--------\n");
            Customer u = (Customer) users.get(index);
            for (int i = 0; i < u.getBookings().size(); i++) {
                System.out.println(u.getBookings().get(i).getStartDate() + " till " + u.getBookings().get(i).getEndDate());
                System.out.println("For the " + u.getBookings().get(i).getProperty());
                System.out.println();
            }
        }

    }

    /**
     * This function displays the total booking cost of the bookings made by a particular user
     * for a particular property
     *
     * @param userId     This is the user id
     * @param propertyId This is the property id
     */
    public static void getBookingCost(int userId, int propertyId) {
        // first identify the booking object for a given user for a given property

        boolean found = false;
        boolean found2 = false;


        System.out.println("\n----GET BOOKING COST----\n");
        for (User user : users) {
            if (user.getUserId() == userId && user instanceof Customer) {
                {
                    found = true;
                    Customer u = (Customer) user;
                    for (int j = 0; j < u.getBookings().size(); j++) {
                        if (u.getBookings().get(j).getProperty().getPropertyId() == propertyId) {
                            found2 = true;
                            System.out.println("\nFor the property of Id:  " + u.getBookings().get(j).getProperty().getPropertyId());
                            System.out.println("Booking Start Date: " + u.getBookings().get(j).getStartDate());
                            System.out.println("Booking End Date: " + u.getBookings().get(j).getEndDate());
                            double cost = u.getBookings().get(j).totalCost();
                            cost = cost - (cost * getDiscountForUser(userId));
                            System.out.println("Total Cost: " + cost);
                        }
                    }
                }

            }
        }

        if (!found) {
            System.out.println("User does not exist, Try again!");
        }
        if (!found2) {
            System.out.println("Property does not exist, Try again!");
        }


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