
import java.util.ArrayList;
import java.util.Scanner;


public class BASIC {
    public ArrayList<User> users;
    public ArrayList<Property> properties;    // is this okay or should I add arrayList

    public static void main(String[] args){


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

    }

    public void deleteUser(int id){

        System.out.println("----DELETE USER----");
        // first check if user exists
        // then find the index of the user with the specified id

        int i;
        for (i = 0; i < this.users.size(); i++) {
            if (this.users.get(i).getUserId() == id){
                this.users.remove(i);
                break;
            }
        }

        if (i == this.users.size()){
            System.out.println("User not found");
        }

    }

    public void getUserDetails(int id){

        int i;
        System.out.println("----GET USER DETAILS----");
        for (i = 0; i < this.users.size(); i++) {
            if (this.users.get(i).getUserId() == id){
                System.out.println(this.users.get(i).toString());
                break;
            }
        }
    }

    public void addProperty(){

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

    public void deleteProperty(int id){

        int i;
        System.out.println("----DELETE PROPERTY----");

        // first check if property exists
        // then find the index of the property with the specified id

        for (i = 0; i < this.properties.size(); i++) {
            if (this.properties.get(i).getPropertyId() == id){
                this.properties.remove(i);
                break;
            }
        }

        if (i == this.properties.size()){
            System.out.println("Property not found");
        }


    }
    public void getPropertyDetails(int id){

        for (int i = 0; i < this.properties.size(); i++) {
            if (this.properties.get(i).getPropertyId() == id){
                System.out.println(this.properties.get(i).toString());
                break;
            }
        }
    }
    public void addBooking(int userID, int propertyId){

        // first we check if the user exists
        // then we check if the property exists
        // then we add the booking



    }
    public void getUserBooking(int userId){}
    public void getBookingCost(int userId, int propertyId){}
    public void listUsers(){}
    public void listProperties(){}
    public void exit(){}


}
