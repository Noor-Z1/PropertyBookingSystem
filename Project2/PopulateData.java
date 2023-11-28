package BASIC.Project2;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;


/**
 * This class is used to populate the data for testing purposes.
 * Custom data can be added in this class.
 * @author Noor Ul Zain
 * @version 1.0
 * @see Property
 * @see Host
 * @see Booking
 * @see Customer
 */

class PopulateData {

     /**
     * This function is used to populate the data for testing purposes.
     * @throws ParseException: exception thrown when parsing date
     */
        static void populate() throws ParseException {


            Property p1 = new FullProperty(1, 2, 2, "Barcelona", 100, 200);
            Property p2 = new FullProperty(2, 3, 3, "London", 300, 500);
            Property p3 = new SharedProperty(3, 2, 4, "Paris", 400);


            Host h1 = new Host(11,new SimpleDateFormat("dd/MM/yyyy").parse("01/2/2001") ,"Marcus", "Weiser", new SimpleDateFormat("dd/MM/yyyy").parse("3/2/2023"), 22314 );
            Host h2 = new Host(22,new SimpleDateFormat("dd/MM/yyyy").parse("02/4/1997"),"John", "Karis", new SimpleDateFormat("dd/MM/yyyy").parse("14/05/2022"), 34521);
            Host h3 = new Host(33,new SimpleDateFormat("dd/MM/yyyy").parse("25/8/1999"),"Carolina", "Silva", new SimpleDateFormat("dd/MM/yyyy").parse("1/05/2021"), 54321);

            p1.setHost(h1);
            p2.setHost(h2);
            p3.setHost(h3);

            Booking b1 = new Booking(new SimpleDateFormat("dd/MM/yyyy").parse("5/4/2023"), new SimpleDateFormat("dd/MM/yyyy").parse("6/5/2023"), true, p1);
            Booking b2 = new Booking(new SimpleDateFormat("dd/MM/yyyy").parse("7/6/2023"), new SimpleDateFormat("dd/MM/yyyy").parse("7/7/2023"), true, p2);
            Booking b3 = new Booking(new SimpleDateFormat("dd/MM/yyyy").parse("3/2/2023"), new SimpleDateFormat("dd/MM/yyyy").parse("4/2/2023"), true,p3);


            // add users (custom)
            Customer u1 = new Gold(1, "CreditCard", 1);
            Customer u2 = new Gold(2, "Bitcoin", 2);
            Customer u3 = new Gold(3, "PayPal", 3);
            Customer u4 = new Standard(4, "DebitCard");
            Customer u5 = new Standard(5, "PayPal");

            u1.setFirstName("Leena");
            u1.setLastName("Smith");
            u1.setDateOfBirth(new SimpleDateFormat("dd/MM/yyyy").parse("4/2/1997"));
            u1.setRegistrationDate(new SimpleDateFormat("dd/MM/yyyy").parse("3/2/2021"));
            u1.addBooking(b1);

            u2.setFirstName("Ally");
            u2.setLastName("Song");
            u2.setDateOfBirth(new SimpleDateFormat("dd/MM/yyyy").parse("28/7/1992"));
            u2.setRegistrationDate(new SimpleDateFormat("dd/MM/yyyy").parse("14/09/2022"));
            u2.addBooking(b2);


            u3.setFirstName("Sarah");
            u3.setLastName("Williams");
            u3.setDateOfBirth(new SimpleDateFormat("dd/MM/yyyy").parse("6/4/1999"));
            u3.setRegistrationDate(new SimpleDateFormat("dd/MM/yyyy").parse("1/05/2021"));
            u3.addBooking(b3);

            u4.setFirstName("Amber");
            u4.setLastName("Jade");
            u4.setDateOfBirth(new SimpleDateFormat("dd/MM/yyyy").parse("5/3/1998"));
            u4.setRegistrationDate(new SimpleDateFormat("dd/MM/yyyy").parse("14/05/2021"));


            u5.setFirstName("Ferry");
            u5.setLastName("Williams");
            u5.setDateOfBirth(new SimpleDateFormat("dd/MM/yyyy").parse("6/4/1989"));
            u5.setRegistrationDate(new SimpleDateFormat("dd/MM/yyyy").parse("1/05/2012"));

            BASIC.users = new ArrayList<User>();
            BASIC.properties = new ArrayList<Property>();

            BASIC.users.add(u1);
            BASIC.users.add(u2);
            BASIC.users.add(u3);
            BASIC.users.add(u4);
            BASIC.users.add(u5);
            BASIC.users.add(h1);
            BASIC.users.add(h2);
            BASIC.users.add(h3);
            BASIC.properties.add(p1);
            BASIC.properties.add(p2);
            BASIC.properties.add(p3);


        }


}

