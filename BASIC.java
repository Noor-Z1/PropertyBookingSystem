
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;



public class BASIC {
    public static ArrayList<User> users;
    public static ArrayList<Property> properties;

    public static void main(String[] args) {

//        int choice, userId, propertyId;
//
//        menu();
//        Scanner sc = new Scanner(System.in);
//        choice = sc.nextInt();
//
//
//        switch (choice) {
//            case 1:
//                addUser();
//                break;
//            case 2:
//                System.out.println("Enter User ID");
//                userId = sc.nextInt();
//                deleteUser(userId);
//                break;
//            case 3:
//                System.out.println("Enter User ID");
//                userId = sc.nextInt();
//                getUserDetails(userId);
//                break;
//            case 4:
//                addProperty();
//                break;
//            case 5:
//                System.out.println("Enter Property ID");
//                propertyId = sc.nextInt();
//                deleteProperty(propertyId);
//                break;
//            case 6:
//                System.out.println("Enter Property ID");
//                propertyId = sc.nextInt();
//                getPropertyDetails(propertyId);
//                break;
//            case 7:
//                System.out.println("Enter User ID");
//                userId = sc.nextInt();
//                System.out.println("Enter Property ID");
//                propertyId = sc.nextInt();
//                addBooking(userId, propertyId);
//                break;
//            case 8:
//                System.out.println("Enter User ID");
//                userId = sc.nextInt();
//                getUserBooking(userId);
//                break;
//            case 9:
//                System.out.println("Enter Booking ID");
//                userId = sc.nextInt();
//                System.out.println("Enter Property ID");
//                propertyId = sc.nextInt();
//                getBookingCost(userId, propertyId);
//                break;
//            case 10:
//                listUsers();
//                break;
//            case 11:
//                listProperties();
//                break;
//            case 12:
//                exit();
//                break;
//


        //}
    }


    public void menu(){

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
    public void addUser(){

        Scanner sc = new Scanner(System.in);
        System.out.println("----ADD USER----");
        System.out.println("Enter User ID: ");
        int id = sc.nextInt();
        this.users.add(new User(id));
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


            //access the user object and add the details
            this.users.get(this.users.size() - 1).setFirstName(firstName);
            this.users.get(this.users.size() - 1).setLastName(lastName);

        }
        else{
            System.out.println("Add details for the user later, thank you!");

        }

    }

    public void deleteUser(int id){

        System.out.println("----DELETE USER----");
        // first check if user exists
        // then find the index of the user with the specified id

        int i, originalSize;
        originalSize = this.users.size();

        for (i = 0; i < this.users.size(); i++) {
            if (this.users.get(i).getUserId() == id){
                this.users.remove(i);
                break;
            }
        }

        // if the size of the user list has not changed
        if (originalSize == this.users.size()){
            System.out.println("User not found");
        }
    }

    public  void getUserDetails(int userId){

        int i, found = 0;
        System.out.println("----GET USER DETAILS----");

        // first check if user exists
        // then find the index of the user with the specified id
        for (i = 0; i < this.users.size(); i++) {
            if (this.users.get(i).getUserId() == userId){
                System.out.println(this.users.get(i).toString());
                found = 1;
                break;
            }
        }
        if (found == 0){
            System.out.println("This User does not exist!");
        }

    }

    public  void addProperty(){

        System.out.println("----ADD PROPERTY----");
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Property ID: ");
        int id = sc.nextInt();
        System.out.println("Enter Number of Bed Rooms: ");
        int noBedRooms = sc.nextInt();
        System.out.println("Enter Number of Rooms: ");
        int noRooms = sc.nextInt();
        System.out.println("Enter City: ");
        String city = sc.next();
        System.out.println("Enter Price Per Day: ");
        float pricePerDay = sc.nextFloat();
        this.properties.add(new Property(id, noBedRooms, noRooms, city, pricePerDay));

    }

    public  void deleteProperty(int propertyId){

        int originalSize;
        System.out.println("----DELETE PROPERTY----");
        originalSize = this.properties.size();

        for (int i = 0; i < this.properties.size(); i++) {
            if (this.properties.get(i).getPropertyId() == propertyId){
                this.properties.remove(i);
                break;
            }
        }

        if (originalSize == this.properties.size()){
            System.out.println("Property not found");
        }

    }
    public  void getPropertyDetails(int propertyId){

        int found = 0;
        for (int i = 0; i < this.properties.size(); i++) {
            if (this.properties.get(i).getPropertyId() == propertyId){
                System.out.println(this.properties.get(i).toString());
                found = 1;
                break;
            }
        }
        if (found == 0){
            System.out.println("This Property does not exist!");
        }
    }
    public  void addBooking(int userId, int propertyId){

        // first we check if the user exists
        // then we check if the property exists
        // then we add the booking

        boolean flag = false;
        int index = 0;

        for (int i = 0; i < this.users.size(); i++) {
           if (this.users.get(i).getUserId() == userId){
               index = i;
               flag = true;
           }
        }
        if (flag == false){
            System.out.println("User not found");
        }

        flag = false;
        for (int i = 0; i < this.properties.size(); i++) {
           if (this.properties.get(i).getPropertyId() == propertyId){
               flag = true;
           }
        }
        if (flag == false){
            System.out.println("Property not found");
        }

        if (flag == true){
          this.users.get(index).addBooking(new Booking());
        }
        

    }

    public void getUserBooking(int userId){

        User u = new User();
        for (int i = 0; i < this.users.size(); i++) {
            if (this.users.get(i).getUserId() == userId){
                u = this.users.get(i);
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

    public  void getBookingCost(int userId, int propertyId){
        // first identify the booking object for a given user for a given property
        // re check this

        for (int i = 0; i < this.users.size(); i++) {
            if (this.users.get(i).getUserId() == userId){
                for (int j = 0; j < this.users.get(i).getBookings().size(); j++) {
                    if (this.users.get(i).getBookings().get(j).getProperty().getPropertyId() == propertyId){
                        System.out.println("Booking Cost: " + this.users.get(i).getBookings().get(j).totalCost());
                    }
                }
            }
        }
    }


    public  void listUsers(){
        for (int i = 0; i < this.users.size(); i++) {
            System.out.println(this.users.get(i).toString());
        }
    }
    public void listProperties(){
        for (int i = 0; i < this.properties.size(); i++) {
            System.out.println(this.properties.get(i).toString());
        }
    }
    public  void exit(){

        System.out.println("Exiting...");
        System.out.println("Goodbye!");
        exit();
    }


}


class PopulateData{

    void populate(){

        BASIC.users = new ArrayList<User>();
        BASIC.properties = new ArrayList<Property>();




    }





}