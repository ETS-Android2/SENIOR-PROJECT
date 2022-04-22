package com.tolgacobanoglu.carservicecentralcarpolicy.model;

import com.google.firebase.Timestamp;

public class Transaction
{
    private Timestamp time;
    private  String content = "";
    private  String title = "";

    public Transaction(String title, String content)
    {
        this.content = "Admin " + content;
        this.title = title;
        this.time = Timestamp.now();
    }

    public Transaction(Timestamp time, String content, String title) {
        this.time = time;
        this.content = content;
        this.title = title;
    }

        public Transaction(String content) //this for sign up has no instance for user
    {
        this.title = "Sign up";
        this.content = content;
        this.time = Timestamp.now();
    }

    public Transaction()
    {

    }

    public Timestamp getTime() {
        return time;
    }

    public String getContent() {
        return content;
    }

    public String getTitle() {
        return title;
    }

}
