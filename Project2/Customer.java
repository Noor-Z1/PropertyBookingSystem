package BASIC.Project2;


import java.util.ArrayList;
import java.util.Date;



/**
 * This class extends the User class and represents a Customer.
 * @author Noor Ul Zain
 * @version 1.0
 * @see User
 */
abstract class Customer extends User {
    private String preferredPaymentMethod;
    private ArrayList<Booking> bookings;


    /**
     * This is the default constructor for the Customer class.
     */
    protected Customer() {
        super();
        this.bookings = new ArrayList<>();
    }

    /**
     * This is the overloaded constructor for the Customer class.
     * @param ID This is the ID of the Customer.
     * @param preferredPaymentMethod This is the preferred payment method of the Customer.
     */
   protected Customer(int ID, String preferredPaymentMethod) {
        super(ID);
        this.preferredPaymentMethod = preferredPaymentMethod;
        this.bookings = new ArrayList<>();
    }
    /**
     * This is the overloaded constructor for the Customer class.
     * @param id This is the ID of the Customer.
     * @param firstName This is the first name of the Customer.
     * @param lastName This is the last name of the Customer.
     * @param dateOfBirth This is the date of birth of the Customer.
     * @param preferredPaymentMethod This is the preferred payment method of the Customer.
     */
   protected Customer(int id, String firstName, String lastName, Date dateOfBirth, String preferredPaymentMethod, Date registrationDate) {
        super(id, dateOfBirth, firstName, lastName, registrationDate);
        this.preferredPaymentMethod = preferredPaymentMethod;
        this.bookings = new ArrayList<>();
    }

    public String getPreferredPaymentMethod() {
        return preferredPaymentMethod;
    }

    public void setPreferredPaymentMethod(String preferredPaymentMethod) {
        this.preferredPaymentMethod = preferredPaymentMethod;
    }

    public ArrayList<Booking> getBookings() {
        return bookings;
    }

    public void addBooking(Booking booking) {
        this.bookings.add(booking);
    }

    /** Abstract method to be implemented by subclasses.
     * Returns the discount percentage for a specific item.
     * @return the discount percentage as a double value
     */
    abstract double discountPercentage();

    /**
     * Overrides the toString() method of the base class.
     * @return a string representation of the Customer object
     */
    @Override
    public String toString() {
        return super.toString() + "\nCustomer with Preferred Payment Method: " + preferredPaymentMethod;
    }

}
