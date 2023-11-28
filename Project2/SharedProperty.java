package BASIC.Project2;


/**
 * Represents a class that stores information about a Shared Property
 * that is owned by a Host
 * @author Noor Ul Zain
 * @version 1.0
 * @see Property
 * @see Host
 */
class SharedProperty extends Property{

    /**
     * This is the default constructor
     */
    public SharedProperty() {
        super();
    }
    /**
     * This is the overloaded constructor
     * @param id this is the property id
     * @param noBedRooms this is the number of bedrooms
     * @param noRooms this is the number of rooms
     * @param city  this is the city
     * @param pricePerDay this is the price per day
     */
    public SharedProperty(int id, int noBedRooms, int noRooms, String city, double pricePerDay) {
        super(id, noBedRooms, noRooms, city, pricePerDay);
    }

    /**
     * This is the overloaded constructor
     * @param id this is the property id
     * @param noBedRooms this is the number of bedrooms
     * @param noRooms this is the number of rooms
     * @param city  this is the city
     * @param pricePerDay this is the price per day
     * @param host this is the host
     */
    public SharedProperty(int id, int noBedRooms, int noRooms, String city, double pricePerDay, Host host) {
        super(id, noBedRooms, noRooms, city, pricePerDay);
        super.setHost(host);
    }


    /**
     * This is the implementation of the calculatePricePerDay() method
     * which is an abstract method in the base class
     * @return the price per day of the Shared Property
     */
    @Override
    public double calculatePricePerDay() {
        double result = 0;
        try {
            result = this.getPricePerDay()/this.getNoBedRooms();
        }
        catch (ArithmeticException e) {
            System.out.println("This property cannot be shared as it has no bedrooms");
            result = 0;
        }
        return result;

    }

    /**
     * This method returns the Shared Property description
     * by overriding the toString() method of the base class
     * @return the string representation of Shared Property
     */
    @Override
    public String toString() {
        return  super.toString() + "Shared Property";
    }
}
