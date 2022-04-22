package com.tolgacobanoglu.makeaquerycentralcarpolicy.model;

import com.google.firebase.Timestamp;

public class Feedback
{
    private Timestamp time;
    private String feedback = "";
    private String email;

    public Feedback(String email,String feedback)
    {
        this.feedback = "Customer suggest : " + feedback;
        this.time = Timestamp.now();
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

    public String getFeedback() {
        return feedback;
    }

    public void setFeedback(String feedback) {
        this.feedback = feedback;
    }
}
