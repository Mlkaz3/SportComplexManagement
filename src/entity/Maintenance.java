/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import java.util.Calendar;

/**
 *
 * @author YJ
 */
public class Maintenance implements Serializable {
    
    private String facilityID;
    private Equipment equipment;
    private String maintenanceID;
    private String maintenanceType;
    private String maintenanceDesc;
    private double maintenanceCost;
    private Calendar startDate;
    private Calendar endDate;

    public Maintenance() {
        
    }
    
    public Maintenance(String maintenanceType, String maintenanceDesc, double maintenanceCost) {
        this.maintenanceType = maintenanceType;
        this.maintenanceDesc = maintenanceDesc;
        this.maintenanceCost = maintenanceCost;
    }

    public String getFacility() {
        return facilityID;
    }

    public void setFacility(String facilityID) {
        this.facilityID = facilityID;
    }

    public Equipment getEquipment() {
        return equipment;
    }

    public void setEquipment(Equipment equipment) {
        this.equipment = equipment;
    }

    public String getMaintenanceID() {
        return maintenanceID;
    }

    public void setMaintenanceID(String maintenanceID) {
        this.maintenanceID = maintenanceID;
    }

    public String getMaintenanceType() {
        return maintenanceType;
    }

    public void setMaintenanceType(String maintenanceType) {
        this.maintenanceType = maintenanceType;
    }

    public String getMaintenanceDesc() {
        return maintenanceDesc;
    }

    public void setMaintenanceDesc(String maintenanceDesc) {
        this.maintenanceDesc = maintenanceDesc;
    }

    public double getMaintenanceCost() {
        return maintenanceCost;
    }

    public void setMaintenanceCost(double maintenanceCost) {
        this.maintenanceCost = maintenanceCost;
    }

    public Calendar getStartDate() {
        return startDate;
    }

    public void setStartDate(Calendar startDate) {
        this.startDate = startDate;
    }

    public Calendar getEndDate() {
        return endDate;
    }

    public void setEndDate(Calendar endDate) {
        this.endDate = endDate;
    }
    
    

    @Override
    public String toString() {
        return String.format("%-15s %-20s %-25s RM %-5.2f", facilityID, maintenanceType, maintenanceDesc, maintenanceCost);
    }
    
}
