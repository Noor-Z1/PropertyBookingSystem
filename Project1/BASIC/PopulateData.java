package Project1.BASIC;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;



/**
 * @author Noor Ul Zain
 * @version 1.0
 */

class PopulateData {

        static void populate() throws ParseException {


            Property p1 = new Property(1, 3, 3, "Barcelona", 200);
            Property p2 = new Property(2, 2, 2, "Madrid", 150);
            Property p3 = new Property(3, 4, 4, "Valencia", 300);


            p1.setHost( new Host(22, "Marcus", "Weiser", new SimpleDateFormat("dd/MM/yyyy").parse("3/2/2023")));
            p2.setHost( new Host(33, "John", "Karis", new SimpleDateFormat("dd/MM/yyyy").parse("14/05/2022")));
            p3.setHost( new Host(44, "Carolina", "Silva", new SimpleDateFormat("dd/MM/yyyy").parse("1/05/2021")));


            Booking b1 = new Booking(new SimpleDateFormat("dd/MM/yyyy").parse("5/4/2023"), new SimpleDateFormat("dd/MM/yyyy").parse("6/5/2023"), p1);
            Booking b2 = new Booking(new SimpleDateFormat("dd/MM/yyyy").parse("7/6/2023"), new SimpleDateFormat("dd/MM/yyyy").parse("7/7/2023"), p2);
            Booking b3 = new Booking(new SimpleDateFormat("dd/MM/yyyy").parse("3/2/2023"), new SimpleDateFormat("dd/MM/yyyy").parse("4/2/2023"), p3);


            // add users (custom)
            User u1 = new User(2243);
            User u2 = new User(3450);
            User u3 = new User(9239);


            u1.setFirstName("Leena");
            u1.setLastName("Smith");
            u1.setDateOfBirth(new SimpleDateFormat("dd/MM/yyyy").parse("4/2/1997"));
            u1.addBooking(b1);
            u2.setFirstName("Amber");
            u2.setLastName("Jade");
            u2.setDateOfBirth(new SimpleDateFormat("dd/MM/yyyy").parse("5/3/1998"));
            u2.addBooking(b2);
            u3.setFirstName("Sarah");
            u3.setLastName("Williams");
            u3.setDateOfBirth(new SimpleDateFormat("dd/MM/yyyy").parse("6/4/1999"));
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

