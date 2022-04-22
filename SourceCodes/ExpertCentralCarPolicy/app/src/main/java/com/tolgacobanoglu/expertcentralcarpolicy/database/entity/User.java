package com.tolgacobanoglu.expertcentralcarpolicy.database.entity;

public class User
{
    private String email;
    private String companyName;
    private String companyAddress;
    private String password;
    private String phone;
    private String status;

    public User(String email, String companyName, String companyAddress, String password, String phone)
    {
        this.email = email;
        this.companyName = companyName;
        this.companyAddress = companyAddress;
        this.password = password;
        this.phone = "+90";
        this.phone += phone;
        this.status = "expert";
    }

    public User(){}

    @Override
    public String toString() {
        return "User{" +
                "email='" + email + '\'' +
                ", companyName='" + companyName + '\'' +
                ", companyAddress='" + companyAddress + '\'' +
                ", password='" + password + '\'' +
                ", phone='" + phone + '\'' +
                ", status='" + status + '\'' +
                '}';
    }

    public String getStatus()
    {
        return status;
    }

    public void setStatus(String status)
    {
        this.status = status;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getCompanyAddress() {
        return companyAddress;
    }

    public void setCompanyAddress(String companyAddress) {
        this.companyAddress = companyAddress;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}