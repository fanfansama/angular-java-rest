package com.fanfansama.web.config;

import com.fasterxml.jackson.jaxrs.json.JacksonJsonProvider;
import lombok.extern.slf4j.Slf4j;
import org.glassfish.jersey.filter.LoggingFilter;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.server.ServerProperties;

import java.util.logging.Logger;

@Slf4j
public class MyJerseyRestAppConfig extends ResourceConfig
{

    /**
    * Register JAX-RS application components.
    */    
    public MyJerseyRestAppConfig(){
        packages("com.fanfansama.web.rest.resources");
        property(ServerProperties.BV_SEND_ERROR_IN_RESPONSE, true);

        registerInstances(new LoggingFilter(Logger.getLogger(MyJerseyRestAppConfig.class.getName()), true));

        register(JacksonJsonProvider.class);

    }
}
