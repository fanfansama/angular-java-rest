package com.fanfansama.web.config;


import org.glassfish.jersey.jackson.JacksonFeature;
import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.web.filter.RequestContextFilter;


public class MyJerseyRestAppConfig extends ResourceConfig
{
 
    /**
    * Register JAX-RS application components.
    */    
    public MyJerseyRestAppConfig(){
        register(RequestContextFilter.class);
        packages("com.fanfansama.web.*");
        register(JacksonFeature.class);
   ///   //  registerInstances(new LoggingFilter(Logger.getLogger(MyJerseyRestAppConfig.class.getName()), true));

    }
}