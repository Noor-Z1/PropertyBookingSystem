package BASIC;

import java.text.DateFormat;
import java.util.Date;
import java.util.ArrayList;



/** Represents a class that stores information about a User
 *  who can make bookings in the system
 * @author Noor Ul Zain
 * @version 1.0
 * @see Booking
 */

class User {

    private int userId;
    private Date dateOfBirth;
    private String firstName;
    private String lastName;
    private ArrayList<Booking> bookings;

    public User() {

    }

    public User(int ID){

        this.userId = ID;
        this.bookings = new ArrayList<Booking>();

    }
    public User(int ID, Date dob, String firstName, String lastName, Booking booking){
        this.userId = ID;
        this.dateOfBirth = dob;
        this.firstName = firstName;
        this.lastName = lastName;
        this.bookings = new ArrayList<Booking>();
        this.bookings.add(booking);  //adding the initial booking

    }

    public User(int ID, Date dob, String firstName, String lastName){
        this.userId = ID;
        this.dateOfBirth = dob;
        this.firstName = firstName;
        this.lastName = lastName;
        this.bookings = new ArrayList<Booking>();

    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * @param booking This is the booking object
     * This function is used to add a booking object to the bookings list of the user.
     */
    public void addBooking(Booking booking){
        this.bookings.add(booking);
    }

    /**
     * @return bookings
     * This function is used to return the list of bookings made by the user.
     *
     */
    public ArrayList<Booking> getBookings(){
        return this.bookings;
    }

    /**
     * This is the function that overrides the toString() method of the object class.
     * @return the string representation of the user.
     */
    public String toString(){
        return "User: userId is " + userId + ", dateOfBirth is " + dateOfBirth.toString() + ", firstName is " + firstName + ", lastName is " + lastName + ".";
    }


}
