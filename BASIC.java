package BASIC;

import java.text.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;


/** Represents a class that manages users and properties for a booking system.
 * @author Noor Ul Zain
 * @version 1.0
 */
public class BASIC {
    public static ArrayList<User> users;
    public static ArrayList<Property> properties;

    public static void main(String[] args) throws ParseException {

        int choice, userId, propertyId;

        PopulateData.populate();  // it is a static method


        do {
            menu();
            Scanner sc = new Scanner(System.in);
            choice = sc.nextInt();

            switch (choice) {
                case 1 -> addUser();
                case 2 -> {
                    System.out.print("Enter User ID: ");
                    userId = sc.nextInt();
                    deleteUser(userId);
                }
                case 3 -> {
                    System.out.print("Enter User ID: ");
                    userId = sc.nextInt();
                    getUserDetails(userId);
                }
                case 4 -> addProperty();
                case 5 -> {
                    System.out.print("Enter Property ID: ");
                    propertyId = sc.nextInt();
                    deleteProperty(propertyId);
                }
                case 6 -> {
                    System.out.print("Enter Property ID: ");
                    propertyId = sc.nextInt();
                    getPropertyDetails(propertyId);
                }
                case 7 -> {
                    System.out.print("Enter User ID: ");
                    userId = sc.nextInt();
                    System.out.print("Enter Property ID: ");
                    propertyId = sc.nextInt();
                    addBooking(userId, propertyId);
                }
                case 8 -> {
                    System.out.print("Enter User ID: ");
                    userId = sc.nextInt();
                    getUserBooking(userId);
                }
                case 9 -> {
                    System.out.print("Enter User ID: ");
                    userId = sc.nextInt();
                    System.out.print("Enter Property ID: ");
                    propertyId = sc.nextInt();
                    getBookingCost(userId, propertyId);
                }
                case 10 -> listUsers();
                case 11 -> listProperties();
                case 12 -> exit();
                default -> System.out.println("Invalid choice");

            }

        }while (choice != 12) ;
    }


    public static void menu(){

        System.out.println("\n----MENU----");
        System.out.println("1. Add User");
        System.out.println("2. Delete User");
        System.out.println("3. Get User Details");
        System.out.println("4. Add Property");
        System.out.println("5. Delete Property");
        System.out.println("6. Get Property Details");
        System.out.println("7. Add Booking");
        System.out.println("8. Get User Booking");
        System.out.println("9. Get Booking Cost");
        System.out.println("10. List Users");
        System.out.println("11. List Properties");
        System.out.println("12. Exit");
        System.out.print("Enter your choice: ");

    }


    /**
     * This function is used to add a user object to the static users list
     * of the BASIC class
     */
    public static void addUser(){

        int id;

        Scanner sc = new Scanner(System.in);
        System.out.println("\n----ADD USER----\n");

        // check if user already exists
        do {
            System.out.print("Enter User ID: ");
            id = sc.nextInt();
        }while(checkUserExists(id));

        users.add(new User(id));
        System.out.println("User added successfully");
        System.out.println("Add more details for the user");
        System.out.print("Enter first name: ");
        String firstName = sc.next();
        System.out.print("Enter last name: ");
        String lastName = sc.next();
        System.out.print("Enter dob (dd/mm/yyyy): ");
        String dob = sc.next();


        // parse dob to a Date format
        Date a = new Date();

        boolean flag;
        do {
           flag = false;
            try {
                a = new SimpleDateFormat("dd/MM/yyyy").parse(dob);
            } catch (ParseException e) {
                System.out.println("\nInvalid date format");
                flag = true;
                System.out.println("Try again");
                System.out.print("Enter dob (dd/mm/yyyy): ");
                dob = sc.next();
            }

        }while (flag);

        //access the user object and add the details
        users.get(users.size() - 1).setFirstName(firstName);
        users.get(users.size() - 1).setLastName(lastName);
        users.get(users.size() - 1).setDateOfBirth(a);
        System.out.println("User added successfully");

    }


    /**
     * This is an auxiliary function used to check if a user exists with the id specified
     * @param id This is the user id
     * @return true if user exists else false
     */
    private static boolean checkUserExists(int id) {
        for (User user : users){
            if (user.getUserId() == id){
                System.out.println("User already exists!\n");
                return true;
            }
        }
        return false;
    }

