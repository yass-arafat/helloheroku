/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.yassir.restapimessanger.restapimessanger001.service;

import com.yassir.restapimessanger.restapimessanger001.database.DatabaseClass;
import com.yassir.restapimessanger.restapimessanger001.model.Profile;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 *
 * @author yassir
 */
public class ProfileServices {
    private  Map<String, Profile> profiles = DatabaseClass.getProfiles();

    public ProfileServices() {
        profiles.put("Yassir", new Profile(1L, "Yassir Arafat Roni", "Yassir", "Arafat"));
    }
    
    public List<Profile> getAllProfiles(){
        return new ArrayList<Profile>(profiles.values());
    }
    
    public Profile getProfile(String profileName){
        return profiles.get(profileName);
    }
    
    public Profile addProfile(Profile profile){
        profile.setId(profiles.size() + 1);
        return  profiles.put(profile.getProfileName(), profile);
    }
    
    public Profile updateProfile(Profile profile){
        if(profile.getProfileName().isEmpty())
            return null;
        return profiles.put(profile.getProfileName(), profile);
    }
    
    public Profile removeProfile(String profileName){
        return profiles.remove(profileName);
    }
}
