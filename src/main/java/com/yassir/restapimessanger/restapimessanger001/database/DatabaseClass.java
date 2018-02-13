/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.yassir.restapimessanger.restapimessanger001.database;

import com.yassir.restapimessanger.restapimessanger001.model.Message;
import com.yassir.restapimessanger.restapimessanger001.model.Profile;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author yassir
 */
public class DatabaseClass {
    private static Map<Long, Message> messages = new HashMap<>();
    private static Map<String, Profile> profiles = new HashMap<>();

    public DatabaseClass() {
    }
    /**
     *
     * @return
     */
    public static Map<Long,Message> getMessages(){
        return messages;
    }
    
    /**
     *
     * @return
     */
    public static Map<String,Profile> getProfiles(){
        return profiles;
    }
    
}
