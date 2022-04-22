package com.tolgacobanoglu.admincentralcarpolicy.regex;

import com.tolgacobanoglu.admincentralcarpolicy.model.LicensePlate;

public class LicensePlateInputs
{
    public LicensePlateInputs(){licensePlate = null;}

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

    public boolean checkNameWithoutLicensePlate(String name)
    {
        return name.matches("[A-Z]+");
    }

    public boolean checkSurnameWithoutLicensePlate(String name)
    {
        return name.matches("[A-Z]+");
    }

    private final LicensePlate licensePlate;

    public LicensePlateInputs(LicensePlate licensePlate)
    {
        this.licensePlate = licensePlate;
    }

    public boolean checkName()
    {
        String name = licensePlate.getOwnerName();
        return name.matches("[A-Z]+");
    }

    public boolean checkSurname()
    {
        String surname = licensePlate.getOwnerSurname();
        return surname.matches("[A-Z]+");
    }

    public boolean checkCityCode()
    {
        String cityCode = licensePlate.getCityCode();
        return cityCode.matches("[1-7][0-9]") || cityCode.matches(  "[8][0-1]") || cityCode.matches(  "[0][1-9]");
    }

    public boolean checkLetterGroup()
    {
        String letterGroup = licensePlate.getLetterGroup();
        return letterGroup.matches("[A-Z&&[^WXQİŞÜĞ]]{1,3}");
    }

    public boolean checkDigitGroup()
    {
        String digitGroup = licensePlate.getDigitGroup();
        return digitGroup.matches("[0-9]{2,4}");
    }

    public boolean checkChassisNumber()
    {
        String chassisNumber = licensePlate.getChassisNumber();
        return chassisNumber.matches("[A-Z | 0-9]{17}");
    }

    public boolean checkModelYear()
    {
        String year = String.valueOf(licensePlate.getModelYear());
        return year.matches("19[0-9]{2}") || year.matches("20[0-2][0-9]");
    }

}