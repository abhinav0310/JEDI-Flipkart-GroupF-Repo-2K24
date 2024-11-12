package com.flipfit.app;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.flipfit.rest.*;
import com.flipfit.rest.FlipFitGymCustomerRestController;
import io.dropwizard.Application;
import io.dropwizard.Configuration;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;

public class App extends Application<Configuration> {
    private static final Logger LOGGER = LoggerFactory.getLogger(App.class);

    @Override
    public void initialize(Bootstrap<Configuration> b) {
    }

    @Override
    public void run(Configuration c, Environment e) throws Exception {
        LOGGER.info("Registering REST resources");

        e.jersey().register(new FlipFitAdminRestController());
        e.jersey().register(new FlipFitGymCustomerRestController());
        e.jersey().register(new FlipFitGymOwnerRestController());
    }

    public static void main(String[] args) throws Exception {
        new App().run(args);
    }
}