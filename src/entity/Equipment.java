package entity;

import java.io.Serializable;
import java.util.Objects;

/**
 * @author 
 * Chan Mei Hui 19WMR11908
 */

public class Equipment implements Serializable{
    private String equipmentID;
    private String equipmentBrand;
    private Boolean equipmentStatus;
    private double equipmentPrice;
    private String equipmentLocation;
    private String equipmentType;

    public Equipment() {
    }

    public Equipment(String equipmentID, String equipmentBrand, Boolean equipmentStatus, double equipmentPrice, String equipmentLocation, String equipmentType) {
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

    public double getEquipmentPrice() {
        return equipmentPrice;
    }

    public void setEquipmentPrice(double equipmentPrice) {
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
        return String.format("%-15s %-20s %-20b %-20.2f %-20s %-20s",equipmentID , equipmentBrand , equipmentStatus , equipmentPrice , equipmentLocation , equipmentType);
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 71 * hash + Objects.hashCode(this.equipmentID);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Equipment other = (Equipment) obj;
        if (!Objects.equals(this.equipmentID, other.equipmentID)) {
            return false;
        }
        return true;
    }
    
    
    
}
