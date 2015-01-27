package com.fanfansama.web.rest.resources;

import org.springframework.stereotype.Component;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

/**
 * Created by fanfan on 26/01/2015.
 */
@Component
@Path("/toto")
public class TotoResource {
    
    @GET
    public String hello(){
        return "hello";
    }
    
}
