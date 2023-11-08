
import java.text.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;


public class BASIC {
    public static ArrayList<User> users;
    public static ArrayList<Property> properties;

    public static void main(String[] args) {

        int choice, userId, propertyId;

        menu();
        Scanner sc = new Scanner(System.in);
        choice = sc.nextInt();


        switch (choice) {
            case 1 -> addUser();
            case 2 -> {
                System.out.println("Enter User ID");
                userId = sc.nextInt();
                deleteUser(userId);
            }
            case 3 -> {
                System.out.println("Enter User ID");
                userId = sc.nextInt();
                getUserDetails(userId);
            }
            case 4 -> addProperty();
            case 5 -> {
                System.out.println("Enter Property ID");
                propertyId = sc.nextInt();
                deleteProperty(propertyId);
            }
            case 6 -> {
                System.out.println("Enter Property ID");
                propertyId = sc.nextInt();
                getPropertyDetails(propertyId);
            }
            case 7 -> {
                System.out.println("Enter User ID");
                userId = sc.nextInt();
                System.out.println("Enter Property ID");
                propertyId = sc.nextInt();
                addBooking(userId, propertyId);
            }
            case 8 -> {
                System.out.println("Enter User ID");
                userId = sc.nextInt();
                getUserBooking(userId);
            }
            case 9 -> {
                System.out.println("Enter Booking ID");
                userId = sc.nextInt();
                System.out.println("Enter Property ID");
                propertyId = sc.nextInt();
                getBookingCost(userId, propertyId);
            }
            case 10 -> listUsers();
            case 11 -> listProperties();
            case 12 -> exit();
        }
    }


    public static void menu(){

        System.out.println("----MENU----");
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

    }


    /**
     * This function is used to add a user object to the static users list
     * of the BASIC class
     */
    public static void addUser(){

        int id;

        Scanner sc = new Scanner(System.in);
        System.out.println("----ADD USER----");

        // check if user already exists
        do {
            System.out.println("Enter User ID: ");
            id = sc.nextInt();
        }while(checkUserExists(id));

        users.add(new User(id));
        System.out.println("User added successfully");
        System.out.println("Would you like to add details for the user?");
        char choice = sc.next().charAt(0);
        if (choice == 'y' || choice == 'Y'){
            System.out.println("Enter first name: ");
            String firstName = sc.next();
            System.out.println("Enter last name: ");
            String lastName = sc.next();
            System.out.println("Enter dob (dd/mm/yyyy: ");
            String dob = sc.next();

            // parse dob to a Date format
            Date a = new Date();

            try {
                a = new SimpleDateFormat("dd/mm/yyyy").parse(dob);
            } catch (ParseException e) {
                System.out.println("Invalid date format");
                System.out.println("Try again");
            }
            //access the user object and add the details
            users.get(users.size() - 1).setFirstName(firstName);
            users.get(users.size() - 1).setLastName(lastName);
            users.get(users.size() - 1).setDateOfBirth(a);

        }
        else{
            System.out.println("Add details for the user later, thank you!");

        }

    }

    /**
     *
     * This is an auxiliary function used to check if a user exists with the id specified
     * @param id
     * @return true if user exists else false
     *
     */
    private static boolean checkUserExists(int id) {
        for (User user : users){
            if (user.getUserId() == id){
                return true;
            }
        }
        return false;
    }

    /**
     * This function is used to delete a user object from the static users list
     * @return true if user exists else false
     *
     */
    public static void deleteUser(int id){
        // first check if user exists
        // then find the index of the user with the specified id
        int i, originalSize;
        originalSize = users.size();

        System.out.println("----DELETE USER----");

        for (i = 0; i < users.size(); i++) {
            if (users.get(i).getUserId() == id){
                users.remove(i);
                break;
            }
        }

        // if the size of the user list has not changed
        if (originalSize == users.size()){
            System.out.println("User not found");
        }
    }

    public static void getUserDetails(int userId){

        int i, found = 0;
        System.out.println("----GET USER DETAILS----");

        // first check if user exists
        // then find the index of the user with the specified id
        for (i = 0; i < users.size(); i++) {
            if (users.get(i).getUserId() == userId){
                System.out.println(users.get(i).toString());
                found = 1;
                break;
            }
        }
        if (found == 0){
            System.out.println("This User does not exist!");
        }

    }

    /**
     * This function is used to add a property object to the static properties list
     *
     */
    public static void addProperty(){

        int id;
        Scanner sc = new Scanner(System.in);
        System.out.println("----ADD PROPERTY----");

        //let's check if property already exists
        do{
            System.out.println("Enter Property ID: ");
            id = sc.nextInt();

        }while (checkPropertyExists(id));
        System.out.println("Enter Number of Bed Rooms: ");
        int noBedRooms = sc.nextInt();
        System.out.println("Enter Number of Rooms: ");
        int noRooms = sc.nextInt();
        System.out.println("Enter City: ");
        String city = sc.next();
        System.out.println("Enter Price Per Day: ");
        float pricePerDay = sc.nextFloat();


        System.out.println("Please add Host details");
        System.out.println("Enter User ID: ");
        id = sc.nextInt();
        System.out.println("Enter first name: ");
        String firstName = sc.next();
        System.out.println("Enter last name: ");
        String lastName = sc.next();
        System.out.println("Enter registration date (dd/mm/yyyy): ");
        String regDate = sc.next();

        // parse registration date to a Date format
        Date a = new Date();
        try {
            a = new SimpleDateFormat("dd/mm/yyyy").parse(regDate);
        }
        catch (ParseException e){
            System.out.println("Invalid date format");
            System.out.println("Try again");
        }
        //access the property object and add the details
        properties.add(new Property(id, noBedRooms, noRooms, city, pricePerDay, new Host(id, firstName, lastName, a)));
        System.out.println("Property with its host added successfully");

    }

