package resources;

import entity.Driver;
import entity.User;
import lombok.extern.slf4j.Slf4j;
import request.InputDetails;
import services.BookRideService;

import javax.inject.Inject;
import javax.validation.Valid;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.ArrayList;

@Slf4j
@Path("v1/")
@Produces(MediaType.APPLICATION_JSON)
public class BookRideResource {

    private final BookRideService bookRideService;

    @Inject
    public BookRideResource(BookRideService bookRideService) {
        this.bookRideService = bookRideService;
    }

    /**
     * api to fetch drivers within given radius to users
     * @param inputDetails
     * @return Array<Drivers>
     */
    @POST
    @Path("/get-drivers")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getEligibleDrivers(@Valid InputDetails inputDetails) {
        User user = new User("Sam");
        user.setLocation(inputDetails.getLatitude(),inputDetails.getLongitude());

        ArrayList<Driver> drivers = new ArrayList<Driver>();

        Driver driverA = new Driver("DriverA");
        driverA.setLocation(2.0,3.0);
        drivers.add(driverA);

        Driver driverB = new Driver("DriverB");
        driverB.setLocation(1.0,2.0);
        drivers.add(driverB);

        Driver driverC = new Driver("DriverC");
        driverC.setLocation(6.0,9.0);
        drivers.add(driverC);

        ArrayList<Driver> driverArrayList =
                bookRideService.getDrivers(user, inputDetails.getRadius(), drivers);

        return Response.ok(driverArrayList).build();

    }
}
