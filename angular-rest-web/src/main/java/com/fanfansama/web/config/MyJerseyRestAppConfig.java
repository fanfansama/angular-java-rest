package com.fanfansama.web.config;

import com.fasterxml.jackson.jaxrs.json.JacksonJsonProvider;
import org.glassfish.jersey.filter.LoggingFilter;
import org.glassfish.jersey.server.ResourceConfig;

import javax.ws.rs.ApplicationPath;
import java.util.logging.Logger;

@ApplicationPath("api")
public class MyJerseyRestAppConfig extends ResourceConfig
{
 
    // http://blog.xebia.fr/2014/04/22/construire-une-api-rest-avec-jersey-et-spring-sans-web-xml-ni-applicationcontext-xml-ni-getterssetters/
    
    /**
    * Register JAX-RS application components.
    */    
    public MyJerseyRestAppConfig(){
        packages("com.fanfansama.web.rest.resources");
        registerInstances(new LoggingFilter(Logger.getLogger(MyJerseyRestAppConfig.class.getName()), true));

        register(JacksonJsonProvider.class);

    }
}
