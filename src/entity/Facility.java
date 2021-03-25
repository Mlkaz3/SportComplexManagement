/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

/**
 *
 * @author andre
 */
import java.util.Date;
import java.util.Objects;

public class Facility {

    private String facilityID;
    private String facilityName;
    private String facilityType;
    private String facilityAvailability;
    private boolean status;

    //set as string for now but the correct one shud be Date
    private String timeSlot;   // the array List the facility ahve throught the day
    //private Date checkingTimeSlot; // the timeslot requested by the user ,together with the facilityAvai can check if that time is available or not

    public Facility() {
    }

    public Facility(String facilityID) {
        this.facilityID = facilityID;
    }

    public Facility(String facilityID, String facilityName, String facilityType, boolean status) {
        this.facilityID = facilityID;
        this.facilityName = facilityName;
        this.facilityType = facilityType;
        this.status = status;
    }
    
    public Facility(String facilityID, String facilityName, String facilityType, String facilityAvailability, String timeSlot, Date checkingTimeSlot) {
        this.facilityID = facilityID;
        this.facilityName = facilityName;
        this.facilityType = facilityType;
        this.facilityAvailability = facilityAvailability;
        this.timeSlot = timeSlot;
        //this.checkingTimeSlot = checkingTimeSlot;
    }

    public String getFacilityID() {
        return facilityID;
    }

    public void setFacilityID(String facilityID) {
        this.facilityID = facilityID;
    }

    public String getFacilityName() {
        return facilityName;
    }

    public void setFacilityName(String facilityName) {
        this.facilityName = facilityName;
    }

    public String getFacilityType() {
        return facilityType;
    }

    public void setFacilityType(String facilityType) {
        this.facilityType = facilityType;
    }

    public String isFacilityAvailability() {
        return facilityAvailability;
    }

    public void setFacilityAvailability(String facilityAvailability) {
        this.facilityAvailability = facilityAvailability;
    }

    public String getTimeSlot() {
        return timeSlot;
    }

    public void setTimeSlot(String timeSlot) {
        this.timeSlot = timeSlot;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    /*public Date getCheckingTimeSlot() {
        return checkingTimeSlot;
    }

    public void setCheckingTimeSlot(Date checkingTimeSlot) {
        this.checkingTimeSlot = checkingTimeSlot;
    }*/
    @Override
    public int hashCode() {
        int hash = 3;
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
        final Facility other = (Facility) obj;
        if (!Objects.equals(this.facilityID, other.facilityID)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Facility ID:" + facilityID + "\n Facility Name: " + facilityName + "\n Facility Type:" + facilityType
                + "\n Facility Availability: " + facilityAvailability + "\n Time Slot:" + timeSlot;
    }

}
