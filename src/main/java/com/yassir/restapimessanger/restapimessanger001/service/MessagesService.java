/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.yassir.restapimessanger.restapimessanger001.service;

import com.yassir.restapimessanger.restapimessanger001.database.DatabaseClass;
import com.yassir.restapimessanger.restapimessanger001.model.Message;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Map;

/**
 *
 * @author yassir
 */
public class MessagesService {
    
    private Map<Long, Message> messages = DatabaseClass.getMessages();

    public MessagesService() {
        
        Message message1 = new Message(1L, "Hello World", "Yassir");
        Message message2 = new Message(2L, "Hello Jersy", "Arafat");
        
        messages.put(1L, message1);
        messages.put(2L, message2);
    }
    
    public List<Message> getAllMessages(){
//        Message message1 = new Message(1L, "Hello World", "Yassir");
//                
//        Message message2 = new Message(2L, "Hello Jersy", "Yassir");
//        
//        List<Message> listOfMessages = new ArrayList();
//        
//        listOfMessages.add(message1);
//        listOfMessages.add(message2);
//        
        return new ArrayList<Message>(messages.values());
    }
    
    public List<Message> getAllMessagesForYear(Integer year){
        List<Message> listOfMessagesOfYear = new ArrayList<>();
        Calendar calender = Calendar.getInstance();
        for(Message message : messages.values()){
            calender.setTime(message.getCreated_on());
            if(calender.get(Calendar.YEAR) == year){
                listOfMessagesOfYear.add(message);
            }
        }
        return listOfMessagesOfYear;
    }
    
    public List<Message> getAllMessagesPaginated(Integer start, Integer size){//How much item you wanted to show in the page
        List<Message> listOfMessagesPaginated = new ArrayList<>(messages.values());
        
        if(start <= 0 || (start+size) > listOfMessagesPaginated.size()) return new ArrayList<Message>();
        
        return listOfMessagesPaginated.subList(start, start+size);
    }
    
    public Message getMessage(long id){
        return messages.get(id);
    }
    
    public Message addMessage(Message message){
        message.setId(messages.size()+1);
        messages.put(message.getId(), message);
        return message;
    }
    
    public Message updateMessage(Message message){
        if(message.getId() <= 0){
            return null;
        }
        messages.put(message.getId(), message);
        return message;
    }
    
    public Message removeMessage(long id){
        return messages.remove(id);
    }
    
}
