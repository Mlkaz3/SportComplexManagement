package entity;

public class Equipment {
    private String equipmentID;
    private String equipmentBrand;
    private Boolean equipmentStatus;
    private String equipmentPrice;
    private String equipmentLocation;
    private String equipmentCode;

    public Equipment() {
    }

    public Equipment(String equipmentID, String equipmentBrand, Boolean equipmentStatus, String equipmentPrice, String equipmentLocation, String equipmentCode) {
        this.equipmentID = equipmentID;
        this.equipmentBrand = equipmentBrand;
        this.equipmentStatus = equipmentStatus;
        this.equipmentPrice = equipmentPrice;
        this.equipmentLocation = equipmentLocation;
        this.equipmentCode = equipmentCode;
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

    public String getEquipmentCode() {
        return equipmentCode;
    }

    public void setEquipmentCode(String equipmentCode) {
        this.equipmentCode = equipmentCode;
    }

    @Override
    public String toString() {
        return String.format("%-10s %-30s %-6b %-6s %-10s %-10s",equipmentID , equipmentBrand , equipmentStatus , equipmentPrice , equipmentLocation , equipmentCode);
    }
    
    
}
