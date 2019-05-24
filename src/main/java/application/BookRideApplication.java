package application;

import com.google.inject.Guice;
import com.google.inject.Injector;
import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import resources.BookRideResource;

public class BookRideApplication extends Application<BookRideConfiguration> {

    @Override
    public void initialize(Bootstrap<BookRideConfiguration> bootstrap) {
        super.initialize(bootstrap);
    }

    @Override
    public void run(BookRideConfiguration bookRideConfiguration, Environment environment) throws Exception {
        // Register resources
        Injector injector = Guice.createInjector();
        environment.jersey().register(injector.getInstance(BookRideResource.class));
    }
}
