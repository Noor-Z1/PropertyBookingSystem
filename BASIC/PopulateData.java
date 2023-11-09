package BASIC;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;


/**
 * @author Noor Ul Zain
 * @version 1.0
 */

class PopulateData {

        void populate(){


            Property p1 = new Property(1, 3, 3, "Barcelona", 200);
            Property p2 = new Property(2, 2, 2, "Madrid", 150);
            Property p3 = new Property(3, 4, 4, "Valencia", 300);

            try {
                p1.setHost( new Host(22, "Marcus", "Weiser", new SimpleDateFormat("dd/mm/yyyy").parse("3/2/2023")));
            } catch (ParseException e) {
                throw new RuntimeException(e);
            }
            p2.setHost( new Host(33, "John", "Karis", new Date()));
            p3.setHost( new Host(44, "Carolina", "Silva", new Date()));

            Booking b1 = new Booking(new Date(), new Date(), p1);
            Booking b2 = new Booking(new Date(), new Date(), p2);
            Booking b3 = new Booking(new Date(), new Date(), p3);


            // add users (custom)
            User u1 = new User(2243);
            User u2 = new User(3450);
            User u3 = new User(9239);


            u1.setFirstName("Leena");
            u1.setLastName("Smith");
            u1.setDateOfBirth(new Date("12/7/2001"));
            u1.addBooking(b1);
            u2.setFirstName("Amber");
            u2.setLastName("Jade");
            u2.setDateOfBirth(new Date("4/2/1997"));
            u2.addBooking(b2);
            u3.setFirstName("Sarah");
            u3.setLastName("Williams");
            u3.setDateOfBirth(new Date("30/1/1999"));
            u3.addBooking(b3);


            BASIC.users = new ArrayList<User>();
            BASIC.properties = new ArrayList<Property>();

            BASIC.users.add(u1);
            BASIC.users.add(u2);
            BASIC.users.add(u3);
            BASIC.properties.add(p1);
            BASIC.properties.add(p2);
            BASIC.properties.add(p3);


        }


}

