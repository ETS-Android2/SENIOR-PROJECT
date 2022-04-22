package com.tolgacobanoglu.expertcentralcarpolicy.regex;

public class SignUpValidator
{
    public boolean checkMail(String email)
    {
        return email.contains("@") && email.contains(".com");
    }

    public boolean checkCompanyName(String companyName)
    {
        return companyName.matches("[A-Z]+");
    }

    public boolean checkPhone(String phone)
    {
        return phone.matches("5[0-9]{9}");
    }
}