/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.yassir.restapimessanger.restapimessanger001.model;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author yassir
 */
public class Comment {
    private long id;
    private String comment;
    private String author;
    private Date created_on;

    public Comment() {
    }
    
    public Comment(long id, String comment, String author){
        this.id = id;
        this.comment = comment;
        this.author = author;
        this.created_on = new Date();
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Date getCreated_on() {
        return created_on;
    }

    public void setCreated_on(Date created_on) {
        this.created_on = created_on;
    }
}
