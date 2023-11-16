package BASIC;

import java.util.Date;


/** Represents a class that stores information about a Host
 *  who owns a Property in the system
 * @author Noor Ul Zain
 * @version 1.0
 * @see Property
 */
class Host {

    private int hostId;
    private String firsName;
    private String lastName;
    private Date registrationDate;

    private double taxNumnber;

    public Host() {

    }
    public Host(int hostID){

    }
    public Host(int hostId, String firsName, String lastName, Date registrationDate){
        this.hostId = hostId;
        this.firsName = firsName;
        this.lastName = lastName;
        this.registrationDate = registrationDate;
    }

    public int getHostID() {
        return hostId;
    }

    public void setHostID(int hostId) {
        this.hostId = hostId;
    }

    public String getFirsName() {
        return firsName;
    }

    public void setFirsName(String firsName) {
        this.firsName = firsName;
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
     * This method returns the Host description
     * by overriding the toString() method of the object class
     * @return the string representation of Host
     */
    public String toString(){
        return "Host: " +
                "hostId is " + hostId +
                ", firsName is " + firsName +
                ", lastName is " + lastName +
                ", registrationDate is " + registrationDate.toString() +
                '}';
    }

}
