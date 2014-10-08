package com.seulgi.sample.service;

import com.seulgi.sample.service.config.SampleConfiguration;
import com.seulgi.sample.service.health.HelloHealthcheck;
import com.seulgi.sample.service.resources.HelloResource;
import com.seulgi.sample.service.resources.ProtectedResource;
import com.yammer.dropwizard.authenticator.LdapAuthenticator;
import com.yammer.dropwizard.authenticator.LdapConfiguration;
import com.yammer.dropwizard.authenticator.ResourceAuthenticator;
import io.dropwizard.Application;
import io.dropwizard.assets.AssetsBundle;
import io.dropwizard.auth.Authenticator;
import io.dropwizard.auth.basic.BasicAuthProvider;
import io.dropwizard.auth.basic.BasicCredentials;
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
        addLdapAuthenticator(configuration.getLdapConfiguration(), environment);
        environment.jersey().setUrlPattern(BACKEND_URL_PATTERN);
        environment.jersey().register(new HelloResource());
        environment.jersey().register(new ProtectedResource());
        environment.healthChecks().register("HelloHealthCheck", new HelloHealthcheck());
    }

    private void addLdapAuthenticator(final LdapConfiguration ldapConfiguration, final Environment environment) {
        Authenticator<BasicCredentials, BasicCredentials> ldapAuthenticator = new ResourceAuthenticator(new LdapAuthenticator(ldapConfiguration));
        environment.jersey().register(new BasicAuthProvider<>(ldapAuthenticator, "LDAP authentication"));
    }

}
