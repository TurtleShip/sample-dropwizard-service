package com.seulgi.sample.service;

import com.seulgi.sample.service.config.SampleConfiguration;
import com.seulgi.sample.service.health.HelloHealthcheck;
import com.seulgi.sample.service.resources.HelloResource;
import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;

public class SampleService extends Application<SampleConfiguration> {


    public static void main(String[] args) throws Exception {
        new SampleService().run(args);
    }

    @Override
    public void initialize(Bootstrap<SampleConfiguration> bootstrap) {

    }

    @Override
    public void run(SampleConfiguration configuration, Environment environment) throws Exception {
        environment.jersey().setUrlPattern("/api/*");
        environment.jersey().register(new HelloResource());
        environment.healthChecks().register("HelloHealthCheck", new HelloHealthcheck());
    }
}
