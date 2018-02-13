/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.yassir.restapimessanger.restapimessanger001.resources;

import com.yassir.restapimessanger.restapimessanger001.database.DatabaseClass;
import com.yassir.restapimessanger.restapimessanger001.model.Message;
import com.yassir.restapimessanger.restapimessanger001.model.Profile;
import com.yassir.restapimessanger.restapimessanger001.service.MessagesService;
import com.yassir.restapimessanger.restapimessanger001.service.ProfileServices;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author yassir
 */
@Path("/profiles")
@Consumes(MediaType.APPLICATION_XML)
@Produces(MediaType.APPLICATION_XML)
public class ProfileResources {
     ProfileServices profilesService = new ProfileServices();
    
//For XML Data
    @GET
    public List<Profile> getAllProfiles(){
          return profilesService.getAllProfiles();
    }
    
    @GET
    @Path("/{profileName}")
    public Profile getProfile(@PathParam("profileName") String profileName){
        return profilesService.getProfile(profileName);
    }
    
    @POST
    public Profile addProfile(Profile profile){
        return profilesService.addProfile(profile);
    } 
    
    @PUT
    @Path("/{profileName}")
    public Profile updateProfile(@PathParam("profileName") String profileName, Profile profile){
        profile.setProfileName(profileName);
        return profilesService.updateProfile(profile);
    }
    
    @DELETE
    @Path("/{profileName}")
    public void deleteMessage(@PathParam("profileName") String profileName){
        profilesService.removeProfile(profileName);
    }

    
}
