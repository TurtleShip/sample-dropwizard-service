package com.seulgi.sample.service.config;

import com.yammer.dropwizard.authenticator.LdapConfiguration;
import io.dropwizard.Configuration;

public class SampleConfiguration extends Configuration {

    LdapConfiguration ldapConfiguration;

    public LdapConfiguration getLdapConfiguration() {
        return ldapConfiguration;
    }
}
