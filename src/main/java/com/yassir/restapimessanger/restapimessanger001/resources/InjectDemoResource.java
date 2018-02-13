/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.yassir.restapimessanger.restapimessanger001.resources;

import javax.ws.rs.Consumes;
import javax.ws.rs.CookieParam;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.MatrixParam;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriInfo;

/**
 *
 * @author yassir
 */
@Path("/injectDemo")
@Consumes(MediaType.TEXT_PLAIN)
@Produces(MediaType.TEXT_PLAIN)
public class InjectDemoResource {
    
    @GET
    @Path("annotations")
    public String getParamUsingAnnotations(@MatrixParam("param")String matrixParam,
                                           @HeaderParam("customHeaderValue") String customHeaderValue,
                                           @CookieParam("language") String cookie){
        return "Matrix Param : "+ matrixParam + " customHeaderValue : "+ customHeaderValue + " Cookie : "+cookie;
    }
    
    @GET
    @Path("context")
    public String getParamsUsingContext(@Context UriInfo uriInfo, @Context HttpHeaders headers){
        String path = uriInfo.getAbsolutePath().toString();
        String cookies = headers.getCookies().toString();
        return "Path : " + path + " \n Cookies : " + cookies ;
    }
}
