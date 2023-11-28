package BASIC.Project2;

import java.util.Date;


/** Represents a class that stores information about a Host
 *  who owns a Property in the system
 * @author Noor Ul Zain
 * @version 2.0
 * @see Property
 */
class Host extends User{

    private double taxNumber;

    /**
     * This is the default constructor
     */
    protected Host(){
        super();
    }

    /**
     * This is the overloaded constructor
     * @param hostID the id of the Host
     * @param taxNumber the tax number of the Host
     */
    protected Host(int hostID, double taxNumber){
        super(hostID);
        this.taxNumber = taxNumber;
    }

    /**
     * This is the overloaded constructor
     * @param hostID the id of the Host
     * @param dateOfBirth the date of birth of the Host
     * @param firstName the first name of the Host
     * @param lastName the last name of the Host
     * @param registrationDate the registration date of the Host
     * @param taxNumber the tax number of the Host
     */
    protected Host(int hostID, Date dateOfBirth, String firstName, String lastName, Date registrationDate, double taxNumber){
        super(hostID, dateOfBirth, firstName, lastName, registrationDate);
        this.taxNumber = taxNumber;
    }

    public double getTaxNumber() {
        return taxNumber;
    }

    public void setTaxNumber(double taxNumber) {
        this.taxNumber = taxNumber;
    }

    /**
     * This method returns the Host description
     * by overriding the toString() method of the base class
     * @return the string representation of Host
     */
    public String toString(){
        return super.toString() + "\nHost has the tax Number: " + taxNumber;
    }

}
