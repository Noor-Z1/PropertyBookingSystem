package BASIC.Project2;
import java.util.Date;




/** Represents a class that stores information about a User
 *  who can make bookings in the system
 *  It is an abstract class and must be extended by subclasses
 * @author Noor Ul Zain
 * @version 2.0
 * @see Booking
 */
abstract class User {

    private int userId;
    private Date dateOfBirth;
    private String firstName;
    private String lastName;
    private Date registrationDate;


    /**
     * This is the default constructor of the User class
     */
    protected User() {}

    /**
     * This is the overloaded constructor of the User class
     * @param ID This is the user id
     */
    protected User(int ID) {
        this.userId = ID;
    }

    /**
     * This is the overloaded constructor of the User class
     * @param ID This is the user id
     * @param dob This is the date of birth
     * @param firstName This is the first name
     * @param lastName This is the last name
     * @param registrationDate This is the registration date
     */
    protected User(int ID, Date dob, String firstName, String lastName, Date registrationDate) {
        this.userId = ID;
        this.dateOfBirth = dob;
        this.firstName = firstName;
        this.lastName = lastName;
        this.registrationDate = registrationDate;
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

    public Date getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(Date registrationDate) {
        this.registrationDate = registrationDate;
    }


    /**
     * This is the function that overrides the toString() method of the object class.
     * @return the string representation of the user.
     */
    public String toString() {
        return "User " +
                "userId = " + userId + "\n" +
                "dateOfBirth = " + dateOfBirth + "\n"+
                "firstName = " + firstName + " " +
                "lastName = " + lastName + "\n"+
                "registrationDate = " + registrationDate + "\n";
    }

}


