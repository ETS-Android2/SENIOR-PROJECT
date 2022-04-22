package com.tolgacobanoglu.expertcentralcarpolicy.database.entity;


public class LicensePlate
{
    private String ownerName;
    private String ownerSurname;
    private String cityCode;
    private String letterGroup;
    private String digitGroup;
    private String chassisNumber;
    private Double damageCosts;
    private String damageDetails;
    private int kilometers;
    private String model;
    private String modelYear;
    private String operations;
    private String expertReport;
    private String allPlate;

    public LicensePlate(String ownerName, String ownerSurname, String cityCode, String letterGroup, String digitGroup, String chassisNumber, Double damageCosts, String damageDetails, int kilometers, String model, String modelYear, String operations, String expertReport) {
        this.ownerName = ownerName;
        this.ownerSurname = ownerSurname;
        this.cityCode = cityCode;
        this.letterGroup = letterGroup;
        this.digitGroup = digitGroup;
        this.chassisNumber = chassisNumber;
        this.damageCosts = damageCosts;
        this.damageDetails = damageDetails;
        this.kilometers = kilometers;
        this.model = model;
        this.modelYear = modelYear;
        this.operations = operations;
        this.expertReport = expertReport;
    }

    public LicensePlate()
    {

    }

    @Override
    public String toString() {
        return "LicensePlate{" +
                "ownerName='" + ownerName + '\'' +
                ", ownerSurname='" + ownerSurname + '\'' +
                ", cityCode='" + cityCode + '\'' +
                ", letterGroup='" + letterGroup + '\'' +
                ", digitGroup='" + digitGroup + '\'' +
                ", chassisNumber='" + chassisNumber + '\'' +
                ", damageCosts=" + damageCosts +
                ", damageDetails='" + damageDetails + '\'' +
                ", kilometers=" + kilometers +
                ", model='" + model + '\'' +
                ", modelYear=" + modelYear +
                ", operations='" + operations + '\'' +
                ", expertReport='" + expertReport + '\'' +
                '}';
    }

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    public String getOwnerSurname() {
        return ownerSurname;
    }

    public void setOwnerSurname(String ownerSurname) {
        this.ownerSurname = ownerSurname;
    }

    public String getOperations() {
        return operations;
    }

    public void setOperations(String operations) {
        this.operations = operations;
    }

    public String getExpertReport() {
        return expertReport;
    }

    public void setExpertReport(String expertReport) {
        this.expertReport = expertReport;
    }

    public String getCityCode() {
        return cityCode;
    }

    public void setCityCode(String cityCode) {
        this.cityCode = cityCode;
    }

    public String getLetterGroup() {
        return letterGroup;
    }

    public void setLetterGroup(String letterGroup) {
        this.letterGroup = letterGroup;
    }

    public String getDigitGroup() {
        return digitGroup;
    }

    public void setDigitGroup(String digitGroup) {
        this.digitGroup = digitGroup;
    }

    public String getChassisNumber() {
        return chassisNumber;
    }

    public void setChassisNumber(String chassisNumber) {
        this.chassisNumber = chassisNumber;
    }

    public Double getDamageCosts() {
        return damageCosts;
    }

    public void setDamageCosts(Double damageCosts) {
        this.damageCosts = damageCosts;
    }

    public String getDamageDetails() {
        return damageDetails;
    }

    public void setDamageDetails(String damageDetails) {
        this.damageDetails = damageDetails;
    }

    public int getKilometers() {
        return kilometers;
    }

    public void setKilometers(int kilometers) {
        this.kilometers = kilometers;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getModelYear() {
        return modelYear;
    }

    public void setModelYear(String modelYear) {
        this.modelYear = modelYear;
    }
}
