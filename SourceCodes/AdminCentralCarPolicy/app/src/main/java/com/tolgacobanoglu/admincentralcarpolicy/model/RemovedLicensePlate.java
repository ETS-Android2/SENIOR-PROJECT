package com.tolgacobanoglu.admincentralcarpolicy.model;

import com.google.firebase.firestore.FieldValue;

public class RemovedLicensePlate
{
    private final String cityCode;
    private final String letterGroup;
    private final String digitGroup;
    private final FieldValue time;

    public RemovedLicensePlate(String cityCode, String letterGroup, String digitGroup) {
        this.cityCode = cityCode;
        this.letterGroup = letterGroup;
        this.digitGroup = digitGroup;
        this.time = FieldValue.serverTimestamp();
    }

    public String getCityCode() {
        return cityCode;
    }

    public String getLetterGroup() {
        return letterGroup;
    }

    public String getDigitGroup() {
        return digitGroup;
    }

    public FieldValue getTime() {
        return time;
    }
}
