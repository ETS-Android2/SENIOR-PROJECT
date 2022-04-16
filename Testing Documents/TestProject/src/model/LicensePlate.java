package model;

public class LicensePlate
{
    private String cityCode;
    private String letterGroup;
    private String digitGroup;
    private String chassisNumber;
    private Double damageCosts;
    private String damageDetails;
    private int kilometers;
    private String model;
    private int modelYear;

    public LicensePlate(String cityCode, String letterGroup, String digitGroup, String chassisNumber, String damageDetails, int kilometers, String model, int modelYear) {
        this.cityCode = cityCode;
        this.letterGroup = letterGroup;
        this.digitGroup = digitGroup;
        this.chassisNumber = chassisNumber;
        this.damageCosts = 0d;
        this.damageDetails = damageDetails;
        this.kilometers = kilometers;
        this.model = model;
        this.modelYear = modelYear;

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

    public int getModelYear() {
        return modelYear;
    }

    public void setModelYear(int modelYear) {
        this.modelYear = modelYear;
    }
}