package com.garanti.endpoints;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;

//localhost:9090/FirstRestfulService/rest/hello
@jakarta.ws.rs.Path(value = "rest")
public class HelloRest
{
    @GET
    @Path(value = "/hello")
    public String hello()
    {
        return "hello jakarta rest";
    }

}
