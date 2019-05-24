package services;

import entity.Driver;
import entity.User;

import java.util.ArrayList;

public class BookRideService {

    /**
     * method to fetch drivers within given radius to users
     * @param user
     * @param radius
     * @param drivers
     * @return Array<Drivers>
     */
    public ArrayList<Driver> getDrivers(User user, Double radius, ArrayList<Driver> drivers) {

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

    private static Boolean isNearLocation(Driver driver, User user, Double radius) {
        Double distanceFromUser = Math.sqrt(Math.pow((user.location.latitude - driver.location.latitude),2)
                + Math.pow((user.location.longitude - driver.location.longitude),2));

        return (distanceFromUser <= radius);
    }
}
