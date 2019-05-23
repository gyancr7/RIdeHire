import java.util.UUID;

public class User{

    String userId;
    String userName;
    Location location;

    User(String userName) {
        this.userId = UUID.randomUUID().toString();
        this.userName = userName;
    }

    void setLocation(int latitude, int longitude) {
        Location location = new Location(latitude,longitude);
        this.location = location;
    }

    Location getLocation(){
        return this.location;
    }

}
