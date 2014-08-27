package com.seulgi.sample.service;

import com.seulgi.sample.service.config.SampleConfiguration;
import com.seulgi.sample.service.health.HelloHealthcheck;
import com.seulgi.sample.service.resources.HelloResource;
import io.dropwizard.Application;
import io.dropwizard.assets.AssetsBundle;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;

public class SampleService extends Application<SampleConfiguration> {

    private static final String FRONTEND_URL_PREFIX = "/";
    private static final String FRONTEND_REPO = "/assets";
    private static final String INDEX_FILE = "index.html";

    private static final String BACKEND_URL_PATTERN = "/api/*";


    public static void main(String[] args) throws Exception {
        new SampleService().run(args);
    }

    @Override
    public void initialize(Bootstrap<SampleConfiguration> bootstrap) {
        bootstrap.addBundle(new AssetsBundle(FRONTEND_REPO, FRONTEND_URL_PREFIX, INDEX_FILE));
    }

    @Override
    public void run(SampleConfiguration configuration, Environment environment) throws Exception {
        environment.jersey().setUrlPattern(BACKEND_URL_PATTERN);
        environment.jersey().register(new HelloResource());
        environment.healthChecks().register("HelloHealthCheck", new HelloHealthcheck());
    }
    
}
