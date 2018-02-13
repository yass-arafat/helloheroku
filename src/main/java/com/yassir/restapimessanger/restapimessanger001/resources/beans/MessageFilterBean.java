/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.yassir.restapimessanger.restapimessanger001.resources.beans;

import javax.ws.rs.QueryParam;

/**
 *
 * @author yassir
 */
public class MessageFilterBean {

    private @QueryParam("year")
    Integer year;
    private @QueryParam("start")
    Integer start;
    private @QueryParam("size")
    Integer size;

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public Integer getStart() {
        return start;
    }

    public void setStart(Integer start) {
        this.start = start;
    }

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }
}
