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
public class Maintenance implements Comparable<Maintenance> {

    private String facilityID;
    private String maintenanceID;
    private String maintenanceType;
    private String maintenanceDesc;
    private double maintenanceCost;
    private Calendar startDate;
    private Calendar endDate;
    private Calendar requiredDate; // This determines the priority
    private int priority;

    public Maintenance() {
    }
    
    public Maintenance(String facilityID, String maintenanceType, String maintenanceDesc, double maintenanceCost, int priority) {
        this.facilityID = facilityID;
        this.maintenanceType = maintenanceType;
        this.maintenanceDesc = maintenanceDesc;
        this.maintenanceCost = maintenanceCost;
        this.priority = priority;
    }

    public String getFacilityID() {
        return facilityID;
    }

    public void setFacilityID(String facilityID) {
        this.facilityID = facilityID;
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

    public Calendar getRequiredDate() {
        return requiredDate;
    }

    public void setRequiredDate(Calendar requiredDate) {
        this.requiredDate = requiredDate;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }
    
        
    @Override
    public String toString() {
        return String.format("%-15s %-20s %-25s %-20s %-20s", facilityID, maintenanceType, maintenanceDesc, maintenanceCost, priority);
    }

    @Override
    public int hashCode() { // Ignored
        int hash = 5;
        return hash;
    }

//    @Override
//    public boolean equals(Object obj) {
//        if (this == obj) {
//            return true;
//        }
//        if (obj == null) {
//            return false;
//        }
//        if (getClass() != obj.getClass()) {
//            return false;
//        }
//        final Maintenance other = (Maintenance) obj;
//        if (!Objects.equals(this.requiredDate, other.requiredDate)) {
//            return false;
//        }
//        return true;
//    }

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
        final Maintenance other = (Maintenance) obj;
        if (this.priority != other.priority) {
            return false;
        }
        return true;
    }

    @Override
    public int compareTo(Maintenance o) {
      return this.priority - o.priority;
    }
   
}