    /**
     * This function is used to delete a user object from the static users list
     */
    public static void deleteUser(int id){
        // first check if user exists
        // then find the index of the user with the specified id
        int i, originalSize;
        originalSize = users.size();

        System.out.println("\n----DELETE USER----\n");

        for (i = 0; i < users.size(); i++) {
            if (users.get(i).getUserId() == id){
                users.remove(i);
                System.out.println("User deleted successfully");
                break;
            }
        }

        // if the size of the user list has not changed
        if (originalSize == users.size()){
            System.out.println("User not found");
        }
    }

    /**
     *
     * This function is used to display the details of a user given the user id
     * @param userId This is the user id
     */
    public static void getUserDetails(int userId){

        int i, found = 0;
        System.out.println("\n----GET USER DETAILS----\n");

        // first check if user exists
        // then find the index of the user with the specified id
        for (i = 0; i < users.size(); i++) {
            if (users.get(i).getUserId() == userId){
                System.out.println(users.get(i));
                found = 1;
                break;
            }
        }
        if (found == 0){
            System.out.println("\nThis User does not exist!");
        }

    }

    /**
     * This function is used to add a property object to the static properties list
     */
    public static void addProperty(){

        int id;
        Scanner sc = new Scanner(System.in);
        System.out.println("\n----ADD PROPERTY----\n");

        //let's check if property already exists
        do{
            System.out.print("Enter Property ID: ");
            id = sc.nextInt();

        }while (checkPropertyExists(id));
        System.out.print("Enter Number of Bed Rooms: ");
        int noBedRooms = sc.nextInt();
        System.out.print("Enter Number of Rooms: ");
        int noRooms = sc.nextInt();
        System.out.print("Enter City: ");
        String city = sc.next();
        System.out.print("Enter Price Per Day: ");
        float pricePerDay = sc.nextFloat();


        System.out.println("Please add Host details");
        System.out.print("Enter Host ID: ");
        id = sc.nextInt();
        System.out.print("Enter first name: ");
        String firstName = sc.next();
        System.out.print("Enter last name: ");
        String lastName = sc.next();
        System.out.print("Enter registration date (dd/mm/yyyy): ");
        String regDate = sc.next();

        // parse registration date to a Date format
        Date a = new Date();
        try {
            a = new SimpleDateFormat("dd/MM/yyyy").parse(regDate);
        }
        catch (ParseException e){
            System.out.println("Invalid date format");
            System.out.println("Try again");
        }
        //access the property object and add the details
        //properties.add(new Property(id, noBedRooms, noRooms, city, pricePerDay, new Host(id, firstName, lastName, a)));
        System.out.println("\nProperty with its host added successfully");

    }

    /**
     * This is an auxiliary function used to check if a property already exists with the id specified
     * @param id This is the property id
     * @return true if property exists else false
     */
    private static boolean checkPropertyExists(int id) {
        for (Property property : properties){
            if (property.getPropertyId() == id){
                System.out.println("Property already exists!\n");
                return true;
            }
        }
        return false;

    }

    /**
     * This function is used to delete a property object from the static properties list
     * @param propertyId This is the property id
     */
    public static void deleteProperty(int propertyId){

        int originalSize;
        originalSize = properties.size();
        System.out.println("\n----DELETE PROPERTY----\n");

        for (int i = 0; i < properties.size(); i++) {
            if (properties.get(i).getPropertyId() == propertyId){
                properties.remove(i);
                System.out.println("Property deleted successfully");
                break;
            }
        }

        // if the size has not changed, property not found
        if (originalSize == properties.size()){
            System.out.println("Property not found");
        }

    }

    /**
     * This function is used to display the details of a property including its host
     * @param propertyId This is the property id
     */
    public static void getPropertyDetails(int propertyId){

        int found = 0;

        System.out.println("\n----GET PROPERTY DETAILS----\n");
        for (Property property : properties) {
            if (property.getPropertyId() == propertyId) {
                System.out.println(property);
                found = 1;
                break;
            }
        }
        if (found == 0){
            System.out.println("This Property does not exist!");
        }
    }


