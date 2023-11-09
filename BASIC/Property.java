package BASIC;

/**
 * Represents a class that stores information about a Property
 * that is owned by a Host
 * @author Noor Ul Zain
 * @version 1.0
 * @see Host
 */
class Property {
    private int propertyId;
    private int noBedRooms;
    private int noRooms;
    private String city;
    private float pricePerDay;
    private Host host;


    public Property() {

    }
    public Property(int propertyId, int noBedRooms, int noRooms, String city, float pricePerDay) {
        this.propertyId = propertyId;
        this.noBedRooms = noBedRooms;
        this.noRooms = noRooms;
        this.city = city;
        this.pricePerDay = pricePerDay;
        this.host = new Host();
    }

    public Property(int propertyId, int noBedRooms, int noRooms, String city, float pricePerDay, Host host) {
        this.propertyId = propertyId;
        this.noBedRooms = noBedRooms;
        this.noRooms = noRooms;
        this.city = city;
        this.pricePerDay = pricePerDay;
        this.host = host;
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

    public float getPricePerDay() {
        return pricePerDay;
    }

    public void setPricePerDay(float pricePerDay) {
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

