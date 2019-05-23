import com.sun.org.apache.xpath.internal.operations.Bool;

import java.util.ArrayList;

public class BookRide {

    static Boolean isNearLocation(Driver driver, User user, Double radius) {
        Double distanceFromUser = Math.sqrt(Math.pow((user.location.latitude - driver.location.latitude),2)
                + Math.pow((user.location.longitude - driver.location.longitude),2));

        return (distanceFromUser <= radius);
    }

    static ArrayList<Driver> getDrivers(User user, Double radius, ArrayList<Driver> drivers) {

        ArrayList<Driver> diversNearBy = new ArrayList<Driver>();
        for(Driver driver : drivers ) {
            if(isNearLocation(driver, user, radius)) {
                diversNearBy.add(driver);
                System.out.println(String.format("DriverId:%s DriverName:%s",
                        driver.driverId, driver.driverName));
            }
        }

        return diversNearBy;

    }

    public static void main(String[] args) {

        User user = new User("Sam");
        user.setLocation(0,0);

        ArrayList<Driver> drivers = new ArrayList<Driver>();

        Driver driverA = new Driver("DriverA");
        driverA.setLocation(2,3);
        drivers.add(driverA);

        Driver driverB = new Driver("DriverB");
        driverB.setLocation(1,2);
        drivers.add(driverB);

        Driver driverC = new Driver("DriverC");
        driverC.setLocation(6,9);
        drivers.add(driverC);

        getDrivers(user, 4.0, drivers);

    }
}
