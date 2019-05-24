package entity;

import java.util.UUID;

public class User{

    public String userId;
    public String userName;
    public Location location;

    public User(String userName) {
        this.userId = UUID.randomUUID().toString();
        this.userName = userName;
    }

    public void setLocation(int latitude, int longitude) {
        Location location = new Location(latitude,longitude);
        this.location = location;
    }

    Location getLocation(){
        return this.location;
    }

}
