package com.tolgacobanoglu.makeaquerycentralcarpolicy.model;

import com.google.firebase.Timestamp;

public class Transaction
{
    private Timestamp time;
    private  String content = "";
    private  String title = "";

    public Transaction(String transactionContent)
    {
        this.content =transactionContent;
        this.title = "FeedBack";
        this.time = Timestamp.now();
    }

    public Transaction(Timestamp time, String transactionContent, String transactionTitle) {
        this.time = time;
        this.content = transactionContent;
        this.title = transactionTitle;
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
