package entity;

import java.util.UUID;

public class Driver {

    public String driverId;
    public String driverName;
    public Location location;

    public Driver(String driverName) {
        this.driverId = UUID.randomUUID().toString();
        this.driverName = driverName;
    }

    public void setLocation(double latitude, double longitude) {
        Location location = new Location(latitude,longitude);
        this.location = location;
    }

    Location getLocation(){
        return this.location;
    }
}
