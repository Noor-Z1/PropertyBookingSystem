package BASIC.Project2;
import java.util.Date;


/**
 * This class is used to represent a standard customer who is
 * a customer and a user in the system
 * @author Noor Ul Zain
 * @version 1.0
 * @see Customer
 * @see User
 */

class Standard extends Customer{

    /**
     * This is the constructor of the Standard class
     * @param ID id of the customer
     * @param preferredPaymentMethod preferred payment method
     */
    public Standard(int ID, String preferredPaymentMethod) {
        super(ID, preferredPaymentMethod);
    }
    /**
     * This is overloaded constructor of the Standard class
     * @param ID id of the customer
     * @param preferredPaymentMethod preferred payment method
     * @param firstName first name of the customer
     * @param lastName last name of the customer
     * @param registrationDate registration date of the customer
     * @param dob date of birth of the customer
     */
    public Standard(int ID, String preferredPaymentMethod, String firstName, String lastName, Date registrationDate, Date dob) {
        super(ID, firstName, lastName, dob, preferredPaymentMethod, registrationDate);
    }


    /**
     * This method overrides the abstract method in the Customer class
     * @return the discount percentage for a standard customer
     */
    @Override
    double discountPercentage() {
        // we calculate if customer is registered for more than or equal to 10 years
        // if yes we give 2% discount
        // if no we give 0% discount
        Date now = new Date();
        long diff = now.getTime() - this.getRegistrationDate().getTime();

        //here I was getting error if I wrote (1000 * 60 * 60 * 24 * 365)
        //instead of 1000L
        long diffYears = diff / (1000L * 60 * 60 * 24 * 365);
        if (diffYears >= 10) {
            return 0.02;
        } else {
            return 0;
        }
    }

    /**
     * This method returns the Standard object's description
     * by overriding the toString() method of the base class
     * @return the string representation of Standard
     */
    @Override
    public String toString() {
        return super.toString() + ", Customer Type: Standard}";
    }

}
