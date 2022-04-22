package com.tolgacobanoglu.admincentralcarpolicy.model;

import com.google.firebase.Timestamp;

public class Feedback
{
    private Timestamp time;
    private String content = "";
    private String email;

    public Feedback(Timestamp time,String email,String content)
    {
        this.content = content;
        this.time = time;
        this.email = email;
    }

    public String getEmail()
    {
        return email;
    }

    public void setEmail(String email)
    {
        this.email = email;
    }

    public Timestamp getTime() {
        return time;
    }

    public void setTime(Timestamp time) {
        this.time = time;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}