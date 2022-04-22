package com.tolgacobanoglu.admincentralcarpolicy.model;

import com.google.firebase.Timestamp;

public class Transaction
{
    private Timestamp time;
    private  String transactionContent = "";
    private  String transactionTitle = "";

    public Transaction(String transactionTitle,String transactionContent)
    {
        this.transactionContent = "Admin " + transactionContent;
        this.transactionTitle = transactionTitle;
        this.time = Timestamp.now();
    }

    public Transaction(Timestamp time, String transactionContent, String transactionTitle) {
        this.time = time;
        this.transactionContent = transactionContent;
        this.transactionTitle = transactionTitle;
    }

    public Transaction()
    {

    }

    public Timestamp getTime() {
        return time;
    }

    public String getTransactionContent() {
        return transactionContent;
    }

    public String getTransactionTitle() {
        return transactionTitle;
    }
}