    /**
     * This is an auxiliary function used to check if a property already exists with the id specified
     * @param id
     * @return true if property exists else false
     */
    private static boolean checkPropertyExists(int id) {
        for (Property property : properties){
            if (property.getPropertyId() == id){
                return true;
            }
        }
        return false;

    }

    /**
     * This function is used to delete a property object from the static properties list
     * @param propertyId
     */
    public static void deleteProperty(int propertyId){

        int originalSize;
        originalSize = properties.size();
        System.out.println("----DELETE PROPERTY----");

        for (int i = 0; i < properties.size(); i++) {
            if (properties.get(i).getPropertyId() == propertyId){
                properties.remove(i);
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
     * @param propertyId
     */
    public static void getPropertyDetails(int propertyId){

        int found = 0;
        for (Property property : properties) {
            if (property.getPropertyId() == propertyId) {
                System.out.println(property.toString());
                found = 1;
                break;
            }
        }
        if (found == 0){
            System.out.println("This Property does not exist!");
        }
    }

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
                a = new SimpleDateFormat("dd/mm/yyyy").parse(startDate);
                b = new SimpleDateFormat("dd/mm/yyyy").parse(endDate);
            } catch (ParseException e) {
                System.out.println("Invalid date format");
                System.out.println("Try again");
            }

            // we also need to check if the property is available for the given dates
            users.get(uindex).addBooking(new Booking(a, b, properties.get(pindex)));

        }


        

    }

    public static void getUserBooking(int userId){

        User u = new User();
        for (int i = 0; i < users.size(); i++) {
            if (users.get(i).getUserId() == userId){
                u = users.get(i);
                break;
            }
        }

        if (u == null){
            System.out.println("User not found");
        }
        else if(u.getBookings().size() == 0){
            System.out.println("User has no bookings");
        }
        else {
            for (int i = 0; i < u.getBookings().size(); i++) {
                System.out.println(u.getBookings().get(i).toString());
            }
        }

    }

    public static void getBookingCost(int userId, int propertyId){
        // first identify the booking object for a given user for a given property
        // re check this

        for (User user : users) {
            if (user.getUserId() == userId) {
                for (int j = 0; j < user.getBookings().size(); j++) {
                    if (user.getBookings().get(j).getProperty().getPropertyId() == propertyId) {
                        System.out.println("Booking Cost: " + user.getBookings().get(j).totalCost());
                    }
                }
            }
        }
    }


    public static void listUsers(){
        for (User user : users) {
            System.out.println(user.toString());
        }
    }
    public static void listProperties(){
        for (Property property : properties) {
            System.out.println(property.toString());
        }
    }
    public static void exit(){

        System.out.println("Exiting...");
        System.out.println("Goodbye!");
        exit();
    }


}


class PopulateData{

    void populate(){


        Property p1 = new Property(1, 3, 3, "Barcelona", 200);
        Property p2 = new Property(2, 2, 2, "Madrid", 150);
        Property p3 = new Property(3, 4, 4, "Valencia", 300);

        p1.setHost( new Host(22, "Marcus", "Weiser", new Date("01/2/2017")) );
        p2.setHost( new Host(33, "John", "Karis", new Date("22/5/2018")) );
        p3.setHost( new Host(44, "Carolina", "Silva", new Date("17/8/2022")) );


//        Booking b1 = new Booking(new Date("4/06/2023"), new Date("01/07/2023"), true, p1);
//        Booking b2 = new Booking(new Date("9/08/2023"), new Date("01/09/2023"), false, p2);
//        Booking b3 = new Booking(new Date("14/10/2023"), new Date("01/11/2023"), true, p3);


        // add users (custom)
        User u1 = new User(2243);
        User u2 = new User(3450);
        User u3 = new User(9239);


//        u1.setFirstName("Leena");
//        u1.setLastName("Smith");
//        u1.setDateOfBirth(new Date("12/7/2001"));
//        u1.addBooking(b1);
//        u2.setFirstName("Amber");
//        u2.setLastName("Jade");
//        u2.setDateOfBirth(new Date("4/2/1997"));
//        u2.addBooking(b2);
//        u3.setFirstName("Sarah");
//        u3.setLastName("Williams");
//        u3.setDateOfBirth(new Date("30/1/1999"));
//        u3.addBooking(b3);


        BASIC.users = new ArrayList<User>();
        BASIC.properties = new ArrayList<Property>();

        BASIC.users.add(u1);
        BASIC.users.add(u2);
        BASIC.users.add(u3);
        BASIC.properties.add(p1);
        BASIC.properties.add(p2);
        BASIC.properties.add(p3);


    }


}