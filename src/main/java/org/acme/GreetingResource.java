package org.acme;

import org.jboss.logging.Logger;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.HeaderParam;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.Context;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Request;
import jakarta.ws.rs.core.UriInfo;

@Path("/test")
public class GreetingResource {

    @Context
    UriInfo uri;

    @Context
    Request request;
    
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String returnHostAndPort(@HeaderParam("X-Forwarded-Host") final String xForwardedHost) {
        Logger logger = Logger.getLogger(GreetingResource.class);
        logger.info("UriInfo:" + uri.getAbsolutePath());
        logger.info("X-Forwarded-Host:" + xForwardedHost);
        return uri.getAbsolutePath().getHost() + ":" + uri.getAbsolutePath().getPort();
    }
}
