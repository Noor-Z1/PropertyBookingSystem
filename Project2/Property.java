package BASIC.Project2;

import java.util.Date;
import java.util.HashMap;


/**
 * Represents a class that stores information about a Property
 * that is owned by a Host
 * @author Noor Ul Zain
 * @version 2.0
 * @see Host
 */
abstract class Property implements Comparable<Property>, PropertyPrice{
    private int propertyId;
    private int noBedRooms;
    private int noRooms;
    private String city;
    private double pricePerDay;
    private Host host;
    private HashMap<Date, String> Inspection;


    /**
     * This is the default constructor
     */
    protected Property() {
        this.Inspection = new HashMap<>();
    }
    /**
     * This is the overloaded constructor
     * @param id This is the property id
     */
    protected Property(int id) {
        this.propertyId = id;
        this.Inspection = new HashMap<>();
    }

    /**
     * This is the overloaded constructor
     * @param id This is the property id
     * @param noBedRooms This is the number of bed rooms
     * @param noRooms This is the number of rooms
     * @param city This is the city
     * @param pricePerDay This is the price per day
     */
    protected Property(int id, int noBedRooms, int noRooms, String city, double pricePerDay) {
        this.propertyId = id;
        this.noBedRooms = noBedRooms;
        this.noRooms = noRooms;
        this.city = city;
        this.pricePerDay = pricePerDay;
        this.Inspection = new HashMap<>();
    }


    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public int getNoBedRooms() {
        return noBedRooms;
    }

    public void setNoBedRooms(int noBedRooms) {
        this.noBedRooms = noBedRooms;
    }

    public int getNoRooms() {
        return noRooms;
    }

    public void setNoRooms(int noRooms) {
        this.noRooms = noRooms;
    }

    public double getPricePerDay() {
        return pricePerDay;
    }

    public void setPricePerDay(double pricePerDay) {
        this.pricePerDay = pricePerDay;
    }

    public int getPropertyId() {
        return propertyId;
    }

    public void setPropertyId(int propertyId) {
        this.propertyId = propertyId;
    }

    public Host getHost() {
        return host;
    }

    public void setHost(Host host) {
        this.host = host;
    }

    public HashMap<Date, String> getInspection() {
        return Inspection;
    }
    public void setInspection(HashMap<Date, String> Inspection) {
        this.Inspection = Inspection;
    }

    public void addInspection(Date date, String inspection) {
        Inspection.put(date, inspection);
    }

    /**
     * This is the abstract method used to calculate the price per day
     * It is implemented in the subclasses
     * @return the price per day
     */
    public abstract double calculatePricePerDay();

    /**
     *  This is the implemented method of the
     *  comparable interface
     *  It compares the price of two properties
     * @param o The Property object to be compared
     * @return 1 if greater, -1 if less, 0 if equal
     */
    public int compareTo(Property o) {
            if (this.calculatePricePerDay() > o.calculatePricePerDay()) {
                return 1;
            } else if (this.calculatePricePerDay() < o.calculatePricePerDay()) {
                return -1;
            } else {
                return 0;
            }
    }

    /**
     * This method returns the Property description
     * by overriding the toString() method of the object class
     * @return the string representation of Property
     */
    public String toString() {
        return "Property: propertyId is " + propertyId + ", noBedRooms are " +  noBedRooms + ", noRooms are " + noRooms + "," +
                " city is " + city + ", pricePerDay is " + pricePerDay +"\n"+ host.toString() + ".";
    }


}

