package com.seulgi.sample.service.entities;

import java.util.Date;

public class Event {
    private Long id;
    private String title;
    private Date date;

    public Event() {}

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public Date getDate() {
        return date;
    }

    private void setId(Long id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
