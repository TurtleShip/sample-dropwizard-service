package com.seulgi.sample.service.resources;

import io.dropwizard.auth.Auth;
import io.dropwizard.auth.basic.BasicCredentials;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/secure")
public class ProtectedResource {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getUser(@Auth BasicCredentials basicCredentials) {
        return "Hi, " + basicCredentials.getUsername();
    }
}
