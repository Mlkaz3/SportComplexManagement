package entity;

public class Equipment {
    private String equipmentID;
    private String equipmentBrand;
    private Boolean equipmentStatus;
    private String equipmentPrice;
    private String equipmentLocation;
    private String equipmentType;

    public Equipment() {
    }

    public Equipment(String equipmentID, String equipmentBrand, Boolean equipmentStatus, String equipmentPrice, String equipmentLocation, String equipmentType) {
        this.equipmentID = equipmentID;
        this.equipmentBrand = equipmentBrand;
        this.equipmentStatus = equipmentStatus;
        this.equipmentPrice = equipmentPrice;
        this.equipmentLocation = equipmentLocation;
        this.equipmentType = equipmentType;
    }

    public String getEquipmentID() {
        return equipmentID;
    }

    public void setEquipmentID(String equipmentID) {
        this.equipmentID = equipmentID;
    }

    public String getEquipmentBrand() {
        return equipmentBrand;
    }

    public void setEquipmentBrand(String equipmentBrand) {
        this.equipmentBrand = equipmentBrand;
    }

    public Boolean getEquipmentStatus() {
        return equipmentStatus;
    }

    public void setEquipmentStatus(Boolean equipmentStatus) {
        this.equipmentStatus = equipmentStatus;
    }

    public String getEquipmentPrice() {
        return equipmentPrice;
    }

    public void setEquipmentPrice(String equipmentPrice) {
        this.equipmentPrice = equipmentPrice;
    }

    public String getEquipmentLocation() {
        return equipmentLocation;
    }

    public void setEquipmentLocation(String equipmentLocation) {
        this.equipmentLocation = equipmentLocation;
    }

    public String getEquipmentType() {
        return equipmentType;
    }

    public void setEquipmentType(String equipmentType) {
        this.equipmentType = equipmentType;
    }

    @Override
    public String toString() {
        return String.format("%-15s %-20s %-20b %-20s %-20s %-20s",equipmentID , equipmentBrand , equipmentStatus , equipmentPrice , equipmentLocation , equipmentType);
    }
    
    
}
