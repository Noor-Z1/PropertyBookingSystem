package BASIC.Project2;


/**
 * Represents a class that stores information about a Full Property
 * that is owned by a Host
 * @author Noor Ul Zain
 * @version 1.0
 * @see Property
 * @see Host
 */
public class FullProperty extends Property {
    private double propertySize;

    /**
     * This is the default constructor
     */
    public FullProperty() {
        super();
    }

    /**
     * This is the overloaded constructor
     * @param id This is the property id
     * @param size This is the property size
     */
    public FullProperty(int id, double size) {
        super(id);
        this.propertySize = size;
    }

    /**
     * This is the overloaded constructor
     * @param id This is the property id
     * @param beds This is the number of beds
     * @param rooms This is the number of rooms
     * @param city This is the city
     * @param pricePerDay This is the price per day
     * @param size This is the property size
     */
    public FullProperty(int id, int beds, int rooms, String city, double pricePerDay ,double size) {
        super(id, beds, rooms, city, pricePerDay);
        this.propertySize = size;
    }


    public double getPropertySize() {
        return propertySize;
    }

    public void setPropertySize(double propertySize) {
        this.propertySize = propertySize;
    }



    /**
     * This is the implementation of the calculatePricePerDay() method
     * which is an abstract method in the base class
     * @return the price per day of the Full Property
     */
    @Override
    public double calculatePricePerDay() {
        return this.getPricePerDay() + this.calculateTax();
    }

    /**
     * This is a helper function to calculate the tax
     * for a certain full property object
     * @return the tax
     */

    private double calculateTax() {
        if (this.getPropertySize() <= 200) {
            return this.getPricePerDay() * 0.01;
        } else if (this.getPropertySize() > 200 && this.getPropertySize() <= 300) {
            return this.getPricePerDay() * 0.03;
        } else {
            return this.getPricePerDay() * 0.04;
        }
    }

    /**
     * This method returns the Full Property description
     * by overriding the toString() method of the base class
     * @return the string representation of Full Property
     */
    public String toString() {
        return super.toString() + "\nProperty Size: " + this.getPropertySize();
    }

}
