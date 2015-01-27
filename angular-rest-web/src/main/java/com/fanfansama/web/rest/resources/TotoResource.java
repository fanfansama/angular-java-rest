package com.fanfansama.web.rest.resources;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

/**
 * Created by fanfan on 26/01/2015.
 */
@Path("/toto")
public class TotoResource {
    
    @GET
    public String hello(){
        return "hello";
    }
    
}
