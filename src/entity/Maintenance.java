package entity;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;

/**
 * @author Ong Yi Jie 19WMR11855
 */
public class Maintenance implements Comparable<Maintenance>, Serializable {

    private Facility facility;
    private static int next = 1000;
    private String maintenanceID;
    private String maintenanceType;
    private String maintenanceDesc;
    private double costPerDay;
    private Date requestDate;
    private Date startDate;
    private Date endDate;
    private Date requiredDate; // This determines the priority

    public Maintenance() {
        this.maintenanceID = "M" + String.valueOf(next++);
    }

    public Maintenance(String maintenanceID, String maintenanceType, String maintenanceDesc, Date requiredDate, Date requestDate) {
        this.maintenanceID = "M" + String.valueOf(next++);
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
        return String.format("%-17s %-17s %-20s %-30s %-20s %-25s", maintenanceID, facility.getFacilityID(), maintenanceType, maintenanceDesc, formatter.format(requiredDate), requestDate);
    }

    @Override
    public int hashCode() {
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
        long duration = endDate.getTime() - startDate.getTime();
        return (int) (duration / (1000 * 60 * 60 * 24));
    }

    public double calcCost() { // duration x payment per day (use seconds for demonstration)
        return calcDuration() * costPerDay;
    }

    public int calcWaitingTime() { //request date - start date
        long waitingTime = startDate.getTime() - requestDate.getTime();
        return (int) (waitingTime / (1000 * 60 * 60 * 24));
    }
}
