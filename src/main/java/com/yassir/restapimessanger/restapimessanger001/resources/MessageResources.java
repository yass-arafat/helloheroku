/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.yassir.restapimessanger.restapimessanger001.resources;

import com.yassir.restapimessanger.restapimessanger001.model.Message;
import com.yassir.restapimessanger.restapimessanger001.resources.beans.MessageFilterBean;
import com.yassir.restapimessanger.restapimessanger001.service.MessagesService;
import java.util.List;
import javax.ws.rs.BeanParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import static javax.ws.rs.HttpMethod.PUT;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author yassir
 */
@Path("/messages")
@Consumes(MediaType.APPLICATION_XML)
@Produces(MediaType.APPLICATION_XML)
public class MessageResources {

    MessagesService messagesService = new MessagesService();
    
//For XML Data
    @GET
    public List<Message> getMessages(@BeanParam MessageFilterBean filterBean){
        if (filterBean.getYear() != null) {
            if (filterBean.getYear() > 0) {
                return messagesService.getAllMessagesForYear(filterBean.getYear());
            }
        }
        if (filterBean.getStart() != null && filterBean.getSize() != null) {
            if (filterBean.getStart() > 0 && filterBean.getSize() > 0) {
                return messagesService.getAllMessagesPaginated(filterBean.getStart(), filterBean.getSize());
            }
        }
        
          return messagesService.getAllMessages();
    }
    
    @GET
    @Path("/{messageId}")
    public Message getMessage(@PathParam("messageId") long messageId){
        return messagesService.getMessage(messageId);
    }
    
    
    @POST
    public Message addMessage(Message message){
        return messagesService.addMessage(message);
    } 
    
    @PUT
    @Path("/{messageId}")
    public Message updateMessage(@PathParam("messageId") long id, Message message){
        message.setId(id);
        return messagesService.updateMessage(message);
    }
    
    @DELETE
    @Path("/{messageId}")
    public void deleteMessage(@PathParam("messageId") long id){
        messagesService.removeMessage(id);
    }
    
    
    @Path("/{messageId}/comments")
    public CommentsResource getCommentsResource(){
        return new CommentsResource();
    }
    

////For JSON Data
//    @GET
//    @Produces(MediaType.APPLICATION_JSON)
//    public List<Message> getMessages(){
////        return "Hello World";
//          return messagesService.getAllMessages();
//    }
//    
//    @GET
//    @Path("/{messageId}")
//    @Produces(MediaType.APPLICATION_JSON)
//    public Message getMessage(@PathParam("messageId") long messageId){
//        return messagesService.getMessage(messageId);
//    }
}