    /**
     * This function is used to add a booking object to the bookings list of a particular user
     * @param userId  This is the user id
     * @param propertyId This is the property id
     */
    public static void addBooking(int userId, int propertyId){

        // first we check if the user exists
        // then we check if the property exists
        // then we add the booking

        boolean flag = false;
        int uindex = 0, pindex = 0;
        Scanner sc = new Scanner(System.in);

        for (int i = 0; i < users.size(); i++) {
           if (users.get(i).getUserId() == userId){
               uindex = i;
               flag = true;
           }
        }
        if (!flag){
            System.out.println("User not found");
        }

        flag = false;
        for (int i = 0; i < properties.size(); i++) {
            if (properties.get(i).getPropertyId() == propertyId) {
                pindex = i;
                flag = true;
                break;
            }
        }
        if (!flag){
            System.out.println("Property not found");
        }
        else{
            System.out.println("Please add booking details");
            System.out.println("Enter start date (dd/mm/yyyy): ");
            String startDate = sc.next();
            System.out.println("Enter end date (dd/mm/yyyy): ");
            String endDate = sc.next();
            // parse dates to a Date format
            Date a = new Date();
            Date b = new Date();
            try {
                a = new SimpleDateFormat("dd/MM/yyyy").parse(startDate);
                b = new SimpleDateFormat("dd/MM/yyyy").parse(endDate);
            } catch (ParseException e) {
                System.out.println("Invalid date format");
                System.out.println("Try again");
            }

            // access the user object and add the booking with the specified dates and property
            users.get(uindex).addBooking(new Booking(a, b, properties.get(pindex)));

        }

    }

    /**
     * This function is used to display the bookings of a user
     * If the user does not exist or has no bookings, an appropriate message will be displayed
     * @param userId This is the user id
     */
    public static void getUserBooking(int userId){

        boolean found = false;

        User u = new User();
        for (int i = 0; i < users.size(); i++) {
            if (users.get(i).getUserId() == userId){
                found = true;
                u = users.get(i);
                break;
            }
        }

        if (!found){
            System.out.println("User does not exist, Try again!");
        }
        else if(u.getBookings().size() == 0){
            System.out.println("User has no bookings!");
        }
        else {
            System.out.println("\n-------User bookings--------\n");
            for (int i = 0; i < u.getBookings().size(); i++) {
                System.out.println(u.getBookings().get(i).getStartDate() + " till " + u.getBookings().get(i).getEndDate());
                System.out.println( "For the " +u.getBookings().get(i).getProperty());
                System.out.println();
            }
        }

    }

    /**
     * This function displays the total booking cost of the bookings made by a particular user
     * for a particular property
     * @param userId This is the user id
     * @param propertyId This is the property id
     */
    public static void getBookingCost(int userId, int propertyId){
        // first identify the booking object for a given user for a given property

        boolean found = false;
        boolean found2 = false;

        System.out.println("\n----GET BOOKING COST----\n");
        for (User user : users) {
            if (user.getUserId() == userId) {
                found = true;
                for (int j = 0; j < user.getBookings().size(); j++) {
                    if (user.getBookings().get(j).getProperty().getPropertyId() == propertyId) {
                        found2 = true;
                        System.out.println("\nFor the property of Id:  " + user.getBookings().get(j).getProperty().getPropertyId());
                        System.out.println("Booking Start Date: " + user.getBookings().get(j).getStartDate());
                        System.out.println("Booking End Date: " + user.getBookings().get(j).getEndDate());
                        System.out.println("Booking Cost: " + user.getBookings().get(j).totalCost());
                    }
                }
            }

        }
        if (!found){
            System.out.println("User does not exist, Try again!");
        }
        if (!found2){
            System.out.println("Property does not exist, Try again!");
        }

    }

    /**
     * This function displays all the Users in the system, in a string format
     */
    public static void listUsers(){
        System.out.println("\n----LISTING USERS----\n");
        for (User user : users) {
            System.out.println(user);
            System.out.println();
        }

    }

    /**
     * This function displays all the Properties in the system, in a string format
     */
    public static void listProperties(){
        System.out.println("\n----LISTING PROPERTIES----\n");
        for (Property property : properties) {
            System.out.println(property);
            System.out.println();
        }
    }


    public static double getDiscountForUser(int a){
        return 0;
    }

    public static void addInspectionToProperty(int a, String b){}

    public void comparePropertyPricesPerDay(int a, int b){}

    /**
     * This function is used to exit the CLI booking application from the main method
     * of BASIC class
     */
    public static void exit(){
        System.out.println("Exiting...");
        System.out.println("Goodbye!");
    }

}

