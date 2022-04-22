package com.tolgacobanoglu.expertcentralcarpolicy.regex;

public class LicensePlateValidator
{
    public boolean checkCityCodeWithoutLicensePlate(String cityCode)
    {
        return cityCode.matches("[1-7][0-9]") || cityCode.matches(  "[8][0-1]") || cityCode.matches(  "[0][1-9]");
    }

    public boolean checkLetterGroupWithoutLicensePlate(String letterGroup)
    {
        return letterGroup.matches("[A-Z&&[^WXQİŞÜĞ]]{1,3}");
    }

    public boolean checkDigitGroupWithoutLicensePlate(String digitGroup)
    {
        return digitGroup.matches("[0-9]{2,4}");
    }

    public boolean checkKilometers(int kilometers)
    {
        return String.valueOf(kilometers).matches("[0-9]+");
    }

    public boolean checkDamageCost(Double damageCost)
    {
        return String.valueOf(damageCost).matches("[0-9.]+");
    }

}