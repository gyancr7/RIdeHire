import java.util.UUID;

public class Driver {

    String driverId;
    String driverName;
    Location location;

    Driver(String driverName) {
        this.driverId = UUID.randomUUID().toString();
        this.driverName = driverName;
    }

    void setLocation(int latitude, int longitude) {
        Location location = new Location(latitude,longitude);
        this.location = location;
    }

    Location getLocation(){
        return this.location;
    }
}
