/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;

/**
 *
 * @author YJ
 */
public class Maintenance implements Comparable<Maintenance> {

    private Facility facility;
    private static int next = 1000;
    private String maintenanceID;
    private String maintenanceType;
    private String maintenanceDesc;
    private double maintenanceCost;
    private double costPerDay;
    private Date requestDate;
    private Date startDate;
    private Date endDate;
    private Date requiredDate; // This determines the priority

    public Maintenance() {
        this.maintenanceID = String.valueOf(next++);
    }

    public Maintenance(String maintenanceType, String maintenanceDesc, Date requiredDate, Date requestDate) {
        //this.maintenanceID = "M" + String.valueOf(next++);
        this.maintenanceType = maintenanceType;
        this.maintenanceDesc = maintenanceDesc;
        this.requestDate = requestDate;
        this.requiredDate = requiredDate;
    }

    public String getMaintenanceID() {
        return maintenanceID;
    }

    public void setMaintenanceID(String maintenanceID) {
        this.maintenanceID = maintenanceID;
    }

    public Facility getFacility() {
        return facility;
    }

    public void setFacility(Facility facility) {
        this.facility = facility;
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

    public double getCostPerDay() {
        return costPerDay;
    }

    public void setCostPerDay(double costPerDay) {
        this.costPerDay = costPerDay;
    }

    public Date getRequestDate() {
        return requestDate;
    }

    public void setRequestDate(Date requestDate) {
        this.requestDate = requestDate;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
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
        return String.format("%-17s %-20s %-30s %-20s %-25s", facility.getFacilityID(), maintenanceType, maintenanceDesc, formatter.format(requiredDate), requestDate);
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
        return Objects.equals(this.requiredDate, other.requiredDate);
    }

    @Override
    public int compareTo(Maintenance o) {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-mm-dd");
        return formatter.format(this.requiredDate).compareTo(formatter.format(o.requiredDate));
    }

    //Entity class methods
    public int calcDuration() { //end date - start date
        return (int) (endDate.getTime() - startDate.getTime() / (1000 * 60 * 60 * 24));
    }

    public double calcCost() { // duration x payment per day
        return calcDuration() * costPerDay;
    }

    public double calcWaitingTime() {
        return (int) (startDate.getTime() - requestDate.getTime() / (1000 * 60 * 60 * 24));
    }
}
