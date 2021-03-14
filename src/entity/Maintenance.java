/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Objects;

/**
 *
 * @author YJ
 */
public class Maintenance implements Comparable<Maintenance>, Serializable {

    private Facility facility; // need a facility class constructor with facilityID and facilityID getter method
    
    private String facilityID; // temporary hardcode
    private static int next = 1000;
    private String maintenanceID;
    private String maintenanceType;
    private String maintenanceDesc;
    private double maintenanceCost;
    private Calendar startDate;
    private Calendar endDate;
    private Date requiredDate; // This determines the priority

    public Maintenance() {
        this.maintenanceID = String.valueOf(next++);
    }

    public Maintenance(String facilityID, String maintenanceType, String maintenanceDesc, Date requiredDate) {
        this.maintenanceID = String.valueOf(next++);
        this.facilityID = facilityID;
        this.maintenanceType = maintenanceType;
        this.maintenanceDesc = maintenanceDesc;
        this.maintenanceCost = maintenanceCost;
        this.requiredDate = requiredDate;
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

    public Date getRequiredDate() {
        return requiredDate;
    }

    public void setRequiredDate(Date requiredDate) {
        this.requiredDate = requiredDate;
    }

    @Override
    public String toString() {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-mm-dd");
        return String.format("%-15s %-20s %-25s %-20s", facilityID, maintenanceType, maintenanceDesc, formatter.format(requiredDate));
    }

    @Override
    public int hashCode() { // Ignored
        int hash = 5;
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
        final Maintenance other = (Maintenance) obj;
        if (!Objects.equals(this.requiredDate, other.requiredDate)) {
            return false;
        }
        return true;
    }

    @Override
    public int compareTo(Maintenance o) {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-mm-dd");
        return formatter.format(this.requiredDate).compareTo(formatter.format(o.requiredDate));
    }

    //Entity class methods
    public void updateSchedule() { // edit the details of the schedule or set the end date in the list
        
    }
    
    public void calcDuration() { //end date - start date

    }

    public void calcCost() { // duration x payment per day

    }
    
    public boolean updateStatus() { // update status of facility
        return true;
    }
   
    
    
}
